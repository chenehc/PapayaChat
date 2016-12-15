package com.example.papaya.papayachat;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.sa90.materialarcmenu.ArcMenu;

public class GroupChatActivity extends AppCompatActivity{
    private FloatingActionButton fabGallery, fabCamera, fabMic, fabDoc;
    private int leftIndex, rightIndex, position;
    private Intent startingIntent;
    private Group group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        startingIntent = getIntent();

        //Contact name
        String s = getIntent().getStringExtra("CONTACT_NAME");
        Log.i("name", s);
        setTitle(s);

        //The group that the contact belongs to
        group = (Group)getIntent().getSerializableExtra("GROUP");
        int maxGroupPosition = group.getSize() - 1;
        Log.i("group size", "group size is " + group.getSize());

        //Contact position in list
        position = getIntent().getExtras().getInt("POSITION");
        leftIndex = (position - 1 < 0) ? maxGroupPosition - (0 - position) % maxGroupPosition : (position - 1) % maxGroupPosition;
        rightIndex = (position + 1) % (maxGroupPosition + 1);
        Log.i("position", "position is" + position);
        Log.i("positionleft", "left is" + leftIndex);
        Log.i("positionRight", "right is" + rightIndex);

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

        ScrollView sv = (ScrollView) findViewById(R.id.scroll_view);
        sv.setOnTouchListener(new OnSwipeTouchListener(GroupChatActivity.this) {
            public void onSwipeRight() {
//                Toast.makeText(GroupChatActivity.this, "right", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent (GroupChatActivity.this, GroupChatActivity.class);
                intent.putExtra("CONTACT_NAME", group.getMember(leftIndex).getName());
                intent.putExtra("POSITION", leftIndex);
                intent.putExtra("GROUP", group);
                finish();
//                Bundle bndlanimation =
//                        ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.slide_right_in,R.anim.slide_right_out).toBundle();
                startActivity(intent);
//                overridePendingTransition(R.anim.slide_left_in, R.anim.slide_left_out);
            }
            public void onSwipeLeft() {
//                Toast.makeText(GroupChatActivity.this, "left", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent (GroupChatActivity.this, GroupChatActivity.class);
                intent.putExtra("CONTACT_NAME", group.getMember(rightIndex).getName());
                intent.putExtra("POSITION", rightIndex);
                intent.putExtra("GROUP", group);
                finish();
                startActivity(intent);

//                overridePendingTransition(R.anim.slide_left_in, R.anim.slide_left_out);

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
