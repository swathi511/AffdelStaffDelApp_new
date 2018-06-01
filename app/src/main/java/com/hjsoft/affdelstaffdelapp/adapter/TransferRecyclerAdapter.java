package com.hjsoft.affdelstaffdelapp.adapter;

import android.content.Context;
import android.location.Geocoder;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hjsoft.affdelstaffdelapp.R;
import com.hjsoft.affdelstaffdelapp.model.AllBookingsData;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by hjsoft on 19/5/18.
 */
public class TransferRecyclerAdapter extends RecyclerView.Adapter<TransferRecyclerAdapter.MyViewHolder>{

    Context context;
    LayoutInflater inflater;
    Geocoder geocoder;
    RecyclerView rview;
    ArrayList<AllBookingsData> mResultList;
    AllBookingsData data;
    int pos;


    public TransferRecyclerAdapter(Context context, ArrayList<AllBookingsData> mResultList, RecyclerView rview)
    {

        this.context=context;
        this.mResultList=mResultList;
        this.rview=rview;
        inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        geocoder=new Geocoder(context, Locale.getDefault());

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_transfer_items, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        data=mResultList.get(position);

        holder.tvRoute.setText(data.getRoute());
        holder.tvDate.setText(data.getDate());
    }

    @Override
    public int getItemCount() {
        return mResultList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvRoute,tvDate;



        public MyViewHolder(final View itemView) {
            super(itemView);
            tvRoute=(TextView)itemView.findViewById(R.id.rtf_tv_route);
            tvDate=(TextView)itemView.findViewById(R.id.rtf_tv_date);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    //Toast.makeText(context,"clicked .."+pos,Toast.LENGTH_LONG).show();
                }
            });




        }


    }
}
