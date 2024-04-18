CREATE TABLE `test` (
	`STUDENT_CD` VARCHAR(10) NOT NULL COMMENT '学生番号',
	`SUBJECT_CD` CHAR(3) NOT NULL COMMENT '科目コード',
	`SCHOOL_CD` CHAR(10) NOT NULL COMMENT '学校コード',
	`NO` INT(10) NOT NULL COMMENT '回数',
	`POINT` INT(10) COMMENT '得点',
	`CLASS_NUM` VARCHAR(5) COMMENT 'クラス番号',
	PRIMARY KEY (`STUDENT_CD`,`SUBJECT_CD`,`SCHOOL_CD`,`NO`)
) ENGINE=InnoDB;