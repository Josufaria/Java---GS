package interfaces;

public interface Notificavel {
    /**
     * Envia uma notificação sobre o status ou algum evento do objeto.
     * @param mensagem Mensagem a ser notificada.
     */
    void enviarNotificacao(String mensagem);
}
