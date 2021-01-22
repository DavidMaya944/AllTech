package logic;

import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.alltech_cliente.LoginActivity;
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
    public static Intent intent;

    public void getUsuario(){
        new login_user().execute("http://davidmaya.atwebpages.com/UsuarioCliente/get-login-user.php");
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
            if(compararCredenciales()){
                intent = new Intent(LoginActivity.context, Tienda_activity.class);
                LoginActivity.context.startActivity(intent);
            }
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

    public boolean compararCredenciales(){
        boolean bExito = false;
        String sEmail = LoginActivity.txtUserEmail.getText().toString();
        Log.i("MAYA", "Email por teclado = " + sEmail);
        String sPassword = LoginActivity.txtPass.getText().toString();
        Log.i("MAYA", "Password por tecladdo = " + sPassword);
        Usuario u = lUsuario.get(iPos);
        Log.i("PRUEBA", "Usuario de la posicion = " + iPos + " es: " + u);

        while(iPos < lUsuario.size() && !bExito){
            if(sEmail.equals(lUsuario.get(iPos).getEMAIL()) && sPassword.equals(lUsuario.get(iPos).getPASSWORD())
                    && "ACEPTADO".equals(lUsuario.get(iPos).getPERMISO())){
                Log.i("MAYA", "Son Iguales!!");
                Log.i("MAYA", "Email BD: " + lUsuario.get(iPos).getEMAIL());
                Log.i("MAYA","Password BD: " + lUsuario.get(iPos).getPASSWORD());
                Log.i("MAYA", "Permiso: " + lUsuario.get(iPos).getPERMISO());
                bExito = true;
            }else{
                bExito = false;
                Log.i("MAYA", "Lo siento :(");
            }
            iPos++;
        }
        Log.i("PRUEBA", "Usuario de la posicion DESPUES DEL WHILE = " + iPos + " es: " + u);
        Log.i("MAYA", "bExito = " + bExito);
       return bExito;
    }

    public String insert(){
        String sNombre = RegistroActivity.txtNombre.getText().toString();
        String sApellidos = RegistroActivity.txtApellidos.getText().toString();
        String sEmail = RegistroActivity.txtEmail.getText().toString();
        String sDireccion = RegistroActivity.txtDireccion.getText().toString();
        String sUsuario = RegistroActivity.txtUsuario.getText().toString();
        String sPassword = RegistroActivity.txtPassword.getText().toString();
        String sTelefono = RegistroActivity.txtTelefono.getText().toString();
        Log.i("MAYA","Entra en el insert");
        String sql = "http://davidmaya.atwebpages.com/UsuarioCliente/insert-usuarioCliente.php?NOMBRE=" + sNombre;
        sql += "&APELLIDOS=" + sApellidos + "&EMAIL=" + sEmail + "&DIRECCION=" + sDireccion;
        sql += "&USUARIO=" + sUsuario + "&PASSWORD=" + sPassword + "&TELEFONO=" + sTelefono + "&PERMISO=EN%20ESPERA";
        Log.i("MAYA","Hace el insert");
        return sql;
    }

}