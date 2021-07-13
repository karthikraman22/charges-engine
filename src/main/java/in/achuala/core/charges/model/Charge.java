package in.achuala.core.charges.model;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;

@Builder
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Charge {
    private  @NonNull String id;
    private  @NonNull String code;
    private  @NonNull String description;
    private  @NonNull String typeCode;
    private  @NonNull Double  value;

    public boolean isEnabled() {
        return true;
    }
}
