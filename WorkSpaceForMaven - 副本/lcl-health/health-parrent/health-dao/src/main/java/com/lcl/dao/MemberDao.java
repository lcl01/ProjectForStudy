package com.lcl.dao;

import com.github.pagehelper.Page;
import com.lcl.pojo.Member;

import java.util.List;

public interface MemberDao {
    Member findByTelephone(String telephone);

    void add(Member member);
    public List<Member> findAll();
    public Page<Member> selectByCondition(String queryString);
    public void deleteById(Integer id);
    public Member findById(Integer id);
//    public Member findByTelephone(String telephone);
    public void edit(Member member);
    public Integer findMemberCountBeforeDate(String date);
    public Integer findMemberCountByDate(String date);
    public Integer findMemberCountAfterDate(String date);
    public Integer findMemberTotalCount();
}
