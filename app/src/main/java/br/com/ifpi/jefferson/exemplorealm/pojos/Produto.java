package br.com.ifpi.jefferson.exemplorealm.pojos;

import io.realm.RealmObject;

/**
 * Created by Jefferson on 25/09/2016.
 */
public class Produto extends RealmObject {
    private String name ;
    private Double valor;
    private int Quantidade;

    public Produto setName(String name) {
        this.name = name;
        return this;
    }

    public Produto setValor(Double valor) {
        this.valor = valor;
        return this;
    }

    public Produto setQuantidade(int quantidade) {
        Quantidade = quantidade;
        return this;
    }

    public String getName() {
        return name;
    }

    public Double getValor() {
        return valor * getQuantidade();
    }

    public int getQuantidade() {
        return Quantidade;
    }
}
