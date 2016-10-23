package br.com.ifpi.jefferson.exemplorealm.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.ifpi.jefferson.exemplorealm.Activitys.ComprasActivity;
import br.com.ifpi.jefferson.exemplorealm.Activitys.ProdutosCompradosActivity;
import br.com.ifpi.jefferson.exemplorealm.R;
import br.com.ifpi.jefferson.exemplorealm.pojos.Compra;

/**
 * Created by Jefferson on 25/09/2016.
 */

public class ComprasAdapter extends RecyclerView.Adapter{

    private final Context context;
    private final List<Compra> compras;
    private LayoutInflater ml;

    public ComprasAdapter(Context context, ArrayList<Compra> compras) {
        this.context = context;
        this.compras = compras;
        ml = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = ml.inflate(R.layout.compras_adapter, parent, false);
        NossoViewHolder holder = new NossoViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        NossoViewHolder holder = (NossoViewHolder) viewHolder;

        Compra compra = compras.get(position) ;

        holder.dataCompra.setText(compra.getData().toString());
        holder.descCompra.setText(compra.getDescrição().toString());
        holder.valorCompra.setText("Orçamento: R$ "+compra.getOrcamento().toString().replace(".",","));
        holder.valorGasto.setText("Valor gasto: R$ "+compra.valorTotal().toString().replace(".",","));
    }

    @Override
    public int getItemCount() {
        return compras.size();
    }

    public class NossoViewHolder extends RecyclerView.ViewHolder {

        TextView descCompra ;
        TextView dataCompra ;
        TextView valorCompra ;
        TextView valorGasto ;

        public NossoViewHolder(View view) {
            super(view);

            view.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    Intent i = new Intent(v.getContext(), ProdutosCompradosActivity.class);
                    i.putExtra("id",compras.get(getAdapterPosition()).getId());
                    context.startActivity(i);
                }
            });

            descCompra = (TextView) view.findViewById(R.id.desc_compra);
            dataCompra = (TextView) view.findViewById(R.id.data_compra);
            valorCompra = (TextView) view.findViewById(R.id.valor_compra);
            valorGasto = (TextView) view.findViewById(R.id.valor_gasto);
        }

    }
}
