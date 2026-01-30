package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText cena;
    private Spinner marki;
    private ListView model;
    private SeekBar lata;
    private CheckBox wlasciciel;
    private RadioGroup historia;
    private RadioButton radio;
    private TextView rocznik;
    private ListView auta;
    private ArrayList<String> modele;
    private ArrayList<String> autaLista;
    private ArrayAdapter<String> modeleAdapter;
    private ArrayAdapter<String> autaAdapter;
    private Integer fcena;
    private String fmarka;
    private String fmodel;
    private Integer frok;
    private Boolean fwlasciciel;
    private String fhistoria = "Bezwypadkowe";
    private Button  dodaj;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        marki = findViewById(R.id.marki);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.marki_lista, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        marki.setAdapter(adapter);

        model = findViewById(R.id.model);
        modele = new ArrayList<>();
        modeleAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, modele);
        model.setAdapter(modeleAdapter);

        auta = findViewById(R.id.auta);
        autaLista = new ArrayList<>();
        autaAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, autaLista);
        auta.setAdapter(autaAdapter);

        String[][] marki_lista = {
                {"Yaris", "Corolla", "RAV4"},
                {"Focus", "Mustang", "Fiesta", "Explorer"},
                {"Civic", "Accord"},
        };

        fcena = 0;
        fmarka = "Toyota";
        fmodel = "";
        frok = 2000;

        marki.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        modele.clear();
                        for(int j = 0; j < marki_lista[i].length; j++){
                            modele.add(marki_lista[i][j]);
                        }
                        modeleAdapter.notifyDataSetChanged();
                        fmarka = marki.getSelectedItem().toString();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                }
        );
        model.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        fmodel = model.getItemAtPosition(i).toString();
                    }
                }
        );
        lata = findViewById(R.id.lata);
        rocznik = findViewById(R.id.rocznik);
        lata.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        rocznik.setText(String.valueOf(i));
                        frok = i;
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );
        wlasciciel = findViewById(R.id.wlasciciel);
        fwlasciciel = wlasciciel.isChecked();

        historia = findViewById(R.id.historia);
        historia.setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(@NonNull RadioGroup radioGroup, int i) {
                        radio = findViewById(i);
                        fhistoria = radio.getText().toString();
                    }
                }
        );

        cena = findViewById(R.id.cena);

        dodaj = findViewById(R.id.dodaj);
        dodaj.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        fcena = Integer.parseInt(cena.getText().toString());
                        Samochody samochod = new Samochody(fcena,fmarka,fmodel,frok,fwlasciciel,fhistoria);
                        autaLista.add(samochod.toString());
                        autaAdapter.notifyDataSetChanged();
                    }
                }
        );
    }
}