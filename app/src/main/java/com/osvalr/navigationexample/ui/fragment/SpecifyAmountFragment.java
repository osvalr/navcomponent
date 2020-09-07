package com.osvalr.navigationexample.ui.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.osvalr.navigationexample.R;

public class SpecifyAmountFragment extends BaseFragment
        implements View.OnClickListener {
    @Override
    int getLayoutId() {
        return R.layout.fragment_specify_amount;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.send_button).setOnClickListener(this);
        view.findViewById(R.id.cancel_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == null) {
            return;
        }
        if (v.getId() == R.id.send_button) {
            navController.navigate(R.id.action_specifyAmountFragment_to_confirmationFragment);
        } else if (v.getId() == R.id.cancel_button) {
            getActivity().onBackPressed();
        }
    }
}
