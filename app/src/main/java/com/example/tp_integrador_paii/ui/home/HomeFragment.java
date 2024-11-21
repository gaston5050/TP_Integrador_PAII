package com.example.tp_integrador_paii.ui.home;

import static android.content.Context.MODE_PRIVATE;

import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.tp_integrador_paii.R;
import com.example.tp_integrador_paii.SignInActivity;
import com.example.tp_integrador_paii.adapter.EncuestaListAdapter;
import com.example.tp_integrador_paii.daoSQLite.DaoHelperEncuesta;
import com.example.tp_integrador_paii.databinding.FragmentHomeBinding;
import com.example.tp_integrador_paii.entidad.Encuesta;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        final ListView lvEncuesta = binding.lista;
        final ArrayList<Encuesta> listaEncuestas = (ArrayList<Encuesta>) DaoHelperEncuesta.obtenerTodos(getActivity());
        final TextView txtElementoSeleccionado = binding.txtElementoSeleccionado;

        Integer encuestas = contarEncuestas();
        homeViewModel.setTextValue("ENCUESTAS REALIZADAS: " + encuestas);
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        EncuestaListAdapter adapter = new EncuestaListAdapter(getActivity(), listaEncuestas);
        lvEncuesta.setAdapter(adapter);

        lvEncuesta.setOnItemClickListener((parent, view, position, id) -> {
            Encuesta encuesta = listaEncuestas.get(position);
            txtElementoSeleccionado.setText("ID Encuesta seleccionada: " + encuesta.getId());
            AlertDialog.Builder confirmacion = new AlertDialog.Builder(getContext())
                    .setIcon(R.drawable.ic_delete_24)
                    .setTitle("Borrar encuesta")
                    .setMessage("¿Desea borrar la encuesta?")
                    .setCancelable(false);
            confirmacion.setPositiveButton("Si", (dialogInterface, i) -> {
                DaoHelperEncuesta.eliminar(encuesta.getId(), getActivity());
                listaEncuestas.remove(encuesta);
                adapter.notifyDataSetChanged();
                Toast.makeText(getContext(), "Encuesta borrada", Toast.LENGTH_SHORT).show();
                homeViewModel.setTextValue("ENCUESTAS REALIZADAS: " + contarEncuestas());
                txtElementoSeleccionado.setText("ID Encuesta seleccionada: ");
            });
            confirmacion.setNegativeButton("NO", (dialogInterface, i) -> {
                Toast.makeText(getContext(), "Encuesta no borrada", Toast.LENGTH_SHORT).show();
            });
            confirmacion.show();
        });

        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private Integer contarEncuestas() {
        SharedPreferences sp = getActivity().getSharedPreferences(SignInActivity.SHARED_PREFERENCES_LOGIN_DATA, MODE_PRIVATE);
        String username = sp.getString(SignInActivity.SHARED_PREFERENCES_USERNAME, "desconocido");
        return DaoHelperEncuesta.obtenerPorEncuestador(username, getActivity()).size();
    }
}