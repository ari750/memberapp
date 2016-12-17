package com.hanbit.memberapp.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.hanbit.memberapp.R;
import com.hanbit.memberapp.domain.MemberBean;
import com.hanbit.memberapp.service.MemberService;
import com.hanbit.memberapp.service.MemberserviceImpl;

import java.util.List;

public class ListActivity extends AppCompatActivity implements View.OnClickListener {

    Button btDetail, btFind;
    MemberService service;
    MemberBean member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        btDetail = (Button) findViewById(R.id.btDetail);
        btFind = (Button) findViewById(R.id.btFind);
        btDetail.setOnClickListener(this);
        btFind.setOnClickListener(this);

        service = new MemberserviceImpl(getApplicationContext());
        List<MemberBean>list = service.list();
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.btDetail:
                Toast.makeText(ListActivity.this,"Click Detail", Toast.LENGTH_LONG).show();
                this.startActivity(new Intent(ListActivity.this, DetailActivity.class));
                break;

            case R.id.btFind:
                Toast.makeText(ListActivity.this,"Click Find", Toast.LENGTH_LONG).show();
                this.startActivity(new Intent(ListActivity.this, FindActivity.class));
                break;
        }
    }

}
