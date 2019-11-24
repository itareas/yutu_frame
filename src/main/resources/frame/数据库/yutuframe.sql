/*
SQLyog Enterprise v12.08 (64 bit)
MySQL - 8.0.14 : Database - yutuframe
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`yutuframe` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `yutuframe`;

/*Table structure for table `t_sys_errorlog` */

DROP TABLE IF EXISTS `t_sys_errorlog`;

CREATE TABLE `t_sys_errorlog` (
  `uuid` varchar(64) NOT NULL COMMENT '编码',
  `project_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '项目名称',
  `create_date` varchar(64) DEFAULT NULL COMMENT '创建时间',
  `log_level` varchar(64) DEFAULT NULL COMMENT '等级',
  `log_category` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '类别',
  `file_name` varchar(256) DEFAULT NULL COMMENT '文件名',
  `thread_name` varchar(64) DEFAULT NULL COMMENT '线程名称',
  `log_line` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '线',
  `all_category` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '所有类型',
  `log_message` text COMMENT '错误信息',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_sys_errorlog` */

/*Table structure for table `t_sys_landinglog` */

DROP TABLE IF EXISTS `t_sys_landinglog`;

CREATE TABLE `t_sys_landinglog` (
  `uuid` varchar(64) NOT NULL COMMENT '编码',
  `login_userid` varchar(64) DEFAULT NULL COMMENT '用户id',
  `login_account` varchar(64) DEFAULT NULL COMMENT '登陆用户名',
  `login_ip` varchar(128) DEFAULT NULL COMMENT '登陆者的ip',
  `login_sessionid` varchar(128) DEFAULT NULL COMMENT '登陆sessionId',
  `login_date` datetime DEFAULT NULL COMMENT '登陆时间',
  `login_type` varchar(32) DEFAULT NULL COMMENT '登陆类型： 登陆/退出登录',
  `login_result` int(4) DEFAULT NULL COMMENT '登陆结果   0：登陆成功   1：登陆失败',
  `login_appname` varchar(246) DEFAULT NULL COMMENT '登录模块名称',
  `login_address` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '登陆系统地址',
  `login_remarks` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '备注',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_sys_landinglog` */

/*Table structure for table `t_sys_operationlog` */

DROP TABLE IF EXISTS `t_sys_operationlog`;

CREATE TABLE `t_sys_operationlog` (
  `uuid` varchar(64) NOT NULL COMMENT '编码',
  `operate_db` varchar(64) DEFAULT NULL COMMENT '操作数据库',
  `operate_dt` varchar(64) DEFAULT NULL COMMENT '操作表',
  `operate_type` varchar(64) DEFAULT NULL COMMENT '操作类型   增删改',
  `operate_primarykey` varchar(2048) DEFAULT NULL COMMENT '主键',
  `operate_content` text COMMENT '操作内容',
  `operate_person` varchar(64) DEFAULT NULL COMMENT '操作人',
  `operate_datetime` datetime DEFAULT NULL COMMENT '操作时间',
  `log_type` varchar(64) DEFAULT NULL COMMENT '操作类型 1,sql语句',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_sys_operationlog` */

/*Table structure for table `t_sys_userinfo` */

DROP TABLE IF EXISTS `t_sys_userinfo`;

CREATE TABLE `t_sys_userinfo` (
  `uuid` varchar(64) NOT NULL COMMENT '主键',
  `user_code` varchar(64) DEFAULT NULL COMMENT '用户特殊编码',
  `user_account` varchar(128) DEFAULT NULL COMMENT '用户登陆名',
  `user_pwd` varchar(64) DEFAULT NULL COMMENT '用户密码',
  `user_question` varchar(255) DEFAULT NULL COMMENT '密码提示',
  `user_name` varchar(256) DEFAULT NULL COMMENT '用户真实姓名',
  `user_sex` bigint(4) DEFAULT NULL COMMENT '用户性别  0：保密   1：男   2：女',
  `user_title` varchar(256) DEFAULT NULL COMMENT '用户职称',
  `user_phone` varchar(32) DEFAULT NULL COMMENT '用户手机号',
  `user_email` varchar(255) DEFAULT NULL COMMENT '用户邮件',
  `user_lock` bigint(4) DEFAULT NULL COMMENT '用户锁定  0：正常   1：锁定',
  `user_status` bigint(4) DEFAULT NULL COMMENT '用户逻辑删除  0 ：正常   1：删除',
  `create_date` date DEFAULT NULL COMMENT '创建时间',
  `create_userid` varchar(64) DEFAULT NULL COMMENT '创建人',
  `modify_date` date DEFAULT NULL COMMENT '修改时间',
  `modify_userid` varchar(64) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_sys_userinfo` */

insert  into `t_sys_userinfo`(`uuid`,`user_code`,`user_account`,`user_pwd`,`user_question`,`user_name`,`user_sex`,`user_title`,`user_phone`,`user_email`,`user_lock`,`user_status`,`create_date`,`create_userid`,`modify_date`,`modify_userid`) values ('ae771cf1-23f0-4e8e-b235-fc12a6fb4884','yt-001','admin','ba0e9509d71fa98694cd9a0061fb7efd','管理员','赵宝成',1,'',NULL,'zhaobc@mapuni.com',0,0,'2019-04-21',NULL,'2019-04-21',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
