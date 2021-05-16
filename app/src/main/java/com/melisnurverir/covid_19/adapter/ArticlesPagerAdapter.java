package com.melisnurverir.covid_19.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.melisnurverir.covid_19.R;
import com.melisnurverir.covid_19.model.DetailsArticle;

import java.util.List;

public class ArticlesPagerAdapter extends PagerAdapter {

    Context context;
    List<DetailsArticle> detailsArticleList;

    public ArticlesPagerAdapter(Context context, List<DetailsArticle> detailsArticleList) {
        this.context = context;
        this.detailsArticleList = detailsArticleList;
    }

    @Override
    public int getCount() {
        return detailsArticleList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.articles_layout,null);

        ImageView articleImage = view.findViewById(R.id.article_image);

        Glide.with(context).load(detailsArticleList.get(position).getImageUrl()).into(articleImage);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
