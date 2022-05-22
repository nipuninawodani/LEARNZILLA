package com.uok.learnzilla.HomeComponents.results;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.uok.learnzilla.AlartDialogs.ErrorDialogFragment;
import com.uok.learnzilla.BackEndClasses.api.Session.SessionManager;
import com.uok.learnzilla.BackEndClasses.api.apiServices.CourseApiServices;
import com.uok.learnzilla.BackEndClasses.api.apimodels.apiCourses;
import com.uok.learnzilla.BackEndClasses.api.apimodels.apiEnrollment;
import com.uok.learnzilla.BackEndClasses.api.config.retrofitConfiguration;
import com.uok.learnzilla.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResultsListAdaptor extends RecyclerView.Adapter<ResultsListAdaptor.ViewHolder> {
   private List<apiEnrollment> enrollments;
   private ViewGroup Frag;
   CourseApiServices courseApiServices = retrofitConfiguration.getClient().create(CourseApiServices.class);

    public ResultsListAdaptor(List<apiEnrollment> enrollments) {
        this.enrollments = enrollments;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_results, parent, false);
        Frag = parent;
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
     apiEnrollment ItemViewModel  = enrollments.get(position);
      if(ItemViewModel.getOverall_grade() == null){
          holder.Grade.setText("-");
      }else {
          holder.Grade.setText(ItemViewModel.getOverall_grade());
      }
      holder.Year.setText(ItemViewModel.getAcademic_year());
        SessionManager Manage = new SessionManager(Frag.getContext());
      Call<apiCourses> CallData =  courseApiServices.getCourseByCourseCode(ItemViewModel.getCourse_code(),ItemViewModel.getAcademic_year(),Manage.fetchAuthToken());
      CallData.enqueue(new Callback<apiCourses>() {
          @Override
          public void onResponse(Call<apiCourses> call, Response<apiCourses> response) {
              apiCourses course = response.body();
              holder.CourseName.setText(course.getCourse_code()+" "+course.getTitle());
          }

          @Override
          public void onFailure(Call<apiCourses> call, Throwable t) {
              new ErrorDialogFragment("Server Error : "+t.getMessage())
                      .show(FragmentManager.findFragment(Frag).getChildFragmentManager(),null);
          }
      });

    }

    @Override
    public int getItemCount() {
        return enrollments.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView CourseName ;
        private TextView Year ;
        private TextView Grade ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            CourseName = (TextView) itemView.findViewById(R.id.textView_Coursename);
            Year = (TextView) itemView.findViewById(R.id.textView_academic);
            Grade = (TextView) itemView.findViewById(R.id.textview_Results);
        }

    }
}
