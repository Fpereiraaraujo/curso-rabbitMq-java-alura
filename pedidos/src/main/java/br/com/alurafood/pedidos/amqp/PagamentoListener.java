package br.com.alurafood.pedidos.amqp;

import br.com.alurafood.pedidos.dto.PagamentoDTO;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class PagamentoListener {

    @RabbitListener(queues = "pagamento.concluido")
    public void recebeMensagem(PagamentoDTO pagamento) {

        String mensagem = """
                        Dados do pagamento: %s
                Número do pedido: %s
                Valor R$: %s
                Status: %s 
                     """.formatted(pagamento.getId(), pagamento.getPedidoId(), pagamento.getValor(),pagamento.getStatus());
        System.out.println("recebi a menssagem" + mensagem);
    }


}
