package com.shixin;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.HashMap;


@RunWith(SpringRunner.class)
@SpringBootTest
class JwtApplicationTests {

    @Test
    void contextLoads() {
        HashMap<String, Object> map = new HashMap<>();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, 300);
        String token = JWT.create()
                .withHeader(map) //header,可省略
                .withClaim("userId", 21) //payload
                .withClaim("username", "许诺")
                .withExpiresAt(calendar.getTime())  //令牌过期时间
                .sign(Algorithm.HMAC256("!#$@hfids"));//签名
        System.out.println(token);
    }

    @Test
    void test() {
        //创建验证对象
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("!#$@hfids")).build();
        DecodedJWT verify = jwtVerifier.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1OTczODM0MjMsInVzZXJJZCI6MjEsInVzZXJuYW1lIjoi6K646K-6In0.iYpSR_CyGcg7Mge5QIadso9ESEwcUnxHB9aEt5XOhpY");
        System.out.println(verify.getClaim("userId").asInt());
        System.out.println(verify.getClaim("username").asString());
        System.out.println(verify.getExpiresAt());
    }


}
