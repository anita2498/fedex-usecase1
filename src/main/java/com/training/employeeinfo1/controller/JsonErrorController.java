package com.training.employeeinfo1.controller;

import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsonErrorController /* extends HttpServlet */ implements ErrorController {

	@GetMapping("/error")
	// @ResponseBody
	public String handleError(HttpServletRequest request) {
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		Object message = request.getAttribute(RequestDispatcher.ERROR_MESSAGE);
		Object type = request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
		String retval=" ";
		if (status != null) {
			retval = "status =" + status.toString() ; 
			
			if (type !=null) {
				retval += " type =" + type.toString();
			}
			if (message !=null) {
				retval += " message = " +  message.toString();
			}
			//+ " message = " +  message.toString() + " type =" + type.toString();
		}
		return retval ;
	}

	/*
	 * public JsonErrorController(final ErrorAttributes errorAttributes) {
	 * super(errorAttributes); }
	 */

	/*
	 * @SuppressWarnings("deprecation")
	 * 
	 * @GetMapping public ResponseEntity<Map<String, Object>> error(final
	 * HttpServletRequest request) { final Map<String, Object> body =
	 * this.getErrorAttributes(request, false); final HttpStatus status =
	 * this.getStatus(request); //Object status =
	 * request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE); //final HttpStatus
	 * status = this.getErrorAttributes(RequestDispatcher.ERROR_STATUS_CODE); return
	 * new ResponseEntity<>(body, status); }
	 * 
	 * @Override public String getErrorPath() { return "/error"; }
	 */

	/*
	 * @GetMapping("/error")
	 * 
	 * @ResponseBody public String handleError(HttpServletRequest request) {
	 * 
	 * 
	 * Object codeObj, messageObj, typeObj;
	 * 
	 * // Retrieve the three possible error attributes, some may be null codeObj =
	 * request.getAttribute("javax.servlet.error.status_code"); messageObj =
	 * request.getAttribute("javax.servlet.error.message"); typeObj =
	 * request.getAttribute("javax.servlet.error.exception_type");
	 * 
	 * 
	 * //Integer statusCode = (Integer)
	 * request.getAttribute("javax.servlet.error.status_code"); //Exception
	 * exception = (Exception)
	 * request.getAttribute("javax.servlet.error.exception"); //String exception =
	 * (String) request.getAttribute("javax.servlet.error.message"); //String
	 * exception = (String)
	 * request.getAttribute("javax.servlet.error.exception_type");
	 * //System.out.println(exception.toString());
	 * 
	 * return String.
	 * format("<html><body><h2>Error Page</h2><div>Status code: <b>%s</b></div>" +
	 * "<div>Exception Message: <b>%s</b></div><body></html>", statusCode,
	 * exception==null? "N/A": exception);
	 * 
	 * 
	 * return String.
	 * format("<html><body><h2>Error Page</h2><div>Status code: <b>%s</b></div>" +
	 * "<div>Exception Message: <b>%s</b></div><body></html>" +
	 * "<div>Exception Type: <b>%s</b></div><body></html>", codeObj, messageObj,
	 * typeObj);
	 * 
	 * }
	 */

	@Override
	public String getErrorPath() {
		return "/error";
	}

}
