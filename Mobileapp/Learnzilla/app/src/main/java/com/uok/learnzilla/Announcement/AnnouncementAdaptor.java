package com.uok.learnzilla.Announcement;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.uok.learnzilla.BackEndClasses.api.apimodels.apiAnnouncement;
import com.uok.learnzilla.R;
import com.uok.learnzilla.courses.teacher.CourseViewTeacherAdaptor;

import java.util.List;

public class AnnouncementAdaptor extends RecyclerView.Adapter<AnnouncementAdaptor.ViewHolder> {
    private List<apiAnnouncement> mListAnnouncement;
    ViewGroup frag;

    public AnnouncementAdaptor(List<apiAnnouncement> mListAnnouncement) {
        this.mListAnnouncement = mListAnnouncement;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_announcement, parent, false);
        frag = parent;
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        apiAnnouncement ItemViewModel = mListAnnouncement.get(position);
        holder.Title.setText(ItemViewModel.getTitle());
        holder.Message.setText(ItemViewModel.getMessage());
        holder.Date.setVisibility(View.INVISIBLE);
    }

    @Override
    public int getItemCount() {
        return mListAnnouncement.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView Title ;
        TextView Message;
        TextView Date;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Title = itemView.findViewById(R.id.TitleAnnounce);
            Message = itemView.findViewById(R.id.messageAnnounce);
            Date = itemView.findViewById(R.id.Date);

        }

    }
}
