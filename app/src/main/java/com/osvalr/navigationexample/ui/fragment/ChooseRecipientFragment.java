package com.osvalr.navigationexample.ui.fragment;

import android.view.View;

import com.osvalr.navigationexample.R;

public class ChooseRecipientFragment extends BaseFragment
        implements View.OnClickListener {
    @Override
    int getLayoutId() {
        return R.layout.fragment_choose_recipient;
    }

    @Override
    public void onClick(View v) {
        if (v == null) {
            return;
        }
    }
}
