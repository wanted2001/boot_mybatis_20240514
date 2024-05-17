package com.ezen.www.domain;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BoardDTO {

    private BoardVO bvo;
    private List<FileVO> flist;


}
