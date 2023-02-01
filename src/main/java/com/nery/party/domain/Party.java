package com.nery.party.domain;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Party implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "O título não pode estar vazio!")
    @Length(min = 5, max = 100, message = "O campo deve ter entre 5 e 100 caracteres!")
    private String title;

    @NotEmpty(message = "O campo autor é obrigatório")
    @Length(min = 5, max = 100, message = "O campo autor deve ter entre 5 e 100 caracteres!")
    private String author;

    @Length(min = 10, max = 255, message = "O campo descrição deve ter entre 10 e 255 caracteres!")
    private String descricao;

    private Float budget;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "servico_id")
    private Servico servico;

    public Party() {
        super();
    }

    public Party(Integer id, String title, String author, String descricao, Float budget, Servico servico) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.descricao = descricao;
        this.budget = budget;
        this.servico = servico;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Float getBudget() {
        return budget;
    }

    public void setBudget(Float budget) {
        this.budget = budget;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        Party other = (Party) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}