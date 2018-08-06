package kr.or.ddit.mvc.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)   // public enum HttpStatus  이용
public class NoFileException extends Exception {

}
