package br.com.intercomex.api_resumeDescricao.controllers;

import br.com.intercomex.api_resumeDescricao.services.DescricaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/descricao")
public class DescricaoController {

    @Autowired
    private DescricaoService descricaoService;

    @PostMapping("/resumir")
    public ResponseEntity<String> resumir(@RequestBody String descricao) {
        if (descricao == null || descricao.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Descrição não pode ser vazia");
        }

        String resumo = descricaoService.resumirDescricao(descricao);
        return ResponseEntity.status(HttpStatus.OK).body(resumo);
    }
}
