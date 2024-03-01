package com.example.latihan_1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText vallEditText;
    private EditText val2EditText;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vallEditText = findViewById(R.id.vall);
        val2EditText = findViewById(R.id.val2);
        resultTextView = findViewById(R.id.textViewResult);

        Button multiplyButton = findViewById(R.id.kali);
        Button divideButton = findViewById(R.id.bagi);
        Button subtractButton = findViewById(R.id.kurang);
        Button addButton = findViewById(R.id.tmbh);

        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('*');
                    showToast("Perkalian Berhasil");
            }
        });

        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('/');
                showToast("Pembagian berhasil");
            }
        });

        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('-');
                showToast("Pengurangan Berhasil");
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('+');
                showToast("Penjumlahan Berhasil");
            }
        });
    }

    private void calculate(char operator) {
        String value1String = vallEditText.getText().toString();
        String value2String = val2EditText.getText().toString();

        if (value1String.isEmpty() || value2String.isEmpty()) {
            showToast("Masukkan kedua nilai");
            return;
        }

        double value1;
        double value2;

        try {
            value1 = Double.parseDouble(value1String);
            value2 = Double.parseDouble(value2String);
        } catch (NumberFormatException e) {
            showToast("Input Angka Yang benar");
            return;
        }

        double result = 0;

        switch (operator) {
            case '*':
                result = value1 * value2;
                break;
            case '/':
                if (value2 == 0) {
                    showToast("Masukan Angka Selain 0");
                    return;
                }
                result = value1 / value2;
                break;
            case '-':
                result = value1 - value2;
                break;
            case '+':
                result = value1 + value2;
                break;
        }

        resultTextView.setText(String.valueOf(result));
    }

    private void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
