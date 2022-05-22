package com.uok.learnzilla.lecture.teacher;

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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.uok.learnzilla.AlartDialogs.ErrorDialogFragment;
import com.uok.learnzilla.AlartDialogs.SuccessDialogFragment;
import com.uok.learnzilla.BackEndClasses.api.apiServices.LectureResourcesApiServices;
import com.uok.learnzilla.BackEndClasses.api.apimodels.apiLectureResources;
import com.uok.learnzilla.BackEndClasses.api.config.retrofitConfiguration;
import com.uok.learnzilla.R;
import com.uok.learnzilla.lecture.student.StuLectureResourcesAdaptor;

import java.util.List;

public class TeacherLectureResourcesAdaptor extends RecyclerView.Adapter<TeacherLectureResourcesAdaptor.ViewHolder> {
    private List<apiLectureResources> mListResources;
    private ViewGroup Frag;
    LectureResourcesApiServices ResourceServices = retrofitConfiguration.getClient().create(LectureResourcesApiServices.class);


    public TeacherLectureResourcesAdaptor(List<apiLectureResources> mListResources) {
        this.mListResources = mListResources;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_resources_teacher, parent, false);
        Frag = parent;
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(mListResources.size() != 0){
            apiLectureResources ItemViewModel = mListResources.get(position);
            holder.LectureResources.setText(ItemViewModel.getResource());
            holder.Delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Call<Void> CallDelete = ResourceServices.DeleteLectureResource(ItemViewModel);
                    CallDelete.enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {
                            new SuccessDialogFragment("You successfully Enrolled")
                                    .show(FragmentManager.findFragment(Frag).getChildFragmentManager(),null);
                        }
                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {
                            new ErrorDialogFragment("Server Error : "+t.getMessage())
                                    .show(FragmentManager.findFragment(Frag).getChildFragmentManager(),null);

                        }
                    });

                }
            });
            holder.Update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    NavHostFragment.findNavController(FragmentManager.findFragment(view))
                            .navigate(R.id.action_LectureTeacherView_to_UpdateResourceDialog);
                    notifyDataSetChanged();
                }
            });
        }


    }

    @Override
    public int getItemCount() {
        return mListResources.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView LectureResources;
        private ImageButton Delete;
        private ImageButton Update;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            LectureResources = (TextView) itemView.findViewById(R.id.resName);
            Delete = (ImageButton) itemView.findViewById(R.id.DeleteButton);
            Update = (ImageButton)  itemView.findViewById(R.id.UpdateButton);
        }
    }
}
