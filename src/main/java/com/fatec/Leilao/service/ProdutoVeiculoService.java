package com.lp2.leilao.service;

import com.lp2.leilao.exception.SolicitacaoNaoEncontrada;
import com.lp2.leilao.model.*;
import com.lp2.leilao.model.dto.leilao.ExibicaoProdutoMudarLeilaoDTO;
import com.lp2.leilao.model.dto.produtoVeiculo.*;
import com.lp2.leilao.model.veiculo.*;
import com.lp2.leilao.repository.*;
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


    public ExibicaoProdutoVeiculoDTO criarProdutoVeiculo(Long leilaoId, CadastroProdutoVeiculoDTO cadastroProdutoVeiculoDTO) {
        Optional<Leilao> leilao = leilaoRepository.findById(leilaoId);
        if (leilao.isEmpty()) {
            throw new SolicitacaoNaoEncontrada("Leilão não encontrado!");
        }
        DispositivoVeiculo dispositivoVeiculo = new DispositivoVeiculo(cadastroProdutoVeiculoDTO, leilao.get());
        produtoRepository.save(dispositivoVeiculo);
        return new ExibicaoProdutoVeiculoDTO(dispositivoVeiculo);
    }
    public ExibicaoProdutoVeiculoMotocicletaDTO criarProdutoVeiculoMotocicleta(Long leilaoId, CadastroProdutoVeiculoMotocicletaDTO cadastroProdutoVeiculoMotocicletaDTO) {
        Optional<Leilao> leilao = leilaoRepository.findById(leilaoId);
        if (leilao.isEmpty()) {
            throw new SolicitacaoNaoEncontrada("Leilão não encontrado!");
        }
        Motocicleta motocicleta = new Motocicleta(cadastroProdutoVeiculoMotocicletaDTO, leilao.get(), cadastroProdutoVeiculoMotocicletaDTO.cilindradas());
        produtoRepository.save(motocicleta);
        return new ExibicaoProdutoVeiculoMotocicletaDTO(motocicleta);
    }
    public ExibicaoProdutoVeiculoCarroDTO criarProdutoVeiculoCarro(Long leilaoId, CadastroProdutoVeiculoCarroDTO cadastroProdutoVeiculoCarroDTO) {
        Optional<Leilao> leilao = leilaoRepository.findById(leilaoId);
        if (leilao.isEmpty()) {
            throw new SolicitacaoNaoEncontrada("Leilão não encontrado!");
        }
        Carro carro = new Carro(cadastroProdutoVeiculoCarroDTO, leilao.get(),cadastroProdutoVeiculoCarroDTO.quantidadePortas());
        produtoRepository.save(carro);
        return new ExibicaoProdutoVeiculoCarroDTO(carro);
    }


    public ExibicaoProdutoVeiculoCaminhaoDTO criarProdutoVeiculoCaminhao(Long leilaoId, CadastroProdutoVeiculoCaminhaoDTO cadastroProdutoVeiculoCaminhaoDTO) {
        Optional<Leilao> leilao = leilaoRepository.findById(leilaoId);
        if (leilao.isEmpty()) {
            throw new SolicitacaoNaoEncontrada("Leilão não encontrado!");
        }
        Caminhao caminhao = new Caminhao(cadastroProdutoVeiculoCaminhaoDTO, leilao.get(),cadastroProdutoVeiculoCaminhaoDTO.capacidadeCarga());
        produtoRepository.save(caminhao);
        return new ExibicaoProdutoVeiculoCaminhaoDTO(caminhao);
    }

    public ExibicaoProdutoVeiculoUtilitarioDTO criarProdutoVeiculoUtilitario(Long leilaoId, CadastroProdutoVeiculoUtilitarioDTO cadastroProdutoVeiculoUtilitarioDTO) {
        Optional<Leilao> leilao = leilaoRepository.findById(leilaoId);
        if (leilao.isEmpty()) {
            throw new SolicitacaoNaoEncontrada("Leilão não encontrado!");
        }
        Utilitario utilitario = new Utilitario(cadastroProdutoVeiculoUtilitarioDTO, leilao.get(),cadastroProdutoVeiculoUtilitarioDTO.capacidadePessoa());
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

