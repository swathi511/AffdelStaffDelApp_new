package com.hjsoft.affdelstaffdelapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import com.hjsoft.affdelstaffdelapp.R;

/**
 * Created by hjsoft on 21/5/18.
 */
public class DeliveryFragment extends Fragment {

    View v;
    TextView tvPickupLoc,tvDeliveryLoc,tvItems,tvApproxWeight;
    EditText etReceiverName,etReceiverMobile;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v=inflater.inflate(R.layout.fragment_delivery,container,false);
        tvPickupLoc=(TextView)v.findViewById(R.id.fd_tv_pickup_loc);
        tvDeliveryLoc=(TextView)v.findViewById(R.id.fd_tv_delivery_loc);
        tvItems=(TextView)v.findViewById(R.id.fd_tv_no_items);
        tvApproxWeight=(TextView)v.findViewById(R.id.fd_tv_weight);
        etReceiverName=(EditText)v.findViewById(R.id.fd_et_receiver_name);
        etReceiverMobile=(EditText)v.findViewById(R.id.fd_et_receiver_mobile);



        return v;
    }
}
