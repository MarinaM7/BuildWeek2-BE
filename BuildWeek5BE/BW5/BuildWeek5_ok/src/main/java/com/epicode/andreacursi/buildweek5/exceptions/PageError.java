package com.epicode.andreacursi.buildweek5.exceptions;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PageError {
	private String message;
	private HttpStatus status;
}
