package com.example.alumnos.nuevo1;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


    public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {
        SQLiteDatabase base;

        public AdminSQLiteOpenHelper(Context context, String Nombre, SQLiteDatabase.CursorFactory cursorFactory, int version)
        {
            super(context,Nombre,cursorFactory,version);
        }
        public void onCreate(SQLiteDatabase base)
        {
            String query = "CREATE DATABASE leasy(integer categorias, text frases, text rutaAudio)";
            base.execSQL(query);
            ContentValues insertar = new ContentValues();
            insertar.put("categorias",1);
            insertar.put("frases","Pedir un refresco");
            base = getWritableDatabase();
            base.insert("leasy",null,insertar);
            base.close();

        }
        public void onUpgrade(SQLiteDatabase base, int valor, int valor1){
            String query = "DROP TABLE IF EXIST leasy";
            base.execSQL(query);
            query = "CREATE DATABASE leasy(integer categorias, text frases, text rutaAudio)";
            base.execSQL(query);

        }
    }

