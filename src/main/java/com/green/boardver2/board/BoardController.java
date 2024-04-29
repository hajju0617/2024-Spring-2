package com.green.boardver2.board;

import com.green.boardver2.board.model.*;
import com.green.boardver2.common.ResultDto;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Update;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController             //   ------> Bean 등록 + URL 맵핑 (간단하게 역할분담 지정) ===> /board가 들어오면 BoardController, /user가 들어오면 UserController
@RequestMapping("board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService service;

    @PostMapping
    public ResultDto<Integer> postBoard(@RequestBody BoardPostReq p) {      // ResultDto<T>의 <T>가 <Integer> 타입으로 정해짐
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

    @PutMapping
    public int putUpdate(@RequestBody BoardPutReq p) {
        return service.putUpdate(p);
    }

    @GetMapping("{board_id}")
    public ResultDto<BoardDetailGetRes> getBoardOne(@PathVariable(name = "board_id") long boardId) {
        BoardDetailGetRes result = service.getBoardOne(boardId);

        return ResultDto.<BoardDetailGetRes>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg(result == null? "내용을 찾을 수 없습니다." : HttpStatus.OK.toString())
                .resultData(result).build();
        //builder()는 사용한 변수만 만들어줌 + 클래스명이 아닌 변수명으로 생성자 -> result를 받음
    }

    @GetMapping("SelectList")   // ("SelectList") 적은 이유 -> 중복된 GetMapping 구분
    public ResultDto<List<BoardGetRes>> getBoardList(@RequestParam(name = "page") int page      // ----> ResultDto<T>에서 T가 <List<BoardGetRes>> 해당 타입으로 정해짐
            , @RequestParam(name = "size", defaultValue = "10") int size) {
        BoardGetReq p = new BoardGetReq();
        p.setStartIdx((page - 1) * size);           // service 쪽에서 처리 해야 할 코드
        p.setLen(size);

        List<BoardGetRes> list = service.getBoardList(p);

        return ResultDto.<List<BoardGetRes>>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg(String.format("rowCount: %d", list.size()))
                .resultData(list).build();
    }
}
