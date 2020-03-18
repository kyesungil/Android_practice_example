package com.example.intenttest01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static com.example.intenttest01.MainActivity.MESAGGE;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mResultMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mResultMessage = findViewById(R.id.ResultMessage);

        /** getIntent Intent객체 받기**/
        Intent intent = getIntent();
        String message = intent.getStringExtra(MESAGGE);

        mResultMessage.setText("Message : " + message);

        findViewById(R.id.return_btn).setOnClickListener(this);

    }

    /** setResult 다시 되돌려 주기 **/
    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.putExtra("result",mResultMessage.getText().toString());

        setResult(RESULT_OK,intent);
        finish();
    }
}
