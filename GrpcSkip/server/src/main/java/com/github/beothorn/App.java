package com.github.beothorn;

import com.github.beothorn.grpc.HelloServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class App {
    public static void main( String[] args ) throws IOException, InterruptedException {
        System.out.println("Starting on port 8080");
        Server server = ServerBuilder
                .forPort(8080)
                .addService(new HelloServiceImpl()).build();

        server.start();
        server.awaitTermination();
    }
}
