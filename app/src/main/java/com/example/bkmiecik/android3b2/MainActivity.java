package com.example.bkmiecik.android3b2;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ActionBar.TabListener,Fragment21.OnWyborOpcjiListener{

    ActionBar bar;
    private Fragment1 f1;
    private Fragment2 f2;
    public static Fragment22 f22;
    public static Fragment23 f23;
    private Fragment3 f3;
    FragmentTransaction transakcja;
    public static ArrayList<GrandPrix> grandPrixArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grandPrixArrayList = new ArrayList<>();

        bar = getSupportActionBar();
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.Tab o1 = bar.newTab();
        ActionBar.Tab o2 = bar.newTab();
        ActionBar.Tab o3 = bar.newTab();

        o1.setText("O autorze");
        o2.setText("Dodaj");
        o3.setText("Lista");

        o1.setTabListener(this);
        o2.setTabListener(this);
        o3.setTabListener(this);

        bar.addTab(o1,false);
        bar.addTab(o2,false);
        bar.addTab(o3,false);


        f1 = new Fragment1();
        f2 = new Fragment2();
        f23 = new Fragment23();
        f22 = new Fragment22();
        f3 = new Fragment3();

        transakcja = getSupportFragmentManager().beginTransaction();
        transakcja.add(R.id.kontener, f1);
        transakcja.detach(f1);
        transakcja.add(R.id.kontener, f2);
        transakcja.detach(f2);
        transakcja.add(R.id.kontener, f3);
        transakcja.detach(f3);
        transakcja.add(R.id.kontener2, f23);
        transakcja.detach(f23);
        transakcja.add(R.id.kontener2, f22);
        transakcja.detach(f22);

        transakcja.commit();
        bar.selectTab(o1);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        transakcja = getSupportFragmentManager().beginTransaction();
        transakcja.detach(f1);
        transakcja.detach(f2);
        transakcja.detach(f3);

        switch (tab.getPosition()){
            case 0:
                transakcja.attach(f1);
                break;
            case 1:
                transakcja.attach(f2);
                break;
            case 2:
                transakcja.attach(f3);
                break;
        }
        transakcja.commit();

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onWyborOpcji(int opcja) {
        FragmentTransaction transakcja2 =
                getSupportFragmentManager().beginTransaction();
        transakcja2.detach(f23);
        transakcja2.detach(f22);


        switch (opcja){
            case 1:
                transakcja2.attach(f22);
                break;
            case 2:
                transakcja2.attach(f23);
                break;
        }
        transakcja2.commit();
    }

}
