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
    public static Intent appIn;

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
            compararCredenciales();
            
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
        String sEmail = LoginActivity.txtUserEmail.getText().toString();
        String sPassword = LoginActivity.txtPass.getText().toString();

        while(iPos < lUsuario.size() && iValidacion == 0){
            if(sEmail.equals(lUsuario.get(iPos).getEMAIL()) && sPassword.equals(lUsuario.get(iPos).getPASSWORD())
                    && "ACEPTADO".equals(lUsuario.get(iPos).getPERMISO())){
                iValidacion = 1;

            }else if(sEmail.equals(lUsuario.get(iPos).getEMAIL()) && sPassword.equals(lUsuario.get(iPos).getPASSWORD())
                    && !"ACEPTADO".equals(lUsuario.get(iPos).getPERMISO())){
                iValidacion = 2;

            }else{
                iValidacion = 3;
            }
            iPos++;
        }

        switch (iValidacion){
            case 1:
                appIn = new Intent(LoginActivity.context, Tienda_activity.class);
                LoginActivity.context.startActivity(appIn.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                break;
            case 2:
                Toast.makeText(LoginActivity.context, "Sin permiso aún. Inténtelo más tarde", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(LoginActivity.context, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                break;
        }
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