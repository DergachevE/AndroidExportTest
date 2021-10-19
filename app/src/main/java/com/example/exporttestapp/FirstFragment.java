package com.example.exporttestapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.exporttestapp.databinding.FragmentFirstBinding;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.analytics.EventProperties;

import java.util.Date;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Custom event without properties
                Analytics.trackEvent("ExportTest_1");

                // Custom event with properties
                EventProperties properties = new EventProperties();
                properties.set("BoolValue", true);
                properties.set("DoubleValue", 14.56f);
                properties.set("DateTime", new Date());
                Analytics.trackEvent("ExportTest_2_with_props", properties);

                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}