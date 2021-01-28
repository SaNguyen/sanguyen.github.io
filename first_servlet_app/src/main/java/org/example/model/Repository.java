package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    private List<User> userList;

    public Repository() {
        this.userList = new ArrayList<User>();
        userList.add(new User("sa","1"));
        userList.add(new User("do","2"));
    }
    public boolean findUser(String name, String pass){
        User user = new User(name, pass);
        return userList.contains(user);
    }

    public boolean findUser(User user){
        return userList.contains(user);
    }

}
