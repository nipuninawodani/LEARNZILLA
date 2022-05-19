package com.uok.learnzilla.HomeComponents.myCoursees.Student;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.uok.learnzilla.BackEndClasses.api.apiServices.CourseApiServices;
import com.uok.learnzilla.BackEndClasses.api.apiServices.TeacherApiServices;
import com.uok.learnzilla.BackEndClasses.api.apimodels.apiCourses;
import com.uok.learnzilla.BackEndClasses.api.apimodels.apiEnrollment;
import com.uok.learnzilla.BackEndClasses.api.apimodels.apiTeacher;
import com.uok.learnzilla.BackEndClasses.api.config.retrofitConfiguration;
import com.uok.learnzilla.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyCoursesStudentAdaptor extends RecyclerView.Adapter<MyCoursesStudentAdaptor.ViewHolder> {
    private List<apiEnrollment> mListAllEnrolledCourses;
    apiCourses ItemViewModel;
    TeacherApiServices TeacherServices = retrofitConfiguration.getClient().create(TeacherApiServices.class);
    CourseApiServices CourseServices = retrofitConfiguration.getClient().create(CourseApiServices.class);
    private Context context;
    private ViewGroup Frag;

    public MyCoursesStudentAdaptor(List<apiEnrollment> mListAllEnrolledCourses) {
        this.mListAllEnrolledCourses = mListAllEnrolledCourses;
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
       apiEnrollment enrollment = mListAllEnrolledCourses.get(position);
        Call<apiCourses> CallEnrolledCourse = CourseServices.getCourseByCourseCode(enrollment.getCourse_code(),enrollment.getAcademic_year());
        CallEnrolledCourse.enqueue(new Callback<apiCourses>() {
            @Override
            public void onResponse(Call<apiCourses> call, Response<apiCourses> response) {
              ItemViewModel = response.body();
                Call<apiTeacher> CallTeacher = TeacherServices.getTeacherById(ItemViewModel.getTeacher_id());
                CallTeacher.enqueue(new Callback<apiTeacher>() {
                    @Override
                    public void onResponse(Call<apiTeacher> call, Response<apiTeacher> response) {
                        apiTeacher teacher = response.body();
                        holder.courseTeacher.setText(teacher.getFirstName()+" "+teacher.getLastName());
                    }
                    @Override
                    public void onFailure(Call<apiTeacher> call, Throwable t) {
                        Toast.makeText(context, "Server Timeout", Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(context, "Nodata", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onFailure(Call<apiCourses> call, Throwable t) {
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return mListAllEnrolledCourses.size();
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
