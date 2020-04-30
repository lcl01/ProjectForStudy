package com.health.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.health.dao.MemberDao;
import com.health.pojo.Member;
import com.health.service.MemberService;
import com.health.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service(interfaceClass = MemberService.class)
@Transactional
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberDao memberDao;
    @Override
    public Member findByTelephone(String telephone) {

        return memberDao.findByTelephone(telephone);
    }

    @Override
    public void add(Member member) {
        if (member.getPassword()!=null) {
            member.setPassword(MD5Utils.md5(member.getPassword()));
        }
        memberDao.add(member);
    }

    @Override
    public List<Integer> findMemberCountByMonth(List<String> month) {
        List<Integer> list = new ArrayList<>();
        for (String m : month) {
            m=m+".31";//格式：2019.04.31
            Integer count = memberDao.findMemberCountBeforeDate(m);
            list.add(count);
        }
        return list;
    }
}
