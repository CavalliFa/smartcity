package br.com.fiap.smartcity.controller;

import br.com.fiap.smartcity.model.Caminhao;
import br.com.fiap.smartcity.service.seCaminhao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/caminhao"})
public class ctCaminhao {
    @Autowired
    public seCaminhao service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> insert(@RequestBody Caminhao caminhao) {
        Caminhao insertCaminhao = service.insert(caminhao);
        return new ResponseEntity<>(insertCaminhao, HttpStatus.CREATED);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll() {
        List<Caminhao> caminhao = service.getAll();
        return new ResponseEntity<>(caminhao, HttpStatus.OK);
    }
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getId(@PathVariable("id") Long id) {
        return new ResponseEntity<>(service.getId(id), HttpStatus.OK);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@RequestBody Caminhao caminhao) {
        service.update(caminhao);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
