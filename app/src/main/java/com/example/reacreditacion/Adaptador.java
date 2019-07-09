package com.example.reacreditacion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {
    private Context context;
    private ArrayList<Categorias> listItems;

    public Adaptador(Context context, ArrayList<Categorias> listItems) {
        this.context = context;
        this.listItems = listItems;
    }

    @Override
    public int getCount() {
        return listItems.size();
    }

    @Override
    public Object getItem(int position) {
        return listItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Categorias item = (Categorias) getItem(position);

        convertView = LayoutInflater.from(context).inflate(R.layout.cat_info, null);
        ImageView imageView = convertView.findViewById(R.id.icono);
        TextView txtTitulo = convertView.findViewById(R.id.titulo);
        TextView txtDescrip = convertView.findViewById(R.id.descripcion);

        imageView.setImageResource(item.getIcono());
        txtTitulo.setText(item.getNombre());
        txtDescrip.setText(item.getDescripcion());

        return convertView;
    }
}
