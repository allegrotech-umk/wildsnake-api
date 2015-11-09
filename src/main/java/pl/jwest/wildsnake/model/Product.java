package pl.jwest.wildsnake.model;

import javax.persistence.Entity;

@Entity
public class Product {
    private final String name;

    public Product(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

}
