package com.example.tp_integrador_paii.daoSQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

/**
 * @see <a href="https://developer.android.com/training/data-storage/sqlite?hl=es-419">documentacion api</a>
 */
public class ConectSQLiteHelperDB extends SQLiteOpenHelper {
    /* BD */
    // Constantes para crear la base de datos
    public static final String DATABASE_NAME = "BD_ENCUESTA";
    public static final int DATABASE_VERSION = 1;

    /* TABLAS */
    // Encuestador
    public static final String TABLE_ENCUESTADOR = "Encuestador";
    public static final String COLUMN_ENCUESTADOR_CUE = "cue";
    public static final String COLUMN_ENCUESTADOR_PASSWORD = "password";
    private static final String DROP_TABLE_ENCUESTADOR = "DROP TABLE IF EXISTS " + TABLE_ENCUESTADOR + ";";
    private static final String CREATE_TABLE_ENCUESTADOR = "CREATE TABLE IF NOT EXISTS " + TABLE_ENCUESTADOR + "(" +
            COLUMN_ENCUESTADOR_CUE + " TEXT NOT NULL," +
            COLUMN_ENCUESTADOR_PASSWORD + " TEXT NOT NULL," +
            "CONSTRAINT PK_Encuestador PRIMARY KEY (" + COLUMN_ENCUESTADOR_CUE + ")" +
            ");";

    // Sexo
    public static final String TABLE_SEXO = "Sexo";
    public static final String COLUMN_SEXO_ID = "id";
    public static final String COLUMN_SEXO_DESCRIPCION = "descripcion";
    private static final String DROP_TABLE_SEXO = "DROP TABLE IF EXISTS " + TABLE_SEXO + ";";
    private static final String CREATE_TABLE_SEXO = "CREATE TABLE IF NOT EXISTS " + TABLE_SEXO + "(" +
            COLUMN_SEXO_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            COLUMN_SEXO_DESCRIPCION + " TEXT NOT NULL" +
            ");";
    public static final String TABLE_SEXO_RESET_AUTOINCREMENT = "UPDATE sqlite_sequence SET seq = 0 WHERE name = '" + TABLE_SEXO + "';";

    // Estudio
    public static final String TABLE_ESTUDIO = "Estudio";
    public static final String COLUMN_ESTUDIO_ID = "id";
    public static final String COLUMN_ESTUDIO_DESCRIPCION = "descripcion";
    private static final String DROP_TABLE_ESTUDIO = "DROP TABLE IF EXISTS " + TABLE_ESTUDIO + ";";
    private static final String CREATE_TABLE_ESTUDIO = "CREATE TABLE IF NOT EXISTS " + TABLE_ESTUDIO + "(" +
            COLUMN_ESTUDIO_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            COLUMN_ESTUDIO_DESCRIPCION + " TEXT NOT NULL" +
            ");";
    public static final String TABLE_ESTUDIO_RESET_AUTOINCREMENT = "UPDATE sqlite_sequence SET seq = 0 WHERE name = '" + TABLE_ESTUDIO + "';";

    // Edad
    public static final String TABLE_EDAD = "Edad";
    public static final String COLUMN_EDAD_ID = "id";
    public static final String COLUMN_EDAD_DESCRIPCION = "descripcion";
    private static final String DROP_TABLE_EDAD = "DROP TABLE IF EXISTS " + TABLE_EDAD + ";";
    private static final String CREATE_TABLE_EDAD = "CREATE TABLE IF NOT EXISTS " + TABLE_EDAD + "(" +
            COLUMN_EDAD_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            COLUMN_EDAD_DESCRIPCION + " TEXT NOT NULL" +
            ");";
    public static final String TABLE_EDAD_RESET_AUTOINCREMENT = "UPDATE sqlite_sequence SET seq = 0 WHERE name = '" + TABLE_EDAD + "';";

    // Trabajao
    public static final String TABLE_TRABAJO = "Trabajo";
    public static final String COLUMN_TRABAJO_ID = "id";
    public static final String COLUMN_TRABAJO_DESCRIPCION = "descripcion";
    private static final String DROP_TABLE_TRABAJO = "DROP TABLE IF EXISTS " + TABLE_TRABAJO + ";";
    private static final String CREATE_TABLE_TRABAJO = "CREATE TABLE IF NOT EXISTS " + TABLE_TRABAJO + "(" +
            COLUMN_TRABAJO_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            COLUMN_TRABAJO_DESCRIPCION + " TEXT NOT NULL" +
            ");";
    public static final String TABLE_TRABAJO_RESET_AUTOINCREMENT = "UPDATE sqlite_sequence SET seq = 0 WHERE name = '" + TABLE_TRABAJO + "';";

