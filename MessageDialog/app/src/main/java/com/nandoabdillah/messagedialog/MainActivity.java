package com.nandoabdillah.messagedialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

//        System.out.println("onCreate");
    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//
//        System.out.println("onStart");
//    }
//
//    @Override
//    protected void onPostResume() {
//        super.onPostResume();
//
//        System.out.println("onResume");
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//
//        System.out.println("onPause");
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//
//        System.out.println("onStop");
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//
//        System.out.println("onDestroy");
//    }

    public void showToast(String pesan)
    {
        Toast.makeText(this,pesan, Toast.LENGTH_SHORT).show();
    }

    public void showAlert(String pesan)
    {
        AlertDialog.Builder buatAlert = new AlertDialog.Builder(this);
        buatAlert.setTitle("Perhatian");
        buatAlert.setMessage(pesan);
        buatAlert.show();
    }

    public void showAlertButton(String pesan)
    {
        AlertDialog.Builder buatAlert = new AlertDialog.Builder(this);
        buatAlert.setTitle("Perhatian !");
        buatAlert.setMessage(pesan);

        buatAlert.setPositiveButton("YA", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                showToast("Data sudah dihapus");
            }
        });

        buatAlert.setNegativeButton("TIDAK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                showToast("Data Tidak dihapus");
            }
        });
    }

    public void btnToast(View view)
    {
        showToast("Belajar membuat pesan");
    }

    public void btnAlert(View view)
    {
        showAlert("Selamat Belajar !");
    }

    public void btnAlertDialogButton(View view)
    {
        showAlertButton("Yakin akan menghapus ?");
    }
}