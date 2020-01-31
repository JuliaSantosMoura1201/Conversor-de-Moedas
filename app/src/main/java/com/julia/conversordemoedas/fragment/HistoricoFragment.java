package com.julia.conversordemoedas.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import com.julia.conversordemoedas.R;
import com.julia.conversordemoedas.adapter.AdapterHistorico;

public class HistoricoFragment extends Fragment {

    private RecyclerView recyclerView;

    public HistoricoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_historico, container, false);
        FragmentActivity c = getActivity();
        recyclerView = view.findViewById(R.id.recyclerView);

        AdapterHistorico adapterHistorico = new AdapterHistorico();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(c);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapterHistorico);
        return view;
    }

}
