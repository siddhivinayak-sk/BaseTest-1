/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 *
 * @author sandeep.kumar
 */
public class POJOEX {
}

class Employee {
    private Long id;
    private String name;
    private Double salary;
    
    public Employee() {}
    public Employee(Long id, String name, Double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}

class Student {
    private Integer roll;
    private String name;
    private Double marks;
    private Set<String> books;
    
    public Student() {}
    
    public Student(Integer roll, String name, Double marks) {
        this.roll = roll;
        this.name = name;
        this.marks = marks;
        books = new HashSet<String>();
    }

    public Integer getRoll() {
        return roll;
    }

    public void setRoll(Integer roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMarks() {
        return marks;
    }

    public void setMarks(Double marks) {
        this.marks = marks;
    }

    public Set<String> getBooks() {
        return books;
    }

    public void setBooks(Set<String> books) {
        this.books = books;
    }
}

class ScreenResolution {
    private int width;
    private int height;
    
    public ScreenResolution() {}
    
    public ScreenResolution(int w, int h) {
        this.width = w;
        this.height = h;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}

class DisplayFeatures {
    private String size;
    private Optional<ScreenResolution> resolution;

    public DisplayFeatures() {
    }

    public DisplayFeatures(String size, Optional<ScreenResolution> resolution) {
        this.size = size;
        this.resolution = resolution;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Optional<ScreenResolution> getResolution() {
        return resolution;
    }

    public void setResolution(Optional<ScreenResolution> resolution) {
        this.resolution = resolution;
    }
}

class Mobile {
    private long id;
    private String name;
    private String brand;
    private Optional<DisplayFeatures> displayFeature;

    public Mobile() {
    }

    public Mobile(long id, String name, String brand, Optional<DisplayFeatures> displayFeature) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.displayFeature = displayFeature;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Optional<DisplayFeatures> getDisplayFeature() {
        return displayFeature;
    }

    public void setDisplayFeature(Optional<DisplayFeatures> displayFeature) {
        this.displayFeature = displayFeature;
    }
}