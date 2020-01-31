package com.julia.conversordemoedas.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.julia.conversordemoedas.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConversaoFragment extends Fragment {


    public ConversaoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_conversao, container, false);
    }

}
