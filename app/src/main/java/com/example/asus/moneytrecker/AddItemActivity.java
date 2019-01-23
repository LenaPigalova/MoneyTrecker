package com.example.asus.moneytrecker;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddItemActivity extends AppCompatActivity {

    private EditText nameEditText;
    private EditText priceEditText;
    private Button addButton;
    private TextView textViewRub;
    private int colorEn;
    private int colorDis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        nameEditText = (EditText)findViewById(R.id.name_edit_text);
        priceEditText = (EditText)findViewById(R.id.price_edit_text);
        addButton = (Button)findViewById(R.id.add_btn);
        textViewRub = (TextView)findViewById(R.id.rub);
        colorEn = ContextCompat.getColor(getApplicationContext(), R.color.blackColor);
        colorDis = ContextCompat.getColor(getApplicationContext(), R.color.grayColor);

        nameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!TextUtils.isEmpty(s) && !TextUtils.isEmpty(priceEditText.getText())) {
                    addButton.setEnabled(!TextUtils.isEmpty(s));

                } else {
                    addButton.setEnabled(false);
                }
            }
        });

        priceEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(!TextUtils.isEmpty(s)){
                    textViewRub.setTextColor(colorEn);
                }
                else {
                    textViewRub.setTextColor(colorDis);
                }
                if (!TextUtils.isEmpty(s) && !TextUtils.isEmpty(nameEditText.getText())) {
                    addButton.setEnabled(!TextUtils.isEmpty(s));
                }
                else {
                    addButton.setEnabled(false);
                }

            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                String price = priceEditText.getText().toString();
            }
        });
    }
}
