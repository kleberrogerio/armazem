package br.gov.sp.fatec.armazem;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashSet;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.armazem.entity.Autorizacao;
import br.gov.sp.fatec.armazem.entity.Usuario;
import br.gov.sp.fatec.armazem.repository.AutorizacaoRepository;
import br.gov.sp.fatec.armazem.repository.UsuarioRepository;

@SpringBootTest
@Transactional
@Rollback
class ArmazemApplicationTests {

	@Autowired
	private UsuarioRepository usuarioRepo;

	@Autowired
	private AutorizacaoRepository autorizacaoRepo;


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

	@Test
	void findbyAutorizacoesNomeTest() {
		Autorizacao autorizacao = new Autorizacao();
		autorizacao.setNome("Teste");
		autorizacaoRepo.save(autorizacao);

		Usuario usuario = new Usuario();
		usuario.setNome("Kleber");
		usuario.setEmail("Kleber@Kleber");
		usuario.setSenha("123");
		usuario.setAutorizacoes(new HashSet<Autorizacao>());
		usuario.getAutorizacoes().add(autorizacao);
		usuarioRepo.save(usuario);

		assertFalse(usuarioRepo.findByAutorizacoesNome("Teste").isEmpty());

	}

	@Test
	void findbyUsuariosNomeTest() {
		Autorizacao autorizacao = new Autorizacao();
		autorizacao.setNome("Teste");
		autorizacaoRepo.save(autorizacao);

		Usuario usuario = new Usuario();
		usuario.setNome("Kleber");
		usuario.setEmail("Kleber@Kleber");
		usuario.setSenha("123");
		usuario.setAutorizacoes(new HashSet<Autorizacao>());
		usuario.getAutorizacoes().add(autorizacao);
		usuarioRepo.save(usuario);

		assertFalse(autorizacaoRepo.findByUsuariosNome("Teste").isEmpty());

	}

}
