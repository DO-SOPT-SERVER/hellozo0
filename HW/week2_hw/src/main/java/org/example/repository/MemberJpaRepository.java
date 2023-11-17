package org.example.repository;

import jakarta.persistence.EntityNotFoundException;
import org.example.constant.ErrorMessage;
import org.example.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberJpaRepository extends JpaRepository<Member, Long> {

    //default--> interface에 구현부 구현가능하게 하는 keyword
    //Service 파일에서 예외처리하던것을 Repository파일에 정의함으로써 다른곳에서도 재사용할 수 있게 되었다.
    //Service 파일의 getMemberByIdV3 함수에서 사용~
    default Member findByIdOrThrow(Long id) {
        return findById(id).orElseThrow(
                () -> new EntityNotFoundException(ErrorMessage.NOT_FOUND_MEMBER_EXCEPTION.getMessage()));
    }
}
