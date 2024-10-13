package br.com.fiap.smartcity.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "CAMINHAO")
public class Caminhao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    @Column(nullable = false)
    private String motorista;
    @Column(nullable = false)
    private String placa;
    private String capacidade;
    @OneToMany(mappedBy = "coleta")
    private List<Coleta> coleta;

    public List<Coleta> getColeta() {
        return coleta;
    }

    public void setColeta(List<Coleta> coleta) {
        this.coleta = coleta;
    }

    public Caminhao() {
    }

    public Caminhao(String descricao, String motorista, String placa, String capacidade) {
        this.descricao = descricao;
        this.motorista = motorista;
        this.placa = placa;
        this.capacidade = capacidade;
    }

    public Caminhao(Long id, String descricao, String motorista, String placa, String capacidade) {
        this.id = id;
        this.descricao = descricao;
        this.motorista = motorista;
        this.placa = placa;
        this.capacidade = capacidade;

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMotorista() {
        return motorista;
    }

    public void setMotorista(String motorista) {
        this.motorista = motorista;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(String capacidade) {
        this.capacidade = capacidade;
    }



}

