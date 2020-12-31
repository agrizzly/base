package com.grizzly.base.common.security;

import com.grizzly.base.utils.Result;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * token 验证工具类
 *
 * @author itguang
 * @create 2018-01-06 15:01
 **/

public class TokenAuthenticationService {

    /**
     * JWT 加密密钥
     */
    @Value("${SECRET}")
    static final String SECRET = "www.grizzly.com";
    /**
     * TOKEN前缀
     */
    static final String TOKEN_PREFIX = "Bearer ";
    /**
     * 存放Token的Header Key
     */
    @Value("${HEADER_STRING}")
    public static final String HEADER_STRING = "token";

    /**
     * 自定义的 playload
     */
    static final String AUTHORITIES = "authorities";

    static final int EXPIRATIONTIME = 10000;


    /**
     * 将jwt token 写入header头部 和 cookie 中
     *
     * @param response
     * @param subject
     */
    public static void addTokenToHeader(HttpServletRequest request, HttpServletResponse response, String subject) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, 1);
        //生成 jwt
        String token = Jwts.builder()
                .setSubject(subject)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
//                .setExpiration(calendar.getTime())
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();

        //把token设置到响应头中去
        response.addHeader(HEADER_STRING, TOKEN_PREFIX + token);

        //把token设置到 cookie 中去,并且设置cookie的过期时间和token的过期时间相同
//        CookieUtil.set(request,response, HEADER_STRING, TOKEN_PREFIX + token, new Long(EXPIRATIONTIME / 1000).intValue());
        //为了方便客户段取得 openid ,再把openid 放到 cookie中
        //CookieUtil.set(request,response, "openid", subject, new Long(EXPIRATIONTIME / 1000).intValue());
    }

    /**
     * 从请求头和Cookie中解析出 token
     *
     * @param request
     * @param response
     * @return
     */
    public static Authentication getAuthentication(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // 从Header中拿到token
        String header = request.getHeader(HEADER_STRING);
        if (header == null || !header.startsWith(TOKEN_PREFIX)) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.setContentType("application/json;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.write(Result.newInstance(403, "暂未登录，请先登录").toJSONString());
            out.flush();
            out.close();
            return null;
        }
        try {
            String subject = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(header.replace(TOKEN_PREFIX, ""))
                    .getBody()
                    .getSubject();
            if (subject != null) {
                ArrayList<GrantedAuthority> authorities = new ArrayList<>();
                authorities.add(new GrantedAuthorityImpl("ROLE_ADMIN"));
                authorities.add(new GrantedAuthorityImpl("ROLE_USER"));
                return new UsernamePasswordAuthenticationToken(subject, null, authorities);
            }
        } catch (ExpiredJwtException e) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.setContentType("application/json;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.write(Result.newInstance(403, "认证已过期,请重新登录").toJSONString());
            out.flush();
            out.close();
        } catch (UnsupportedJwtException e) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.setContentType("application/json;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.write(Result.newInstance(403, "Token格式错误").toJSONString());
            out.flush();
            out.close();
        } catch (MalformedJwtException e) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.setContentType("application/json;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.write(Result.newInstance(403, "Token没有被正确构造").toJSONString());
            out.flush();
            out.close();
        } catch (SignatureException e) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.setContentType("application/json;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.write(Result.newInstance(403, "签名失败").toJSONString());
            out.flush();
            out.close();
        } catch (IllegalArgumentException e) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.setContentType("application/json;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.write(Result.newInstance(403, "非法参数异常").toJSONString());
            out.flush();
            out.close();
        }
        return null;
    }

}
