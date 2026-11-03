package org.example;

public final class SiloFactory {
    private static final SiloFactory instance = new SiloFactory();

    private SiloFactory() {
    }

    public static SiloFactory getInstance() {
        return instance;
    }

    // Fábrica por reflexão, seguindo os exercícios da disciplina.
    public Silo obterSilo(String tipo) {
        Class<?> classe;
        try {
            classe = Class.forName("org.example.Silo" + tipo);
        } catch (ClassNotFoundException ex) {
            throw new IllegalArgumentException("Silo inexistente", ex);
        }
        if (!Silo.class.isAssignableFrom(classe)) {
            throw new IllegalArgumentException("Silo inválido");
        }
        try {
            return (Silo) classe.getDeclaredConstructor().newInstance();
        } catch (ReflectiveOperationException ex) {
            throw new IllegalArgumentException("Silo inválido", ex);
        }
    }
}
