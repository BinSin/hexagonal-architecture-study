package com.example.hexagonal.application.port.out;

import com.example.hexagonal.domain.Member;
import java.util.Optional;

public interface MemberFindOutputPort {

  Optional<Member> findOne(String userId);

}
