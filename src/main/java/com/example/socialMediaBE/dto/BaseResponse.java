package com.example.socialMediaBE.dto;

import com.example.socialMediaBE.common.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse<T> {
    private int code;
    private String message;
    private T data;

    // Static factory methods để tạo response dễ dàng hơn
    
    /**
     * Tạo response thành công với data
     */
    public static <T> BaseResponse<T> success(T data) {
        return BaseResponse.<T>builder()
                .code(ErrorCode.SUCCESS.getCode())
                .message(ErrorCode.SUCCESS.getMessage())
                .data(data)
                .build();
    }

    /**
     * Tạo response thành công với message tùy chỉnh
     */
    public static <T> BaseResponse<T> success(String message, T data) {
        return BaseResponse.<T>builder()
                .code(ErrorCode.SUCCESS.getCode())
                .message(message)
                .data(data)
                .build();
    }

    /**
     * Tạo response thành công không có data
     */
    public static <T> BaseResponse<T> success() {
        return BaseResponse.<T>builder()
                .code(ErrorCode.SUCCESS.getCode())
                .message(ErrorCode.SUCCESS.getMessage())
                .build();
    }

    /**
     * Tạo response lỗi với ErrorCode
     */
    public static <T> BaseResponse<T> error(ErrorCode errorCode) {
        return BaseResponse.<T>builder()
                .code(errorCode.getCode())
                .message(errorCode.getMessage())
                .build();
    }

    /**
     * Tạo response lỗi với code và message tùy chỉnh
     */
    public static <T> BaseResponse<T> error(int code, String message) {
        return BaseResponse.<T>builder()
                .code(code)
                .message(message)
                .build();
    }

    /**
     * Tạo response lỗi với ErrorCode và message tùy chỉnh
     */
    public static <T> BaseResponse<T> error(ErrorCode errorCode, String customMessage) {
        return BaseResponse.<T>builder()
                .code(errorCode.getCode())
                .message(customMessage)
                .build();
    }
}
