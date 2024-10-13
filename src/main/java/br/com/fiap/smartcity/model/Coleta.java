package br.com.fiap.smartcity.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "COLETA")
public class Coleta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Date coleta;
    @ManyToOne
    @JoinColumn(name = "caminhaoid", nullable = false)
    private Caminhao caminhao;
    @ManyToOne
    @JoinColumn(name = "pontocoletaid", nullable = false)
    private Pontocoleta pontocoleta;

    public Pontocoleta getPontocoleta() {
        return pontocoleta;
    }

    public void setPontocoleta(Pontocoleta pontocoleta) {
        this.pontocoleta = pontocoleta;
    }

    public Caminhao getCaminhao() {
        return caminhao;
    }

    public void setCaminhao(Caminhao caminhao) {
        this.caminhao = caminhao;
    }

    public Coleta() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getColeta() {
        return coleta;
    }

    public void setColeta(Date coleta) {
        this.coleta = coleta;
    }
}