    // Relacion_Contractual
    public static final String TABLE_RELACION_CONTRACTUAL = "Relacion_Contractual";
    public static final String COLUMN_RELACION_CONTRACTUAL_ID = "id";
    public static final String COLUMN_RELACION_CONTRACTUAL_DESCRIPCION = "descripcion";
    private static final String DROP_TABLE_RELACION_CONTRACTUAL = "DROP TABLE IF EXISTS " + TABLE_RELACION_CONTRACTUAL + ";";
    private static final String CREATE_TABLE_RELACION_CONTRACTUAL = "CREATE TABLE IF NOT EXISTS " + TABLE_RELACION_CONTRACTUAL + "(" +
            COLUMN_RELACION_CONTRACTUAL_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            COLUMN_RELACION_CONTRACTUAL_DESCRIPCION + " TEXT NOT NULL" +
            ");";
    public static final String TABLE_RELACION_CONTRACTUAL_RESET_AUTOINCREMENT = "UPDATE sqlite_sequence SET seq = 0 WHERE name = '" + TABLE_RELACION_CONTRACTUAL + "';";

    // Rubro
    public static final String TABLE_RUBRO = "Rubro";
    public static final String COLUMN_RUBRO_ID = "id";
    public static final String COLUMN_RUBRO_DESCRIPCION = "descripcion";
    private static final String DROP_TABLE_RUBRO = "DROP TABLE IF EXISTS " + TABLE_RUBRO + ";";
    private static final String CREATE_TABLE_RUBRO = "CREATE TABLE IF NOT EXISTS " + TABLE_RUBRO + "(" +
            COLUMN_RUBRO_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            COLUMN_RUBRO_DESCRIPCION + " TEXT NOT NULL" +
            ");";
    public static final String TABLE_RUBRO_RESET_AUTOINCREMENT = "UPDATE sqlite_sequence SET seq = 0 WHERE name = '" + TABLE_RUBRO + "';";

    // Hora_Semanal
    public static final String TABLE_HORA_SEMANAL = "Hora_Semanal";
    public static final String COLUMN_HORA_SEMANAL_ID = "id";
    public static final String COLUMN_HORA_SEMANAL_DESCRIPCION = "descripcion";
    private static final String DROP_TABLE_HORA_SEMANAL = "DROP TABLE IF EXISTS " + TABLE_HORA_SEMANAL + ";";
    private static final String CREATE_TABLE_HORA_SEMANAL = "CREATE TABLE IF NOT EXISTS " + TABLE_HORA_SEMANAL + "(" +
            COLUMN_HORA_SEMANAL_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            COLUMN_HORA_SEMANAL_DESCRIPCION + " TEXT NOT NULL" +
            ");";
    public static final String TABLE_HORA_SEMANAL_RESET_AUTOINCREMENT = "UPDATE sqlite_sequence SET seq = 0 WHERE name = '" + TABLE_HORA_SEMANAL + "';";

    // Antiguedad
    public static final String TABLE_ANTIGUEDAD = "Antiguedad";
    public static final String COLUMN_ANTIGUEDAD_ID = "id";
    public static final String COLUMN_ANTIGUEDAD_DESCRIPCION = "descripcion";
    private static final String DROP_TABLE_ANTIGUEDAD = "DROP TABLE IF EXISTS " + TABLE_ANTIGUEDAD + ";";
    private static final String CREATE_TABLE_ANTIGUEDAD = "CREATE TABLE IF NOT EXISTS " + TABLE_ANTIGUEDAD + "(" +
            COLUMN_ANTIGUEDAD_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            COLUMN_ANTIGUEDAD_DESCRIPCION + " TEXT NOT NULL" +
            ");";
    public static final String TABLE_ANTIGUEDAD_RESET_AUTOINCREMENT = "UPDATE sqlite_sequence SET seq = 0 WHERE name = '" + TABLE_ANTIGUEDAD + "';";

    // Salario
    public static final String TABLE_SALARIO = "Salario";
    public static final String COLUMN_SALARIO_ID = "id";
    public static final String COLUMN_SALARIO_DESCRIPCION = "descripcion";
    private static final String DROP_TABLE_SALARIO = "DROP TABLE IF EXISTS " + TABLE_SALARIO + ";";
    private static final String CREATE_TABLE_SALARIO = "CREATE TABLE IF NOT EXISTS " + TABLE_SALARIO + "(" +
            COLUMN_SALARIO_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            COLUMN_SALARIO_DESCRIPCION + " TEXT NOT NULL" +
            ");";
    public static final String TABLE_SALARIO_RESET_AUTOINCREMENT = "UPDATE sqlite_sequence SET seq = 0 WHERE name = '" + TABLE_SALARIO + "';";

    // Conforme
    public static final String TABLE_CONFORME = "Conforme";
    public static final String COLUMN_CONFORME_ID = "id";
    public static final String COLUMN_CONFORME_DESCRIPCION = "descripcion";
    private static final String DROP_TABLE_CONFORME = "DROP TABLE IF EXISTS " + TABLE_CONFORME + ";";
    private static final String CREATE_TABLE_CONFORME = "CREATE TABLE IF NOT EXISTS " + TABLE_CONFORME + "(" +
            COLUMN_CONFORME_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            COLUMN_CONFORME_DESCRIPCION + " TEXT NOT NULL" +
            ");";
    public static final String TABLE_CONFORME_RESET_AUTOINCREMENT = "UPDATE sqlite_sequence SET seq = 0 WHERE name = '" + TABLE_CONFORME + "';";

