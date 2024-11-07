package com.example.tp_integrador_paii;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tp_integrador_paii.daoSQLite.DaoHelperEncuestador;

public class SignInActivity extends AppCompatActivity {

    private EditText etUsername;
    private EditText etPassword;
    private Button btnSignIn;

    public static final String SHARED_PREFERENCES_LOGIN_DATA = "spLoginData";
    public static final String SHARED_PREFERENCES_USERNAME = "username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_in);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btnSignIn = findViewById(R.id.btn_signin);
    }

    public void signIn(View view) {
        // TODO: Add sign in logic
        String username = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        if (validarCampos(username, password)) {
            String mensajeToast = "";
            if (validarLogin(username, password)) {
                cargarSP(username);
                limpiarCampos();
                mensajeToast = "Bienvenido " + username;
                irMainActivity();
            } else {
                mensajeToast = "Usuario o contraseña incorrectos, intente de nuevo porfavor";
                limpiarCampos();
            }
            Toast.makeText(this, mensajeToast, Toast.LENGTH_SHORT).show();
        }
    }

    private void irMainActivity() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    private void cargarSP(String username) {
        //TODO: cargar shared preferences
        SharedPreferences sp = getSharedPreferences(SHARED_PREFERENCES_LOGIN_DATA, MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(SHARED_PREFERENCES_USERNAME, username);
        editor.apply();
    }

    private boolean validarLogin(String username, String password) {
        return DaoHelperEncuestador.login(username, password, this) != null;
    }

    private boolean validarCampos(String username, String password) {
        if (username.isEmpty() || username.length() < 3) {
            Toast.makeText(this, "Ingrese un usuario porfavor", Toast.LENGTH_SHORT).show();
            etUsername.setError("Ingrese un usuario porfavor, minimo 3 caracteres");
            etUsername.requestFocus();
            return false;
        }

        if (password.isEmpty() || password.length() < 4) {
            Toast.makeText(this, "Ingrese una contraseña porfavor", Toast.LENGTH_SHORT).show();
            etPassword.setError("Ingrese una contraseña porfavor, minimo 4 caracteres");
            etPassword.requestFocus();
            return false;
        }

        return true;
    }

    private void limpiarCampos() {
        etUsername.setText("");
        etPassword.setText("");
        etUsername.requestFocus();
    }
}