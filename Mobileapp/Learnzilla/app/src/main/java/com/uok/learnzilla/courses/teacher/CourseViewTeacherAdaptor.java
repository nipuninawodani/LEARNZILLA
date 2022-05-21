package com.uok.learnzilla.courses.teacher;

import android.util.Log;
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

import com.uok.learnzilla.BackEndClasses.api.apiServices.LectureApiServices;
import com.uok.learnzilla.BackEndClasses.api.apimodels.apiLectures;
import com.uok.learnzilla.BackEndClasses.api.config.retrofitConfiguration;
import com.uok.learnzilla.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CourseViewTeacherAdaptor extends RecyclerView.Adapter<CourseViewTeacherAdaptor.ViewHolder> {
    private List<apiLectures> mListLectures;
    LectureApiServices LectureServices = retrofitConfiguration.getClient().create(LectureApiServices.class);

    public CourseViewTeacherAdaptor(List<apiLectures> mListLectures) {
        this.mListLectures = mListLectures;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_lecture_teacher, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        apiLectures ItemViewModel = mListLectures.get(position);
        Log.e("test",ItemViewModel.getCourse_code());
        holder.LectureDescription.setText(ItemViewModel.getDescription());
        holder.CourseCode.setText(ItemViewModel.getCourse_code());
        holder.Week.setText("Week :" + ItemViewModel.getWeek());
        holder.GoToLectureResources.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TeacherCourseViewFragmentDirections.ActionCourseViewLecturesTeacherToLectureTeacherView Action;
                Action = TeacherCourseViewFragmentDirections.actionCourseViewLecturesTeacherToLectureTeacherView(ItemViewModel);
                NavHostFragment.findNavController(FragmentManager.findFragment(view)).navigate(Action);
            }
        });
        holder.Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<Void> CallDeleteLecture = LectureServices.deleteLecture(ItemViewModel);
                CallDeleteLecture.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        Toast.makeText(view.getContext(), "Lecture deleted", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(view.getContext(), "Server Error", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return mListLectures.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView LectureDescription;
        private TextView CourseCode;
        private TextView Week;
        private ImageButton GoToLectureResources;
        private ImageButton Delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            LectureDescription = (TextView) itemView.findViewById(R.id.textview_lecture_Description);
            CourseCode = (TextView) itemView.findViewById(R.id.textview_LecCourseCodee);
            Week = (TextView) itemView.findViewById(R.id.textViewWeek);
            GoToLectureResources = (ImageButton) itemView.findViewById(R.id.Goto);
            Delete = (ImageButton) itemView.findViewById(R.id.DeleteData);

        }

    }
}
