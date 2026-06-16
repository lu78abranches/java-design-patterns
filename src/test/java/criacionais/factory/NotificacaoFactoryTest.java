package criacionais.factory;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NotificacaoFactoryTest {

	@Test
	void testEmail() {
		Notificacao notificacao = NotificacaoFactory.criar("EMAIL");
		assertThat(notificacao).isInstanceOf(NotificacaoEmail.class);
	}

	@Test
	void testSMS() {
		Notificacao notificacao = NotificacaoFactory.criar("SMS");
		assertThat(notificacao).isInstanceOf(NotificacaoSMS.class);
	}

	@Test
	void testPush() {
		Notificacao notificacao = NotificacaoFactory.criar("PUSH");
		assertThat(notificacao).isInstanceOf(NotificacaoPush.class);
	}

	@Test
	void testIvalido() {
		assertThatThrownBy(() -> NotificacaoFactory.criar("INVALIDO")).isInstanceOf(IllegalArgumentException.class);
	}

}
