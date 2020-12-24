CREATE DATABASE `today` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

/*创建表user*/ 
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT comment '用户ID',
  `user_name` varchar(20) NOT NULL COMMENT '用户名（昵称）',
  `password` varchar(16) NOT NULL COMMENT '用户密码，存放MD5加密后的信息',
  `user_avatar_url` varchar(40) NOT NULL COMMENT '用户头像的路径',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


/*创建待办信息表*/
CREATE TABLE `todo` (
  `todo_id` int NOT NULL AUTO_INCREMENT,
  `schedule_id` int DEFAULT NULL COMMENT '关联的日程ID',
  `user_id` int NOT NULL COMMENT '关联用户ID',
  `todo_progress_rate` tinyint DEFAULT '0' COMMENT '当前待办完成进度',
  `repeat_type` tinyint DEFAULT '0' COMMENT '重复类型',
  `todo_state` tinyint DEFAULT '0' COMMENT '待办状态',
  `type` tinyint DEFAULT '0' COMMENT '待办类型',
  `priority` tinyint DEFAULT '0' COMMENT '待办优先级',
  `begin_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '截至时间',
  `content` varchar(60) DEFAULT NULL COMMENT '待办内容',
  PRIMARY KEY (`todo_id`) COMMENT '主键',
  KEY `user_id` (`user_id`),
  CONSTRAINT `todo_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


/*创建父子待办信息表*/
CREATE TABLE `todorealationship` (
  `child_todo_id` int NOT NULL COMMENT '子待办ID，不为空',
  `parent_todo_id` int NOT NULL COMMENT '父待办，不为空',
  PRIMARY KEY (`child_todo_id`,`parent_todo_id`),
  KEY `parent_todo_id` (`parent_todo_id`),
  CONSTRAINT `todorealationship_ibfk_1` FOREIGN KEY (`child_todo_id`) REFERENCES `todo` (`todo_id`),
  CONSTRAINT `todorealationship_ibfk_2` FOREIGN KEY (`parent_todo_id`) REFERENCES `todo` (`todo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*创建日程表*/
CREATE TABLE `schedule` (
  `schedule_id` int NOT NULL COMMENT '日程ID',
  `user_id` int NOT NULL COMMENT '关联用户ID',
  `content` varchar(60) NOT NULL COMMENT '日程内容',
  `begin_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '截至时间',
  `repeat_type` tinyint DEFAULT NULL COMMENT '重复类型',
  `alarm_type` tinyint DEFAULT NULL COMMENT '提醒类型',
  `schedule_type` tinyint DEFAULT NULL COMMENT '日程类型',
  PRIMARY KEY (`schedule_id`,`user_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `schedule_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


/*创建工作日志表*/
CREATE TABLE `worklog` (
  `user_id` int NOT NULL COMMENT '父待办ID',
  `date` date NOT NULL COMMENT '日期',
  `tomato_clock_score` tinyint DEFAULT NULL COMMENT '当天番茄钟执行度',
  `schedule_score` tinyint DEFAULT NULL COMMENT '当天日程时间块执行度',
  `experience` varchar(100) DEFAULT NULL COMMENT '当天工作经验与日志',
  PRIMARY KEY (`user_id`,`date`) COMMENT '用户ID＋date作为主键',
  CONSTRAINT `worklog_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*创建番茄钟信息表*/
CREATE TABLE `tomatoclock` (
  `tomato_clock_id` int NOT NULL AUTO_INCREMENT COMMENT '自增的番茄钟ID',
  `todo_id` int DEFAULT NULL COMMENT '关联待办ID',
  `type` tinyint DEFAULT NULL COMMENT '番茄钟的类型',
  `singel_duration` tinyint DEFAULT NULL COMMENT '单次时长',
  `begin_time` datetime NOT NULL COMMENT '开始时间',
  `user_id` int NOT NULL COMMENT '关联的用户ID',
  `singel_rest_duration` tinyint DEFAULT NULL COMMENT '单词休息时长',
  `repeat_times` tinyint DEFAULT NULL COMMENT '重复次数',
  `summary` varchar(60) DEFAULT NULL COMMENT '总结',
  `bgm_url` varchar(60) DEFAULT NULL COMMENT 'bgmURL',
  PRIMARY KEY (`tomato_clock_id`,`user_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `tomatoclock_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



/*创建番茄钟状态变化记录表*/
CREATE TABLE `tomatoclockstaterecord` (
  `state_type` tinyint NOT NULL DEFAULT '0' COMMENT '状态类型',
  `time` datetime NOT NULL COMMENT '状态变化时间',
  `tomato_clock_id` int NOT NULL COMMENT '关联番茄钟ID',
  PRIMARY KEY (`state_type`,`time`,`tomato_clock_id`),
  KEY `tomato_clock_id` (`tomato_clock_id`),
  CONSTRAINT `tomatoclockstaterecord_ibfk_1` FOREIGN KEY (`tomato_clock_id`) REFERENCES `tomatoclock` (`tomato_clock_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;




