package com.example.tliaswebmanagement;

import com.example.tliaswebmanagement.mapper.EmpMapper;
import com.example.tliaswebmanagement.pojo.Emp;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class TliasWebManagementApplicationTests {
    @Autowired
    private EmpMapper empMapper;

    @Test
    public void testList() {
        List<Emp> empList = empMapper.list(null, null, null, null);
        empList.forEach(System.out::println);
    }
    @Test
    public void testGenJwt() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 10);
        claims.put("username", "itheima");

        String jwt = Jwts.builder().signWith(SignatureAlgorithm.HS256, "aXRjYXN0")
                .addClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + 12 * 3600 * 1000))//令牌过期时间 当前+1小时
                .compact();

        System.out.println(jwt);
    }
    @Test
    public void testParseJwt() {
        Claims claims = Jwts.parser().setSigningKey("aXRjYXN0")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MTAsInVzZXJuYW1lIjoiaXRoZWltYSIsImV4cCI6MTc3OTY2Njk1M30.I91FiFOL2uz44HLyj4O2GfWvVqcyDwnyW760xr26mXo")
                .getBody();
        System.out.println(claims);
    }
}