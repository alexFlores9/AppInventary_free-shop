package com.example.appinventary_free_shop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adaptador extends RecyclerView.Adapter<Adaptador.inner> {


    private Context mCtx;
    private List<Dto> list;

    public Adaptador(Context mCtx, List<Dto> list) {
        this.mCtx = mCtx;
        this.list = list;
    }

    @NonNull
    @Override
    public inner onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.list_recyclerview, null);
        return new inner (view);
    }

    @Override
    public void onBindViewHolder(@NonNull inner holder, int position) {
//Toast.makeText(mCtx, "Se encontraron: "+getItemCount()+ " Registros.",Toast.LENGTH_SHORT).show();
        Dto dto = list.get(position);
        holder.t1.setText(String.valueOf(dto.getId_producto()));
        holder.t2.setText(dto.getNom_producto());
        holder.t3.setText(dto.getDes_producto());
        holder.t41.setText(String.valueOf(dto.getStock()));
        holder.t5.setText(String.valueOf(dto.getPrecio()));
        holder.t6.setText(dto.getUnidad_de_medida());
        holder.t7.setText(String.valueOf(dto.getEstado_producto()));
        holder.t8.setText(String.valueOf(dto.getCategoria()));


        holder.t4.setText(String.valueOf("Registro #:" + (position+1)) + "/" +
                getItemCount());



    }


    @Override
    public int getItemCount() {
        return list.size();
    }



    public class inner extends RecyclerView.ViewHolder {
        TextView t1,t2,t3,t4,t41,t5,t6,t7,t8,t9;

        public inner(@NonNull View itemView) {
            super(itemView);
            t1 = itemView.findViewById(R.id.textViewCodigo1);
            t2 = itemView.findViewById(R.id.textViewDescripcion1);
            t3= itemView.findViewById(R.id.textViewPrecio1);
            t4= itemView.findViewById(R.id.textViewOtro);
            t41=itemView.findViewById(R.id.tv6);
            t5=itemView.findViewById(R.id.tv8);
            t6=itemView.findViewById(R.id.tv10);
            t7=itemView.findViewById(R.id.tv12);
            t8=itemView.findViewById(R.id.tv14);

        }
    }
}
