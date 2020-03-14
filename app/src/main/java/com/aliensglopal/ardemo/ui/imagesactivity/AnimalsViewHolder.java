package com.aliensglopal.ardemo.ui.imagesactivity;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aliensglopal.ardemo.databinding.RawItemBinding;
import com.aliensglopal.ardemo.viewmodel.ItemAnimalViewModel;

public class AnimalsViewHolder extends RecyclerView.ViewHolder
{
    private RawItemBinding binding;

    public AnimalsViewHolder(@NonNull RawItemBinding binding)
    {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void setViewModel(ItemAnimalViewModel viewModel) {
        if (binding != null) {
            binding.setModel(viewModel);
        }
    }
}
