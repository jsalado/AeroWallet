package com.samsung.aero_wallet_app.viewmodel;

import android.app.Application;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.samsung.aero_wallet_app.services.PaymentService;
import com.samsung.aero_wallet_app.util.Util;
import com.samsung.android.sdk.blockchain.account.ethereum.EthereumAccount;

import java.math.BigInteger;

public class PaymentViewModel extends AndroidViewModel {

    private PaymentService mPaymentService = new PaymentService();

    public PaymentViewModel(@NonNull Application application) {
        super(application);
    }

    public Intent getDAppPaymentIntent(EthereumAccount fromAccount, String toAddress, BigInteger productPrice
            , String data, BigInteger nonce) {
        Log.i(Util.LOG_TAG, "Calling payment sheet intent service for Dapp.");
        Intent buyWebDAppProductIntent = mPaymentService.buildDappProductPaymentSheet
                (getApplication(), fromAccount, toAddress, productPrice, data, nonce);
        return buyWebDAppProductIntent;
    }
}
