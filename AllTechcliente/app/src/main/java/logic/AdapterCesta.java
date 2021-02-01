package logic;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.alltech_cliente.Prod_detalle_activity;
import com.example.alltech_cliente.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class AdapterCesta extends RecyclerView.Adapter<AdapterCesta.HolderProducto>{
    public static Context context;
    public static int iPos;
    private LogicaProducto logProd = new LogicaProducto();

    public AdapterCesta(Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public HolderProducto onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tarjeta, parent, false);
        return new HolderProducto(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderProducto holder, final int position) {

        holder.lblNombre.setText(LogicaProducto.lCesta.get(position).getNOMBRE());
        holder.lblPrecio.setText(LogicaProducto.lCesta.get(position).getPVP() + " €");
        Glide
                .with(context)
                .load("https://alltech1.000webhostapp.com/imgProd/" + LogicaProducto.lCesta.get(position).getCODIGO() + ".jpg")
                .into(holder.imgProd);
        iPos = position;
        holder.floatInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent prodDetalle = new Intent(AdapterCesta.context, Prod_detalle_activity.class);
               AdapterCesta.context.startActivity(prodDetalle.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });

        holder.floatRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    @Override
    public int getItemCount() {
        return LogicaProducto.lCesta.size();
    }
    public void refresh(){
        notifyDataSetChanged();
    }

    public static class HolderProducto extends RecyclerView.ViewHolder {
        public static CardView cTarjeta;
        public static TextView lblNombre;
        public static TextView lblPrecio;
        public static ImageView imgProd;
        public static FloatingActionButton floatInfo;
        public static FloatingActionButton floatRemove;

        public HolderProducto(@NonNull View itemView) {
            super(itemView);
            cTarjeta = itemView.findViewById(R.id.crdTarjeta);
            lblNombre = itemView.findViewById(R.id.lblNombre);
            lblPrecio = itemView.findViewById(R.id.lblPrecio);
            imgProd = itemView.findViewById(R.id.imgProd);
            floatInfo = itemView.findViewById(R.id.floatInfo);
            floatRemove = itemView.findViewById(R.id.floatRemove);
        }
    }
}
