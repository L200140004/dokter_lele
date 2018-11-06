package com.application.abdur_rohman.dokter_lele;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (RelativeLayout) object;
    }

    public SliderAdapter (Context context){
        this.context = context;
    }

    public int[] slide_images = {
            R.drawable.ic_android,
            R.drawable.ic_info,
            R.drawable.ic_warning
    };

    public int[] slide_headings = {
            R.string.dokter_lele,
            R.string.informasi,
            R.string.perhatian
    };

    public int[] slide_descs = {
            R.string.desc_slide1,
            R.string.info,
            R.string.waning
    };


    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slider, container, false);

        ImageView slider_image = (ImageView) view.findViewById(R.id.slide_image);
        TextView slider_head = (TextView) view.findViewById(R.id.slide_heading);
        TextView slider_desc = (TextView) view.findViewById(R.id.slide_desc);

        slider_image.setImageResource(slide_images[position]);
        slider_head.setText(slide_headings[position]);
        slider_desc.setText(slide_descs[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout)object);
    }
}
