package com.example.tp_integrador_paii.ui.slideshow;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.tp_integrador_paii.SignInActivity;
import com.example.tp_integrador_paii.conexion.DataEncuestaMainActivity;
import com.example.tp_integrador_paii.daoSQLite.DaoHelperEncuesta;
import com.example.tp_integrador_paii.databinding.FragmentSlideshowBinding;
import com.example.tp_integrador_paii.entidad.Encuesta;

import java.util.List;

public class SlideshowFragment extends Fragment {

    private FragmentSlideshowBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textSlideshow;
        final Button btnUpload = binding.btnUpload;

        slideshowViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        slideshowViewModel.setBtnUploadValue("Sincronizar encuestas");
        slideshowViewModel.getBtnUpload().observe(getViewLifecycleOwner(), btnUpload::setText);

        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                slideshowViewModel.setBtnUploadValue("Sincronizando...");
                btnUpload.setEnabled(false);
                sincronizarEncuestas(textView);
                slideshowViewModel.setBtnUploadValue("Sincronizar encuestas");
                btnUpload.setEnabled(true);
            }
        });

        return root;
    }

    private void sincronizarEncuestas(TextView textView) {
        //TODO: sincronizar encuestas
        SharedPreferences sp = getActivity().getSharedPreferences(SignInActivity.SHARED_PREFERENCES_LOGIN_DATA, MODE_PRIVATE);
        String username = sp.getString(SignInActivity.SHARED_PREFERENCES_USERNAME, "desconocido");
        List<Encuesta> encuestas = DaoHelperEncuesta.obtenerPorEncuestador(username, getActivity());

        if (encuestas.size() == 0) {
            textView.setText("No hay encuestas para sincronizar");
            return;
        }

        textView.setText("Sincronizando encuestas...");

        Log.d("Sincronizar", "username: " + username);

        for (Encuesta encuesta : DaoHelperEncuesta.obtenerPorEncuestador(username, getActivity())) {
            Log.d("Sincronizar", encuesta.toString());
            DataEncuestaMainActivity.insertar(encuesta, new DataEncuestaMainActivity.EncuestaCallback() {
                @Override
                public void onResponse(Object response) {

                    DaoHelperEncuesta.eliminar(((Encuesta) response).getId(), getActivity());
                }

                @Override
                public void onError(String mensaje) {
                    textView.setText("Error al sincronizar: " + mensaje);
                }
            });
        }

        textView.setText("Sincronizacion finalizada");

        if (DaoHelperEncuesta.obtenerTodos(getActivity()).size() == 0) {
            DaoHelperEncuesta.reiniciarAutoincrement(getActivity());
            textView.setText("Sincronizacion finalizada. No hay encuestas para sincronizar");
        } else {
            textView.setText("Sincronizacion finalizada. Hay encuestas para sincronizar de otro/os encuestadores: " + DaoHelperEncuesta.obtenerTodos(getActivity()).size());
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}