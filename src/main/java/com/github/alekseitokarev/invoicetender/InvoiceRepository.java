package com.github.alekseitokarev.invoicetender;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.alekseitokarev.invoicetender.domain.InvoiceData;
import com.github.alekseitokarev.invoicetender.entities.Invoice;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Repository
public class InvoiceRepository {
    private final JdbcTemplate jdbcTemplate;
    private final ObjectMapper objectMapper;

    public List<Invoice> getInvoicesByCustomerId(long customerId) {
        String sql = "SELECT invoice_id, invoice_data::varchar FROM invoice WHERE customer_id = ?";
        List<Map<String, Object>> result = jdbcTemplate.queryForList(sql, customerId);
        return result.stream().map((row) -> {
            var invoice = new Invoice();
            invoice.setId((Long) row.get("invoice_id"));
            var invoiceData = parseInvoiceData((String) row.get("invoice_data"));
            invoice.setInvoiceData(invoiceData);
            return invoice;
        }).toList();
    }

    @SneakyThrows
    private InvoiceData parseInvoiceData(String json) {
        return objectMapper.readValue(json, InvoiceData.class);
    }
}
