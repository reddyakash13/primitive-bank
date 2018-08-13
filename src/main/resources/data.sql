insert into customer(id, name, address, email_address, created_on) values (1, 'akash', '142, wilson street', 'akash@xyz.com', now());
insert into customer(id, name, address, email_address, created_on) values (2, 'eldo', '123, rtc cross roads', 'eldo@xyz.com', now());
insert into customer(id, name, address, email_address, created_on) values (3, 'mahend', '342, indiranagar', 'mahendra@xyz.com', now());

insert into account(id, account_number,account_type, cust_id, account_currency, account_balance, created_on) values (1, 123414, 'SAVINGS', 1, 'EUR', 80, now());
insert into account(id, account_number,account_type, cust_id, account_currency, account_balance, created_on) values (2, 544234, 'SAVINGS', 2, 'EUR', 200, now());
insert into account(id, account_number,account_type, cust_id, account_currency, account_balance, created_on) values (3, 245251, 'SAVINGS', 3, 'EUR', 400, now());

insert into accounthistory(id, transaction_type, transaction_time, opening_balance, closing_balance, transaction_amount, account_id)
	values(1, 'CREDIT', now(), 0, 100, 100, 1);
insert into accounthistory(id, transaction_type, transaction_time, opening_balance, closing_balance, transaction_amount, account_id)
	values(2, 'CREDIT', now(), 100, 130, 30, 1);
insert into accounthistory(id, transaction_type, transaction_time, opening_balance, closing_balance, transaction_amount, account_id)
	values(3, 'DEBIT', now(), 130, 80, 50, 1);

insert into accounthistory(id, transaction_type, transaction_time, opening_balance, closing_balance, transaction_amount, account_id)
	values(4, 'CREDIT', now(), 0, 200, 200, 2);

insert into accounthistory(id, transaction_type, transaction_time, opening_balance, closing_balance, transaction_amount, account_id)
	values(5, 'CREDIT', now(), 0, 400, 400, 3);
