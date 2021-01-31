package logic;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.alltech_cliente.Prod_detalle_activity;
import com.example.alltech_cliente.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import model.Producto;


public class Adapter extends RecyclerView.Adapter<Adapter.HolderProducto>{
    public static Context context;
    public static int iPos;
    private LogicaProducto logProd = new LogicaProducto();

    public Adapter(Context context){
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

        holder.lblNombre.setText(LogicaProducto.lProducto.get(position).getNOMBRE());
        holder.lblPrecio.setText(LogicaProducto.lProducto.get(position).getPVP() + " €");
        Glide
                .with(context)
                .load("https://alltech1.000webhostapp.com/imgProd/" + LogicaProducto.lProducto.get(position).getCODIGO() + ".jpg")
                .into(holder.imgProd);
        iPos = position;
        holder.floatInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logProd.getProductoDetalle(LogicaProducto.lProducto.get(iPos).getCODIGO());
           /*     Prod_detalle_activity.txtNombreDetalle.setText(LogicaProducto.lProducto.get(position).getNOMBRE());
                Prod_detalle_activity.txtPrecioDetalle.setText(LogicaProducto.lProducto.get(position).getPVP() + " €");
                Prod_detalle_activity.txtDescrip.setText(LogicaProducto.lProducto.get(position).getCOMENTARIOS());*/





               /* Intent pordDetalle = new Intent(context, com.example.alltech_cliente.Prod_detalle_activity.class);

                context.startActivity(pordDetalle);*/
            }
        });
    }

    @Override
    public int getItemCount() {
        return LogicaProducto.lProducto.size();
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



        public HolderProducto(@NonNull View itemView) {
            super(itemView);
            cTarjeta = itemView.findViewById(R.id.crdTarjeta);
            lblNombre = itemView.findViewById(R.id.lblNombre);
            lblPrecio = itemView.findViewById(R.id.lblPrecio);
            imgProd = itemView.findViewById(R.id.imgProd);
            floatInfo = itemView.findViewById(R.id.floatInfo);


        }


    }
}
