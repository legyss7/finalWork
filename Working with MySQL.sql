DROP DATABASE IF EXISTS `Human_Friends`;
CREATE DATABASE `Human_Friends`;
USE `Human_Friends`;



-- типы домашних животных
DROP TABLE IF EXISTS `type_pets`;
CREATE TABLE `type_pets` (
	`id_type_pets` SERIAL PRIMARY KEY, 
	`type_pets` VARCHAR(50) NOT NULL
);
-- наполнение данными 
INSERT INTO `type_pets` (`type_pets`)
VALUES 
('Cat'),
('Dog'),
('Hamster');

-- команды кошек
DROP TABLE IF EXISTS `commands_pets`;
CREATE TABLE `commands_pets` (
	`id_commands_pets` SERIAL PRIMARY KEY, 
	`type_commands_pets` VARCHAR(50) NOT NULL
);
-- наполнение данными 
INSERT INTO `commands_pets` (`type_commands_pets`)
VALUES 
('Sit'), 		-- 1
('Pounce'),		-- 2
('Scratch'),	-- 3
('Meow'),		-- 4
('Jump'),		-- 5
('Stay'),		-- 6
('Fetch'),		-- 7
('Paw'),		-- 8
('Bark'),		-- 9
('Roll'),		-- 10
('Hide'),		-- 11
('Spin');		-- 12


-- домашнии животные
DROP TABLE IF EXISTS `pets`;
CREATE TABLE `pets` (
	`id` SERIAL PRIMARY KEY, 
	`name` VARCHAR(50) NOT NULL,
	`type` BIGINT UNSIGNED NOT NULL,
	`birthdate` DATE NOT NULL,
	`commands` BIGINT UNSIGNED NOT NULL,
    FOREIGN KEY (`type`) REFERENCES `type_pets`(`id_type_pets`) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (`commands`) REFERENCES `commands_pets`(`id_commands_pets`) ON DELETE CASCADE ON UPDATE CASCADE
);
-- наполнение данными 
INSERT INTO `pets` (`name`, `type`, `birthdate`, `commands`)
VALUES 
('Fido', 2, '2020-01-01', '1'),
('Whiskers', 1, '2019-05-15', '2'),
('Hammy', 3, '2021-03-10', '3'),
('Buddy', 2, '2018-12-10', '4'),
('Smudge', 1, '2020-02-20', '5'),
('Peanut', 3, '2021-08-01', '6'),
('Bella', 2, '2019-11-11', '7'),
('Oliver', 1, '2020-06-30', '8');




-- типы вьючных животных
DROP TABLE IF EXISTS `type_pack_animals`;
CREATE TABLE `type_pack_animals` (
	`id_type_pack_animals` SERIAL PRIMARY KEY, 
	`type_pack_animals` VARCHAR(50) NOT NULL
);
-- наполнение данными 
INSERT INTO `type_pack_animals` (`type_pack_animals`)
VALUES 
('Horse'),
('Camel'),
('Donkey');

-- команды 
DROP TABLE IF EXISTS `commands_pack_animals`;
CREATE TABLE `commands_pack_animals` (
	`id_commands_pack_animals` SERIAL PRIMARY KEY, 
	`type_commands_pack_animals` VARCHAR(50) NOT NULL
);
-- наполнение данными 
INSERT INTO `commands_pack_animals` (`type_commands_pack_animals`)
VALUES 
('Trot'),			-- 1
('Canter'),			-- 2
('Gallop'),			-- 3
('Jump'), 			-- 4
('Carry Load'),		-- 5
('Sit'),			-- 6
('Walk'),			-- 7
('Bray'),			-- 8
('Jump'),			-- 9
('Run');			-- 10

-- вьючные животные
DROP TABLE IF EXISTS `pack_animals`;
CREATE TABLE `pack_animals` (
	`id` SERIAL PRIMARY KEY,
	`name` VARCHAR(50) NOT NULL,
	`type` BIGINT UNSIGNED NOT NULL,
	`birthdate` DATE NOT NULL,
	`commands` BIGINT UNSIGNED NOT NULL,
    FOREIGN KEY (`type`) REFERENCES `type_pack_animals`(`id_type_pack_animals`) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (`commands`) REFERENCES `commands_pack_animals`(`id_commands_pack_animals`) ON DELETE CASCADE ON UPDATE CASCADE
);
-- наполнение данными 
INSERT INTO `pack_animals` (`name`, `type`, `birthdate`, `commands`)
VALUES 
('Thunder', '1', '2015-07-21', '1'),
('Sandy', '2', '2016-11-03', '2'),
('Eeyore', '3', '2022-08-30', '3'),
('Storm', '1', '2022-09-20', '4'),
('Dune', '2', '2018-12-12', '5'),
('Burro', '3', '2020-01-23', '6'),
('Blaze', '1', '2021-02-22', '7'),
('Sahara', '2', '2015-08-14', '8');


-- Удалить записи о верблюдах и объединить таблицы лошадей и ослов 
DELETE FROM  human_friends.pack_animals WHERE `type` = 2;
SELECT * FROM human_friends.pack_animals;

-- Создать новую таблицу для животных в возрасте от 1 до 3 лет и 
-- вычислить их возраст с точностью до месяца.
DROP TABLE IF EXISTS pets_1_3;
CREATE TABLE pets_1_3 AS 
(SELECT 
	`id`,
	`name`,
	`birthdate`,
    TIMESTAMPDIFF(MONTH, `birthdate`, CURDATE()) AS month
FROM human_friends.pets
		WHERE (YEAR(CURDATE()) - YEAR(`birthdate`) >= 1
        AND YEAR(CURDATE()) - YEAR(`birthdate`) <= 3));
SELECT * FROM pets_1_3;

DROP TABLE IF EXISTS pack_animals_1_3;
CREATE TABLE pack_animals_1_3 AS 
(SELECT 
	`id`,
	`name`,
	`birthdate`,
    TIMESTAMPDIFF(MONTH, `birthdate`, CURDATE()) AS month
FROM human_friends.pack_animals
		WHERE (YEAR(CURDATE()) - YEAR(`birthdate`) >= 1
        AND YEAR(CURDATE()) - YEAR(`birthdate`) <= 3));
SELECT * FROM pack_animals_1_3;


-- Объединить все созданные таблицы в одну, 
-- сохраняя информацию о принадлежности к исходным таблицам.
DROP TABLE IF EXISTS animals_1_3;
CREATE TABLE animals_1_3 AS (
SELECT
*
FROM pets_1_3
);

insert into animals_1_3 select * from pack_animals_1_3;
SELECT * FROM  animals_1_3; 











