package com.green.boardver2.board.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BoardPutReq {
    private int boardId;
    private String title;
    private String contents;
}
