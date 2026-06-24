package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja Criada com sucesso!" + novoNinja.getNome() + " com o ID: " + novoNinja.getId());
    }

    // Mostrar todos os ninjas (READ)
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>>  listarNinjas(){
        List<NinjaDTO> ninjas =  ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    // Procurar ninja por ID (READ)
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarNinjasId(@PathVariable Long id){
        NinjaDTO ninja = (ninjaService.listarNinjasId(id));
        if(ninja != null){
            return ResponseEntity.ok().body(ninja);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja com o ID: " + id + " Não foi encontrado no banco de dados.");
    }

    // Alterar dados dos ninjas (UPDATE)
     @PutMapping("/alterar/{id}")
    public ResponseEntity alterarNinjaPorId(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado){
        NinjaDTO ninja = ninjaService.listarNinjasId(id);
         if (ninja != null) {
             ninjaService.alterarNinjaPorId(id, ninjaAtualizado);
             return ResponseEntity.status(HttpStatus.OK).body("Ninja " + ninja.getNome() + " alterado com sucesso" );
         }
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja com o ID " + id + " não foi encontrado" );
     }

    // Deletar Ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id){
        if(ninjaService.listarNinjasId(id) != null){
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok("Deletado com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("ID " + id + " não encontrado, tente novamente!");
    }

}
