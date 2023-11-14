package com.diazero.incidentAPI.ExceptionHandler;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class ApiErrorMessage {

    private String message;


}
