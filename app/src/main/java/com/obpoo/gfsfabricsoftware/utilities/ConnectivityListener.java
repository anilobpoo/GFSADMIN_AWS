package com.obpoo.gfsfabricsoftware.utilities;

import android.app.Application;

/**
 * Created by PHD on 12/6/2018.
 */

public class ConnectivityListener extends Application {

    private static ConnectivityListener mInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = this;
    }

    public static synchronized ConnectivityListener getInstance() {
        return mInstance;
    }

    public void setConnectivityListener(ConnectivityReceiver.ConnectivityReceiverListener listener) {
        ConnectivityReceiver.connectivityReceiverListener = listener;
    }
}
