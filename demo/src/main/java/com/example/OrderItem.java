package com.example;

// foi trocada estrutura frágil por objeto com produto, quantidade e preço
class OrderItem {
    private final String product;
    private final int quantity;
    private final double price;

    public OrderItem(String product, int quantity, double price) {
        validateProduct(product);
        validateQuantity(quantity);
        validatePrice(price);

        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public double getTotal() {
        return quantity * price;
    }

    public String toInvoiceLine() {
        return quantity + "x " + product + " - R$" + price;
    }

    private void validateProduct(String product) {
        if (product == null || product.isBlank()) {
            throw new IllegalArgumentException("Nome do produto é obrigatório.");
        }
    }

    private void validateQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que zero.");
        }
    }

    private void validatePrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Preço não pode ser negativo.");
        }
    }
}