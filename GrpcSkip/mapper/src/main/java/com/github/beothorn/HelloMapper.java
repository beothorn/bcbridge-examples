package com.github.beothorn;

import com.github.beothorn.grpc.HelloResponse;

public class HelloMapper {

    public static ServerPlaceholder fakeClient = new ServerPlaceholder();

    public com.github.beothorn.grpc.HelloResponse hello(com.github.beothorn.grpc.HelloRequest request) {
        System.out.println("Redirect hit! " + request.getMessage());
        fakeClient.hello(request, new FakeStreamObserver());
        return HelloResponse.newBuilder().setResponse("Intercepted " + request.getMessage()).build();
    }
}

