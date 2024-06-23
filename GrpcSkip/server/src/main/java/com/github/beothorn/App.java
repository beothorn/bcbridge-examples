package com.github.beothorn;

import com.github.beothorn.grpc.HelloServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class App {
    public static void main( String[] args ) throws IOException, InterruptedException {
        if (args.length > 0 && args[0].equals("doNotRunServer")) {
            System.out.println("Will NOT run server!!!");
            while (true) {
                Thread.sleep(1000);
            }
        }
        System.out.println("Starting on port 8080");
        Server server = ServerBuilder
                .forPort(8080)
                .addService(new HelloServiceImpl()).build();

        server.start();
        server.awaitTermination();
    }
}
