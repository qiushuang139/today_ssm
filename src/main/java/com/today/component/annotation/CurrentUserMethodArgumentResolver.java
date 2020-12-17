package com.today.component.annotation;

import com.today.component.Constants;
import com.today.entity.User;
import com.today.entity.UserPasswordRecord;
import com.today.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

/**
 * @author :zhangyi
 * @description:
 * @date :2020/12/15 15:41
 */
//@Component
public class CurrentUserMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Autowired
    private UserService userService;

    @Override
    public boolean supportsParameter (MethodParameter parameter) {
        // 如果参数类型是 User 并且有 CurrentUser 注解则支持
        if ((parameter.getParameterType ().isAssignableFrom (User.class)||
                parameter.getParameterType().isAssignableFrom(UserPasswordRecord.class))
                && parameter.hasParameterAnnotation (CurrentUser.class)) {
            return true;
        }
        return false;
    }

    @Override
    public Object resolveArgument (MethodParameter parameter, ModelAndViewContainer mavContainer,
                                   NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        System.out.println("确认是否是当前的用户");

//        NativeWebRequest webRequest
//        return null;
        // 取出鉴权时存入的登录用户 Id
//        HttpServletRequest request=(HttpServletRequest)webRequest;

        Integer currentUserId=(Integer) webRequest.getAttribute(Constants.CURRENT_USER_ID,RequestAttributes.SCOPE_REQUEST);
        System.out.println("test"+webRequest.getAttribute(Constants.CURRENT_USER_ID,RequestAttributes.SCOPE_REQUEST));

        if (currentUserId !=null) {
            // 从数据库中查询并返回
            return userService.getUserById(currentUserId);
        }
        throw new MissingServletRequestPartException(Constants.CURRENT_USER_ID);
    }
}
