package com.green.boardver2.board.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.beans.ConstructorProperties;

@Setter
@Getter
@ToString
public class BoardGetReq {
    private int page;   // 페이지 값
    private int size = 10;   // 페이지 당 레코드 수

    @JsonIgnore
    private int startIdx;
    @JsonIgnore
    private int len;

//    @ConstructorProperties({"page", "size"})
//    public BoardGetReq(int page, int size) {
//        this.page = page;
//        this.size = size;
//        if(this.page == 0) {
//            this.page = 1;
//        }
//        if(this.size == 0) {
//            this.size = 10;
//        }
//        this.startIdx = (this.page - 1) * this.size;
//        this.len = this.size;
//    }
}
