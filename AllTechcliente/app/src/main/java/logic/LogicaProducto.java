package logic;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.example.alltech_cliente.LoginActivity;
import com.example.alltech_cliente.Prod_detalle_activity;
import com.example.alltech_cliente.Tienda_activity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import  model.Producto;

public class LogicaProducto {
    public static List<Producto> lProducto;
    public static List<Producto> lCesta;

    public void getProductos(){
       new listar_productos().execute(Adapter.DOMINIO + "/productos/get-productos.php");
    }
    public void getProductosBack(){
        new listar_productos_back().execute(Adapter.DOMINIO + "/productos/get-productos.php");
    }

    public void getProductoDetalle(int iCod){
        new carga_producto_detalle().execute(Adapter.DOMINIO + "/productos/get-producto.php?CODIGO=" + iCod);
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

        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Type type = new TypeToken<List<Producto>>() {}.getType();
            lProducto = new Gson().fromJson(sResultado, type);
            Intent appIn = new Intent(LoginActivity.context, Tienda_activity.class);
            LoginActivity.context.startActivity(appIn.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));

        }
    }

    private class listar_productos_back extends AsyncTask<String, Void, Void> {

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

        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Type type = new TypeToken<List<Producto>>() {}.getType();
            lProducto = new Gson().fromJson(sResultado, type);
            

        }
    }

    private class carga_producto_detalle extends AsyncTask<String, Void, Void> {

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

        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Type type = new TypeToken<List<Producto>>() {}.getType();
            lProducto = new Gson().fromJson(sResultado, type);
            Intent prodDetalle = new Intent(Adapter.context, Prod_detalle_activity.class);
            Adapter.context.startActivity(prodDetalle.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        }
    }

}
