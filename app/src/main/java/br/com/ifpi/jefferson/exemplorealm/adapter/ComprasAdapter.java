package br.com.ifpi.jefferson.exemplorealm.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.ifpi.jefferson.exemplorealm.Activitys.ComprasActivity;
import br.com.ifpi.jefferson.exemplorealm.R;
import br.com.ifpi.jefferson.exemplorealm.pojos.Compra;

/**
 * Created by Jefferson on 25/09/2016.
 */

public class ComprasAdapter extends BaseAdapter{
    private final Context context;
    private final List<Compra> compras;

    public ComprasAdapter (Context context, ArrayList<Compra> compras) {
        this.context = context;
        this.compras = compras;
    }

    @Override
    public int getCount() {
        return compras != null ? compras.size():0;
    }

    @Override
    public Object getItem(int position) {
        return compras.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.compras_adapter,parent,false);
        TextView descCompra = (TextView) view.findViewById(R.id.desc_compra);
        TextView dataCompra = (TextView) view.findViewById(R.id.data_compra);
        TextView valorCompra = (TextView) view.findViewById(R.id.valor_compra);
        TextView valorGasto = (TextView) view.findViewById(R.id.valor_gasto);

        Compra compra = compras.get(position);
        descCompra.setText(compra.getDescrição());
        dataCompra.setText(compra.getData());
        valorCompra.setText("Orçamento: R$ "+compra.getOrcamento().toString());
        valorGasto.setText(compra.valorTotal()+"");

        return view;
    }
}
