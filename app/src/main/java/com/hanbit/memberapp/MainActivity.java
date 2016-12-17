package com.hanbit.memberapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.hanbit.memberapp.controller.JoinActivity;
import com.hanbit.memberapp.controller.LoginActivity;

//implements로 기능을 구현한다.  View.OnClickListener 뒤에 Alt+ Insert로 이벤트(onClick)메서드 만들기
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //변수 선언
    Button btJoin,btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Alt+ enter + enter java: Button btJoin = new Button();
        //instance화 시킨다.
        btJoin  = (Button) findViewById(R.id.btJoin);
        btLogin = (Button) findViewById(R.id.btLogin);

        //Button instance에 Click Event set
        btJoin.setOnClickListener(this);
        btLogin.setOnClickListener(this);

    }

    @Override
    //Alt+ Insert로 메소드 만들기 View.OnClickListener뒤에서 Alt+ Ins
    public void onClick(View v) {



        switch(v.getId()){
            //activity_join.xml로 넘기기
            case R.id.btJoin:
                Toast.makeText(MainActivity.this,"Click Join", Toast.LENGTH_LONG).show();
                //Intent intent = new Intent(MainActivity.this, JoinActivity.class);  // from A to B
                //this.startActivity(intent);
                this.startActivity(new Intent(MainActivity.this, JoinActivity.class));

                break;
            //activity_login.xml로 넘기기
            case R.id.btLogin:
                Toast.makeText(MainActivity.this,"Click Login", Toast.LENGTH_LONG).show();
                //Intent intent2 = new Intent(MainActivity.this, LoginActivity.class);
                //this.startActivity(intent2);
                this.startActivity(new Intent(MainActivity.this, LoginActivity.class));
                break;
        }
    }

}
