package criacionais.builder;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import java.util.List;

public class PedidoTest{

	@Test
	void deveCriarPedidoValido() {
	    //1. Cenário e Ação (Construindo o pedido válido)
	    Pedido pedido = new Pedido.Builder("João Pedro").comItens(List.of("Headphones", "Webcam")).comEnderecoEntrega("Rua dos Prazeres, 355").comCupomDesconto("DESCONTO10").comPrioridade("ALTA").build();

	    //2. Verificação (AssertJ validando os atributos)
	    assertThat(pedido).isNotNull();
	    assertThat(pedido.getCliente()).isEqualTo("João Pedro");
	    assertThat(pedido.getItens()).containsExactly("Headphones", "Webcam");
	    assertThat(pedido.getEnderecoEntrega()).isEqualTo("Rua dos Prazeres, 355");
	    assertThat(pedido.getCupomDesconto()).isEqualTo("DESCONTO10");
	    assertThat(pedido.getPrioridade()).isEqualTo("ALTA");
	}

	@Test
        void deveCriarPedidoComValoresPadraoEOpcionaisAusentes() {
        // Teste para garantir que opcionais funcionam e o default é aplicado
               Pedido pedido = new Pedido.Builder("Maria Souza").comItens(List.of("Livro")).comEnderecoEntrega("Av. Central, 456").build(); // Sem cupom e sem prioridade

        assertThat(pedido.getCupomDesconto()).isNull();
        assertThat(pedido.getPrioridade()).isEqualTo("NORMAL"); // Valor default exigido
        }

	@Test 
	void deveLancarExcecaoSemCliente() {

	   assertThatThrownBy(() -> new Pedido.Builder(null)).isInstanceOf(IllegalArgumentException.class);
	}
	
	@Test 
	void deveLancarExcecaoSemItens() {
	   
	   assertThatThrownBy(() -> new Pedido.Builder("João").comItens(null).comEnderecoEntrega("Rua A, 123").build()).isInstanceOf(IllegalStateException.class);
	}
	@Test
	void deveLancarExcecaoSemEnderecoEntrega() {
	   assertThatThrownBy(() -> new Pedido.Builder("João").comItens(List.of("Notebook", "Mouse")).comEnderecoEntrega(null).build()).isInstanceOf(IllegalStateException.class);
	}
}
