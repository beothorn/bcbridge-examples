package com.github.beothorn;

import com.github.beothorn.grpc.HelloRequest;
import com.github.beothorn.grpc.HelloResponse;
import com.github.beothorn.grpc.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class App
{
    public static void main( String[] args ) throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        HelloServiceGrpc.HelloServiceBlockingStub stub
                = HelloServiceGrpc.newBlockingStub(channel);

        int count = 0;
        while (count++ < 10000){
            System.out.println("Sending test "+count);
            HelloResponse helloResponse = stub.hello(HelloRequest.newBuilder()
                    .setMessage("Test "+count)
                    .build());

            System.out.println("Received " + helloResponse.getResponse());

            Thread.sleep(500);
        }

        channel.shutdown();
    }

    public static void log(String s) {
        System.out.println("Do nothing");
    }
}
