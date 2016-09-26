package br.com.ifpi.jefferson.exemplorealm.Activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import br.com.ifpi.jefferson.exemplorealm.R;
import br.com.ifpi.jefferson.exemplorealm.adapter.ComprasAdapter;
import br.com.ifpi.jefferson.exemplorealm.pojos.Compra;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

public class ComprasActivity extends AppCompatActivity {

    ArrayList<Compra> compras ;
    private ComprasAdapter comprasAdapter;
    private ListView listaDeCompras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compras);
        compras = new ArrayList<Compra>();
        listaDeCompras = (ListView) findViewById(R.id.list_compras);

        RealmConfiguration realmConfig = new RealmConfiguration.Builder(getApplicationContext()).build();
        Realm realm = Realm.getInstance(realmConfig);
        RealmResults<Compra> realmCompras = realm.where(Compra.class).findAll();

        for (Compra compra: realmCompras) {
            compras.add(compra);
        }

        comprasAdapter = new ComprasAdapter (this,compras);
        listaDeCompras.setAdapter(comprasAdapter);
    }
}
