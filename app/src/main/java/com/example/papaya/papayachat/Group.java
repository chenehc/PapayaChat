package com.example.papaya.papayachat;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class Group implements Serializable{
    private String groupName;
    private List<Contact> members;
    private int groupSize;

    public Group(String groupName){
        this.groupName = groupName;
        this.members = new ArrayList<>();
        this.groupSize = 0;
    }

    public Group(String groupName, List<Contact> members){
        this.groupName = groupName;
        this.members = members;
        this.groupSize = members.size();
    }

    public String getGroupName() {
        return groupName;
    }

    public void addMember(Contact member){
        members.add(member);
    }

    public void removeMember(Contact member){
        members.remove(member);
    }

    public Contact getMember(int index){
        return members.get(index);
    }

    public int getSize(){
        return groupSize;
    }

}
