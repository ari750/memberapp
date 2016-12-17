package com.hanbit.memberapp.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hanbit.memberapp.MainActivity;
import com.hanbit.memberapp.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener  {

    EditText etID, etPass;
    Button btSubmit, btCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etID      = (EditText) findViewById(R.id.etID);
        etPass    = (EditText) findViewById(R.id.etPass);
        btSubmit  = (Button) findViewById(R.id.btSubmit);
        btCancel  = (Button) findViewById(R.id.btCancel);

        btSubmit.setOnClickListener(this);
        btCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String id = etID.getText().toString();
        String pass = etPass.getText().toString();

        switch(v.getId()){
            case R.id.btSubmit:
                Toast.makeText(LoginActivity.this,"Click Submit", Toast.LENGTH_LONG).show();
                this.startActivity(new Intent(LoginActivity.this, ListActivity.class));
                break;
            case R.id.btCancel:
                Toast.makeText(LoginActivity.this,"Click Cancel", Toast.LENGTH_LONG).show();
                this.startActivity(new Intent(LoginActivity.this, MainActivity.class));
                break;
        }

    }
}
