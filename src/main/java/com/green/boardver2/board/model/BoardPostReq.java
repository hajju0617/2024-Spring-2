package com.green.boardver2.board.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Setter
@Getter
public class BoardPostReq {
    private String title;
    private String contents;
    private long writerId;
}
