package br.com.isageek.bcbridge.example;

public final class App {

    public App() {
    }

    public static void main(String[] args) {
        new App().printOriginal("Hello from code");
    }

    public void printOriginal(String stringParam) {
        System.out.println("original: " + stringParam);
    }

    public void printRedirected(String stringParam) {
        System.out.println("redirected: " + stringParam);
    }
}
