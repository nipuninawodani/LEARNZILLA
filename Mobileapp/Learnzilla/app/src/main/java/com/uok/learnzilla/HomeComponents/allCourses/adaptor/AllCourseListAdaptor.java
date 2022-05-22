package com.uok.learnzilla.HomeComponents.allCourses.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavHostController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.uok.learnzilla.AlartDialogs.ErrorDialogFragment;
import com.uok.learnzilla.BackEndClasses.api.apiServices.TeacherApiServices;
import com.uok.learnzilla.BackEndClasses.api.apimodels.apiCourses;
import com.uok.learnzilla.BackEndClasses.api.apimodels.apiTeacher;
import com.uok.learnzilla.BackEndClasses.api.config.retrofitConfiguration;
import com.uok.learnzilla.HomeComponents.allCourses.fragment.allCourseListFragment;
import com.uok.learnzilla.HomeComponents.allCourses.fragment.allCourseListFragmentDirections;
import com.uok.learnzilla.R;
import com.uok.learnzilla.enrollment.EnrollViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllCourseListAdaptor extends RecyclerView.Adapter<AllCourseListAdaptor.ViewHolder> {
   private List<apiCourses>  mlistAllCourse;
    private Context context;
    private ViewGroup Frag;
   TeacherApiServices TeacherServices = retrofitConfiguration.getClient().create(TeacherApiServices.class);

    public  AllCourseListAdaptor(List<apiCourses>  list){

       mlistAllCourse = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_course, parent, false);
        Frag = parent;
        context = parent.getContext();
      return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        apiCourses ItemViewModel = mlistAllCourse.get(position);
        Call<apiTeacher> CallTeacher = TeacherServices.getTeacherById(ItemViewModel.getTeacher_id());
        CallTeacher.enqueue(new Callback<apiTeacher>() {
            @Override
            public void onResponse(Call<apiTeacher> call, Response<apiTeacher> response) {
                apiTeacher teacher = response.body();
                holder.courseTeacher.setText(teacher.getFirstName()+" "+teacher.getLastName());
            }

            @Override
            public void onFailure(Call<apiTeacher> call, Throwable t) {
                new ErrorDialogFragment("Server Error : "+t.getMessage())
                        .show(FragmentManager.findFragment(Frag).getChildFragmentManager(),null);
            }
        });
        holder.AcademicYear.setText(ItemViewModel.getAcademic_year());
        holder.Sem.setText("Sem:"+ItemViewModel.getSemester());
        holder.Level.setText("Level :"+ItemViewModel.getLevel());
        holder.courseTitle.setText(ItemViewModel.getTitle());
        holder.courseDescription.setText(ItemViewModel.getDescription());
        holder.enroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EnrollViewModel enrollViewModel = new EnrollViewModel(ItemViewModel,holder.courseTeacher.getText().toString());
                allCourseListFragmentDirections.ActionAllCoursesToEnrollDialog Action;
                Action = allCourseListFragmentDirections.actionAllCoursesToEnrollDialog(enrollViewModel);
                NavHostFragment.findNavController(FragmentManager.findFragment(Frag)).navigate(Action);
            }
        });
        
    }

    @Override
    public int getItemCount() {
        return mlistAllCourse.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView AcademicYear;
        private TextView Level;
        private TextView Sem;
        private TextView courseTitle;
        private TextView courseTeacher;
        private TextView courseDescription;
        private ImageButton enroll;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            AcademicYear = (TextView) itemView.findViewById(R.id.textView_AcademicYear);
            Level = (TextView) itemView.findViewById(R.id.textView_Level);
            Sem = (TextView) itemView.findViewById(R.id.textView_Semester);
            courseTitle = (TextView) itemView.findViewById(R.id.textView_CourseTitle);
            courseTeacher = (TextView) itemView.findViewById(R.id.textView_CourseTeacher);
            courseDescription = (TextView) itemView.findViewById(R.id.textView_CourseDescription);
            enroll = (ImageButton) itemView.findViewById(R.id.enroll_button);
        }

       
    }

}

