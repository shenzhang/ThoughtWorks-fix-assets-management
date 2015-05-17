package com.thoughtworks.fam.domain;

public class User {

    private String name;

    private String email;

    private String password;

    public User() {

    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.password = "P@ss123456";
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = "P@ss123456";
    }

    public User(String name) {
        this.name = name;
        this.password = "P@ss123456";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean authenticate(String password) {
        return this.password.equals(password);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (name != null ? !name.equals(user.name) : user.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
