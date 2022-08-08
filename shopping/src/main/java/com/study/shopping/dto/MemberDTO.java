package com.study.shopping.dto;

import com.study.shopping.domain.Address;
import com.study.shopping.domain.Role;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberDTO {
    private String name;
    private String password;
    private String phoneNum;
    private Role role;
    private Address address;

}
