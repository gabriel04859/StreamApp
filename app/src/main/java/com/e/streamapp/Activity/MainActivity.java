package com.e.streamapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;

import com.e.streamapp.Adapter.AnimesTemporadaAdapter;
import com.e.streamapp.Adapter.MaisVistosAdapter;
import com.e.streamapp.Adapter.SlideAdapter;
import com.e.streamapp.AnimeItemClickListener;
import com.e.streamapp.DAO.DataSource;
import com.e.streamapp.Model.Anime;
import com.e.streamapp.Model.Slide;
import com.e.streamapp.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements AnimeItemClickListener {
    List<Slide> slideList;
    private ViewPager slidePager;
    private TabLayout tabLayoutMain;
    private RecyclerView recyclerViewMaisVistos,recyclerViewAnimesTemp;
    private List<Anime> animeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        recyclerAnimesTemp();

        tabLayoutMain = findViewById(R.id.tabMain);
        recyclerViewMaisVistos = findViewById(R.id.recyclerViewMaisVistos);


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

        animeList = new ArrayList<>();
        recyclerViewMaisVistos.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        MaisVistosAdapter maisVistosAdapter = new MaisVistosAdapter(getApplicationContext(),DataSource.getAnimesPopulares(), this);
        recyclerViewMaisVistos.setAdapter(maisVistosAdapter);






    }
    private void recyclerAnimesTemp(){
        recyclerViewAnimesTemp = findViewById(R.id.recyclerViewAnimesTemporada);
        recyclerViewAnimesTemp.setHasFixedSize(true);
        recyclerViewAnimesTemp.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        AnimesTemporadaAdapter animesTemporadaAdapter = new AnimesTemporadaAdapter(getApplicationContext(), DataSource.getAnimesDaTemporada(),this);
        recyclerViewAnimesTemp.setAdapter(animesTemporadaAdapter);

    }

    @Override
    public void onAnimeClick(Anime anime, ImageView animeImageView) {
        Intent intent = new Intent(this, DetalhesAnimeActivity.class);
        intent.putExtra("nome",anime.getNome());
        intent.putExtra("imagem",anime.getImg());
        intent.putExtra("imagemCover", anime.getImgCover());

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,
                animeImageView, "sharedName");
        startActivity(intent, options.toBundle());

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
