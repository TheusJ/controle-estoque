package com.example.controll.estoque.enums;

public enum StatusLogin {
    ONLINE(1),
    OFFILINE(2);

    private int codigo;

    StatusLogin(int codigo){
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }
}
