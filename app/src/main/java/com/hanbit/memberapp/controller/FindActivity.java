package com.hanbit.memberapp.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hanbit.memberapp.R;

public class FindActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etSearch;
    Button btSearch, btCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);

        etSearch     = (EditText) findViewById(R.id.etSearch);
        btSearch = (Button) findViewById(R.id.btSearch);
        btCancel = (Button) findViewById(R.id.btCancel);

        btSearch.setOnClickListener(this);
        btCancel.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.btSearch:
                Toast.makeText(FindActivity.this,"Click Search", Toast.LENGTH_LONG).show();
                this.startActivity(new Intent(FindActivity.this, ListActivity.class));
                break;
            case R.id.btCancel:
                Toast.makeText(FindActivity.this,"Click Cancel", Toast.LENGTH_LONG).show();
                this.startActivity(new Intent(FindActivity.this, ListActivity.class));
                break;
        }

    }
}
