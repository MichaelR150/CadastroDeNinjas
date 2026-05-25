package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    // Listar todos os ninjas
    public List<NinjaModel> listarNinjas(){
        return ninjaRepository.findAll();
    }

    // Listar por ID
    public NinjaModel listarNinjasId(Long id){
        Optional<NinjaModel> ninja = ninjaRepository.findById(id);
        return ninja.orElse(null);
    }

    // Criar um novo ninja
    public NinjaModel criarNinja(NinjaModel ninja){
        return ninjaRepository.save(ninja);
    }

    // Deletar ninja por Id

    public void deletarNinjaPorId(Long id) {
        if(!ninjaRepository.existsById(id)){
            throw new RuntimeException("Usuário nao encontrado!");
        }
        ninjaRepository.deleteById(id);
    }

    // Atualizar ninja por Id

    public NinjaModel alterarNinjaPorId(Long id, NinjaModel ninja) {
        NinjaModel ninjaAtualizado = ninjaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));

        ninjaAtualizado.setNome(ninja.getNome());
        ninjaAtualizado.setEmail(ninja.getEmail());
        ninjaAtualizado.setIdade(ninja.getIdade());
        ninjaAtualizado.setMissoes(ninja.getMissoes());
        return ninjaRepository.save(ninjaAtualizado);
    }



}
