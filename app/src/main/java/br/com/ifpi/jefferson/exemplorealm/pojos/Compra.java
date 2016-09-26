package br.com.ifpi.jefferson.exemplorealm.pojos;

import java.util.ArrayList;

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

}
