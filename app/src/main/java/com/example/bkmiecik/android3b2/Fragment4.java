package com.example.bkmiecik.android3b2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import com.example.bkmiecik.android3b2.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment4 extends Fragment implements AdapterView.OnItemClickListener{

    ArrayList<Eliga> eligaArrayList;

    public Fragment4() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        eligaArrayList = MainActivity.eligaArrayList;
        return inflater.inflate(R.layout.fragment_fragment4, container, false);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
