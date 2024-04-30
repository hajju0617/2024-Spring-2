package com.green.boardver2.board;

import com.green.boardver2.board.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardMapper mapper;

    public int postBoard(BoardPostReq p) {
        return mapper.postBoard(p);
    }
    public BoardGetRes getBoard(int boardId) {
        return mapper.getBoard(boardId);
    }
    public int deleteBoard(long boardId) {
        return mapper.deleteBoard(boardId);
    }

    public int putBoard(BoardPutReq p) {
        return mapper.putBoard(p);
    }
    public BoardDetailGetRes getBoardOne(long boardId) {
        BoardDetailGetRes result = mapper.getBoardOne(boardId);
        if(result != null) {
            // Record 가 있다면 조회수 +1
            mapper.patchBoardHits(boardId);
        }
        return result;
    }
    public List<BoardGetRes> getBoardList(BoardGetReq p) {
        return mapper.getBoardList(p);
    }

}
