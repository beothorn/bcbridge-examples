package com.github.beothorn;

import com.github.beothorn.grpc.HelloRequest;
import com.github.beothorn.grpc.HelloResponse;
import com.github.beothorn.grpc.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class App
{
    public static void main( String[] args ) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        HelloServiceGrpc.HelloServiceBlockingStub stub
                = HelloServiceGrpc.newBlockingStub(channel);

        System.out.println("Sending test");
        HelloResponse helloResponse = stub.hello(HelloRequest.newBuilder()
                .setMessage("Test")
                .build());

        System.out.println("Received " + helloResponse.getResponse());

        channel.shutdown();
    }
}
