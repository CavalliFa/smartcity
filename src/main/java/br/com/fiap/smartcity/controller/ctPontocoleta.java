package br.com.fiap.smartcity.controller;

import br.com.fiap.smartcity.model.Pontocoleta;
import br.com.fiap.smartcity.service.sePontocoleta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/pontocoleta"})
public class ctPontocoleta {
    @Autowired
    public sePontocoleta service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> insert(@RequestBody Pontocoleta pontocoleta) {
        Pontocoleta insertPontocoleta = service.insert(pontocoleta);
        return new ResponseEntity<>(insertPontocoleta, HttpStatus.CREATED);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll() {
        List<Pontocoleta> pontocoleta = service.getAll();
        return new ResponseEntity<>(pontocoleta, HttpStatus.OK);
    }
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getId(@PathVariable("id") Long id) {
        return new ResponseEntity<>(service.getId(id), HttpStatus.OK);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@RequestBody Pontocoleta pontocoleta) {
        service.update(pontocoleta);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}