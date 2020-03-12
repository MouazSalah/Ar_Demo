package com.aliensglopal.ardemo.utils;

import android.media.Image;
import android.widget.ImageView;

import androidx.core.content.res.ResourcesCompat;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aliensglopal.ardemo.R;
import com.aliensglopal.ardemo.ui.imagesactivity.ProductsAdapter;

/**
 * Created by MahmoudAyman on 2/14/2020.
 **/
public class SetupBinding {

    @BindingAdapter("app:adapter")
    public static void bindRecycler(RecyclerView recyclerView, ProductsAdapter productsAdapter){
        //do any you want with recycler view
        recyclerView.setAdapter(productsAdapter);
//        recyclerView.setLayoutManager(new GridLayoutManager(BaseApplication.getInstance(), 2)); you can set this from xml see with meخن
        recyclerView.hasFixedSize();         //optional
    }


    @BindingAdapter("app:setImage")
    public static void bindRecycler(ImageView imageView, int imageRes){
        imageView.setImageDrawable(ResourcesCompat.getDrawable(BaseApplication.getInstance().getResources(), imageRes, null));
    }

}
