package com.melisnurverir.covid_19;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import com.melisnurverir.covid_19.adapter.StoryRecyclerAdapter;

import java.util.ArrayList;
import java.util.Map;

public class ShareStoryActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore firebaseFirestore;
    ArrayList<String> userEmailFromFB;
    ArrayList<String> userTitleFromFB;
    ArrayList<String> userImageFromFB;
    ArrayList<String> userStoryFromFB;
    StoryRecyclerAdapter storyRecyclerAdapter;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.options_menu,menu);

        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.share){
            Intent shareIntent = new Intent(ShareStoryActivity.this,UploadActivity.class);
            startActivity(shareIntent);
        }
        else if (item.getItemId() == R.id.signout){
            firebaseAuth.signOut();

            Intent backMainIntent = new Intent(ShareStoryActivity.this,MainActivity.class);
            startActivity(backMainIntent);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_story);

        userStoryFromFB = new ArrayList<>();
        userTitleFromFB = new ArrayList<>();
        userEmailFromFB = new ArrayList<>();
        userImageFromFB = new ArrayList<>();

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

        getDataFromFirestore();

        // RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        storyRecyclerAdapter = new StoryRecyclerAdapter(userEmailFromFB,userTitleFromFB ,userStoryFromFB,userImageFromFB);
        recyclerView.setAdapter(storyRecyclerAdapter);
    }

    public void getDataFromFirestore(){
        CollectionReference collectionReference = firebaseFirestore.collection("Stories");
        collectionReference.orderBy("date", Query.Direction.DESCENDING).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                if (e != null){ // if error is not null, so there is an error
                    Toast.makeText(ShareStoryActivity.this, e.getLocalizedMessage().toString(), Toast.LENGTH_LONG).show();
                }
                if (queryDocumentSnapshots != null){
                    for (DocumentSnapshot documentSnapshot : queryDocumentSnapshots.getDocuments()){
                        Map<String,Object> data = documentSnapshot.getData();

                        String title = (String) data.get("title");
                        String story = (String) data.get("story");
                        String userEmail = (String) data.get("useremail");
                        String downloadUrl = (String) data.get("downloadurl");

                        userTitleFromFB.add(title);
                        userStoryFromFB.add(story);
                        userEmailFromFB.add(userEmail);
                        userImageFromFB.add(downloadUrl);

                        storyRecyclerAdapter.notifyDataSetChanged();
                    }
                }
            }
        });
    }
}