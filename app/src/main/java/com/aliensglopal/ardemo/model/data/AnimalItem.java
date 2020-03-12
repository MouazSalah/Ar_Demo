package com.aliensglopal.ardemo.model.data;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.aliensglopal.ardemo.R;
import com.bumptech.glide.Glide;

/**
 * Created by MahmoudAyman on 2/14/2020.
 **/
public class AnimalItem
{
    private int id;
    private String name;
    private boolean selected;
    private String imageUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getImageName() {
        return imageUrl;
    }

    public void setImageName(String imageName) {
        this.imageUrl = imageName;
    }

    // important code for loading image here
    @BindingAdapter({"avatar"})
    public void loadImage(ImageView imageView, String imageURL) {
        Glide.with(imageView.getContext())
                .load(imageURL)
                .placeholder(R.drawable.biology)
                .into(imageView);
    }

}
