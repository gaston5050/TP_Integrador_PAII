package com.example.tp_integrador_paii.daoSQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.tp_integrador_paii.entidad.Encuesta;

import java.util.ArrayList;
import java.util.List;

public class DaoHelperEncuesta {
    public static boolean insertar(Encuesta encuesta, Context context) {
        boolean resultado = false;
        try {
            SQLiteDatabase con = new ConectSQLiteHelperDB(context).getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put(ConectSQLiteHelperDB.COLUMN_ENCUESTA_ID_SEXO, encuesta.getId_sexo().getId());
            cv.put(ConectSQLiteHelperDB.COLUMN_ENCUESTA_ID_ESTUDIO, encuesta.getId_estudio().getId());
            cv.put(ConectSQLiteHelperDB.COLUMN_ENCUESTA_ID_EDAD, encuesta.getId_edad().getId());
            cv.put(ConectSQLiteHelperDB.COLUMN_ENCUESTA_ID_TRABAJO, encuesta.getId_trabajo().getId());
            cv.put(ConectSQLiteHelperDB.COLUMN_ENCUESTA_ID_RELACION_CONTRACTUAL, encuesta.getId_relacion_contractual().getId());
            cv.put(ConectSQLiteHelperDB.COLUMN_ENCUESTA_ID_RUBRO, encuesta.getId_rubro().getId());
            cv.put(ConectSQLiteHelperDB.COLUMN_ENCUESTA_ID_HORA_SEMANAL, encuesta.getId_hora_semanal().getId());
            cv.put(ConectSQLiteHelperDB.COLUMN_ENCUESTA_ID_ANTIGUEDAD, encuesta.getId_antiguedad().getId());
            cv.put(ConectSQLiteHelperDB.COLUMN_ENCUESTA_ID_SALARIO, encuesta.getId_salario().getId());
            cv.put(ConectSQLiteHelperDB.COLUMN_ENCUESTA_ID_CONFORME, encuesta.getId_conforme().getId());
            cv.put(ConectSQLiteHelperDB.COLUMN_ENCUESTA_ID_ENCUESTADOR, encuesta.getId_encuestador().getCue());

            long id = con.insert(ConectSQLiteHelperDB.TABLE_ENCUESTA, null, cv);
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

    public static Encuesta obtenerUno(int id, Context context) {
        Encuesta encuesta = new Encuesta();
        try {
            SQLiteDatabase con = new ConectSQLiteHelperDB(context).getReadableDatabase();
            String[] projection = null;
            String selection = ConectSQLiteHelperDB.COLUMN_ENCUESTA_ID + " = ?";
            String[] selectionArgs = {String.valueOf(id)};
            String sortOrder = null;
            Cursor cursor = con.query(
                    ConectSQLiteHelperDB.TABLE_ENCUESTA,
                    projection,
                    selection,
                    selectionArgs,
                    null,
                    null,
                    sortOrder);

            while (cursor.moveToNext()) {
                encuesta.setId(cursor.getInt(cursor.getColumnIndexOrThrow(ConectSQLiteHelperDB.COLUMN_ENCUESTA_ID)));
                encuesta.setId_sexo(DaoHelperSexo.obtenerUno(cursor.getInt(cursor.getColumnIndexOrThrow(ConectSQLiteHelperDB.COLUMN_ENCUESTA_ID_SEXO)), context));
                encuesta.setId_estudio(DaoHelperEstudio.obtenerUno(cursor.getInt(cursor.getColumnIndexOrThrow(ConectSQLiteHelperDB.COLUMN_ENCUESTA_ID_ESTUDIO)), context));
                encuesta.setId_edad(DaoHelperEdad.obtenerUno(cursor.getInt(cursor.getColumnIndexOrThrow(ConectSQLiteHelperDB.COLUMN_ENCUESTA_ID_EDAD)), context));
                encuesta.setId_trabajo(DaoHelperTrabajo.obtenerUno(cursor.getInt(cursor.getColumnIndexOrThrow(ConectSQLiteHelperDB.COLUMN_ENCUESTA_ID_TRABAJO)), context));
                encuesta.setId_relacion_contractual(DaoHelperRelacionContractual.obtenerUno(cursor.getInt(cursor.getColumnIndexOrThrow(ConectSQLiteHelperDB.COLUMN_ENCUESTA_ID_RELACION_CONTRACTUAL)), context));
                encuesta.setId_rubro(DaoHelperRubro.obtenerUno(cursor.getInt(cursor.getColumnIndexOrThrow(ConectSQLiteHelperDB.COLUMN_ENCUESTA_ID_RUBRO)), context));
                encuesta.setId_hora_semanal(DaoHelperHoraSemanal.obtenerUno(cursor.getInt(cursor.getColumnIndexOrThrow(ConectSQLiteHelperDB.COLUMN_ENCUESTA_ID_HORA_SEMANAL)), context));
                encuesta.setId_antiguedad(DaoHelperAntiguedad.obtenerUno(cursor.getInt(cursor.getColumnIndexOrThrow(ConectSQLiteHelperDB.COLUMN_ENCUESTA_ID_ANTIGUEDAD)), context));
                encuesta.setId_salario(DaoHelperSalario.obtenerUno(cursor.getInt(cursor.getColumnIndexOrThrow(ConectSQLiteHelperDB.COLUMN_ENCUESTA_ID_SALARIO)), context));
                encuesta.setId_conforme(DaoHelperConforme.obtenerUno(cursor.getInt(cursor.getColumnIndexOrThrow(ConectSQLiteHelperDB.COLUMN_ENCUESTA_ID_CONFORME)), context));
                encuesta.setId_encuestador(DaoHelperEncuestador.obtenerUno(cursor.getString(cursor.getColumnIndexOrThrow(ConectSQLiteHelperDB.COLUMN_ENCUESTA_ID_ENCUESTADOR)), context));
            }
            cursor.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return encuesta;
        }
    }

    public static List<Encuesta> obtenerTodos(Context context) {
        List<Encuesta> lista = new ArrayList<Encuesta>();
        try {
            SQLiteDatabase con = new ConectSQLiteHelperDB(context).getReadableDatabase();
            String[] projection = null;
            String selection = null;
            String[] selectionArgs = null;
            String sortOrder = null;
            Cursor cursor = con.query(
                    ConectSQLiteHelperDB.TABLE_ENCUESTA,
                    projection,
                    selection,
                    selectionArgs,
                    null,
                    null,
                    sortOrder);

            while (cursor.moveToNext()) {
                Encuesta encuesta = new Encuesta();
                encuesta.setId(cursor.getInt(cursor.getColumnIndexOrThrow(ConectSQLiteHelperDB.COLUMN_ENCUESTA_ID)));
                encuesta.setId_sexo(DaoHelperSexo.obtenerUno(cursor.getInt(cursor.getColumnIndexOrThrow(ConectSQLiteHelperDB.COLUMN_ENCUESTA_ID_SEXO)), context));
                encuesta.setId_estudio(DaoHelperEstudio.obtenerUno(cursor.getInt(cursor.getColumnIndexOrThrow(ConectSQLiteHelperDB.COLUMN_ENCUESTA_ID_ESTUDIO)), context));
                encuesta.setId_edad(DaoHelperEdad.obtenerUno(cursor.getInt(cursor.getColumnIndexOrThrow(ConectSQLiteHelperDB.COLUMN_ENCUESTA_ID_EDAD)), context));
                encuesta.setId_trabajo(DaoHelperTrabajo.obtenerUno(cursor.getInt(cursor.getColumnIndexOrThrow(ConectSQLiteHelperDB.COLUMN_ENCUESTA_ID_TRABAJO)), context));
                encuesta.setId_relacion_contractual(DaoHelperRelacionContractual.obtenerUno(cursor.getInt(cursor.getColumnIndexOrThrow(ConectSQLiteHelperDB.COLUMN_ENCUESTA_ID_RELACION_CONTRACTUAL)), context));
                encuesta.setId_rubro(DaoHelperRubro.obtenerUno(cursor.getInt(cursor.getColumnIndexOrThrow(ConectSQLiteHelperDB.COLUMN_ENCUESTA_ID_RUBRO)), context));
                encuesta.setId_hora_semanal(DaoHelperHoraSemanal.obtenerUno(cursor.getInt(cursor.getColumnIndexOrThrow(ConectSQLiteHelperDB.COLUMN_ENCUESTA_ID_HORA_SEMANAL)), context));
                encuesta.setId_antiguedad(DaoHelperAntiguedad.obtenerUno(cursor.getInt(cursor.getColumnIndexOrThrow(ConectSQLiteHelperDB.COLUMN_ENCUESTA_ID_ANTIGUEDAD)), context));
                encuesta.setId_salario(DaoHelperSalario.obtenerUno(cursor.getInt(cursor.getColumnIndexOrThrow(ConectSQLiteHelperDB.COLUMN_ENCUESTA_ID_SALARIO)), context));
                encuesta.setId_conforme(DaoHelperConforme.obtenerUno(cursor.getInt(cursor.getColumnIndexOrThrow(ConectSQLiteHelperDB.COLUMN_ENCUESTA_ID_CONFORME)), context));
                encuesta.setId_encuestador(DaoHelperEncuestador.obtenerUno(cursor.getString(cursor.getColumnIndexOrThrow(ConectSQLiteHelperDB.COLUMN_ENCUESTA_ID_ENCUESTADOR)), context));
                lista.add(encuesta);
            }

            cursor.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return lista;
        }
    }

    public static boolean actualizar(Encuesta encuesta, Context context) {
        boolean resultado = false;
        try {
            SQLiteDatabase con = new ConectSQLiteHelperDB(context).getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put(ConectSQLiteHelperDB.COLUMN_ENCUESTA_ID_SEXO, encuesta.getId_sexo().getId());
            cv.put(ConectSQLiteHelperDB.COLUMN_ENCUESTA_ID_ESTUDIO, encuesta.getId_estudio().getId());
            cv.put(ConectSQLiteHelperDB.COLUMN_ENCUESTA_ID_EDAD, encuesta.getId_edad().getId());
            cv.put(ConectSQLiteHelperDB.COLUMN_ENCUESTA_ID_TRABAJO, encuesta.getId_trabajo().getId());
            cv.put(ConectSQLiteHelperDB.COLUMN_ENCUESTA_ID_RELACION_CONTRACTUAL, encuesta.getId_relacion_contractual().getId());
            cv.put(ConectSQLiteHelperDB.COLUMN_ENCUESTA_ID_RUBRO, encuesta.getId_rubro().getId());
            cv.put(ConectSQLiteHelperDB.COLUMN_ENCUESTA_ID_HORA_SEMANAL, encuesta.getId_hora_semanal().getId());
            cv.put(ConectSQLiteHelperDB.COLUMN_ENCUESTA_ID_ANTIGUEDAD, encuesta.getId_antiguedad().getId());
            cv.put(ConectSQLiteHelperDB.COLUMN_ENCUESTA_ID_SALARIO, encuesta.getId_salario().getId());
            cv.put(ConectSQLiteHelperDB.COLUMN_ENCUESTA_ID_CONFORME, encuesta.getId_conforme().getId());
            cv.put(ConectSQLiteHelperDB.COLUMN_ENCUESTA_ID_ENCUESTADOR, encuesta.getId_encuestador().getCue());

            String selection = ConectSQLiteHelperDB.COLUMN_ENCUESTA_ID + " LIKE ?";
            String[] selectionArgs = {String.valueOf(encuesta.getId())};
            int count = con.update(
                    ConectSQLiteHelperDB.TABLE_ENCUESTA,
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
            String selection = ConectSQLiteHelperDB.COLUMN_ENCUESTA_ID + " LIKE ?";
            String[] selectionArgs = {String.valueOf(id)};
            int count = con.delete(
                    ConectSQLiteHelperDB.TABLE_ENCUESTA,
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

    public static List<Encuesta> obtenerPorEncuestador(String cue, Context context) {
        List<Encuesta> lista = new ArrayList<Encuesta>();
        try {
            SQLiteDatabase con = new ConectSQLiteHelperDB(context).getReadableDatabase();
            String[] projection = null;
            String selection = ConectSQLiteHelperDB.COLUMN_ENCUESTA_ID_ENCUESTADOR + " LIKE ?";
            String[] selectionArgs = {cue};
            String sortOrder = null;
            Cursor cursor = con.query(
                    ConectSQLiteHelperDB.TABLE_ENCUESTA,
                    projection,
                    selection,
                    selectionArgs,
                    null,
                    null,
                    sortOrder);

            while (cursor.moveToNext()) {
                Encuesta encuesta = new Encuesta();
                encuesta.setId(cursor.getInt(cursor.getColumnIndexOrThrow(ConectSQLiteHelperDB.COLUMN_ENCUESTA_ID)));
                encuesta.setId_sexo(DaoHelperSexo.obtenerUno(cursor.getInt(cursor.getColumnIndexOrThrow(ConectSQLiteHelperDB.COLUMN_ENCUESTA_ID_SEXO)), context));
                encuesta.setId_estudio(DaoHelperEstudio.obtenerUno(cursor.getInt(cursor.getColumnIndexOrThrow(ConectSQLiteHelperDB.COLUMN_ENCUESTA_ID_ESTUDIO)), context));
                encuesta.setId_edad(DaoHelperEdad.obtenerUno(cursor.getInt(cursor.getColumnIndexOrThrow(ConectSQLiteHelperDB.COLUMN_ENCUESTA_ID_EDAD)), context));
                encuesta.setId_trabajo(DaoHelperTrabajo.obtenerUno(cursor.getInt(cursor.getColumnIndexOrThrow(ConectSQLiteHelperDB.COLUMN_ENCUESTA_ID_TRABAJO)), context));
                encuesta.setId_relacion_contractual(DaoHelperRelacionContractual.obtenerUno(cursor.getInt(cursor.getColumnIndexOrThrow(ConectSQLiteHelperDB.COLUMN_ENCUESTA_ID_RELACION_CONTRACTUAL)), context));
                encuesta.setId_rubro(DaoHelperRubro.obtenerUno(cursor.getInt(cursor.getColumnIndexOrThrow(ConectSQLiteHelperDB.COLUMN_ENCUESTA_ID_RUBRO)), context));
                encuesta.setId_hora_semanal(DaoHelperHoraSemanal.obtenerUno(cursor.getInt(cursor.getColumnIndexOrThrow(ConectSQLiteHelperDB.COLUMN_ENCUESTA_ID_HORA_SEMANAL)), context));
                encuesta.setId_antiguedad(DaoHelperAntiguedad.obtenerUno(cursor.getInt(cursor.getColumnIndexOrThrow(ConectSQLiteHelperDB.COLUMN_ENCUESTA_ID_ANTIGUEDAD)), context));
                encuesta.setId_salario(DaoHelperSalario.obtenerUno(cursor.getInt(cursor.getColumnIndexOrThrow(ConectSQLiteHelperDB.COLUMN_ENCUESTA_ID_SALARIO)), context));
                encuesta.setId_conforme(DaoHelperConforme.obtenerUno(cursor.getInt(cursor.getColumnIndexOrThrow(ConectSQLiteHelperDB.COLUMN_ENCUESTA_ID_CONFORME)), context));
                encuesta.setId_encuestador(DaoHelperEncuestador.obtenerUno(cue, context));
                lista.add(encuesta);
            }

            cursor.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return lista;
        }
    }

    public static boolean eliminarPorEncuestador(String cue, Context context) {
        boolean resultado = false;
        try {
            SQLiteDatabase con = new ConectSQLiteHelperDB(context).getWritableDatabase();
            String selection = ConectSQLiteHelperDB.COLUMN_ENCUESTA_ID_ENCUESTADOR + " LIKE ?";
            String[] selectionArgs = {cue};
            int count = con.delete(
                    ConectSQLiteHelperDB.TABLE_ENCUESTA,
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
            con.execSQL(ConectSQLiteHelperDB.TABLE_ENCUESTA_RESET_AUTOINCREMENT);
            con.close();
            resultado = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return resultado;
        }
    }
}
