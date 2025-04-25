package com.example.mycalc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button myButton = findViewById(R.id.buton2);
        EditText fioText = findViewById(R.id.fio);
        EditText groupText = findViewById(R.id.grupa);
        EditText ageText = findViewById(R.id.age);
        EditText resText = findViewById(R.id.res);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fio = fioText.getText().toString();
                String group = groupText.getText().toString();
                int age = 0, res = 0;

                try {
                    age = Integer.parseInt(ageText.getText().toString());
                    res = Integer.parseInt(resText.getText().toString());
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Введите корректные значения", Toast.LENGTH_SHORT).show();
                    return;
                }

                Toast.makeText(getApplicationContext(), "Вы нажали на розовый", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("fio", fio);
                intent.putExtra("group", group);
                intent.putExtra("age", age);
                intent.putExtra("res", res);
                startActivity(intent);
            }
        });
    }

    public void nextActivity(View view) {
        Toast.makeText(this, "Вы нажали на голубой", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
}
