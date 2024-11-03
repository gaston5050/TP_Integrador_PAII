package com.example.tp_integrador_paii.daoSQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.tp_integrador_paii.entidad.Rubro;

import java.util.ArrayList;
import java.util.List;

public class DaoHelperRubro {
    public static boolean insertar(Rubro rubro, Context context) {
        boolean resultado = false;
        try {
            SQLiteDatabase con = new ConectSQLiteHelperDB(context).getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put(ConectSQLiteHelperDB.COLUMN_RUBRO_DESCRIPCION, rubro.getDescripcion());

            long id = con.insert(ConectSQLiteHelperDB.TABLE_RUBRO, null, cv);
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

    public static Rubro obtenerUno(int id, Context context) {
        Rubro rubro = new Rubro();
        try {
            SQLiteDatabase con = new ConectSQLiteHelperDB(context).getReadableDatabase();
            String[] projection = null;
            String selection = ConectSQLiteHelperDB.COLUMN_RUBRO_ID + " = ?";
            String[] selectionArgs = {String.valueOf(id)};
            String sortOrder = null;
            Cursor cursor = con.query(
                    ConectSQLiteHelperDB.TABLE_RUBRO,
                    projection,
                    selection,
                    selectionArgs,
                    null,
                    null,
                    sortOrder);

            while (cursor.moveToNext()) {
                rubro.setId(cursor.getInt(cursor.getColumnIndexOrThrow(ConectSQLiteHelperDB.COLUMN_RUBRO_ID)));
                rubro.setDescripcion(cursor.getString(cursor.getColumnIndexOrThrow(ConectSQLiteHelperDB.COLUMN_RUBRO_DESCRIPCION)));
            }
            cursor.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return rubro;
        }
    }

    public static List<Rubro> obtenerTodos(Context context) {
        List<Rubro> lista = new ArrayList<Rubro>();
        try {
            SQLiteDatabase con = new ConectSQLiteHelperDB(context).getReadableDatabase();
            String[] projection = null;
            String selection = null;
            String[] selectionArgs = null;
            String sortOrder = null;
            Cursor cursor = con.query(
                    ConectSQLiteHelperDB.TABLE_RUBRO,
                    projection,
                    selection,
                    selectionArgs,
                    null,
                    null,
                    sortOrder);

            while (cursor.moveToNext()) {
                Rubro rubro = new Rubro();
                rubro.setId(cursor.getInt(cursor.getColumnIndexOrThrow(ConectSQLiteHelperDB.COLUMN_RUBRO_ID)));
                rubro.setDescripcion(cursor.getString(cursor.getColumnIndexOrThrow(ConectSQLiteHelperDB.COLUMN_RUBRO_DESCRIPCION)));
                lista.add(rubro);
            }

            cursor.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return lista;
        }
    }

    public static boolean actualizar(Rubro rubro, Context context) {
        boolean resultado = false;
        try {
            SQLiteDatabase con = new ConectSQLiteHelperDB(context).getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put(ConectSQLiteHelperDB.COLUMN_RUBRO_ID, rubro.getId());
            cv.put(ConectSQLiteHelperDB.COLUMN_RUBRO_DESCRIPCION, rubro.getDescripcion());

            String selection = ConectSQLiteHelperDB.COLUMN_RUBRO_ID + " LIKE ?";
            String[] selectionArgs = {String.valueOf(rubro.getId())};
            int count = con.update(
                    ConectSQLiteHelperDB.TABLE_RUBRO,
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
            String selection = ConectSQLiteHelperDB.COLUMN_RUBRO_ID + " LIKE ?";
            String[] selectionArgs = {String.valueOf(id)};
            int count = con.delete(
                    ConectSQLiteHelperDB.TABLE_RUBRO,
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
            con.execSQL(ConectSQLiteHelperDB.TABLE_RUBRO_RESET_AUTOINCREMENT);
            con.close();
            resultado = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return resultado;
        }
    }
}
