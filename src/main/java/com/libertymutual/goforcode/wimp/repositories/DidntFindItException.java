package com.libertymutual.goforcode.wimp.repositories;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No such Order")


public class DidntFindItException extends Exception {
	private static final long serialVersionUID = 1L;
	

}
