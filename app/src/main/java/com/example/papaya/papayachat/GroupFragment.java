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

public class GroupFragment extends Fragment{
    List<Group> groupList;

    public GroupFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        groupList = new ArrayList<>();
    }

    public void addGroup(String name){
        Group newGroup = new Group(name);
        groupList.add(newGroup);
        Toast.makeText(getContext(), "Added group " + name, Toast.LENGTH_LONG).show();
    }

    public void addToGroup(Group group, String name){
        if (group.getSize() >= 9){
            Toast.makeText(getContext(), "Group is full", Toast.LENGTH_LONG).show();
        }else {
            Contact newContact = new Contact(name);
            group.addMember(newContact);
            Toast.makeText(getContext(), name + " added to " + group.getGroupName(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_group, container, false);

        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.groups_recycler_view);
        rv.setHasFixedSize(true);
        List<Contact> contacts = new ArrayList<>();
        List<Contact> contacts2 = new ArrayList<>();
        Contact contact1 = new Contact("Dave Zimmerman");
        Contact contact2 = new Contact("Priscilla Chen");
        Contact contact3 = new Contact("Vijay Dinanath Chauhan");
        Contact contact4 = new Contact("Josephine Natum");
        Contact contact5 = new Contact("Jordan A");
        contacts.add(contact1);
        contacts.add(contact2);
        contacts.add(contact3);
        contacts2.add(contact1);
        contacts2.add(contact2);
        contacts2.add(contact3);
        contacts2.add(contact4);
        contacts2.add(contact5);
        Group group1 = new Group("Acquaintances", contacts);
        Group group2 = new Group("Family", contacts2);
        groupList.add(group1);
        groupList.add(group2);
        GroupAdapter adapter = new GroupAdapter(groupList, new GroupAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String item) {
//                Toast.makeText(getContext(), "Item Clicked" + item, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getActivity(), ChatActivity.class);
                startActivity(intent);
            }}, getContext(), this);
        rv.setAdapter(adapter);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);

        return rootView;
    }

}