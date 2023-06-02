package com.example.freetalk.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;


import com.bumptech.glide.Glide;
import com.example.freetalk.databinding.RowSlideViewItemBinding;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.List;

public class SliderViewImageAdapter extends SliderViewAdapter<SliderViewImageAdapter.SliderAdapterVH> {

    private final Context context;
    private final List<String> sliderList;

    public SliderViewImageAdapter(Context context, List<String> sliderList) {
        this.context = context;
        this.sliderList = sliderList;
    }

    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        RowSlideViewItemBinding viewBinding = RowSlideViewItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new SliderAdapterVH(viewBinding);
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, final int position) {
        viewHolder.bind(sliderList.get(position));
    }

    @Override
    public int getCount() {
        return sliderList.size();
    }

    class SliderAdapterVH extends SliderViewAdapter.ViewHolder {

        private final RowSlideViewItemBinding viewBinding;

        public SliderAdapterVH(RowSlideViewItemBinding viewBinding) {
            super(viewBinding.getRoot());

            this.viewBinding = viewBinding;
        }

        public void bind(String data) {

            Glide.with(context).load(data).into(viewBinding.imgSliderView);
        }
    }
}
