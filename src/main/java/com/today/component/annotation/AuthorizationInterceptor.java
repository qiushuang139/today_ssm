package com.today.component.annotation;

import com.today.component.Constants;
import com.today.component.TokenManager;
import com.today.entity.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author :zhangyi
 * @description:
 * @date :2020/12/15 15:36
 */
@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {
    @Qualifier("redisTokenManager")
    @Autowired
    private TokenManager tokenManager;

    public boolean preHandle (HttpServletRequest request,
                              HttpServletResponse response, Object handler) throws Exception {

        //
        System.out.println("执行校验");


        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod ();
        // 从 header 中得到 token
        String authorization = request.getHeader (Constants.AUTHORIZATION);
        // 验证 token
        Token model = tokenManager.getToken (authorization);
        if (tokenManager.checkToken (model)) {
            // 如果 token 验证成功，将 token 对应的用户 id 存在 request 中，便于之后注入
            request.setAttribute (Constants.CURRENT_USER_ID, model.getUserId ());
            System.out.println(request.getAttribute(Constants.CURRENT_USER_ID));
            return true;
        }

        // 如果验证 token 失败，并且方法注明了 Authorization，返回 401 错误
        if (method.getAnnotation (Authorization.class) != null) {
            response.setStatus (HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
        return true;
    }
}
