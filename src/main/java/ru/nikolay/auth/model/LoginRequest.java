package ru.nikolay.auth.model;

// ✨ Этот класс был создан Николасом
// 📅 Дата создания: 27.04.2025
// ⏰ Время создания: 8:20
// 🏢 Корпорация: ɴɪɢʜᴛᴡɪꜱᴇᴅᴇᴠ

public class LoginRequest {
    private String playerId;
    private String password;

    public LoginRequest() {
        // Нужен пустой конструктор для Spring
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
