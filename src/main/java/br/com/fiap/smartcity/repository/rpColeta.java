package br.com.fiap.smartcity.repository;

import br.com.fiap.smartcity.model.Coleta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface rpColeta extends JpaRepository<Coleta, Long> {
}