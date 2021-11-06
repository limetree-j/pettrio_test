package com.fluffytrio.pettrio.app.user.domain;

import com.fluffytrio.pettrio.app.common.domain.Common;
import com.fluffytrio.pettrio.app.user.enums.UserRole;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="users")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends Common implements Serializable {
    @Column(nullable = false, unique = true, length = 50)
    private String userName;

    @Setter
    @Column(nullable = false)
    private String pw;

    @Setter
    @Column(nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private UserRole role;
}
