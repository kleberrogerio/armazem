package br.gov.sp.fatec.armazem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.armazem.entity.Usuario;
import br.gov.sp.fatec.armazem.service.SegurancaService;

@RestController
@CrossOrigin
@RequestMapping(value="/usuario")
public class UsuarioController{

    @Autowired
    private SegurancaService segurancaService;

    @GetMapping
    public List<Usuario> buscarTodosUsuarios(){
        return segurancaService.buscarTodosUsuarios();
    }


}