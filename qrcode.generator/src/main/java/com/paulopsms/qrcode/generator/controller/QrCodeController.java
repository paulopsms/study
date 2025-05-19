package com.paulopsms.qrcode.generator.controller;

import com.paulopsms.qrcode.generator.dto.qrcode.QrCodeGenerateRequest;
import com.paulopsms.qrcode.generator.dto.qrcode.QrCodeGenerateResponse;
import com.paulopsms.qrcode.generator.service.QrCodeGeneratorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/qrcode")
public class QrCodeController {

    private static final Logger log = LoggerFactory.getLogger(QrCodeController.class);
    private final QrCodeGeneratorService qrCodeGeneratorService;

    public QrCodeController(QrCodeGeneratorService qrCodeGeneratorService) {
        this.qrCodeGeneratorService = qrCodeGeneratorService;
    }

    @PostMapping("/generate")
    public ResponseEntity<QrCodeGenerateResponse> generateQrCode(@RequestBody QrCodeGenerateRequest request) {
        try {
            QrCodeGenerateResponse qrCodeGenerateResponse = this.qrCodeGeneratorService.generateQrCode(request.text());

            return ResponseEntity.ok(qrCodeGenerateResponse);
        } catch (Exception e) {
            log.error("exception: ", e);
            return ResponseEntity.internalServerError().build();
        }
    }
}
