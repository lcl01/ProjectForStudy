package com.lcl.service;

import com.lcl.pojo.Member;

import java.util.List;

public interface MemberService {
    public Member findByTelephone(String telephone);
    public void add(Member member);

    List<Integer> findMemberCountByMonth(List<String> month);
}
