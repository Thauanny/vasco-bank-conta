package com.vascobancoconta.vascobancocontaarti.models;

import com.vascobancoconta.vascobancocontaarti.models.enums.OPERACAO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Extrato")
@Getter
@Setter
public class Extrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "extrato_id")
    private Integer id;
    @Column(name = "dia")
    private String dia;
    @Column(name = "mes")
    private String mes;
    @Column(name = "ano")
    private String ano;
    @Enumerated(EnumType.STRING)
    @Column(name = "operacao")
    private OPERACAO operacao;
    @OneToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name = "conta_id", referencedColumnName = "conta_id", foreignKey = @ForeignKey(name = "fk_conta_id"))
    private Conta contaId;

}
