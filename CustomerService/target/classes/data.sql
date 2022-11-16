drop table if exists customers;
drop table if exists products;
drop table if exists orders;
drop table if exists order_products;

CREATE TABLE customers
	(`id` int not null auto_increment primary key, `first_name` varchar(15), `last_name`varchar(15), `phone_no`varchar(15), `pincode`varchar(10), `address`varchar(65) )
;
	
INSERT INTO customers
	(`first_name`, `last_name`, `phone_no`)
VALUES
	('Alex', 'Rozera', '2345678900')
;
CREATE TABLE products
	(`id` int not null auto_increment primary key, 
     `product` varchar(64),
     `price` decimal(19,2),
     `quantity` varchar(5))
;
	
INSERT INTO products
	(`product`, `price`, `quantity`)
VALUES
	('Hand Bag', 2998.5, '25'),
	('Flip flop', 567, '55'),
	('Half Jacket', 4567, '35')
;

CREATE TABLE orders
	(`id` int not null auto_increment primary key, 
     `date` date, 
     `customer_id` int,
     `status` int not null default 1, -- 1 new
    constraint fk_customer_id foreign key (customer_id) references customers (id))
;
	
INSERT INTO orders
	(`date`, `customer_id`, `status`)
VALUES
	(CURDATE(), 1, 1)
;

CREATE TABLE order_products
	(`id` int not null auto_increment primary key, 
     `order_id` int not null, 
     `product_id` int not null, 
     `quantity` decimal(19,3) not null, 
     `price` decimal(19,3) not null,
    constraint fk_order_id foreign key (order_id) references orders (id),
    constraint fk_product_id  foreign key (product_id) references products (id))
;
	
INSERT INTO order_products
	(`order_id`, `product_id`, `quantity`, `price`)
VALUES
	(1, 1, 2, 2310.5),
    (1, 2, 4, 2785)
;