package com.example.hexagonal.member.adapter.in.web;

import com.example.hexagonal.member.adapter.out.persistence.MemberJoinDto;
import com.example.hexagonal.member.application.port.in.FindOneMemberUseCase;
import com.example.hexagonal.member.application.port.in.JoinMemberUseCase;
import com.example.hexagonal.member.domain.Member;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
      return ResponseEntity.ok("존재하지 않는 userId 입니다.");
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
