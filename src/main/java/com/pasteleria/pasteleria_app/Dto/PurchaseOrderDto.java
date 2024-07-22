package com.pasteleria.pasteleria_app.Dto;

import java.util.Date;

public class PurchaseOrderDto {
    private long order_id;
    private String user_id;
    private Date created_at;
    private double total_amount;

    public PurchaseOrderDto() {
    }

    public PurchaseOrderDto(long order_id, String user_id, Date created_at, double total_amount) {
        this.order_id = order_id;
        this.user_id = user_id;
        this.created_at = created_at;
        this.total_amount = total_amount;
    }

    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(double total_amount) {
        this.total_amount = total_amount;
    }

}
