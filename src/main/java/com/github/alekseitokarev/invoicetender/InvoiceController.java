package com.github.alekseitokarev.invoicetender;

import com.github.alekseitokarev.invoicetender.entities.Invoice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RequiredArgsConstructor
@RestController
public class InvoiceController {
    private final InvoiceRepository invoiceRepository;

    @GetMapping("/invoices")
    public ResponseEntity<List<Map<Long, String>>> getInvoices(
            @RequestParam("customerId") Long customerId) {

        List<Invoice> invoices = invoiceRepository.getInvoicesByCustomerId(customerId);
        if (invoices.isEmpty()) {
            return new ResponseEntity(Map.of("error", "no invoices found"), HttpStatus.NOT_FOUND);
        }
        List<Map<Long, String>> responseMap = invoices.stream()
                .map((invoice) -> Map.of(invoice.getId(), invoice.getInvoiceData().getTenderDetails().getType()))
                .toList();
        return ResponseEntity.ok(responseMap);
    }

}
