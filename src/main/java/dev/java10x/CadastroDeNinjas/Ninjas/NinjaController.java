package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota";
    }

    // Adicionar ninja (CREATE)
    @PostMapping("/criar")
    public String criarNinja(){
        return "Criado com sucesso!";
    }

    // Mostrar todos os ninjas (READ)
    @GetMapping("/listar")
    public String mostrarTodosOsNinjas(){
        return "Lista de Ninjas";
    }

    // Procurar ninja por ID (READ)
    @GetMapping("/listarID")
    public String mostrarTodosOsNinjasPorId(){
        return "Lista de Ninjas por ID";
    }

    // Alterar dados dos ninjas (UPDATE)
     @PutMapping("/alterarID")
    public String alterarNinjaPorId(){
        return "Alterado com sucesso!";
     }

    // Deletar Ninja (DELETE)
    @DeleteMapping("/deletarID")
    public String deletarNinjaPorId(){
        return "Deletado com sucesso!";
    }

}
