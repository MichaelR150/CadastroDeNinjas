package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService){
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota";
    }

    // Adicionar ninja (CREATE)
    @PostMapping("/criar")
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja){
        return ninjaService.criarNinja(ninja);
    }

    // Mostrar todos os ninjas (READ)
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas(){
        return ninjaService.listarNinjas();
    }

    // Procurar ninja por ID (READ)
    @GetMapping("/listar/{id}")
    public Optional<NinjaModel> listarNinjasId(@PathVariable Long id){
        return Optional.ofNullable(ninjaService.listarNinjasId(id));
    }

    // Alterar dados dos ninjas (UPDATE)
     @PutMapping("/alterar/{id}")
    public ResponseEntity<NinjaModel> alterarNinjaPorId(@PathVariable Long id, @RequestBody NinjaModel ninja){
        NinjaModel ninjaAtualizado = ninjaService.alterarNinjaPorId(id, ninja);
        return ResponseEntity.ok().body(ninjaAtualizado);
     }

    // Deletar Ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id){
        ninjaService.deletarNinjaPorId(id);
        return ResponseEntity.ok("Deletado com sucesso!");
    }

}
