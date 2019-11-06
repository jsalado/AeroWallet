package com.samsung.aero_wallet_app.services;

import android.util.Log;

import com.samsung.aero_wallet_app.R;
import com.samsung.aero_wallet_app.model.ProductModel;
import com.samsung.aero_wallet_app.util.Util;

import java.util.ArrayList;

public class ProductService {


    private ArrayList<ProductModel> productList = new ArrayList<>();

    public void populateProductListRaw() {
        ArrayList<ProductModel> productListRaw = new ArrayList<>();
        String sellerAddress = "0x59B8B4238D8cBdA87046df15a6eF2815CD807C80";
        productListRaw.add(new ProductModel(
                1,
                "Galaxy Note10",
                "Introducing next-level power with Galaxy Note10.",
                R.drawable.note10,
                3.2, sellerAddress
        ));
        productListRaw.add(new ProductModel(
                2,
                "Galaxy S10",
                "Introducing next-level power with Galaxy S10.",
                R.drawable.s10,
                3.0,
                sellerAddress
        ));
        productListRaw.add(new ProductModel(
                3,
                "Galaxy Watch Active",
                "Introducing next-level power with Galaxy Watch Active.",
                R.drawable.active_watch,
                0.28,
                sellerAddress
        ));
        productListRaw.add(new ProductModel(
                4,
                "Galaxy Fit",
                "Introducing next-level power with Galaxy Fit.",
                R.drawable.galaxy_fit,
                0.15,
                sellerAddress
        ));
        this.productList = productListRaw;
    }

    public ArrayList<ProductModel> getProductList() {
        if (productList.isEmpty()) {
            populateProductListRaw();
            Log.i(Util.LOG_TAG, "Populated raw product list.");
        }
        return productList;
    }
}
