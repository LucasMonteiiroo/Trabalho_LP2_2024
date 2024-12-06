package com.lp2.leilao.service;

import com.lp2.leilao.exception.SolicitacaoNaoEncontrada;
import com.lp2.leilao.model.*;
import com.lp2.leilao.model.dto.leilao.ExibicaoProdutoMudarLeilaoDTO;
import com.lp2.leilao.model.dto.produtoInformatica.*;
import com.lp2.leilao.model.enums.StatusLeilao;
import com.lp2.leilao.model.informatica.*;
import com.lp2.leilao.repository.LanceDispositivoInformaticaRepository;
import com.lp2.leilao.repository.LeilaoRepository;
import com.lp2.leilao.repository.DispositivoInformaticaRepository;
import com.lp2.leilao.util.ConfenciaStatusLeilao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoInformaticaService {

    @Autowired
    private DispositivoInformaticaRepository produtoRepository;

    @Autowired
    private LeilaoRepository leilaoRepository;

    @Autowired
    private LanceDispositivoInformaticaRepository lanceDispositivoInformaticaRepository;

    public List<ExibicaoProdutoInformaticaDTO> listarProdutosInformatica() {
        List<DispositivoInformatica> dispositivoInformaticaLista = produtoRepository.findAll();
        return dispositivoInformaticaLista
                .stream()
                .map(ExibicaoProdutoInformaticaDTO::new).toList();
    }

    public ExibicaoProdutoInformaticaDTO atualizarProduto(Long idProduto, CadastroProdutoInformaticaDTO cadastroProdutoInformaticaDTO) {
        Optional<DispositivoInformatica> produtoEncontrado = produtoRepository.findById(idProduto);
        if (produtoEncontrado.isEmpty()) {
            throw new SolicitacaoNaoEncontrada("Produto não encontrado!");
        }

        DispositivoInformatica dispositivoInformaticaAtualizado =
                new DispositivoInformatica(produtoEncontrado.get(),
                        new DispositivoInformatica(cadastroProdutoInformaticaDTO, produtoEncontrado.get().getLeilao()));
        produtoRepository.save(dispositivoInformaticaAtualizado);
        return new ExibicaoProdutoInformaticaDTO(dispositivoInformaticaAtualizado);
    }


    public ResponseEntity<String> deletarProdutoInformatica(Long id) {
        if (produtoRepository.findById(id).isPresent()) {
            produtoRepository.deleteById(id);
        } else {
            return ResponseEntity.ok().body("Produto inexistente!");
        }
        if (produtoRepository.findById(id).isEmpty()) {
            return ResponseEntity.ok().body("Produto deletado com sucesso!");
        } else {
            return ResponseEntity.ok().body("Erro ao deletar produto!");
        }
    }

    public ExibicaoProdutoMudarLeilaoDTO mudarLeilaoProdutoInformatica(Long idProduto, Long idLeilao) {

        Optional<DispositivoInformatica> produtoInformatica = produtoRepository.findById(idProduto);

        List<LanceDispositivoInformatica> lanceDispositivoInformatica = lanceDispositivoInformaticaRepository.findByDispositivoInformatica(produtoInformatica.get());

        if(lanceDispositivoInformatica != null){
            throw new SolicitacaoNaoEncontrada("Produto já possui lance!");
        }

        if(produtoInformatica.isEmpty() ){
            throw new SolicitacaoNaoEncontrada("Produto não encontrado!");
        }

        Optional<Leilao> leilao = leilaoRepository.findById(idLeilao);
        if(leilao.isEmpty() ){
            throw new SolicitacaoNaoEncontrada("Leilão não encontrado!");
        }
        produtoInformatica.get().setLeilao(leilao.get());
        produtoRepository.save(produtoInformatica.get());
        return new ExibicaoProdutoMudarLeilaoDTO(idProduto,idLeilao);

    }

    public ExibicaoProdutoInformaticaNotebookDTO criarProdutoInformaticaNotebook(Long leilaoId, CadastroProdutoInformaticaNotebookDTO cadastroProdutoInformaticaDTO,Long idProdutoAtualizar) {
        Leilao leilao = buscarLeilao(leilaoId);
        Notebook produtoInformatica = new Notebook(cadastroProdutoInformaticaDTO, leilao, cadastroProdutoInformaticaDTO.tamanhoTela());
        produtoRepository.save(produtoInformatica);
        return new ExibicaoProdutoInformaticaNotebookDTO(produtoInformatica);
    }

    public Leilao buscarLeilao(Long leilaoId){
        Leilao leilao = leilaoRepository.findById(leilaoId)
                .orElseThrow(() -> new SolicitacaoNaoEncontrada("Leilão não encontrado!"));
        if(ConfenciaStatusLeilao.conferirStatus(leilao).equals(StatusLeilao.FINALIZADO)){
            throw new SolicitacaoNaoEncontrada("Este leilão já foi encerrado. É possível adicionar dispositivos apenas a leilões que estejam em aberto ou andamento.");
        }
        return leilao;
    }

    public ExibicaoProdutoInformaticaMonitorDTO criarProdutoInformaticaMonitor(Long leilaoId, CadastroProdutoInformaticaMonitorDTO cadastroProdutoInformaticaMonitorDTO) {
        Leilao leilao = buscarLeilao(leilaoId);

        Monitor produtoInformatica = new Monitor(cadastroProdutoInformaticaMonitorDTO, leilao, cadastroProdutoInformaticaMonitorDTO.tamanhoTela());
        produtoRepository.save(produtoInformatica);
        return new ExibicaoProdutoInformaticaMonitorDTO(produtoInformatica);
    }

    public ExibicaoProdutoInformaticaHubDTO criarProdutoInformaticaHub(Long leilaoId, CadastroProdutoInformaticaHubDTO cadastroProdutoInformaticaHubDTO) {
        Leilao leilao = buscarLeilao(leilaoId);

        Hub produtoInformatica = new Hub(cadastroProdutoInformaticaHubDTO, leilao, cadastroProdutoInformaticaHubDTO.quantidadePortas());
        produtoRepository.save(produtoInformatica);
        return new ExibicaoProdutoInformaticaHubDTO(produtoInformatica);
    }

    public ExibicaoProdutoInformaticaSwitchDTO criarProdutoInformaticaSwitch(Long leilaoId, CadastroProdutoInformaticaSwitchDTO cadastroProdutoInformaticaSwitchDTO) {
        Leilao leilao = buscarLeilao(leilaoId);

        Switch produtoInformatica = new Switch(cadastroProdutoInformaticaSwitchDTO, leilao, cadastroProdutoInformaticaSwitchDTO.quantidadePortas());
        produtoRepository.save(produtoInformatica);
        return new ExibicaoProdutoInformaticaSwitchDTO(produtoInformatica);
    }
    public ExibicaoProdutoInformaticaRoteadorDTO criarProdutoInformaticaRoteador(Long leilaoId, CadastroProdutoInformaticaRoteadorDTO cadastroProdutoInformaticaRoteadorDTO) {
        Leilao leilao = buscarLeilao(leilaoId);


        Roteador produtoInformatica = new Roteador(cadastroProdutoInformaticaRoteadorDTO, leilao, cadastroProdutoInformaticaRoteadorDTO.quantidadePortas());
        produtoRepository.save(produtoInformatica);
        return new ExibicaoProdutoInformaticaRoteadorDTO(produtoInformatica);
    }

    public Object selecionarProdutoInformatica(Long idProduto) {
        Optional<DispositivoInformatica> produtoInformatica = produtoRepository.findById(idProduto);
        if(produtoInformatica.isEmpty() ){
            throw new SolicitacaoNaoEncontrada("Produto não encontrado!");
        }        return produtoInformatica.get().criacaoDTO();
    }
}
