package com.fatec.Leilao.controller;
import com.fatec.Leilao.model.leilao.dto.CriacaoLeilaoDTO;
import com.fatec.Leilao.model.leilao.dto.ExibicaoLeilaoDTO;
import com.fatec.Leilao.service.LeilaoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
