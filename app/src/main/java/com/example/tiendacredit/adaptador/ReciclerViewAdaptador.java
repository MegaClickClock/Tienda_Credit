package com.example.tiendacredit.adaptador;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tiendacredit.Articulo;
import com.example.tiendacredit.R;

import java.util.List;

public class ReciclerViewAdaptador extends RecyclerView.Adapter<ReciclerViewAdaptador.ViewHolder>  {
    @NonNull
    @Override
    public ReciclerViewAdaptador.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_articulo, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReciclerViewAdaptador.ViewHolder holder, int position) {
        holder.codigo.setText(String.valueOf(inventarioListas.get(position).getCodigo()));
        holder.nombreArticulo.setText(inventarioListas.get(position).getnombreArticulo());
        holder.precio.setText(String.valueOf(inventarioListas.get(position).getPrecio()));

        //holder.carrera.setImageResource(cursosModeloList.get(position).getImgCantante());
    }

    @Override
    public int getItemCount() {
        return inventarioListas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView codigo, nombreArticulo, precio;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            codigo = itemView.findViewById(R.id.tvCodigo);
            nombreArticulo = itemView.findViewById(R.id.tvCurso);
            precio = itemView.findViewById(R.id.tvCarrera);
        }
    }

    public List<Articulo> inventarioListas;

    public ReciclerViewAdaptador(List<Articulo> inventarioListas) {
        this.inventarioListas = inventarioListas;
    }
}
