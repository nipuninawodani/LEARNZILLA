package com.uok.learnzilla.courses.teacher;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


import com.uok.learnzilla.AlartDialogs.ErrorDialogFragment;
import com.uok.learnzilla.BackEndClasses.api.Session.SessionManager;
import com.uok.learnzilla.BackEndClasses.api.apiServices.StudentApiServices;
import com.uok.learnzilla.BackEndClasses.api.apimodels.apiEnrollment;
import com.uok.learnzilla.BackEndClasses.api.apimodels.apiStudent;
import com.uok.learnzilla.BackEndClasses.api.config.retrofitConfiguration;
import com.uok.learnzilla.R;

import java.util.List;

public class StudentsAndResultsAdaptor extends RecyclerView.Adapter<StudentsAndResultsAdaptor.ViewHolder> {
    private List<apiEnrollment> mlistEnrollment;
    private  apiStudent student;
    private ViewGroup Frag;
    StudentApiServices StudentServices = retrofitConfiguration.getClient().create(StudentApiServices.class);


    public StudentsAndResultsAdaptor(List<apiEnrollment> mlistEnrollment) {
        this.mlistEnrollment = mlistEnrollment;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_results_teacher, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        apiEnrollment ItemViewModel = mlistEnrollment.get(position);

        if(TextUtils.isEmpty(ItemViewModel.getOverall_grade())){
            holder.Grade.setText(" - ");
        }else {
            holder.Grade.setText(ItemViewModel.getOverall_grade());
        }
        SessionManager Manage = new SessionManager(Frag.getContext());
        Call<apiStudent> CallStudent = StudentServices.getStudentByID(ItemViewModel.getStudent_id(),Manage.fetchAuthToken());
        CallStudent.enqueue(new Callback<apiStudent>() {
            @Override
            public void onResponse(Call<apiStudent> call, Response<apiStudent> response) {
                student = response.body();
                holder.StudentName.setText(student.getFirstName()+" "+student.getLastName());
                holder.Email.setText(student.getEmail());
                holder.Edit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        StudentAndResultsFragmentDirections.ActionResultViewTeacherToUpdateGrade Action;
                        Action = StudentAndResultsFragmentDirections.actionResultViewTeacherToUpdateGrade(ItemViewModel,student.getFirstName()+" "+student.getLastName());
                        NavHostFragment.findNavController(FragmentManager.findFragment(view))
                                .navigate(Action);
                    }
                });
            }

            @Override
            public void onFailure(Call<apiStudent> call, Throwable t) {
                student = new apiStudent("ServerError","ServerError","ServerError","ServerError");
                holder.StudentName.setText("server Error");
                holder.StudentName.setText("server Error");
                new ErrorDialogFragment("Server Error : "+t.getMessage())
                        .show(FragmentManager.findFragment(Frag).getChildFragmentManager(),null);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mlistEnrollment.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView StudentName ;
        private TextView Email ;
        private TextView Grade ;
        private ImageButton Edit;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            StudentName = (TextView) itemView.findViewById(R.id.textView_StudentName);
            Email = (TextView) itemView.findViewById(R.id.textView_EmailStudent);
            Grade = (TextView) itemView.findViewById(R.id.textview_Results);
            Edit = (ImageButton)  itemView.findViewById(R.id.EditResultsButton);
        }

    }
}
