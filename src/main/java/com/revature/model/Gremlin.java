package com.revature.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Objects;

@JsonIgnoreProperties(value = { "id" })
public class Gremlin implements Serializable {


    private int id;
    private String name;
    private int age;
    private Color color;
    private boolean isEvil;

    public Gremlin() {}

    public Gremlin(String name, int age, Color color, boolean isEvil) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.isEvil = isEvil;
    }

    public int getId() {
        return id;
    }

    public Gremlin setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Gremlin setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Gremlin setAge(int age) {
        this.age = age;
        return this;
    }

    public Color getColor() {
        return color;
    }

    public Gremlin setColor(Color color) {
        this.color = color;
        return this;
    }

    public boolean isEvil() {
        return isEvil;
    }

    public Gremlin setEvil(boolean evil) {
        isEvil = evil;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gremlin gremlin = (Gremlin) o;
        return id == gremlin.id && age == gremlin.age && isEvil == gremlin.isEvil && Objects.equals(name, gremlin.name) && color == gremlin.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, color, isEvil);
    }

    @Override
    public String toString() {
        return "Gremlin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", color=" + color +
                ", isEvil=" + isEvil +
                '}';
    }
}
