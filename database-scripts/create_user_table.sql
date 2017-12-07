CREATE TABLE `user_table` (
  `user_pass` varchar(45) NOT NULL,
  `user_email` varchar(50) NOT NULL,
  `salt` varchar(45) NOT NULL,
  `last_login` datetime NOT NULL,
  PRIMARY KEY (`user_email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8