package com.dragonbyte.patientservice.grpc;

import billing.BillingServiceGrpc;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class BillingServiceGrpcClient {

    private final BillingServiceGrpc.BillingServiceBlockingStub blockingStub;


    public BillingServiceGrpcClient(
            @Value("${billing.service.address:localhost}") String serverAddress,
            BillingServiceGrpc.BillingServiceBlockingStub blockingStub) {
        this.blockingStub = blockingStub;
    }
}
