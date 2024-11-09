package com.example.tp_integrador_paii.conexion;

public class DataDB {
    /* BD */
    //Informacion de la BD
    public static String host = "sql10.freesqldatabase.com";
    public static String port = "3306";
    public static String nameBD = "sql10737404";
    public static String user = "sql10737404";
    public static String pass = "7WcqHbE7Wr";

    //Informacion para la conexion
    public static String urlMySQL = "jdbc:mysql://" + host + ":" + port + "/" + nameBD;
    public static String driver = "com.mysql.jdbc.Driver";

    /* TABLAS */
    // Encuestador
    public static final String TABLE_ENCUESTADOR = "Encuestador";
    public static final String COLUMN_ENCUESTADOR_CUE = "cue";
    public static final String COLUMN_ENCUESTADOR_PASSWORD = "password";

    // Sexo
    public static final String TABLE_SEXO = "Sexo";
    public static final String COLUMN_SEXO_ID = "id";
    public static final String COLUMN_SEXO_DESCRIPCION = "descripcion";

    // Estudio
    public static final String TABLE_ESTUDIO = "Estudio";
    public static final String COLUMN_ESTUDIO_ID = "id";
    public static final String COLUMN_ESTUDIO_DESCRIPCION = "descripcion";

    // Edad
    public static final String TABLE_EDAD = "Edad";
    public static final String COLUMN_EDAD_ID = "id";
    public static final String COLUMN_EDAD_DESCRIPCION = "descripcion";

    // Trabajao
    public static final String TABLE_TRABAJO = "Trabajo";
    public static final String COLUMN_TRABAJO_ID = "id";
    public static final String COLUMN_TRABAJO_DESCRIPCION = "descripcion";

    // Relacion_Contractual
    public static final String TABLE_RELACION_CONTRACTUAL = "Relacion_Contractual";
    public static final String COLUMN_RELACION_CONTRACTUAL_ID = "id";
    public static final String COLUMN_RELACION_CONTRACTUAL_DESCRIPCION = "descripcion";

    // Rubro
    public static final String TABLE_RUBRO = "Rubro";
    public static final String COLUMN_RUBRO_ID = "id";
    public static final String COLUMN_RUBRO_DESCRIPCION = "descripcion";

    // Hora_Semanal
    public static final String TABLE_HORA_SEMANAL = "Hora_Semanal";
    public static final String COLUMN_HORA_SEMANAL_ID = "id";
    public static final String COLUMN_HORA_SEMANAL_DESCRIPCION = "descripcion";

    // Antiguedad
    public static final String TABLE_ANTIGUEDAD = "Antiguedad";
    public static final String COLUMN_ANTIGUEDAD_ID = "id";
    public static final String COLUMN_ANTIGUEDAD_DESCRIPCION = "descripcion";

    // Salario
    public static final String TABLE_SALARIO = "Salario";
    public static final String COLUMN_SALARIO_ID = "id";
    public static final String COLUMN_SALARIO_DESCRIPCION = "descripcion";

    // Conforme
    public static final String TABLE_CONFORME = "Conforme";
    public static final String COLUMN_CONFORME_ID = "id";
    public static final String COLUMN_CONFORME_DESCRIPCION = "descripcion";

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
}
