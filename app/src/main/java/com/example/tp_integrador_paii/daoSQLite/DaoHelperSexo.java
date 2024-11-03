package com.example.tp_integrador_paii.daoSQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.tp_integrador_paii.entidad.Sexo;

import java.util.ArrayList;
import java.util.List;

public class DaoHelperSexo {
    public static boolean insertar(Sexo sexo, Context context) {
        boolean resultado = false;
        try {
            SQLiteDatabase con = new ConectSQLiteHelperDB(context).getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put(ConectSQLiteHelperDB.COLUMN_SEXO_DESCRIPCION, sexo.getDescripcion());

            long id = con.insert(ConectSQLiteHelperDB.TABLE_SEXO, null, cv);
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

    public static Sexo obtenerUno(int id, Context context) {
        Sexo sexo = new Sexo();
        try {
            SQLiteDatabase con = new ConectSQLiteHelperDB(context).getReadableDatabase();
            String[] projection = null;
            String selection = ConectSQLiteHelperDB.COLUMN_SEXO_ID + " = ?";
            String[] selectionArgs = {String.valueOf(id)};
            String sortOrder = null;
            Cursor cursor = con.query(
                    ConectSQLiteHelperDB.TABLE_SEXO,
                    projection,
                    selection,
                    selectionArgs,
                    null,
                    null,
                    sortOrder);

            while (cursor.moveToNext()) {
                sexo.setId(cursor.getInt(cursor.getColumnIndexOrThrow(ConectSQLiteHelperDB.COLUMN_SEXO_ID)));
                sexo.setDescripcion(cursor.getString(cursor.getColumnIndexOrThrow(ConectSQLiteHelperDB.COLUMN_SEXO_DESCRIPCION)));
            }
            cursor.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return sexo;
        }
    }

    public static List<Sexo> obtenerTodos(Context context) {
        List<Sexo> lista = new ArrayList<Sexo>();
        try {
            SQLiteDatabase con = new ConectSQLiteHelperDB(context).getReadableDatabase();
            String[] projection = null;
            String selection = null;
            String[] selectionArgs = null;
            String sortOrder = null;
            Cursor cursor = con.query(
                    ConectSQLiteHelperDB.TABLE_SEXO,
                    projection,
                    selection,
                    selectionArgs,
                    null,
                    null,
                    sortOrder);

            while (cursor.moveToNext()) {
                Sexo sexo = new Sexo();
                sexo.setId(cursor.getInt(cursor.getColumnIndexOrThrow(ConectSQLiteHelperDB.COLUMN_SEXO_ID)));
                sexo.setDescripcion(cursor.getString(cursor.getColumnIndexOrThrow(ConectSQLiteHelperDB.COLUMN_SEXO_DESCRIPCION)));
                lista.add(sexo);
            }

            cursor.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return lista;
        }
    }

    public static boolean actualizar(Sexo sexo, Context context) {
        boolean resultado = false;
        try {
            SQLiteDatabase con = new ConectSQLiteHelperDB(context).getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put(ConectSQLiteHelperDB.COLUMN_SEXO_ID, sexo.getId());
            cv.put(ConectSQLiteHelperDB.COLUMN_SEXO_DESCRIPCION, sexo.getDescripcion());

            String selection = ConectSQLiteHelperDB.COLUMN_SEXO_ID + " LIKE ?";
            String[] selectionArgs = {String.valueOf(sexo.getId())};
            int count = con.update(
                    ConectSQLiteHelperDB.TABLE_SEXO,
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
            String selection = ConectSQLiteHelperDB.COLUMN_SEXO_ID + " LIKE ?";
            String[] selectionArgs = {String.valueOf(id)};
            int count = con.delete(
                    ConectSQLiteHelperDB.TABLE_SEXO,
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
            con.execSQL(ConectSQLiteHelperDB.TABLE_SEXO_RESET_AUTOINCREMENT);
            con.close();
            resultado = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return resultado;
        }
    }
}
