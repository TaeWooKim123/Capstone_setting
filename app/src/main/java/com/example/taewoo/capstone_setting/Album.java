package com.example.taewoo.capstone_setting;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Album extends AppCompatActivity {
    RecyclerAdapter adapter;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_main);
        init();
        getData();
    }
    private void init(){  //리사이클러뷰 초기화 및 동작
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        //LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        //recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new RecyclerAdapter(this);
        recyclerView.setAdapter(adapter);
    }
    private void getData(){
        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        database.child("message").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Item board = dataSnapshot.getValue(Item.class);
                //board.setTitle(board.getTitle());
                //board.setContent(board.getContent());
                //System.out.printf("김태우 파일네임 : %s", board.getFilename());
                adapter.addItem(board);
                //adapter.add(board.getContent());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
