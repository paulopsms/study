package com.paulopsms.qrcode.generator.dto.qrcode;

public record QrCodeGenerateRequest(String text) {
    public QrCodeGenerateRequest {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Text cannot be null or empty");
        }
    }
}
