package com.osvalr.navigationexample.ui.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.osvalr.navigationexample.R;
import com.osvalr.navigationexample.databinding.FragmentChooseRecipientBinding;

public class ChooseRecipientFragment extends BaseFragment {
    FragmentChooseRecipientBinding binding;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.nextButton.setOnClickListener(v -> {
            if (TextUtils.isEmpty(binding.recipient.getEditText().getText())) {
                Toast.makeText(getActivity(), "Type the recipient", Toast.LENGTH_SHORT).show();
                return;
            }
            Bundle data = new Bundle();
            data.putString("recipient", binding.recipient.getEditText().getText().toString().trim());
            navController.navigate(
                    R.id.action_chooseRecipientFragment_to_specifyAmountFragment,
                    data);
        });
        binding.cancelButton.setOnClickListener(v -> getActivity().onBackPressed());
    }
}
