package br.com.ifpi.jefferson.exemplorealm.Activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.ifpi.jefferson.exemplorealm.DAO;
import br.com.ifpi.jefferson.exemplorealm.R;
import br.com.ifpi.jefferson.exemplorealm.adapter.ComprasAdapter;
import br.com.ifpi.jefferson.exemplorealm.pojos.Compra;
import br.com.ifpi.jefferson.exemplorealm.pojos.Produto;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

public class ComprasActivity extends AppCompatActivity {

    ArrayList<Compra> compras ;
    private ComprasAdapter comprasAdapter;
    private ListView listaDeCompras;
    Realm realm;

    DAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dao = new DAO();
        setContentView(R.layout.activity_compras);
        compras = dao.todasCompras();
        listaDeCompras = (ListView) findViewById(R.id.list_compras);


        comprasAdapter = new ComprasAdapter (this,compras);
        listaDeCompras.setAdapter(comprasAdapter);

        listaDeCompras.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Compra CompraDel = realm.where(Compra.class).equalTo("id",compras.get(position).getId()).findFirst();
                realm.beginTransaction();
                CompraDel.deleteFromRealm();
                realm.commitTransaction();
                realm.close();
                compras.remove(position);
                toast("Compra excluida");
                refresh(view);

                return false;
            }
        });

    }

    public void refresh(View view){          //refresh is onClick name given to the button
        onRestart();
    }

    @Override
    protected void onRestart() {

        // TODO Auto-generated method stub
        super.onRestart();
        Intent i = new Intent(this, ComprasActivity.class);  //your class
        startActivity(i);
        finish();

    }

    private void toast(String msg){

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }



    public ListView getListaDeCompras() {
        return listaDeCompras;
    }

    public void deletarCompra(View view){


    }
}
