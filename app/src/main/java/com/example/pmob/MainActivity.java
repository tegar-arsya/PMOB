package com.example.pmob;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.example.pmob.R;
public class MainActivity extends AppCompatActivity {
    Button tombol1,tombolUtama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tombol1 = (Button) findViewById(R.id.tombol1);
        tombol1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,HasilActivity.class);
                startActivity(intent);
            }
        });
        tombolUtama = (Button) findViewById(R.id.tombolUtama);
        tombolUtama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE );
                if ( !manager.isProviderEnabled( LocationManager.GPS_PROVIDER ) ) {
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                    alertDialogBuilder.setMessage("GPS belum aktif. Silahkan aktifkan terlebih dahulu.")
                            .setCancelable(false)
                            .setPositiveButton("Sentuh disini untuk masuk ke pengaturan GPS",
                                    new DialogInterface.OnClickListener(){
                                        public void onClick(DialogInterface dialog, int id){
                                            Intent callGPSSettingIntent = new Intent(
                                                    android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                                            startActivity(callGPSSettingIntent);
                                        }
                                    });
                    alertDialogBuilder.setNegativeButton("Batalkan",
                            new DialogInterface.OnClickListener(){
                                public void onClick(DialogInterface dialog, int id){
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alert = alertDialogBuilder.create();
                    alert.show();
                }else {
                    if(isNetworkAvailable() == false){
                        Toast.makeText(MainActivity.this, "Tidak ada koneksi internet!!", Toast.LENGTH_SHORT).show();
                    }else{
                        Intent intent = new Intent(MainActivity.this, CariCepat.class);
                        startActivity(intent);
                    }
                }
            }
        });
    }
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}