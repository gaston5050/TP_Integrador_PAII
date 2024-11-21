package com.example.tp_integrador_paii;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tp_integrador_paii.conexion.DataAntiguedadMainActivity;
import com.example.tp_integrador_paii.conexion.DataConformeMainActivity;
import com.example.tp_integrador_paii.conexion.DataEdadMainActivity;
import com.example.tp_integrador_paii.conexion.DataEncuestadorMainActivity;
import com.example.tp_integrador_paii.conexion.DataEstudioMainActivity;
import com.example.tp_integrador_paii.conexion.DataHoraSemanal;
import com.example.tp_integrador_paii.conexion.DataRelacionContractualMainActivity;
import com.example.tp_integrador_paii.conexion.DataRubroMainActivity;
import com.example.tp_integrador_paii.conexion.DataSalarioMainActivity;
import com.example.tp_integrador_paii.conexion.DataSexoMainActivity;
import com.example.tp_integrador_paii.conexion.DataTrabajoMainActivity;
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

import java.util.List;

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
        DataEncuestadorMainActivity.obtenerTodos(new DataEncuestadorMainActivity.EncuestadorCallback() {
            @Override
            public void onResponse(Object response) {
                for (Encuestador encuestador : (List<Encuestador>) response) {
                    DaoHelperEncuestador.insertar(encuestador, SplashActivity.this);
                }
            }

            @Override
            public void onError(String mensaje) {
                System.out.println("Error: " + mensaje);
            }
        });
    }

    private void cargarSexos() {
        if (DaoHelperSexo.obtenerTodos(this).size() == 0) {
            DataSexoMainActivity.obtenerTodos(new DataSexoMainActivity.SexoCallback() {
                @Override
                public void onResponse(Object response) {
                    for (Sexo sexo : (List<Sexo>) response) {
                        DaoHelperSexo.insertar(sexo, SplashActivity.this);
                    }
                }

                @Override
                public void onError(String mensaje) {
                    System.out.println("Error: " + mensaje);
                }
            });
        }
    }

    private void cargarEstudios() {
        if (DaoHelperEstudio.obtenerTodos(this).size() == 0) {
            DataEstudioMainActivity.obtenerTodos(new DataEstudioMainActivity.EstudioCallback() {
                @Override
                public void onResponse(Object response) {
                    for (Estudio estudio : (List<Estudio>) response) {
                        DaoHelperEstudio.insertar(estudio, SplashActivity.this);
                    }
                }

                @Override
                public void onError(String mensaje) {
                    System.out.println("Error: " + mensaje);
                }

            });
        }
    }

    private void cargarEdades() {
        if (DaoHelperEdad.obtenerTodos(this).size() == 0) {
            DataEdadMainActivity.obtenerTodos(new DataEdadMainActivity.EdadCallback() {
                @Override
                public void onResponse(Object response) {
                    for (Edad edad : (List<Edad>) response) {
                        DaoHelperEdad.insertar(edad, SplashActivity.this);
                    }
                }

                @Override
                public void onError(String mensaje) {
                    System.out.println("Error: " + mensaje);
                }
            });
        }
    }

    private void cargarTrabajos() {
        if (DaoHelperTrabajo.obtenerTodos(this).size() == 0) {
            DataTrabajoMainActivity.obtenerTodos(new DataTrabajoMainActivity.TrabajoCallback() {
                @Override
                public void onResponse(Object response) {
                    for (Trabajo trabajo : (List<Trabajo>) response) {
                        DaoHelperTrabajo.insertar(trabajo, SplashActivity.this);
                    }
                }

                @Override
                public void onError(String mensaje) {
                    System.out.println("Error: " + mensaje);
                }
            });
        }
    }

    private void cargarRelacionesContractuales() {
        if (DaoHelperRelacionContractual.obtenerTodos(this).size() == 0) {
            DataRelacionContractualMainActivity.obtenerTodos(new DataRelacionContractualMainActivity.RelacionContractualCallback() {
                @Override
                public void onResponse(Object response) {
                    for (Relacion_Contractual relacion_contractual : (List<Relacion_Contractual>) response) {
                        DaoHelperRelacionContractual.insertar(relacion_contractual, SplashActivity.this);
                    }
                }

                @Override
                public void onError(String mensaje) {
                    System.out.println("Error: " + mensaje);
                }
            });
        }
    }

    private void cargarRubros() {
        if (DaoHelperRubro.obtenerTodos(this).size() == 0) {
            DataRubroMainActivity.obtenerTodos(new DataRubroMainActivity.RubroCallback() {
                @Override
                public void onResponse(Object response) {
                    for (Rubro rubro : (List<Rubro>) response) {
                        DaoHelperRubro.insertar(rubro, SplashActivity.this);
                    }
                }

                @Override
                public void onError(String mensaje) {
                    System.out.println("Error: " + mensaje);
                }
            });
        }
    }

    private void cargarHorasSemanales() {
        if (DaoHelperHoraSemanal.obtenerTodos(this).size() == 0) {
            DataHoraSemanal.obtenerTodos(new DataHoraSemanal.HoraSemanalCallback() {
                @Override
                public void onResponse(Object response) {
                    for (Hora_Semanal hora_semanal : (List<Hora_Semanal>) response) {
                        DaoHelperHoraSemanal.insertar(hora_semanal, SplashActivity.this);
                    }
                }

                @Override
                public void onError(String mensaje) {
                    System.out.println("Error: " + mensaje);
                }
            });
        }
    }

    private void cargarAntiguedades() {
        if (DaoHelperAntiguedad.obtenerTodos(this).size() == 0) {
            DataAntiguedadMainActivity.obtenerTodos(new DataAntiguedadMainActivity.AntiguedadCallback() {
                @Override
                public void onResponse(Object response) {
                    for (Antiguedad antiguedad : (List<Antiguedad>) response) {
                        DaoHelperAntiguedad.insertar(antiguedad, SplashActivity.this);
                    }
                }

                @Override
                public void onError(String mensaje) {
                    System.out.println("Error: " + mensaje);
                }
            });
        }
    }

    private void cargarSalarios() {
        if (DaoHelperSalario.obtenerTodos(this).size() == 0) {
            DataSalarioMainActivity.obtenerTodos(new DataSalarioMainActivity.SalarioCallback() {
                @Override
                public void onResponse(Object response) {
                    for (Salario salario : (List<Salario>) response) {
                        DaoHelperSalario.insertar(salario, SplashActivity.this);
                    }
                }
                @Override
                public void onError(String mensaje) {
                    System.out.println("Error: " + mensaje);
                }
            });
        }
    }

    private void cargarConformes() {
        if (DaoHelperConforme.obtenerTodos(this).size() == 0) {
            DataConformeMainActivity.obtenerTodos(new DataConformeMainActivity.ConformeCallback() {
                @Override
                public void onResponse(Object response) {
                    for (Conforme conforme : (List<Conforme>) response) {
                        DaoHelperConforme.insertar(conforme, SplashActivity.this);
                    }
                }

                @Override
                public void onError(String mensaje) {
                    System.out.println("Error: " + mensaje);
                }
            });
        }
    }
}
