package com.hanbit.memberapp.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hanbit.memberapp.R;

public class UpdateActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etName,etID,etPass,etTel,etAddr;
    Button btSubmit, btCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);
        etName   = (EditText) findViewById(R.id.etName);
        etID     = (EditText) findViewById(R.id.etID);
        etPass   = (EditText) findViewById(R.id.etPass);
        etTel    = (EditText) findViewById(R.id.etTel);
        etAddr   = (EditText) findViewById(R.id.etAddr);
        btSubmit = (Button) findViewById(R.id.btSubmit);
        btCancel = (Button) findViewById(R.id.btCancel);

        btSubmit.setOnClickListener(this);
        btCancel.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        String id   = etID.getText().toString();
        String pass = etPass.getText().toString();
        String name = etName.getText().toString();
        String tel  = etTel.getText().toString();
        String addr = etAddr.getText().toString();

        switch(v.getId()){
            case R.id.btSubmit:
                Toast.makeText(UpdateActivity.this,"Click Submit", Toast.LENGTH_LONG).show();
                this.startActivity(new Intent(UpdateActivity.this, ListActivity.class));
                break;
            case R.id.btCancel:
                Toast.makeText(UpdateActivity.this,"Click Submit", Toast.LENGTH_LONG).show();
                this.startActivity(new Intent(UpdateActivity.this, ListActivity.class));
                break;
        }
    }

}
