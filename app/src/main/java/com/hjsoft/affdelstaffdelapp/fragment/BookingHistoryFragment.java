package com.hjsoft.affdelstaffdelapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.hjsoft.affdelstaffdelapp.R;
import com.hjsoft.affdelstaffdelapp.adapter.RecyclerAdapter;
import com.hjsoft.affdelstaffdelapp.model.AllBookingsData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hjsoft on 19/5/18.
 */
public class BookingHistoryFragment extends Fragment {

    View v;
    Spinner sp;
    String item="";
    RecyclerView rView;
    RecyclerAdapter rAdapter;
    ArrayList<AllBookingsData> dataList=new ArrayList<>();
    RecyclerAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v= inflater.inflate(R.layout.fragment_booking_history, container, false);
        sp=(Spinner)v.findViewById(R.id.fbh_spinner);
        rView=(RecyclerView)v.findViewById(R.id.fbh_rview);

        final List<String> categories = new ArrayList<String>();
        categories.add("All");
        categories.add("Allocated");
        categories.add("Picked");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        sp.setAdapter(dataAdapter);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                if (position != 0) {

                    item = parent.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        dataList.add(new AllBookingsData("HYD - VIJ","22 May 2018","Pickup"));
        dataList.add(new AllBookingsData("HYD - VIJ","22 May 2018","Pickup"));
        dataList.add(new AllBookingsData("HYD - VIJ","22 May 2018","Delivery"));
        dataList.add(new AllBookingsData("HYD - VIJ","22 May 2018","Pickup"));
        dataList.add(new AllBookingsData("HYD - VIJ","22 May 2018","Pickup"));
        dataList.add(new AllBookingsData("HYD - VIJ","22 May 2018","Delivery"));
        dataList.add(new AllBookingsData("HYD - VIJ","22 May 2018","Pickup"));
        dataList.add(new AllBookingsData("HYD - VIJ","22 May 2018","Pickup"));

        mAdapter = new RecyclerAdapter(getActivity(), dataList, rView);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rView.setLayoutManager(mLayoutManager);
        rView.setItemAnimator(new DefaultItemAnimator());
        rView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();




         return v;
    }
}
