package com.github.alekseitokarev.invoicetender.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalTime;

@lombok.Data
public class InvoiceData {
    @JsonFormat(pattern="HH:mm")
    private LocalTime time;
    private TenderDetails tenderDetails;
    private String storeNumber;
}
