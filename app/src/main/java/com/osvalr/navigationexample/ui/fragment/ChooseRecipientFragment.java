package com.osvalr.navigationexample.ui.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.osvalr.navigationexample.R;
import com.osvalr.navigationexample.databinding.FragmentChooseRecipientBinding;

public class ChooseRecipientFragment extends BaseFragment {
    FragmentChooseRecipientBinding binding;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.nextButton.setOnClickListener(v ->
                navController.navigate(R.id.action_chooseRecipientFragment_to_specifyAmountFragment));
        binding.cancelButton.setOnClickListener(v -> getActivity().onBackPressed());
    }
}
