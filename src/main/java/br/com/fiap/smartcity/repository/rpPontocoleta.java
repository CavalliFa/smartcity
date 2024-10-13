package br.com.fiap.smartcity.repository;

import br.com.fiap.smartcity.model.Pontocoleta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface rpPontocoleta extends JpaRepository<Pontocoleta, Long> {
}