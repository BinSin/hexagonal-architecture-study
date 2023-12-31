package com.example.hexagonal.application.port.in;

import com.example.hexagonal.application.port.out.MemberFindOutputPort;
import com.example.hexagonal.application.usecases.FindOneMemberUseCase;
import com.example.hexagonal.domain.Member;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class FindMemberInputPort implements FindOneMemberUseCase {

  private final MemberFindOutputPort memberFindOutputPort;

  @Override
  @Transactional(readOnly = true)
  public Optional<Member> findOne(String userId) {
    return memberFindOutputPort.findOne(userId);
  }

}
