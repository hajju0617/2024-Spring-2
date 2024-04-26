package com.green.boardver2.user;
import com.green.boardver2.user.model.ChangePasswordPatchReq;
import com.green.boardver2.user.model.SignInPostReq;
import com.green.boardver2.user.model.UserEntity;
import com.green.boardver2.user.model.UserPostReq;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;

    public int postUser(UserPostReq p) {
        // 비밀번호 암호화
        String hashedPassword = BCrypt.hashpw(p.getUpw(), BCrypt.gensalt());    // BCrypt.hashpw, BCrypt.gensalt() : static 메소드 (객체화 없이 사용하고있음)
        p.setUpw(hashedPassword);
        return mapper.postUser(p);
    }

    // 1: 로그인 성공, 2: 아이디 없음, 3: 비밀번호 다름
    public int postSignIn(SignInPostReq p) {
        UserEntity entity = mapper.getUserById(p.getUid());     // 메소드 반환값이 아예 없을 경우 entity는 null값을 가짐
        if(entity == null) {
            return 2;
        }

        if(BCrypt.checkpw(p.getUpw(), entity.getUpw())) {
            return 1;
        }
        return 3;
    }
    // 1: 비밀번호 변경 성공, 2: 아이디를 확인해 주세요. 3:기존 비밀번호를 확인 해주세요
    public int patchPassword(ChangePasswordPatchReq p) {
        // 현재 비밀번호
        System.out.println("유저가 입력한 값: " + p);
        UserEntity entity = mapper.getUserById(p.getUid());
        if(entity == null) {
            return 2;
        } else if (!BCrypt.checkpw(p.getCurrentPw(), entity.getUpw())) {
            return 3;
        }
        // 비밀번호 변경
        String hashedPassword = BCrypt.hashpw(p.getNewPw(), BCrypt.gensalt());
        p.setNewPw(hashedPassword);
        System.out.println("set userid 적은 이유: "+  entity);
        p.setUserId(entity.getUserId());
        System.out.println("mapper 에 들어갈 값: " + p);
        return mapper.patchPassword(p);

        /*
        Mybatis에서 insert, update, delete의 결과값은 int형이며
        실패시 0 성공시 성공한 갯수를 반환합니다. ====> 그래서 return 1;을 하지 않았음에도
        리턴값으로 1이 뜸

        동일한 값을 2번 이상 Update시에도
        값의 변경여부와 관계없이 결과를 반환합니다
        즉, Update구문의 오류 없이 성공 했다면
        DB내 저장된 값의 변경여부와 관계없이
        대상이 되는 row의 갯수를 반환합니다
         */
    }
}
