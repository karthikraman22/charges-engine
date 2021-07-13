package in.achuala.core.charges.resource;

import com.linecorp.armeria.common.HttpStatus;
import com.linecorp.armeria.server.annotation.*;
import in.achuala.core.charges.model.Charge;
import in.achuala.core.charges.model.Transaction;
import in.achuala.core.common.GlobalExceptionHandler;
import in.achuala.core.common.RedisCacheManager;
import in.achuala.core.common.RedisWrapper;
import lombok.val;

import javax.inject.Inject;
import java.util.Date;

@PathPrefix("/charges")
public class ChargesResource {

    private RedisCacheManager cacheManager;
    @Inject
    public ChargesResource(RedisCacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    @Post("/calculate")
    @ProducesJson
    @ConsumesJson
    @ExceptionHandler(GlobalExceptionHandler.class)
    public HttpResult<Charge> calculateCharges(Transaction transaction) {
        val charge =  Charge.builder()
                .id("1")
                .code("code")
                .typeCode("PCT")
                .value(1.2)
                .description("desc")
                .build();
        return HttpResult.of(HttpStatus.OK, charge);
    }
}
