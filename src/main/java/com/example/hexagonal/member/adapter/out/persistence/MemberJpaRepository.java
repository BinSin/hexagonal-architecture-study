package com.example.hexagonal.adapter.out.persistence;

import com.example.hexagonal.member.domain.Member;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {

  Optional<Member> findByUserId(String userId);

}
