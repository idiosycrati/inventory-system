DROP DATABASE  IF EXISTS `spring_security_demo_bcrypt`;

CREATE DATABASE  IF NOT EXISTS `spring_security_demo_bcrypt`;
USE `spring_security_demo_bcrypt`;
-- use heroku_8af15f4392cf60a;
-- update authorities set authority='ROLE_ADMIN';


-- CUSTOM CODE HERE
SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(5) Primary Key AUTO_INCREMENT,
  `email` varchar(50) NOT NULL,
  `password` char(68) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  `auth_id` int(5) ,
  CONSTRAINT user_constraint UNIQUE (`email`),
   FOREIGN KEY (auth_id) REFERENCES authorities (`id`)
   ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
  `id` int(5) auto_increment Primary Key,
  `email` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL 
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `products`;
CREATE TABLE `products` (
  `id` int(5) auto_increment Primary Key,
  `productDescription` varchar(256) NOT NULL,
  `productName` varchar(128) NOT NULL,
  `remainingQuantity` int(20) NOT NULL ,
  `productPrice` int(20) NOT NULL,
  `productImageLocation` varchar(128) NOT NULL,
  `enabled` tinyint(1) NOT NULL

) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `id` int(5) auto_increment Primary Key,
  `productId` int(5) NOT NULL,
  `orderQuantity` int(20) NOT NULL ,
  `userId` int(5) NOT NULL,
  FOREIGN KEY (userId) REFERENCES users (`id`)
   ON DELETE NO ACTION ON UPDATE NO ACTION,
   FOREIGN KEY (productId) REFERENCES products (`id`)
   ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `orderId` int(5) auto_increment Primary Key,
  `uuid` varchar(125),
  `productId` int(5) NOT NULL,
  `orderQuantity` int(20) NOT NULL,
  `price` int(20) NOT NULL,
  `userId` int(5) NOT NULL,
  FOREIGN KEY (userId) REFERENCES users (`id`)
   ON DELETE NO ACTION ON UPDATE NO ACTION,
   FOREIGN KEY (productId) REFERENCES products (`id`)
   ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `schedules`;
CREATE TABLE `schedules` (
  `id` int(5) auto_increment Primary Key,
  `date` DATE NOT NULL,
  `time` varchar(20) NOT NULL,
  `caption` varchar(128) NOT NULL,
  `eventDescription` varchar(256) NOT NULL

  -- `enabled` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `posts`;
CREATE TABLE `posts` (
  `id` int(5) auto_increment Primary Key,
  `postCaption` varchar(256) NOT NULL,
  `postBanner` varchar(20) NOT NULL,
  `enabled` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


























-- Create View `TheCart` as select products.id,productDescription,remainingQuantity,productPrice,productImageLocation,orderQuantity,userId from products,cart where products.id=cart.productId;





-- INSERT INTO `authorities` (`username`,`authority`)
-- VALUES 
-- ('mary','ROLE_USER'),
-- ('susan','ROLE_ADMIN');

-- INSERT INTO `users` (`username`,`password`,`enabled`)
-- VALUES 
-- ('mary','{bcrypt}$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K',1),
-- ('susan','{bcrypt}$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K',1);
  SET FOREIGN_KEY_CHECKS = 0;
-- CUSTOM CODE HERE
--
-- Table structure for table `users`
--
-- v1
-- DROP TABLE IF EXISTS `users`;
-- CREATE TABLE `users` (
--   `username` varchar(50) NOT NULL,
--   `password` char(68) NOT NULL,
--   `enabled` tinyint(1) NOT NULL,
--   PRIMARY KEY (`username`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=latin1;
-- SET FOREIGN_KEY_CHECKS = 1;
--
-- Dumping data for table `users`
--
-- NOTE: The passwords are encrypted using BCrypt
--
-- A generation tool is avail at: http://www.luv2code.com/generate-bcrypt-password
--
-- Default passwords here are: fun123
--
-- v1
-- INSERT INTO `users` 
-- VALUES 
-- ('john','{bcrypt}$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K',1),
-- ('mary','{bcrypt}$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K',1),
-- ('susan','{bcrypt}$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K',1);
  -- SET FOREIGN_KEY_CHECKS = 1;
--
-- Table structure for table `authorities`
--
--
-- Dumping data for table `authorities`
--
-- v1
-- INSERT INTO `authorities` 
-- VALUES 
-- ('john','ROLE_EMPLOYEE'),
-- ('mary','ROLE_EMPLOYEE'),
-- ('mary','ROLE_MANAGER'),
-- ('susan','ROLE_EMPLOYEE'),
-- ('susan','ROLE_ADMIN');
