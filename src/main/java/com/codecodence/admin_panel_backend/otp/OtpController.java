package com.codecodence.admin_panel_backend.otp;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.codecodence.admin_panel_backend.security.JwtUtil;

@RestController
@RequestMapping("/api/otp")
@CrossOrigin(origins = "http://localhost:3000")
public class OtpController {

    private final OtpService otpService;
    private final JwtUtil jwtUtil;

    public OtpController(OtpService otpService, JwtUtil jwtUtil) {
        this.otpService = otpService;
        this.jwtUtil = jwtUtil;
    }

    // ✅ SEND OTP (EMAIL)
    @PostMapping("/send")
    public ResponseEntity<?> sendOtp(@RequestBody Map<String, String> body) {

        String email = body.get("email"); // 🔥 FIXED

        otpService.sendOtp(email); // 🔥 email pass

        return ResponseEntity.ok(
                Map.of(
                        "success", true,
                        "message", "OTP_SENT"
                )
        );
    }

    // ✅ VERIFY OTP (EMAIL)
    @PostMapping("/verify")
    public ResponseEntity<?> verifyOtp(@RequestBody Map<String, String> body) {

        String email = body.get("email"); // 🔥 FIXED
        String otp = body.get("otp");

        boolean verified = otpService.verifyOtp(email, otp); // 🔥 FIXED

        if (!verified) {
            return ResponseEntity.badRequest().body(
                    Map.of(
                            "success", false,
                            "message", "INVALID_OTP"
                    )
            );
        }

        // ✅ Token generate using email
        String token = jwtUtil.generateToken(email);

        return ResponseEntity.ok(
                Map.of(
                        "success", true,
                        "token", token
                )
        );
    }
}