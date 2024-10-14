package com.fatec.Leilao.service;

import com.fatec.Leilao.model.informatica.DispositivoInformatica;
import com.fatec.Leilao.repository.DispositivoInformaticaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DispositivoInformaticaService {

    @Autowired
    private DispositivoInformaticaRepository dispositivoInformaticaRepository;
//
//    public void criarProdutoInformaticaNotebook(Long leilaoId, CadastroDispositivoInformaticaNotebookDTO cadastroProdutoInformaticaDTO,Long idProdutoAtualizar) {
//        Optional<Leilao> leilao = leilaoRepository.findById(leilaoId);
//        if (leilao.isEmpty()) {
//            throw new SolicitacaoNaoEncontrada("Leilão não encontrado!");
//        }
//        Notebook produtoInformatica = new Notebook(cadastroProdutoInformaticaDTO, leilao.get(), cadastroProdutoInformaticaDTO.tamanhoTela());
//        produtoRepository.save(produtoInformatica);
//        return new ExibicaoProdutoInformaticaNotebookDTO(produtoInformatica);
//    }

}
