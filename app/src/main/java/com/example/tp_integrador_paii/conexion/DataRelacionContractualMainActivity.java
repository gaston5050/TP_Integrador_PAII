package com.example.tp_integrador_paii.conexion;

import android.content.Context;
import android.os.Looper;

import com.example.tp_integrador_paii.entidad.Relacion_Contractual;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DataRelacionContractualMainActivity {
    private Object object;
    private static Context context;

    public DataRelacionContractualMainActivity(Object object, Context context) {
        this.object = object;
        this.context = context;
    }

    public interface RelacionContractualCallback {
        void onResponse(Object response);

        void onError(String mensaje);
    }

    public static void obtenerTodos(DataRelacionContractualMainActivity.RelacionContractualCallback callback) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            List<Relacion_Contractual> listaRegistros = new ArrayList<>();
            try {
                // Crear sentencia SQL para obtener todas las registros de la tabla
                String sql = "SELECT * FROM " + DataDB.TABLE_RELACION_CONTRACTUAL;

                // Establecer conexión a la base de datos
                Class.forName(DataDB.driver);
                Connection connection = DriverManager.getConnection(DataDB.urlMySQL, DataDB.user, DataDB.pass);
                // Preparar la sentencia SQL y establecer los valores
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    Relacion_Contractual relacion_contractual = new Relacion_Contractual();
                    relacion_contractual.setId(resultSet.getInt(DataDB.COLUMN_RELACION_CONTRACTUAL_ID));
                    relacion_contractual.setDescripcion(resultSet.getString(DataDB.COLUMN_RELACION_CONTRACTUAL_DESCRIPCION));
                    listaRegistros.add(relacion_contractual);
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
