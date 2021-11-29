package com.example.a08_recyclerviews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.a08_recyclerviews.modelos.Coche;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Coche> coches;
    private RecyclerView recyclerView;
    private CochesAdapter adapter;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coches = new ArrayList<>();
        crearCoches();

        /**
         * ReciclyView -> Similar al ListView
         * - Adapter
         *  - Fila ->
         *  - Modelo -> coches
         *  - Contexto
         *      Los elementos a mostrar
         * - LayoutManager -> Cómo se tiene que mostrar la información.
         */

        recyclerView = findViewById(R.id.contenedor);
        adapter = new CochesAdapter(this, R.layout.coche_model, coches);
        linearLayoutManager = new LinearLayoutManager(this);
        //linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private void crearCoches(){
        for (int i = 0; i < 100; i++){
            coches.add(new Coche("Marca " + i, "Modelo " + i));
        }
    }
}