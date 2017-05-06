package com.example.bkmiecik.android3b2;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment21 extends Fragment implements RadioGroup.OnCheckedChangeListener {

    AppCompatActivity A1;
    OnWyborOpcjiListener sluchaczF1;

    public Fragment21() {
        // Required empty public constructor
    }


    public interface OnWyborOpcjiListener {
        public void onWyborOpcji(int opcja);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment21, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ((RadioGroup) getActivity().findViewById(R.id.opcje)).
                setOnCheckedChangeListener(this);
        //((RadioGroup) getActivity().findViewById(R.id.opcje)).check(R.id.opcja1);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.opcja1:
                sluchaczF1.onWyborOpcji(1);
                break;
            case R.id.opcja2:
                sluchaczF1.onWyborOpcji(2);
                break;
        }
    }

    @Override
    public void onAttach(Context context) {
        try {
            A1 = (AppCompatActivity) context;
            sluchaczF1 = (OnWyborOpcjiListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(sluchaczF1.toString() +
                    " musi implementować OnWyborOpcjiListener");
        }
        super.onAttach(context);
    }
}
