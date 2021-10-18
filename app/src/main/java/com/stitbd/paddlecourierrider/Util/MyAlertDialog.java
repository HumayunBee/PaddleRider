package com.stitbd.paddlecourierrider.Util;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.stitbd.paddlecourierrider.R;


public class MyAlertDialog {


    private ImageView imageView;
    private Dialog dialog;
    EditText editText;
    public Button button;

    public MyAlertDialog(Context context) {
        this.dialog = new Dialog(context);
        this.dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
    }

    public void showConfirmDialog(String message, String okTitle, String cancelTitle) {
        this.dialog.setContentView(R.layout.dialog_layout);


        editText = dialog.findViewById(R.id.dialogMessageTextView);
        button = dialog.findViewById(R.id.dialogCancelButton);
        dialog.setCancelable(false);

        // msgTextView = dialog.findViewById(R.id.dialogMessageTextView);


//        msgTextView.setText(message);
//        okButton.setText(okTitle);
//        cancelButton.setText(cancelTitle);

        if (dialog.getWindow() != null) {
            dialog.getWindow().setAttributes(getLayoutParams(dialog));

            dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            button.setOnClickListener(view -> MyAlertDialog.this.cancel());
        }
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
