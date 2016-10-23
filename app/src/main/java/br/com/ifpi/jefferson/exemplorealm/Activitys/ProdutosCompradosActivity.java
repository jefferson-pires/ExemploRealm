package br.com.ifpi.jefferson.exemplorealm.Activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.ifpi.jefferson.exemplorealm.DAO;
import br.com.ifpi.jefferson.exemplorealm.R;
import br.com.ifpi.jefferson.exemplorealm.adapter.ProdutosAdapter;
import br.com.ifpi.jefferson.exemplorealm.pojos.Compra;
import br.com.ifpi.jefferson.exemplorealm.pojos.Produto;
import io.realm.RealmList;

public class ProdutosCompradosActivity extends AppCompatActivity {

    private RealmList<Produto> produtos ;
    private DAO dao;
    private ProdutosAdapter adapter;
    private RecyclerView listaProdutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produtos_comprados);
        dao = new DAO();
        listaProdutos = (RecyclerView) findViewById(R.id.list_produtos);

        produtos = new RealmList<Produto>();

        Intent intent = getIntent();

        Long id = intent.getLongExtra("id",6);
        Compra compra = dao.buscarCompra(id);
        Toast.makeText(this, compra.getDescrição(), Toast.LENGTH_SHORT).show();
        produtos = compra.getProdutos();
        adapter = new ProdutosAdapter(this,produtos);

        listaProdutos.setAdapter(adapter);

    }
}
