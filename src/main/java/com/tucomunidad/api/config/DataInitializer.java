package com.tucomunidad.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.security.crypto.password.PasswordEncoder;

import jakarta.annotation.PostConstruct;

@Component
public class DataInitializer {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PasswordEncoder passwordEncoder; // Inyección del PasswordEncoder

    @PostConstruct
    public void initialize() {
        insertCommunities();
        insertUsers();
        insertMeetings();
        insertVotaciones();
        insertChats();
    }

    private void insertUsers() {
        // Cifrado correcto de la contraseña
        String encodedPassword = passwordEncoder.encode("123456");
        jdbcTemplate.update(
            "INSERT INTO usuarios (name, email, password, community_id, door, floor, is_president) VALUES (?, ?, ?, ?, ?, ?, ?)",
            "Alvaro", "alvaro@gmail.com", encodedPassword, 1, "1", "1", true
        );
    }

    private void insertCommunities() {
        String sql = "INSERT INTO comunidades (name, cinema, gym, library, padel, pool) VALUES ('Comunidad Uno', true, false, true, false, true);";
        jdbcTemplate.execute(sql);
        String sql1 = "INSERT INTO comunidades (name, cinema, gym, library, padel, pool) VALUES ('Comunidad Dos', true, false, true, false, true);";
        jdbcTemplate.execute(sql1);
    }

    private void insertMeetings() {
        String sql = "INSERT INTO reuniones (community_id, dia, hora, mes, año, information) VALUES (1, '21', '18:30', 'Mayo', '2024', 'Annual general meeting discussing community improvements and budget allocations.');";
        jdbcTemplate.execute(sql);
        String sql1 = "INSERT INTO reuniones (community_id, dia, hora, mes, año, information) VALUES (1, '21', '18:30', 'Mayo', '2024', 'Annual general meeting discussing community improvements and budget allocations.');";
        jdbcTemplate.execute(sql1);
        String sql2 = "INSERT INTO reuniones (community_id, dia, hora, mes, año, information) VALUES (1, '21', '18:30', 'Mayo', '2024', 'Annual general meeting discussing community improvements and budget allocations.');";
        jdbcTemplate.execute(sql2);
    }

    private void insertVotaciones() {
        String sql = "INSERT INTO votaciones (titulo, informacion, fecha, community_id) VALUES ('Reformas en la piscina', 'Se propone realizar una serie de reformas en la piscina comunitaria para mejorar su seguridad, comodidad y estética. Estas reformas incluyen la renovación del pavimento alrededor de la piscina, la instalación de nuevas duchas y vestuarios, así como la mejora del sistema de filtrado y limpieza del agua. Además, se contempla la posibilidad de añadir nuevas características, como toboganes o zonas de juegos acuáticos, para aumentar el atractivo de la piscina para todos los residentes. ¡Tu opinión es importante para decidir el futuro de nuestras instalaciones comunitarias!', '2024-05-21 18:30:00', 1);";
        jdbcTemplate.execute(sql);
        String sql2 = "INSERT INTO votaciones (titulo, informacion, fecha, community_id) VALUES ('Pintar garaje', 'Se propone realizar una votación para decidir si se debe pintar el garaje comunitario. El garaje es un espacio compartido por todos los residentes y su apariencia juega un papel importante en la impresión general de nuestra comunidad. La pintura actual puede estar desgastada o descolorida, y una nueva capa de pintura podría mejorar significativamente la estética y la calidad general del garaje. La votación determinará si los residentes están de acuerdo en asignar fondos para este proyecto de mejora del garaje comunitario. ¡Tu voto cuenta para decidir el futuro aspecto de nuestro garaje!', '2024-05-22 18:30:00', 1);";
        jdbcTemplate.execute(sql2);
        String sql3 = "INSERT INTO votaciones (titulo, informacion, fecha, community_id) VALUES ('Instalar telefonillo con camaras', 'Esta votación tiene como objetivo decidir si la comunidad desea instalar un telefonillo con cámara en la entrada principal del edificio. La instalación de un telefonillo con cámara proporcionará un nivel adicional de seguridad al permitir a los residentes ver y comunicarse con los visitantes antes de permitirles el acceso al edificio. Este sistema puede ayudar a prevenir la entrada de personas no autorizadas y mejorar la tranquilidad de los residentes.', '2024-05-23 18:30:00', 1);";
        jdbcTemplate.execute(sql3);
    }

    private void insertChats() {
        String sql = "INSERT INTO chats (sender, message, fecha, community_id, titulo) VALUES ('Usuario1', 'Hola vecinosvecinosvecinosvecinosvecinosvecinosvecinosvecinosvecinosvecinosvecinosvecinosvecinosvecinosvecinosvecinosvecinos!', '2022-05-01T10:15:00', 1, 'derrama 1')";
        jdbcTemplate.execute(sql);
        String sql2 = "INSERT INTO chats (sender, message, fecha, community_id, titulo) VALUES ('Usuario2', '¿Alguien para el partido de tenis?', '2022-05-01T12:30:00', 1, 'derrama 2')";
        jdbcTemplate.execute(sql2);

    }

}
