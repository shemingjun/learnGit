package com.test.learn.utils.exception;

import com.test.learn.utils.annotation.ExceptionNoticeLog;
import com.test.learn.utils.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.sql.SQLException;

/**
 * 异常通用处理*
 * @author smj
 * @Title: CustomerExceptionAdvice
 * @ProjectName ESOP-project
 * @packageName com.ruoyi.common.exception
 * @date 2023/5/19 16:31
 */
@Slf4j
@ResponseBody
@ControllerAdvice
public class CustomerExceptionAdvice {
    /**
     * IllegalArgumentException异常处理返回json
     * 返回状态码:400
     */
    @ExceptionNoticeLog
    @ExceptionHandler({IllegalArgumentException.class})
    public AjaxResult badRequestException(IllegalArgumentException e) {
        return defHandler("参数解析失败", e);
    }

    @ExceptionNoticeLog
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public AjaxResult handleError(MissingServletRequestParameterException e) {
        return defHandler("参数解析失败", e);
    }

    @ExceptionNoticeLog
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public AjaxResult handleError(MethodArgumentTypeMismatchException e) {
        return defHandler("参数解析失败", e);
    }

    @ExceptionNoticeLog
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public AjaxResult handleError(MethodArgumentNotValidException e) {
        return defHandler("参数解析失败", e);
    }

    @ExceptionNoticeLog
    @ExceptionHandler(BindException.class)
    public AjaxResult handleError(BindException e) {
        return defHandler("参数解析失败", e);
    }

    @ExceptionNoticeLog
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public AjaxResult handleError(HttpMessageNotReadableException e) {
        return defHandler("http请求参数转换异常", e);
    }

    @ExceptionNoticeLog
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public AjaxResult handleAccessDeniedException(MaxUploadSizeExceededException e) {
        return defHandler("文件上传过大异常", e);
    }

    /**
     * 返回状态码:405
     */
    @ExceptionNoticeLog
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public AjaxResult handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        return defHandler("不支持当前请求方法", e);
    }

    /**
     * 返回状态码:415
     */
    @ExceptionNoticeLog
    @ExceptionHandler({HttpMediaTypeNotSupportedException.class})
    public AjaxResult handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException e) {
        return defHandler("不支持当前媒体类型", e);
    }

    /**
     * SQLException sql异常处理
     * 返回状态码:500
     */
    @ExceptionNoticeLog
    @ExceptionHandler({SQLException.class})
    public AjaxResult handleSQLException(SQLException e) {
        return defHandler("服务运行SQLException异常", e);
    }

    /**
     * BusinessException 业务异常处理
     * 返回状态码:500
     */
    @ExceptionNoticeLog
    @ExceptionHandler(ServiceException.class)
    public AjaxResult handleException(ServiceException e) {
        return defHandler(e.getMessage(), e);
    }


    protected AjaxResult defHandler(String msg, Throwable e) {
        log.error(msg, e);
        return AjaxResult.error(msg);
    }
}
