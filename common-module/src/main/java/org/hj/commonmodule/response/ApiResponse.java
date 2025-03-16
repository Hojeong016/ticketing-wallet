package org.hj.commonmodule.response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *3/16
 */
public record ApiResponse<T>(
        HttpStatus status,
        String message,
        T data
) {

    public static <T> ResponseEntity<ApiResponse<T>> success(ResponseStatus successCode) {
        return ResponseEntity.status(successCode.getHttpStatus())
                .body(new ApiResponse<>(successCode.getHttpStatus()
                        , successCode.getMessage()
                        , null));
    }

    public static <T> ResponseEntity<ApiResponse<T>> success(ResponseStatus successCode,T data) {
        return ResponseEntity.status(successCode.getHttpStatus())
                .body(new ApiResponse<>(successCode.getHttpStatus()
                        , successCode.getMessage()
                        , data));
    }

}


