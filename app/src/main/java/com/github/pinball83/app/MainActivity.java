package com.github.pinball83.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.github.pinball83.maskededittext.MaskedEditText;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = this.findViewById(R.id.textView);
        final TextView textView1 = this.findViewById(R.id.textView2);

        final MaskedEditText maskedEditText = this.findViewById(R.id.masked);
        maskedEditText.setIconCallback(unmaskedText -> {
            Log.d(TAG, "onIconPushed: " + unmaskedText);
            textView.setText(unmaskedText);
            textView1.setText(maskedEditText.getText());
            maskedEditText.setMaskedTextWithIgnore("+71234567890");
        });

        final MaskedEditText maskedEditText2 = this.findViewById(R.id.masked3);
        maskedEditText2.setMaskAndNotMaskedSymbolWithIgnore("+7(***) ***-**-**"
                , "*"
                , new ArrayList<>(Arrays.asList('(', ')', ' ', '-')));

        final EditText editText = this.findViewById(R.id.editText);
        final Button button = this.findViewById(R.id.toEditText);

        button.setOnClickListener(v -> maskedEditText2.setMaskedTextWithIgnore(editText.getText().toString()));

        final MaskedEditText maskedEditText3 = this.findViewById(R.id.masked4);
        final Button button1 = this.findViewById(R.id.toMaskedEditText);
        final EditText editText1 = this.findViewById(R.id.editText1);
        button1.setOnClickListener(v -> maskedEditText3.setNotMaskedSymbol(editText1.getText().toString()));
    }
}
