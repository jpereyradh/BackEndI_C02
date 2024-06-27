package com.example.demo.jwt;

import com.example.demo.model.Usuario;
import com.example.demo.model.UsuarioRole;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DatosIniciales implements ApplicationRunner {
    private UsuarioRepository usuarioRepository;

    @Autowired
    public DatosIniciales(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder= new BCryptPasswordEncoder();
        String passSinCifrar= "digital";
        String passCifrado=passwordEncoder.encode(passSinCifrar);
        usuarioRepository.save(new Usuario("Jorgito","admin","admin@admin.com",passCifrado, UsuarioRole.ADMIN));

    }
}
