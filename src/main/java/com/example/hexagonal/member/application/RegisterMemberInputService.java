package com.example.hexagonal.member.application;

import com.example.hexagonal.member.application.port.in.JoinMemberUseCase;
import com.example.hexagonal.member.application.port.out.MemberJoinOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class RegisterMemberInputService implements JoinMemberUseCase {

  private final MemberJoinOutputPort memberJoinOutputPort;

  @Override
  public void join(String userId, String pw) {
    memberJoinOutputPort.join(userId, pw);
  }

}
