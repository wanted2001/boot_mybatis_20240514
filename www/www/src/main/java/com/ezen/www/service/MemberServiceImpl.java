package com.ezen.www.service;


import com.ezen.www.domain.AuthVO;
import com.ezen.www.domain.MemberVO;
import com.ezen.www.repository.MemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
    private final MemberMapper memberMapper;

    @Override
    public int insert(MemberVO mvo) {
        int isOk = memberMapper.insert(mvo);

        return (isOk > 0 ? memberMapper.insertAuth(mvo.getEmail()) : 0);
    }

    @Override
    public List<MemberVO> getList() {
        List<MemberVO> mList = memberMapper.getMlist();
        for(MemberVO memberVO : mList){
            memberVO.setAuthList(memberMapper.selectAuths(memberVO.getEmail()));
        }
        return mList;
    }

    @Override
    public void updateNick(MemberVO mvo) {
        memberMapper.updateNick(mvo);
    }

    @Override
    public void updateWithPwd(MemberVO mvo) {
        memberMapper.updateWithPwd(mvo);
    }
}
