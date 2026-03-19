package br.com.intercomex.api_resumeDescricao.services;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class DescricaoService {
    @Value("${gemini.api.key}")
    private String myApiKey;

    public String resumirDescricao(String descricao){

        // Configuramos o cliente para usar a chave manual em vez da variável de ambiente
        Client client = Client.builder()
                .apiKey(myApiKey)
                .build();

        GenerateContentResponse response =
                client.models.generateContent(
                        "gemini-3-flash-preview",
                        "Preciso que voce faça um resumo em poucas palavras da descrição a seguir, gerar apenas o resumo, não fale mais nada, e gere apenas um resumo " + descricao,
                        null);

        System.out.println(response.text());
        return response.text();

    }
}
