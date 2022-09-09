package com.api.rest.disney.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private String resourceName;
    private String fieldName;
    private Long fieldValueLong;

    private String fieldValueString;

    private Double fieldValueDouble;

    private Integer fieldValueInteger;

    public ResourceNotFoundException(String resourceName, String fieldName, Long fieldValueLong) {
        super(String.format("%s not found with : %s : '%s'", resourceName, fieldName,fieldValueLong));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValueLong = fieldValueLong;
    }

    public ResourceNotFoundException(String resourceName, String fieldName, String fieldValueString) {
        super(String.format("%s not found with : %s : '%s'", resourceName, fieldName,fieldValueString));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValueString = fieldValueString;
    }

    public ResourceNotFoundException(String resourceName, String fieldName, Double fieldValueDouble) {
        super(String.format("%s not found with : %s : '%s'", resourceName, fieldName,fieldValueDouble));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValueDouble = fieldValueDouble;
    }

    public ResourceNotFoundException(String resourceName, String fieldName, Integer fieldValueInteger) {
        super(String.format("%s not found with : %s : '%s'", resourceName, fieldName,fieldValueInteger));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValueInteger = fieldValueInteger;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Long getFieldValueLong() {
        return fieldValueLong;
    }

    public void setFieldValueLong(Long fieldValueLong) {
        this.fieldValueLong = fieldValueLong;
    }

    public String getFieldValueString() {
        return fieldValueString;
    }

    public void setFieldValueString(String fieldValueString) {
        this.fieldValueString = fieldValueString;
    }

    public Double getFieldValueDouble() {
        return fieldValueDouble;
    }

    public void setFieldValueDouble(Double fieldValueDouble) {
        this.fieldValueDouble = fieldValueDouble;
    }

    public Integer getFieldValueInteger() {
        return fieldValueInteger;
    }

    public void setFieldValueInteger(Integer fieldValueInteger) {
        this.fieldValueInteger = fieldValueInteger;
    }
}
