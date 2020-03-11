package com.aliensglopal.ardemo.viewmodel;

import com.aliensglopal.ardemo.R;
import com.aliensglopal.ardemo.model.data.AnimalItem;
import com.aliensglopal.ardemo.ui.imagesactivity.ProductsAdapter;
import java.util.ArrayList;
import java.util.List;


public class AnimalsViewModel extends BaseViewModel
{
   public ProductsAdapter productsAdapter = new ProductsAdapter();

   private int images[] = {R.drawable.ic_launcher_foreground, R.drawable.biology, R.drawable.atom_jpg, R.drawable.astronaut_png,
                            R.drawable.beaker_png, R.drawable.caurve_bg};
   private String names[] = {"rabbit", "fox", "mouse", "rabbit", "fox", "mouse"};
    private String imageNames[] = {"ArcticFox_Posed.sfp", "Mesh_Dinosaur.sfb","ArcticFox_Posed.sfp", "Mesh_Dinosaur.sfb", "ArcticFox_Posed.sfp", "Mesh_Dinosaur.sfb"};

    public AnimalsViewModel()
    {
        setValue("getting data");
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
            item.setSelected(false);
            productItems.add(item);
        }

        productsAdapter.updateDataList(productItems);
        setValue("all ready");
    }
}
