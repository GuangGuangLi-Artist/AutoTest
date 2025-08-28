
CREATE TABLE `test_case` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255),
  `method` varchar(10),
  `url` varchar(255),
  `headers` text,
  `params` text,
  `body` text,
  `file_path` varchar(255),
  `content_type` varchar(50),
  `expected_result` text,
  PRIMARY KEY (`id`)
);

INSERT INTO `test_case` (`name`, `method`, `url`, `headers`, `body`, `content_type`, `expected_result`) VALUES
('登录接口-JSON', 'POST', 'http://api.example.com/login', '{"Content-Type":"application/json"}', '{"username":"admin","password":"123456"}', 'application/json', 'token');
