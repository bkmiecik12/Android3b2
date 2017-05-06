package com.example.bkmiecik.android3b2;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment2 extends Fragment implements Fragment21.OnWyborOpcjiListener {

    Fragment21 f21;
    Fragment22 f22;
    FragmentTransaction transakcja2;

    public Fragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment2, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        System.out.println("Tu jesteśmy");
        f21 = new Fragment21();
        f22 = new Fragment22();
        transakcja2 = getActivity().getSupportFragmentManager().beginTransaction();
        transakcja2.add(R.id.kontener, f21);
        transakcja2.detach(f21);
        transakcja2.add(R.id.kontener, f22);
        transakcja2.detach(f22);
        transakcja2.commit();
        System.out.println("Tu jesteśmy");
    }

    @Override
    public void onWyborOpcji(int opcja) {
        FragmentTransaction transakcja2 =
                getActivity().getSupportFragmentManager().beginTransaction();
        transakcja2.detach(f21);
        transakcja2.detach(f22);

        switch (opcja){
            case 1:
                transakcja2.attach(f21);
                break;
            case 2:
                transakcja2.attach(f22);
                break;
        }
        transakcja2.commit();
    }
}