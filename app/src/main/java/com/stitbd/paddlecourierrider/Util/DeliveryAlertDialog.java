package com.stitbd.paddlecourierrider.Util;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.stitbd.paddlecourierrider.Network.Api;
import com.stitbd.paddlecourierrider.Network.RetrofitClient;
import com.stitbd.paddlecourierrider.R;
import com.google.gson.JsonObject;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DeliveryAlertDialog {
   Api api;
    private Dialog dialog;
    public Spinner spinner;
    Context context;
    public ImageView cancel;
    public TextView Eamount, ECode, Edate, ENote;
    public LinearLayout LnNote, LnDate, LnCode, LnConfirmAmount;
    public EditText EnterCode,ConfirmAmount;
    public Button button ,SendOtp;
    Calendar myCalendar;
    public  ImageView canceldialog;
    DatePickerDialog datePickerDialog;
    private int mYear, mMonth, mDay;
    String[] items = new String[]{"Select Delivery Type", "Complete Delivery ", "Partial Delivery", "Reschedule Delivery", "Delivery cancel"};

    public DeliveryAlertDialog(Context context) {
        this.dialog = new Dialog(context);
        this.dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.context = context;
        api= RetrofitClient.get(context).create(Api.class);
    }

    public void showConfirmDialog(String message, String okTitle, String cancelTitle) {
        this.dialog.setContentView(R.layout.dialog_delivery_complete);

        EnterCode=dialog.findViewById(R.id.et_code);

        spinner = dialog.findViewById(R.id.sp_user_list);
        cancel = dialog.findViewById(R.id.iv_cancel);
        ConfirmAmount = dialog.findViewById(R.id.et_amount);
        Eamount = dialog.findViewById(R.id.et_amount);
        ECode = dialog.findViewById(R.id.et_code);
        Edate = dialog.findViewById(R.id.tv_date);
        ENote = dialog.findViewById(R.id.et_note);
        LnNote = dialog.findViewById(R.id.ln_note);
        LnDate = dialog.findViewById(R.id.ln_date);
        LnCode = dialog.findViewById(R.id.ln_code);
        LnConfirmAmount = dialog.findViewById(R.id.ln_confirm_amount);
        button = dialog.findViewById(R.id.btn_confirm);
        SendOtp=dialog.findViewById(R.id.send_otp);
        canceldialog=dialog.findViewById(R.id.iv_cancel);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, items);
        spinner.setAdapter(adapter);
        Edate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myCalendar = Calendar.getInstance();
                mYear = myCalendar.get(Calendar.YEAR);
                mMonth = myCalendar.get(Calendar.MONTH) ;
                mDay = myCalendar.get(Calendar.DAY_OF_MONTH);


                datePickerDialog = new DatePickerDialog(context,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                                int month=i1+1;
                                Edate.setText(i + "-" + month + "-" + i2);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }

        });
        canceldialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancel();
            }
        });

//        editText = dialog.findViewById(R.id.dialogMessageTextView);
//        button = dialog.findViewById(R.id.dialogCancelButton);
        dialog.setCancelable(false);


        if (dialog.getWindow() != null) {
            dialog.getWindow().setAttributes(getLayoutParams(dialog));

            dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            button.setOnClickListener(view -> DeliveryAlertDialog.this.cancel());
        }
    }

public void sendOtp(String parcelId){
        Log.e("tesst","send otp");
         api.getDeliveryOTP(parcelId).enqueue(new Callback<JsonObject>() {
             @Override
             public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                 if(response.isSuccessful()&&response.body()!=null){
                     Toast.makeText(context, "OTP Code send", Toast.LENGTH_SHORT).show();
                 }
                 Log.e("tesst","send otp from if");
             }

             @Override
             public void onFailure(Call<JsonObject> call, Throwable t) {
                 Log.e("tesst","send otp from else");
             }
         });

}


    private WindowManager.LayoutParams getLayoutParams(@NonNull Dialog dialog) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        if (dialog.getWindow() != null) {
            layoutParams.copyFrom(dialog.getWindow().getAttributes());
        }
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;

        return layoutParams;
    }

    public void show() {
        if (dialog != null) {
            dialog.show();
        }
    }

    public Dialog getDialog() {
        return dialog;
    }

    public void cancel() {
        if (dialog != null) {
            dialog.dismiss();
        }
    }
}
