package com.example.managerlibrary.controller;

import com.example.managerlibrary.dto.NotificationMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ChatController {

    private final SimpMessagingTemplate messagingTemplate;

    // Danh sách để lưu trữ các thông báo đã gửi
    private final List<NotificationMessage> messages = new ArrayList<>();

    /**
     * Registers a user for chat.
     *
     * param chatMessage The chat message containing the sender's information.
     * param headerAccessor The SimpMessageHeaderAccessor object used to access session attributes.
     * return The registered chat message.
     */
    @PostMapping("/api/chat/register")
    public NotificationMessage register(@RequestBody NotificationMessage chatMessage,
                                        @RequestHeader(value = "username", required = false) String username) {
        if (username != null) {
            // Tạo một SimpMessageHeaderAccessor thủ công nếu cần
            messagingTemplate.convertAndSend("/topic/public", chatMessage);
        }
        // Lưu trữ thông báo vào danh sách
        messages.add(chatMessage);
        return chatMessage;
    }


    /**
     * Sends a chat message to all connected users.
     *
     * param chatMessage The chat message to be sent.
     * return The sent chat message.
     */
    @PostMapping("/api/chat/send")
    public NotificationMessage sendMessage(@RequestBody NotificationMessage chatMessage) {
        messagingTemplate.convertAndSend("/topic/public", chatMessage);
        // Lưu trữ thông báo vào danh sách
        messages.add(chatMessage);
        return chatMessage;
    }

    /**
     * Retrieves all chat messages that have been sent.
     *
     * return The list of all sent chat messages.
     */
    @GetMapping("/api/chat/messages")
    public List<NotificationMessage> getAllMessages() {
        return messages;
    }
}
