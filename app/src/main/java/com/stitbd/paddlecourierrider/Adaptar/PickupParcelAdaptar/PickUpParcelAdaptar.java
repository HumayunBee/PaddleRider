package com.stitbd.paddlecourierrider.Adaptar.PickupParcelAdaptar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.stitbd.paddlecourierrider.Adaptar.listener.PercelMenuClickListener;
import com.stitbd.paddlecourierrider.Model.PickUpParcel.Parcel;
import com.stitbd.paddlecourierrider.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class PickUpParcelAdaptar extends RecyclerView.Adapter<PickUpParcelAdaptar.Viewholders> {

    public OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    List<Parcel> pickup = new ArrayList<>();
    Context context;

    public PickUpParcelAdaptar(List<Parcel> pickup, Context context, OnItemClickListener listener) {
        this.pickup = pickup;
        this.context = context;
        this.listener = listener;
    }

    @Override
    public PickUpParcelAdaptar.Viewholders onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.model_parcel, parent, false);
        return new PickUpParcelAdaptar.Viewholders(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull PickUpParcelAdaptar.Viewholders holder, int position) {

        holder.Invoice.setText(String.valueOf(pickup.get(position).getParcelInvoice()));
        holder.CustomerName.setText(String.valueOf(pickup.get(position).getCustomerName()));
        holder.CustomerPhn.setText(String.valueOf(pickup.get(position).getCustomerContactNumber()));
        holder.CustomerAddress.setText(String.valueOf(pickup.get(position).getCustomerAddress()));
        holder.TotalCollectAmount.setText("Collection Amount :" + String.valueOf(pickup.get(position).getTotalCollectAmount()));
        holder.MerchantName.setText("Merchant Name :" + String.valueOf(pickup.get(position).getMerchantName()));
        holder.ParcelStatus.setText(String.valueOf(pickup.get(position).getParcelStatus()));
        holder.optionMenu.setOnClickListener(new PercelMenuClickListener(this, holder,
                pickup.get(position), listener));


    }

    @Override
    public int getItemCount() {
        return pickup.size();
    }

    public class Viewholders extends RecyclerView.ViewHolder {

        TextView Invoice, CustomerName, CustomerPhn, CustomerAddress, TotalCollectAmount, MerchantName, ParcelStatus;
        ImageView optionMenu;

        public Viewholders(@NonNull @NotNull View itemView) {
            super(itemView);

            Invoice = itemView.findViewById(R.id.tv_invoice);
            CustomerName = itemView.findViewById(R.id.tv_customer_name);
            CustomerPhn = itemView.findViewById(R.id.tv_phone);
            CustomerAddress = itemView.findViewById(R.id.tv_address);
            TotalCollectAmount = itemView.findViewById(R.id.tv_amount);
            MerchantName = itemView.findViewById(R.id.tv_merchant_name);
            ParcelStatus = itemView.findViewById(R.id.tv_status);
            optionMenu = itemView.findViewById(R.id.iv_menu);


        }

        public ImageView getoption() {
            return this.optionMenu;
        }
    }


}
