package com.example.tp_integrador_paii.conexion;

import android.content.Context;
import android.os.Looper;

import com.example.tp_integrador_paii.entidad.Trabajo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DataTrabajoMainActivity {
    private Object object;
    private static Context context;

    public DataTrabajoMainActivity(Object object, Context context) {
        this.object = object;
        this.context = context;
    }

    public interface TrabajoCallback {
        void onResponse(Object response);

        void onError(String mensaje);
    }

    public static void obtenerTodos(DataTrabajoMainActivity.TrabajoCallback callback) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            List<Trabajo> trabajos = new ArrayList<>();
            try {
                // Crear sentencia SQL para obtener todos los registros de la tabla
                String sql = "SELECT * FROM " + DataDB.TABLE_TRABAJO;

                // Establecer conexion a la base de datos
                Class.forName(DataDB.driver);
                Connection connection = DriverManager.getConnection(DataDB.urlMySQL, DataDB.user, DataDB.pass);
                // Preparar la sentencia SQL y establecer los valores
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    Trabajo trabajo = new Trabajo();
                    trabajo.setId(resultSet.getInt(DataDB.COLUMN_TRABAJO_ID));
                    trabajo.setDescripcion(resultSet.getString(DataDB.COLUMN_TRABAJO_DESCRIPCION));
                    trabajos.add(trabajo);
                }
                // Cerrar la conexion a la base de datos
                resultSet.close();
                statement.close();
                connection.close();

                if (trabajos.size() > 0) {
                    new android.os.Handler(Looper.getMainLooper()).post(() -> callback.onResponse(trabajos));
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
