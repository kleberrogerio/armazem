package br.gov.sp.fatec.armazem.service;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.armazem.entity.Autorizacao;
import br.gov.sp.fatec.armazem.entity.Usuario;
import br.gov.sp.fatec.armazem.repository.AutorizacaoRepository;
import br.gov.sp.fatec.armazem.repository.UsuarioRepository;

@Service
public class SegurancaServiceImpl implements SegurancaService {

    @Autowired
    UsuarioRepository usuarioRepo;

    @Autowired
    AutorizacaoRepository autorizacaoRepo;

    @Transactional
    public Usuario cadastrarUsuario(String nome, String email,String senha, String autorizacao){
        Autorizacao aut = autorizacaoRepo.findByAutorizacoesNome(autorizacao);
        if (aut==null){
            aut = new Autorizacao();   
            aut.setNome(autorizacao);
            autorizacaoRepo.save(aut);
        }

        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenha(senha);
        usuario.setAutorizacoes(new HashSet<Autorizacao>());
        usuario.getAutorizacoes().add(aut);
        usuarioRepo.save(usuario);

        return usuario;
    }

    public List<Usuario> buscarTodosUsuarios(){

        return usuarioRepo.findAll();
        
    }
    
}
