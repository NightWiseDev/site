    package ru.nikolay.auth.repository;

    // ✨ Этот класс был создан Николасом
    // 📅 Дата создания: 26.04.2025
    // ⏰ Время создания: 2:36
    // 🏢 Корпорация: ɴɪɢʜᴛᴡɪꜱᴇᴅᴇᴠ

    import org.springframework.data.jpa.repository.JpaRepository;
    import ru.nikolay.auth.model.Auth;

    public interface AuthRepository extends JpaRepository<Auth,Integer> {

        Auth findByPlayerId(String playerId);

    }
