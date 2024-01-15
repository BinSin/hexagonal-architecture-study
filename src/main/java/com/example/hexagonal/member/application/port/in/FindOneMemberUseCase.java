package com.example.hexagonal.member.application.port.in;

import com.example.hexagonal.member.domain.Member;
import java.util.Optional;

public interface FindOneMemberUseCase {

  Optional<Member> findOne(String userId);

}
