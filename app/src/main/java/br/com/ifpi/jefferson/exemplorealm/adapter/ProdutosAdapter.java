package br.com.ifpi.jefferson.exemplorealm.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.ifpi.jefferson.exemplorealm.Activitys.ProdutosCompradosActivity;
import br.com.ifpi.jefferson.exemplorealm.R;
import br.com.ifpi.jefferson.exemplorealm.pojos.Compra;
import br.com.ifpi.jefferson.exemplorealm.pojos.Produto;
import io.realm.RealmList;

/**
 * Created by Jefferson on 23/10/2016.
 */

public class ProdutosAdapter extends RecyclerView.Adapter{

    private final Context context;
    private final List<Produto> produtos;
    private LayoutInflater ml;

    public ProdutosAdapter(Context context, RealmList<Produto> produtos) {
        this.context = context;
        this.produtos = produtos;
        ml = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = ml.inflate(R.layout.produtos_adapter, parent, false);
        ProdutosAdapter.NossoViewHolder holder = new ProdutosAdapter.NossoViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        NossoViewHolder holder = (NossoViewHolder) viewHolder;

        Produto produto  = produtos.get(position) ;

        holder.valorTotal.setText(produto.getValor().toString().replace(".",","));
        holder.nomeProduto.setText(produto.getName());
        holder.quantidadeProduto.setText(produto.getQuantidade().toString().replace(".",","));

    }

    @Override
    public int getItemCount() {
        return produtos.size();
    }

    public class NossoViewHolder extends RecyclerView.ViewHolder {

        TextView nomeProduto;
        TextView quantidadeProduto;
        TextView valorTotal ;

        public NossoViewHolder(View view) {
            super(view);

            nomeProduto = (TextView) view.findViewById(R.id.nome_produto);
            quantidadeProduto = (TextView) view.findViewById(R.id.quantidade_produto);
            valorTotal = (TextView) view.findViewById(R.id.valor_produto);
        }

    }
}
