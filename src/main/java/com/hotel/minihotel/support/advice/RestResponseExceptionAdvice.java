package com.hotel.minihotel.support.advice;

import static org.springframework.core.annotation.AnnotatedElementUtils.findMergedAnnotation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.hotel.minihotel.exception.HotelError;
import com.hotel.minihotel.exception.HotelException;
import com.hotel.minihotel.exception.HotelExceptionEnum;
import com.hotel.minihotel.exception.HotelInternalException;
import com.hotel.minihotel.exception.MalformedHttpRequestException;
import com.hotel.minihotel.service.InternalErrorLogService;

import lombok.AllArgsConstructor;



@ControllerAdvice
@AllArgsConstructor
public class RestResponseExceptionAdvice implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1;
    private final static Logger logger = LogManager.getLogger(RestResponseExceptionAdvice.class);


    private InternalErrorLogService errorLogService;


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<HotelError>> handleValidationExcption(MethodArgumentNotValidException exception) {

        BindingResult bindingResult = exception.getBindingResult();
        List<HotelError> exceptionErrors = null;
        Object errorArgument = null;
        HotelExceptionEnum helpdeskExceptionEnum = null;
        HotelError HotelError = null;

        if (bindingResult.hasErrors()) {

            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            List<ObjectError> objectErrors = bindingResult.getGlobalErrors();
            exceptionErrors = new ArrayList<HotelError>();


            for (FieldError fieldError : fieldErrors) {

            	helpdeskExceptionEnum =  HotelExceptionEnum.getByConstraintCode(fieldError.getCode());

                errorArgument = fieldError.getArguments() != null && fieldError.getArguments().length > 0
                        ? fieldError.getArguments()[0] : null;

                if(helpdeskExceptionEnum.equals(HotelExceptionEnum.EXCEPTION_IN_VALIDATION)){
                	HotelException helpdeskException = (HotelException) errorArgument;
                	helpdeskException = errorLogService.log(helpdeskException);
                    logger.error(errorArgument);
                }


                HotelError = new HotelError(fieldError.getRejectedValue(), helpdeskExceptionEnum, errorArgument);
                exceptionErrors.add(HotelError);

            }

            for(ObjectError objectError : objectErrors){
            	helpdeskExceptionEnum = HotelExceptionEnum.getByCode(objectError.getCode());

                errorArgument = objectError.getArguments() != null && objectError.getArguments().length > 0
                        ? objectError.getArguments()[0] : null;

                if(helpdeskExceptionEnum.equals(HotelExceptionEnum.EXCEPTION_IN_VALIDATION)){
                	HotelException helpdeskException = (HotelException) errorArgument;
                	helpdeskException = errorLogService.log(helpdeskException);
                    logger.error(errorArgument);
                }

                HotelError = new HotelError(objectError.getObjectName(), helpdeskExceptionEnum, errorArgument);
                exceptionErrors.add(HotelError);
            }
        }
       
        return ResponseEntity.badRequest().body(exceptionErrors);
    }
    

    @ExceptionHandler(HotelException.class)
    public ResponseEntity<HotelException> handleHelpdeskException(HotelException helpdeskException) {
    	
    	HttpStatus status = resolveAnnotatedResponseStatus(helpdeskException);
    	if(status.equals(HttpStatus.INTERNAL_SERVER_ERROR)) {
    		helpdeskException = errorLogService.log(helpdeskException);
            logger.error(helpdeskException);
    	}
    	
    	return ResponseEntity.status(status).body(helpdeskException);   		    		
    }
 
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<AccessDeniedException> handleAccessDeniedException(AccessDeniedException accessDeniedException) {
    	logger.error(accessDeniedException);
    	return ResponseEntity.status(HttpStatus.FORBIDDEN).build();    
    }
    
    @ExceptionHandler( HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<HotelException> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException httpRequestMethodNotSupportedException) {
    	return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();    
    }
    
    
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<HotelException> handleJsonParseException(HttpMessageNotReadableException httpMessageNotReadableException) {
    	MalformedHttpRequestException malformedHttpRequestException = new MalformedHttpRequestException(httpMessageNotReadableException.getMessage());
    	HttpStatus status = resolveAnnotatedResponseStatus(malformedHttpRequestException);
    	return ResponseEntity.status(status).body(malformedHttpRequestException);    
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<HotelException> handleException(Exception exception) {
    	HotelException helpdeskException = new  HotelInternalException(exception);
    	helpdeskException = errorLogService.log(helpdeskException);
        logger.error(helpdeskException);
        HttpStatus status = resolveAnnotatedResponseStatus(helpdeskException);
    	return ResponseEntity.status(status).body(helpdeskException);   		  
    }
    
    private HttpStatus resolveAnnotatedResponseStatus(Exception exception) {
        ResponseStatus annotation = findMergedAnnotation(exception.getClass(), ResponseStatus.class);
        if (annotation != null) {
            return annotation.value();
        }
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }

}
