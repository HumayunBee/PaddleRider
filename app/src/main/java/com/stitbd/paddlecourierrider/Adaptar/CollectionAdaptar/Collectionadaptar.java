package com.stitbd.paddlecourierrider.Adaptar.CollectionAdaptar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.stitbd.paddlecourierrider.Model.Collection.CParcel;
import com.stitbd.paddlecourierrider.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Collectionadaptar extends RecyclerView.Adapter<Collectionadaptar.Viewholders> {

    List<CParcel> collection = new ArrayList<>();
    Context context;

    public Collectionadaptar(List<CParcel> collection, Context context) {
        this.collection = collection;
        this.context = context;
    }

    @Override
    public Collectionadaptar.Viewholders onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.model_parcel, parent, false);
        return new Collectionadaptar.Viewholders(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull Collectionadaptar.Viewholders holder, int position) {

        holder.Invoice.setText(String.valueOf(collection.get(position).getParcelInvoice()));
        holder.CustomerName.setText(String.valueOf(collection.get(position).getCustomerName()));
        holder.CustomerPhn.setText(String.valueOf(collection.get(position).getCustomerContactNumber()));
        holder.CustomerAddress.setText(String.valueOf(collection.get(position).getCustomerAddress()));
        holder.TotalCollectAmount.setText("Collection Amount :" + String.valueOf(collection.get(position).getCollectAmount()));
        holder.MerchantName.setText("Merchant Name :" + String.valueOf(collection.get(position).getMerchantName()));
        holder.ParcelStatus.setText(String.valueOf(collection.get(position).getParcelStatus()));
        holder.nav.setVisibility(View.GONE);

    }

    @Override
    public int getItemCount() {
        return collection.size();
    }

    public class Viewholders extends RecyclerView.ViewHolder {

        TextView Invoice, CustomerName, CustomerPhn, CustomerAddress, TotalCollectAmount, MerchantName, ParcelStatus;
        ImageView nav;

        public Viewholders(@NonNull @NotNull View itemView) {
            super(itemView);

            Invoice = itemView.findViewById(R.id.tv_invoice);
            CustomerName = itemView.findViewById(R.id.tv_customer_name);
            CustomerPhn = itemView.findViewById(R.id.tv_phone);
            CustomerAddress = itemView.findViewById(R.id.tv_address);
            TotalCollectAmount = itemView.findViewById(R.id.tv_amount);
            MerchantName = itemView.findViewById(R.id.tv_merchant_name);
            ParcelStatus = itemView.findViewById(R.id.tv_status);
            nav = itemView.findViewById(R.id.iv_menu);
        }
    }
}
