package com.uok.learnzilla.HomeComponents.results;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.uok.learnzilla.R;

import java.util.List;

public class ResultsListAdaptor extends RecyclerView.Adapter<ResultsListAdaptor.ViewHolder> {
    private List<Results> mResults;

    public ResultsListAdaptor(List<Results> mResults) {
        this.mResults = mResults;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_results, parent, false);
        return new ResultsListAdaptor.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
      Results results =  mResults.get(position);
      holder.CourseName.setText(results.getCourse_name());
      holder.Grade.setText(results.getGrade());
      holder.Year.setText(results.getCourse_year());
    }

    @Override
    public int getItemCount() {
        return mResults.size();
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
