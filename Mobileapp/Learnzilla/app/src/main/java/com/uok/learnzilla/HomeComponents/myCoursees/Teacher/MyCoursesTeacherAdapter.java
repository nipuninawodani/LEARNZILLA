package com.uok.learnzilla.HomeComponents.myCoursees.Teacher;

import static java.security.AccessController.getContext;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.uok.learnzilla.AlartDialogs.ErrorDialogFragment;
import com.uok.learnzilla.BackEndClasses.api.Session.SessionManager;
import com.uok.learnzilla.BackEndClasses.api.apiServices.TeacherApiServices;
import com.uok.learnzilla.BackEndClasses.api.apimodels.apiCourses;
import com.uok.learnzilla.BackEndClasses.api.apimodels.apiTeacher;
import com.uok.learnzilla.BackEndClasses.api.config.retrofitConfiguration;
import com.uok.learnzilla.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyCoursesTeacherAdapter extends RecyclerView.Adapter<MyCoursesTeacherAdapter.ViewHolder> {
    private List<apiCourses> mListAllCourse;
    private Context context;
    private ViewGroup Frag;
    TeacherApiServices TeacherServices = retrofitConfiguration.getClient().create(TeacherApiServices.class);

    public MyCoursesTeacherAdapter(List<apiCourses> mListAllCourse) {
        this.mListAllCourse = mListAllCourse;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_mycourse, parent, false);
        Frag = parent;
        context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        apiCourses ItemViewModel = mListAllCourse.get(position);
        if(ItemViewModel == null){
            new ErrorDialogFragment("No Courses Created")
                    .show(FragmentManager.findFragment(Frag).getChildFragmentManager(),null);
        }else {
            SessionManager Manage = new SessionManager(Frag.getContext());
            Call<apiTeacher> CallTeacher = TeacherServices.getTeacherById(ItemViewModel.getTeacher_id(),Manage.fetchAuthToken());
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
            holder.Go.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    FragmentMyCoursesTeacherDirections.ActionMyCoursesTeacherToCourseViewLecturesTeacher Action;
                    Action = FragmentMyCoursesTeacherDirections.actionMyCoursesTeacherToCourseViewLecturesTeacher(ItemViewModel);
                    NavHostFragment.findNavController(FragmentManager.findFragment(Frag)).navigate(Action);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return mListAllCourse.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView AcademicYear;
        private TextView Level;
        private TextView Sem;
        private TextView courseTitle;
        private TextView courseTeacher;
        private TextView courseDescription;
        private ImageButton Go;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            AcademicYear = (TextView) itemView.findViewById(R.id.textView_AcademicYear);
            Level = (TextView) itemView.findViewById(R.id.textView_Level);
            Sem = (TextView) itemView.findViewById(R.id.textView_Semester);
            courseTitle = (TextView) itemView.findViewById(R.id.textView_CourseTitle);
            courseTeacher = (TextView) itemView.findViewById(R.id.textView_CourseTeacher);
            courseDescription = (TextView) itemView.findViewById(R.id.textView_CourseDescription);
           Go = (ImageButton) itemView.findViewById(R.id.Gobutton);
        }


    }
}
