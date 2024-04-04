package com.Gerenciamento.Petshop.model;

import jakarta.persistence.*;

@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo;

    private String nome;

    private int idade;
    private String raca;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente tutor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Cliente getTutor() {
        return tutor;
    }

    public void setTutor(Cliente tutor) {
        this.tutor = tutor;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + idade;
        result = prime * result + ((raca == null) ? 0 : raca.hashCode());
        result = prime * result + ((tutor == null) ? 0 : tutor.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Animal other = (Animal) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (tipo == null) {
            if (other.tipo != null)
                return false;
        } else if (!tipo.equals(other.tipo))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (idade != other.idade)
            return false;
        if (raca == null) {
            if (other.raca != null)
                return false;
        } else if (!raca.equals(other.raca))
            return false;
        if (tutor == null) {
            if (other.tutor != null)
                return false;
        } else if (!tutor.equals(other.tutor))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Animal [id=" + id + ", tipo=" + tipo + ", nome=" + nome + ", idade=" + idade + ", raca=" + raca
                + ", tutor=" + tutor + "]";
    }

    public Animal() {
    }

    

}
