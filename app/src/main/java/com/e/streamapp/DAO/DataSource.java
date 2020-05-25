package com.e.streamapp.DAO;

import com.e.streamapp.Model.Anime;
import com.e.streamapp.R;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

    public static List<Anime> getAnimesPopulares(){
        List<Anime> animeListPopular = new ArrayList<>();
        animeListPopular.add(new Anime("Hunter X Hunter", R.drawable.slide02,R.drawable.slide01));
        animeListPopular.add(new Anime("Tower of God", R.drawable.slide04,R.drawable.slide01));
        animeListPopular.add(new Anime("Evangelion", R.drawable.slide03,R.drawable.slide01));
        animeListPopular.add(new Anime("FullMetal Alchimester", R.drawable.slide04,R.drawable.slide01));
        animeListPopular.add(new Anime("Hunter X Hunter", R.drawable.slide02,R.drawable.slide01));
        animeListPopular.add(new Anime("Tower of God", R.drawable.slide03,R.drawable.slide01));
        animeListPopular.add(new Anime("Evangelion", R.drawable.slide03,R.drawable.slide01));
        animeListPopular.add(new Anime("FullMetal Alchimester", R.drawable.slide04,R.drawable.slide01));
        return animeListPopular;

    }

    public static List<Anime> getAnimesDaTemporada(){
        List<Anime> animeListTemp = new ArrayList<>();
        animeListTemp.add(new Anime("Tower of God", R.drawable.slide03,R.drawable.slide01));
        animeListTemp.add(new Anime("Tower of God", R.drawable.slide03,R.drawable.slide01));
        animeListTemp.add(new Anime("Tower of God", R.drawable.slide03,R.drawable.slide01));
        animeListTemp.add(new Anime("Tower of God", R.drawable.slide03,R.drawable.slide01));
        animeListTemp.add(new Anime("Tower of God", R.drawable.slide03,R.drawable.slide01));
        animeListTemp.add(new Anime("Tower of God", R.drawable.slide03,R.drawable.slide01));
        animeListTemp.add(new Anime("Tower of God", R.drawable.slide03,R.drawable.slide01));
        return animeListTemp;

    }
}
