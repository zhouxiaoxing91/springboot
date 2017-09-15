package com.nancy.handle;

import com.nancy.dto.ResponseError;
import com.nancy.enums.ResponseEnum;
import com.nancy.exception.ResponException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

  @ExceptionHandler(value = ResponException.class)
  @ResponseBody
  public ResponseError<String> jsonErrorHandler(HttpServletRequest req, Exception e){
    ResponseError response = new ResponseError();
    ResponException be = (ResponException)e;
    response.setCode(ResponseEnum.FAIL.getCode());
    response.setMessage(be.getMessage());
    response.setUrl(req.getRequestURL().toString() ) ;
    log.info("异常", e, response);
    return response;
  }

}
