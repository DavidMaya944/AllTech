package logic;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.alltech_cliente.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import controller.CtrlProducto;
import model.Producto;


public class Adapter extends RecyclerView.Adapter<Adapter.HolderProducto>{
    public static Context context;
    public static List<Producto> lCesta = new ArrayList<Producto>();
    public static final String DOMINIO = "https://alltech1.000webhostapp.com";
    private LogicaProducto logProd = new LogicaProducto();
    private CtrlProducto ctrlProd = new CtrlProducto();
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
        final MediaPlayer sonido = MediaPlayer.create(context, R.raw.boton);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);

        holder.lblNombre.setText(LogicaProducto.lProducto.get(position).getNOMBRE());
        holder.lblPrecio.setText(LogicaProducto.lProducto.get(position).getPVP() + " €");
        Glide
                .with(context)
                .load(DOMINIO + "/imgProd/" + LogicaProducto.lProducto.get(position).getCODIGO() + ".jpg")
                .into(holder.imgProd);
        holder.floatInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(preferences.getBoolean("vol",true)){
                    sonido.start();
                }else{
                    sonido.stop();
                }
                ctrlProd.getProductoDetalle(LogicaProducto.lProducto.get(position).getCODIGO());

            }
        });

        holder.floatAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(preferences.getBoolean("vol",true)){
                    sonido.start();
                }else{
                    sonido.stop();
                }
                Log.i("MAYA", "ANTES de la cesta hay: " + lCesta.size());
                lCesta.add(LogicaProducto.lProducto.get(position));
                Log.i("MAYA","Productos añadidos: " + position);
                Log.i("MAYA", "DENTRO de la cesta hay: " + lCesta.size());
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
        public static FloatingActionButton floatAdd;

        public HolderProducto(@NonNull View itemView) {
            super(itemView);
            cTarjeta = itemView.findViewById(R.id.crdTarjeta);
            lblNombre = itemView.findViewById(R.id.lblNombre);
            lblPrecio = itemView.findViewById(R.id.lblPrecio);
            imgProd = itemView.findViewById(R.id.imgProd);
            floatInfo = itemView.findViewById(R.id.floatInfo);
            floatAdd = itemView.findViewById(R.id.floatAdd);
        }
    }


}
