package com.uok.learnzilla.Resource;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uok.learnzilla.R;
import com.uok.learnzilla.databinding.FragmentWebviewResourcesBinding;

public class webviewResources extends Fragment {
    private FragmentWebviewResourcesBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       binding = FragmentWebviewResourcesBinding.inflate(inflater,container,false);
       return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String Url = webviewResourcesArgs.fromBundle(getArguments()).getUrl();
        binding.webView.getSettings().setJavaScriptEnabled(true);
        binding.webView.loadUrl(Url);
    }
}