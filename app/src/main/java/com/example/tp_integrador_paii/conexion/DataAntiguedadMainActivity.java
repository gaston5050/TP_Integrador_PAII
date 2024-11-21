package com.example.tp_integrador_paii.conexion;

import android.content.Context;
import android.os.Looper;

import com.example.tp_integrador_paii.entidad.Antiguedad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DataAntiguedadMainActivity {
    private Object object;
    private static Context context;

    public DataAntiguedadMainActivity(Object object, Context context) {
        this.object = object;
        this.context = context;
    }

    public interface AntiguedadCallback {
        void onResponse(Object response);

        void onError(String mensaje);
    }

    public static void obtenerTodos(DataAntiguedadMainActivity.AntiguedadCallback callback) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            List<Antiguedad> listaRegistros = new ArrayList<>();
            try {
                // Crear sentencia SQL para obtener todas las registros de la tabla
                String sql = "SELECT * FROM " + DataDB.TABLE_ANTIGUEDAD;

                // Establecer conexión a la base de datos
                Class.forName(DataDB.driver);
                Connection connection = DriverManager.getConnection(DataDB.urlMySQL, DataDB.user, DataDB.pass);
                // Preparar la sentencia SQL y establecer los valores
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    Antiguedad antiguedad = new Antiguedad();
                    antiguedad.setId(resultSet.getInt(DataDB.COLUMN_ANTIGUEDAD_ID));
                    antiguedad.setDescripcion(resultSet.getString(DataDB.COLUMN_ANTIGUEDAD_DESCRIPCION));
                    listaRegistros.add(antiguedad);
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
