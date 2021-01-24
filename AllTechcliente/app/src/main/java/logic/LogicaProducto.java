package logic;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alltech_cliente.R;
import com.example.alltech_cliente.Tienda_activity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.List;

import model.Producto;

public class LogicaProducto {
    public static List<Producto> lProducto;
    public static int iPos;
    public void getProductos(){
       new listar_productos().execute("http://davidmaya.atwebpages.com/ProductosPHP/getProductos.php");
    }

    private class listar_productos extends AsyncTask<String, Void, Void> {

        String sResultado;

        @Override
        protected Void doInBackground(String... params) {
            try {
                URL url = new URL(params[0]);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
                String stringBuffer;
                String str = "";
                while ((stringBuffer = bufferedReader.readLine()) != null){
                    str = String.format("%s%s", str, stringBuffer);
                }

                sResultado = str;
                bufferedReader.close();
            }catch (IOException e){
                sResultado = e.getMessage();
            }
            return null;
        }

        @Override
        public void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Type type = new TypeToken<List<Producto>>() {
            }.getType();
            lProducto = new Gson().fromJson(sResultado, type);
            for (Producto p : lProducto){
                Adapter.HolderProducto.lblNombre.setText(p.getNOMBRE());
                Adapter.HolderProducto.lblPrecio.setText(p.getPVP() + " €");
                Adapter.HolderProducto.lblDescripcion.setText(p.getCOMENTARIOS());
            }

        }
    }


}
