package com.example;

// foi trocado cálculo solto de desconto por política centralizada com validação
class DiscountPolicy {
    public static double calculateDiscount(double amount, double rate) {
        validateAmount(amount);
        validateRate(rate);
        return amount * rate;
    }

    private static void validateAmount(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Subtotal não pode ser negativo.");
        }
    }

    private static void validateRate(double rate) {
        if (rate < 0 || rate > 1) {
            throw new IllegalArgumentException("Taxa de desconto deve estar entre 0 e 1.");
        }
    }
}