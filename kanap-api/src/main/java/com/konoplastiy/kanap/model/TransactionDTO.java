package com.konoplastiy.kanap.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.Instant;

@Builder
@Getter
@EqualsAndHashCode
@ToString
public class TransactionDTO {

    @NotBlank
    private String transactionId;

    @NotBlank
    private String sk;

    @NotBlank
    private String transactionType;

    @NotNull
    private BigDecimal amount;

    @NotNull
    private Instant timestamp;

    @NotBlank
    private String description;

    @NotBlank
    private String currency;

    @NotBlank
    private String status;
}
