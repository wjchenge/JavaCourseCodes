
CREATE DATABASE `wjchenge_test` CHARACTER SET 'utf8' COLLATE 'utf8_general_ci';

CREATE TABLE `wjchenge_test`.`test_1025` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `age` smallint(3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



INSERT INTO wjchenge_test.test_1025(`name`, age) values('KK01',26),('KK02',35),('KK03',21);