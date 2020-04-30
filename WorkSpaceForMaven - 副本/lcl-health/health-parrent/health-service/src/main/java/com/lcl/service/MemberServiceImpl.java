package com.lcl.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.lcl.dao.MemberDao;
import com.lcl.pojo.Member;
import com.lcl.utils.MD5Utils;
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
        if(member.getPassword() != null && !"".equals(member.getPassword())){
            member.setPassword(MD5Utils.md5(member.getPassword()));
        }
        memberDao.add(member);
    }

    @Override
    public List<Integer> findMemberCountByMonth(List<String> month) {
        List <Integer> list = new ArrayList <>();
        for (String m : month) {
            m=m+"-31";
            Integer count = memberDao.findMemberCountBeforeDate(m);
            list.add(count);
        }

        return list;
    }
}
