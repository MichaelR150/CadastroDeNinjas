package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
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
    public NinjaDTO criarNinja(NinjaDTO ninjaDTO){

        NinjaModel ninja = new NinjaMapper().map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);

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
