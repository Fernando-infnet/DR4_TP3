package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// foi trocado nome e e-mail soltos por objeto Client
// foi trocada coleção paralela por lista encapsulada de OrderItem
class Order {
    private Client client;
    private final List<OrderItem> items = new ArrayList<>();
    private final double discountRate = 0.1;

    public void setClient(String name, String email) {
        this.client = new Client(name, email);
    }

    public void addItem(String product, int quantity, double price) {
        items.add(new OrderItem(product, quantity, price));
    }

    public void printInvoice() {
        validateOrderState();
        InvoicePrinter.print(this);
    }

    // foi trocada montagem direta de mensagem por builder dedicado
    public void sendEmail() {
        validateOrderState();
        EmailService.sendEmail(client.getEmail(), OrderMessageBuilder.buildOrderReceivedMessage(client.getName()));
    }

    public double calculateSubtotal() {
        return sumItemTotals();
    }

    public double calculateDiscount() {
        return DiscountPolicy.calculateDiscount(calculateSubtotal(), discountRate);
    }

    public double calculateFinalTotal() {
        return calculateSubtotal() - calculateDiscount();
    }

    Client getClient() {
        return client;
    }

    List<OrderItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    private double sumItemTotals() {
        double subtotal = 0;
        for (OrderItem item : items) {
            subtotal += item.getTotal();
        }
        return subtotal;
    }

    private void validateOrderState() {
        ensureClientIsDefined();
        ensureHasItems();
    }

    private void ensureClientIsDefined() {
        if (client == null) {
            throw new IllegalStateException("Cliente não definido para o pedido.");
        }
    }

    private void ensureHasItems() {
        if (items.isEmpty()) {
            throw new IllegalStateException("Pedido deve ter ao menos um item.");
        }
    }
}