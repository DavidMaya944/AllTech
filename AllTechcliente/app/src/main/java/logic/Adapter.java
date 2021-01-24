package logic;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alltech_cliente.R;

import java.util.List;

import model.Producto;


public class Adapter extends RecyclerView.Adapter<Adapter.HolderProducto>{
    public static List<Producto> lProducto;
    Context context;
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

       /* holder.lblNombre.setText(lProducto.get(position).getNOMBRE());
        holder.lblPrecio.setText(""+ lProducto.get(position).getPVP());
        holder.lblDescripcion.setText(lProducto.get(position).getCOMENTARIOS());*/
        logProd.getProductos();

        holder.cTarjeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pordDetalle = new Intent(context, com.example.alltech_cliente.Prod_detalle_activity.class);
                iPos = position;
                context.startActivity(pordDetalle);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lProducto.size();
    }
    public void refresh(){
        notifyDataSetChanged();
    }

    public static class HolderProducto extends RecyclerView.ViewHolder {
        public static CardView cTarjeta;
        public static TextView lblNombre;
        public static TextView lblPrecio;
        public static TextView lblDescripcion;


        public HolderProducto(@NonNull View itemView) {
            super(itemView);
            cTarjeta = itemView.findViewById(R.id.crdTarjeta);
            lblNombre = itemView.findViewById(R.id.lblNombre);
            lblPrecio = itemView.findViewById(R.id.lblPrecio);
            lblDescripcion = itemView.findViewById(R.id.lblDescripcion);

        }


    }
}
