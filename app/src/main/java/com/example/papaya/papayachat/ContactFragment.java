package com.example.papaya.papayachat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class ContactFragment extends Fragment {
    List<Contact> contactList;
    
    public ContactFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contactList = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_contacts, container, false);

        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.contacts_recycler_view);
        rv.setHasFixedSize(true);
        Contact contact1 = new Contact("Dave Zimmerman");
        Contact contact2 = new Contact("Priscilla Chen");
        Contact contact3 = new Contact("Vijay Dinanath Chauhan");
        Contact contact4 = new Contact("Josephine Natum");
        Contact contact5 = new Contact("Jordan A");
        contactList.add(contact1);
        contactList.add(contact2);
        contactList.add(contact3);
        contactList.add(contact4);
        contactList.add(contact5);

        ContactAdapter adapter = new ContactAdapter(contactList, new ContactAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String item) {
//                Toast.makeText(getContext(), "Item Clicked" + item, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getActivity(), ChatActivity.class);
                intent.putExtra("CONTACT_NAME", item);
                startActivity(intent);
            }}, getContext());
        rv.setAdapter(adapter);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);

        return rootView;
    }

    public void addContact(String name){
        Contact newContact = new Contact(name);
        contactList.add(newContact);
        Toast.makeText(getContext(), "Added new contact, " + name, Toast.LENGTH_LONG).show();
    }

}