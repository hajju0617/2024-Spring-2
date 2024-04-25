package com.green.boardver2.board;

import com.green.boardver2.board.model.BoardGetRes;
import com.green.boardver2.board.model.BoardPostReq;
import com.green.boardver2.board.model.BoardPutReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
    public int deleteBoard(int boardId) {
        return mapper.deleteBoard(boardId);
    }

    public int putUpdate(BoardPutReq p) {
        return mapper.putUpdate(p);
    }
}
