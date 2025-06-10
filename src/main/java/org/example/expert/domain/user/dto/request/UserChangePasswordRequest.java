package org.example.expert.domain.user.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserChangePasswordRequest {

    @NotBlank
    // ^ : 문자열 시작 $ : 문자열 끝
    // {8,} 8자리 이상인지 확인
    // (?=.*[A-Z]) : 문자열에서 대문자 포함 여부 확인
    // (?=.*\\d) : 문자열에서 숫자(digit) 포함 여부 확인
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d).{8,}$", message = "기존 비밀번호 형식이 올바르지 않습니다.")
    private String oldPassword;

    @NotBlank
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d).{8,}$", message = "새 비밀번호는 8자 이상이어야 하고, 숫자와 대문자를 포함해야 합니다.")
    private String newPassword;
}
