package com.melisnurverir.covid_19;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.melisnurverir.covid_19.adapter.ArticlesPagerAdapter;
import com.melisnurverir.covid_19.model.DetailsArticle;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Articles extends AppCompatActivity {

    ArticlesPagerAdapter articlesPagerAdapter;
    TabLayout tabIndicator,categoryTab;
    ViewPager articlesViewPager;
    List<DetailsArticle> detailsArticleList;
    List<DetailsArticle> childrenArticleList;
    List<DetailsArticle> vaccineArticleList;
    List<DetailsArticle> mentalArticleList;
    List<DetailsArticle> socialArticleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articles);

        tabIndicator = findViewById(R.id.tab_indicator);
        categoryTab = findViewById(R.id.tablayout);


        vaccineArticleList = new ArrayList<>();
        vaccineArticleList.add(new DetailsArticle(1,"WHO Lists COVID-19 Vaccine for Emergency Use",
                "https://firebasestorage.googleapis.com/v0/b/covid-19-2611d.appspot.com/o/vaccine.jpg?alt=media&token=2ac49f00-65da-47a0-a722-f06f7647351f",""));
        vaccineArticleList.add(new DetailsArticle(2,"Astra-Zeneca Vaccine and Information",
                "https://firebasestorage.googleapis.com/v0/b/covid-19-2611d.appspot.com/o/vaccine2.jpg?alt=media&token=e028dc9e-dd41-4281-a46d-82d67d26fa16",""));
        vaccineArticleList.add(new DetailsArticle(3,"Protein Type of Covid-19",
                "https://firebasestorage.googleapis.com/v0/b/covid-19-2611d.appspot.com/o/vaccine3.jpg?alt=media&token=bf8ab346-da1d-4e98-ab96-f817478e2527",""));


        childrenArticleList = new ArrayList<>();
        childrenArticleList.add(new DetailsArticle(1,"COVID-19 in Children and Teens",
                "https://firebasestorage.googleapis.com/v0/b/covid-19-2611d.appspot.com/o/children_effects.jpg?alt=media&token=442b054c-e39e-4c62-8aa9-56ec114b11ac",""));
        childrenArticleList.add(new DetailsArticle(2,"Online Education and Children",
                "https://firebasestorage.googleapis.com/v0/b/covid-19-2611d.appspot.com/o/children_effects2.jpg?alt=media&token=096157c6-7f22-4cdc-872a-6d478f2c9717",""));

        socialArticleList = new ArrayList<>();
        socialArticleList.add(new DetailsArticle(1,"Impact of COVID-19 on people's livelihoods",
                "https://firebasestorage.googleapis.com/v0/b/covid-19-2611d.appspot.com/o/social_life.jpg?alt=media&token=ec121b2b-f293-4f9b-8ecd-0e772081f4f5",""));
        socialArticleList.add(new DetailsArticle(2,"Impact of COVID-19 on people's livelihoods",
                "https://firebasestorage.googleapis.com/v0/b/covid-19-2611d.appspot.com/o/alone_covid.jpg?alt=media&token=8660600c-66ce-4405-b9e6-1ad955d2b7e4",""));

        mentalArticleList = new ArrayList<>();
        mentalArticleList.add(new DetailsArticle(1,"Mental health and COVID-19",
                "https://firebasestorage.googleapis.com/v0/b/covid-19-2611d.appspot.com/o/psychological_effect.jpg?alt=media&token=ddb8c93b-8df5-4414-a530-70eeef544006",""));

        //setArticlesPagerAdapter(vaccineArticleList);

        categoryTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 1:
                        setArticlesPagerAdapter(childrenArticleList);
                        return;
                    case 2:
                        setArticlesPagerAdapter(socialArticleList);
                        return;
                    case 3:
                        setArticlesPagerAdapter(mentalArticleList);
                        return;
                    default:
                        setArticlesPagerAdapter(vaccineArticleList);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setArticlesPagerAdapter(List<DetailsArticle> detailsArticleList) {
        articlesViewPager = findViewById(R.id.article_viewpager);
        articlesPagerAdapter = new ArticlesPagerAdapter(this,detailsArticleList);
        articlesViewPager.setAdapter(articlesPagerAdapter);
        tabIndicator.setupWithViewPager(articlesViewPager);

        Timer sliderTimer = new Timer();
        sliderTimer.scheduleAtFixedRate(new AutoSlider(),4000,6000);
        tabIndicator.setupWithViewPager(articlesViewPager,true);
    }

    class AutoSlider extends TimerTask {

        @Override
        public void run() {
            Articles.this.runOnUiThread(() -> {
                if (articlesViewPager.getCurrentItem() < childrenArticleList.size() - 1){
                    articlesViewPager.setCurrentItem(articlesViewPager.getCurrentItem() + 1);
                } else {
                    articlesViewPager.setCurrentItem(0);
                }
            });
        }
    }
}