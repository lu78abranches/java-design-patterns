package criacionais.singleton;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class ConfiguracaoTestApp{

	@Test
	public void deveRetornarMesmaInstancia(){
	  ConfiguracaoApp instancia1 = ConfiguracaoApp.getInstance();
	  ConfiguracaoApp instancia2 = ConfiguracaoApp.getInstance();

	  assertSame(instancia1, instancia2);
	}
	@Test
	public void atributosDevemFuncionar(){
	  ConfiguracaoApp obj = ConfiguracaoApp.getInstance();
	  ConfiguracaoApp obj2 = ConfiguracaoApp.getInstance();	
	  obj.setIdioma("pt-BR");
	  assertThat(obj2.getIdioma()).isEqualTo("pt-BR");
	  	  
	}
	@Test
	public void deveRetornarMesmaInstanciaEmMultiolasThreads() throws InterruptedException{
	   ConfiguracaoApp[] instancias = new ConfiguracaoApp[2];

	   Thread t1 = new Thread(() -> instancias[0] = ConfiguracaoApp.getInstance());
	   Thread t2 = new Thread(() -> instancias[1] = ConfiguracaoApp.getInstance());

	   t1.start();
	   t2.start();

	   t1.join();
	   t2.join();

	   assertSame(instancias[0], instancias[1]);
	}
}
	  