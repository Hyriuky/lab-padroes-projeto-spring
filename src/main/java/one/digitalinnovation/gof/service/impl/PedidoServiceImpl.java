package one.digitalinnovation.gof.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.digitalinnovation.gof.model.Pedido;
import one.digitalinnovation.gof.model.PedidoRepository;
import one.digitalinnovation.gof.service.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public Iterable<Pedido> buscarTodos() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido buscarPorId(Long id) {
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        return pedido.orElse(null);
    }

    @Override
    public void inserir(Pedido pedido) {
        pedidoRepository.save(pedido);
    }

    @Override
    public void atualizar(Long id, Pedido pedido) {
        Optional<Pedido> pedidoBd = pedidoRepository.findById(id);
        if (pedidoBd.isPresent()) {
            pedidoRepository.save(pedido);
        }
    }

    @Override
    public void deletar(Long id) {
        pedidoRepository.deleteById(id);
    }

}