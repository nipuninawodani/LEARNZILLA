package com.uok.learnzilla.lecture.teacher;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.uok.learnzilla.BackEndClasses.api.apimodels.apiLectureResources;
import com.uok.learnzilla.R;
import com.uok.learnzilla.lecture.student.StuLectureResourcesAdaptor;

import java.util.List;

public class TeacherLectureResourcesAdaptor extends RecyclerView.Adapter<TeacherLectureResourcesAdaptor.ViewHolder> {
    private List<apiLectureResources> mListResources;

    public TeacherLectureResourcesAdaptor(List<apiLectureResources> mListResources) {
        this.mListResources = mListResources;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_resources_teacher, parent, false);
        return new TeacherLectureResourcesAdaptor.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        apiLectureResources ItemViewModel = mListResources.get(position);
        holder.LectureResources.setText(ItemViewModel.getResource());
        holder.Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO
            }
        });

    }

    @Override
    public int getItemCount() {
        return mListResources.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView LectureResources;
        private ImageButton Delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            LectureResources = (TextView) itemView.findViewById(R.id.resName);
            Delete = (ImageButton) itemView.findViewById(R.id.DeleteButton);
        }
    }
}
