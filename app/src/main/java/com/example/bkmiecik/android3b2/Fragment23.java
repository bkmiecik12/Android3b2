package com.example.bkmiecik.android3b2;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.*;
import com.example.bkmiecik.android3b2.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment23 extends Fragment {

    ArrayList<Eliga> eligaArrayList;

    Spinner sgosp;
    Spinner sgosc;
    EditText epgosp;
    EditText epgosc;
    SeekBar seekBar;
    Button zapisz;

    public Fragment23() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_fragment23, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        eligaArrayList = MainActivity.eligaArrayList;

        sgosp = (Spinner) getActivity().findViewById(R.id.sgosp);
        sgosc = (Spinner) getActivity().findViewById(R.id.sgosc);

        epgosp = (EditText) getActivity().findViewById(R.id.epgosp);
        epgosc = (EditText) getActivity().findViewById(R.id.epgosc);

        seekBar = (SeekBar) getActivity().findViewById(R.id.seekBar);

        zapisz = (Button) getActivity().findViewById(R.id.zapiszel);

        zapisz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Eliga eliga = new Eliga(String.valueOf(sgosp.getSelectedItem()), String.valueOf(sgosc.getSelectedItem()), Integer.valueOf(epgosp.getText().toString()), Integer.valueOf(epgosc.getText().toString()));
                eligaArrayList.add(eliga);
                Toast.makeText(getContext(),"Zapisano",Toast.LENGTH_SHORT).show();
            }
        });


        seekBar.setMax(75);
        //seekBar.setProgress(1);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(progress<=15){
                    epgosc.setText(String.valueOf(75));
                    epgosp.setText(String.valueOf(progress));
                }
                else{
                    epgosc.setText(String.valueOf(90-progress));
                    epgosp.setText(String.valueOf(progress));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        super.onActivityCreated(savedInstanceState);
    }
}
