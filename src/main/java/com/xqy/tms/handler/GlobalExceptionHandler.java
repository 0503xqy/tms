package com.xqy.tms.handler;

import com.xqy.tms.base.BaseException;
import com.xqy.tms.dto.Result;
import com.xqy.tms.exception.CustomException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(value = BaseException.class)

    public Result<String> bizExceptionHandler(HttpServletRequest req, BaseException e){
        logger.error("发生业务异常！原因是：{}",e.getMessage());
        return Result.error(e.getStatus(),e.getMessage());
    }


}
