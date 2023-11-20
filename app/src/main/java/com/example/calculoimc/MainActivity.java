package com.example.calculoimc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBarPeso;
    SeekBar seekBarAltura;
    TextView txtPeso;
    TextView txtAltura;
    TextView txtResultado;
    ImageView imgResultado;
    Button btncalcular;
    Button btnReiniciar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciarVariaveis();
        iniciarSeekBar();


    }

    public void iniciarVariaveis(){

        seekBarPeso = findViewById(R.id.seekBarPeso);
        seekBarAltura = findViewById(R.id.seekBarAltura);
        txtPeso = findViewById(R.id.txtPeso);
        txtAltura = findViewById(R.id.txtAltura);
        txtResultado = findViewById(R.id.txtResultado);
        imgResultado = findViewById(R.id.imgResultado);
        btncalcular = findViewById(R.id.btnCalcular);
        btnReiniciar = findViewById(R.id.btnReiniciar);


    }

    public void iniciarSeekBar(){
        seekBarPeso.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txtPeso.setText(progress + " Kg");


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarAltura.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txtAltura.setText(progress + " cm");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }



    public void calcularImc(View view){

        double altura = seekBarAltura.getProgress();
        double peso = seekBarPeso.getProgress();

        if (altura ==0  || peso == 0){
            Toast.makeText(getApplicationContext(),
                        "Necessário definir Peso e altura",Toast.LENGTH_SHORT).show();
        }else {

            double imc = (double) peso / ((altura / 100) * (altura / 100));

            if (imc < 18.5) {
                txtResultado.setText("Seu IMC ficou em: " +
                        String.format("%.2f", imc));
                imgResultado.setImageResource(R.drawable.imcbaixo);
            } else if (imc < 24.9) {
                txtResultado.setText("Seu IMC ficou em: " +
                        String.format("%.2f", imc));
                imgResultado.setImageResource(R.drawable.imcnormal);
            } else if (imc < 29.9) {
                txtResultado.setText("Seu IMC ficou em: " +
                        String.format("%.2f", imc));
                imgResultado.setImageResource(R.drawable.imcsobreseso);
            } else if (imc < 39.9) {
                txtResultado.setText("Seu IMC ficou em: " +
                        String.format("%.2f", imc));
                imgResultado.setImageResource(R.drawable.imcobsedidade);
            } else {
                txtResultado.setText("Seu IMC ficou em: " +
                        String.format("%.2f", imc));
                imgResultado.setImageResource(R.drawable.icmobesidadedois);
            }
        }

    }

    public void reiniciar(View view){
        seekBarAltura.setProgress(0);
        seekBarPeso.setProgress(0);
        imgResultado.setImageResource(R.drawable.imc);
        txtResultado.setText("Resultado");
    }
}