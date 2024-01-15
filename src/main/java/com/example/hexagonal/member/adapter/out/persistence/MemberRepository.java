package com.example.hexagonal.adapter.out.persistence;

import com.example.hexagonal.member.application.port.out.MemberFindOutputPort;
import com.example.hexagonal.member.application.port.out.MemberJoinOutputPort;
import com.example.hexagonal.member.domain.Member;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepository implements MemberFindOutputPort, MemberJoinOutputPort {

  private final MemberJpaRepository dataJpaMemberRepository;

  @Override
  public Optional<Member> findOne(String userId) {
    return dataJpaMemberRepository.findByUserId(userId);
  }

  @Override
  public void join(String userId, String pw) {
    Member member = Member.builder()
        .userId(userId)
        .pw(pw)
        .build();

    dataJpaMemberRepository.findByUserId(userId)
        .ifPresent(m -> {
          throw new IllegalStateException("UserId: " + m.getUserId() + " 는 이미 존재하는 회원입니다.");
        });

    dataJpaMemberRepository.save(member);
  }

}
