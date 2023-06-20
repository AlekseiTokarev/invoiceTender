## Requirements
Spring rest service that accepts a long CustomerID and returns a Map<long InvoiceID, String TenderType>.

This method will get all invoices and tendertypes for that customerID from the invoice table.

## Details
Uses Postgres DB which starts up in a docker container by testcontainers lib.

## API
API sample in [invoices.http](./invoices.http) file
