package com.hanbit.memberapp.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hanbit.memberapp.MainActivity;
import com.hanbit.memberapp.R;
import com.hanbit.memberapp.domain.MemberBean;
import com.hanbit.memberapp.service.MemberService;
import com.hanbit.memberapp.service.MemberserviceImpl;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener  {

    EditText etID, etPass;
    Button btSubmit, btCancel;
    //activity를 servcie로 연결 인터페이스로 타입결정
    MemberService service;
    MemberBean member;

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
        //가상의 객체 생성 - 에러발생 Alt+enter으로 자동생성
        service = new MemberserviceImpl(this.getApplicationContext());
        member = new MemberBean();
    }

    @Override
    public void onClick(View v) {

        String id = etID.getText().toString();
        String pass = etPass.getText().toString();
        Log.d("넘어온 ID:",id);
        Log.d("넘어온 Pass:",pass);
        member.setId(id);
        member.setPass(pass);

        switch(v.getId()){
            case R.id.btSubmit:

                boolean flag = service.login(member);
                if(flag){
                    Toast.makeText(LoginActivity.this,"SUCCESS", Toast.LENGTH_LONG).show();
                    this.startActivity(new Intent(LoginActivity.this, ListActivity.class));
                }else{
                    Toast.makeText(LoginActivity.this,"FAIL", Toast.LENGTH_LONG).show();
                    //this.startActivity(new Intent(LoginActivity.this, MainActivity.class));
                }
                break;
            case R.id.btCancel:
                Toast.makeText(LoginActivity.this,"Click Cancel", Toast.LENGTH_LONG).show();
                this.startActivity(new Intent(LoginActivity.this, MainActivity.class));
                break;
        }

    }
}
