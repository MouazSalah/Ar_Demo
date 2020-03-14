package com.aliensglopal.ardemo.viewmodel;

import androidx.databinding.ObservableBoolean;
import com.aliensglopal.ardemo.model.constants.Codes;
import com.aliensglopal.ardemo.model.data.AnimalItem;

public class ItemAnimalViewModel extends BaseViewModel
{
    public AnimalItem item;
    public ObservableBoolean isSelected = new ObservableBoolean();

    public ItemAnimalViewModel(AnimalItem item)
    {
        this.item = item;
    }

    public void onItemClick()
    {
        setValue(Codes.ITEM_CLICK);
    }

}
