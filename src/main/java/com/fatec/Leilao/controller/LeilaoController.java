package com.fatec.Leilao.controller;
import com.fatec.Leilao.model.leilao.dto.CriacaoLeilaoDTO;
import com.fatec.Leilao.model.leilao.dto.ExibicaoLeilaoDTO;
import com.fatec.Leilao.service.LeilaoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("leilao")
@Tag(name = "LEILÃO")
public class LeilaoController {

    @Autowired
    private LeilaoService leilaoService;

    @PostMapping("criar")
    public ExibicaoLeilaoDTO criarLeilao(@RequestBody CriacaoLeilaoDTO criacaoLeilaoDTO){
        return leilaoService.criarLeilao(criacaoLeilaoDTO);
    }

    @GetMapping("listar")
    public List<ExibicaoLeilaoDTO> listarLeiloes (){
        return leilaoService.listarLeiloes();
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarLeilaoPorId (@PathVariable Long id){
        return leilaoService.deletarLeilaoPorId(id);
    }

}
