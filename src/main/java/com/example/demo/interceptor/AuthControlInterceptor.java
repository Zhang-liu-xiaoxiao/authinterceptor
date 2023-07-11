package com.example.demo.interceptor;

import com.example.demo.enums.AuthLevel;
import com.example.demo.model.User;
import com.example.demo.annotation.AuthControl;
import com.example.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Configuration
public class AuthControlInterceptor extends HandlerInterceptorAdapter {
    private static final Logger logger = LoggerFactory.getLogger(AuthControlInterceptor.class);

    private final String USER_ID = "user-id";
    @Autowired
    UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        AuthControl authControl = method.getAnnotation(AuthControl.class);
        if (authControl == null) {
            // 如果注解为null, 说明不需要拦截, 直接放过
            return true;
        }

        // 如果是所有都能访问权限直接放行
        if (authControl.value() == AuthLevel.ALL) {
            return true;
        }
        if (authControl.value().getAuthLevel() >= AuthLevel.ALL.getAuthLevel()) {
            // 如果没带USER_ID, 直接返回401
            if (request.getIntHeader(USER_ID) == 0) {
                response.setStatus(401);
                logger.info("authControl " + method.getName() + " Not logged in");
                return false;
            }

            User user = userService.findById(request.getIntHeader(USER_ID));
            if (user == null || user.getId() == null) {
                response.setStatus(401);

                logger.info("authControl " + method.getName() + " Not logged in");
                return false;
            }
            if (user.getAuth() <= authControl.value().getAuthLevel()) {
                response.setStatus(403);
                logger.info("authControl " + method.getName() + " No authority");
                return false;
            }
        }
        return true;
    }
}
