package com.github.alekseitokarev.invoicetender.domain;

import java.math.BigDecimal;

@lombok.Data
public class TenderDetails {
    private String type;
    private BigDecimal amount;
}
