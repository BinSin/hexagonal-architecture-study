package com.example.hexagonal.adapter.out.persistence;

import com.example.hexagonal.application.port.out.MemberFindOutputPort;
import com.example.hexagonal.application.port.out.MemberJoinOutputPort;
import com.example.hexagonal.domain.Member;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepository implements MemberFindOutputPort, MemberJoinOutputPort {

  private final DataJpaMemberRepository dataJpaMemberRepository;

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

    try {
      dataJpaMemberRepository.save(member);
    } catch (DataIntegrityViolationException e) {
      throw new DataIntegrityViolationException("userId 중복");
    }
  }
}
