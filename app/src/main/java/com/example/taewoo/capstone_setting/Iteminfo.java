package com.example.taewoo.capstone_setting;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Iteminfo extends AppCompatActivity {
    Context context;
    private ArrayList<Item> arrayList;
    String title;
    String content;
    String downloadURL;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        context = getApplicationContext();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iteminfo);

        //TextView textView1 = (TextView) findViewById(R.id.textView1);
        //TextView textView2 = (TextView) findViewById(R.id.textView2);
        ImageView imageView = (ImageView) findViewById(R.id.imageview);

        title = (String) getIntent().getSerializableExtra("TITLE");
        Log.d("제발요", this.title);
        //content = (String) getIntent().getSerializableExtra("CONTENT");
        arrayList = (ArrayList<Item>) getIntent().getSerializableExtra("LIST");
        //textView1.setText(title);
        //textView2.setText(content);
        for (Item board : arrayList) {
            if (board.title.equals(this.title)) {
                //position = arrayList.get
                this.downloadURL = board.downloadURL;
                //textView1.setText(board.getTitle());
                Log.d("filename : ", this.downloadURL);
            }
        }
        Picasso.with(context).load(downloadURL).fit().centerInside().into(imageView);
    }
}