package com.example;

// foi trocado armazenamento direto de dados do cliente por classe reutilizável
class Client {
    private final String name;
    private final String email;

    public Client(String name, String email) {
        validateName(name);
        validateEmail(email);

        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Nome do cliente é obrigatório.");
        }
    }

    private void validateEmail(String email) {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("E-mail do cliente é obrigatório.");
        }
    }
}