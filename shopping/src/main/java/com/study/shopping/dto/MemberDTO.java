package com.study.shopping.dto;

import com.study.shopping.domain.Address;
import com.study.shopping.domain.Role;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@ToString
public class MemberDTO {

    @NotEmpty(message = "이름 입력하세요")
    private String name;

    @NotEmpty(message = "비밀번호 입력하세요")
    private String password;

    private String phoneNum;
    private Role role;
    private Address address;

}
