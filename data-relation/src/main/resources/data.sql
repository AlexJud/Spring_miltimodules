INSERT INTO account (email) VALUES ('India');
INSERT INTO account (email) VALUES ('Brazil');
INSERT INTO account (email) VALUES ('USA');
INSERT INTO account (email) VALUES ('Italy');

INSERT INTO address_delivery (address) VALUES ( 'Nevskiy prospect' );
INSERT INTO address_delivery (address) VALUES ( 'Milionnaya street' );
INSERT INTO address_delivery (address) VALUES ( 'Sadovaya street' );
INSERT INTO address_delivery (address) VALUES ( 'Admiralteyskiy prospect' );
INSERT INTO address_delivery (address) VALUES ( 'Pesochnaya embankment' );

INSERT INTO customer (name,age,account_id) SELECT 'Alex',20 , id FROM account as a WHERE a.email = 'India';
INSERT INTO customer (name,age,account_id) SELECT 'Mike',25 , id FROM account as a WHERE a.email = 'Brazil';
INSERT INTO customer (name,age,account_id) SELECT 'Rick',30 , id FROM account as a WHERE a.email = 'USA';
INSERT INTO customer (name,age,account_id) SELECT 'Kris',35 , id FROM account as a WHERE a.email = 'Italy';

INSERT INTO customer_deliveries (customer_id,deliveries_id)
SELECT t1.id, t2.id FROM customer as t1, address_delivery as t2 WHERE t1.name = 'Alex' AND t2.address = 'Nevskiy prospect';
INSERT INTO customer_deliveries (customer_id,deliveries_id)
SELECT t1.id, t2.id FROM customer as t1, address_delivery as t2 WHERE t1.name = 'Alex' AND t2.address = 'Milionnaya street';
INSERT INTO customer_deliveries (customer_id,deliveries_id)
SELECT t1.id, t2.id FROM customer as t1, address_delivery as t2 WHERE t1.name = 'Mike' AND t2.address = 'Pesochnaya embankment';
INSERT INTO customer_deliveries (customer_id,deliveries_id)
SELECT t1.id, t2.id FROM customer as t1, address_delivery as t2 WHERE t1.name = 'Rick' AND t2.address = 'Sadovaya street';
INSERT INTO customer_deliveries (customer_id,deliveries_id)
SELECT t1.id, t2.id FROM customer as t1, address_delivery as t2 WHERE t1.name = 'Kris' AND t2.address = 'Admiralteyskiy prospect';
