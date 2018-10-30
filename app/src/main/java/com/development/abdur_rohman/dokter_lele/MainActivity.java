package com.development.abdur_rohman.dokter_lele;

import android.content.Intent;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ViewPager mSlider;
    private LinearLayout mLayout;
    private TextView[] mDots;
    private SliderAdapter sliderAdapter;
    private Button mNextBtn;
    private Button mBackBtn;
    private int mCurrentPage;
    private PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSlider = (ViewPager) findViewById(R.id.slideViewPager);
        mLayout = (LinearLayout) findViewById(R.id.mLayout);
        mNextBtn = (Button) findViewById(R.id.btn_next);
        mBackBtn = (Button) findViewById(R.id.btn_back);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.colorPrimaryDark));
        }

        sliderAdapter = new SliderAdapter(this);
        mSlider.setAdapter(sliderAdapter);

        prefManager = new PrefManager(this);

        //if (!prefManager.isFirstTimeLaunch()) {
        //    launchHomeScreen();
        //    finish();
        //}

        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

        addDotsIndicator(0);

        mSlider.addOnPageChangeListener(viewListener);

        mNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                mSlider.setCurrentItem(mCurrentPage + 1);
//                if (mCurrentPage < mDots.length - 1) {
//                    mSlider.setCurrentItem(mCurrentPage);
//                } else {
//                    prefManager.setFirstTimeLaunch(true);
//                    launchHomeScreen();
//                }
                int current = getItem(+1);
                if (current < mDots.length) {
                    mSlider.setCurrentItem(current);
                } else {
                    prefManager.setFirstTimeLaunch(true);
                    launchHomeScreen();
                }
            }
        });

        mBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSlider.setCurrentItem(mCurrentPage - 1);
            }
        });
    }

    private int getItem(int i) {
        return mSlider.getCurrentItem() + i;
    }

    private void launchHomeScreen() {
        prefManager.setFirstTimeLaunch(false);
        startActivity(new Intent(MainActivity.this, MainMenu.class));
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    public void addDotsIndicator(int position) {

        mDots = new TextView[3];
        mLayout.removeAllViews();

        for (int i = 0; i < mDots.length; i++){
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorTransapentWhite));

            mLayout.addView(mDots[i]);
        }

        if (mDots.length > 0){
            mDots[position].setTextColor(getResources().getColor(R.color.msg_no_notes));
        }


    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDotsIndicator(position);

            mCurrentPage = position;

            if (position == 0){
                mBackBtn.setVisibility(View.INVISIBLE);
            } else if (position == mDots.length - 1){
                mBackBtn.setVisibility(View.VISIBLE);
                mNextBtn.setText(R.string.finish);
            } else {
                mBackBtn.setVisibility(View.VISIBLE);
                mNextBtn.setText(R.string.next);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
