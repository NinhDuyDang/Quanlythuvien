package com.example.managerlibrary.service.Imp;

import com.example.managerlibrary.entity.Employee;
import com.example.managerlibrary.service.MailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendEmail(Employee employee) {
        // Tạo đối tượng MimeMessage
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

            // Thiết lập thông tin email
            helper.setSubject("Welcome to the Company!");
            helper.setFrom("ninhduydang2001@gmail.com"); // Địa chỉ email gửi đi
            helper.setTo("ninhduy2000@gmail.com"); // Địa chỉ email người nhận

            // Tạo nội dung email
            String content = "<p>Dear " + employee.getName() + ",</p>"
                    + "<p>Welcome to the company!</p>"
                    + "<p>Your Employee ID is: " + employee.getEmployeeId() + "</p>"
                    + "<p>Age: " + employee.getAge() + "</p>"
                    + "<p>Start Date: " + employee.getStartedDate() + "</p>"
                    + "<p>Type: " + employee.getType() + "</p>"
                    + "<p>We are excited to have you on our team.</p>"
                    + "<p>Best regards,</p>"
                    + "<p>Your Company</p>";

            helper.setText(content, true); // `true` để gửi email dưới dạng HTML

            // Gửi email
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            // Xử lý lỗi với thông báo rõ ràng hơn
            System.err.println("Failed to send email: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
