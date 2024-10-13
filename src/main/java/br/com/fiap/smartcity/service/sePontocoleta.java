package br.com.fiap.smartcity.service;

import br.com.fiap.smartcity.model.Pontocoleta;
import br.com.fiap.smartcity.repository.rpPontocoleta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class sePontocoleta {

    @Autowired
    private rpPontocoleta repository;

    public Pontocoleta insert(Pontocoleta pontocoleta) {
        return repository.save(pontocoleta);
    }

    public List<Pontocoleta> getAll() {
        return repository.findAll();
    }

    public Pontocoleta getId(Long id) {
        return repository.findById(id).get();
    }

    public void update(Pontocoleta pontocoleta) {
        if(!(this.getId(pontocoleta.getId())==null)) repository.save(pontocoleta);
    }

    public void delete(Long id) {
        repository.delete(this.getId(id));
    }

}

