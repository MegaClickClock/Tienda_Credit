package com.example.tiendacredit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.tiendacredit.adaptador.ReciclerViewAdaptador;
import com.example.tiendacredit.database.DataBase;

public class RecyclerItem extends AppCompatActivity {

    private RecyclerView recyclerViewEstudiantes;
    private ReciclerViewAdaptador reciclerViewAdaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_item);

        recyclerViewEstudiantes = findViewById(R.id.recyclerviewEstudiantes);
        recyclerViewEstudiantes.setLayoutManager(new LinearLayoutManager(this));

        DataBase dataBase = new DataBase(getApplicationContext());

        reciclerViewAdaptador = new ReciclerViewAdaptador(dataBase.mostrarItem());
        recyclerViewEstudiantes.setAdapter(reciclerViewAdaptador);
    }
}