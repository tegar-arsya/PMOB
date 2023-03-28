package com.example.pmob;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;
import com.example.pmob.R;

public class tampilRS extends AppCompatActivity {
    private String idRS;
    private String kirim;
    private Double latNya;
    private Double lonNya;
    private String KEY_NAME = "idRS";
    private String kunci_lat = "lat";
    private String kunci_lon = "Lon";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_rs);
        rumahSakit rs = new rumahSakit();
        Button telepon = findViewById(R.id.btn_telepon);
        Button arah = findViewById(R.id.arahin);
        ImageView Gambar = findViewById(R.id.iv_Gambar);
        TextView Alamat = findViewById(R.id.tv_Alamat);
        TextView noTelp = findViewById(R.id.tv_NomorTelepon);
        TextView keterangan = findViewById(R.id.tv_Keterangan);
        Bundle extras = getIntent().getExtras();
        kirim = extras.getString(KEY_NAME);
        latNya = extras.getDouble(kunci_lat);
        lonNya = extras.getDouble(kunci_lon);

        if(kirim.equals("RSKIA PKU Muhammadiyah")){
            rs.setDataRS(kirim);
            setTitle(rs.getNamaRs().toString());
            Resources res = getResources();
            String mDrawableName = rs.getImageRS();
            int resID = res.getIdentifier(mDrawableName , "drawable", getPackageName());
            Gambar.setImageResource(resID);
            Alamat.setText(rs.getAlamatRS());
            noTelp.setText(rs.getNoTelp());

            if((latNya == 0.0 || latNya == null) && (lonNya == 0.0 || lonNya == null) ){
                keterangan.setText(rs.getKetRS());
            }else{
                Double tujuanLat = (rs.getlatTujuan()*(3.14/180));
                Double tujuanLon = (rs.getlonTujuan()*(3.14/180));
                Double a = 2*6371*Math.asin(Math.sqrt((Math.pow(Math.sin((latNya*(3.14/180)-tujuanLat)/2),2))+Math.cos(latNya*(3.14/180))
                        *Math.cos(tujuanLat)*(Math.pow(Math.sin((tujuanLon-lonNya*(3.14/180))/2),2))));

                keterangan.setText("Dari hasil perhitungan jarak pada posisi kamu di titik latitude " + new DecimalFormat("##.####").format(latNya)
                        +" dan longitude " + new DecimalFormat("##.####").format(lonNya) +" ke " + rs.getNamaRs() + " didapatkan perkiraan jarak " + new DecimalFormat("##.##").format(a) + " KM.");
            }
            final String telpon = rs.getNoTelp();
            final Double lat = rs.getlatTujuan();
            final Double lon = rs.getlonTujuan();
            telepon.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:"+telpon.toString()));
                    startActivity(callIntent);
                }
            });
            arah.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE );
                    if ( !manager.isProviderEnabled( LocationManager.GPS_PROVIDER ) ) {
                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(tampilRS.this);
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
                            Toast.makeText(tampilRS.this, "Tidak ada koneksi internet!!", Toast.LENGTH_SHORT).show();
                        }else{
                            String url = "https://www.google.com/maps/dir/?api=1&destination=" + lat + "," + lon + "&travelmode=driving";
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                            startActivity(intent);
                        }
                    }
                }
            });
        }
        if(kirim.equals("RSKIA Permata Bunda")){
            rs.setDataRS(kirim);
            setTitle(rs.getNamaRs().toString());
            Resources res = getResources();
            String mDrawableName = rs.getImageRS();
            int resID = res.getIdentifier(mDrawableName , "drawable", getPackageName());
            Gambar.setImageResource(resID);
            Alamat.setText(rs.getAlamatRS());
            noTelp.setText(rs.getNoTelp());
            if((latNya == 0.0 || latNya == null) && (lonNya == 0.0 || lonNya == null) ){
                keterangan.setText(rs.getKetRS());
            }else{
                Double tujuanLat = (rs.getlatTujuan()*(3.14/180));
                Double tujuanLon = (rs.getlonTujuan()*(3.14/180));
                Double a = 2*6371*Math.asin(Math.sqrt((Math.pow(Math.sin((latNya*(3.14/180)-tujuanLat)/2),2))+Math.cos(latNya*(3.14/180))
                        *Math.cos(tujuanLat)*(Math.pow(Math.sin((tujuanLon-lonNya*(3.14/180))/2),2))));
                keterangan.setText("Dari hasil perhitungan jarak pada posisi kamu di titik latitude " + new DecimalFormat("##.####").format(latNya) +" dan longitude "
                        + new DecimalFormat("##.####").format(lonNya) +" ke " + rs.getNamaRs() + " didapatkan perkiraan jarak " + new DecimalFormat("##.##").format(a) + " KM.");
            }
            final String telpon = rs.getNoTelp();
            final Double lat = rs.getlatTujuan();
            final Double lon = rs.getlonTujuan();
            telepon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:"+telpon.toString()));
                    startActivity(callIntent);
                }
            });
            arah.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE );
                    if ( !manager.isProviderEnabled( LocationManager.GPS_PROVIDER ) ) {
                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(tampilRS.this);
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
                            Toast.makeText(tampilRS.this, "Tidak ada koneksi internet!!", Toast.LENGTH_SHORT).show();
                        }else{
                            String url = "https://www.google.com/maps/dir/?api=1&destination=" + lat + "," + lon + "&travelmode=driving";
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                            startActivity(intent);
                        }
                    }
                }
            });
        }
        if(kirim.equals("RSUD Kota Yogyakarta")){
            rs.setDataRS(kirim);
            setTitle(rs.getNamaRs().toString());
            Resources res = getResources();
            String mDrawableName = rs.getImageRS();
            int resID = res.getIdentifier(mDrawableName , "drawable", getPackageName());
            Gambar.setImageResource(resID);
            Alamat.setText(rs.getAlamatRS());
            noTelp.setText(rs.getNoTelp());
            if((latNya == 0.0 || latNya == null) && (lonNya == 0.0 || lonNya == null) ){
                keterangan.setText(rs.getKetRS());
            }else{
                Double tujuanLat = (rs.getlatTujuan()*(3.14/180));
                Double tujuanLon = (rs.getlonTujuan()*(3.14/180));
                Double a = 2*6371*Math.asin(Math.sqrt((Math.pow(Math.sin((latNya*(3.14/180)-tujuanLat)/2),2))+Math.cos(latNya*(3.14/180))
                        *Math.cos(tujuanLat)*(Math.pow(Math.sin((tujuanLon-lonNya*(3.14/180))/2),2))));
                keterangan.setText("Dari hasil perhitungan jarak pada posisi kamu di titik latitude " + new DecimalFormat("##.####").format(latNya) +" dan longitude "
                        + new DecimalFormat("##.####").format(lonNya) +" ke " + rs.getNamaRs() + " didapatkan perkiraan jarak " + new DecimalFormat("##.##").format(a) + " KM.");
            }
            final String telpon = rs.getNoTelp();
            final Double lat = rs.getlatTujuan();
            final Double lon = rs.getlonTujuan();
            telepon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:"+telpon.toString()));
                    startActivity(callIntent);
                }
            });
            arah.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE );
                    if ( !manager.isProviderEnabled( LocationManager.GPS_PROVIDER ) ) {
                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(tampilRS.this);
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
                            Toast.makeText(tampilRS.this, "Tidak ada koneksi internet!!", Toast.LENGTH_SHORT).show();
                        }else{
                            String url = "https://www.google.com/maps/dir/?api=1&destination=" + lat + "," + lon + "&travelmode=driving";
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                            startActivity(intent);
                        }
                    }
                }
            });
        }
        if(kirim.equals("RS Pratama Kota Yogyakarta")){
            rs.setDataRS(kirim);
            setTitle(rs.getNamaRs().toString());
            Resources res = getResources();
            String mDrawableName = rs.getImageRS();
            int resID = res.getIdentifier(mDrawableName , "drawable", getPackageName());
            Gambar.setImageResource(resID);
            Alamat.setText(rs.getAlamatRS());
            noTelp.setText(rs.getNoTelp());
            if((latNya == 0.0 || latNya == null) && (lonNya == 0.0 || lonNya == null) ){
                keterangan.setText(rs.getKetRS());
            }else{
                Double tujuanLat = (rs.getlatTujuan()*(3.14/180));
                Double tujuanLon = (rs.getlonTujuan()*(3.14/180));
                Double a = 2*6371*Math.asin(Math.sqrt((Math.pow(Math.sin((latNya*(3.14/180)-tujuanLat)/2),2))+Math.cos(latNya*(3.14/180))
                        *Math.cos(tujuanLat)*(Math.pow(Math.sin((tujuanLon-lonNya*(3.14/180))/2),2))));
                keterangan.setText("Dari hasil perhitungan jarak pada posisi kamu di titik latitude " + new DecimalFormat("##.####").format(latNya) +" dan longitude "
                        + new DecimalFormat("##.####").format(lonNya) +" ke " + rs.getNamaRs() + " didapatkan perkiraan jarak " + new DecimalFormat("##.##").format(a) + " KM.");
            }
            final String telpon = rs.getNoTelp();
            final Double lat = rs.getlatTujuan();
            final Double lon = rs.getlonTujuan();
            telepon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:"+telpon.toString()));
                    startActivity(callIntent);
                }
            });
            arah.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE );
                    if ( !manager.isProviderEnabled( LocationManager.GPS_PROVIDER ) ) {
                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(tampilRS.this);
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
                            Toast.makeText(tampilRS.this, "Tidak ada koneksi internet!!", Toast.LENGTH_SHORT).show();
                        }else{
                            String url = "https://www.google.com/maps/dir/?api=1&destination=" + lat + "," + lon + "&travelmode=driving";
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                            startActivity(intent);
                        }
                    }
                }
            });
        }
        if(kirim.equals("RS PKU Muhammadiyah")){
            rs.setDataRS(kirim);
            setTitle(rs.getNamaRs().toString());
            Resources res = getResources();
            String mDrawableName = rs.getImageRS();
            int resID = res.getIdentifier(mDrawableName , "drawable", getPackageName());
            Gambar.setImageResource(resID);
            Alamat.setText(rs.getAlamatRS());
            noTelp.setText(rs.getNoTelp());

            if((latNya == 0.0 || latNya == null) && (lonNya == 0.0 || lonNya == null) ){
                keterangan.setText(rs.getKetRS());
            }else{
                Double tujuanLat = (rs.getlatTujuan()*(3.14/180));
                Double tujuanLon = (rs.getlonTujuan()*(3.14/180));
                Double a = 2*6371*Math.asin(Math.sqrt((Math.pow(Math.sin((latNya*(3.14/180)-tujuanLat)/2),2))+Math.cos(latNya*(3.14/180))
                        *Math.cos(tujuanLat)*(Math.pow(Math.sin((tujuanLon-lonNya*(3.14/180))/2),2))));
                keterangan.setText("Dari hasil perhitungan jarak pada posisi kamu di titik latitude " + new DecimalFormat("##.####").format(latNya) +" dan longitude "
                        + new DecimalFormat("##.####").format(lonNya) +" ke " + rs.getNamaRs() + " didapatkan perkiraan jarak " + new DecimalFormat("##.##").format(a) + " KM.");
            }
            final String telpon = rs.getNoTelp();
            final Double lat = rs.getlatTujuan();
            final Double lon = rs.getlonTujuan();

            telepon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:"+telpon.toString()));
                    startActivity(callIntent);
                }
            });
            arah.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE );
                    if ( !manager.isProviderEnabled( LocationManager.GPS_PROVIDER ) ) {
                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(tampilRS.this);
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
                            Toast.makeText(tampilRS.this, "Tidak ada koneksi internet!!", Toast.LENGTH_SHORT).show();
                        }else{
                            String url = "https://www.google.com/maps/dir/?api=1&destination=" + lat + "," + lon + "&travelmode=driving";
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                            startActivity(intent);
                        }
                    }
                }
            });
        }
        if(kirim.equals("RSI Hidayatullah")){
            rs.setDataRS(kirim);
            setTitle(rs.getNamaRs().toString());
            Resources res = getResources();
            String mDrawableName = rs.getImageRS();
            int resID = res.getIdentifier(mDrawableName , "drawable", getPackageName());
            Gambar.setImageResource(resID);
            Alamat.setText(rs.getAlamatRS());
            noTelp.setText(rs.getNoTelp());

            if((latNya == 0.0 || latNya == null) && (lonNya == 0.0 || lonNya == null) ){
                keterangan.setText(rs.getKetRS());
            }else{
                Double tujuanLat = (rs.getlatTujuan()*(3.14/180));
                Double tujuanLon = (rs.getlonTujuan()*(3.14/180));
                Double a = 2*6371*Math.asin(Math.sqrt((Math.pow(Math.sin((latNya*(3.14/180)-tujuanLat)/2),2))+Math.cos(latNya*(3.14/180))
                        *Math.cos(tujuanLat)*(Math.pow(Math.sin((tujuanLon-lonNya*(3.14/180))/2),2))));
                keterangan.setText("Dari hasil perhitungan jarak pada posisi kamu di titik latitude " + new DecimalFormat("##.####").format(latNya) +" dan longitude "
                        + new DecimalFormat("##.####").format(lonNya) +" ke " + rs.getNamaRs() + " didapatkan perkiraan jarak " + new DecimalFormat("##.##").format(a) + " KM.");
            }
            final String telpon = rs.getNoTelp();
            final Double lat = rs.getlatTujuan();
            final Double lon = rs.getlonTujuan();
            telepon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:"+telpon.toString()));
                    startActivity(callIntent);
                }
            });
            arah.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE );
                    if ( !manager.isProviderEnabled( LocationManager.GPS_PROVIDER ) ) {
                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(tampilRS.this);
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
                            Toast.makeText(tampilRS.this, "Tidak ada koneksi internet!!", Toast.LENGTH_SHORT).show();
                        }else{
                            String url = "https://www.google.com/maps/dir/?api=1&destination=" + lat + "," + lon + "&travelmode=driving";
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                            startActivity(intent);
                        }
                    }
                }
            });
        }
        if(kirim.equals("Rumah Sakit Umum Veteran Patmasuri")){
            rs.setDataRS(kirim);
            setTitle(rs.getNamaRs().toString());
            Resources res = getResources();
            String mDrawableName = rs.getImageRS();
            int resID = res.getIdentifier(mDrawableName , "drawable", getPackageName());
            Gambar.setImageResource(resID);
            Alamat.setText(rs.getAlamatRS());
            noTelp.setText(rs.getNoTelp());
            if((latNya == 0.0 || latNya == null) && (lonNya == 0.0 || lonNya == null) ){
                keterangan.setText(rs.getKetRS());
            }else{
                Double tujuanLat = (rs.getlatTujuan()*(3.14/180));
                Double tujuanLon = (rs.getlonTujuan()*(3.14/180));
                Double a = 2*6371*Math.asin(Math.sqrt((Math.pow(Math.sin((latNya*(3.14/180)-tujuanLat)/2),2))+Math.cos(latNya*(3.14/180))
                        *Math.cos(tujuanLat)*(Math.pow(Math.sin((tujuanLon-lonNya*(3.14/180))/2),2))));
                keterangan.setText("Dari hasil perhitungan jarak pada posisi kamu di titik latitude " + new DecimalFormat("##.####").format(latNya) +" dan longitude "
                        + new DecimalFormat("##.####").format(lonNya) +" ke " + rs.getNamaRs() + " didapatkan perkiraan jarak " + new DecimalFormat("##.##").format(a) + " KM.");
            }
            final String telpon = rs.getNoTelp();
            final Double lat = rs.getlatTujuan();
            final Double lon = rs.getlonTujuan();
            telepon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:"+telpon.toString()));
                    startActivity(callIntent);
                }
            });
            arah.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE );
                    if ( !manager.isProviderEnabled( LocationManager.GPS_PROVIDER ) ) {
                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(tampilRS.this);
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
                            Toast.makeText(tampilRS.this, "Tidak ada koneksi internet!!", Toast.LENGTH_SHORT).show();
                        }else{
                            String url = "https://www.google.com/maps/dir/?api=1&destination=" + lat + "," + lon + "&travelmode=driving";
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                            startActivity(intent);
                        }
                    }
                }
            });
        }
        if(kirim.equals("Rumah Sakit Bethesda Yogyakarta")){
            rs.setDataRS(kirim);
            setTitle(rs.getNamaRs().toString());
            Resources res = getResources();
            String mDrawableName = rs.getImageRS();
            int resID = res.getIdentifier(mDrawableName , "drawable", getPackageName());
            Gambar.setImageResource(resID);
            Alamat.setText(rs.getAlamatRS());
            noTelp.setText(rs.getNoTelp());
            if((latNya == 0.0 || latNya == null) && (lonNya == 0.0 || lonNya == null) ){
                keterangan.setText(rs.getKetRS());
            }else{
                Double tujuanLat = (rs.getlatTujuan()*(3.14/180));
                Double tujuanLon = (rs.getlonTujuan()*(3.14/180));
                Double a = 2*6371*Math.asin(Math.sqrt((Math.pow(Math.sin((latNya*(3.14/180)-tujuanLat)/2),2))+Math.cos(latNya*(3.14/180))
                        *Math.cos(tujuanLat)*(Math.pow(Math.sin((tujuanLon-lonNya*(3.14/180))/2),2))));
                keterangan.setText("Dari hasil perhitungan jarak pada posisi kamu di titik latitude " + new DecimalFormat("##.####").format(latNya) +" dan longitude "
                        + new DecimalFormat("##.####").format(lonNya) +" ke " + rs.getNamaRs() + " didapatkan perkiraan jarak " + new DecimalFormat("##.##").format(a) + " KM.");
            }
            final String telpon = rs.getNoTelp();
            final Double lat = rs.getlatTujuan();
            final Double lon = rs.getlonTujuan();
            telepon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:"+telpon.toString()));
                    startActivity(callIntent);
                }
            });
            arah.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE );
                    if ( !manager.isProviderEnabled( LocationManager.GPS_PROVIDER ) ) {
                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(tampilRS.this);
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
                            Toast.makeText(tampilRS.this, "Tidak ada koneksi internet!!", Toast.LENGTH_SHORT).show();
                        }else{
                            String url = "https://www.google.com/maps/dir/?api=1&destination=" + lat + "," + lon + "&travelmode=driving";
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                            startActivity(intent);
                        }
                    }
                }
            });

        }
        if(kirim.equals("Rumah Sakit Mata Dr. Yap Yogyakarta")){
            rs.setDataRS(kirim);
            setTitle(rs.getNamaRs().toString());
            Resources res = getResources();
            String mDrawableName = rs.getImageRS();
            int resID = res.getIdentifier(mDrawableName , "drawable", getPackageName());
            Gambar.setImageResource(resID);
            Alamat.setText(rs.getAlamatRS());
            noTelp.setText(rs.getNoTelp());

            if((latNya == 0.0 || latNya == null) && (lonNya == 0.0 || lonNya == null) ){
                keterangan.setText(rs.getKetRS());
            }else{
                Double tujuanLat = (rs.getlatTujuan()*(3.14/180));
                Double tujuanLon = (rs.getlonTujuan()*(3.14/180));
                Double a = 2*6371*Math.asin(Math.sqrt((Math.pow(Math.sin((latNya*(3.14/180)-tujuanLat)/2),2))+Math.cos(latNya*(3.14/180))
                        *Math.cos(tujuanLat)*(Math.pow(Math.sin((tujuanLon-lonNya*(3.14/180))/2),2))));
                keterangan.setText("Dari hasil perhitungan jarak pada posisi kamu di titik latitude " + new DecimalFormat("##.####").format(latNya) +" dan longitude "
                        + new DecimalFormat("##.####").format(lonNya) +" ke " + rs.getNamaRs() + " didapatkan perkiraan jarak " + new DecimalFormat("##.##").format(a) + " KM.");
            }
            final String telpon = rs.getNoTelp();
            final Double lat = rs.getlatTujuan();
            final Double lon = rs.getlonTujuan();
            telepon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:"+telpon.toString()));
                    startActivity(callIntent);
                }
            });
            arah.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE );
                    if ( !manager.isProviderEnabled( LocationManager.GPS_PROVIDER ) ) {
                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(tampilRS.this);
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
                            Toast.makeText(tampilRS.this, "Tidak ada koneksi internet!!", Toast.LENGTH_SHORT).show();
                        }else{
                            String url = "https://www.google.com/maps/dir/?api=1&destination=" + lat + "," + lon + "&travelmode=driving";
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                            startActivity(intent);
                        }
                    }
                }
            });
        }
    }
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}