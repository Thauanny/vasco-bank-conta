package com.vascobancoconta.vascobancocontaarti.models.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ValorChequeDTO {
    Integer idCheque;
    double valor;
}
