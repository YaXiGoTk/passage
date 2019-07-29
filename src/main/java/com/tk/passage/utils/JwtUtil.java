package com.tk.passage.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: passage
 * @description:
 * @author: tkang
 * @create: 2019-07-29 10:53
 **/

public class JwtUtil {

    public static String generateJwt(String loginName){

        try {

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("alg", "HS256");
            map.put("typ", "JWT");

            Algorithm algorithm = Algorithm.HMAC256("secret");

            /**
             *  我们通过定义注册和自定义声明 并组合头部信息和密钥信息生成jwt token
             */
            String token = JWT.create()
                    //构建头部信息
                    .withHeader(map)
                    /*设置 载荷 Payload*/
                    .withClaim("loginName",loginName)//设置自定义，加上登陆用户名
                    .withIssuer("passage")//签名是有谁生成 例如 服务器
                    .withSubject("this is passage token")//签名的主题
                    .withExpiresAt(new Date((System.currentTimeMillis() / 1000 / 10 + 60 * 60 * 2 / 10) * 10 * 1000))//签名过期的时间
                    .sign(algorithm);
                    return token;
        } catch (JWTCreationException exception){
            //Invalid Signing configuration / Couldn't convert Claims.
        }
        return null;

    }

    public static String verifyJwt(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("passage")
                    .build(); //Reusable verifier instance
            DecodedJWT jwt = verifier.verify(token);
            Map<String, Claim> claims = jwt.getClaims();    //Key is the Claim name
            Claim claim = claims.get("loginName");
            String username = claim.asString();
            if (username !=null){
                return username;
            }

        } catch (JWTVerificationException exception){
            //Invalid signature/claims
        }
        return null;
    }

    public static void main(String[] args) {
        generateJwt("tkang");
        //两小时
        System.out.println(new Date((System.currentTimeMillis() / 1000 / 10 + 60 * 60 * 2 / 10) * 10 * 1000));
    }
}
