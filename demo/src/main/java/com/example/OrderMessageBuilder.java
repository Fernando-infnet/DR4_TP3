package com.example;

// foi trocada mensagem embutida por gerador de mensagem
class OrderMessageBuilder {
    public static String buildOrderReceivedMessage(String clientName) {
        return String.format(orderReceivedTemplate(), clientName);
    }

    private static String orderReceivedTemplate() {
        return "Pedido recebido, %s! Obrigado pela compra.";
    }
}
