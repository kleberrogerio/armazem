package br.gov.sp.fatec.armazem;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.armazem.entity.Usuario;
import br.gov.sp.fatec.armazem.repository.UsuarioRepository;

@SpringBootTest
@Transactional
@Rollback
class ArmazemApplicationTests {

	@Autowired
	private UsuarioRepository usuarioRepo;

	@Test
	void contextLoads() {
	}
	
	@Test
	void findbyNomeTest() {
		Usuario usuario = new Usuario();
		usuario.setNome("Kleber");
		usuario.setEmail("kleber@Kleber");
		usuario.setSenha("123");
		usuarioRepo.save(usuario);

		assertNotNull(usuarioRepo.findbyNome("Kleber"));
	}

	
	@Test
	void findbyNomeContainsOrEmailContainsTest() {
		Usuario usuario = new Usuario();
		usuario.setNome("Kleber");
		usuario.setEmail("Kleber@Kleber");
		usuario.setSenha("123");
		usuarioRepo.save(usuario);

		assertFalse(usuarioRepo.findbyNomeContainsOrEmailContains("Kle", "er@").isEmpty());

	}

}
