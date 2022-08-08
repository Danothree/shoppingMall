package com.study.shopping.service;

import com.study.shopping.domain.Address;
import com.study.shopping.domain.Member;
import com.study.shopping.domain.Role;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired private MemberService memberService;


    @Test
    void 회원가입() throws Exception {

        Member member = new Member();
        Address address = new Address("천안시", "중앙로", "265-36");

        member.builder()
                .name("member1")
                .address(address)
                .password("danu1234")
                .phoneNum("01093472172")
                .role(Role.VIP)
                .build();

        Long joinMemberId = memberService.join(member);
        Assertions.assertThat(memberService.findOne(joinMemberId)).isEqualTo(member);
    }

    @Test
    void 중복회원체크() {
        Member member1 = new Member();
        Address address = new Address("천안시", "중앙로", "265-36");

        member1.builder()
                .name("member1")
                .address(address)
                .password("danu1234")
                .phoneNum("01093472172")
                .role(Role.VIP)
                .build();

        Member member2 = new Member();

        member2.builder()
                .name("member1")
                .address(address)
                .password("danu1234")
                .phoneNum("01093472172")
                .role(Role.VIP)
                .build();

        memberService.join(member1);

        assertThrows(IllegalStateException.class, () -> {
            memberService.join(member2);
        });
    }

    @Test
    void 회원업데이트() throws Exception {

        Member member = new Member();
        Address address = new Address("천안시", "중앙로", "265-36");

        member.builder()
                .name("member1")
                .address(address)
                .password("danu1234")
                .phoneNum("01093472172")
                .role(Role.VIP)
                .build();

        Long joinMember = memberService.join(member);
        Member findMember = memberService.findOne(joinMember);
        findMember.changeRole(Role.NORMAL);

        Assertions.assertThat(findMember.getRole()).isEqualTo(memberService.findOne(joinMember).getRole());
    }
}