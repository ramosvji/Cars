package com.ramosvji.advices;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.RollbackException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ramosvji.dtos.CarErrorMessagesRestDtoOut;

@ControllerAdvice
public class CarControllerAdvice {
	
	@ResponseBody
	@ExceptionHandler(RollbackException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<CarErrorMessagesRestDtoOut> carNotSaved(RollbackException ex) {
		CarErrorMessagesRestDtoOut carErrorMessagesRestDtoOut = new CarErrorMessagesRestDtoOut();
		Set<ConstraintViolation<?>> violations = ((ConstraintViolationException)ex.getCause()).getConstraintViolations();
		List<String> messages = new ArrayList<String>();
		
		for (ConstraintViolation<?> v : violations) {
			messages.add(v.getMessage());
		}
		
		carErrorMessagesRestDtoOut.setMessages(messages);
		
		return new ResponseEntity<CarErrorMessagesRestDtoOut>(carErrorMessagesRestDtoOut, new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}
	
	@ResponseBody
	@ExceptionHandler(EmptyResultDataAccessException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String emptyResult(EmptyResultDataAccessException e) {
		return "valor vacio";
	}

}
