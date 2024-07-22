package com.pasteleria.pasteleria_app.Dto;

public class UserDto {
    private String id_number;
    private String first_name;
    private String last_name;
    private String phone_number;

    public UserDto() {
    }

    public UserDto(String id_number, String first_name, String last_name, String phone_number) {
        this.id_number = id_number;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
    }

    public String getId_number() {
        return id_number;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
}
