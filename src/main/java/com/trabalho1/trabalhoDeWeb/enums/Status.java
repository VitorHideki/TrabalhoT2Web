package com.trabalho1.trabalhoDeWeb.enums;

public enum Status {
    REALIZADO("Realizado"),
    CANCELADO("Cancelado");

    private String status;
    Status(String status){
        this.status = status;
    }
}
