package br.com.ifpi.jefferson.exemplorealm.Activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import br.com.ifpi.jefferson.exemplorealm.R;
import br.com.ifpi.jefferson.exemplorealm.pojos.Compra;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {
    Realm realm ;
    EditText txtDescricao;
    EditText txtData;
    RealmResults<Compra> compras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtDescricao = (EditText) findViewById(R.id.descricao);
        txtData = (EditText) findViewById(R.id.data);

        RealmConfiguration realmConfig = new RealmConfiguration.Builder(getApplicationContext()).build();
        realm = Realm.getInstance(realmConfig);

        compras = realm.where(Compra.class).findAll();

    }

    public void salvarCompra(View view){
        String descrição = txtDescricao.getText().toString();
        String data = txtData.getText().toString();

        realm.beginTransaction();
        Compra compra = realm.createObject(Compra.class);
        compra.setData(data);
        compra.setDescrição(descrição);
        compra.setId(compras.size()+1);
        realm.commitTransaction();
        realm.close();
    }

    public void compras(View view){

        Intent intent = new Intent(this,ComprasActivity.class);
        startActivity(intent);
    }
}
