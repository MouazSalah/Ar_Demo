package com.aliensglopal.ardemo.viewmodel;

import com.aliensglopal.ardemo.R;
import com.aliensglopal.ardemo.model.data.AnimalItem;
import com.aliensglopal.ardemo.ui.imagesactivity.ProductsAdapter;
import java.util.ArrayList;
import java.util.List;


public class AnimalsViewModel extends BaseViewModel
{
   public ProductsAdapter productsAdapter = new ProductsAdapter();

   private int images[] = {R.drawable.flower_png, R.drawable.palm_png, R.drawable.dolphin_png, R.drawable.elephant_png,
                              R.drawable.beaker_png, R.drawable.skel};
   private String names[] = {"Flower", "Palm", "Dolphin", "Elephant", "Beaker", "Skelton"};
    private String imageNames[] = {"Flower.sfb", "Palm.sfb", "dolphin.sfb", "elephant.sfb", "Beaker.sfb", "skel.sfb"};



    public AnimalsViewModel()
    {
        getData();
    }

    private void getData()
    {
        List<AnimalItem> productItems = new ArrayList<>();

        for (int i = 0; i < images.length; i++)
        {
            AnimalItem item = new AnimalItem();
            item.setId(images[i]);
            item.setName(names[i]);
            item.setImageName(imageNames[i]);
            item.setSelected(false);
            productItems.add(item);
        }

        productsAdapter.updateDataList(productItems);
        setValue("all ready");
    }
}
