package in.achuala.core.charges.resource;

import com.google.protobuf.InvalidProtocolBufferException;
import com.linecorp.armeria.common.HttpResponse;
import com.linecorp.armeria.common.HttpStatus;
import com.linecorp.armeria.server.annotation.*;
import in.achuala.core.charges.model.CustomerAggregate;
import in.achuala.core.charges.model.Transaction;
import in.achuala.core.common.GlobalExceptionHandler;
import in.achuala.core.common.RedisCache;
import in.achuala.core.common.RedisCacheManager;
import in.achuala.core.common.RedisWrapper;
import lombok.val;

import javax.inject.Inject;
import javax.inject.Named;

@PathPrefix("/transaction")
public class TransactionResource {

    private final RedisCache custCache;
    @Inject
    public TransactionResource(@Named("CUST") RedisCache custCache) {
        this.custCache = custCache;
    }

    @Post("/notify")
    @ProducesJson
    @ConsumesJson
    @ExceptionHandler(GlobalExceptionHandler.class)
    public HttpResponse notifyTransaction(Transaction transaction) throws InvalidProtocolBufferException {
        // Update the respective counts
        // Get Customer Aggregate
        val customer = CustomerAggregate.newBuilder().setCustomerId(transaction.getCustomerId())
                .build();
        custCache.setBytes(transaction.getCustomerId(), customer.toByteArray());
        byte[] found = custCache.getBytes(transaction.getCustomerId());
        CustomerAggregate customerAggregate = CustomerAggregate.parseFrom(found);
        // Get Account Aggregate
        val custID = customerAggregate.getCustomerId();
        // Get Product Aggregate

        return HttpResponse.of(HttpStatus.OK);
    }
}
