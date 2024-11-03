package com.example.tp_integrador_paii.daoSQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.tp_integrador_paii.entidad.Relacion_Contractual;

import java.util.ArrayList;
import java.util.List;

public class DaoHelperRelacionContractual {
    public static boolean insertar(Relacion_Contractual relacion_contractual, Context context) {
        boolean resultado = false;
        try {
            SQLiteDatabase con = new ConectSQLiteHelperDB(context).getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put(ConectSQLiteHelperDB.COLUMN_RELACION_CONTRACTUAL_DESCRIPCION, relacion_contractual.getDescripcion());

            long id = con.insert(ConectSQLiteHelperDB.TABLE_RELACION_CONTRACTUAL, null, cv);
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

    public static Relacion_Contractual obtenerUno(int id, Context context) {
        Relacion_Contractual relacion_contractual = new Relacion_Contractual();
        try {
            SQLiteDatabase con = new ConectSQLiteHelperDB(context).getReadableDatabase();
            String[] projection = null;
            String selection = ConectSQLiteHelperDB.COLUMN_RELACION_CONTRACTUAL_ID + " = ?";
            String[] selectionArgs = {String.valueOf(id)};
            String sortOrder = null;
            Cursor cursor = con.query(
                    ConectSQLiteHelperDB.TABLE_RELACION_CONTRACTUAL,
                    projection,
                    selection,
                    selectionArgs,
                    null,
                    null,
                    sortOrder);

            while (cursor.moveToNext()) {
                relacion_contractual.setId(cursor.getInt(cursor.getColumnIndexOrThrow(ConectSQLiteHelperDB.COLUMN_RELACION_CONTRACTUAL_ID)));
                relacion_contractual.setDescripcion(cursor.getString(cursor.getColumnIndexOrThrow(ConectSQLiteHelperDB.COLUMN_RELACION_CONTRACTUAL_DESCRIPCION)));
            }
            cursor.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return relacion_contractual;
        }
    }

    public static List<Relacion_Contractual> obtenerTodos(Context context) {
        List<Relacion_Contractual> lista = new ArrayList<Relacion_Contractual>();
        try {
            SQLiteDatabase con = new ConectSQLiteHelperDB(context).getReadableDatabase();
            String[] projection = null;
            String selection = null;
            String[] selectionArgs = null;
            String sortOrder = null;
            Cursor cursor = con.query(
                    ConectSQLiteHelperDB.TABLE_RELACION_CONTRACTUAL,
                    projection,
                    selection,
                    selectionArgs,
                    null,
                    null,
                    sortOrder);

            while (cursor.moveToNext()) {
                Relacion_Contractual relacion_contractual = new Relacion_Contractual();
                relacion_contractual.setId(cursor.getInt(cursor.getColumnIndexOrThrow(ConectSQLiteHelperDB.COLUMN_RELACION_CONTRACTUAL_ID)));
                relacion_contractual.setDescripcion(cursor.getString(cursor.getColumnIndexOrThrow(ConectSQLiteHelperDB.COLUMN_RELACION_CONTRACTUAL_DESCRIPCION)));
                lista.add(relacion_contractual);
            }

            cursor.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return lista;
        }
    }

    public static boolean actualizar(Relacion_Contractual relacion_contractual, Context context) {
        boolean resultado = false;
        try {
            SQLiteDatabase con = new ConectSQLiteHelperDB(context).getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put(ConectSQLiteHelperDB.COLUMN_RELACION_CONTRACTUAL_ID, relacion_contractual.getId());
            cv.put(ConectSQLiteHelperDB.COLUMN_RELACION_CONTRACTUAL_DESCRIPCION, relacion_contractual.getDescripcion());

            String selection = ConectSQLiteHelperDB.COLUMN_RELACION_CONTRACTUAL_ID + " LIKE ?";
            String[] selectionArgs = {String.valueOf(relacion_contractual.getId())};
            int count = con.update(
                    ConectSQLiteHelperDB.TABLE_RELACION_CONTRACTUAL,
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
            String selection = ConectSQLiteHelperDB.COLUMN_RELACION_CONTRACTUAL_ID + " LIKE ?";
            String[] selectionArgs = {String.valueOf(id)};
            int count = con.delete(
                    ConectSQLiteHelperDB.TABLE_RELACION_CONTRACTUAL,
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
            con.execSQL(ConectSQLiteHelperDB.TABLE_RELACION_CONTRACTUAL_RESET_AUTOINCREMENT);
            con.close();
            resultado = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return resultado;
        }
    }
}
