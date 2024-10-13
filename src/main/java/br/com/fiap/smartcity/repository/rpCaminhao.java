package br.com.fiap.smartcity.repository;

import br.com.fiap.smartcity.model.Caminhao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface rpCaminhao extends JpaRepository<Caminhao, Long> {
}
