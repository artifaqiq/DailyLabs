/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package by.casanova.team.aspects;

import by.casanova.team.service.UserService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * @author Lomako
 * @author Shurin
 * @version 1.0
 */

@Component
@Aspect
public class SecurityAspect {

    private UserService userService;

    public SecurityAspect(@Autowired UserService userService) {
        this.userService = userService;
    }

    @Pointcut("within(by.casanova.team.controllers.api.DiaryController)")
    public void diaryController() { }

    @Around("diaryController()")
    public Object checkSecurity(ProceedingJoinPoint joinPoint) throws Throwable {
        String jwtToken = (String)(joinPoint.getArgs()[0]);

        if(userService.getByToken(jwtToken) == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } else {
            return joinPoint.proceed();
        }
    }

}
