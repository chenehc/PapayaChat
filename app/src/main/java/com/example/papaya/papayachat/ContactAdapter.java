package com.example.papaya.papayachat;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
        import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.MyViewHolder> {

    public interface OnItemClickListener{
        void onItemClick(String item);
    }

    private List<Contact> mContactList;
    private OnItemClickListener mListener;
    private static Context mContext;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public CardView mCardView;
        public ImageView mProfileImageView;
        public TextView mNameTextView;

        public MyViewHolder(View v) {
            super(v);

            mCardView = (CardView) v.findViewById(R.id.card_view);
            mProfileImageView = (ImageView) v.findViewById(R.id.contact_image);
            mNameTextView = (TextView) v.findViewById(R.id.contact_name);
        }

        public void bind(final Contact item, final OnItemClickListener listener) {
            mNameTextView.setText(item.getName());
            mProfileImageView.setImageResource(mContext.getResources().getIdentifier(item.getProfileIcon(), "drawable", mContext.getPackageName()));
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(item.getName());
                }
            });
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ContactAdapter(List<Contact> myContactList, OnItemClickListener listener, Context context) {
        mContactList = myContactList;
        mListener = listener;
        mContext = context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ContactAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {

        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_contact_list, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.bind(mContactList.get(position), mListener);
    }

    @Override
    public int getItemCount() {
        return mContactList.size();
    }
}