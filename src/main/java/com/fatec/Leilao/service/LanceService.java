package com.lp2.leilao.service;

import com.lp2.leilao.exception.SolicitacaoNaoEncontrada;
import com.lp2.leilao.model.*;
import com.lp2.leilao.model.dto.lance.ExibicaoLanceProdutoDTO;
import com.lp2.leilao.model.enums.CategoriaProduto;
import com.lp2.leilao.model.informatica.DispositivoInformatica;
import com.lp2.leilao.model.veiculo.DispositivoVeiculo;
import com.lp2.leilao.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class LanceService {

    @Autowired
    private LanceDispositivoInformaticaRepository lanceDispositivoInformaticaRepository;

    @Autowired
    private LanceDispositivoVeiculoRepository lanceDispositivoVeiculoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private DispositivoInformaticaRepository dispositivoInformaticaRepository;

    @Autowired
    private DispositivoVeiculoRepository dispositivoVeiculoRepository;
    public ExibicaoLanceProdutoDTO gerarlanceProdutoInformatica(Long produtoId, String clienteCpf, Double valor){
        Optional<DispositivoInformatica> produtoInformatica = dispositivoInformaticaRepository.findById(produtoId);

        if(produtoInformatica.isEmpty()){
            throw new SolicitacaoNaoEncontrada("Produto não encontrado!");
        }

        if(produtoInformatica.get().getLeilao().getDataFechamento().isBefore(LocalDateTime.now())){
            throw new SolicitacaoNaoEncontrada("Produto não encontrado!");
        }

        if(produtoInformatica.get().getPrecoInicial()>valor){
            throw new SolicitacaoNaoEncontrada("É necessario inserir um valor maior do que o preço inicial do produto!");
        }
        Optional<Cliente> cliente = clienteRepository.findById(clienteCpf);
        if(cliente.isEmpty()){
            throw new SolicitacaoNaoEncontrada("Cliente não encontrado!");
        }
        Double ultimoMaiorLance = lanceDispositivoInformaticaRepository.findValorByDispositivoInformatica(produtoInformatica.get().getId());
        ultimoMaiorLance = ultimoMaiorLance != null ? ultimoMaiorLance : 0D;
        if(ultimoMaiorLance>=valor){
            throw new SolicitacaoNaoEncontrada("Valor abaixo do ultimo lance!");
        }
        LanceDispositivoInformatica lanceDispositivoInformatica = new LanceDispositivoInformatica(produtoInformatica.get(),cliente.get(),valor);
        lanceDispositivoInformaticaRepository.save(lanceDispositivoInformatica);
        return new ExibicaoLanceProdutoDTO(lanceDispositivoInformatica);
    }

    public ExibicaoLanceProdutoDTO gerarLanceProdutoVeiculo(Long produtoId, String clienteCpf, Double valor){
        Optional<DispositivoVeiculo> produtoVeiculo = dispositivoVeiculoRepository.findById(produtoId);
        if(produtoVeiculo.isEmpty()){
            throw new SolicitacaoNaoEncontrada("Produto não encontrado!");
        }
        if(produtoVeiculo.get().getLeilao().getDataFechamento().isBefore(LocalDateTime.now())){
            throw new SolicitacaoNaoEncontrada("Produto não encontrado!");
        }
        if(produtoVeiculo.get().getPrecoInicial()>valor){
            throw new SolicitacaoNaoEncontrada("É necessario inserir um valor maior do que o preço inicial do produto!");
        }
        Optional<Cliente> cliente = clienteRepository.findById(clienteCpf);
        if(cliente.isEmpty()){
            throw new SolicitacaoNaoEncontrada("Cliente não encontrado!");
        }
        Double ultimoMaiorLance = lanceDispositivoVeiculoRepository.findValorByProdutoVeiculo(produtoVeiculo.get().getId());
        ultimoMaiorLance = ultimoMaiorLance != null ? ultimoMaiorLance : 0D;
        if(ultimoMaiorLance>=valor){
            throw new SolicitacaoNaoEncontrada("Valor abaixo do ultimo lance!");
        }
        LanceDispositivoVeiculo lanceDispositivoVeiculo = new LanceDispositivoVeiculo(produtoVeiculo.get(),cliente.get(),valor);
        lanceDispositivoVeiculoRepository.save(lanceDispositivoVeiculo);
        return new ExibicaoLanceProdutoDTO(lanceDispositivoVeiculo);
    }

    public ExibicaoLanceProdutoDTO gerarLanceProduto (Long produtoId, String clienteCpf, Double valor, CategoriaProduto categoriaProduto){
        switch (categoriaProduto){
            case VEICULO -> {
                return gerarLanceProdutoVeiculo(produtoId,clienteCpf,valor);
            }
            case INFORMATICA -> {
                return gerarlanceProdutoInformatica(produtoId, clienteCpf, valor);
            }
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao gerar lance!");
    }

    public List<ExibicaoLanceProdutoDTO> historicoLance(Long produtoId, CategoriaProduto categoriaProduto) {
        switch (categoriaProduto){
            case VEICULO -> {
                return consultarHistoricoVeiculo(produtoId);
            }
            case INFORMATICA -> {
                return consultarHistoricoInformatica(produtoId);
            }
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao gerar lance!");
    }

    private List<ExibicaoLanceProdutoDTO> consultarHistoricoVeiculo(Long produtoId) {
        Optional<DispositivoVeiculo> produtoVeiculo = dispositivoVeiculoRepository.findById(produtoId);
        if(produtoVeiculo.isEmpty()){
            throw new SolicitacaoNaoEncontrada("Produto não encontrado!");
        }
        List<LanceDispositivoVeiculo> lanceDispositivoVeiculo = lanceDispositivoVeiculoRepository.findByDispositivoVeiculo(produtoVeiculo.get());
        return lanceDispositivoVeiculo.stream().map(ExibicaoLanceProdutoDTO::new).toList();
    }
    private List<ExibicaoLanceProdutoDTO> consultarHistoricoInformatica(Long produtoId) {
        Optional<DispositivoInformatica> produtoInformatica = dispositivoInformaticaRepository.findById(produtoId);
        if(produtoInformatica.isEmpty()){
            throw new SolicitacaoNaoEncontrada("Produto não encontrado!");
        }
        List<LanceDispositivoInformatica> lanceDispositivoInformatica = lanceDispositivoInformaticaRepository.findByDispositivoInformatica(produtoInformatica.get());
        return lanceDispositivoInformatica.stream().map(ExibicaoLanceProdutoDTO::new).toList();
    }
}
