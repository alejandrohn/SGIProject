/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;


public class User {

    private int id;
    private String firstName;
    private String surname;
    private String email;
    private String userName;
    private String password;

    public User(int id, String firstName, String surname, String email, String userName) {
        this.id = id;
        this.firstName = firstName;
        this.surname = surname;
        this.email = email;
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
