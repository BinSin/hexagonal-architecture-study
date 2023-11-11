package com.example.hexagonal.adapter.in.web;

import com.example.hexagonal.adapter.out.persistence.MemberJoinDto;
import com.example.hexagonal.application.usecases.FindOneMemberUseCase;
import com.example.hexagonal.application.usecases.JoinMemberUseCase;
import com.example.hexagonal.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthorizationController {

  private final FindOneMemberUseCase findOneMemberUseCase;
  private final JoinMemberUseCase joinMemberUseCase;

  @GetMapping
  public ResponseEntity<String> join(@RequestParam String userId) {
    Optional<Member> member = findOneMemberUseCase.findOne(userId);
    if (member.isEmpty()) {
      return ResponseEntity.ok("존재하지 않는 userId 입니다.a");
    }

    return ResponseEntity.ok(member.get().toString());

  }

  @PostMapping("/join")
  public ResponseEntity<String> join(@RequestBody MemberJoinDto dto) {
    try {
      joinMemberUseCase.join(dto.getUserId(), dto.getPw());
      return ResponseEntity.ok("join success");
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

}
