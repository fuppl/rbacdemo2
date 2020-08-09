package com.example.loginservice.component;

import com.example.loginservice.entity.Role;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

/**
 * 此类用于将公有方法提炼出来，包括获取请求上的token中的uid和role方法
 */
@Component
@Slf4j
public class RequestComponent {
    public int getUid() {
        return (int) RequestContextHolder.currentRequestAttributes()
                .getAttribute(MyToken.UID, RequestAttributes.SCOPE_REQUEST);
    }

    public Role getRole() {
        return (Role) RequestContextHolder.currentRequestAttributes()
                .getAttribute(MyToken.ROLE, RequestAttributes.SCOPE_REQUEST);
    }
}
