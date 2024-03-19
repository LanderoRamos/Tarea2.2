package com.example.tarea2p2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BOTONES();

        TextView textView3 = (TextView) findViewById(R.id.textView3);
        textView3.setText("Integrantes del grupo: \n" +
                "- Esdras Abiel Clother Paz (202010010048)\n" +
                "- Eber Orestes González Garcia (201810030032)\n" +
                "- Bayardo Antonio Ponce Ruiz (202110110125)\n" +
                "- Jafeth Donatilo Rápalo Rivera (202120030040)\n" +
                "- Dennis Antonio Landero Ramos (202120030040)\n" +
                "- Delcer Oviel Hernandez (201510050050)");

    }

    private void BOTONES() {
        Button button = (Button) findViewById(R.id.button);
        Button button2 = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivityPlaceHolder.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivityPlaceHolderBuscar.class);
                startActivity(intent);
            }
        });
    }
}