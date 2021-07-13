package in.achuala.core.charges.model;

import lombok.*;

import java.util.Date;

@Builder
@Data
public class ChargeConfig {
    private @NonNull String id;
    private @NonNull String code;
    private ChargeType chargeType;
    private @NonNull Double chargeValue;
    private @NonNull Date effectiveFrom;
    private Date effectiveUntil;


    static enum ChargeType {
        FLAT,
        PERCENTAGE
    }
}
