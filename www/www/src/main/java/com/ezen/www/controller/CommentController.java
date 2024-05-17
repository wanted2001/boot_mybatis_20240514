package com.ezen.www.controller;

import com.ezen.www.domain.CommentVO;
import com.ezen.www.domain.PagingVO;
import com.ezen.www.handler.PagingHandler;
import com.ezen.www.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.xml.stream.events.Comment;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/comment/*")
public class CommentController {

    private final CommentService csv;

    @PostMapping("/post")
    @ResponseBody
    public String post(@RequestBody CommentVO cvo) {
        log.info("cvo >> {}",cvo);
        int isOk = csv.post(cvo);
        return  isOk > 0 ? "1" : "0";

    }

    @GetMapping("/list/{bno}/{page}")
    @ResponseBody
    public PagingHandler list(@PathVariable("bno")long bno,@PathVariable("page")int page){
        PagingVO pgvo = new PagingVO(page, 5);
        PagingHandler ph = csv.getList(bno, pgvo);
        return ph;
    }
    /* select * from comment order by cno desc limit 0,5*/
    
    /* ***************
    *  RequestBody : 내가 버튼을 눌렀을때(클라이언트)가 Controller(서버)로 보내져 오는 바디
    *  ResponseBody : 내가 Controller(서버)에 보낸 값이 맞는지 아닌지 버튼(클라이언트)으로 돌아가서 작업을 수행
    * */
    @PutMapping("/update")
    @ResponseBody
    public String update(@RequestBody CommentVO cvo){
        log.info(">>> {}",cvo);
        int isOk = csv.update(cvo);
        return  isOk > 0 ? "1" : "0";
    }

    @DeleteMapping("/delete/{cno}")
    @ResponseBody
    public String delete(@PathVariable("cno") long cno){
        int isOk = csv.delete(cno);
        return isOk > 0 ? "1" : "0";
    }

}
