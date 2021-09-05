package com.example.tablayout.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tablayout.R;

public class Fragment2 extends Fragment {

    public static Fragment2 newInstance() {
        return new Fragment2();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_2, container, false);
        return view;
    }
}
