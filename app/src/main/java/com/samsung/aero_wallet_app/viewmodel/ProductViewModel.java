package com.samsung.aero_wallet_app.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.samsung.aero_wallet_app.model.ProductModel;
import com.samsung.aero_wallet_app.services.ProductService;
import com.samsung.aero_wallet_app.util.Util;

import java.util.ArrayList;

public class ProductViewModel extends AndroidViewModel {

    private ArrayList<ProductModel> productList;

    private ProductService mProductService = new ProductService();

    public ProductViewModel(@NonNull Application application) {
        super(application);
    }

    public ArrayList<ProductModel> getProductList() {
        Log.i(Util.LOG_TAG, "Calling service for product list.");
        if (productList == null) {
            productList = mProductService.getProductList();
        }
        return productList;
    }

}
