CREATE TABLE `customer` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(128) not null ,
  `comment` varchar(2048) NOT NULL,
  `amount_sell` decimal(20,4) NOT NULL,
  `register_user_id` int NOT NULL,
  `register_user_fullname` varchar(250) NOT NULL,
  `register_datetime` datetime NOT NULL,
  `active` bit NOT NULL,
  PRIMARY KEY `pk_customer_id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;