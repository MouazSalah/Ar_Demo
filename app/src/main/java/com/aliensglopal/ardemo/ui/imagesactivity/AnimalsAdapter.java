package com.aliensglopal.ardemo.ui.imagesactivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.aliensglopal.ardemo.R;
import com.aliensglopal.ardemo.databinding.RawItemBinding;
import com.aliensglopal.ardemo.model.constants.Codes;
import com.aliensglopal.ardemo.model.data.AnimalItem;
import com.aliensglopal.ardemo.viewmodel.ItemAnimalViewModel;

import java.util.ArrayList;
import java.util.List;

public class AnimalsAdapter extends RecyclerView.Adapter<AnimalsViewHolder>
{
    private List<AnimalItem> mDataList;
    private MutableLiveData<Object> mutableLiveData;
    private static final int layoutRes = R.layout.raw_item;

    public AnimalsAdapter() {
        mutableLiveData = new MutableLiveData<>();
    }

    public void updateDataList(final List<AnimalItem> items)
    {
        if  (mDataList == null)
        {
            mDataList = new ArrayList<>();
        }
        mDataList.clear();
        mDataList.addAll(items);
    }

    @NonNull
    @Override
    public AnimalsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        RawItemBinding binding = DataBindingUtil.inflate(layoutInflater, layoutRes
                , parent, false);
        return new AnimalsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalsViewHolder holder, int position)
    {
        ItemAnimalViewModel viewModel = new ItemAnimalViewModel(getCurrentItem(position));
        holder.setViewModel(viewModel);
        viewModel.getMutableLiveData().observeForever(o -> {
            if (o instanceof Integer){
                int result = (Integer) o;
                if (result == Codes.ITEM_CLICK){
                    mutableLiveData.setValue(getCurrentItem(position));
                }
            }
        });
    }

    private AnimalItem getCurrentItem(int pos) {
        return mDataList.get(pos);
    }


    @Override
    public int getItemCount()
    {
        return mDataList == null ? 0 : mDataList.size();
    }

    public MutableLiveData<Object> getMutableLiveData() {
        return mutableLiveData;
    }
}
