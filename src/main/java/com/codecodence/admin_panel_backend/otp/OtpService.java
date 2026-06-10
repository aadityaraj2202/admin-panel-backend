package com.codecodence.admin_panel_backend.otp;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codecodence.admin_panel_backend.service.EmailService;

@Service
public class OtpService {

    // 🔐 Temporary OTP storage (email → otp)
    private Map<String, String> otpStorage = new HashMap<>();

    @Autowired
    private EmailService emailService;

    // ✅ SEND OTP (EMAIL)
    public void sendOtp(String email) {

        // Generate 6-digit OTP
        String otp = String.valueOf(100000 + new Random().nextInt(900000));

        // Save OTP
        otpStorage.put(email, otp);

        // Send email
        emailService.sendEmail(
                email,
                "Code Codence OTP Verification",
                "Your OTP is: " + otp + "\n\nDo not share this with anyone."
        );

        System.out.println("OTP for " + email + " 👉 " + otp);
    }

    // ✅ VERIFY OTP
    public boolean verifyOtp(String email, String otp) {

        String storedOtp = otpStorage.get(email);

        if (storedOtp != null && storedOtp.equals(otp)) {
            otpStorage.remove(email); // 🔥 remove after success (important)
            return true;
        }

        return false;
    }
}