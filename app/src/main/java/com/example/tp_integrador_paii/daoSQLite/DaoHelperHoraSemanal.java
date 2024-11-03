package com.example.tp_integrador_paii.daoSQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.tp_integrador_paii.entidad.Hora_Semanal;

import java.util.ArrayList;
import java.util.List;

public class DaoHelperHoraSemanal {
    public static boolean insertar(Hora_Semanal horaSemanal, Context context) {
        boolean resultado = false;
        try {
            SQLiteDatabase con = new ConectSQLiteHelperDB(context).getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put(ConectSQLiteHelperDB.COLUMN_HORA_SEMANAL_DESCRIPCION, horaSemanal.getDescripcion());

            long id = con.insert(ConectSQLiteHelperDB.TABLE_HORA_SEMANAL, null, cv);
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

    public static Hora_Semanal obtenerUno(int id, Context context) {
        Hora_Semanal hora_semanal = new Hora_Semanal();
        try {
            SQLiteDatabase con = new ConectSQLiteHelperDB(context).getReadableDatabase();
            String[] projection = null;
            String selection = ConectSQLiteHelperDB.COLUMN_HORA_SEMANAL_ID + " = ?";
            String[] selectionArgs = {String.valueOf(id)};
            String sortOrder = null;
            Cursor cursor = con.query(
                    ConectSQLiteHelperDB.TABLE_HORA_SEMANAL,
                    projection,
                    selection,
                    selectionArgs,
                    null,
                    null,
                    sortOrder);

            while (cursor.moveToNext()) {
                hora_semanal.setId(cursor.getInt(cursor.getColumnIndexOrThrow(ConectSQLiteHelperDB.COLUMN_HORA_SEMANAL_ID)));
                hora_semanal.setDescripcion(cursor.getString(cursor.getColumnIndexOrThrow(ConectSQLiteHelperDB.COLUMN_HORA_SEMANAL_DESCRIPCION)));
            }
            cursor.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return hora_semanal;
        }
    }

    public static List<Hora_Semanal> obtenerTodos(Context context) {
        List<Hora_Semanal> lista = new ArrayList<Hora_Semanal>();
        try {
            SQLiteDatabase con = new ConectSQLiteHelperDB(context).getReadableDatabase();
            String[] projection = null;
            String selection = null;
            String[] selectionArgs = null;
            String sortOrder = null;
            Cursor cursor = con.query(
                    ConectSQLiteHelperDB.TABLE_HORA_SEMANAL,
                    projection,
                    selection,
                    selectionArgs,
                    null,
                    null,
                    sortOrder);

            while (cursor.moveToNext()) {
                Hora_Semanal hora_semanal = new Hora_Semanal();
                hora_semanal.setId(cursor.getInt(cursor.getColumnIndexOrThrow(ConectSQLiteHelperDB.COLUMN_HORA_SEMANAL_ID)));
                hora_semanal.setDescripcion(cursor.getString(cursor.getColumnIndexOrThrow(ConectSQLiteHelperDB.COLUMN_HORA_SEMANAL_DESCRIPCION)));
                lista.add(hora_semanal);
            }

            cursor.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return lista;
        }
    }

    public static boolean actualizar(Hora_Semanal hora_semanal, Context context) {
        boolean resultado = false;
        try {
            SQLiteDatabase con = new ConectSQLiteHelperDB(context).getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put(ConectSQLiteHelperDB.COLUMN_HORA_SEMANAL_ID, hora_semanal.getId());
            cv.put(ConectSQLiteHelperDB.COLUMN_HORA_SEMANAL_DESCRIPCION, hora_semanal.getDescripcion());

            String selection = ConectSQLiteHelperDB.COLUMN_HORA_SEMANAL_ID + " LIKE ?";
            String[] selectionArgs = {String.valueOf(hora_semanal.getId())};
            int count = con.update(
                    ConectSQLiteHelperDB.TABLE_HORA_SEMANAL,
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

    public static boolean eliminar(int id, Context context) {
        boolean resultado = false;
        try {
            SQLiteDatabase con = new ConectSQLiteHelperDB(context).getWritableDatabase();
            String selection = ConectSQLiteHelperDB.COLUMN_HORA_SEMANAL_ID + " LIKE ?";
            String[] selectionArgs = {String.valueOf(id)};
            int count = con.delete(
                    ConectSQLiteHelperDB.TABLE_HORA_SEMANAL,
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
            con.execSQL(ConectSQLiteHelperDB.TABLE_HORA_SEMANAL_RESET_AUTOINCREMENT);
            con.close();
            resultado = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return resultado;
        }
    }
}
