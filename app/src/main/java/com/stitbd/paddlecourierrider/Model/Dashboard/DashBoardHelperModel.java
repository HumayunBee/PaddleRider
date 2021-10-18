package com.stitbd.paddlecourierrider.Model.Dashboard;

import android.content.Context;

public class DashBoardHelperModel {

    String title;
    Double value;
    Context context;

    public DashBoardHelperModel(String title, Double value) {
        this.title = title;
        this.value = value;
//        this.context=context;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
