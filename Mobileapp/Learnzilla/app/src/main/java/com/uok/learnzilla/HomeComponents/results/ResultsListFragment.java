package com.uok.learnzilla.HomeComponents.results;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uok.learnzilla.R;
import com.uok.learnzilla.databinding.FragmentResultsListBinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ResultsListFragment extends Fragment {

    private FragmentResultsListBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       binding = FragmentResultsListBinding.inflate(inflater,container,false);
       return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        List<Results> results = new ArrayList<Results>();
        Collections.addAll(
                results,
                new Results("SENG 12536","2018/2019","A"),
                new Results("SENG 13436","2018/2019","B"),
                new Results("SENG 13536","2018/2019","D"),
                new Results("SENG 12256","2018/2019","E"),
                new Results("SENG 12056","2018/2019","A")
        );
        ResultsListAdaptor resultsListAdaptor = new ResultsListAdaptor(results);
        binding.recyclerview.setAdapter(resultsListAdaptor);
    }
}