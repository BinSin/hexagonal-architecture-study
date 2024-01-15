package com.example.hexagonal.member.application.port.out;

import com.example.hexagonal.member.domain.Member;
import java.util.Optional;

public interface MemberFindOutputPort {

  Optional<Member> findOne(String userId);

}
