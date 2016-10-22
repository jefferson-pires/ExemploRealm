package br.com.ifpi.jefferson.exemplorealm.Activitys;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.ifpi.jefferson.exemplorealm.DAO;
import br.com.ifpi.jefferson.exemplorealm.R;
import br.com.ifpi.jefferson.exemplorealm.adapter.ComprasAdapter;
import br.com.ifpi.jefferson.exemplorealm.pojos.Compra;

public class ComprasActivity extends AppCompatActivity {

    private ArrayList<Compra> compras ;
    private ComprasAdapter comprasAdapter;
    private RecyclerView listaDeCompras;
    private DAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dao = new DAO();
        setContentView(R.layout.activity_compras);
        compras = dao.todasCompras();
        listaDeCompras = (RecyclerView) findViewById(R.id.list_compras);


        comprasAdapter = new ComprasAdapter (this,compras);
        listaDeCompras.setAdapter(comprasAdapter);
        RecyclerView.LayoutManager layout = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        listaDeCompras.setLayoutManager(layout);

        AdapterView.OnItemLongClickListener longClick = new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                dao.deletarCompra(compras.get(position).getId());
                toast("Compra excluida");
                onRestart();
                return false;
            }
        };

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

}
