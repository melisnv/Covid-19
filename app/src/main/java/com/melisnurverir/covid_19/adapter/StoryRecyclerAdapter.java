package com.melisnurverir.covid_19.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.melisnurverir.covid_19.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class StoryRecyclerAdapter extends RecyclerView.Adapter<StoryRecyclerAdapter.StoryHolder> {

    private ArrayList<String> userEmailList;
    private ArrayList<String> userTitleList;
    private ArrayList<String> userStoryList;
    private ArrayList<String> userImageList;

    public StoryRecyclerAdapter(ArrayList<String> userEmailList,ArrayList<String> userTitleList, ArrayList<String> userStoryList, ArrayList<String> userImageList) {
        this.userEmailList = userEmailList;
        this.userStoryList = userStoryList;
        this.userImageList = userImageList;
        this.userTitleList= userTitleList;
    }

    @NonNull
    @Override
    public StoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recycler_row,parent,false);
        return new StoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoryHolder holder, int position) {
        holder.userNameTxt.setText(userEmailList.get(position));
        holder.userStoryTxt.setText(userStoryList.get(position));
        holder.userTitleTxt.setText(userTitleList.get(position));
        Picasso.get().load(userImageList.get(position)).into(holder.userImageView);
    }

    @Override
    public int getItemCount() {
        return userEmailList.size();
    }

    class StoryHolder extends RecyclerView.ViewHolder{

        ImageView userImageView;
        TextView userStoryTxt;
        TextView userNameTxt;
        TextView userTitleTxt;

        public StoryHolder(@NonNull View itemView) {
            super(itemView);

            userImageView = itemView.findViewById(R.id.row_imageview);
            userStoryTxt = itemView.findViewById(R.id.story_user);
            userNameTxt = itemView.findViewById(R.id.story_userEmail);
            userTitleTxt = itemView.findViewById(R.id.userTitle_text);

        }
    }
}
