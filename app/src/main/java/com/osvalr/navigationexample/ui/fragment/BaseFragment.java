package com.osvalr.navigationexample.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewbinding.ViewBinding;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

abstract class BaseFragment extends Fragment {
    protected NavController navController;
    private Method inflate;
    private Field bindingField;

    int getLayoutId() {
        return -1;
    }

    {
        try {
            bindingField = this.getClass().getDeclaredField("binding");
            bindingField.setAccessible(true);
            inflate = bindingField.getType().getDeclaredMethod(
                    "inflate", LayoutInflater.class, ViewGroup.class, boolean.class);
        } catch (Exception ignored) {
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        try {
            ViewBinding binding = (ViewBinding) inflate.invoke(null, inflater, container, false);
            bindingField.set(this, binding);
            return binding.getRoot();
        } catch (Exception ignored) {
            Log.w("App", "onCreateView: Not binded, trying inflating view ");
            int layoutId = getLayoutId();
            if (layoutId < 0) {
                Log.e("App", "onCreateView: Not inflated, you MUST either:"
                        + "\n- Override BaseFragment's getLayoutId method"
                        + "\n- Place private *Binding binding member inside your class"
                        + "");
                return null;
            }
            return inflater.inflate(layoutId, container, false);
        }
    }

    @Override
    public void onDestroyView() {
        try {
            bindingField.set(this, null);
        } catch (Exception ignored) {
        }
        super.onDestroyView();
    }
}
