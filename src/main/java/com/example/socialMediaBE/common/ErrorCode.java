package com.example.socialMediaBE.common;

public enum ErrorCode {

    SUCCESS(200, "Thành công"),
    CREATED(201, "Tạo mới thành công"),
    BAD_REQUEST(400, "Yêu cầu không hợp lệ"),
    UNAUTHORIZED(401, "Không có quyền truy cập"),
    FORBIDDEN(403, "Bị cấm truy cập"),
    NOT_FOUND(404, "Không tìm thấy"),
    INTERNAL_SERVER_ERROR(500, "Lỗi hệ thống"),

    USERNAME_ALREADY_EXISTS(409, "Username đã tồn tại"),
    EMAIL_ALREADY_EXISTS(409, "Email đã tồn tại"),
    INVALID_CREDENTIALS(401, "Username hoặc password không đúng");

    private final int code;
    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
