package com.example.ep1_damii_lucianobacab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import android.widget.Toast;

public class Planeta extends AppCompatActivity {
    ListView LVF;
    List<Contacto1> lst1;
    private Button Salir;
    private TextView TVP1;
    private TextView TVPI;
    private ImageView IVP1;
    private Button btnVolver;

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
        setContentView(R.layout.activity_planeta);
        //Activar Toolbar
        setSupportActionBar(findViewById(R.id.toolbar));

        TVP1 = (TextView) findViewById(R.id.TVP1);
        TVPI = (TextView) findViewById(R.id.TVPI);
        IVP1 = (ImageView) findViewById(R.id.IVP1);
        datos();

        Spinner FTA = (Spinner) findViewById(R.id.Spinner);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this, R.array.Opciones, android.R.layout.simple_spinner_item);

        FTA.setAdapter(adapter);
        FTA.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(parent.getContext(), "Seleccion: "+parent.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();
                String PlanetaS = TVP1.getText().toString();
                if (PlanetaS.equals("Mercurio")){
                    if (position==0){
                        TVPI.setText("");

                    } else if (position==1){
                        String infoCMe = "El clima mercuriano es extremo en sus dos caras: la cara expuesta al Sol alcanza temperaturas de alrededor de 427 a 430 °C, mientras que su rostro oculto desciende a los -173 °C.";
                        TVPI.setText(infoCMe);

                    } else if (position==2){
                        String infoGMe = "Mercurio es un planeta sólido y rocoso, es el planeta más cercano al Sol y es también el más pequeño de todos los planetas del Sistema Solar. Es sólo un poco más grande que la Luna, el satélite natural de la Tierra, ambos cuerpos celestes se caracterizan por tener una superficie cubierta de cráteres.";
                        TVPI.setText(infoGMe);

                    } else if (position==3){
                        String infoFMe = "No se ha encontrado evidencia científica de la existencia de flora en el planeta Mercurio. ";
                        TVPI.setText(infoFMe);

                    } else if (position==4){
                        String infoFaMe = "No se ha encontrado evidencia científica de la existencia de fauna en el planeta Mercurio. ";
                        TVPI.setText(infoFaMe);

                    }

                } else if (PlanetaS.equals("Venus")) {
                    if (position==0){
                        TVPI.setText(" ");

                    } else if (position==1){
                        String infoCVe = "Venus está cubierto por una atmósfera densa de dióxido de carbono, y sus nubes son de ácido sulfúrico. Ambos forman el llamado efecto invernadero: atrapan el calor y calientan el planeta. Venus puede alcanzar temperaturas insoportables: ¡hasta 847℉ (453℃).";
                        TVPI.setText(infoCVe);

                    } else if (position==2){
                        String infoGVe = "Tiene dos masas de tierra elevada, que podríamos considerar continentes. En el norte, Ishtar Terra, de un tamaño aproximado al de Australia, y en el sur, Maxwell Montes, más o menos como Sudamérica. La mayor montaña de Venus está en Ishtar y es un par de kilómetros más alta que el Everest.";
                        TVPI.setText(infoGVe);

                    } else if (position==3){
                        String infoFVe = "Hasta la fecha, no se ha encontrado evidencia científica de la existencia de flora o vegetación en el planeta Venus. Venus es un planeta inhóspito con un entorno extremadamente hostil para la vida tal como la conocemos.";
                        TVPI.setText(infoFVe);

                    } else if (position==4){
                        String infoFaVe = "Hasta la fecha, no se ha encontrado evidencia científica de la existencia de fauna o vida animal en el planeta Venus.";
                        TVPI.setText(infoFaVe);

                    }

                } else if (PlanetaS.equals("Tierra")) {
                    if (position==0){
                        TVPI.setText("");

                    } else if (position==1){
                        String infoCTi = "El clima terrestre es producto de la constante interacción entre la atmósfera, los océanos, las capas de hielo y nieve, los continentes y, muy importante, la vida en el planeta.";
                        TVPI.setText(infoCTi);

                    } else if (position==2){
                        String infoGTi = "A continuación se presentan los elementos principales de la geografía de la Tierra: Relieve, Hidrografía, Clima, Vegetación, Distribución de los continentes y océanos.";
                        TVPI.setText(infoGTi);

                    } else if (position==3){
                        String infoFTi = "La flora del planeta Tierra es extremadamente diversa y abarca una amplia variedad de plantas, desde pequeñas hierbas hasta árboles gigantes.";
                        TVPI.setText(infoFTi);

                    } else if (position==4){
                        String infoFaTI = "La fauna del planeta Tierra es sumamente diversa y abarca una amplia variedad de especies animales, desde organismos microscópicos hasta grandes mamíferos.";
                        TVPI.setText(infoFaTI);

                    }

                } else if (PlanetaS.equals("Marte")) {
                    if (position==0){
                        TVPI.setText("");

                    } else if (position==1){
                        String infoCMa = "Las temperaturas diurnas en Marte se acercan a las temperaturas de invierno en la Tierra y pueden llegar hasta los 32℉ (0℃). Pero la delgada atmósfera de Marte no puede mantener el calor del Sol y, por la noche, las temperaturas se encuentran alrededor de los -200℉ (-129℃).";
                        TVPI.setText(infoCMa);

                    } else if (position==2){
                        String infoGMa = "La geografía de Marte, también conocido como el Planeta Rojo, presenta características únicas y fascinantes: Superficie marciana, Monte Olimpo, Valles y cañones, Cráteres de impacto y Llanuras.";
                        TVPI.setText(infoGMa);

                    } else if (position==3){
                        String infoFMa = "Hasta la fecha, no se ha encontrado evidencia de flora o vegetación en el planeta Marte. Según los conocimientos científicos actuales, las condiciones en Marte no son favorables para el crecimiento de plantas tal como las conocemos en la Tierra.";
                        TVPI.setText(infoFMa);

                    } else if (position==4){
                        String infoFaMa = "Hasta la fecha, no se ha encontrado evidencia de fauna o vida animal en el planeta Marte. Marte es un planeta extremadamente inhóspito y hostil para la vida tal como la conocemos en la Tierra.";
                        TVPI.setText(infoFaMa);

                    }

                } else if (PlanetaS.equals("Jupiter")) {
                    if (position==0){
                        TVPI.setText("");

                    } else if (position==1){
                        String infoCJu = "Las temperaturas atmosféricas en Júpiter tienen un rango de entre 930 y 1.330 grados centígrados. Esto es mucho más que la temperatura de la lava fundida y causaría que las baterías de litio de los celulares se evaporaran y se volvieran gas.";
                        TVPI.setText(infoCJu);

                    } else if (position==2){
                        String infoGJu = "Tiene fuertes tormentas como la Gran Mancha Roja, que hace cientos de años que dura. Júpiter es un gigante hecho de gas, y no tiene una superficie sólida, pero puede tener un núcleo interno sólido de aproximadamente el tamaño de la Tierra.";
                        TVPI.setText(infoGJu);

                    } else if (position==3){
                        String infoFJu = "No se ha encontrado evidencia de flora en el planeta Júpiter. Júpiter es un gigante gaseoso compuesto principalmente por hidrógeno y helio, sin una superficie sólida como la que tienen los planetas rocosos como la Tierra.";
                        TVPI.setText(infoFJu);

                    } else if (position==4){
                        String infoFaJu = "No se ha encontrado evidencia de fauna en el planeta Júpiter. Júpiter es un gigante gaseoso compuesto principalmente por hidrógeno y helio, sin una superficie sólida como la que tienen los planetas rocosos. ";
                        TVPI.setText(infoFaJu);

                    }

                } else if (PlanetaS.equals("Saturno")) {
                    if (position==0){
                        TVPI.setText("");

                    } else if (position==1){
                        String infoCSa = "La temperatura promedio en Saturno ronda los 143 K, es decir, -130,15 °C y alcanzando los -180,15 °C en la región de sus nubes. Aunque el interior del planeta es difícil de conocer, se estima que posee un núcleo rocoso.";
                        TVPI.setText(infoCSa);

                    } else if (position==2){
                        String infoGSa = "Es una gran bola de gas con una masa casi 95.1 veces la de la Tierra y un volumen 755 veces mayor, famosa por sus numerosos anillos. Pertenece al grupo de los planetas gaseosos.";
                        TVPI.setText(infoGSa);

                    } else if (position==3){
                        String infoFSa = "No se ha encontrado evidencia de flora en el planeta Saturno. Saturno es un gigante gaseoso compuesto principalmente por hidrógeno y helio, sin una superficie sólida como la que tienen los planetas rocosos.";
                        TVPI.setText(infoFSa);

                    } else if (position==4){
                        String infoFaSa = "No se ha encontrado evidencia de fauna en el planeta Saturno. Saturno es un gigante gaseoso compuesto principalmente por hidrógeno y helio, sin una superficie sólida como la que tienen los planetas rocosos.";
                        TVPI.setText(infoFaSa);

                    }

                } else if (PlanetaS.equals("Urano")) {
                    if (position==0){
                        TVPI.setText("");

                    } else if (position==1){
                        String infoCUr = "rano es Famoso como gigante de hielo y hace honor a su nombre: alcanza temperaturas de -360℉ (-218℃). Además, su eje está ladeado unos 98℉ (37℃).";
                        TVPI.setText(infoCUr);

                    } else if (position==2){
                        String infoGUr = "Urano está constituido por un núcleo de roca, un manto helado y una capa exterior gaseosa. Carece de una superficie sólida. El 80 por ciento (puede ser más) de su masa está compuesto de un fluido denso y caliente de materiales de hielo (agua, amoníaco y metano) que está encima del núcleo rocoso.";
                        TVPI.setText(infoGUr);

                    } else if (position==3){
                        String infoFUr = "No se ha encontrado evidencia de flora en el planeta Urano. Urano es un gigante gaseoso compuesto principalmente por hidrógeno y helio, sin una superficie sólida como la que tienen los planetas rocosos.";
                        TVPI.setText(infoFUr);

                    } else if (position==4){
                        String infoFaUr = "No se ha encontrado evidencia de fauna en el planeta Urano. Urano es un gigante gaseoso compuesto principalmente por hidrógeno y helio, sin una superficie sólida como la que tienen los planetas rocosos.";
                        TVPI.setText(infoFaUr);

                    }

                } else if (PlanetaS.equals("Neptuno")) {
                    if (position==0){
                        TVPI.setText("");

                    } else if (position==1){
                        String infoCNe = "Neptuno está muy, muy lejos: una media de 2800 millones de millas (4506 millones de kilómetros) del Sol. Eso significa que este gigante gélido tiene unas temperaturas muy frías. La temperatura media en Neptuno es de -360℉ (-218℃). Si esta temperatura te suena es porque Urano está casi a la misma temperatura.";
                        TVPI.setText(infoCNe);

                    } else if (position==2){
                        String infoGNe = "Está más de 30 veces más lejos del Sol que la Tierra. Neptuno es muy parecido a Urano. Está compuesto de una espesa mezcla de agua, amoniaco y metano sobre un centro sólido del tamaño de la Tierra. Su atmósfera se compone de hidrógeno, helio y metano.";
                        TVPI.setText(infoGNe);

                    } else if (position==3){
                        String infoFNe = "No se ha encontrado evidencia de flora en el planeta Neptuno. Neptuno es un gigante gaseoso compuesto principalmente por hidrógeno y helio, sin una superficie sólida como la que tienen los planetas rocosos.";
                        TVPI.setText(infoFNe);

                    } else if (position==4){
                        String infoFaNe = "No se ha encontrado evidencia de fauna en el planeta Neptuno. Neptuno es un gigante gaseoso compuesto principalmente por hidrógeno y helio, sin una superficie sólida como la que tienen los planetas rocosos.";
                        TVPI.setText(infoFaNe);

                    }

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnVolver = (Button) findViewById(R.id.btnVolver);
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("INFO:", "Planeta");
                restablecer();
                Intent intent = new Intent(Planeta.this, MainActivity.class);
                startActivity(intent);
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

        Intent intent = new Intent(Planeta.this,Planeta.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }



    private void datos(){

        SharedPreferences prfMe = getSharedPreferences("Mercurio1", Context.MODE_PRIVATE);
        String OpcionMe = prfMe.getString("Opcion1", "0");
        int OpcionMe1 = Integer.parseInt(OpcionMe);

        if (OpcionMe1==1) {
            String Mercurio = prfMe.getString("Mercurio", "No hay planetas");
            TVP1.setText(Mercurio);
            IVP1.setImageResource(R.drawable.mercurio);

        }

        SharedPreferences prfVe = getSharedPreferences("Venus1", Context.MODE_PRIVATE);
        String OpcionVe = prfVe.getString("Opcion2", "0");
        int OpcionVe1 = Integer.parseInt(OpcionVe);

        if (OpcionVe1==2) {
            String Venus = prfVe.getString("Venus", "No hay planetas");
            TVP1.setText(Venus);
            IVP1.setImageResource(R.drawable.venus);

        }

        SharedPreferences prfTi = getSharedPreferences("Tierra1", Context.MODE_PRIVATE);
        String OpcionTi = prfTi.getString("Opcion3", "0");
        int OpcionTi1 = Integer.parseInt(OpcionTi);

        if (OpcionTi1==3) {
            String Tierra = prfTi.getString("Tierra", "No hay planetas");
            TVP1.setText(Tierra);
            IVP1.setImageResource(R.drawable.tierra);

        }

        SharedPreferences prfMa = getSharedPreferences("Marte1", Context.MODE_PRIVATE);
        String OpcionMa = prfMa.getString("Opcion4", "0");
        int OpcionMa1 = Integer.parseInt(OpcionMa);

        if (OpcionMa1==4) {
            String Marte = prfMa.getString("Marte", "No hay planetas");
            TVP1.setText(Marte);
            IVP1.setImageResource(R.drawable.marte);

        }

        SharedPreferences prfJu = getSharedPreferences("Jupiter1", Context.MODE_PRIVATE);
        String OpcionJu = prfJu.getString("Opcion5", "0");
        int OpcionJu1 = Integer.parseInt(OpcionJu);

        if (OpcionJu1==5) {
            String Jupiter = prfJu.getString("Jupiter", "No hay planetas");
            TVP1.setText(Jupiter);
            IVP1.setImageResource(R.drawable.jupiter);

        }

        SharedPreferences prfSa = getSharedPreferences("Saturno1", Context.MODE_PRIVATE);
        String OpcionSa = prfSa.getString("Opcion6", "0");
        int OpcionSa1 = Integer.parseInt(OpcionSa);

        if (OpcionSa1==6) {
            String Saturno = prfSa.getString("Saturno", "No hay planetas");
            TVP1.setText(Saturno);
            IVP1.setImageResource(R.drawable.saturno);

        }

        SharedPreferences prfUr = getSharedPreferences("Urano1", Context.MODE_PRIVATE);
        String OpcionUr = prfUr.getString("Opcion7", "0");
        int OpcionUr1 = Integer.parseInt(OpcionUr);

        if (OpcionUr1==7) {
            String Urano = prfUr.getString("Urano", "No hay planetas");
            TVP1.setText(Urano);
            IVP1.setImageResource(R.drawable.urano);

        }

        SharedPreferences prfNe = getSharedPreferences("Neptuno1", Context.MODE_PRIVATE);
        String OpcionNe = prfNe.getString("Opcion8", "0");
        int OpcionNe1 = Integer.parseInt(OpcionNe);

        if (OpcionNe1==8) {
            String Neptuno = prfNe.getString("Neptuno", "No hay planetas");
            TVP1.setText(Neptuno);
            IVP1.setImageResource(R.drawable.neptuno);

        }


    }

    private void restablecer () {
        SharedPreferences prfMe = getSharedPreferences("Mercurio1", Context.MODE_PRIVATE);
        SharedPreferences.Editor editMer1 = prfMe.edit();
        editMer1.clear();
        editMer1.apply();

        SharedPreferences prfVe = getSharedPreferences("Venus1", Context.MODE_PRIVATE);
        SharedPreferences.Editor editVe1 = prfVe.edit();
        editVe1.clear();
        editVe1.apply();

        SharedPreferences prfTi = getSharedPreferences("Tierra1", Context.MODE_PRIVATE);
        SharedPreferences.Editor editTi1 = prfTi.edit();
        editTi1.clear();
        editTi1.apply();

        SharedPreferences prfMa = getSharedPreferences("Marte1", Context.MODE_PRIVATE);
        SharedPreferences.Editor editMa1 = prfMa.edit();
        editMa1.clear();
        editMa1.apply();

        SharedPreferences prfJu = getSharedPreferences("Jupiter1", Context.MODE_PRIVATE);
        SharedPreferences.Editor editJu1 = prfJu.edit();
        editJu1.clear();
        editJu1.apply();

        SharedPreferences prfSa = getSharedPreferences("Saturno1", Context.MODE_PRIVATE);
        SharedPreferences.Editor editSa1 = prfSa.edit();
        editSa1.clear();
        editSa1.apply();

        SharedPreferences prfUr = getSharedPreferences("Urano1", Context.MODE_PRIVATE);
        SharedPreferences.Editor editUr1 = prfUr.edit();
        editUr1.clear();
        editUr1.apply();

        SharedPreferences prfNe = getSharedPreferences("Neptuno1", Context.MODE_PRIVATE);
        SharedPreferences.Editor editNe1 = prfNe.edit();
        editNe1.clear();
        editNe1.apply();

    }


}