package criacionais.factory;

public class NotificacaoFactory {
    public static Notificacao criar(String tipo) {

        return switch (tipo) {
            case "EMAIL" -> new NotificacaoEmail();
            case "SMS" -> new NotificacaoSMS();
            case "PUSH" -> new NotificacaoPush();
            default -> throw new IllegalArgumentException("Tipo de notificação desconhecido: " + tipo);
        };

    }
}