    // Encuesta
    public static final String TABLE_ENCUESTA = "Encuesta";
    public static final String COLUMN_ENCUESTA_ID = "id";
    public static final String COLUMN_ENCUESTA_ID_SEXO = "id_sexo";
    public static final String COLUMN_ENCUESTA_ID_ESTUDIO = "id_estudio";
    public static final String COLUMN_ENCUESTA_ID_EDAD = "id_edad";
    public static final String COLUMN_ENCUESTA_ID_TRABAJO = "id_trabajo";
    public static final String COLUMN_ENCUESTA_ID_RELACION_CONTRACTUAL = "id_relacion_contractual";
    public static final String COLUMN_ENCUESTA_ID_RUBRO = "id_rubro";
    public static final String COLUMN_ENCUESTA_ID_HORA_SEMANAL = "id_hora_semanal";
    public static final String COLUMN_ENCUESTA_ID_ANTIGUEDAD = "id_antiguedad";
    public static final String COLUMN_ENCUESTA_ID_SALARIO = "id_salario";
    public static final String COLUMN_ENCUESTA_ID_CONFORME = "id_conforme";
    public static final String COLUMN_ENCUESTA_ID_ENCUESTADOR = "id_encuestador";
    private static final String DROP_TABLE_ENCUESTA = "DROP TABLE IF EXISTS " + TABLE_ENCUESTA + ";";
    private static final String CREATE_TABLE_ENCUESTA = "CREATE TABLE IF NOT EXISTS " + TABLE_ENCUESTA + "(" +
            COLUMN_ENCUESTA_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            COLUMN_ENCUESTA_ID_SEXO + " INTEGER NOT NULL," +
            COLUMN_ENCUESTA_ID_ESTUDIO + " INTEGER NOT NULL," +
            COLUMN_ENCUESTA_ID_EDAD + " INTEGER NOT NULL," +
            COLUMN_ENCUESTA_ID_TRABAJO + " INTEGER NOT NULL," +
            COLUMN_ENCUESTA_ID_RELACION_CONTRACTUAL + " INTEGER NOT NULL," +
            COLUMN_ENCUESTA_ID_RUBRO + " INTEGER NOT NULL," +
            COLUMN_ENCUESTA_ID_HORA_SEMANAL + " INTEGER NOT NULL," +
            COLUMN_ENCUESTA_ID_ANTIGUEDAD + " INTEGER NOT NULL," +
            COLUMN_ENCUESTA_ID_SALARIO + " INTEGER NOT NULL," +
            COLUMN_ENCUESTA_ID_CONFORME + " INTEGER NOT NULL," +
            COLUMN_ENCUESTA_ID_ENCUESTADOR + " TEXT NOT NULL," +
            "CONSTRAINT FK_Encuesta_Encuestador FOREIGN KEY (" + COLUMN_ENCUESTA_ID_ENCUESTADOR + ") REFERENCES " + TABLE_ENCUESTADOR + "(" + COLUMN_ENCUESTADOR_CUE + ")" +
            ");";
    public static final String TABLE_ENCUESTA_RESET_AUTOINCREMENT = "UPDATE sqlite_sequence SET seq = 0 WHERE name = '" + TABLE_ENCUESTA + "';";

    /* Metodos para crear implementar SQLiteOpenHelper */
    public ConectSQLiteHelperDB(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_ENCUESTADOR);
        db.execSQL(CREATE_TABLE_SEXO);
        db.execSQL(CREATE_TABLE_ESTUDIO);
        db.execSQL(CREATE_TABLE_EDAD);
        db.execSQL(CREATE_TABLE_TRABAJO);
        db.execSQL(CREATE_TABLE_RELACION_CONTRACTUAL);
        db.execSQL(CREATE_TABLE_RUBRO);
        db.execSQL(CREATE_TABLE_HORA_SEMANAL);
        db.execSQL(CREATE_TABLE_ANTIGUEDAD);
        db.execSQL(CREATE_TABLE_SALARIO);
        db.execSQL(CREATE_TABLE_CONFORME);
        db.execSQL(CREATE_TABLE_ENCUESTA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE_ENCUESTADOR);
        db.execSQL(DROP_TABLE_SEXO);
        db.execSQL(DROP_TABLE_ESTUDIO);
        db.execSQL(DROP_TABLE_EDAD);
        db.execSQL(DROP_TABLE_TRABAJO);
        db.execSQL(DROP_TABLE_RELACION_CONTRACTUAL);
        db.execSQL(DROP_TABLE_RUBRO);
        db.execSQL(DROP_TABLE_HORA_SEMANAL);
        db.execSQL(DROP_TABLE_ANTIGUEDAD);
        db.execSQL(DROP_TABLE_SALARIO);
        db.execSQL(DROP_TABLE_CONFORME);
        db.execSQL(DROP_TABLE_ENCUESTA);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }
}
