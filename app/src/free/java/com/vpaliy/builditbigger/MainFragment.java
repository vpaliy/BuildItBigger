package com.vpaliy.builditbigger;

import android.view.View;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class MainFragment extends BaseMainFragment{

    @Override
    public void onJokeFetched(final String joke) {
        final InterstitialAd ad=new InterstitialAd(getContext());
        ad.setAdUnitId(getString(R.string.banner_ad_unit_id));
        ad.loadAd(new AdRequest.Builder().build());
        ad.setAdListener(new AdListener(){
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                if (progressBar != null) {
                    progressBar.setVisibility(View.GONE);
                }
                ad.show();
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                super.onAdFailedToLoad(errorCode);
                if (progressBar != null) {
                    progressBar.setVisibility(View.GONE);
                }
                showJoke(joke);
            }

            @Override
            public void onAdClosed() {
                showJoke(joke);
            }
        });
    }
}
