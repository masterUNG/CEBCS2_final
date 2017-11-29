package com.example.administrator.cebcs.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.cebcs.R;

/**
 * Created by ASUS on 11/11/2560.
 */

public class CEdetailFragment extends Fragment{

    private String[] loginStrings;

    public static CEdetailFragment ceDetailInstance(String[] loginStrings) {

        CEdetailFragment cEdetailFragment = new CEdetailFragment();
        Bundle bundle = new Bundle();
        bundle.putStringArray("Login", loginStrings);
        cEdetailFragment.setArguments(bundle);
        return cEdetailFragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        loginStrings = getArguments().getStringArray("Login");
        Log.d("11novV2", "idStudent ==>" + loginStrings[1]);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ce_detail, container, false);
        return view;
    }
}   // Main Class
