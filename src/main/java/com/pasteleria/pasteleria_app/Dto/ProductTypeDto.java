package com.pasteleria.pasteleria_app.Dto;

public class ProductTypeDto {
    private long id;

    private String name;

    public ProductTypeDto() {
    }

    public ProductTypeDto(long id, String name) {
        this.id = id;
        this.name = name;
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

}
