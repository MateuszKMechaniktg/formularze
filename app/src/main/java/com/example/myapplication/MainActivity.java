package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Spinner marki;
    private ListView model;
    private SeekBar lata;
    private TextView rocznik;
    private ArrayList<String> modele;
    private ArrayAdapter<String> markiAdapter;
    private ArrayAdapter<String> modeleAdapter;

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

        String[][] marki_lista = {
                {"Yaris", "Corolla", "RAV4"},
                {"Focus", "Mustang", "Fiesta", "Explorer"},
                {"Civic", "Accord"},
        };
        marki.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        modele.clear();
                        for(int j = 0; j < marki_lista[i].length; j++){

                            modele.add(marki_lista[i][j]);
                        }
                        modeleAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

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
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );
    }
}