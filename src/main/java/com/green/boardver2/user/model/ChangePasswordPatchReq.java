package com.green.boardver2.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ChangePasswordPatchReq {
    // 비빌번호 변경
    // 대상 지정(PK or ID) 기존 비밀번호(대상의 원 주인인지 체크), 신규 비밀번호
    // PK는 모르기때문에 아이디를 보낸다
    @JsonIgnore private long userId; // 이 한줄만 영향 받음 (swagger문서에 나타나지 않음) => 제이슨 문서에 이 값을 안 나타나게 해줌

    private String uid;
    private String currentPw;
    private String newPw;
}
