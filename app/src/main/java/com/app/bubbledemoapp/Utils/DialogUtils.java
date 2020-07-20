package com.app.bubbledemoapp.Utils;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;

import com.app.bubbledemoapp.R;


public class DialogUtils extends Dialog {

    private static DialogUtils dialogUtils;

    // Constructor
    public DialogUtils(Context context)
            throws ClassCastException {
        super(context);

    }

    public static DialogUtils startProgressDialog(Context context) {

        dialogUtils = new DialogUtils(context);
        dialogUtils.setCancelable(false);
        dialogUtils.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogUtils.show();
        return dialogUtils;
    }


    public static void stopProgressDialog() {
        if (dialogUtils != null) {
            dialogUtils.dismiss();
            dialogUtils = null;
        } else if (dialogUtils == null) {

        } else {
            dialogUtils.dismiss();
            dialogUtils = null;
        }

    }

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.custom_progress_dialog_trans);
    }

}
