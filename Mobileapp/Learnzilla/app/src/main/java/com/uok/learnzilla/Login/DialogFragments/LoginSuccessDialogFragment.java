package com.uok.learnzilla.Login.DialogFragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uok.learnzilla.Home.HomeActivity;
import com.uok.learnzilla.R;
import com.uok.learnzilla.databinding.FragmentLoginFailedDialogBinding;
import com.uok.learnzilla.databinding.FragmentLoginSuccessDialogBinding;

public class LoginSuccessDialogFragment extends DialogFragment {
    private FragmentLoginSuccessDialogBinding binding;

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
        binding = FragmentLoginSuccessDialogBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int Type = LoginSuccessDialogFragmentArgs.fromBundle(getArguments()).getType();
        binding.closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
                if (Type == 2) {
                    gotoLoginFragment();
                }else if (Type == 1){
                    goToHomeActivity();
                }
            }
        });
    }

    private void gotoLoginFragment() {
        NavHostFragment.findNavController(LoginSuccessDialogFragment.this)
                . navigate(R.id.action_RegisterSuccess_to_LoginFragment);
    }

    private void goToHomeActivity() {
        Intent intent = new Intent(getActivity(), HomeActivity.class);
        startActivity(intent);
    }
}