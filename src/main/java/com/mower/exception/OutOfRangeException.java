package com.mower.exception;

/**
 * Custom Exception : Out Of Range
 * User: fanfan
 * Date: 13/06/14
 * Time: 23:10
 */
public class OutOfRangeException extends RuntimeException {

    /**
     *
     * @param errorMessage
     */
	public OutOfRangeException(String errorMessage) {
		super(errorMessage);
	}

}
