package com.aliensglopal.ardemo.ui.imagesactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.aliensglopal.ardemo.ui.aygmentedactivity.AugmentedActivity;
import com.aliensglopal.ardemo.R;
import com.aliensglopal.ardemo.databinding.ActivityAnimalsBinding;
import com.aliensglopal.ardemo.model.data.AnimalItem;
import com.aliensglopal.ardemo.viewmodel.AnimalsViewModel;

public class AnimalsActivity extends AppCompatActivity
{
    ActivityAnimalsBinding binding;
    AnimalsViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_animals);

        viewModel = new ViewModelProvider(this).get(AnimalsViewModel.class);
        binding.setViewModel(viewModel);

        viewModel.getMutableLiveData().observe(this, o -> {
            if (o instanceof String) {
                String text = o.toString();
                //Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
              //  Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show();
            }
        });

        viewModel.productsAdapter.getMutableLiveData().observe(this, o ->
        {
            if (o instanceof AnimalItem)
            {
                AnimalItem item = (AnimalItem) o;
                Intent intent = new Intent(AnimalsActivity.this, AugmentedActivity.class);
                intent.putExtra("image_url", item.getImageName());
                startActivity(intent);
                finish();
            }
            else if (o instanceof String)
            {
                String text = o.toString();
                //Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
