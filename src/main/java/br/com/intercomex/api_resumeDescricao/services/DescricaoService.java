package br.com.intercomex.api_resumeDescricao.services;

import org.springframework.stereotype.Service;

@Service
public class DescricaoService {
    public String resumirDescricao(String descricao){
        System.out.println("Descrição recebida: " + descricao);
        descricao = "Teste de Descrição";
        return descricao;
    }
}
