package com.vascobancoconta.vascobancocontaarti.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.ForeignKey;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cheque")
@Getter
@Setter
public class Cheque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cheque_id")
    private Integer id;
    @Column(name = "valoe")
    private double valor;
    @Column(name = "limite")
    private double limite;
    @Column(name = "juros")
    private double juros;
    @Column(name = "valor_extenso")
    private String valorExtenso;
    @Column(name = "data_atual")
    private String dataAtual;
    @Column(name = "nome")
    private String nome;
    @Column(name = "numero")
    private String numero;
    @Column(name = "serie")
    private String serie;
    @Column(name = "data_entrada")
    private String dataEntrada;
    @ManyToOne
    @JoinColumn(name="conta_id")
    public Conta conta;
   

}
