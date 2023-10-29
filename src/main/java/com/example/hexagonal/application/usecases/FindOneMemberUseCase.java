package com.example.hexagonal.application.usecases;

import com.example.hexagonal.domain.Member;
import java.util.Optional;

public interface FindOneMemberUseCase {

  Optional<Member> findOne(String userId);

}
