package com.green.boardver2.board;

import com.green.boardver2.board.model.*;
import org.apache.ibatis.annotations.Mapper;
import java.util.*;

@Mapper
public interface BoardMapper {
    int postBoard(BoardPostReq p);

    BoardGetRes getBoard(int boardId);
    int deleteBoard(int p);
    int putUpdate(BoardPutReq p);

    BoardDetailGetRes getBoardOne(long boardId);

    List<BoardGetRes> getBoardList(BoardGetReq p);

    int patchBoardHits(long boardId);
}
