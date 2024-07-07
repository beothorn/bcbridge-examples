package com.github.beothorn;

import com.github.beothorn.grpc.HelloResponse;
import io.grpc.stub.StreamObserver;

import java.io.Serializable;

public class FakeStreamObserver implements StreamObserver<HelloResponse>, Serializable {
        @Override
        public void onNext(final HelloResponse helloResponse) {

        }

        @Override
        public void onError(final Throwable throwable) {

        }

        @Override
        public void onCompleted() {

        }
}