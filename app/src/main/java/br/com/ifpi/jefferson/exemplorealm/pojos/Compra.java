package br.com.ifpi.jefferson.exemplorealm.pojos;

import java.util.ArrayList;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by Jefferson on 25/09/2016.
 */
public class Compra extends RealmObject{

    @PrimaryKey
    private long id ;
    private String Descrição ;
    private String data ;
    private Double Orcamento;
    private RealmList<Produto> produtos;

    public long getId() {
        return id;
    }

    public Compra setId(long id) {
        this.id = id;
        return this;
    }

    public String getDescrição() {
        return Descrição;
    }

    public Compra setDescrição(String descrição) {
        Descrição = descrição;
        return this;
    }

    public String getData() {
        return data;
    }

    public Compra setData(String data) {
        this.data = data;
        return this;
    }

    public RealmList<Produto> getProdutos() {
        return produtos;
    }

    public Double getOrcamento() {
        return Orcamento;
    }

    public Compra setOrcamento(Double orcamento) {
        Orcamento = orcamento;
        return this;
    }

    public Compra setProdutos(Produto produto) {
        this.produtos.add(produto);
        return this;
    }

    public double valorTotal (){
        Double valorTotal = 0.0;
        for (Produto produto: produtos) {
            valorTotal = valorTotal + produto.getValor();
        }
        return valorTotal;
    }
}
