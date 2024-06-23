package com.github.beothorn.grpc;

import io.grpc.stub.StreamObserver;

public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase{

    @Override
    public void hello(final HelloRequest request, final StreamObserver<HelloResponse> responseObserver) {

        System.out.println("Received "+request.getMessage());

        String greeting = new StringBuilder()
                .append("Hello, ")
                .append(request.getMessage())
                .toString();

        HelloResponse response = HelloResponse.newBuilder()
                .setResponse(greeting)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
