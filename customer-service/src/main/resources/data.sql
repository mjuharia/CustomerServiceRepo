
delete from customer;

delete from customer;

delete from ref_country;

delete from ref_state;

INSERT INTO ref_country (id, name, created_by, created_date, is_active, modified_by, modified_date, short_code) 
VALUES (1, 'United States', 'SYSTEM', CURRENT_DATE, true, 'SYSTEM', CURRENT_DATE, 'USA');

INSERT INTO ref_state (id, name, created_by, created_date, is_active, modified_by, modified_date, short_code) 
VALUES (1, 'New York', 'SYSTEM', CURRENT_DATE, true , 'SYSTEM', CURRENT_DATE, 'NY');

INSERT INTO ref_state (id, name, created_by, created_date, is_active, modified_by, modified_date, short_code) 
VALUES (2, 'New Jersey', 'SYSTEM', CURRENT_DATE, true , 'SYSTEM', CURRENT_DATE, 'NJ');

INSERT INTO ref_state (id, name, created_by, created_date, is_active, modified_by, modified_date, short_code) 
VALUES (3, 'California', 'SYSTEM', CURRENT_DATE, true , 'SYSTEM', CURRENT_DATE, 'CA');

INSERT INTO ref_state (id, name, created_by, created_date, is_active, modified_by, modified_date, short_code) 
VALUES (4, 'Florida', 'SYSTEM', CURRENT_DATE, true , 'SYSTEM', CURRENT_DATE, 'FL');

INSERT INTO customer (id, name, address, city, created_by, created_on, is_active, modified_by, modified_on, postal_ccode, taxid, country, state) 
VALUES (1004146585, 'Eagle Rock Capital Management', '20 WEST 40TH STREET, 10TH FLOOR', 'NEW YORK', 'SYSTEM', CURRENT_DATE, true , 'SYSTEM', CURRENT_DATE, '10013', '94-5894685', 'USA', 'NY');

INSERT INTO customer (id, name, address, city, created_by, created_on, is_active, modified_by, modified_on, postal_ccode, taxid, country, state) 
VALUES (1003523285, 'LOGAN FOUNTAIN HOMES LLC', '826 BROADWAY, 11TH FLOOR', 'NEW YORK', 'SYSTEM', CURRENT_DATE, true , 'SYSTEM', CURRENT_DATE, '10013', '90-1354689', 'USA', 'NY');

INSERT INTO customer (id, name, address, city, created_by, created_on, is_active, modified_by, modified_on, postal_ccode, taxid, country, state) 
VALUES (1002523234, 'RIVERWALK APARTMENTS', '1040 EAST 54th STREET, 11TH FLOOR', 'NEW YORK', 'SYSTEM', CURRENT_DATE, true , 'SYSTEM', CURRENT_DATE, '10013', '89-4354659', 'USA', 'NY');

INSERT INTO customer_contact (id, address, city, country, created_by, created_date, email_address, fax_number, first_name, is_active, last_name, modified_by, modified_date, phone_number, postalcode, state, i_customer_id, i_customer_servicing_group_id) 
VALUES (1, '1040 EAST 54th STREET, 11TH FLOOR', 'NEW YORK', 'USA', 'SYSTEM', CURRENT_DATE, 'john.dow@riverwalk.com', '212-888-8888', 'John', true, 'Dow', 'SYSTEM', CURRENT_DATE, '212-888-8879', '10013', 'NY', 1002523234, null);

INSERT INTO customer_contact (id, address, city, country, created_by, created_date, email_address, fax_number, first_name, is_active, last_name, modified_by, modified_date, phone_number, postalcode, state, i_customer_id, i_customer_servicing_group_id) 
VALUES (2, '860 35th STREET, 10TH FLOOR', 'NEW YORK', 'USA', 'SYSTEM', CURRENT_DATE, 'Alis.Dumbo@eaglerock.com', '212-888-8888', 'Alis', true, 'Dumbo', 'SYSTEM', CURRENT_DATE, '212-858-1879', '10013', 'NY', 1004146585, null);
