package com.uok.learnzilla.DialogFragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.navigation.fragment.NavHostFragment;

import com.uok.learnzilla.R;
import com.uok.learnzilla.databinding.FragmentRegisterDialogBinding;


public class RegisterDialogFragment extends DialogFragment {
    private FragmentRegisterDialogBinding binding;

    public RegisterDialogFragment() {
        // Required empty public constructor
    }

    @Override
    public void onStart() {
        super.onStart();
            if (getDialog() == null)
                return;
            int dialogWidth = 1000; // specify a value here
            int dialogHeight = 1000; // specify a value here

            getDialog().getWindow().setLayout(dialogWidth, dialogHeight);
            getDialog().getWindow().setBackgroundDrawableResource(R.drawable.dialog_round_bg);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRegisterDialogBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.Student.setOnClickListener(view1 ->
                NavHostFragment.findNavController(RegisterDialogFragment.this)
                        .navigate(R.id.action_RegisterDialog_to_RegisterFragment));
        binding.closeButton.setOnClickListener(View1 ->
                dismiss());
    }

}