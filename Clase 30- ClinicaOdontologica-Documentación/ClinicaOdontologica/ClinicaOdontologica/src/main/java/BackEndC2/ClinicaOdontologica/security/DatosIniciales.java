package BackEndC2.ClinicaOdontologica.security;

import BackEndC2.ClinicaOdontologica.entity.Usuario;
import BackEndC2.ClinicaOdontologica.entity.UsuarioRole;
import BackEndC2.ClinicaOdontologica.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DatosIniciales implements ApplicationRunner {
@Autowired
private UsuarioRepository usuarioRepository;
@Autowired
private BCryptPasswordEncoder passwordEncoder;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        String passSinCifrar= "admin";
        String passCifrado= passwordEncoder.encode(passSinCifrar);
        Usuario usuario= new Usuario("jorgito", UsuarioRole.ROLE_USER,passCifrado,"admin@admin.com","jpereyradh");
        System.out.println("pass cifrado: "+passCifrado);
        usuarioRepository.save(usuario);

    }
}
