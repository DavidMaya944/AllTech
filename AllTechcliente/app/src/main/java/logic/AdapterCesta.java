package logic;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.preference.PreferenceManager;
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

import controller.CtrlProducto;


public class AdapterCesta extends RecyclerView.Adapter<AdapterCesta.HolderProducto>{
    public static Context context;
    private LogicaProducto logProd = new LogicaProducto();
    private CtrlProducto ctrlProd = new CtrlProducto();
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
        final MediaPlayer sonido = MediaPlayer.create(context, R.raw.boton);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);

        holder.lblNombre.setText(LogicaProducto.lCesta.get(position).getNOMBRE());
        holder.lblPrecio.setText(LogicaProducto.lCesta.get(position).getPVP() + " €");
        Glide
                .with(context)
                .load(Adapter.DOMINIO + "/imgProd/" + LogicaProducto.lCesta.get(position).getCODIGO() + ".jpg")
                .into(holder.imgProd);
        holder.floatInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(preferences.getBoolean("vol",true)){
                    sonido.start();
                }else{
                    sonido.stop();
                }
                ctrlProd.getProductoDetalle(LogicaProducto.lCesta.get(position).getCODIGO());

            }
        });

        holder.floatRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(preferences.getBoolean("vol",true)){
                    sonido.start();
                }else{
                    sonido.stop();
                }
                logProd.borrarCesta();
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
