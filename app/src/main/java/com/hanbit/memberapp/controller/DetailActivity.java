package com.hanbit.memberapp.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hanbit.memberapp.R;
import com.hanbit.memberapp.domain.MemberBean;
import com.hanbit.memberapp.service.MemberService;
import com.hanbit.memberapp.service.MemberserviceImpl;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvID,tvName,tvPass,tvTel,tvAddr;
    Button btCall,btMap,btMessage,btUpdate,btDelete,btList;
    MemberService service;
    MemberBean member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        service = new MemberserviceImpl(this.getApplicationContext());
        member = service.detail("hong");

        tvID     = (TextView) findViewById(R.id.tvID);
        tvName   = (TextView) findViewById(R.id.tvName);
        tvPass   = (TextView) findViewById(R.id.etPass);
        tvTel    = (TextView) findViewById(R.id.etTel);
        tvAddr   = (TextView) findViewById(R.id.etAddr);

        //리스트화면에 바로 출력
        tvID.setText(member.getId());
        tvName.setText(member.getName());
        tvPass.setText(member.getPass());
        tvTel.setText(member.getPhone());
        tvAddr.setText(member.getAddr());

        btCall = (Button) findViewById(R.id.btCall);
        btMap = (Button) findViewById(R.id.btMap);
        btMessage = (Button) findViewById(R.id.btMessage);
        btUpdate = (Button) findViewById(R.id.btUpdate);
        btDelete = (Button) findViewById(R.id.btDelete);
        btList = (Button) findViewById(R.id.btList);

        btCall.setOnClickListener(this);
        btMap.setOnClickListener(this);
        btMessage.setOnClickListener(this);
        btUpdate.setOnClickListener(this);
        btDelete.setOnClickListener(this);
        btList.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btCall:break;
            case R.id.btMap:break;
            case R.id.btMessage:
                break;
            case R.id.btUpdate:
                startActivity(new Intent(DetailActivity.this, UpdateActivity.class));
                break;
            case R.id.btDelete:
                service.delete(tvID.getText().toString());
                startActivity(new Intent(DetailActivity.this, ListActivity.class));
                break;
            case R.id.btList:break;
        }
    }
}
