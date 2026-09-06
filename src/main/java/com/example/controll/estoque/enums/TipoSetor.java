package com.example.controll.estoque.enums;

public enum TipoSetor {
    LOGISTICA(1);

    private int codigo;

    TipoSetor(int codigo){
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }
}
