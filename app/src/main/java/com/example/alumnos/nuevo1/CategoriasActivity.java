package com.example.alumnos.nuevo1;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class CategoriasActivity extends AppCompatActivity {
    Bundle bundle;
    int idRecibido;
    String []arreglo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias);
        bundle = getIntent().getExtras();
        idRecibido = bundle.getInt("id");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_categorias, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void consultas(){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"base", null, 1);
        SQLiteDatabase base = admin.getWritableDatabase();
        String query = "SELECT frase FROM leasy WHERE categoria = "+idRecibido;
        Cursor cursor=base.rawQuery(query,null);
        arreglo = new String[cursor.getCount()];
        if (cursor.moveToFirst())


        while (cursor.moveToNext())
            arreglo[0] =cursor.getString(0);
    }
}
