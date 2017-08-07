--   Copyright 2017, nu1silva (nuwan@nu1silva.com)
--
--   Licensed under the Apache License, Version 2.0 (the "License");
--   you may not use this file except in compliance with the License.
--   You may obtain a copy of the License at
--
--       http://www.apache.org/licenses/LICENSE-2.0
--
--   Unless required by applicable law or agreed to in writing, software
--   distributed under the License is distributed on an "AS IS" BASIS,
--   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
--   See the License for the specific language governing permissions and
--   limitations under the License.


CREATE DATABASE XTRACKER;
USE XTRACKER;

DROP TABLE IF EXISTS `user_accounts`;
CREATE TABLE `user_accounts` (
  `id`        INT(10)      NOT NULL AUTO_INCREMENT,
  `email`     VARCHAR(100) NOT NULL,
  `password`  VARCHAR(200) NOT NULL,
  `fname`     VARCHAR(50)  NOT NULL,
  `lname`     VARCHAR(50)  NOT NULL,
  `user_type` VARCHAR(50)  NOT NULL,
  `status`    VARCHAR(10)  NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`, `email`)
);
