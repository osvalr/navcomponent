package com.osvalr.navigationexample.ui.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.osvalr.navigationexample.R;
import com.osvalr.navigationexample.databinding.FragmentSpecifyAmountBinding;

public class SpecifyAmountFragment extends BaseFragment {
    private FragmentSpecifyAmountBinding binding;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.sendButton.setOnClickListener(v ->
                navController.navigate(R.id.action_specifyAmountFragment_to_confirmationFragment));
        binding.cancelButton.setOnClickListener(v -> getActivity().onBackPressed());
    }

}
