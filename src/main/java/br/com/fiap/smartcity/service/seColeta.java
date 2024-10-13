package br.com.fiap.smartcity.service;

import br.com.fiap.smartcity.model.Coleta;
import br.com.fiap.smartcity.repository.rpColeta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class seColeta {

    @Autowired
    private rpColeta repository;

    public Coleta insert(Coleta coleta) {
        return repository.save(coleta);
    }

    public List<Coleta> getAll() {
        return repository.findAll();
    }

    public Coleta getId(Long id) {
        return repository.findById(id).get();
    }

    public void update(Coleta coleta) {
        if(!(this.getId(coleta.getId())==null)) repository.save(coleta);
    }

    public void delete(Long id) {
        repository.delete(this.getId(id));
    }

}
