package br.com.vaccine.vaccine.resources;

import br.com.vaccine.vaccine.domain.Pessoa;
import br.com.vaccine.vaccine.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
@CrossOrigin(origins={"http://localhost:3000"})
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping
    public List<Pessoa> listar(){
        return pessoaRepository.findAll();
    }

    @PostMapping
    public Pessoa cadastrar(@RequestBody Pessoa pessoa){
        Pessoa pessoaCadastrada = pessoaRepository.save(pessoa);
        pessoaCadastrada.setVacinada(false);
        return pessoaRepository.save(pessoaCadastrada);
    }

    @PutMapping("/{codigo}")
    public Pessoa atualizar(@PathVariable ("codigo") Long codigo, @RequestBody Pessoa pessoa){

        System.out.println(pessoa.getVacinada());

        return pessoaRepository.findById(codigo).map(
                pess -> {
                    pess.setCpf(pessoa.getCpf());
                    pess.setDataNascimento(pessoa.getDataNascimento());
                    pess.setEmail(pessoa.getEmail());
                    pess.setIdade(pessoa.getIdade());
                    pess.setNome(pessoa.getNome());
                    pess.setTelefone(pessoa.getTelefone());
                    pess.setVacinada(pessoa.getVacinada());
                    pess.setEndereco(pessoa.getEndereco());
                    pess.setGruposPrioridades(pessoa.getGruposPrioridades());
                    return pessoaRepository.save(pess);
                }).orElse(null);
    }

    @GetMapping("/{codigo}")
    public Pessoa buscarPeloCodigo(@PathVariable ("codigo") Long codigo){
        return pessoaRepository.findById(codigo).orElse(null);
    }
}
