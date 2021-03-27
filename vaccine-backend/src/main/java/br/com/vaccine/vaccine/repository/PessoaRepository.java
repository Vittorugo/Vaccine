package br.com.vaccine.vaccine.repository;

import br.com.vaccine.vaccine.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {}
