package com.fatec.Leilao.controller;

import com.fatec.Leilao.model.informatica.dto.*;
import com.fatec.Leilao.service.DispositivoInformaticaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "INFORMATICA CONTROLLER")
@RequestMapping("d-informatica")
public class DispositivoInformaticaController {


    @Autowired
    private DispositivoInformaticaService DispositivoService;

    @PostMapping("/criar/notebook/{leilaoId}")
    public ExibicaoDispositivoInformaticaNotebookDTO criarDispositivoInformaticaNotebook (@PathVariable Long leilaoId, @RequestParam(required = false) Long idDispositivoAtualizar, @RequestBody CadastroDispositivoInformaticaNotebookDTO DispositivoInformatica){
        return DispositivoService.criarDispositivoInformaticaNotebook(leilaoId, DispositivoInformatica, idDispositivoAtualizar);
    }

    @PostMapping("/criar/monitor/{leilaoId}")
    public ExibicaoDispositivoInformaticaMonitorDTO criarDispositivoInformaticaMonitor (@PathVariable Long leilaoId, @RequestBody CadastroDispositivoInformaticaMonitorDTO DispositivoInformatica){
        return DispositivoService.criarDispositivoInformaticaMonitor(leilaoId, DispositivoInformatica);
    }

    @PostMapping("/criar/hub/{leilaoId}")
    public ExibicaoDispositivoInformaticaHubDTO criarDispositivoInformaticaHub (@PathVariable Long leilaoId, @RequestBody CadastroDispositivoInformaticaHubDTO cadastroDispositivoInformaticaHubDTO){
        return DispositivoService.criarDispositivoInformaticaHub(leilaoId, cadastroDispositivoInformaticaHubDTO);
    }

    @PostMapping("/criar/switch/{leilaoId}")
    public ExibicaoDispositivoInformaticaSwitchDTO criarDispositivoInformaticaSwitch (@PathVariable Long leilaoId, @RequestBody CadastroDispositivoInformaticaSwitchDTO cadastroDispositivoInformaticaSwitchDTO){
        return DispositivoService.criarDispositivoInformaticaSwitch(leilaoId, cadastroDispositivoInformaticaSwitchDTO);
    }

    @PostMapping("/criar/roteador/{leilaoId}")
    public ExibicaoDispositivoInformaticaRoteadorDTO criarDispositivoInformaticaRoteador(@PathVariable Long leilaoId, @RequestBody CadastroDispositivoInformaticaRoteadorDTO cadastroDispositivoInformaticaRoteadorDTO){
        return DispositivoService.criarDispositivoInformaticaRoteador(leilaoId, cadastroDispositivoInformaticaRoteadorDTO);
    }

    @GetMapping("/listar-todos")
    public List<ExibicaoDispositivoInformaticaDTO> listarDispositivosInformatica (){
        return DispositivoService.listarDispositivosInformatica();
    }

    @DeleteMapping("deletar/{id}")
    public ResponseEntity<String> deletarDispositivoInformatica (@PathVariable Long id){
        return DispositivoService.deletarProdutoInformatica(id);
    }


}
