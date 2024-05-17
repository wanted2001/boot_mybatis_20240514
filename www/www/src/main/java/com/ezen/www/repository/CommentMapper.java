package com.ezen.www.repository;

import com.ezen.www.domain.CommentVO;
import com.ezen.www.domain.PagingVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import javax.xml.stream.events.Comment;
import java.util.List;

@Mapper
public interface CommentMapper {
    int post(CommentVO cvo);

    int bnoToTotalCount(long bno);

    List<CommentVO> getList(@Param("bno") long bno, @Param("pgvo") PagingVO pgvo);

    int update(CommentVO cvo);

    int delete(long cno);
}
