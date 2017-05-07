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
public class Fragment2 extends Fragment {

    Fragment23 f23;
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


    //    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        System.out.println("Tu jesteśmy");
//        f23 = new Fragment23();
//        f22 = new Fragment22();
//        transakcja2 = getActivity().getSupportFragmentManager().beginTransaction();
//        transakcja2.add(R.id.kontener2, f22);
//        transakcja2.detach(f22);
//        transakcja2.add(R.id.kontener2, f23);
//        transakcja2.detach(f23);
//        transakcja2.commit();
//        System.out.println("Tu jesteśmy");
//    }
}