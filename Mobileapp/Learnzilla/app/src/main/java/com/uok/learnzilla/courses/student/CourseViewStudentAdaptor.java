package com.uok.learnzilla.courses.student;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.uok.learnzilla.BackEndClasses.api.apimodels.apiLectures;
import com.uok.learnzilla.R;

import java.util.List;

public class CourseViewStudentAdaptor extends RecyclerView.Adapter<CourseViewStudentAdaptor.ViewHolder> {
    private List<apiLectures> mListLectures;

    public CourseViewStudentAdaptor(List<apiLectures> mListLectures) {
        this.mListLectures = mListLectures;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_lectures_student, parent, false);
        return new CourseViewStudentAdaptor.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        apiLectures ItemViewModel = mListLectures.get(position);
        holder.LectureDescription.setText(ItemViewModel.getDescription());
        holder.CourseCode.setText(ItemViewModel.getCourse_code());
        holder.Week.setText(ItemViewModel.getWeek());
        holder.GoToLectureResources.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO
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

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            LectureDescription = (TextView) itemView.findViewById(R.id.textview_lecture_Description);
            CourseCode = (TextView) itemView.findViewById(R.id.textview_LecCourseCodee);
            Week = (TextView) itemView.findViewById(R.id.textview_week);
            GoToLectureResources = (ImageButton) itemView.findViewById(R.id.Goto);

        }

    }
}
