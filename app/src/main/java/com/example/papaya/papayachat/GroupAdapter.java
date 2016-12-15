package com.example.papaya.papayachat;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

import java.util.List;

public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.MyViewHolder> {

    public interface OnItemClickListener{
        void onItemClick(String item);
    }

    private static List<Group> mGroupList;
    private static OnItemClickListener mListener;
    private static Context mContext;
    private static GroupFragment mgFrag;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        protected CardView mCardView;
        protected ImageView mContact1ImageView;
        protected ImageView mContact2ImageView;
        protected ImageView mContact3ImageView;
        protected ImageView mContact4ImageView;
        protected ImageView mContact5ImageView;
        protected ImageView mContact6ImageView;
        protected ImageView mContact7ImageView;
        protected ImageView mContact8ImageView;
        protected ImageView mContact9ImageView;
        protected TextView mGroupName;
        protected Group mGroup;
        protected Button mButton;
        protected ExpandableRelativeLayout expandableLayout1;
        protected ImageView mAddToGroup;

        public MyViewHolder(View v, final OnItemClickListener listener) {
            super(v);

            mCardView = (CardView) v.findViewById(R.id.group_card_view);
            mContact1ImageView = (ImageView) v.findViewById(R.id.group_contact_1_image);
            mContact2ImageView = (ImageView) v.findViewById(R.id.group_contact_2_image);
            mContact3ImageView = (ImageView) v.findViewById(R.id.group_contact_3_image);
            mContact4ImageView = (ImageView) v.findViewById(R.id.group_contact_4_image);
            mContact5ImageView = (ImageView) v.findViewById(R.id.group_contact_5_image);
            mContact6ImageView = (ImageView) v.findViewById(R.id.group_contact_6_image);
            mContact7ImageView = (ImageView) v.findViewById(R.id.group_contact_7_image);
            mContact8ImageView = (ImageView) v.findViewById(R.id.group_contact_8_image);
            mContact9ImageView = (ImageView) v.findViewById(R.id.group_contact_9_image);
            mGroupName = (TextView) v.findViewById(R.id.group_name);
            mButton = (Button) v.findViewById(R.id.expandableButton1);
            expandableLayout1 = (ExpandableRelativeLayout) v.findViewById(R.id.expandableLayout1);
            mAddToGroup = (ImageView) v.findViewById(R.id.add_to_group);

            mContact1ImageView.setOnClickListener(this);
            mContact2ImageView.setOnClickListener(this);
            mContact3ImageView.setOnClickListener(this);
            mContact4ImageView.setOnClickListener(this);
            mContact5ImageView.setOnClickListener(this);
            mContact6ImageView.setOnClickListener(this);
            mContact7ImageView.setOnClickListener(this);
            mContact8ImageView.setOnClickListener(this);
            mContact9ImageView.setOnClickListener(this);
            mAddToGroup.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (v.getId() == mAddToGroup.getId()){
                // get prompts.xml view
                LayoutInflater li = LayoutInflater.from(mContext);
                View promptsView = li.inflate(R.layout.prompt, null);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        mContext);

                // set prompts.xml to alertdialog builder
                alertDialogBuilder.setView(promptsView);

                final EditText userInput = (EditText) promptsView
                        .findViewById(R.id.editTextDialogUserInput);

                // set dialog message
                alertDialogBuilder
                        .setCancelable(false)
                        .setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        // get user input
                                        mgFrag.addToGroup(mGroup, userInput.getText().toString());
                                        bind(mGroup, mListener);
                                    }
                                })
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        dialog.cancel();
                                    }
                                });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();

                return;
            }

            Intent intent = null;
            //TODO optimize by removing putExtra contact_name, GroupChatActivity already has position to determine name
            if (v.getId() == mContact1ImageView.getId()) {
//                Toast.makeText(mContext, "Contact1 Clicked!", Toast.LENGTH_LONG).show();
                 intent = new Intent(mContext, GroupChatActivity.class);
                intent.putExtra("CONTACT_NAME", mGroup.getMember(0).getName());
                intent.putExtra("POSITION", 0);
            } else if (v.getId() == mContact2ImageView.getId()) {
//                Toast.makeText(mContext, "Contact2 Clicked!", Toast.LENGTH_LONG).show();
                 intent = new Intent(mContext, GroupChatActivity.class);
                intent.putExtra("CONTACT_NAME", mGroup.getMember(1).getName());
                intent.putExtra("POSITION", 1);
            } else if (v.getId() == mContact3ImageView.getId()) {
//                Toast.makeText(mContext, "Contact3 Clicked!", Toast.LENGTH_LONG).show();
                 intent = new Intent(mContext, GroupChatActivity.class);
                intent.putExtra("CONTACT_NAME", mGroup.getMember(2).getName());
                intent.putExtra("POSITION", 2);
            } else if (v.getId() == mContact4ImageView.getId()) {
//                Toast.makeText(mContext, "Contact4 Clicked!", Toast.LENGTH_LONG).show();
                 intent = new Intent(mContext, GroupChatActivity.class);
                intent.putExtra("CONTACT_NAME", mGroup.getMember(3).getName());
                intent.putExtra("POSITION", 3);
            } else if (v.getId() == mContact5ImageView.getId()) {
//                Toast.makeText(mContext, "Contact5 Clicked!", Toast.LENGTH_LONG).show();
                 intent = new Intent(mContext, GroupChatActivity.class);
                intent.putExtra("CONTACT_NAME", mGroup.getMember(4).getName());
                intent.putExtra("POSITION", 4);
            } else if (v.getId() == mContact6ImageView.getId()) {
//                Toast.makeText(mContext, "Contact6 Clicked!", Toast.LENGTH_LONG).show();
                 intent = new Intent(mContext, GroupChatActivity.class);
                intent.putExtra("CONTACT_NAME", mGroup.getMember(5).getName());
                intent.putExtra("POSITION", 5);
            } else if (v.getId() == mContact7ImageView.getId()) {
//                Toast.makeText(mContext, "Contact7 Clicked!", Toast.LENGTH_LONG).show();
                 intent = new Intent(mContext, GroupChatActivity.class);
                intent.putExtra("CONTACT_NAME", mGroup.getMember(6).getName());
                intent.putExtra("POSITION", 6);
            } else if (v.getId() == mContact8ImageView.getId()) {
//                Toast.makeText(mContext, "Contact8 Clicked!", Toast.LENGTH_LONG).show();
                 intent = new Intent(mContext, GroupChatActivity.class);
                intent.putExtra("CONTACT_NAME", mGroup.getMember(7).getName());
                intent.putExtra("POSITION", 7);
            } else if (v.getId() == mContact9ImageView.getId()) {
//                Toast.makeText(mContext, "Contact9 Clicked!", Toast.LENGTH_LONG).show();
                 intent = new Intent(mContext, GroupChatActivity.class);
                intent.putExtra("CONTACT_NAME", mGroup.getMember(8).getName());
                intent.putExtra("POSITION", 8);
            }
            intent.putExtra("GROUP", mGroup);
            mContext.startActivity(intent);
        }

        //set onClick action here
        public void bind(final Group group, final OnItemClickListener listener) {
            mGroup = group;
            mGroupName.setText(group.getGroupName());

            switch(mGroup.getSize()) {
                case 1:
                    mContact1ImageView.setImageResource(mContext.getResources().getIdentifier(group.getMember(0).getProfileIcon(), "drawable", mContext.getPackageName()));
                    mContact1ImageView.setVisibility(View.VISIBLE);
                    break;
                case 2:
                    mContact1ImageView.setImageResource(mContext.getResources().getIdentifier(group.getMember(0).getProfileIcon(), "drawable", mContext.getPackageName()));
                    mContact1ImageView.setVisibility(View.VISIBLE);
                    mContact2ImageView.setImageResource(mContext.getResources().getIdentifier(group.getMember(1).getProfileIcon(), "drawable", mContext.getPackageName()));
                    mContact2ImageView.setVisibility(View.VISIBLE);
                    break;
                case 3:
                    mContact1ImageView.setImageResource(mContext.getResources().getIdentifier(group.getMember(0).getProfileIcon(), "drawable", mContext.getPackageName()));
                    mContact1ImageView.setVisibility(View.VISIBLE);
                    mContact2ImageView.setImageResource(mContext.getResources().getIdentifier(group.getMember(1).getProfileIcon(), "drawable", mContext.getPackageName()));
                    mContact2ImageView.setVisibility(View.VISIBLE);
                    mContact3ImageView.setImageResource(mContext.getResources().getIdentifier(group.getMember(2).getProfileIcon(), "drawable", mContext.getPackageName()));
                    mContact3ImageView.setVisibility(View.VISIBLE);
                    break;
                case 4:
                    mContact1ImageView.setImageResource(mContext.getResources().getIdentifier(group.getMember(0).getProfileIcon(), "drawable", mContext.getPackageName()));
                    mContact1ImageView.setVisibility(View.VISIBLE);
                    mContact2ImageView.setImageResource(mContext.getResources().getIdentifier(group.getMember(1).getProfileIcon(), "drawable", mContext.getPackageName()));
                    mContact2ImageView.setVisibility(View.VISIBLE);
                    mContact3ImageView.setImageResource(mContext.getResources().getIdentifier(group.getMember(2).getProfileIcon(), "drawable", mContext.getPackageName()));
                    mContact3ImageView.setVisibility(View.VISIBLE);
                    mContact4ImageView.setImageResource(mContext.getResources().getIdentifier(group.getMember(3).getProfileIcon(), "drawable", mContext.getPackageName()));
                    mContact4ImageView.setVisibility(View.VISIBLE);
                    break;
                case 5:
                    mContact1ImageView.setImageResource(mContext.getResources().getIdentifier(group.getMember(0).getProfileIcon(), "drawable", mContext.getPackageName()));
                    mContact1ImageView.setVisibility(View.VISIBLE);
                    mContact2ImageView.setImageResource(mContext.getResources().getIdentifier(group.getMember(1).getProfileIcon(), "drawable", mContext.getPackageName()));
                    mContact2ImageView.setVisibility(View.VISIBLE);
                    mContact3ImageView.setImageResource(mContext.getResources().getIdentifier(group.getMember(2).getProfileIcon(), "drawable", mContext.getPackageName()));
                    mContact3ImageView.setVisibility(View.VISIBLE);
                    mContact4ImageView.setImageResource(mContext.getResources().getIdentifier(group.getMember(3).getProfileIcon(), "drawable", mContext.getPackageName()));
                    mContact4ImageView.setVisibility(View.VISIBLE);
                    mContact5ImageView.setImageResource(mContext.getResources().getIdentifier(group.getMember(4).getProfileIcon(), "drawable", mContext.getPackageName()));
                    mContact5ImageView.setVisibility(View.VISIBLE);
                    break;
                case 6:
                    mContact1ImageView.setImageResource(mContext.getResources().getIdentifier(group.getMember(0).getProfileIcon(), "drawable", mContext.getPackageName()));
                    mContact1ImageView.setVisibility(View.VISIBLE);
                    mContact2ImageView.setImageResource(mContext.getResources().getIdentifier(group.getMember(1).getProfileIcon(), "drawable", mContext.getPackageName()));
                    mContact2ImageView.setVisibility(View.VISIBLE);
                    mContact3ImageView.setImageResource(mContext.getResources().getIdentifier(group.getMember(2).getProfileIcon(), "drawable", mContext.getPackageName()));
                    mContact3ImageView.setVisibility(View.VISIBLE);
                    mContact4ImageView.setImageResource(mContext.getResources().getIdentifier(group.getMember(3).getProfileIcon(), "drawable", mContext.getPackageName()));
                    mContact4ImageView.setVisibility(View.VISIBLE);
                    mContact5ImageView.setImageResource(mContext.getResources().getIdentifier(group.getMember(4).getProfileIcon(), "drawable", mContext.getPackageName()));
                    mContact5ImageView.setVisibility(View.VISIBLE);
                    mContact6ImageView.setImageResource(mContext.getResources().getIdentifier(group.getMember(5).getProfileIcon(), "drawable", mContext.getPackageName()));
                    mContact6ImageView.setVisibility(View.VISIBLE);
                    break;
                case 7:
                    mContact1ImageView.setImageResource(mContext.getResources().getIdentifier(group.getMember(0).getProfileIcon(), "drawable", mContext.getPackageName()));
                    mContact1ImageView.setVisibility(View.VISIBLE);
                    mContact2ImageView.setImageResource(mContext.getResources().getIdentifier(group.getMember(1).getProfileIcon(), "drawable", mContext.getPackageName()));
                    mContact2ImageView.setVisibility(View.VISIBLE);
                    mContact3ImageView.setImageResource(mContext.getResources().getIdentifier(group.getMember(2).getProfileIcon(), "drawable", mContext.getPackageName()));
                    mContact3ImageView.setVisibility(View.VISIBLE);
                    mContact4ImageView.setImageResource(mContext.getResources().getIdentifier(group.getMember(3).getProfileIcon(), "drawable", mContext.getPackageName()));
                    mContact4ImageView.setVisibility(View.VISIBLE);
                    mContact5ImageView.setImageResource(mContext.getResources().getIdentifier(group.getMember(4).getProfileIcon(), "drawable", mContext.getPackageName()));
                    mContact5ImageView.setVisibility(View.VISIBLE);
                    mContact6ImageView.setImageResource(mContext.getResources().getIdentifier(group.getMember(5).getProfileIcon(), "drawable", mContext.getPackageName()));
                    mContact6ImageView.setVisibility(View.VISIBLE);
                    mContact7ImageView.setImageResource(mContext.getResources().getIdentifier(group.getMember(6).getProfileIcon(), "drawable", mContext.getPackageName()));
                    mContact7ImageView.setVisibility(View.VISIBLE);
                    break;
                case 8:
                    mContact1ImageView.setImageResource(mContext.getResources().getIdentifier(group.getMember(0).getProfileIcon(), "drawable", mContext.getPackageName()));
                    mContact1ImageView.setVisibility(View.VISIBLE);
                    mContact2ImageView.setImageResource(mContext.getResources().getIdentifier(group.getMember(1).getProfileIcon(), "drawable", mContext.getPackageName()));
                    mContact2ImageView.setVisibility(View.VISIBLE);
                    mContact3ImageView.setImageResource(mContext.getResources().getIdentifier(group.getMember(2).getProfileIcon(), "drawable", mContext.getPackageName()));
                    mContact3ImageView.setVisibility(View.VISIBLE);
                    mContact4ImageView.setImageResource(mContext.getResources().getIdentifier(group.getMember(3).getProfileIcon(), "drawable", mContext.getPackageName()));
                    mContact4ImageView.setVisibility(View.VISIBLE);
                    mContact5ImageView.setImageResource(mContext.getResources().getIdentifier(group.getMember(4).getProfileIcon(), "drawable", mContext.getPackageName()));
                    mContact5ImageView.setVisibility(View.VISIBLE);
                    mContact6ImageView.setImageResource(mContext.getResources().getIdentifier(group.getMember(5).getProfileIcon(), "drawable", mContext.getPackageName()));
                    mContact6ImageView.setVisibility(View.VISIBLE);
                    mContact7ImageView.setImageResource(mContext.getResources().getIdentifier(group.getMember(6).getProfileIcon(), "drawable", mContext.getPackageName()));
                    mContact7ImageView.setVisibility(View.VISIBLE);
                    mContact8ImageView.setImageResource(mContext.getResources().getIdentifier(group.getMember(7).getProfileIcon(), "drawable", mContext.getPackageName()));
                    mContact8ImageView.setVisibility(View.VISIBLE);
                    break;
                case 9:
                    mContact1ImageView.setImageResource(mContext.getResources().getIdentifier(group.getMember(0).getProfileIcon(), "drawable", mContext.getPackageName()));
                    mContact1ImageView.setVisibility(View.VISIBLE);
                    mContact2ImageView.setImageResource(mContext.getResources().getIdentifier(group.getMember(1).getProfileIcon(), "drawable", mContext.getPackageName()));
                    mContact2ImageView.setVisibility(View.VISIBLE);
                    mContact3ImageView.setImageResource(mContext.getResources().getIdentifier(group.getMember(2).getProfileIcon(), "drawable", mContext.getPackageName()));
                    mContact3ImageView.setVisibility(View.VISIBLE);
                    mContact4ImageView.setImageResource(mContext.getResources().getIdentifier(group.getMember(3).getProfileIcon(), "drawable", mContext.getPackageName()));
                    mContact4ImageView.setVisibility(View.VISIBLE);
                    mContact5ImageView.setImageResource(mContext.getResources().getIdentifier(group.getMember(4).getProfileIcon(), "drawable", mContext.getPackageName()));
                    mContact5ImageView.setVisibility(View.VISIBLE);
                    mContact6ImageView.setImageResource(mContext.getResources().getIdentifier(group.getMember(5).getProfileIcon(), "drawable", mContext.getPackageName()));
                    mContact6ImageView.setVisibility(View.VISIBLE);
                    mContact7ImageView.setImageResource(mContext.getResources().getIdentifier(group.getMember(6).getProfileIcon(), "drawable", mContext.getPackageName()));
                    mContact7ImageView.setVisibility(View.VISIBLE);
                    mContact8ImageView.setImageResource(mContext.getResources().getIdentifier(group.getMember(7).getProfileIcon(), "drawable", mContext.getPackageName()));
                    mContact8ImageView.setVisibility(View.VISIBLE);
                    mContact9ImageView.setImageResource(mContext.getResources().getIdentifier(group.getMember(8).getProfileIcon(), "drawable", mContext.getPackageName()));
                    mContact9ImageView.setVisibility(View.VISIBLE);
                    break;
            }

            mButton.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    expandableLayout1.toggle();
                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
//                        listener.onItemClick(group.getGroupName());
                }
            });
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public GroupAdapter(List<Group> groupList, OnItemClickListener listener, Context context, GroupFragment gFrag) {
        mGroupList = groupList;
        mListener = listener;
        mContext = context;
        mgFrag = gFrag;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public GroupAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                          int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_group_list, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v, mListener);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.bind(mGroupList.get(position), mListener);
    }

    @Override
    public int getItemCount() {
        return mGroupList.size();
    }
}
