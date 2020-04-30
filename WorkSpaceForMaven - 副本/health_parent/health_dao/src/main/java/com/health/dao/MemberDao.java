package com.health.dao;

import com.health.pojo.Member;
import com.github.pagehelper.Page;

import java.util.List;

public interface MemberDao {
    Member findByTelephone(String telephone);

    void add(Member member);

    public List<Member> findAll();

    public Page<Member> selectByCondition(String queryString);

    public void deleteById(Integer id);

    public Member findById(Integer id);
    public void edit(Member member);
    public Integer findMemberCountBeforeDate(String date);
    public Integer findMemberCountByDate(String date);
    public Integer findMemberCountAfterDate(String date);
    public Integer findMemberTotalCount();
}
