package com.example.pmob;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.pmob.R;
public class HasilActivity extends AppCompatActivity {
    String list_rs[] = new String[] {"RSKIA PKU Muhammadiyah","RSKIA Permata Bunda","RSUD Kota Yogyakarta", "RS Pratama Kota Yogyakarta", "RS PKU Muhammadiyah", "RSI Hidayatullah",
            "Rumah Sakit Umum Veteran Patmasuri", "Rumah Sakit Bethesda Yogyakarta", "Rumah Sakit Mata Dr. Yap Yogyakarta"};
    String KEY_NAME = "idRS";
    String kirim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle(R.string.halamanHasil);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        ListView list_view = findViewById(R.id.listview);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,list_rs);
        list_view.setAdapter(adapter);
        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                kirim = list_rs[position];
                if (kirim == "RSKIA PKU Muhammadiyah"){
                    Intent intent = new Intent(HasilActivity.this, tampilRS.class);
                    intent.putExtra(KEY_NAME, kirim);
                    startActivity(intent);
                }
                if (kirim == "RSKIA Permata Bunda"){
                    Intent intent = new Intent(HasilActivity.this, tampilRS.class);
                    intent.putExtra(KEY_NAME, kirim);
                    startActivity(intent);
                }

                if (kirim == "RSUD Kota Yogyakarta"){
                    Intent intent = new Intent(HasilActivity.this, tampilRS.class);
                    intent.putExtra(KEY_NAME, kirim);
                    startActivity(intent);
                }

                if (kirim == "RS Pratama Kota Yogyakarta"){
                    Intent intent = new Intent(HasilActivity.this, tampilRS.class);
                    intent.putExtra(KEY_NAME, kirim);
                    startActivity(intent);
                }

                if (kirim == "RS PKU Muhammadiyah"){
                    Intent intent = new Intent(HasilActivity.this, tampilRS.class);
                    intent.putExtra(KEY_NAME, kirim);
                    startActivity(intent);
                }

                if (kirim == "RSI Hidayatullah"){
                    Intent intent = new Intent(HasilActivity.this, tampilRS.class);
                    intent.putExtra(KEY_NAME, kirim);
                    startActivity(intent);
                }

                if (kirim == "Rumah Sakit Umum Veteran Patmasuri"){
                    Intent intent = new Intent(HasilActivity.this, tampilRS.class);
                    intent.putExtra(KEY_NAME, kirim);
                    startActivity(intent);
                }

                if (kirim == "Rumah Sakit Bethesda Yogyakarta"){
                    Intent intent = new Intent(HasilActivity.this, tampilRS.class);
                    intent.putExtra(KEY_NAME, kirim);
                    startActivity(intent);
                }

                if (kirim == "Rumah Sakit Mata Dr. Yap Yogyakarta"){
                    Intent intent = new Intent(HasilActivity.this, tampilRS.class);
                    intent.putExtra(KEY_NAME, kirim);
                    startActivity(intent);
                }
            }
        });
            }
}