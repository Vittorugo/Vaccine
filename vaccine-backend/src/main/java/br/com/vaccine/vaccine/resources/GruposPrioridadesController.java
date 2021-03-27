package br.com.vaccine.vaccine.resources;

import br.com.vaccine.vaccine.domain.GruposPrioridades;
import br.com.vaccine.vaccine.repository.GruposPrioritariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grupos-prioridades")
public class GruposPrioridadesController {

    @Autowired
    private GruposPrioritariosRepository gruposPrioritariosRepository;

    @GetMapping
    public List<GruposPrioridades> listarTodos(){
        return gruposPrioritariosRepository.findAll();
    }

    @GetMapping("/{codigo}")
    public GruposPrioridades buscarPeloCodigo(@PathVariable Long codigo){
        return gruposPrioritariosRepository.findById(codigo).orElse(null);
    }

}
