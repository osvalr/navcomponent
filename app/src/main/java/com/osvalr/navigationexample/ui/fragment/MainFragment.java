package com.osvalr.navigationexample.ui.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.osvalr.navigationexample.R;

public class MainFragment extends BaseFragment
        implements View.OnClickListener {
    private NavController navController;

    @Override
    int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        view.findViewById(R.id.send_money_button).setOnClickListener(this);
        view.findViewById(R.id.view_transaction_button).setOnClickListener(this);
        view.findViewById(R.id.view_balance_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == null) {
            return;
        }
        if (v.getId() == R.id.send_money_button) {
            navController.navigate(R.id.action_mainFragment_to_chooseRecipientFragment);
        } else if (v.getId() == R.id.view_balance_button) {
            navController.navigate(R.id.action_mainFragment_to_viewBalanceFragment);
        } else if (v.getId() == R.id.view_transaction_button) {
            navController.navigate(R.id.action_mainFragment_to_viewTransactionFragment);
        }
    }
}
