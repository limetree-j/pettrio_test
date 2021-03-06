package com.fluffytrio.pettrio.app.user.dto;

import com.fluffytrio.pettrio.app.user.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@Builder
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class UserListResponseDTO {
    private final List<User> userList;
}
