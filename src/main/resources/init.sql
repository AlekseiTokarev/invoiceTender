create table invoice
(
    customer_id  BIGINT not null,
    invoice_id   BIGINT not null,
    invoice_data jsonb
);
create index invoice_customer_id_index
    on invoice (customer_id);

insert into invoice (customer_id, invoice_id, invoice_data)
values (1, 54, '{" time": "19:53", "tenderDetails": {"amount": 23.43, "type": "cash"}, "storeNumber":"999"}'),
       (2, 55, '{" time": "12:00", "tenderDetails": {"amount": 4.95, "type": "cash"}, "storeNumber":"999"}'),
       (2, 56, '{" time": "08:49", "tenderDetails": {"amount": 100.12, "type": "credit"}, "storeNumber":"999"}')
