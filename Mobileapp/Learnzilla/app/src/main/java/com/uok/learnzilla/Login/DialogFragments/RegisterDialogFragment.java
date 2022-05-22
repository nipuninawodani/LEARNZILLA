package com.uok.learnzilla.Login.DialogFragments;


import android.app.AlertDialog;

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
            int dialogWidth = 1000;
            int dialogHeight = 1000;

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

        RegisterDialogFragmentDirections.ActionRegister action = RegisterDialogFragmentDirections.actionRegister();

        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());

        binding.Student.setOnClickListener(view1 -> {
            builder.setTitle("Warning");
            builder.setMessage("Do you need to Create Account for Student ?")
                    .setCancelable(false)
                    .setPositiveButton("yes", (dialogInterface, i) -> NavHostFragment.findNavController(RegisterDialogFragment.this)
                            .navigate(action.setRegister(1)))
                    .setNegativeButton("No", (dialogInterface, i) -> dialogInterface.cancel());
            AlertDialog alert = builder.create();
            alert.show();
        });

        binding.teacher.setOnClickListener(view12 -> {
            builder.setTitle("Warning");
            builder.setMessage("Do you need to Create Account for Teacher ?")
                    .setCancelable(false)
                    .setPositiveButton("yes", (dialogInterface, i) -> NavHostFragment.findNavController(RegisterDialogFragment.this)
                            .navigate(action.setRegister(2)))
                    .setNegativeButton("No", (dialogInterface, i) -> dialogInterface.cancel());
            AlertDialog alert = builder.create();
            alert.show();
        });


        binding.closeButton.setOnClickListener(View1 ->
                dismiss());
    }

}