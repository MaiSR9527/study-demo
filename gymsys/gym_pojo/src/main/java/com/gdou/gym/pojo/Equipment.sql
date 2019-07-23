-- auto Generated on 2019-05-31
-- DROP TABLE IF EXISTS equipment;
CREATE TABLE equipment(
	equip_id INT (11) NOT NULL AUTO_INCREMENT COMMENT 'equipId',
	equip_name VARCHAR (50) NOT NULL COMMENT 'equipName',
	total_num INT (11) NOT NULL COMMENT 'totalNum',
	valid_num INT (11) NOT NULL COMMENT 'validNum 可以租借的数量',
	maintain_num INT (11) NOT NULL COMMENT 'maintainNum 维护的器材的数量',
	PRIMARY KEY (equip_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'equipment';
