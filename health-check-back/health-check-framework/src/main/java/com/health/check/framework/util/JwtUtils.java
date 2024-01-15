package com.health.check.framework.util;

import com.health.check.framework.base.UserJwt;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Optional;

/**
 * JWT工具类
 *
 * @author xiao.xl 2022/3/31 10:50
 */
@Slf4j
public abstract class JwtUtils {

    /**
     * jwt加/解密秘钥
     */
    private static final String SECRET = "1xiao2xin3lai4ni5ke6yi7xie8chu9hen10niu11bi12de13dai14ma15de";

    private static final String JWT_NAME = "name";
    private static final String JWT_EMAIL = "email";
    private static final String JWT_USER_TYPE = "userType";
    private static final String JWT_USER_ID = "userId";


    /**
     * 密钥加密token
     *
     * @param jwt 用户信息
     * @return 生成token
     * @author xiao.xl 2022/3/31 10:53
     */
    public static String generateToken(UserJwt jwt, Date expire) {
        String compactJws = Jwts.builder()
                .setSubject(jwt.getPhone())
                .claim(JWT_NAME, jwt.getName())
                .claim(JWT_EMAIL, jwt.getEmail())
                .claim(JWT_USER_ID, jwt.getUserId())
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .setExpiration(expire)
                .compact();
        return compactJws;
    }

    /**
     * 从token中获取用户信息
     *
     * @param token token值
     * @return 用户信息
     * @author xiao.xl 2022/3/31 11:01
     */
    public static UserJwt getUserInfoToToken(String token) {
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token);
        Claims body = claimsJws.getBody();
        String phone = body.getSubject();
        Optional<String> nameOptional = Optional.ofNullable(body.get(JWT_NAME, String.class));
        Optional<String> emailOptional = Optional.ofNullable(body.get(JWT_EMAIL, String.class));
        Optional<String> userTypeOptional = Optional.ofNullable(body.get(JWT_USER_TYPE, String.class));
        Optional<Long> userIdOptional = Optional.ofNullable(body.get(JWT_USER_ID, Long.class));
        Date expiration = body.getExpiration();
        return new UserJwt(phone, nameOptional.orElse(null), emailOptional.orElse(null),
                 userIdOptional.orElse(null), expiration);
    }

}
