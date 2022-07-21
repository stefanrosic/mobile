package com.mobile.service.dto.response;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ErrorResponse {

    String message;
}
