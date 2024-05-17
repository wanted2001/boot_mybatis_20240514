package com.ezen.www.domain;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CommentVO {

    private int cno;
    private int bno;
    private String writer;
    private String content;
    private String regAt;
    private String modAt;

}
