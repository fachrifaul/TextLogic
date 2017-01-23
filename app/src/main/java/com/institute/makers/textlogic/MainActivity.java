package com.institute.makers.textlogic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText inputTextView;
    TextView resultTextView;
    String inputString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputTextView = (EditText) findViewById(R.id.inputTextView);
        resultTextView = (TextView) findViewById(R.id.resultTextView);
    }

    public void reverseString(View view) {
        inputString = inputTextView.getText().toString();

        String result = "";
        int len = inputString.length();

        for (int i = len - 1; i >= 0; i--) {
            result = result + inputString.charAt(i);
        }

        resultTextView.setText("Result : " + result);
    }

    public void checkPalindrom(View view) {
        inputString = inputTextView.getText().toString();

        boolean isPalindrom = true;

        int len = inputString.length();

        int first = 0;
        int last = len - 1;

        while (isPalindrom && first < len / 2) {
            if (inputString.charAt(first) != inputString.charAt(last)) {
                isPalindrom = false;
            } else {
                first++;
                last--;
            }
        }

        if (isPalindrom) {
            resultTextView.setText("Result : Your input is palindrom");
        } else {
            resultTextView.setText("Result : Your input is NOT palindrom");
        }
    }

    public void disemvoweler(View view) {
        inputString = inputTextView.getText().toString();

        int len = inputString.length();
        String consonant = "";
        String vocal = "";

        for (int i = 0; i < len; i++) {
            char huruf = inputString.charAt(i);
            if (huruf != ' ') {
                if (huruf == 'a' || huruf == 'i' ||
                    huruf == 'u' || huruf == 'e' ||
                    huruf == 'o') {
                    vocal = vocal + huruf;
                } else {
                    consonant = consonant + huruf;
                }
            }
        }

        resultTextView.setText("Result : " + consonant + " " + vocal);

    }

    public void reset(View view) {
        inputTextView.setText("");
        resultTextView.setText("Result : ");
    }
}
