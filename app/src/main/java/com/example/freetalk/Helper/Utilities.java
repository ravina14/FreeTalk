package com.example.freetalk.Helper;


import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.freetalk.R;

import java.util.Locale;

public class Utilities {

    private static final String TAG = "Utilities";
    private final Activity activity;
    public static Dialog dialogProgressBar;

    public Utilities(Activity activity) {
        this.activity = activity;
    }

    public void enterActivity(Intent intent) {
        activity.startActivity(intent);
    }

    public void exitActivity() {
        activity.finish();
    }

    public void progressDialogShow() {
        dialogProgressBar = new Dialog(activity);
        dialogProgressBar.setCanceledOnTouchOutside(false);
        dialogProgressBar.setCancelable(false);
        dialogProgressBar.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogProgressBar.setContentView(R.layout.row_progress_bar);

        dialogProgressBar.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialogProgressBar.show();
    }

    public void progressDialogHide() {
        if (dialogProgressBar != null) {
            if (dialogProgressBar.isShowing()) {
                dialogProgressBar.dismiss();
            }
        }
    }

    public  void setLanguage(String languageCode) {
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);
        Resources resources = activity.getResources();
        Configuration config = resources.getConfiguration();
        config.setLocale(locale);
        resources.updateConfiguration(config, resources.getDisplayMetrics());
    }

}
