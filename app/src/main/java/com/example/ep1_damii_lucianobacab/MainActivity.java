package com.example.ep1_damii_lucianobacab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView LV;
    TextView TV,TVS;
    List<Contacto> lst;
    //Planetas
    private String Me, Ve, Ti, Ma, Ju, Sa, Ur, Ne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Recuperar Tema y Aplicarlo
        SharedPreferences TS = getSharedPreferences("Tema", Context.MODE_PRIVATE);
        String TemaSeleccionado = TS.getString("TemaSeleccionado2", "No Hay Tema Aplicado");
        if (TemaSeleccionado != null) {
            if (TemaSeleccionado.equals("Claro")) {
                setTheme(R.style.Theme_EP1_DAMII_LucianoBacab);
            } else if (TemaSeleccionado.equals("Oscuro")) {
                setTheme(R.style.Oscuro);
            } else if (TemaSeleccionado.equals("Personalizado")) {
                setTheme(R.style.MiTema);
            }
        }
        setContentView(R.layout.activity_main);
        //Activar Toolbar
        setSupportActionBar(findViewById(R.id.toolbar));

        LV = (ListView) findViewById(R.id.LV);
        TV = (TextView) findViewById(R.id.TV);
        TVS = (TextView) findViewById(R.id.TVS);

        CustomAdapter adapter = new CustomAdapter(this, GetData());
        LV.setAdapter(adapter);

        LV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contacto c = lst.get(position);
                Toast.makeText(getBaseContext(), "Planeta Seleccionado: "+c.TVNP, Toast.LENGTH_SHORT).show();
                TV.setText(c.TVNP);
                TVS.setText(c.TVNP);
                guardarPreference();
                    Intent intent1 = new Intent(MainActivity.this,Planeta.class);
                    startActivity(intent1);
            }
        });

    }

    //Metodo para mostrar y ocultar el menu

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menuoverflow, menu);
        return true;
    }

    //Metodo de seleccion de opciones
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id==R.id.MIC) {
            SharedPreferences TS = getSharedPreferences("Tema", Context.MODE_PRIVATE);
            String TemaSeleccionado1 = "Claro";
            SharedPreferences.Editor TC = TS.edit();
            TC.putString("TemaSeleccionado2", TemaSeleccionado1.toString());
            TC.commit();
            Toast.makeText(this, "Tema Claro Aplicado", Toast.LENGTH_SHORT).show();

        }else if(id==R.id.MIO) {
            SharedPreferences TS = getSharedPreferences("Tema", Context.MODE_PRIVATE);
            String TemaSeleccionado1 = "Oscuro";
            SharedPreferences.Editor TO = TS.edit();
            TO.putString("TemaSeleccionado2", TemaSeleccionado1.toString());
            TO.commit();
            Toast.makeText(this, "Tema Oscuro Aplicado", Toast.LENGTH_SHORT).show();

        }else if(id==R.id.MIP){
            SharedPreferences TS = getSharedPreferences("Tema", Context.MODE_PRIVATE);
            String TemaSeleccionado1 = "Personalizado";
            SharedPreferences.Editor TP = TS.edit();
            TP.putString("TemaSeleccionado2", TemaSeleccionado1.toString());
            TP.commit();
            Toast.makeText(this, "Tema Personalizado Aplicado", Toast.LENGTH_SHORT).show();

        }

        Intent intent = new Intent(MainActivity.this,MainActivity.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }


    private List<Contacto> GetData(){
        lst = new ArrayList<>();

        lst.add(new Contacto(0, R.drawable.mercurio, "Planeta:","Mercurio"));
        lst.add(new Contacto(1, R.drawable.venus, "Planeta:","Venus"));
        lst.add(new Contacto(2, R.drawable.tierra, "Planeta:","Tierra"));
        lst.add(new Contacto(3, R.drawable.marte, "Planeta:","Marte"));
        lst.add(new Contacto(4, R.drawable.jupiter, "Planeta:","Jupiter"));
        lst.add(new Contacto(5, R.drawable.saturno, "Planeta:","Saturno"));
        lst.add(new Contacto(6, R.drawable.urano, "Planeta:","Urano"));
        lst.add(new Contacto(7, R.drawable.neptuno, "Planeta:", "Neptuno"));

        return lst;
    }


    private void guardarPreference() {
        String fs = TVS.getText().toString();

        if (fs.equals("Mercurio")){
            SharedPreferences prfMe = getSharedPreferences("Mercurio1", Context.MODE_PRIVATE);
            Me = fs;
            int Op= 1;
            String Opn = String.valueOf(Op);
            SharedPreferences.Editor editMer = prfMe.edit();
            editMer.putString("Mercurio", Me.toString());
            editMer.putString("Opcion1", Opn.toString());
            editMer.commit();
            Toast.makeText(getApplicationContext(), "Planeta Guardado ", Toast.LENGTH_SHORT).show();

        } else if (fs.equals("Venus")){
            SharedPreferences prfVe = getSharedPreferences("Venus1", Context.MODE_PRIVATE);
            Ve = fs;
            int Op2= 2;
            String Opn2 = String.valueOf(Op2);
            SharedPreferences.Editor editVe = prfVe.edit();
            editVe.putString("Venus", Ve.toString());
            editVe.putString("Opcion2", Opn2.toString());
            editVe.commit();
            Toast.makeText(getApplicationContext(), "Planeta Guardado ", Toast.LENGTH_SHORT).show();

        } else if (fs.equals("Tierra")){
            SharedPreferences prfTi = getSharedPreferences("Tierra1", Context.MODE_PRIVATE);
            Ti = fs;
            int Op3= 3;
            String Opn3 = String.valueOf(Op3);
            SharedPreferences.Editor editTi = prfTi.edit();
            editTi.putString("Tierra", Ti.toString());
            editTi.putString("Opcion3", Opn3.toString());
            editTi.commit();
            Toast.makeText(getApplicationContext(), "Planeta Guardado ", Toast.LENGTH_SHORT).show();

        } else if (fs.equals("Marte")){
            SharedPreferences prfMa = getSharedPreferences("Marte1", Context.MODE_PRIVATE);
            Ma = fs;
            int Op4= 4;
            String Opn4 = String.valueOf(Op4);
            SharedPreferences.Editor editMa = prfMa.edit();
            editMa.putString("Marte", Ma.toString());
            editMa.putString("Opcion4", Opn4.toString());
            editMa.commit();
            Toast.makeText(getApplicationContext(), "Planeta Guardado ", Toast.LENGTH_SHORT).show();

        } else if (fs.equals("Jupiter")){
            SharedPreferences prfJu = getSharedPreferences("Jupiter1", Context.MODE_PRIVATE);
            Ju = fs;
            int Op5= 5;
            String Opn5 = String.valueOf(Op5);
            SharedPreferences.Editor editJu = prfJu.edit();
            editJu.putString("Jupiter", Ju.toString());
            editJu.putString("Opcion5", Opn5.toString());
            editJu.commit();
            Toast.makeText(getApplicationContext(), "Planeta Guardado ", Toast.LENGTH_SHORT).show();

        } else if (fs.equals("Saturno")){
            SharedPreferences prfSa = getSharedPreferences("Saturno1", Context.MODE_PRIVATE);
            Sa = fs;
            int Op6= 6;
            String Opn6 = String.valueOf(Op6);
            SharedPreferences.Editor editSa = prfSa.edit();
            editSa.putString("Saturno", Sa.toString());
            editSa.putString("Opcion6", Opn6.toString());
            editSa.commit();
            Toast.makeText(getApplicationContext(), "Planeta Guardado ", Toast.LENGTH_SHORT).show();

        } else if (fs.equals("Urano")){
            SharedPreferences prfUr = getSharedPreferences("Urano1", Context.MODE_PRIVATE);
            Ur = fs;
            int Op7= 7;
            String Opn7 = String.valueOf(Op7);
            SharedPreferences.Editor editUr = prfUr.edit();
            editUr.putString("Urano", Ur.toString());
            editUr.putString("Opcion7", Opn7.toString());
            editUr.commit();
            Toast.makeText(getApplicationContext(), "Planeta Guardado ", Toast.LENGTH_SHORT).show();

        } else if (fs.equals("Neptuno")){
            SharedPreferences prfNe = getSharedPreferences("Neptuno1", Context.MODE_PRIVATE);
            Ne = fs;
            int Op8= 8;
            String Opn8 = String.valueOf(Op8);
            SharedPreferences.Editor editNe = prfNe.edit();
            editNe.putString("Neptuno", Ne.toString());
            editNe.putString("Opcion8", Opn8.toString());
            editNe.commit();
            Toast.makeText(getApplicationContext(), "Planeta Guardado ", Toast.LENGTH_SHORT).show();

        }

    }


}