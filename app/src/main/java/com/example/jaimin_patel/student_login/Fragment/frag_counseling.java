package com.example.jaimin_patel.student_login.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.QuickContactBadge;

import com.example.jaimin_patel.student_login.R;
import com.example.jaimin_patel.student_login.activity.counseling_aftertenth;
import com.example.jaimin_patel.student_login.activity.counseling_aftertwelve;


/**
 * Created by Jaimin on 1/30/2018.
 */

public class frag_counseling extends Fragment {

    Button ten,twelve;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_counseling, container, false);


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getActivity().setTitle("Counseling");
    ten = getView().findViewById(R.id.ten);
    twelve= getView().findViewById(R.id.twelve);


    ten.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getActivity(),counseling_aftertenth.class);
            getActivity().startActivity(intent);
        }
    });


    twelve.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getActivity(),counseling_aftertwelve.class);
        getActivity().startActivity(intent);

        }
    });


    }
}