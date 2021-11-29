package com.example.a08_recyclerviews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a08_recyclerviews.modelos.Coche;

import java.util.List;

/**
 * Ya no hereda de ArrayAdapter, sino que tengo una clase especifica
 *
 *  - ReciclyView.Adapter<Objeto>
 *
 *     Clase ViewHolder -> (VH) permite la reutilización de las vistas
 *
 *     getView()
 *      1. Obtiene los elementos de la vista -> findviewbyid
 *      2. Asigna valores a los elementos de la vista
 *
 *     El objeto viewHolder -> Es quien mapea la fila(coche_model)
 *      1. Método para crear el ViewHolder
 *      2. Método para asignar valores al ViewHolder
 *      3. Indica cuantas filas hay que implementar
 */

public class CochesAdapter extends RecyclerView.Adapter<CochesAdapter.CocheVH> {

    private Context context;
    private int resource;
    private List<Coche> coches;

    public CochesAdapter(Context context, int resource, List<Coche> coches) {
        this.context = context;
        this.resource = resource;
        this.coches = coches;
    }

    // onCreateViewHolder -> Se lanza cuando no tengo suficientes filas creadas
    @NonNull
    @Override
    public CocheVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View fila = LayoutInflater.from(context).inflate(R.layout.coche_model, null);
        return new CocheVH(fila);
    }

    //Asigna los valores del elemento correspondiente al ViewHolder
    @Override
    public void onBindViewHolder(@NonNull CocheVH holder, int position) {
        Coche coche = coches.get(position);
        holder.lblModelo.setText(coche.getModelo());
        holder.lblMarca.setText(coche.getMarca());

        //Lo mismo, diferente dorma: holder.lblModelo.setText(coches.get(position).getModelo());
    }

    @Override
    public int getItemCount() {
        return coches.size();
    }


    /**
     * Modelo de datos para mostrar en el RecyclerView
     */

    static class CocheVH extends RecyclerView.ViewHolder {

        TextView lblMarca, lblModelo;

        public CocheVH(@NonNull View itemView) {
            super(itemView);
            lblMarca = itemView.findViewById(R.id.lblMarcaModel);
            lblModelo = itemView.findViewById(R.id.lblModeloModel);
        }
    }
}
