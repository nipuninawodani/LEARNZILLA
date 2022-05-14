package com.uok.learnzilla.HomeComponents.myCourses.adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.uok.learnzilla.HomeComponents.allCourses.adaptor.AllCourseListAdaptor;
import com.uok.learnzilla.HomeComponents.myCourses.model.Courses;
import com.uok.learnzilla.R;

import java.util.List;

public class MyCoursesListAdapter extends RecyclerView.Adapter<MyCoursesListAdapter.ViewHolder> {
    private List<Courses> mlistAllCourse;

    public MyCoursesListAdapter(List<Courses> mlistAllCourse) {
        this.mlistAllCourse = mlistAllCourse;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_course, parent, false);
        return new MyCoursesListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Courses ItemViewModel = mlistAllCourse.get(position);
        holder.ID.setText(ItemViewModel.getCourseId());
        holder.Name.setText(ItemViewModel.getCourseName());
        holder.teacher.setText(ItemViewModel.getTeacherName());
        holder.enroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "enroll", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mlistAllCourse.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView ID;
        private TextView Name;
        private ImageButton enroll;
        private TextView teacher;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ID = (TextView) itemView.findViewById(R.id.textView_ID);
            Name = (TextView) itemView.findViewById(R.id.textview_Name);
            enroll = (ImageButton) itemView.findViewById(R.id.enroll_button);
            teacher = (TextView) itemView.findViewById(R.id.textview_teacher);
        }

        public TextView getID() {
            return ID;
        }

        public TextView getName() {
            return Name;
        }

        public ImageButton getEnroll() {
            return enroll;
        }

        public TextView getTeacher() {
            return teacher;
        }
    }
}
