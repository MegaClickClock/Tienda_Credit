package com.example.tiendacredit;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.valueOf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tiendacredit.database.DataBase;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class InventarioLista extends AppCompatActivity {
    private Button btnMostrar,btnAgregar, btnBuscar, btnEditar, btnEliminar;
    private EditText edtCodigo, edtCarrera, edtCurso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventario_lista);

        btnMostrar = findViewById(R.id.btnMostrar);
        btnAgregar = findViewById(R.id.btnAgregar);
        btnBuscar = findViewById(R.id.btnBuscar);
        btnEditar = findViewById(R.id.btnEditar);
        btnEliminar = findViewById(R.id.btnEliminar);
        edtCodigo = findViewById(R.id.edtCodigo);
        edtCarrera = findViewById(R.id.edtCarrera);
        edtCurso = findViewById(R.id.edtCurso);

        final DataBase  dataBase = new DataBase(getApplicationContext());

        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), RecyclerItem.class);
                startActivity(intent);

            }
        });

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataBase.agregarItem(parseInt(edtCodigo.getText().toString()), edtCurso.getText().toString(), Float.parseFloat(edtCarrera.getText().toString()));
                Toast.makeText(getApplicationContext(), "SE AGREGO CORRECTAMENTE ", Toast.LENGTH_SHORT).show();
            }
        });

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Articulo articulo = new Articulo();
                dataBase.buscarItem(articulo, parseInt(edtCodigo.getText().toString()));
                edtCurso.setText(articulo.getnombreArticulo());
                edtCarrera.setText(String.valueOf(articulo.getPrecio()));
            }
        });

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataBase.editarItem(parseInt(edtCodigo.getText().toString()), edtCurso.getText().toString(), Float.parseFloat(edtCarrera.getText().toString()));
                Toast.makeText(getApplicationContext(), "SE A MODIFICADO CORRECTAMENTE", Toast.LENGTH_SHORT).show();
            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataBase.eliminarItem(parseInt(edtCodigo.getText().toString()));
                Toast.makeText(getApplicationContext(), "SE A ELIMINADO CORRECTAMENTE", Toast.LENGTH_SHORT).show();
            }
        });

    }
}