package in.achuala.core.charges.resource;

import com.linecorp.armeria.common.HttpStatus;
import com.linecorp.armeria.server.annotation.*;
import in.achuala.core.charges.model.Charge;
import in.achuala.core.charges.model.ChargeConfig;
import in.achuala.core.charges.model.Transaction;
import in.achuala.core.common.GlobalExceptionHandler;
import in.achuala.core.common.RedisCache;
import in.achuala.core.common.RedisCacheManager;
import in.achuala.core.common.RedisWrapper;
import lombok.NonNull;
import lombok.val;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Date;

@PathPrefix("/admin/charges")
public class ChargesAdminResource {
    private final RedisCache chargeConfigCache;
    @Inject
    public ChargesAdminResource(@Named("CHARGECFG") RedisCache chargeConfigCache) {
        this.chargeConfigCache = chargeConfigCache;
    }

    @Post("/create")
    @ProducesJson
    @ConsumesJson
    @ExceptionHandler(GlobalExceptionHandler.class)
    public HttpResult<Charge> createNewCharge(@NonNull ChargeConfig chargeConfig) {

        this.chargeConfigCache.set(chargeConfig.getCode(), chargeConfig);
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
