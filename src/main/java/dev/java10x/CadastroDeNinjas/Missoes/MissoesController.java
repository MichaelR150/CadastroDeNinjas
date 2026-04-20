package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController{

    // POST - Mandar uma requisição para criar missao
    @PostMapping("/criar")
    public String criarMissao(){
        return "Criado com sucesso!";
    }

    // GET - Mandar uma requisição para listar as missoes
    @GetMapping("/listar")
    public String listarMissoes(){
        return "Listado com sucesso!";
    }

    // PUT - Mandar uma requisição para alterar uma missao
    @PutMapping("/alterar")
    public String alterarMissao(){
        return "Alterado com sucesso!";
    }

    // DELETE - Requisição para deletar
    @DeleteMapping("/deletar")
    public String deletarMissao(){
        return "Deletado com sucesso!";
    }

}
