package com.example.tp_integrador_paii.conexion;

import android.content.Context;
import android.os.Looper;

import com.example.tp_integrador_paii.entidad.Encuesta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DataEncuestaMainActivity {
    private Object object;
    private static Context context;

    public DataEncuestaMainActivity(Object object, Context context) {
        this.object = object;
        this.context = context;
    }

    public interface EncuestaCallback {
        void onResponse(Object response);

        void onError(String mensaje);
    }

    public static void insertar(Encuesta encuesta, EncuestaCallback callback) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            try {
                // Crear sentencia SQL para insertar la encuesta
                String sql = "INSERT INTO " + com.example.tp_integrador_paii.conexion.DataDB.TABLE_ENCUESTA + "(" +
                        com.example.tp_integrador_paii.conexion.DataDB.COLUMN_ENCUESTA_ID_SEXO + "," +
                        com.example.tp_integrador_paii.conexion.DataDB.COLUMN_ENCUESTA_ID_ESTUDIO + "," +
                        com.example.tp_integrador_paii.conexion.DataDB.COLUMN_ENCUESTA_ID_EDAD + "," +
                        com.example.tp_integrador_paii.conexion.DataDB.COLUMN_ENCUESTA_ID_TRABAJO + "," +
                        com.example.tp_integrador_paii.conexion.DataDB.COLUMN_ENCUESTA_ID_RELACION_CONTRACTUAL + "," +
                        com.example.tp_integrador_paii.conexion.DataDB.COLUMN_ENCUESTA_ID_RUBRO + "," +
                        com.example.tp_integrador_paii.conexion.DataDB.COLUMN_ENCUESTA_ID_HORA_SEMANAL + "," +
                        com.example.tp_integrador_paii.conexion.DataDB.COLUMN_ENCUESTA_ID_ANTIGUEDAD + "," +
                        com.example.tp_integrador_paii.conexion.DataDB.COLUMN_ENCUESTA_ID_SALARIO + "," +
                        com.example.tp_integrador_paii.conexion.DataDB.COLUMN_ENCUESTA_ID_CONFORME + "," +
                        com.example.tp_integrador_paii.conexion.DataDB.COLUMN_ENCUESTA_ID_ENCUESTADOR + ")" +
                        "VALUES(?,?,?,?,?,?,?,?,?,?,?);";

                // Establecer conexión a la base de datos
                Class.forName(com.example.tp_integrador_paii.conexion.DataDB.driver);
                Connection connection = DriverManager.getConnection(com.example.tp_integrador_paii.conexion.DataDB.urlMySQL, com.example.tp_integrador_paii.conexion.DataDB.user, com.example.tp_integrador_paii.conexion.DataDB.pass);

                // Preparar la sentencia SQL y establecer los valores
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, encuesta.getId_sexo().getId());
                statement.setInt(2, encuesta.getId_estudio().getId());
                statement.setInt(3, encuesta.getId_edad().getId());
                statement.setInt(4, encuesta.getId_trabajo().getId());
                statement.setInt(5, encuesta.getId_relacion_contractual().getId());
                statement.setInt(6, encuesta.getId_rubro().getId());
                statement.setInt(7, encuesta.getId_hora_semanal().getId());
                statement.setInt(8, encuesta.getId_antiguedad().getId());
                statement.setInt(9, encuesta.getId_salario().getId());
                statement.setInt(10, encuesta.getId_conforme().getId());
                statement.setString(11, encuesta.getId_encuestador().getCue());

                // Ejecutar la sentencia SQL
                int rowsInserted = statement.executeUpdate();

                // Cerrar la conexión a la base de datos
                statement.close();
                connection.close();

                if (rowsInserted > 0) {
                    new android.os.Handler(Looper.getMainLooper()).post(() -> callback.onResponse(encuesta));
                } else {
                    new android.os.Handler(Looper.getMainLooper()).post(() -> callback.onError("No se pudo insertar la encuesta"));
                }

            } catch (Exception e) {
                e.printStackTrace();
                new android.os.Handler(Looper.getMainLooper()).post(() -> callback.onError(e.getMessage()));
            }
        });
    }
}
