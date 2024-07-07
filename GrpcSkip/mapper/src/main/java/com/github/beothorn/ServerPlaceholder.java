package com.github.beothorn;

import com.github.beothorn.grpc.HelloRequest;
import com.github.beothorn.grpc.HelloResponse;
import io.grpc.stub.StreamObserver;

public class ServerPlaceholder {

    public void hello(final HelloRequest request, final StreamObserver<HelloResponse> responseObserver) {
        System.out.println("Should not be called directly");
    }

    public void onNext() {
        System.out.println("Fake on next");
    }
}
