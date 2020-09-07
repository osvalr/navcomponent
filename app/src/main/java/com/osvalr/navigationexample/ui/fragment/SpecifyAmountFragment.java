package com.osvalr.navigationexample.ui.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.osvalr.navigationexample.R;
import com.osvalr.navigationexample.databinding.FragmentSpecifyAmountBinding;

public class SpecifyAmountFragment extends BaseFragment {
    private FragmentSpecifyAmountBinding binding;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String recipientName = getArguments().getString("recipient");
        binding.recipient.setText(getString(R.string.sending_money_to, recipientName));
        binding.sendButton.setOnClickListener(v -> {
            if (TextUtils.isEmpty(binding.amount.getEditText().getText())) {
                Toast.makeText(getActivity(), "Specify the amount to send", Toast.LENGTH_SHORT).show();
                return;
            }
            Bundle data = new Bundle();
            data.putString("recipient", recipientName);
            data.putString("amount", binding.amount.getEditText().getText().toString().trim());
            navController.navigate(R.id.action_specifyAmountFragment_to_confirmationFragment, data);
        });
        binding.cancelButton.setOnClickListener(v -> getActivity().onBackPressed());
    }

}
