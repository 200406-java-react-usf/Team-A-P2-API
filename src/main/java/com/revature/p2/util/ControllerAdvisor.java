package com.revature.p2.util;

import com.revature.p2.exceptions.*;
import com.revature.p2.web.dtos.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

@Component
@RestControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler
    public ErrorResponse handleRevaboardsException(P2Exception e, HttpServletResponse resp) {
        ErrorResponse err = new ErrorResponse(e);

        if (e instanceof BadRequestException) {
            resp.setStatus(400);
        } else if (e instanceof AuthenticationException) {
            resp.setStatus(401);
        } else if (e instanceof ResourceNotFoundException) {
            resp.setStatus(404);
        }
        

        return err;
    }

}