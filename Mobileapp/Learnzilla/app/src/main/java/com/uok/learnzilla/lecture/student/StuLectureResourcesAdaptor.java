package com.uok.learnzilla.lecture.student;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.uok.learnzilla.BackEndClasses.api.apimodels.apiLectureResources;
import com.uok.learnzilla.R;
import com.uok.learnzilla.courses.student.StudentCourseViewFragmentDirections;

import java.util.List;

public class StuLectureResourcesAdaptor extends RecyclerView.Adapter<StuLectureResourcesAdaptor.ViewHolder>{
    private List<apiLectureResources> mListResources;

    public StuLectureResourcesAdaptor(List<apiLectureResources> mListResources) {
        this.mListResources = mListResources;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_resources_student, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        apiLectureResources ItemViewModel = mListResources.get(position);
        holder.LectureResources.setText(ItemViewModel.getResource());
        holder.Go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StudentLectureViewFragmentDirections.ActionLectureViewStudentToWebView Action;
                Action = StudentLectureViewFragmentDirections.actionLectureViewStudentToWebView(ItemViewModel.getResource());
                NavHostFragment.findNavController(FragmentManager.findFragment(view))
                        .navigate(Action);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mListResources.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView LectureResources;
        private ImageButton Go;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            LectureResources = (TextView) itemView.findViewById(R.id.resName);
            Go = (ImageButton) itemView.findViewById(R.id.EditButton);
        }
    }
}
