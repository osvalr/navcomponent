package com.osvalr.navigationexample.ui.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.osvalr.navigationexample.R;
import com.osvalr.navigationexample.databinding.FragmentMainBinding;

public class MainFragment extends BaseFragment {
    private NavController navController;
    private FragmentMainBinding binding;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        binding.sendMoneyButton.setOnClickListener(v ->
                navController.navigate(R.id.action_mainFragment_to_chooseRecipientFragment));
        binding.viewBalanceButton.setOnClickListener(v ->
                navController.navigate(R.id.action_mainFragment_to_viewBalanceFragment));
        binding.viewTransactionButton.setOnClickListener(v ->
                navController.navigate(R.id.action_mainFragment_to_viewTransactionFragment));
    }
}
