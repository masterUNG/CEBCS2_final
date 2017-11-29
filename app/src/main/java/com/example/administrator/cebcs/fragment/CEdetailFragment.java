package com.example.administrator.cebcs.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.administrator.cebcs.R;
import com.example.administrator.cebcs.unity.GetCEwhereIDstudent;
import com.example.administrator.cebcs.unity.MyConstant;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by ASUS on 11/11/2560.
 */

public class CEdetailFragment extends Fragment {

    private String[] loginStrings;
    private String tag = "29novV3";

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
        Log.d(tag, "idSt2 ==>" + loginStrings[2]);

//        Create ListView
        createListView();


    }   // Main Method

    private void createListView() {

        ListView listView = getView().findViewById(R.id.livCE);
        MyConstant myConstant = new MyConstant();

        try {

            GetCEwhereIDstudent getCEwhereIDstudent = new GetCEwhereIDstudent(getActivity());
            getCEwhereIDstudent.execute(loginStrings[2], myConstant.getUrlGetCEwhereIDstudent());
            String resultJSON = getCEwhereIDstudent.get();
            Log.d(tag, "resultJSON ==> " + resultJSON);

            JSONArray jsonArray = new JSONArray(resultJSON);
            JSONObject jsonObject = jsonArray.getJSONObject(0);

            String ceString = jsonObject.getString("CE");
            Log.d(tag, "ce ==> " + ceString);


            ceString = ceString.replace("[", "");
            ceString = ceString.replace("]", "");
            Log.d(tag, "ce ที่ตัด [] แล้ว ==> " + ceString);

            String[] ceStrings = ceString.split(",");
            for (int i=0; i<ceStrings.length; i+=1) {
                Log.d(tag, "ceStrings[" + i + "] ==> " + ceStrings[i]);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ce_detail, container, false);
        return view;
    }
}   // Main Class
