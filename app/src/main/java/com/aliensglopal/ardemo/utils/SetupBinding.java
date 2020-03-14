package com.aliensglopal.ardemo.utils;


import android.widget.ImageView;
import androidx.core.content.res.ResourcesCompat;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.aliensglopal.ardemo.ui.imagesactivity.AnimalsAdapter;


public class SetupBinding {

    @BindingAdapter("app:adapter")
    public static void bindRecycler(RecyclerView recyclerView, AnimalsAdapter animalsAdapter){
        recyclerView.setAdapter(animalsAdapter);
        recyclerView.hasFixedSize();
    }


    @BindingAdapter("app:setImage")
    public static void bindRecycler(ImageView imageView, int imageRes)
    {
        imageView.setImageDrawable(ResourcesCompat.getDrawable(BaseApplication.getInstance().getResources(), imageRes, null));
    }

}
