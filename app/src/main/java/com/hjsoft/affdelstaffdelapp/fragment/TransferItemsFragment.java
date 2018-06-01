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
import com.hjsoft.affdelstaffdelapp.adapter.TransferRecyclerAdapter;
import com.hjsoft.affdelstaffdelapp.model.AllBookingsData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hjsoft on 19/5/18.
 */
public class TransferItemsFragment extends Fragment {

    View v;
    Spinner sp;
    String item="";
    RecyclerView rView;
    TransferRecyclerAdapter mAdapter;
    ArrayList<AllBookingsData> dataList=new ArrayList<>();
    //RecyclerAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v= inflater.inflate(R.layout.fragment_transfer_items, container, false);

        rView=(RecyclerView)v.findViewById(R.id.fti_rview);

        dataList.add(new AllBookingsData("HYD - VIJ","22 May 2018","Pickup"));
        dataList.add(new AllBookingsData("HYD - VIJ","22 May 2018","Pickup"));
        dataList.add(new AllBookingsData("HYD - VIJ","22 May 2018","Delivery"));
        dataList.add(new AllBookingsData("HYD - VIJ","22 May 2018","Pickup"));
        dataList.add(new AllBookingsData("HYD - VIJ","22 May 2018","Pickup"));
        dataList.add(new AllBookingsData("HYD - VIJ","22 May 2018","Pickup"));
        dataList.add(new AllBookingsData("HYD - VIJ","22 May 2018","Delivery"));
        dataList.add(new AllBookingsData("HYD - VIJ","22 May 2018","Pickup"));

        mAdapter = new TransferRecyclerAdapter (getActivity(), dataList, rView);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rView.setLayoutManager(mLayoutManager);
        rView.setItemAnimator(new DefaultItemAnimator());
        rView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();




        return v;
    }
}