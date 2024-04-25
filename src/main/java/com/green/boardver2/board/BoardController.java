package com.green.boardver2.board;

import com.green.boardver2.board.model.BoardGetRes;
import com.green.boardver2.board.model.BoardPostReq;
import com.green.boardver2.common.ResultDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService service;

    @PostMapping
    public ResultDto<Integer> postBoard(@RequestBody BoardPostReq p) {
        int result = service.postBoard(p);

        return ResultDto.<Integer>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg("")
                .resultData(result).build();
    }
    @GetMapping
    public BoardGetRes getBoard(@RequestParam int boardId) {
        return service.getBoard(boardId);
    }


    // 형우씨 (결과값으로 resultDto 확인 가능)
    //    @GetMapping
//    public ResultDto<BoardGetRes> getBoard(@RequestParam int boardId) {
//        BoardGetRes result = service.getBoard(boardId);
//        return ResultDto.<BoardGetRes>builder()
//                .statusCode(HttpStatus.OK)
//                .resultMsg("")
//                .resultData(result).build();
//    }

    @DeleteMapping
    public int deleteBoard(@RequestParam(name="board_id") int boardId) {
        return service.deleteBoard(boardId);
    }
}
