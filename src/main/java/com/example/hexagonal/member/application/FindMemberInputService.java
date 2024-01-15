package com.example.hexagonal.member.application;

import com.example.hexagonal.member.application.port.in.FindOneMemberUseCase;
import com.example.hexagonal.member.application.port.out.MemberFindOutputPort;
import com.example.hexagonal.member.domain.Member;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class FindMemberInputService implements FindOneMemberUseCase {

  private final MemberFindOutputPort memberFindOutputPort;

  @Override
  @Transactional(readOnly = true)
  public Optional<Member> findOne(String userId) {
    return memberFindOutputPort.findOne(userId);
  }

}
