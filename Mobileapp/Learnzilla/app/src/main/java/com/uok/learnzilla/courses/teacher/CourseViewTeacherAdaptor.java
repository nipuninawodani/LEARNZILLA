package com.uok.learnzilla.courses.teacher;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.uok.learnzilla.BackEndClasses.api.apiServices.LectureApiServices;
import com.uok.learnzilla.BackEndClasses.api.apimodels.apiLectures;
import com.uok.learnzilla.BackEndClasses.api.config.retrofitConfiguration;
import com.uok.learnzilla.R;

import java.util.List;

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
                //TODO
            }
        });
        holder.Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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
