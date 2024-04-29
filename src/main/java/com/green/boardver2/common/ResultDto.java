package com.green.boardver2.common;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder    // 객체 생성시 원하는 것만 생성 가능
public class ResultDto<T> {     // <T> : 제네릭 -> 컴파일 될 시점에 타입이 정해짐
    private HttpStatus statusCode;
    private String resultMsg;
    private T resultData;
}
/*
ResultDto는 일반적인 API 응답 데이터를 담는 DTO(Data Transfer Object) 클래스

ResultDto 클래스의 구성
1. statusCode: HTTP 상태 코드를 나타내는 HttpStatus 타입의 필드
2. resultMsg: 결과에 대한 메시지를 나타내는 String 타입의 필드
3. resultData: 실제 결과 데이터를 나타내는 T 타입의 필드
 */

// 공통적으로 쓰는 클래스


/* EX)
{
    "statusCode": 200,
    "resultMsg": "통신완료",
    "resultData": {          <------ 제네릭이므로 뭐든 지 될 수 있다.
        "name": "홍길동"
    }
}
 */
