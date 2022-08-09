package com.projectBasic.JVBasicCourse.service.exceptions;

public class ResourceNotFoundException extends RuntimeException { //exceção que o compilador não me obirga a tratar
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(Object id){
        super("Resource not found. Id "+ id);
    }
}