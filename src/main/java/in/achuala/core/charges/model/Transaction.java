package in.achuala.core.charges.model;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@NoArgsConstructor
public class Transaction {
    private String id;
    private String referenceNumber;
    private Date transactionDate;
    private String customerId;
    private String accountNumber;
    private Double amount;
    private String product;
}
