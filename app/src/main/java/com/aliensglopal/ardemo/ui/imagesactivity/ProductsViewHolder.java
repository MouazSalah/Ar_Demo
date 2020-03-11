package com.aliensglopal.ardemo.ui.imagesactivity;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.aliensglopal.ardemo.databinding.RawItemBinding;
import com.aliensglopal.ardemo.viewmodel.ItemProductViewModel;

public class ProductsViewHolder extends RecyclerView.ViewHolder
{
    private RawItemBinding binding;

    public ProductsViewHolder(@NonNull RawItemBinding binding)
    {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind() {
        if (binding == null) {
            binding = DataBindingUtil.bind(itemView);
        }
    }

    public void unbind() {
        if (binding != null) {
            binding.unbind(); // Don't forget to unbind
        }
    }

    public void setViewModel(ItemProductViewModel viewModel) {
        if (binding != null) {
            binding.setModel(viewModel);
        }
    }

 /*   public void setAnimation() {
        Context baseContext = BaseApplication.getInstance().getApplicationContext();
        Animation anim = AnimationUtils.loadAnimation(baseContext, R.anim.left_in);
        itemView.startAnimation(anim);

    }*/
}
