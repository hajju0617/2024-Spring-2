package com.green.boardver2.common;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder    // 객체 생성시 원하는 값만 넣어서 생성 가능
public class ResultDto<T> {     // <T> : 제네릭 -> 컴파일 될 시점에 타입이 정해짐
    private HttpStatus statusCode;
    private String resultMsg;
    private T resultData;
}

// 공통적으로 쓰는 클래스
