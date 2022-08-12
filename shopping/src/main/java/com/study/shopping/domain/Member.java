package com.study.shopping.domain;

import com.study.shopping.dto.MemberDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String name;

    private String password;
    private String phoneNum;
    private Role role;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "cart_id")
//    private Cart cart;
//
//    public void setCart(Cart cart) {
//        this.cart = cart;
//        cart.setMember(this);
//    }

    public void changeRole(Role role){
        this.role = role;
    }

    public Member(MemberDTO memberDTO) {
        this.name = memberDTO.getName();
        this.address = memberDTO.getAddress();
        this.role = memberDTO.getRole();
        this.phoneNum = memberDTO.getPhoneNum();
        this.password = memberDTO.getPassword();
    }

}
