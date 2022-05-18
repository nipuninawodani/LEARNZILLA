package com.uok.learnzilla.HomeComponents.allCourses.adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.uok.learnzilla.BackEndClasses.api.apimodels.apiCourses;
import com.uok.learnzilla.R;

import java.util.List;

public class AllCourseListAdaptor extends RecyclerView.Adapter<AllCourseListAdaptor.ViewHolder> {
   private List<apiCourses>  mlistAllCourse;

    public  AllCourseListAdaptor(List<apiCourses>  list){

       mlistAllCourse = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_course, parent, false);
      return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        apiCourses ItemViewModel = mlistAllCourse.get(position);
        holder.ID.setText(ItemViewModel.getCourse_code());
        holder.Name.setText(ItemViewModel.getDescription());
        holder.teacher.setText(ItemViewModel.getTeacher_id());
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
        private  TextView ID;
        private TextView Name;
        private ImageButton enroll;
        private TextView teacher;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ID = (TextView) itemView.findViewById(R.id.textView_lecture);
            Name = (TextView) itemView.findViewById(R.id.textview_lecture_Description);
            enroll = (ImageButton) itemView.findViewById(R.id.enroll_button);
            teacher = (TextView) itemView.findViewById(R.id.textview_week);

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

