package com.example;

public class Main {
    public static void main(String[] args) {
        // foi trocado acesso direto por chamadas controladas de domínio
        Order order = new Order();
        order.setClient("João", "joao@email.com");
        order.addItem("Notebook", 1, 3500.0);
        order.addItem("Mouse", 2, 80.0);
        order.printInvoice();
        order.sendEmail();
    }
}