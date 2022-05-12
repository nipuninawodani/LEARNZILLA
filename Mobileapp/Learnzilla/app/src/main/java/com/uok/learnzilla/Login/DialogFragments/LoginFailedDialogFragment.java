package com.uok.learnzilla.Login.DialogFragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uok.learnzilla.Home.HomeActivity;
import com.uok.learnzilla.R;
import com.uok.learnzilla.databinding.FragmentLoginFailedDialogBinding;
import com.uok.learnzilla.databinding.FragmentRegisterDialogBinding;


public class LoginFailedDialogFragment extends DialogFragment {

    private FragmentLoginFailedDialogBinding binding;
    @Override
    public void onStart() {
        super.onStart();
        if (getDialog() == null)
            return;
        int dialogWidth = 1000;
        int dialogHeight = 500;

        getDialog().getWindow().setLayout(dialogWidth, dialogHeight);
        getDialog().getWindow().setBackgroundDrawableResource(R.drawable.dialog_round_bg);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      binding = FragmentLoginFailedDialogBinding.inflate(inflater,container,false);
      return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
                goToHomeActivity();
            }
        });
    }

    private void goToHomeActivity() {
        Intent intent = new Intent(getActivity(), HomeActivity.class);
        startActivity(intent);
    }
}