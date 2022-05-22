package com.uok.learnzilla.AlartDialogs;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uok.learnzilla.R;
import com.uok.learnzilla.databinding.FragmentSuccessDialogBinding;

public class SuccessDialogFragment extends DialogFragment {
    private FragmentSuccessDialogBinding binding;
    private String message;

    public SuccessDialogFragment(String message) {
        this.message = message;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      binding = FragmentSuccessDialogBinding.inflate(inflater,container,false);
      return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.Error.setText(message);
        binding.closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }
}