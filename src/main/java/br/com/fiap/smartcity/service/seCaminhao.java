package br.com.fiap.smartcity.service;

import br.com.fiap.smartcity.model.Caminhao;
import br.com.fiap.smartcity.repository.rpCaminhao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class seCaminhao {

    @Autowired
    private rpCaminhao repository;

    public Caminhao insert(Caminhao caminhao) {
        return repository.save(caminhao);
    }

    public List<Caminhao> getAll() {
        return repository.findAll();
    }

    public Caminhao getId(Long id) {
        return repository.findById(id).get();
    }

    public void update(Caminhao caminhao) {
        if(!(this.getId(caminhao.getId())==null)) repository.save(caminhao);
    }

    public void delete(Long id) {
        repository.delete(this.getId(id));
    }

}
