package com.aliensglopal.ardemo.viewmodel;

import androidx.databinding.ObservableBoolean;

import com.aliensglopal.ardemo.model.constants.Codes;
import com.aliensglopal.ardemo.model.data.AnimalItem;

public class ItemProductViewModel extends BaseViewModel {

    public AnimalItem item;
    public ObservableBoolean isSelected = new ObservableBoolean();

    public ItemProductViewModel(AnimalItem item) {
        this.item = item;
        isSelected.set(item.isSelected());
    }

    public void onItemClick() {
        setValue(Codes.ITEM_CLICK);
    }

    public void onFavClick() {
        if (isSelected.get()) {
            isSelected.set(false);
            item.setSelected(false);
            setValue(Codes.FAV_UN_SELECTED);
        } else {
            isSelected.set(true);
            item.setSelected(true);
            setValue(Codes.FAV_SELECTED);
        }
    }

}
