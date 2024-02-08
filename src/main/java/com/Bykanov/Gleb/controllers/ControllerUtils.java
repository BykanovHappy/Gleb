package com.Bykanov.Gleb.controllers;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ControllerUtils {
    static Map<String, String> getErrors(BindingResult bindingResult){
        Collector<FieldError, ?, Map<String, String>> collector = Collectors.toMap(
                fieldError -> fieldError.getField() + "",
                FieldError::getDefaultMessage
        );
        Map<String, String> errorsMap =bindingResult.getFieldErrors().stream().collect( collector );
        return errorsMap;
    }
}
