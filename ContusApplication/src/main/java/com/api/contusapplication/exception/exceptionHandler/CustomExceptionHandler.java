package com.api.contusapplication.exception.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.api.contusapplication.exception.DataNotFoundException;
import com.api.contusapplication.exception.DatabaseException;
import com.api.contusapplication.exception.InvalidUserDataException;
import com.api.contusapplication.exception.ProjectNotFoundException;
import com.api.contusapplication.exception.UserAlreadyExistsException;
import com.api.contusapplication.exception.UserNotFoundException;

@ControllerAdvice
public class CustomExceptionHandler {

    /**
     * Handles the UserAlreadyExistsException by creating an ErrorResponse object with the exception message and
     * HttpStatus.CONFLICT value. It then returns a ResponseEntity with the ErrorResponse object and HttpStatus.CONFLICT.
     *
     * @param  e  the UserAlreadyExistsException to handle
     * @return    a ResponseEntity with the ErrorResponse object and HttpStatus.CONFLICT
     */
    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleUserAlreadyExistsException(UserAlreadyExistsException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), HttpStatus.CONFLICT.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    /**
     * Handles the InvalidUserDataException by creating an ErrorResponse object with the exception message and
     * HttpStatus.BAD_REQUEST value. It then returns a ResponseEntity with the ErrorResponse object and HttpStatus.BAD_REQUEST.
     *
     * @param  e  the InvalidUserDataException to handle
     * @return    a ResponseEntity with the ErrorResponse object and HttpStatus.BAD_REQUEST
     */
    @ExceptionHandler(InvalidUserDataException.class)
    public ResponseEntity<ErrorResponse> handleInvalidUserDataException(InvalidUserDataException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handles the DatabaseException by creating an ErrorResponse object with the exception message and
     * HttpStatus.INTERNAL_SERVER_ERROR value. It then returns a ResponseEntity with the ErrorResponse object and HttpStatus.INTERNAL_SERVER_ERROR.
     *
     * @param  e  the DatabaseException to handle
     * @return    a ResponseEntity with the ErrorResponse object and HttpStatus.INTERNAL_SERVER_ERROR
     */
    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<ErrorResponse> handleDatabaseException(DatabaseException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Handles the DataNotFoundException by creating an ErrorResponse object with the exception message and
     * HttpStatus.NOT_FOUND value. It then returns a ResponseEntity with the ErrorResponse object and HttpStatus.NOT_FOUND.
     *
     * @param  e  the DataNotFoundException to handle
     * @return    a ResponseEntity with the ErrorResponse object and HttpStatus.NOT_FOUND
     */
    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleDataNotFoundException(DataNotFoundException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    /**
     * Handles the UserNotFoundException by creating an ErrorResponse object with the exception message and
     * HttpStatus.NOT_FOUND value. It then returns a ResponseEntity with the ErrorResponse object and HttpStatus.NOT_FOUND.
     *
     * @param  e  the UserNotFoundException to handle
     * @return    a ResponseEntity with the ErrorResponse object and HttpStatus.NOT_FOUND
     */
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    /**
     * Handles the ProjectNotFoundException by creating an ErrorResponse object with the exception message and
     * HttpStatus.NOT_FOUND value. It then returns a ResponseEntity with the ErrorResponse object and HttpStatus.NOT_FOUND.
     *
     * @param  e  the ProjectNotFoundException to handle
     * @return    a ResponseEntity with the ErrorResponse object and HttpStatus.NOT_FOUND
     */
    @ExceptionHandler(ProjectNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleProjectNotFoundException(ProjectNotFoundException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    /**
     * Handles any unhandled exceptions by creating an ErrorResponse object with the exception message
     * and HttpStatus.INTERNAL_SERVER_ERROR value. It then returns a ResponseEntity with the ErrorResponse
     * object and HttpStatus.INTERNAL_SERVER_ERROR.
     *
     * @param  e  the exception to handle
     * @return    a ResponseEntity with the ErrorResponse object and HttpStatus.INTERNAL_SERVER_ERROR
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        ErrorResponse errorResponse = new ErrorResponse("An unexpected error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
