package com.example.intenttest01;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String MESAGGE = "MESAGGE";
    public static final int REQUEST_CODE = 100;
    private EditText mMessageEditText;
        private TextView mResultText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMessageEditText = findViewById(R.id.message_edit_text);
        mResultText = findViewById(R.id.result_text);

        findViewById(R.id.message_send_btn).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this,SecondActivity.class);
        intent.putExtra(MESAGGE,mMessageEditText.getText().toString());
        
        startActivityForResult(intent, REQUEST_CODE);
    }

    /** setResult로 부터 데이터 받는다. **/
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            String result =data.getStringExtra("result");
            Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
        }
    }
}
