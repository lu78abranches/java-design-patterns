package criacionais.singleton;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

public class ConfiguracaoTestApp{

	@Test
	public void deveRetornarMesmaInstancia(){
	  ConfiguracaoApp instancia1 = ConfiguracaoApp.getInstance();
	  ConfiguracaoApp instancia2 = ConfiguracaoApp.getInstance();

	  assertSame(instancia1, instancia2);
	}
}
	  