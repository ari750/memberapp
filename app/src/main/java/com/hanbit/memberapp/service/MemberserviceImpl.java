package com.hanbit.memberapp.service;

import android.content.Context;
import android.util.Log;

import com.hanbit.memberapp.dao.MemberDAO;
import com.hanbit.memberapp.domain.MemberBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hb2012 on 2016-12-17.
 */
//Alt + Ins로 메소드 생성, DAO만 접속가능
public class MemberserviceImpl implements  MemberService{

    MemberDAO dao;
    public MemberserviceImpl(Context applicationContext) {
        dao = new MemberDAO(applicationContext); //에러발생 alt+enter 자동으로 MemberDAO에 생성자 생성
    }

    @Override
    public MemberBean detail(String id) {
        MemberBean member = new MemberBean();
        //DB에서 가져온 결과값
        member = dao.detail(id);
        Log.d("서비스 datil 결과 이름:", member.getName());
        return member;
    }

    @Override
    public List<MemberBean> find(String keyword) {
        List<MemberBean> list = new ArrayList<MemberBean>();
        list = dao.list();
        Log.d("리스트 갯수:", String.valueOf(list.size()));
        return list;
    }

    @Override
    public void join(MemberBean param) {
        Log.d("서비스 join에 넘어온 ID:", param.getId());
        dao.join(param);
    }

    @Override
    public List<MemberBean> list() {
        List<MemberBean> list = new ArrayList<MemberBean>();
        list = dao.list();
        Log.d("리스트 갯수:", String.valueOf(list.size()));
        return list;
    }

    @Override
    public boolean login(MemberBean param) {
        boolean flag =false;
        flag = dao.login(param);
        Log.d("로그인 결과:", String.valueOf(flag));
        return flag;
    }
    오후 4:19:24 Executing tasks: [:app:assembleDebug]

    @Override
    public void update(MemberBean param) {
        Log.d("서비스로 넘어온 id:",param.getId());
        dao.update(param);
    }

    @Override
    public void delete(String id) {
        Log.d("서비스로 넘어온 id:",id);
        dao.delete(id);

    }

    @Override
    public int count() {
        int count = 0;
        count = dao.count();
        Log.d("서비스 count:",String.valueOf(count));
        return count;
    }
}
