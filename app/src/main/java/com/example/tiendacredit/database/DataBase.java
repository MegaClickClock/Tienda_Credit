package com.example.tiendacredit.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
import com.example.tiendacredit.Articulo;

import java.util.ArrayList;
import java.util.List;

public class DataBase extends SQLiteOpenHelper {
    private static final int VERSION_DATABASE = 1;
    private static final String NOMBRE_DATABASE = "prueba.db";
    private static final String TABLE_INVENTARIO = "t_inventario";

    public DataBase(@Nullable Context context) {
        super(context, NOMBRE_DATABASE, null, VERSION_DATABASE);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_INVENTARIO + "(" +
                "id INTEGER PRIMARY KEY," +
                "curso TEXT NOT NULL, " +
                "precio FLOAT (3,2) NOT NULL )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_INVENTARIO );
        onCreate(db);
    }

    public  void agregarItem(int codigo, String nombreArticulo, float precio){
        SQLiteDatabase bd = getWritableDatabase();
        if (bd!=null ){
            bd.execSQL("INSERT INTO " + TABLE_INVENTARIO + " VALUES" + "('"+codigo+"','"+nombreArticulo+"', '"+precio+"')");
            bd.close();
        }
    }

    public List<Articulo> mostrarItem (){
        SQLiteDatabase bd = getReadableDatabase();
        Cursor cursor = bd.rawQuery("SELECT * FROM " + TABLE_INVENTARIO, null);
        List<Articulo> ArticuloList = new ArrayList<>();
        if (cursor.moveToFirst()){
            do {
                ArticuloList.add(new Articulo(cursor.getInt(0), cursor.getString(1), cursor.getFloat(2)));
            } while (cursor.moveToNext());
        }
        return ArticuloList;
    }

    public  void buscarItem (Articulo Articulo, int codigo){
        SQLiteDatabase bd = getReadableDatabase();
        Cursor cursor = bd.rawQuery("SELECT * FROM " + TABLE_INVENTARIO + " WHERE id = '"+codigo+"' ", null);
        if (cursor.moveToFirst()){
            do {
                Articulo.setnombreArticulo(cursor.getString(1));
                Articulo.setPrecio(cursor.getFloat(2));
            } while (cursor.moveToNext());
        }
    }

    public  void editarItem (int codigo, String curso, float precio){
        SQLiteDatabase bd = getWritableDatabase();
        if (bd!=null){
        bd.execSQL("UPDATE " + TABLE_INVENTARIO + " SET curso = '"+curso+"', precio = '"+precio+"' WHERE id = '"+codigo+"'");
        bd.close();
        }
    }

    public  void eliminarItem (int codigo){
        SQLiteDatabase bd = getWritableDatabase();
        if (bd!=null){
            bd.execSQL("DELETE FROM " + TABLE_INVENTARIO + " WHERE id = '"+codigo+"'");
            bd.close();
        }
    }
}
