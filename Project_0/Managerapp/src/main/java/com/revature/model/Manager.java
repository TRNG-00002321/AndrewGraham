package com.revature.model;

public class Manager implements Comparable<Manager>{

    private String name;
    private String username;
    private String password;

    public Manager() {
    }

    public Manager(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public boolean Login(String username, String password){
        return this.username.equals(username) && this.password.equals(password);
    }

    @Override
    public int compareTo(Manager o) {
        return this.username.compareTo(o.username);
    }
}
