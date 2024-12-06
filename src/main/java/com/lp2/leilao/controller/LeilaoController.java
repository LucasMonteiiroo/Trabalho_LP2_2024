package com.lp2.leilao.controller;

import com.lp2.leilao.model.dto.leilao.CadastroLeilaoDTO;
import com.lp2.leilao.model.dto.leilao.ExibicaoLeilaoCriadoDTO;
import com.lp2.leilao.model.dto.leilao.ExibicaoLeilaoDTO;
import com.lp2.leilao.model.enums.CategoriaProduto;
import com.lp2.leilao.service.LeilaoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "leilao")
@CrossOrigin("*")
@Tag(name = "LEILÃO")

public class LeilaoController {

    @Autowired
    private LeilaoService leilaoService;

    @PostMapping("/criar")
    public ExibicaoLeilaoCriadoDTO criarLeilao (@RequestBody CadastroLeilaoDTO leilao){
        return leilaoService.criarNovoLeilao(leilao);
    }

    @GetMapping("/detalhamento/{id}")
    public Object consultarLeilaoPorId(@PathVariable Long id){
        return leilaoService.consultarLeilaoPorId(id);
    }

    @GetMapping("/buscar-produtos/{idLeilao}")
    public Object buscarProdutos(@PathVariable Long idLeilao,
                                                           @RequestParam(required = false) Double valorMinimo,
                                                           @RequestParam(required = false) Double valorMaximo,
                                                           @RequestParam(required = false) Double valorMinimoLance,
                                                           @RequestParam(required = false) Double valorMaximoLance,
                                                           @RequestParam(required = false) String palavraChave,
                                                           @RequestParam CategoriaProduto categoriaProduto){
        return leilaoService.buscarProdutos(idLeilao,valorMinimo,valorMaximo,valorMinimoLance,valorMaximoLance,palavraChave,categoriaProduto);
    }
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarLeilaoPorId (@PathVariable Long id){
        return leilaoService.deletarLeilaoPorId(id);
    }

    @GetMapping("listar")
    public List<ExibicaoLeilaoDTO> listarLeiloes (){
        return leilaoService.listarLeiloes();
    }

    @PostMapping("/gerar-arquivo-det/{idLeilao}")
    public ResponseEntity<FileSystemResource> gerarArquivoDet(@PathVariable Long idLeilao) {
        return leilaoService.gerarArquivoDet(idLeilao);
        }
    }

