package com.lp2.leilao.service;

import com.lp2.leilao.exception.SolicitacaoNaoEncontrada;
import com.lp2.leilao.model.*;
import com.lp2.leilao.model.dto.leilao.ExibicaoProdutoMudarLeilaoDTO;
import com.lp2.leilao.model.dto.produtoVeiculo.*;
import com.lp2.leilao.model.enums.StatusLeilao;
import com.lp2.leilao.model.veiculo.*;
import com.lp2.leilao.repository.*;
import com.lp2.leilao.util.ConfenciaStatusLeilao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProdutoVeiculoService {
    @Autowired
    private DispositivoVeiculoRepository produtoRepository;

    @Autowired
    private LeilaoRepository leilaoRepository;

    @Autowired
    private MotocicletaRepository motocicletaRepository;
    @Autowired
    private LanceDispositivoVeiculoRepository lanceDispositivoVeiculoRepository;


    public ExibicaoProdutoVeiculoMotocicletaDTO criarProdutoVeiculoMotocicleta(Long leilaoId, CadastroProdutoVeiculoMotocicletaDTO cadastroProdutoVeiculoMotocicletaDTO) {
        Leilao leilao = buscarLeilao(leilaoId);

        Motocicleta motocicleta = new Motocicleta(cadastroProdutoVeiculoMotocicletaDTO, leilao, cadastroProdutoVeiculoMotocicletaDTO.cilindradas());
        produtoRepository.save(motocicleta);
        return new ExibicaoProdutoVeiculoMotocicletaDTO(motocicleta);
    }
    public ExibicaoProdutoVeiculoCarroDTO criarProdutoVeiculoCarro(Long leilaoId, CadastroProdutoVeiculoCarroDTO cadastroProdutoVeiculoCarroDTO) {
        Leilao leilao = buscarLeilao(leilaoId);

        Carro carro = new Carro(cadastroProdutoVeiculoCarroDTO, leilao,cadastroProdutoVeiculoCarroDTO.quantidadePortas());
        produtoRepository.save(carro);
        return new ExibicaoProdutoVeiculoCarroDTO(carro);
    }

    public Leilao buscarLeilao(Long leilaoId){
        Leilao leilao = leilaoRepository.findById(leilaoId)
                .orElseThrow(() -> new SolicitacaoNaoEncontrada("Leilão não encontrado!"));
        if(ConfenciaStatusLeilao.conferirStatus(leilao).equals(StatusLeilao.FINALIZADO)){
            throw new SolicitacaoNaoEncontrada("Este leilão já foi encerrado. É possível adicionar dispositivos apenas a leilões que estejam em aberto ou andamento.");
        }
        return leilao;
    }


    public ExibicaoProdutoVeiculoCaminhaoDTO criarProdutoVeiculoCaminhao(Long leilaoId, CadastroProdutoVeiculoCaminhaoDTO cadastroProdutoVeiculoCaminhaoDTO) {
        Leilao leilao = buscarLeilao(leilaoId);

        Caminhao caminhao = new Caminhao(cadastroProdutoVeiculoCaminhaoDTO, leilao,cadastroProdutoVeiculoCaminhaoDTO.capacidadeCarga());
        produtoRepository.save(caminhao);
        return new ExibicaoProdutoVeiculoCaminhaoDTO(caminhao);
    }

    public ExibicaoProdutoVeiculoUtilitarioDTO criarProdutoVeiculoUtilitario(Long leilaoId, CadastroProdutoVeiculoUtilitarioDTO cadastroProdutoVeiculoUtilitarioDTO) {
        Leilao leilao = buscarLeilao(leilaoId);

        Utilitario utilitario = new Utilitario(cadastroProdutoVeiculoUtilitarioDTO, leilao,cadastroProdutoVeiculoUtilitarioDTO.capacidadePessoa());
        produtoRepository.save(utilitario);
        return new ExibicaoProdutoVeiculoUtilitarioDTO(utilitario);

    }






    public List<ExibicaoProdutoVeiculoDTO> listarProdutosVeiculo() {
        List<DispositivoVeiculo> dispositivoVeiculoLista = produtoRepository.findAll();

        return dispositivoVeiculoLista.stream().map(produtoVeiculo ->
                new ExibicaoProdutoVeiculoDTO(produtoVeiculo)).toList();
    }


    public ExibicaoProdutoVeiculoDTO atualizarProduto(Long idProduto, CadastroProdutoVeiculoDTO cadastroProdutoVeiculoDTO) {
        Optional<DispositivoVeiculo> produtoEncontrado = produtoRepository.findById(idProduto);
        if (produtoEncontrado.isEmpty()) {
            throw new SolicitacaoNaoEncontrada("Produto não encontrado!");
        }

        DispositivoVeiculo dispositivoVeiculoAtualizado =
                new DispositivoVeiculo(produtoEncontrado.get(),
                        new DispositivoVeiculo(cadastroProdutoVeiculoDTO, produtoEncontrado.get().getLeilao()));
        produtoRepository.save(dispositivoVeiculoAtualizado);
        return new ExibicaoProdutoVeiculoDTO(dispositivoVeiculoAtualizado);
    }

    public ResponseEntity<String> deletarProdutoVeiculo(Long id) {
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
    public ExibicaoProdutoMudarLeilaoDTO mudarLeilaoProdutoVeiculo(Long idProduto, Long idLeilao) {

        Optional<DispositivoVeiculo> produtoVeiculo = produtoRepository.findById(idProduto);
        if(produtoVeiculo.isEmpty() ){
            throw new SolicitacaoNaoEncontrada("Produto não encontrado!");
        }
        List<LanceDispositivoVeiculo> lanceDispositivoVeiculo = lanceDispositivoVeiculoRepository.findByDispositivoVeiculo(produtoVeiculo.get());

        if(lanceDispositivoVeiculo != null){
            throw new SolicitacaoNaoEncontrada("Produto já possui lance!");
        }

        Optional<Leilao> leilao = leilaoRepository.findById(idLeilao);
        if(leilao.isEmpty() ){
            throw new SolicitacaoNaoEncontrada("Leilão não encontrado!");
        }
        produtoVeiculo.get().setLeilao(leilao.get());
        produtoRepository.save(produtoVeiculo.get());
        return new ExibicaoProdutoMudarLeilaoDTO(idProduto,idLeilao);
    }


    public Object selecionarProdutoVeiculo(Long idProduto) {
        Optional<DispositivoVeiculo> produtoVeiculo = produtoRepository.findById(idProduto);
        if(produtoVeiculo.isEmpty() ){
            throw new SolicitacaoNaoEncontrada("Produto não encontrado!");
        }        return produtoVeiculo.get().criacaoDTO();
    }

}

