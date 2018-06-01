package com.hjsoft.affdelstaffdelapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hjsoft.affdelstaffdelapp.R;

/**
 * Created by hjsoft on 21/5/18.
 */
public class PickupFragment extends Fragment {

    View v;
    TextView tvPickupLoc,tvDeliveryLoc,tvItems,tvApproxWeight;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v=inflater.inflate(R.layout.fragment_pickup,container,false);

        tvPickupLoc=(TextView)v.findViewById(R.id.fp_tv_pickup_loc);
        tvDeliveryLoc=(TextView)v.findViewById(R.id.fp_tv_delivery_loc);
        tvItems=(TextView)v.findViewById(R.id.fp_tv_no_items);
        tvApproxWeight=(TextView)v.findViewById(R.id.fp_tv_weight);
        return v;
    }
}
