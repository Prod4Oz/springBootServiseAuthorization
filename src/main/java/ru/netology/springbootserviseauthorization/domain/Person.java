package ru.netology.springbootserviseauthorization.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

public class Person {
    @NotBlank
    @Size(min = 2, max = 20)
    private String userName;
    @NotBlank
    @Size(min = 2, max = 20)
    private String userPassword;

    public Person() {
    }

    public Person(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return "Person{" +
                "userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(userName, person.userName) && Objects.equals(userPassword, person.userPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, userPassword);
    }
}
