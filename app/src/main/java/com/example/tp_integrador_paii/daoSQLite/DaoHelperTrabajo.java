package com.example.tp_integrador_paii.daoSQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.tp_integrador_paii.entidad.Trabajo;

import java.util.ArrayList;
import java.util.List;

public class DaoHelperTrabajo {
    public static boolean insertar(Trabajo trabajo, Context context) {
        boolean resultado = false;
        try {
            SQLiteDatabase con = new ConectSQLiteHelperDB(context).getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put(ConectSQLiteHelperDB.COLUMN_TRABAJO_DESCRIPCION, trabajo.getDescripcion());

            long id = con.insert(ConectSQLiteHelperDB.TABLE_TRABAJO, null, cv);
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

    public static Trabajo obtenerUno(int id, Context context) {
        Trabajo trabajo = new Trabajo();
        try {
            SQLiteDatabase con = new ConectSQLiteHelperDB(context).getReadableDatabase();
            String[] projection = null;
            String selection = ConectSQLiteHelperDB.COLUMN_TRABAJO_ID + " = ?";
            String[] selectionArgs = {String.valueOf(id)};
            String sortOrder = null;
            Cursor cursor = con.query(
                    ConectSQLiteHelperDB.TABLE_TRABAJO,
                    projection,
                    selection,
                    selectionArgs,
                    null,
                    null,
                    sortOrder
            );

            while (cursor.moveToNext()) {
                trabajo.setId(cursor.getInt(cursor.getColumnIndexOrThrow(ConectSQLiteHelperDB.COLUMN_TRABAJO_ID)));
                trabajo.setDescripcion(cursor.getString(cursor.getColumnIndexOrThrow(ConectSQLiteHelperDB.COLUMN_TRABAJO_DESCRIPCION)));
            }
            cursor.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return trabajo;
        }
    }

    public static List<Trabajo> obtenerTodos(Context context) {
        List<Trabajo> lista = new ArrayList<Trabajo>();
        try {
            SQLiteDatabase con = new ConectSQLiteHelperDB(context).getReadableDatabase();
            String[] projection = null;
            String selection = null;
            String[] selectionArgs = null;
            String sortOrder = null;
            Cursor cursor = con.query(
                    ConectSQLiteHelperDB.TABLE_TRABAJO,
                    projection,
                    selection,
                    selectionArgs,
                    null,
                    null,
                    sortOrder);

            while (cursor.moveToNext()) {
                Trabajo trabajo = new Trabajo();
                trabajo.setId(cursor.getInt(cursor.getColumnIndexOrThrow(ConectSQLiteHelperDB.COLUMN_TRABAJO_ID)));
                trabajo.setDescripcion(cursor.getString(cursor.getColumnIndexOrThrow(ConectSQLiteHelperDB.COLUMN_TRABAJO_DESCRIPCION)));
                lista.add(trabajo);
            }
            cursor.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return lista;
        }
    }

    public static boolean actualizar(Trabajo trabajo, Context context) {
        boolean resultado = false;
        try {
            SQLiteDatabase con = new ConectSQLiteHelperDB(context).getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put(ConectSQLiteHelperDB.COLUMN_TRABAJO_ID, trabajo.getId());
            cv.put(ConectSQLiteHelperDB.COLUMN_TRABAJO_DESCRIPCION, trabajo.getDescripcion());

            String selection = ConectSQLiteHelperDB.COLUMN_TRABAJO_ID + " LIKE ?";
            String[] selectionArgs = {String.valueOf(trabajo.getId())};
            int count = con.update(
                    ConectSQLiteHelperDB.TABLE_TRABAJO,
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

    public static boolean eliminar(Trabajo trabajo, Context context) {
        boolean resultado = false;
        try {
            SQLiteDatabase con = new ConectSQLiteHelperDB(context).getWritableDatabase();
            String selection = ConectSQLiteHelperDB.COLUMN_TRABAJO_ID + " LIKE ?";
            String[] selectionArgs = {String.valueOf(trabajo.getId())};
            int count = con.delete(
                    ConectSQLiteHelperDB.TABLE_TRABAJO,
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

    // reiniciar autoincrement
    public static boolean reiniciarAutoincrement(Context context) {
        boolean resultado = false;
        try {
            SQLiteDatabase con = new ConectSQLiteHelperDB(context).getWritableDatabase();
            con.execSQL(ConectSQLiteHelperDB.TABLE_TRABAJO_RESET_AUTOINCREMENT);
            con.close();
            resultado = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return resultado;
        }
    }
}
