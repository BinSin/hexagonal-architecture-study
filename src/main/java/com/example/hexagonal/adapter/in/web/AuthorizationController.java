package com.example.hexagonal.adapter.in.web;

import com.example.hexagonal.adapter.out.persistence.MemberJoinEntity;
import com.example.hexagonal.application.usecases.JoinMemberUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthorizationController {

  private final JoinMemberUseCase joinMemberUseCase;

  @PostMapping("/join")
  public ResponseEntity<String> join(@RequestBody MemberJoinEntity dto) {
    try {
      joinMemberUseCase.join(dto.getUserId(), dto.getPw());
      return ResponseEntity.ok("join success");
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

}
