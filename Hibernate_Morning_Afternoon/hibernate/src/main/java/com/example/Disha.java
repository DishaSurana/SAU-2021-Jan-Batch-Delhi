package com.example;

import com.sun.istack.Nullable;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Disha {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    int id;

    String color;
    String address;

//    @Transient
//    @ColumnDefault("-1")
    int age;

//    @OneToOne
//    private Alien alien;

    @Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
    @OneToMany
    private List<Alien> alienList = new ArrayList<>();

//    public Alien getAlien() {
//        return alien;
//    }
//
//    public void setAlien(Alien alien) {
//        this.alien = alien;
//    }

    public List<Alien> getAlienList() {
        return alienList;
    }

    public void setAlienList(List<Alien> alienList) {
        this.alienList = alienList;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Disha(){

    }

    public Disha(String color, String address) {
        this.id = id;
        this.color = color;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return "Disha{" +
                "id=" + id +
                ", color='" + color + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", alienList=" + alienList +
                '}';
    }
}
