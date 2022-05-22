package com.uok.learnzilla.Announcement;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;


import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.uok.learnzilla.AlartDialogs.ErrorDialogFragment;
import com.uok.learnzilla.AlartDialogs.SuccessDialogFragment;
import com.uok.learnzilla.BackEndClasses.api.Session.SessionManager;
import com.uok.learnzilla.BackEndClasses.api.apiServices.AnnouncementApiServices;
import com.uok.learnzilla.BackEndClasses.api.apimodels.apiAnnouncement;
import com.uok.learnzilla.BackEndClasses.api.config.retrofitConfiguration;
import com.uok.learnzilla.R;
import com.uok.learnzilla.databinding.FragmentAnnouncementDialogBinding;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class AnnouncementFragmentDialog extends DialogFragment {
    private FragmentAnnouncementDialogBinding binding;
    AnnouncementApiServices AnnouncementServices = retrofitConfiguration.getClient().create(AnnouncementApiServices.class);

    @Override
    public void onStart() {
        super.onStart();
        if (getDialog() == null)
            return;
        int dialogWidth = 750;
        int dialogHeight =1500;

        getDialog().getWindow().setLayout(dialogWidth, dialogHeight);
        getDialog().getWindow().setBackgroundDrawableResource(R.drawable.dialog_round_bg);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       binding = FragmentAnnouncementDialogBinding.inflate(inflater,container,false);
       return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String CourseCode = AnnouncementFragmentDialogArgs.fromBundle(getArguments()).getCourseCode();
        binding.recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));

        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
        String formattedDate = df.format(c);
        SessionManager Manage = new SessionManager(getContext());
        Call<List<apiAnnouncement>>  CallAnnouncement = AnnouncementServices.getAnnouncementByCourseCode(CourseCode,Manage.fetchAuthToken());
        CallAnnouncement.enqueue(new Callback<List<apiAnnouncement>>() {
            @Override
            public void onResponse(Call<List<apiAnnouncement>> call, Response<List<apiAnnouncement>> response) {
                if(response.body().size() == 0){
                    new ErrorDialogFragment("No announcement at the movement")
                            .show(getChildFragmentManager(),null);
                }else {
                    List<apiAnnouncement> announcements = response.body();
                    AnnouncementAdaptor adaptor = new AnnouncementAdaptor(announcements);
                    binding.recyclerview.setAdapter(adaptor);
                }
            }

            @Override
            public void onFailure(Call<List<apiAnnouncement>> call, Throwable t) {
                new ErrorDialogFragment("Server Error :" + t.getMessage())
                        .show(getChildFragmentManager(),null);
            }
        });
        binding.SaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(binding.MessageEdit.getText())||TextUtils.isEmpty(binding.TitleEdit.getText()))
                {
                    new ErrorDialogFragment("Fill Empty TextField")
                            .show(getChildFragmentManager(),null);
                }else {
                    apiAnnouncement announcement = AddDataToAnnouncement();
                    Call<Void> CallAddAnnouncement = AnnouncementServices.addAnnouncement(announcement,Manage.fetchAuthToken());
                    CallAddAnnouncement.enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {
                            new SuccessDialogFragment("Announcement Added successfully")
                                    .show(getChildFragmentManager(),null);
                        }

                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {
                            new ErrorDialogFragment("Server Error :" + t.getMessage())
                                    .show(getChildFragmentManager(),null);
                        }
                    });
                }

            }
        });

    }

    private apiAnnouncement AddDataToAnnouncement() {
        String CourseCode = AnnouncementFragmentDialogArgs.fromBundle(getArguments()).getCourseCode();
        String Title = binding.TitleEdit.getText().toString();
        String Message = binding.MessageEdit.getText().toString();
        return  new apiAnnouncement(CourseCode,Title,Message);
    }
}