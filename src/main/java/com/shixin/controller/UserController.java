package com.shixin.controller;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.shixin.entity.User;
import com.shixin.server.UserService;
import com.shixin.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 今何许
 * @date 2020-08-14 14:08
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public Map<String, Object> login(User user) {
        Map<String, Object> map = new HashMap<>();
        try {
            User loginUser = userService.login(user);
            Map<String, String> payload = new HashMap<>();
            //生成Jwt令牌
            payload.put("id", loginUser.getId());
            payload.put("name", loginUser.getName());
            String token = JwtUtil.getToken(payload);
            map.put("state", true);
            map.put("msg", "认证成功");
            map.put("token", token);
        } catch (Exception e) {
            map.put("state", false);
            map.put("msg", e.getMessage());
        }
        return map;
    }

    @PostMapping("/test")
    public Map<String, Object> test(String token) {
        Map<String, Object> map = new HashMap<>();
      /*  try {
            //验证令牌
            DecodedJWT tokenInfo = JwtUtil.getTokenInfo(token);*/
        map.put("state", true);
        map.put("msg", "请求成功");
        return map;
       /* } catch (SignatureVerificationException e) {
            map.put("msg", "无效签名");
        } catch (TokenExpiredException e) {
            map.put("msg", "token过期");
        } catch (AlgorithmMismatchException e) {
            map.put("msg", "算法不一致");
        } catch (Exception e) {
            map.put("msg", "token无效");
        }
        map.put("state", false);
        return map;*/
    }

}
