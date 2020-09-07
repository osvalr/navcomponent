package com.osvalr.navigationexample.ui.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.osvalr.navigationexample.R;
import com.osvalr.navigationexample.databinding.FragmentConfirmationBinding;

public class ConfirmationFragment extends BaseFragment {
    private FragmentConfirmationBinding binding;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String amount = getArguments().getString("amount");
        String recipient = getArguments().getString("recipient");
        binding.confirmationMessage.setText(getString(R.string.money_sent_to, amount, recipient));
    }
}
