package com.e.streamapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.e.streamapp.Model.Slide;
import com.e.streamapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class SlideAdapter extends PagerAdapter {

    private Context context;
    private List<Slide> slideList;

    public SlideAdapter(Context context, List<Slide> slideList){
        this.context = context;
        this.slideList = slideList;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View slideLayout = layoutInflater.inflate(R.layout.slide_item, null);
        ImageView slideImg = slideLayout.findViewById(R.id.imageViewBanner);
        TextView txtTitulo = slideLayout.findViewById(R.id.txtTituloSlide);
        FloatingActionButton fbPlay = slideLayout.findViewById(R.id.floatingActionButtonPlay);
        slideImg.setImageResource(slideList.get(position).getImagem());
        txtTitulo.setText(slideList.get(position).getTitle());

        container.addView(slideLayout);
        return slideLayout;
    }

    @Override
    public int getCount() {
        return slideList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
