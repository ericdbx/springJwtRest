package com.dbx.meu_primeiro_springboot.repository;

import org.springframework.stereotype.Repository;

@Repository
public class MensagemRepository {

    public String obterMensagem() {
        return "Olá repository";
    }
    
}
