package com.green.boardver2.user.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class UserEntity {
    private long userId;
    private String uid;
    private String upw;
    private String nm;
    private String createdAt;
    private String updatedAt;
}
