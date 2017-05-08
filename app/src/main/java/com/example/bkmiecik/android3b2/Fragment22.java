package com.example.bkmiecik.android3b2;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment22 extends Fragment {

    Button zapisz;
    Spinner kraje;
    Spinner dziki;
    EditText miasto;
    RatingBar ocena;


    ArrayList<GrandPrix> grandPrixArrayList;


    public Fragment22() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        grandPrixArrayList = MainActivity.grandPrixArrayList;

        kraje = (Spinner) getActivity().findViewById(R.id.kraj);
        dziki = (Spinner) getActivity().findViewById(R.id.dzik);
        miasto = (EditText) getActivity().findViewById(R.id.miasto);
        ocena = (RatingBar) getActivity().findViewById(R.id.ocenagp);

        zapisz = (Button) getActivity().findViewById(R.id.zapiszgp);
        zapisz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(grandPrixArrayList.isEmpty());
                GrandPrix gp = new GrandPrix(String.valueOf(kraje.getSelectedItem()),miasto.getText().toString(),String.valueOf(dziki.getSelectedItem()), ocena.getRating());
                grandPrixArrayList.add(gp);
                Toast.makeText(getContext(),grandPrixArrayList.get(0).miasto,Toast.LENGTH_SHORT).show();
            }
        });

        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment22, container, false);
    }

}
