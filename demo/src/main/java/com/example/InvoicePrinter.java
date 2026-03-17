package com.example;

// foi trocada impressão da fatura para classe dedicada
class InvoicePrinter {
    public static void print(Order order) {
        printClientHeader(order);
        printItems(order);
        printTotals(order);
    }

    private static void printClientHeader(Order order) {
        System.out.println("Cliente: " + order.getClient().getName());
    }

    private static void printItems(Order order) {
        for (OrderItem item : order.getItems()) {
            System.out.println(item.toInvoiceLine());
        }
    }

    private static void printTotals(Order order) {
        System.out.println("Subtotal: R$" + order.calculateSubtotal());
        System.out.println("Desconto: R$" + order.calculateDiscount());
        System.out.println("Total final: R$" + order.calculateFinalTotal());
    }
}
