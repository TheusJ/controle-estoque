package com.example.controll.estoque.enums;

public enum TipoCargo {
    OPERADOR_ESTOQUE(1),
    CONFERENTE(2),
    OPERADOR_EMPILHADEIRA(3),
    ANALISTA_SUPRIMENTOS(4),
    GERENTE_LOGISTICA(5),
    ADMINISTRADOR(6),
    RH(7),
    ADMIN(8);

    private int id;

    TipoCargo(int codigo) {
        this.id = codigo;
    }

    public int getId() {
        return id;
    }
}
