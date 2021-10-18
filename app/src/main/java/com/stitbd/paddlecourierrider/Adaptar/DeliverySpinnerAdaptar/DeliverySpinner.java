package com.stitbd.paddlecourierrider.Adaptar.DeliverySpinnerAdaptar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.stitbd.paddlecourierrider.Adaptar.listener.Clicklistener;
import com.stitbd.paddlecourierrider.Model.DeliveryParcel.DeliveryStatus;
import com.stitbd.paddlecourierrider.R;

import java.util.ArrayList;
import java.util.List;

public class DeliverySpinner extends BaseAdapter {

    List<DeliveryStatus> areas=new ArrayList<>();
    LayoutInflater inflter;
    Clicklistener clicklistener;

    public DeliverySpinner(List<DeliveryStatus> areas, Context applicationContext) {
        this.areas = areas;
        this.clicklistener = clicklistener;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return areas.size();
    }

    @Override
    public Object getItem(int position) {
        return areas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return areas.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflter.inflate(R.layout.model_spinner_item, null);
        TextView name=convertView.findViewById(R.id.tv_item);
        name.setText(areas.get(position).getName());

        return convertView;
    }
}
