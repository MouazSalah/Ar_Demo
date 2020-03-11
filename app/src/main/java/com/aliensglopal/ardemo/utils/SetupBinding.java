package com.aliensglopal.ardemo.utils;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aliensglopal.ardemo.ui.imagesactivity.ProductsAdapter;

/**
 * Created by MahmoudAyman on 2/14/2020.
 **/
public class SetupBinding {

    @BindingAdapter("app:adapter")
    public static void bindRecycler(RecyclerView recyclerView, ProductsAdapter productsAdapter){
        //do any you want with recycler view
        recyclerView.setAdapter(productsAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(BaseApplication.getInstance(), 2));
        recyclerView.hasFixedSize();         //optional
    }

}
