package com.green.boardver2.board;

import com.green.boardver2.board.model.BoardGetRes;
import com.green.boardver2.board.model.BoardPostReq;
import com.green.boardver2.board.model.BoardPutReq;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {
    int postBoard(BoardPostReq p);

    BoardGetRes getBoard(int boardId);
    int deleteBoard(int p);
    int putUpdate(BoardPutReq p);
}
