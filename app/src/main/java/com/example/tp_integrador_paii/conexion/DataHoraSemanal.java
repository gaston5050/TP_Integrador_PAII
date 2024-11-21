package com.example.tp_integrador_paii.conexion;

import android.content.Context;
import android.os.Looper;

import com.example.tp_integrador_paii.entidad.Hora_Semanal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DataHoraSemanal {
    private Object object;
    private static Context context;

    public DataHoraSemanal(Object object, Context context) {
        this.object = object;
        this.context = context;
    }

    public interface HoraSemanalCallback {
        void onResponse(Object response);

        void onError(String mensaje);
    }

    public static void obtenerTodos(DataHoraSemanal.HoraSemanalCallback callback) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            List<Hora_Semanal> listaRegistros = new ArrayList<>();
            try {
                // Crear sentencia SQL para obtener todas las registros de la tabla
                String sql = "SELECT * FROM " + DataDB.TABLE_HORA_SEMANAL;
                // Establecer conexión a la base de datos
                Class.forName(DataDB.driver);
                Connection connection = DriverManager.getConnection(DataDB.urlMySQL, DataDB.user, DataDB.pass);
                // Preparar la sentencia SQL y establecer los valores
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    Hora_Semanal horaSemanal = new Hora_Semanal();
                    horaSemanal.setId(resultSet.getInt(DataDB.COLUMN_HORA_SEMANAL_ID));
                    horaSemanal.setDescripcion(resultSet.getString(DataDB.COLUMN_HORA_SEMANAL_DESCRIPCION));
                    listaRegistros.add(horaSemanal);
                }
                // Cerrar la conexión a la base de datos
                resultSet.close();
                statement.close();
                connection.close();
                if (listaRegistros.size() > 0) {
                    new android.os.Handler(Looper.getMainLooper()).post(() -> callback.onResponse(listaRegistros));
                } else {
                    new android.os.Handler(Looper.getMainLooper()).post(() -> callback.onError("No se encontraron registros"));
                }

            } catch (Exception e) {
                e.printStackTrace();
                new android.os.Handler(Looper.getMainLooper()).post(() -> callback.onError(e.getMessage()));
            }
        });
    }
}

