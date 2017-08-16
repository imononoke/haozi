package com.isa.haozi;

import android.support.multidex.MultiDexApplication;

import com.dianrong.android.common.AppContext;

/**
 * Created by Izumi on 17/8/16.
 */

public class MyApplication extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        AppContext.init(this);
    }
}
