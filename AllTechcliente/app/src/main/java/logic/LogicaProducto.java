package logic;

import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;

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
    Adapter adapter = new Adapter(Tienda_activity.contextTienda);
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
            Type type = new TypeToken() {
            }.getType();
            lProducto = new Gson().fromJson(sResultado, type);
            for(int i = 0; i < lProducto.size(); i++){
                Adapter.HolderProducto.lblNombre.setText(lProducto.get(i).getNOMBRE());
                Adapter.HolderProducto.lblPrecio.setText(lProducto.get(i).getPVP() + " €");
                Adapter.HolderProducto.lblDescripcion.setText(lProducto.get(i).getCOMENTARIOS());
               
            }

        }
    }
}
