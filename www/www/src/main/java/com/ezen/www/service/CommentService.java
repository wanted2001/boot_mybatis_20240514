package com.ezen.www.service;

import com.ezen.www.domain.CommentVO;
import com.ezen.www.domain.PagingVO;
import com.ezen.www.handler.PagingHandler;

import javax.xml.stream.events.Comment;

public interface CommentService {
    int post(CommentVO cvo);

    PagingHandler getList(long bno, PagingVO pgvo);

    int update(CommentVO cvo);

    int delete(long cno);
}
