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

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment3 extends Fragment implements AdapterView.OnItemClickListener{

    ArrayList<GrandPrix> grandPrixArrayList;

    public Fragment3() {
        // Required empty public constructor
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        System.out.println("WBIJAM!");
        String string = "FIM Speedway Grand Prix\nof"+grandPrixArrayList.get(position)+
                "\nMiasto: "+grandPrixArrayList.get(position).miasto+
                "\nDzika karta: "+grandPrixArrayList.get(position).dzik+
                "\nOcena widowiska: "+grandPrixArrayList.get(position).ocena;
        new AlertDialog.Builder(view.getContext())
                .setTitle("SGP of "+grandPrixArrayList.get(position).kraj)
                .setMessage(string)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .setIcon(android.R.drawable.ic_menu_more)
                .show();
    }

    public class myAdapter extends ArrayAdapter<GrandPrix> {
        private LayoutInflater inflater = null;
        ArrayList<GrandPrix> grandPrixArrayList = MainActivity.grandPrixArrayList;
        public myAdapter(Context context, ArrayList<GrandPrix> users) {
            super(context, R.layout.lrgp, users);
        }


        public int getCount() {
            return grandPrixArrayList.size();
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int poss, View cView, ViewGroup parent) {
            View mV;
            inflater = (LayoutInflater)
                    getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if (cView == null) {
                cView = inflater.inflate(R.layout.lrgp, null);
            }
            mV = cView;


            ImageView img = (ImageView) mV.findViewById(R.id.row_logo);

            GrandPrix f = grandPrixArrayList.get(poss);
            img.setImageResource(R.drawable.logo_gp);

            TextView tv1 = (TextView) mV.findViewById(R.id.row_tyt);
            tv1.setText("Grand Prix of " + f.kraj);
            TextView tv2 = (TextView) mV.findViewById(R.id.row_rez);
            tv2.setText("(" + f.miasto + ")");
            //TextView tv4 = (TextView) mV.findViewById(R.id.row_gp_ocena);
            //tv4.setText(String.valueOf(f.ocena));
            return mV;
        }
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        grandPrixArrayList = MainActivity.grandPrixArrayList;
        myAdapter adapter = new myAdapter(this.getContext(),grandPrixArrayList);
        ListView lista3 = (ListView) getActivity().findViewById(R.id.lista_gp);
        lista3.setAdapter(adapter);
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment3, container, false);
    }

}
