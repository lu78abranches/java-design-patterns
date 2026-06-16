package criacionais.builder;
import java.util.List;

public class Pedido {

	private final String cliente;
	private final List<String> itens;
	private final String enderecoEntrega;
	private final String cupomDesconto;
	private final String prioridade;

	private Pedido(Builder builder) {
	    this.cliente = builder.cliente;
	    this.itens = builder.itens;
	    this.enderecoEntrega = builder.enderecoEntrega;
	    this.cupomDesconto = builder.cupomDesconto;
	    this.prioridade = builder.prioridade;
	}

	public String getCliente() {
	  return cliente;
	}

	public List<String> getItens() {
	  return itens;
	}
	
	public String getEnderecoEntrega() {
	  return enderecoEntrega;
	}

	public String getCupomDesconto() {
	  return cupomDesconto;
	}

	public String getPrioridade() {
	  return prioridade;
	}

	public static class Builder {
	   private String cliente; 
	   private List<String> itens;
	   private String enderecoEntrega;
	   private String cupomDesconto;
	   private String prioridade = "NORMAL"; 
	  
	   public Builder(String cliente) {
	      if (cliente == null || cliente.isBlank()) {
	        throw new IllegalArgumentException("É obrigatório preencher o campo cliente");
	       }
	       this.cliente = cliente;
	   }
	  
	   public Builder comItens(List<String> itens) {
		this.itens = itens;
		return this;
	   }

	   public Builder comEnderecoEntrega(String enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
		return this;
	   }

	   public Builder comCupomDesconto(String cupomDesconto) {
		this.cupomDesconto = cupomDesconto;
		return this;
	   }

	   public Builder comPrioridade(String prioridade) {
		this.prioridade = prioridade;
	        return this;
	   }

	   public Pedido build() {

		if(this.itens == null || this.itens.isEmpty()) {
		   throw new IllegalStateException("O pedido deve ter ao menos um item");
		}

		if(this.enderecoEntrega == null || this.enderecoEntrega.isEmpty()) {
		   throw new IllegalStateException("Endereço deve ser preenchido");
		}
		
		return new Pedido(this);
	    }

	}

}