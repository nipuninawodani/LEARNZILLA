package com.uok.learnzilla.courses;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uok.learnzilla.R;
import com.uok.learnzilla.databinding.FragmentAddLectureDialogBinding;


public class AddLectureDialogFragment extends DialogFragment {
    private FragmentAddLectureDialogBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAddLectureDialogBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

}