package com.example.tp_integrador_paii.daoSQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.tp_integrador_paii.entidad.Encuestador;

import java.util.ArrayList;
import java.util.List;

public class DaoHelperEncuestador {
    /**
     * Inserta encuestador en la base de datos
     *
     * @param encuestador encuestador a insertar
     * @return true inserto con exito o false si fallo
     * @see <a href="https://developer.android.com/training/data-storage/sqlite?hl=es-419">documentacion api</a>
     */
    public static boolean insertar(Encuestador encuestador, Context context) {
        boolean resultado = false;
        try {
            SQLiteDatabase con = new ConectSQLiteHelperDB(context).getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put(ConectSQLiteHelperDB.COLUMN_ENCUESTADOR_CUE, encuestador.getCue());
            cv.put(ConectSQLiteHelperDB.COLUMN_ENCUESTADOR_PASSWORD, encuestador.getPassword());

            long id = con.insert(ConectSQLiteHelperDB.TABLE_ENCUESTADOR, null, cv);
            if (id > 0) {
                resultado = true;
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return resultado;
        }
    }

    public static Encuestador obtenerUno(String cue, Context context) {
        Encuestador encuestador = new Encuestador();
        try {
            SQLiteDatabase con = new ConectSQLiteHelperDB(context).getReadableDatabase();
            String[] projection = null;
            String selection = ConectSQLiteHelperDB.COLUMN_ENCUESTADOR_CUE + " LIKE ?";
            String[] selectionArgs = {cue};
            String sortOrder = null;
            Cursor cursor = con.query(
                    ConectSQLiteHelperDB.TABLE_ENCUESTADOR,
                    projection,
                    selection,
                    selectionArgs,
                    null,
                    null,
                    sortOrder);

            while (cursor.moveToNext()) {
                encuestador.setCue(cursor.getString(cursor.getColumnIndexOrThrow(ConectSQLiteHelperDB.COLUMN_ENCUESTADOR_CUE)));
                encuestador.setPassword(cursor.getString(cursor.getColumnIndexOrThrow(ConectSQLiteHelperDB.COLUMN_ENCUESTADOR_PASSWORD)));
            }
            cursor.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return encuestador;
        }
    }

    public static List<Encuestador> obtenerTodos(Context context) {
        List<Encuestador> lista = new ArrayList<Encuestador>();
        try {
            SQLiteDatabase con = new ConectSQLiteHelperDB(context).getReadableDatabase();
            String[] projection = null;
            String selection = null;
            String[] selectionArgs = null;
            String sortOrder = null;
            Cursor cursor = con.query(
                    ConectSQLiteHelperDB.TABLE_ENCUESTADOR,
                    projection,
                    selection,
                    selectionArgs,
                    null,
                    null,
                    sortOrder);

            while (cursor.moveToNext()) {
                Encuestador encuestador = new Encuestador();
                encuestador.setCue(cursor.getString(cursor.getColumnIndexOrThrow(ConectSQLiteHelperDB.COLUMN_ENCUESTADOR_CUE)));
                encuestador.setPassword(cursor.getString(cursor.getColumnIndexOrThrow(ConectSQLiteHelperDB.COLUMN_ENCUESTADOR_PASSWORD)));
                lista.add(encuestador);
            }

            cursor.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return lista;
        }
    }

    public static boolean actualizar(Encuestador encuestador, Context context) {
        boolean resultado = false;
        try {
            SQLiteDatabase con = new ConectSQLiteHelperDB(context).getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put(ConectSQLiteHelperDB.COLUMN_ENCUESTADOR_CUE, encuestador.getCue());
            cv.put(ConectSQLiteHelperDB.COLUMN_ENCUESTADOR_PASSWORD, encuestador.getPassword());

            String selection = ConectSQLiteHelperDB.COLUMN_ENCUESTADOR_CUE + " LIKE ?";
            String[] selectionArgs = {encuestador.getCue()};
            int count = con.update(
                    ConectSQLiteHelperDB.TABLE_ENCUESTADOR,
                    cv,
                    selection,
                    selectionArgs);
            if (count > 0) {
                resultado = true;
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return resultado;
        }
    }

    public static boolean eliminar(String cue, Context context) {
        boolean resultado = false;
        try {
            SQLiteDatabase con = new ConectSQLiteHelperDB(context).getWritableDatabase();
            String selection = ConectSQLiteHelperDB.COLUMN_ENCUESTADOR_CUE + " LIKE ?";
            String[] selectionArgs = {cue};
            int count = con.delete(
                    ConectSQLiteHelperDB.TABLE_ENCUESTADOR,
                    selection,
                    selectionArgs);
            if (count > 0) {
                resultado = true;
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return resultado;
        }
    }

    public static Encuestador login(String cue, String password, Context context) {
        Encuestador encuestador = new Encuestador();
        try {
            SQLiteDatabase con = new ConectSQLiteHelperDB(context).getReadableDatabase();
            String[] projection = null;
            String selection = ConectSQLiteHelperDB.COLUMN_ENCUESTADOR_CUE + " LIKE ? AND " + ConectSQLiteHelperDB.COLUMN_ENCUESTADOR_PASSWORD + " LIKE ?";
            String[] selectionArgs = {cue, password};
            String sortOrder = null;
            Cursor cursor = con.query(
                    ConectSQLiteHelperDB.TABLE_ENCUESTADOR,
                    projection,
                    selection,
                    selectionArgs,
                    null,
                    null,
                    sortOrder);

            while (cursor.moveToNext()) {
                encuestador.setCue(cursor.getString(cursor.getColumnIndexOrThrow(ConectSQLiteHelperDB.COLUMN_ENCUESTADOR_CUE)));
                encuestador.setPassword(cursor.getString(cursor.getColumnIndexOrThrow(ConectSQLiteHelperDB.COLUMN_ENCUESTADOR_PASSWORD)));
            }
            cursor.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (encuestador.getCue() == null) {
                return null;
            } else {
                return encuestador;
            }
        }
    }
}
