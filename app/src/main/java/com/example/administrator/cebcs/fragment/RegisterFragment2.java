package com.example.administrator.cebcs.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.administrator.cebcs.MainActivity;
import com.example.administrator.cebcs.R;
import com.example.administrator.cebcs.unity.MyAlert;

/**
 * Created by masterung on 29/11/2017 AD.
 */

public class RegisterFragment2 extends Fragment {

    private String idStudentString, passwordString, rePasswordString;


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Toolbar
        toolbar();

//        Save Controller
        saveController();


    }   // Main Method

    private void saveController() {
        Button button = getView().findViewById(R.id.btnSave);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText idStudentEditText = getView().findViewById(R.id.edtIDstudent);
                EditText passwordEditText = getView().findViewById(R.id.edtPassword);
                EditText rePasswordEditText = getView().findViewById(R.id.edtRePassword);

                idStudentString = idStudentEditText.getText().toString().trim();
                passwordString = passwordEditText.getText().toString().trim();
                rePasswordString = rePasswordEditText.getText().toString().trim();

                MyAlert myAlert = new MyAlert(getActivity());

                if (idStudentString.isEmpty() || passwordString.isEmpty() || rePasswordString.isEmpty()) {
//                    Have Space
                    myAlert.myDialog(getString(R.string.have_space), getString(R.string.message_have_space));
                } else if (!(idStudentString.length() == 13)) {
//                    idStudentString Not 13digi
                    myAlert.myDialog(getString(R.string.id_false), getString(R.string.mess_id_false));
                }


            }
        });
    }

    private void toolbar() {
        Toolbar toolbar = getView().findViewById(R.id.toolberRegister2);
        ((MainActivity) getActivity()).setSupportActionBar(toolbar);
        ((MainActivity) getActivity()).getSupportActionBar().setTitle(getString(R.string.register));
        ((MainActivity) getActivity()).getSupportActionBar().setSubtitle(getString(R.string.message_have_space));

        ((MainActivity) getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register2, container, false);
        return view;
    }
}   // Main Class
