package ru.nikolay.auth.model;

// ✨ Этот класс был создан Николасом
// 📅 Дата создания: 26.04.2025
// ⏰ Время создания: 2:26
// 🏢 Корпорация: ɴɪɢʜᴛᴡɪꜱᴇᴅᴇᴠ

import jakarta.persistence.*;

@Entity
@Table(name = "mc_auth_accounts")

public class Auth {
    @Id
    private int id;

    @Column(name = "player_id")
    private String playerId; //Имя аккаунта

    @Column(name = "password_hash")
    private String passwordHash; //bcrypt

    public Auth() {
        // Для JPA
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public String getPlayerId() {
        return playerId;
    }
}

