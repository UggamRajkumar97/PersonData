package com.example.Advise;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.Exception.PersonException;

@RestControllerAdvice
public class ExceptionHandle { 

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(PersonException.class)
	public Map<String, String> getByIdEx(PersonException Excep ) {
	Map<String, String> map=new HashMap<String, String>();
	map.put("Error", Excep.getMessage()); 
		
	 return map; 
		
	}
	
}
