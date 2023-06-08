package com.vascobancoconta.vascobancocontaarti.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.ForeignKey;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Conta")
@Getter
@Setter
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "conta_id")
    private Integer id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "primeiro_nome")
    private String primeiroNome;
    @Column(name = "agencia")
    private String agencia;
    @Column(name = "numero")
    private String numero;
    @Column(name = "digito")
    private Integer digito;
    @Column(name = "numero_com_digito")
    private String numeroComDigito;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "profissao")
    private String profissao;
    @Column(name = "elegivel_credito")
    private boolean elegivelCredito;
    @Column(name = "saldo")
    private double saldo;
    @OneToMany(cascade=CascadeType.ALL)
    public List<Cheque> cheques;

}
