package com.example.tp_integrador_paii.ui.gallery;

import static android.content.Context.MODE_PRIVATE;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.tp_integrador_paii.MainActivity;
import com.example.tp_integrador_paii.R;
import com.example.tp_integrador_paii.SignInActivity;
import com.example.tp_integrador_paii.adapter.AntiguedadSpinnerAdapter;
import com.example.tp_integrador_paii.adapter.ConformeSpinnerAdapter;
import com.example.tp_integrador_paii.adapter.EdadSpinnerAdapter;
import com.example.tp_integrador_paii.adapter.EstudioSpinnerAdapter;
import com.example.tp_integrador_paii.adapter.HoraSemanalSpinnerAdapter;
import com.example.tp_integrador_paii.adapter.RelacionContractualSpinnerAdapter;
import com.example.tp_integrador_paii.adapter.RubroSpinnerAdapter;
import com.example.tp_integrador_paii.adapter.SalarioSpinnerAdapter;
import com.example.tp_integrador_paii.adapter.SexoSpinnerAdapter;
import com.example.tp_integrador_paii.adapter.TrabajoSpinnerAdapter;
import com.example.tp_integrador_paii.daoSQLite.DaoHelperAntiguedad;
import com.example.tp_integrador_paii.daoSQLite.DaoHelperConforme;
import com.example.tp_integrador_paii.daoSQLite.DaoHelperEdad;
import com.example.tp_integrador_paii.daoSQLite.DaoHelperEncuesta;
import com.example.tp_integrador_paii.daoSQLite.DaoHelperEncuestador;
import com.example.tp_integrador_paii.daoSQLite.DaoHelperEstudio;
import com.example.tp_integrador_paii.daoSQLite.DaoHelperHoraSemanal;
import com.example.tp_integrador_paii.daoSQLite.DaoHelperRelacionContractual;
import com.example.tp_integrador_paii.daoSQLite.DaoHelperRubro;
import com.example.tp_integrador_paii.daoSQLite.DaoHelperSalario;
import com.example.tp_integrador_paii.daoSQLite.DaoHelperSexo;
import com.example.tp_integrador_paii.daoSQLite.DaoHelperTrabajo;
import com.example.tp_integrador_paii.databinding.FragmentGalleryBinding;
import com.example.tp_integrador_paii.entidad.Antiguedad;
import com.example.tp_integrador_paii.entidad.Conforme;
import com.example.tp_integrador_paii.entidad.Edad;
import com.example.tp_integrador_paii.entidad.Encuesta;
import com.example.tp_integrador_paii.entidad.Encuestador;
import com.example.tp_integrador_paii.entidad.Estudio;
import com.example.tp_integrador_paii.entidad.Hora_Semanal;
import com.example.tp_integrador_paii.entidad.Relacion_Contractual;
import com.example.tp_integrador_paii.entidad.Rubro;
import com.example.tp_integrador_paii.entidad.Salario;
import com.example.tp_integrador_paii.entidad.Sexo;
import com.example.tp_integrador_paii.entidad.Trabajo;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textGallery;
        final RadioGroup rgP1 = binding.rgP1;
        final RadioButton rbSiRGP1 = binding.rbSiRgp1Gallery;
        final RadioButton rbNoRGP1 = binding.rbNoRgp1Gallery;
        final Spinner spP2 = binding.spP2Gallery;
        final Spinner spP3 = binding.spP3Gallery;
        final Spinner spP4 = binding.spP4Gallery;
        final Spinner spP5 = binding.spP5Gallery;
        final RadioGroup rgP6 = binding.rgP6;
        final RadioButton rbSiRGP6 = binding.rbSiRgp6Gallery;
        final RadioButton rbNoRGP6 = binding.rbNoRgp6Gallery;
        final Spinner spP7 = binding.spP7Gallery;
        final Spinner spP8 = binding.spP8Gallery;
        final Spinner spP9 = binding.spP9Gallery;
        final Spinner spP10 = binding.spP10Gallery;
        final Spinner spP11 = binding.spP11Gallery;
        final Spinner spP12 = binding.spP12Gallery;
        final Button btnFin = binding.btnFinalizarGallery;

        galleryViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        rgP1.check(rbSiRGP1.getId());
        rgP6.check(rbSiRGP6.getId());

        cargarSpSexos(spP2);
        cargarSpEstudios(spP3);
        cargarSpEdades(spP4);
        cargarSpTrabajos(spP5);
        cargarSpRelacionesContractuales(spP7);
        cargarSpRubros(spP8);
        cargarSpHorasSemanales(spP9);
        cargarSpAntiguedades(spP10);
        cargarSpSalarios(spP11);
        cargarSpConformes(spP12);

        rgP1.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == rbSiRGP1.getId()) {
                Toast.makeText(getContext(), "Si", Toast.LENGTH_SHORT).show();
                habilitarPreguntas(spP2, spP3, spP4, spP5, spP7, spP8, spP9, spP10, spP11, spP12, true, rgP6);
            } else {
                Toast.makeText(getContext(), "No", Toast.LENGTH_SHORT).show();
                habilitarPreguntas(spP2, spP3, spP4, spP5, spP7, spP8, spP9, spP10, spP11, spP12, false, rgP6);
            }
        });

        rgP6.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == rbSiRGP6.getId()) {
                Toast.makeText(getContext(), "Si", Toast.LENGTH_SHORT).show();
                habilitarPreguntas11y12(spP11, spP12, true);
            } else {
                Toast.makeText(getContext(), "No", Toast.LENGTH_SHORT).show();
                habilitarPreguntas11y12(spP11, spP12, false);
            }
        });


        btnFin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder confirmacion = new AlertDialog.Builder(getContext())
                        .setIcon(R.drawable.baseline_save_24)
                        .setTitle("Guardar encuesta")
                        .setMessage("¿Desea guardar la encuesta?")
                        .setCancelable(false);
                confirmacion.setPositiveButton("Si", new DialogInterface.OnClickListener() {


                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        guardarEncuesta(spP2, spP3, spP4, spP5, spP7, spP8, spP9, spP10, spP11, spP12, rgP1, rbNoRGP1, rgP6, rbNoRGP6);

                    }

                });

                confirmacion.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getContext(), "Encuesta no guardada", Toast.LENGTH_SHORT).show();
                    }


                });


                confirmacion.show();
            }

        });

        return root;
    }

    private void habilitarPreguntas11y12(Spinner spP11, Spinner spP12, boolean b) {
        spP11.setEnabled(b);
        spP12.setEnabled(b);

        spP11.setVisibility(b ? View.VISIBLE : View.GONE);
        spP12.setVisibility(b ? View.VISIBLE : View.GONE);
    }

    private void guardarEncuesta(Spinner spP2, Spinner spP3, Spinner spP4, Spinner spP5, Spinner spP7, Spinner spP8, Spinner spP9, Spinner spP10, Spinner spP11, Spinner spP12, RadioGroup rgP1, RadioButton rbNoRGP1, RadioGroup rgP6, RadioButton rbNoRGP6) {
        if (rgP1.getCheckedRadioButtonId() == rbNoRGP1.getId()) {
            Toast.makeText(getContext(), "Encuesta descartada", Toast.LENGTH_SHORT).show();
            limpiarCampos(spP2, spP3, spP4, spP5, spP7, spP8, spP9, spP10, spP11, spP12, rgP1, rgP6);
            return;
        }

        Encuesta encuesta = new Encuesta();
        encuesta.setId_sexo((Sexo) spP2.getSelectedItem());
        encuesta.setId_estudio((Estudio) spP3.getSelectedItem());
        encuesta.setId_edad((Edad) spP4.getSelectedItem());
        encuesta.setId_trabajo((Trabajo) spP5.getSelectedItem());
        encuesta.setId_relacion_contractual((Relacion_Contractual) spP7.getSelectedItem());
        encuesta.setId_rubro((Rubro) spP8.getSelectedItem());
        encuesta.setId_hora_semanal((Hora_Semanal) spP9.getSelectedItem());
        encuesta.setId_antiguedad((Antiguedad) spP10.getSelectedItem());
        encuesta.setId_salario((Salario) spP11.getSelectedItem());
        encuesta.setId_conforme((Conforme) spP12.getSelectedItem());
        encuesta.setId_salario((Salario) spP11.getSelectedItem());
        encuesta.setId_conforme((Conforme) spP12.getSelectedItem());

        if (rgP6.getCheckedRadioButtonId() == rbNoRGP6.getId()) {
            spP11.setSelection(spP11.getAdapter().getCount() - 1);
            spP12.setSelection(spP12.getAdapter().getCount() - 2);

            encuesta.setId_salario((Salario) spP11.getSelectedItem());
            encuesta.setId_conforme((Conforme) spP12.getSelectedItem());
        } else {
            encuesta.setId_salario((Salario) spP11.getSelectedItem());
            encuesta.setId_conforme((Conforme) spP12.getSelectedItem());
        }

        SharedPreferences sp = getActivity().getSharedPreferences(SignInActivity.SHARED_PREFERENCES_LOGIN_DATA, MODE_PRIVATE);
        String username = sp.getString(SignInActivity.SHARED_PREFERENCES_USERNAME, "desconocido");

        Encuestador encuestador = new Encuestador();
        encuestador = DaoHelperEncuestador.obtenerUno(username, getActivity());

        encuesta.setId_encuestador(encuestador);

        if (DaoHelperEncuesta.insertar(encuesta, getActivity())) {
            Toast.makeText(getContext(), "Encuesta guardada", Toast.LENGTH_SHORT).show();
            Intent volver = new Intent();
            volver.setClass(getContext(), MainActivity.class);
            startActivity(volver);
        } else {
            Toast.makeText(getContext(), "Error al guardar encuesta", Toast.LENGTH_SHORT).show();
        }
        limpiarCampos(spP2, spP3, spP4, spP5, spP7, spP8, spP9, spP10, spP11, spP12, rgP1, rgP6);
    }

    private void limpiarCampos(Spinner spP2, Spinner spP3, Spinner spP4, Spinner spP5, Spinner spP7, Spinner spP8, Spinner spP9, Spinner spP10, Spinner spP11, Spinner spP12, RadioGroup rgP1, RadioGroup rgP6) {
        spP2.setSelection(0);
        spP3.setSelection(0);
        spP4.setSelection(0);
        spP5.setSelection(0);
        spP7.setSelection(0);
        spP8.setSelection(0);
        spP9.setSelection(0);
        spP10.setSelection(0);
        spP11.setSelection(0);
        spP12.setSelection(0);
        rgP1.check(rgP1.getChildAt(0).getId());
        rgP6.check(rgP6.getChildAt(0).getId());
        rgP1.getChildAt(0).requestFocus();
    }

    private void habilitarPreguntas(Spinner spP2, Spinner spP3, Spinner spP4, Spinner spP5, Spinner spP7, Spinner spP8, Spinner spP9, Spinner spP10, Spinner spP11, Spinner spP12, boolean b, RadioGroup rgP6) {
        spP2.setEnabled(b);
        spP3.setEnabled(b);
        spP4.setEnabled(b);
        spP5.setEnabled(b);
        spP7.setEnabled(b);
        spP8.setEnabled(b);
        spP9.setEnabled(b);
        spP10.setEnabled(b);
        spP11.setEnabled(b);
        spP12.setEnabled(b);
        rgP6.setEnabled(b);

        spP2.setVisibility(b ? View.VISIBLE : View.GONE);
        spP3.setVisibility(b ? View.VISIBLE : View.GONE);
        spP4.setVisibility(b ? View.VISIBLE : View.GONE);
        spP5.setVisibility(b ? View.VISIBLE : View.GONE);
        spP7.setVisibility(b ? View.VISIBLE : View.GONE);
        spP8.setVisibility(b ? View.VISIBLE : View.GONE);
        spP9.setVisibility(b ? View.VISIBLE : View.GONE);
        spP10.setVisibility(b ? View.VISIBLE : View.GONE);
        spP11.setVisibility(b ? View.VISIBLE : View.GONE);
        spP12.setVisibility(b ? View.VISIBLE : View.GONE);
        rgP6.setVisibility(b ? View.VISIBLE : View.GONE);
    }

    private void cargarSpSexos(Spinner sp) {
        List<Sexo> lista = new ArrayList<Sexo>();
        lista = DaoHelperSexo.obtenerTodos(getActivity());
        SexoSpinnerAdapter adapter = new SexoSpinnerAdapter(getContext(), lista);
        sp.setAdapter(adapter);
    }

    private void cargarSpEstudios(Spinner sp) {
        List<Estudio> lista = new ArrayList<Estudio>();
        lista = DaoHelperEstudio.obtenerTodos(getActivity());
        EstudioSpinnerAdapter adapter = new EstudioSpinnerAdapter(getContext(), lista);
        sp.setAdapter(adapter);
    }

    private void cargarSpEdades(Spinner sp) {
        List<Edad> lista = new ArrayList<Edad>();
        lista = DaoHelperEdad.obtenerTodos(getActivity());
        EdadSpinnerAdapter adapter = new EdadSpinnerAdapter(getContext(), lista);
        sp.setAdapter(adapter);
    }

    private void cargarSpTrabajos(Spinner sp) {
        List<Trabajo> lista = new ArrayList<Trabajo>();
        lista = DaoHelperTrabajo.obtenerTodos(getActivity());
        TrabajoSpinnerAdapter adapter = new TrabajoSpinnerAdapter(getContext(), lista);
        sp.setAdapter(adapter);
    }

    private void cargarSpRelacionesContractuales(Spinner sp) {
        List<Relacion_Contractual> lista = new ArrayList<Relacion_Contractual>();
        lista = DaoHelperRelacionContractual.obtenerTodos(getActivity());
        RelacionContractualSpinnerAdapter adapter = new RelacionContractualSpinnerAdapter(getContext(), lista);
        sp.setAdapter(adapter);
    }

    private void cargarSpRubros(Spinner sp) {
        List<Rubro> lista = new ArrayList<Rubro>();
        lista = DaoHelperRubro.obtenerTodos(getActivity());
        RubroSpinnerAdapter adapter = new RubroSpinnerAdapter(getContext(), lista);
        sp.setAdapter(adapter);
    }

    private void cargarSpHorasSemanales(Spinner sp) {
        List<Hora_Semanal> lista = new ArrayList<Hora_Semanal>();
        lista = DaoHelperHoraSemanal.obtenerTodos(getActivity());
        HoraSemanalSpinnerAdapter adapter = new HoraSemanalSpinnerAdapter(getContext(), lista);
        sp.setAdapter(adapter);
    }

    private void cargarSpAntiguedades(Spinner sp) {
        List<Antiguedad> lista = new ArrayList<Antiguedad>();
        lista = DaoHelperAntiguedad.obtenerTodos(getActivity());
        AntiguedadSpinnerAdapter adapter = new AntiguedadSpinnerAdapter(getContext(), lista);
        sp.setAdapter(adapter);
    }

    private void cargarSpSalarios(Spinner sp) {
        List<Salario> lista = new ArrayList<Salario>();
        lista = DaoHelperSalario.obtenerTodos(getActivity());
        SalarioSpinnerAdapter adapter = new SalarioSpinnerAdapter(getContext(), lista);
        sp.setAdapter(adapter);
    }

    private void cargarSpConformes(Spinner sp) {
        List<Conforme> lista = new ArrayList<Conforme>();
        lista = DaoHelperConforme.obtenerTodos(getActivity());
        ConformeSpinnerAdapter adapter = new ConformeSpinnerAdapter(getContext(), lista);
        sp.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}