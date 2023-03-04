package com.example.openappads;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;

import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.ads.MaxAppOpenAd;
import com.applovin.sdk.AppLovinSdk;

public class AppLovingOpenManager
        implements LifecycleObserver, MaxAdListener {
    private final MaxAppOpenAd appLovingOpenAd;
    private final Context context;

    //Ads ID here
    //private final String ADS_UNIT = "315243844d94031a";

    public AppLovingOpenManager(final Context context) {
        ProcessLifecycleOwner.get().getLifecycle().addObserver(this);

        this.context = context;

        appLovingOpenAd = new MaxAppOpenAd("315243844d94031a", context);
        appLovingOpenAd.setListener(this);
        appLovingOpenAd.loadAd();
    }

    private void showAdIfReady() {
        if (appLovingOpenAd == null || !AppLovinSdk.getInstance(context).isInitialized()) return;

        if (appLovingOpenAd.isReady()) {
            appLovingOpenAd.showAd("315243844d94031a");
            Toast.makeText(context, "sakjdhkjsafh", Toast.LENGTH_SHORT).show();

        } else {
            appLovingOpenAd.loadAd();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        showAdIfReady();
        }

    @Override
    public void onAdLoaded(final MaxAd ad) {
    }

    @Override
    public void onAdLoadFailed(final String adUnitId, final MaxError error) {
    }

    @Override
    public void onAdDisplayed(final MaxAd ad) {
    }

    @Override
    public void onAdClicked(final MaxAd ad) {
    }

    @Override
    public void onAdHidden(final MaxAd ad) {
        appLovingOpenAd.loadAd();
    }

    @Override
    public void onAdDisplayFailed(final MaxAd ad, final MaxError error) {
        appLovingOpenAd.loadAd();
    }
}
