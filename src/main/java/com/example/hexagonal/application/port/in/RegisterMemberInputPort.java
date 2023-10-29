package com.example.hexagonal.application.port.in;

import com.example.hexagonal.application.port.out.MemberJoinOutputPort;
import com.example.hexagonal.application.usecases.JoinMemberUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegisterMemberInputPort implements JoinMemberUseCase {

  private final MemberJoinOutputPort memberJoinOutputPort;

  @Override
  @Transactional
  public void join(String userId, String pw) {
    memberJoinOutputPort.join(userId, pw);
  }
}
