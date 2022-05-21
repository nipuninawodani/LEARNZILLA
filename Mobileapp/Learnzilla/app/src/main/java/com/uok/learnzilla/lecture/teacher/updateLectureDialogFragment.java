package com.uok.learnzilla.lecture.teacher;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.uok.learnzilla.BackEndClasses.api.apimodels.apiLectures;
import com.uok.learnzilla.R;
import com.uok.learnzilla.databinding.FragmentUpdateLectureDialogBinding;


public class updateLectureDialogFragment extends DialogFragment {
    private FragmentUpdateLectureDialogBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       binding = FragmentUpdateLectureDialogBinding.inflate(inflater,container,false);
       return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        apiLectures lecture = updateLectureDialogFragmentArgs.fromBundle(getArguments()).getLecture();
        binding.TitleEdit.setText(lecture.getWeek());
        binding.DisEdit.setText(lecture.getDescription());
        binding.SaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(binding.TitleEdit.getText())||TextUtils.isEmpty(binding.DisEdit.getText())){
                    Toast.makeText(getContext(), "Empty Field", Toast.LENGTH_SHORT).show();
                }else{
                    //TODO
                }
            }
        });
    }
}