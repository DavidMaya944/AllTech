package logic;

import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.alltech_cliente.ActivityAjustes;
import com.example.alltech_cliente.LoginActivity;
import com.example.alltech_cliente.MainActivity;
import com.example.alltech_cliente.RegistroActivity;
import com.example.alltech_cliente.Tienda_activity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.List;

import model.Usuario;

public class LogicaUsuario {
    public static List<Usuario> lUsuario;
    public static int iPos;
    LogicaProducto logProd = new LogicaProducto();
    public static boolean isLogged;

    public void getUsuario(){
        new login_user().execute(Adapter.DOMINIO + "/usuarios/get-login-user.php");
    }

    public void deleteUser(){
        new delete_user().execute(Adapter.DOMINIO + "usuarios/delete-user-email.php?EMAIL=" + ActivityAjustes.txtAjEmail.getText());
    }

    public void getUserEmail(){
        new get_user_email().execute(Adapter.DOMINIO + "/usuarios/get-email.php?EMAIL=" + MainActivity.preferences.getString("email", ""));
    }

    public void registroUser(){
        new registro_user().execute(insert());
    }

    private class login_user extends AsyncTask<String, Void, Void> {

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
            Type type = new TypeToken<List<Usuario>>() {
            }.getType();
            lUsuario = new Gson().fromJson(sResultado, type);
            compararCredenciales();
            
        }
    }

    private class delete_user extends AsyncTask<String, Void, Void> {

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

        }
    }

    private class registro_user extends AsyncTask<String, Void, Void> {

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


        }
    }

    public void compararCredenciales(){
        int iValidacion = 0;
        boolean bExito = false;
        String sEmail = LoginActivity.txtUserEmail.getText().toString();
        String sPassword = LoginActivity.txtPass.getText().toString();

        while(iPos < lUsuario.size() && !bExito){
            if(sEmail.equals(lUsuario.get(iPos).getEMAIL()) && sPassword.equals(lUsuario.get(iPos).getPASSWORD())
                    && "ACEPTADO".equals(lUsuario.get(iPos).getPERMISO())){
                iValidacion = 1;
                bExito = true;
            }else if(sEmail.equals(lUsuario.get(iPos).getEMAIL()) && sPassword.equals(lUsuario.get(iPos).getPASSWORD())
                    && !"EN%20ESPERA".equals(lUsuario.get(iPos).getPERMISO())){
                iValidacion = 2;
                bExito = false;
            }else{
                iValidacion = 3;
                bExito = false;
            }
            iPos++;
        }
        iPos = 0;

        switch (iValidacion){
            case 1:
                logProd.getProductos();
                break;
            case 2:
                Toast.makeText(LoginActivity.context, "Esperando verificación", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(LoginActivity.context, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private class update_user extends AsyncTask<String, Void, Void> {

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
        }


    }

    private class get_user_email extends AsyncTask<String, Void, Void> {

        String sResultado;

        @Override
        protected Void doInBackground(String... params) {
            try {
                URL url = new URL(params[0]);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
                String stringBuffer;
                String str = "";
                while ((stringBuffer = bufferedReader.readLine()) != null) {
                    str = String.format("%s%s", str, stringBuffer);
                }

                sResultado = str;
                bufferedReader.close();
            } catch (IOException e) {
                sResultado = e.getMessage();
            }
            return null;
        }

        @Override
        public void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Type type = new TypeToken<List<Usuario>>() {
            }.getType();
            lUsuario = new Gson().fromJson(sResultado, type);
            Intent ajustes = new Intent(Tienda_activity.contextTienda, ActivityAjustes.class);
            Tienda_activity.contextTienda.startActivity(ajustes.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        }
    }

    public String insert() {
        String sNombre = RegistroActivity.txtNombre.getText().toString();
        String sApellidos = RegistroActivity.txtApellidos.getText().toString();
        String sEmail = RegistroActivity.txtEmail.getText().toString();
        String sDireccion = RegistroActivity.txtDireccion.getText().toString();
        String sUsuario = RegistroActivity.txtUsuario.getText().toString();
        String sPassword = RegistroActivity.txtPassword.getText().toString();
        String sTelefono = RegistroActivity.txtTelefono.getText().toString();
        String sql = Adapter.DOMINIO + "/usuarios/insert-usuarioCliente.php?NOMBRE=" + sNombre;
        sql += "&APELLIDOS=" + sApellidos + "&EMAIL=" + sEmail + "&DIRECCION=" + sDireccion;
        sql += "&USUARIO=" + sUsuario + "&PASSWORD=" + sPassword + "&TELEFONO=" + sTelefono + "&PERMISO=EN%20ESPERA&ROL=0";
        return sql;
    }
}