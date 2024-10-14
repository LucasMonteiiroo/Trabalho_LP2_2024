package com.fatec.Leilao.service;

import com.fatec.Leilao.model.informatica.*;
import com.fatec.Leilao.model.informatica.dto.*;
import com.fatec.Leilao.model.leilao.Leilao;
import com.fatec.Leilao.repository.DispositivoInformaticaRepository;
import com.fatec.Leilao.repository.LeilaoRepository;
import com.fatec.Leilao.repository.DispositivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DispositivoInformaticaService {

    @Autowired
    private DispositivoInformaticaRepository dispositivoInformaticaRepository;

    @Autowired
    private LeilaoRepository leilaoRepository;

    @Autowired
    private DispositivoRepository dispositivoRepository;

    public ExibicaoDispositivoInformaticaNotebookDTO criarDispositivoInformaticaNotebook(Long leilaoId, CadastroDispositivoInformaticaNotebookDTO cadastroDispositivoInformaticaDTO, Long idDispositivoAtualizar) {
        Leilao leilao = leilaoRepository.findById(leilaoId)
                .orElseThrow(() -> new RuntimeException("Leilão não encontrado!"));

        Notebook DispositivoInformatica = new Notebook(cadastroDispositivoInformaticaDTO, leilao, cadastroDispositivoInformaticaDTO.tamanhoTela());
        dispositivoRepository.save(DispositivoInformatica);
        return new ExibicaoDispositivoInformaticaNotebookDTO(DispositivoInformatica);
    }

    public ExibicaoDispositivoInformaticaMonitorDTO criarDispositivoInformaticaMonitor(Long leilaoId, CadastroDispositivoInformaticaMonitorDTO cadastroDispositivoInformaticaMonitorDTO) {
        Leilao leilao = leilaoRepository.findById(leilaoId)
                .orElseThrow(() -> new RuntimeException("Leilão não encontrado!"));
        Monitor DispositivoInformatica = new Monitor(cadastroDispositivoInformaticaMonitorDTO, leilao, cadastroDispositivoInformaticaMonitorDTO.tamanhoTela());
        dispositivoRepository.save(DispositivoInformatica);
        return new ExibicaoDispositivoInformaticaMonitorDTO(DispositivoInformatica);
    }

    public ExibicaoDispositivoInformaticaHubDTO criarDispositivoInformaticaHub(Long leilaoId, CadastroDispositivoInformaticaHubDTO cadastroDispositivoInformaticaHubDTO) {
        Leilao leilao = leilaoRepository.findById(leilaoId)
                .orElseThrow(() -> new RuntimeException("Leilão não encontrado!"));

        Hub DispositivoInformatica = new Hub(cadastroDispositivoInformaticaHubDTO, leilao, cadastroDispositivoInformaticaHubDTO.quantidadePortas());
        dispositivoRepository.save(DispositivoInformatica);
        return new ExibicaoDispositivoInformaticaHubDTO(DispositivoInformatica);
    }

    public ExibicaoDispositivoInformaticaSwitchDTO criarDispositivoInformaticaSwitch(Long leilaoId, CadastroDispositivoInformaticaSwitchDTO cadastroDispositivoInformaticaSwitchDTO) {
        Leilao leilao = leilaoRepository.findById(leilaoId)
                .orElseThrow(() -> new RuntimeException("Leilão não encontrado!"));

        Switch DispositivoInformatica = new Switch(cadastroDispositivoInformaticaSwitchDTO, leilao, cadastroDispositivoInformaticaSwitchDTO.quantidadePortas());
        dispositivoRepository.save(DispositivoInformatica);
        return new ExibicaoDispositivoInformaticaSwitchDTO(DispositivoInformatica);
    }
    public ExibicaoDispositivoInformaticaRoteadorDTO criarDispositivoInformaticaRoteador(Long leilaoId, CadastroDispositivoInformaticaRoteadorDTO cadastroDispositivoInformaticaRoteadorDTO) {
        Leilao leilao = leilaoRepository.findById(leilaoId)
                .orElseThrow(() -> new RuntimeException("Leilão não encontrado!"));

        Roteador DispositivoInformatica = new Roteador(cadastroDispositivoInformaticaRoteadorDTO, leilao, cadastroDispositivoInformaticaRoteadorDTO.quantidadePortas());
        dispositivoRepository.save(DispositivoInformatica);
        return new ExibicaoDispositivoInformaticaRoteadorDTO(DispositivoInformatica);
    }

    public List<ExibicaoDispositivoInformaticaDTO> listarDispositivosInformatica() {
        List<DispositivoInformatica> DispositivoInformaticaLista = dispositivoRepository.findAll();
        return DispositivoInformaticaLista
                .stream()
                .map(ExibicaoDispositivoInformaticaDTO::new).toList();
    }

    public ResponseEntity<String> deletarProdutoInformatica(Long id) {
        Optional<DispositivoInformatica> produto = dispositivoRepository.findById(id);

        if (produto.isEmpty()) {
            return ResponseEntity.ok().body("Produto inexistente!");
        }

        try {
            dispositivoRepository.deleteById(id);
            return ResponseEntity.ok().body("Produto deletado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao deletar produto!");
        }
    }

}
