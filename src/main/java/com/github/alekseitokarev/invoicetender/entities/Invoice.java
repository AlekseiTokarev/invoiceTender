package com.github.alekseitokarev.invoicetender.entities;

import com.github.alekseitokarev.invoicetender.domain.InvoiceData;

@lombok.Data
public class Invoice {

    private long id;
    private InvoiceData invoiceData;
}
