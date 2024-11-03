package com.example.tp_integrador_paii;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tp_integrador_paii.daoSQLite.DaoHelperAntiguedad;
import com.example.tp_integrador_paii.daoSQLite.DaoHelperConforme;
import com.example.tp_integrador_paii.daoSQLite.DaoHelperEdad;
import com.example.tp_integrador_paii.daoSQLite.DaoHelperEncuestador;
import com.example.tp_integrador_paii.daoSQLite.DaoHelperEstudio;
import com.example.tp_integrador_paii.daoSQLite.DaoHelperHoraSemanal;
import com.example.tp_integrador_paii.daoSQLite.DaoHelperRelacionContractual;
import com.example.tp_integrador_paii.daoSQLite.DaoHelperRubro;
import com.example.tp_integrador_paii.daoSQLite.DaoHelperSalario;
import com.example.tp_integrador_paii.daoSQLite.DaoHelperSexo;
import com.example.tp_integrador_paii.daoSQLite.DaoHelperTrabajo;
import com.example.tp_integrador_paii.entidad.Antiguedad;
import com.example.tp_integrador_paii.entidad.Conforme;
import com.example.tp_integrador_paii.entidad.Edad;
import com.example.tp_integrador_paii.entidad.Encuestador;
import com.example.tp_integrador_paii.entidad.Estudio;
import com.example.tp_integrador_paii.entidad.Hora_Semanal;
import com.example.tp_integrador_paii.entidad.Relacion_Contractual;
import com.example.tp_integrador_paii.entidad.Rubro;
import com.example.tp_integrador_paii.entidad.Salario;
import com.example.tp_integrador_paii.entidad.Sexo;
import com.example.tp_integrador_paii.entidad.Trabajo;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        iniciarBaseSQLite();

        int tiempo = 3000;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, SignInActivity.class));
                finish();
            }
        }, tiempo);
    }

    private void iniciarBaseSQLite() {
        //TODO: iniciar base de datos
        /* tabla Encuestador */
        cargarEncustadores();
        /* tabla Sexo */
        cargarSexos();
        /* tabla Estudio */
        cargarEstudios();
        /* tabla Edad */
        cargarEdades();
        /* tabla Trabajo */
        cargarTrabajos();
        /* tabla Relacion_Contractual */
        cargarRelacionesContractuales();
        /* tabla Rubro */
        cargarRubros();
        /* tabla Hora_Semanal */
        cargarHorasSemanales();
        /* tabla Antiguedad */
        cargarAntiguedades();
        /* tabla Salario */
        cargarSalarios();
        /* tabla Conforme */
        cargarConformes();
    }


    private void cargarEncustadores() {
        DaoHelperEncuestador.insertar(
                new Encuestador("001", "1234"),
                this
        );
        DaoHelperEncuestador.insertar(
                new Encuestador("002", "1234"),
                this
        );
    }

    private void cargarSexos() {
        if (DaoHelperSexo.obtenerTodos(this).size() == 0) {
            DaoHelperSexo.insertar(
                    new Sexo("M"),
                    this
            );
            DaoHelperSexo.insertar(
                    new Sexo("F"),
                    this
            );
        }
    }

    private void cargarEstudios() {
        if (DaoHelperEstudio.obtenerTodos(this).size() == 0) {
            DaoHelperEstudio.insertar(
                    new Estudio("Primaria"),
                    this
            );
            DaoHelperEstudio.insertar(
                    new Estudio("Secundaria"),
                    this
            );
            DaoHelperEstudio.insertar(
                    new Estudio("Terciaria"),
                    this
            );
            DaoHelperEstudio.insertar(
                    new Estudio("Universitaria"),
                    this
            );
            DaoHelperEstudio.insertar(
                    new Estudio("Post-grado"),
                    this
            );
            DaoHelperEstudio.insertar(
                    new Estudio("sin finalizar"),
                    this
            );
        }
    }

    private void cargarEdades() {
        if (DaoHelperEdad.obtenerTodos(this).size() == 0) {
            DaoHelperEdad.insertar(
                    new Edad("< de 18"),
                    this
            );
            DaoHelperEdad.insertar(
                    new Edad("18 a 35"),
                    this
            );
            DaoHelperEdad.insertar(
                    new Edad("36 a 50"),
                    this
            );
            DaoHelperEdad.insertar(
                    new Edad("51 a 65"),
                    this
            );
            DaoHelperEdad.insertar(
                    new Edad("> de 65"),
                    this
            );
        }
    }

    private void cargarTrabajos() {
        if (DaoHelperTrabajo.obtenerTodos(this).size() == 0) {
            DaoHelperTrabajo.insertar(
                    new Trabajo("1"),
                    this
            );
            DaoHelperTrabajo.insertar(
                    new Trabajo("> 1"),
                    this
            );
        }
    }

    private void cargarRelacionesContractuales() {
        if (DaoHelperRelacionContractual.obtenerTodos(this).size() == 0) {
            DaoHelperRelacionContractual.insertar(
                    new Relacion_Contractual("Relacion de dependencia"),
                    this
            );
            DaoHelperRelacionContractual.insertar(
                    new Relacion_Contractual("Monotributista/autonomo"),
                    this
            );
            DaoHelperRelacionContractual.insertar(
                    new Relacion_Contractual("Cuenta propista (no registrado)"),
                    this
            );
            DaoHelperRelacionContractual.insertar(
                    new Relacion_Contractual("Voluntariado"),
                    this
            );
            DaoHelperRelacionContractual.insertar(
                    new Relacion_Contractual("NS/NC"),
                    this
            );
        }
    }

    private void cargarRubros() {
        if (DaoHelperRubro.obtenerTodos(this).size() == 0) {
            DaoHelperRubro.insertar(
                    new Rubro("Tecnica"),
                    this
            );
            DaoHelperRubro.insertar(
                    new Rubro("Salud"),
                    this
            );
            DaoHelperRubro.insertar(
                    new Rubro("Educacion"),
                    this
            );
            DaoHelperRubro.insertar(
                    new Rubro("Administrativo"),
                    this
            );
            DaoHelperRubro.insertar(
                    new Rubro("Gobierno"),
                    this
            );
            DaoHelperRubro.insertar(
                    new Rubro("Comercio"),
                    this
            );
            DaoHelperRubro.insertar(
                    new Rubro("Cuidados y Asistencia Domestica"),
                    this
            );
            DaoHelperRubro.insertar(
                    new Rubro("Construccion"),
                    this
            );
            DaoHelperRubro.insertar(
                    new Rubro("Gastronomia"),
                    this
            );
            DaoHelperRubro.insertar(
                    new Rubro("Reciclado"),
                    this
            );
            DaoHelperRubro.insertar(
                    new Rubro("Trabajo de plataforma"),
                    this
            );
            DaoHelperRubro.insertar(
                    new Rubro("Otro"),
                    this
            );
        }
    }

    private void cargarHorasSemanales() {
        if (DaoHelperHoraSemanal.obtenerTodos(this).size() == 0) {
            DaoHelperHoraSemanal.insertar(
                    new Hora_Semanal("< 10"),
                    this
            );
            DaoHelperHoraSemanal.insertar(
                    new Hora_Semanal("11 ~ 32"),
                    this
            );
            DaoHelperHoraSemanal.insertar(
                    new Hora_Semanal("> 33"),
                    this
            );
        }
    }

    private void cargarAntiguedades() {
        if (DaoHelperAntiguedad.obtenerTodos(this).size() == 0) {
            DaoHelperAntiguedad.insertar(
                    new Antiguedad("Menos de 1 año"),
                    this
            );
            DaoHelperAntiguedad.insertar(
                    new Antiguedad("1 ~ 3 años"),
                    this
            );
            DaoHelperAntiguedad.insertar(
                    new Antiguedad("4 ~ 7 años"),
                    this
            );
            DaoHelperAntiguedad.insertar(
                    new Antiguedad("8 ~ 10 años"),
                    this
            );
            DaoHelperAntiguedad.insertar(
                    new Antiguedad("mas de 10 años"),
                    this
            );
        }
    }

    private void cargarSalarios() {
        if (DaoHelperSalario.obtenerTodos(this).size() == 0) {
            DaoHelperSalario.insertar(
                    new Salario("Menos de $300.000"),
                    this
            );
            DaoHelperSalario.insertar(
                    new Salario("$300.000 ~ $600.000"),
                    this
            );
            DaoHelperSalario.insertar(
                    new Salario("$600.000 ~ $1M"),
                    this
            );
            DaoHelperSalario.insertar(
                    new Salario("$1M ~ $3M"),
                    this
            );
            DaoHelperSalario.insertar(
                    new Salario("Mas de $3M"),
                    this
            );
            DaoHelperSalario.insertar(
                    new Salario("NO"),
                    this
            );
        }
    }

    private void cargarConformes() {
        if (DaoHelperConforme.obtenerTodos(this).size() == 0) {
            DaoHelperConforme.insertar(
                    new Conforme("Si"),
                    this
            );
            DaoHelperConforme.insertar(
                    new Conforme("No"),
                    this
            );
            DaoHelperConforme.insertar(
                    new Conforme("No lo se"),
                    this
            );
        }
    }
}
