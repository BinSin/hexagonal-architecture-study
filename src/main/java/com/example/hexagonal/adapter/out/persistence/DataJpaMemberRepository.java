package com.example.hexagonal.adapter.out.persistence;

import com.example.hexagonal.domain.Member;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataJpaMemberRepository extends JpaRepository<Member, Long> {

  Optional<Member> findByUserId(String userId);

}
