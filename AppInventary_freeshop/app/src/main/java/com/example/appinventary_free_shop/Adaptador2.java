package com.example.appinventary_free_shop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adaptador2 extends RecyclerView.Adapter<Adaptador2.inner2> {


    private Context mCtx;
    private List<Dto> list2;

    public Adaptador2(Context mCtx, List<Dto> list2) {
        this.mCtx = mCtx;
        this.list2 = list2;
    }

    @NonNull
    @Override
    public inner2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.list2_recyclerview, null);
        return new inner2(view);
    }

    @Override
    public void onBindViewHolder(@NonNull inner2 holder, int position) {
//Toast.makeText(mCtx, "Se encontraron: "+getItemCount()+ " Registros.",Toast.LENGTH_SHORT).show();
        Dto dto = list2.get(position);
        holder.t1.setText(String.valueOf(dto.getId_producto()));
        holder.t2.setText(dto.getNom_producto());
        holder.t3.setText(dto.getDes_producto());
        holder.t41.setText(String.valueOf(dto.getStock()));
        holder.t5.setText(String.valueOf(dto.getPrecio()));
        holder.t6.setText(dto.getUnidad_de_medida());
        holder.t7.setText(String.valueOf(dto.getEstado_producto()));
        holder.t8.setText(String.valueOf(dto.getCategoria()));
        holder.t12.setText(dto.getFecha_entrada());
        holder.t9.setText(String.valueOf(dto.getId_categoria()));
        holder.t10.setText(dto.getNom_categoria());
        holder.t11.setText(String.valueOf(dto.getEstado_categoria()));
        holder.t4.setText(String.valueOf("Registro #:" + (position+1)) + "/" +
                getItemCount());


    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
     return list2.size();
    }

    public class inner2 extends RecyclerView.ViewHolder {
        TextView t1,t2,t3,t4,t41,t5,t6,t7,t8,t9,t10,t11,t12;
        public inner2(@NonNull View itemView) {
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
            t12=itemView.findViewById(R.id.tv16);

            t9=itemView.findViewById(R.id.tv18);
            t10=itemView.findViewById(R.id.tv20);
            t11=itemView.findViewById(R.id.tv22);
        }
    }
}
