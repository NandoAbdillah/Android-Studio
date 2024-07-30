package com.nandoabdillah.kalkulator;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView tvhasil;
    EditText etBil1,etBil2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        load();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void load()
    {
        tvhasil = findViewById(R.id.tvhasil);
        etBil1 = findViewById(R.id.editBil1);
        etBil2 = findViewById(R.id.editBil2);
    }

    public double[] getBil()
    {
        double[] bil = new double[2];
        if (etBil1.getText().toString().equals("") || etBil2.getText().toString().equals(""))
        {
            Toast.makeText(this, "ADA BILANGAN YANG KOSONG", Toast.LENGTH_SHORT).show();
            return null;
        }

        try {
            bil[0] = Double.parseDouble(etBil1.getText().toString());
            bil[1] = Double.parseDouble(etBil2.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(this, "MASUKKAN BILANGAN YANG VALID", Toast.LENGTH_SHORT).show();
            return null;
        }

        return bil;
    }

    public void btnJumlah(View view)
    {
        double[] bilangan = getBil();

        if (bilangan != null) {
            double hasil = bilangan[0] + bilangan[1];
            tvhasil.setText(String.valueOf(hasil));
        }
    }

    public void btnKurang(View view)
    {
        double[] bilangan = getBil();

        if (bilangan !=null) {
            double hasil = bilangan[0]-bilangan[1];
            tvhasil.setText(String.valueOf(hasil));
        }
    }

    public void btnKali(View view)
    {
        double[] bilangan = getBil();

        if (bilangan !=null) {
            double hasil = bilangan[0]*bilangan[1];
            tvhasil.setText(String.valueOf(hasil));
        }
    }

    public void btnBagi(View view)
    {
        double[] bilangan = getBil();

        if (bilangan !=null) {
            double hasil = bilangan[0]/bilangan[1];
            tvhasil.setText(String.valueOf(hasil));
        }
    }
}