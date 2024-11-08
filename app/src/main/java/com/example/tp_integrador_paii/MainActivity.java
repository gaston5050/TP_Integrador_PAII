package com.example.tp_integrador_paii;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tp_integrador_paii.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null)
                        .setAnchorView(R.id.fab).show();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow, R.id.nav_sign_out)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        navigationView.setNavigationItemSelectedListener(item -> {
            // Handle sign out action
            if (item.getItemId() == R.id.nav_sign_out) {
                salir();
                return true;
            }
            // Para otros elementos del menú, deja que NavigationUI maneje la navegación
            boolean handled = NavigationUI.onNavDestinationSelected(item, navController);

            // Cierra el drawer después de la navegación
            drawer.closeDrawer(GravityCompat.START);
            return handled;
        });

        datosUsuarioMenuHamburgueza();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    private void datosUsuarioMenuHamburgueza() {
        NavigationView navigationView = binding.navView;
        View headerView = navigationView.getHeaderView(0);
        ImageView imageView = headerView.findViewById(R.id.imageView);
        TextView titleTextView = headerView.findViewById(R.id.tv_title);
        TextView subtitleTextView = headerView.findViewById(R.id.textView);

        SharedPreferences sp = getSharedPreferences(SignInActivity.SHARED_PREFERENCES_LOGIN_DATA, MODE_PRIVATE);
        String username = sp.getString(SignInActivity.SHARED_PREFERENCES_USERNAME, "desconocido");

        /*imageView.setImageResource(R.drawable.nueva_imagen);*/
        titleTextView.setText("CUE encuestador: " + username);
        subtitleTextView.setText("Bienvenido");
    }

    private void salir() {
        Toast.makeText(this, "Sign out", Toast.LENGTH_SHORT).show();
        limpairSp();
        irSignInActivity();
    }


    private void limpairSp() {
        SharedPreferences sp = getSharedPreferences(SignInActivity.SHARED_PREFERENCES_LOGIN_DATA, MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(SignInActivity.SHARED_PREFERENCES_USERNAME);
        editor.apply();
    }

    private void irSignInActivity() {
        startActivity(new Intent(this, SignInActivity.class));
        finish();
    }
}
