package br.com.vaccine.vaccine.resources;

import br.com.vaccine.vaccine.domain.Pessoa;
import br.com.vaccine.vaccine.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
        return pessoaRepository.save(pessoa);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity atualizar(@PathVariable ("codigo") Long codigo, @RequestBody Pessoa pessoa){
        return pessoaRepository.findById(codigo).map(
                pess -> {
                    pess.setCpf(pessoa.getCpf());
                    pess.setDataNascimento(pessoa.getDataNascimento());
                    pess.setEmail(pessoa.getEmail());
                    pess.setIdade(pessoa.getIdade());
                    pess.setNome(pessoa.getNome());
                    pess.setTelefone(pessoa.getTelefone());
                    pess.setVacinada(pessoa.getVacinada());
                    Pessoa pessoaAtualizada = pessoaRepository.save(pess);
                    return ResponseEntity.ok().body(pessoaAtualizada);
                }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{codigo}")
    public Pessoa buscarPeloCodigo(@PathVariable ("codigo") Long codigo){
        return pessoaRepository.findById(codigo).orElse(null);
    }
}
