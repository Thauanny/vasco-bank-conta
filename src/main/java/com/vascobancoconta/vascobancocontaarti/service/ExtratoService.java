package com.vascobancoconta.vascobancocontaarti.service;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vascobancoconta.vascobancocontaarti.models.Extrato;
import com.vascobancoconta.vascobancocontaarti.repository.ExtratoRepository;

@Service
public class ExtratoService {
    @Autowired
    private ExtratoRepository extratoRepository;


    
    public Extrato extratoDia(Integer idConta){
        return new Extrato();
       // return extratoRepository.extratoDia(idConta, LocalDate.now().getDayOfMonth());

    }

    public Extrato extratoMes(Integer idConta){
        return new Extrato();
        //return extratoRepository.extratoMes(idConta, LocalDate.now().getMonthValue());
    }

    public Extrato extratoAno(Integer idConta){
        return new Extrato();
       // return extratoRepository.extratoDia(idConta, LocalDate.now().getYear());
    }
}
