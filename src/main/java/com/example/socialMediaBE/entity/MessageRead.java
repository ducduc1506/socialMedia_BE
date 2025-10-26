package com.example.socialMediaBE.entity;

import lombok.*;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "message_reads")
@Builder
public class MessageRead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "message_id", nullable = false)
    private Long messageId;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "read_at")
    private LocalDateTime readAt;
}
