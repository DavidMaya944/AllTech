package logic;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.alltech_cliente.MainActivity;
import com.example.alltech_cliente.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import controller.CtrlProducto;


public class AdapterCesta extends RecyclerView.Adapter<AdapterCesta.HolderProducto>{
    public static Context context;
    private CtrlProducto ctrlProd = new CtrlProducto();
    public AdapterCesta(Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public HolderProducto onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tarjeta_cesta, parent, false);
        return new HolderProducto(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderProducto holder, final int position) {

            final MediaPlayer sonido = MediaPlayer.create(context, R.raw.boton);

            holder.lblNombreCesta.setText(Adapter.lCesta.get(position).getNOMBRE());
            holder.lblPrecioCesta.setText(Adapter.lCesta.get(position).getPVP() + " €");
            Glide
                    .with(context)
                    .load(Adapter.DOMINIO + "/imgProd/" + Adapter.lCesta.get(position).getCODIGO() + ".jpg")
                    .into(holder.imgProdCesta);
            holder.imgProdCesta.setOnClickListener(v -> {
                MainActivity.mutearSonido(sonido);
                ctrlProd.getProductoDetalle(Adapter.lCesta.get(position).getCODIGO());

            });

            holder.floatRemove.setOnClickListener(v -> {
                MainActivity.mutearSonido(sonido);
                Adapter.lCesta.remove(Adapter.lCesta.get(position));

            });

    }

    @Override
    public int getItemCount() {
        return Adapter.lCesta.size();
    }
    public void refresh(){
        notifyDataSetChanged();
    }

    public static class HolderProducto extends RecyclerView.ViewHolder {
        public static CardView cTarjetaCesta;
        public static TextView lblNombreCesta;
        public static TextView lblPrecioCesta;
        public static ImageView imgProdCesta;
        public static FloatingActionButton floatRemove;

        public HolderProducto(@NonNull View itemView) {
            super(itemView);
            cTarjetaCesta = itemView.findViewById(R.id.crdTarjetaCesta);
            lblNombreCesta = itemView.findViewById(R.id.lblNombreCesta);
            lblPrecioCesta = itemView.findViewById(R.id.lblPrecioCesta);
            imgProdCesta = itemView.findViewById(R.id.imgProdCesta);
            floatRemove = itemView.findViewById(R.id.floatRemove);
        }
    }


}
