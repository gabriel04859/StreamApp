package com.e.streamapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.e.streamapp.Adapter.SlideAdapter;
import com.e.streamapp.Model.Slide;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    List<Slide> slideList;
    private ViewPager slidePager;
    private TabLayout tabLayoutMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayoutMain = findViewById(R.id.tabMain);

        slideList = new ArrayList<>();
        slideList.add(new Slide(R.drawable.slide01,"Título"));
        slideList.add(new Slide(R.drawable.slide02,"Título"));
        slideList.add(new Slide(R.drawable.slide03,"Título"));
        slideList.add(new Slide(R.drawable.slide04,"Título"));
        slidePager = findViewById(R.id.slidePagerMain);

        SlideAdapter slideAdapter = new SlideAdapter(this,slideList);
        slidePager.setAdapter(slideAdapter);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MainActivity.SliderTime(),4000,6000);
        tabLayoutMain.setupWithViewPager(slidePager,true);


    }

    class SliderTime extends TimerTask{

        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (slidePager.getCurrentItem()<slideList.size() -1) {
                        slidePager.setCurrentItem(slidePager.getCurrentItem() + 1);


                    }else {
                        slidePager.setCurrentItem(0);
                    }
                }
            });
        }
    }
}
