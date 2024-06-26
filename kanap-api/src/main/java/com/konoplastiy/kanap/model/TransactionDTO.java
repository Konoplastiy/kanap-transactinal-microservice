package com.konoplastiy.kanap.model;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;

@Builder
@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDTO {

    @NotBlank
    private String transactionType;

    @NotBlank
    private String currency;

    @NotBlank
    private String status;
}
