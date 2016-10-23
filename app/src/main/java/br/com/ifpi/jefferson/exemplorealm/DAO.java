package br.com.ifpi.jefferson.exemplorealm;

import android.app.Application;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.ifpi.jefferson.exemplorealm.pojos.Compra;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import io.realm.internal.Context;

/**
 * Created by Jefferson on 06/10/2016.
 */

public class DAO extends Application {
    private Realm realm;
    private RealmResults<Compra> compras;

    @Override
    public void onCreate() {
        super.onCreate();
        RealmConfiguration realmConfiguration =
                new RealmConfiguration.Builder(this)
                        .name("realm-sample.db")
                        .schemaVersion(1)
                        .build();

        Realm.setDefaultConfiguration(realmConfiguration);

    }

    public void SalvarCompra(Compra compra){
        try {
            realm = Realm.getDefaultInstance();
            realm.beginTransaction();
            compras = realm.where(Compra.class).findAll();
            compra.setId(compras.size()+1);
            realm.copyToRealm(compra);
            realm.commitTransaction();
            realm.close();
        }catch (Exception ex){
            Toast.makeText(this, "Não foi possivel a compra", Toast.LENGTH_SHORT).show();
        }
    }

    public void deletarCompra(Long id){
        realm = Realm.getDefaultInstance();
        Compra compraDel = realm.where(Compra.class).equalTo("id",id).findFirst();
        realm.beginTransaction();
        compraDel.deleteFromRealm();
        realm.commitTransaction();
        realm.close();
    }

    public Compra buscarCompra(Long id){
        Compra compra = new Compra();
        realm = Realm.getDefaultInstance();
        Compra compraEncontrada = realm.where(Compra.class).equalTo("id",id).findFirst();
        compra = compraEncontrada;
        return compra;
    }

    public ArrayList<Compra> todasCompras(){
        realm = Realm.getDefaultInstance();
        compras = realm.where(Compra.class).findAll();
        ArrayList<Compra> comprasEncontradas = new ArrayList<Compra>();

        for (Compra compra: compras) {
            comprasEncontradas.add(compra);
        }
        return comprasEncontradas;
    }
}
