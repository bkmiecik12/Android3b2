package com.example.bkmiecik.android3b2;


import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.*;
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

    public class MyAdapter1 extends ArrayAdapter<Eliga> {

        private LayoutInflater inflater = null;
        ArrayList<Eliga> eligaArrayList = MainActivity.eligaArrayList;

        public MyAdapter1(Context context, ArrayList<Eliga> users) {
            super(context, R.layout.lrel, users);
        }


        public int getCount() {
            return eligaArrayList.size();
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int poss, View cView, ViewGroup parent) {
            View mV;
            inflater = (LayoutInflater)
                    getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if (cView == null) {
                cView = inflater.inflate(R.layout.lrel, null);
            }
            mV = cView;

            ImageView img = (ImageView) mV.findViewById(R.id.row_logo1);

            Eliga f = eligaArrayList.get(poss);
            img.setImageResource(R.drawable.logo_gp);

            TextView tv1 = (TextView) mV.findViewById(R.id.row_home);
            tv1.setText(f.gosp);
            TextView tv2 = (TextView) mV.findViewById(R.id.row_away);
            tv2.setText(f.gosc);
//            TextView tv3 = (TextView) mV.findViewById(R.id.row_wgosp);
//            tv3.setText(String.valueOf(f.pgosp));
//            TextView tv4 = (TextView) mV.findViewById(R.id.row_wgpsc);
//            tv4.setText(String.valueOf(f.pgosc));


            return mV;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment4, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        eligaArrayList = MainActivity.eligaArrayList;
        MyAdapter1 adapter1 = new MyAdapter1(this.getContext(),eligaArrayList);
        ListView lista4 = (ListView) getActivity().findViewById(R.id.lista_el);
        lista4.setAdapter(adapter1);

        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        System.out.println("WBIJAM!");
        String string = "Runda nr "+eligaArrayList.get(position).runda+
                "\nGosp: "+eligaArrayList.get(position).gosp+
                "\nGoście: "+eligaArrayList.get(position).gosc+
                "\nWynik: "+eligaArrayList.get(position).pgosp+ " : "+eligaArrayList.get(position);
        new AlertDialog.Builder(view.getContext())
                .setTitle("Ekstraliga")
                .setMessage(string)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .setIcon(android.R.drawable.ic_menu_more)
                .show();
    }



}
