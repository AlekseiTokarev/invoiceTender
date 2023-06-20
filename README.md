## Requirements
Spring rest service that accepts a long CustomerID and returns a Map<long InvoiceID, String TenderType>.

This method will get all invoices and tendertypes for that customerID from the invoice table.

## Database connectivity
During the spring-boot start up, the application connects to a Postgres database that is automatically launched within a Docker container.
The database is populated with the data from the [init.sql](./src/main/resources/init.sql) file.

## API
API sample in [invoices.http](./invoices.http) file
