package com.example.pmob;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class SelamatDatang extends AppCompatActivity {
    Button mulai;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selamatdatang);
        mulai = (Button) findViewById(R.id.mulai);
        mulai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SelamatDatang.this, MainActivity.class);
                startActivity(intent);
            }
        });
        Log.v("SelamatDatang", "Kita berada di tampilan selamat datang");
    }
}
