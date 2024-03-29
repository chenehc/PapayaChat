package com.example.papaya.papayachat;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.sa90.materialarcmenu.ArcMenu;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity{
    private FloatingActionButton fabGallery, fabCamera, fabMic, fabDoc;
    private int leftIndex, rightIndex, position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        //Contact name
        String s = getIntent().getStringExtra("CONTACT_NAME");
        setTitle(s);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        fabGallery = (FloatingActionButton) findViewById(R.id.fab_gallery);
        fabCamera = (FloatingActionButton) findViewById(R.id.fab_cam);
        fabDoc = (FloatingActionButton) findViewById(R.id.fab_document);
        fabMic = (FloatingActionButton) findViewById(R.id.fab_mic);

        fabGallery.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (view.getId() == fabGallery.getId()) {
                    Toast.makeText(getApplicationContext(), "Open Gallery", Toast.LENGTH_LONG).show();
                }
            }
        });

        fabCamera.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (view.getId() == fabCamera.getId()) {
                    Toast.makeText(getApplicationContext(), "Open Camera", Toast.LENGTH_LONG).show();
                }
            }
        });

        fabDoc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (view.getId() == fabDoc.getId()) {
                    Toast.makeText(getApplicationContext(), "Open Documents", Toast.LENGTH_LONG).show();
                }
            }
        });

        fabMic.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (view.getId() == fabMic.getId()) {
                    Toast.makeText(getApplicationContext(), "Open Mic", Toast.LENGTH_LONG).show();
                }
            }
        });

        final ArcMenu arcMenu = (ArcMenu) findViewById(R.id.arcMenu);
        final LinearLayout lv = (LinearLayout) findViewById(R.id.arc_layout);
        lv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (arcMenu.isMenuOpened() == true) {
                    arcMenu.toggleMenu();
                    Toast.makeText(getApplicationContext(), "Close", Toast.LENGTH_LONG).show();
                }
            }
        });

        arcMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                if (view.getId() == arcMenu.getId()){
                    Toast.makeText(getApplicationContext(), "Open", Toast.LENGTH_LONG).show();
            }
        }
    });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem)
    {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }
}
