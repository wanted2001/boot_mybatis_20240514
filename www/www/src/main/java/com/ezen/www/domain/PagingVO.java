package com.ezen.www.domain;

import com.ezen.www.handler.PagingHandler;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class PagingVO {

    private int pageNo;
    private int qty;
    private String type;
    private String keyword;

    public PagingVO(){
        this.pageNo = 1;
        this.qty = 10;
    }

    public PagingVO(int pageNo,int qty){
        this.pageNo = pageNo;
        this.qty = qty;
    }

    public  int getPageStart(){
        return (pageNo -1)*qty; //DB 의 limit 앞의 값을 설정
    }

    public String[] getTypeToArray(){
        return this.type == null ? new String[]{} : this.type.split("");
    }
}
