/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : managedb

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2018-06-04 17:27:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for qrtz_blob_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_blob_triggers`;
CREATE TABLE `qrtz_blob_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `BLOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_blob_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_blob_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_calendars
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_calendars`;
CREATE TABLE `qrtz_calendars` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `CALENDAR_NAME` varchar(200) NOT NULL,
  `CALENDAR` blob NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`CALENDAR_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_calendars
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_cron_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_cron_triggers`;
CREATE TABLE `qrtz_cron_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `CRON_EXPRESSION` varchar(200) NOT NULL,
  `TIME_ZONE_ID` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_cron_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_cron_triggers
-- ----------------------------
INSERT INTO `qrtz_cron_triggers` VALUES ('SchedulerFactory', 'com.shop.job.impl.MyJob', 'test', '0 0/1 * * * ?', 'Asia/Shanghai');

-- ----------------------------
-- Table structure for qrtz_fired_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_fired_triggers`;
CREATE TABLE `qrtz_fired_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `ENTRY_ID` varchar(95) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `INSTANCE_NAME` varchar(200) NOT NULL,
  `FIRED_TIME` bigint(13) NOT NULL,
  `SCHED_TIME` bigint(13) NOT NULL,
  `PRIORITY` int(11) NOT NULL,
  `STATE` varchar(16) NOT NULL,
  `JOB_NAME` varchar(200) DEFAULT NULL,
  `JOB_GROUP` varchar(200) DEFAULT NULL,
  `IS_NONCONCURRENT` varchar(1) DEFAULT NULL,
  `REQUESTS_RECOVERY` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`ENTRY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_fired_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_job_details
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_job_details`;
CREATE TABLE `qrtz_job_details` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `JOB_NAME` varchar(200) NOT NULL,
  `JOB_GROUP` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `JOB_CLASS_NAME` varchar(250) NOT NULL,
  `IS_DURABLE` varchar(1) NOT NULL,
  `IS_NONCONCURRENT` varchar(1) NOT NULL,
  `IS_UPDATE_DATA` varchar(1) NOT NULL,
  `REQUESTS_RECOVERY` varchar(1) NOT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_job_details
-- ----------------------------
INSERT INTO `qrtz_job_details` VALUES ('SchedulerFactory', '测试JOB', 'test', null, 'com.shop.job.impl.MyJob', '0', '0', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787000737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F40000000000010770800000010000000007800);

-- ----------------------------
-- Table structure for qrtz_locks
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_locks`;
CREATE TABLE `qrtz_locks` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `LOCK_NAME` varchar(40) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`LOCK_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_locks
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_paused_trigger_grps
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_paused_trigger_grps`;
CREATE TABLE `qrtz_paused_trigger_grps` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_paused_trigger_grps
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_scheduler_state
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_scheduler_state`;
CREATE TABLE `qrtz_scheduler_state` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `INSTANCE_NAME` varchar(200) NOT NULL,
  `LAST_CHECKIN_TIME` bigint(13) NOT NULL,
  `CHECKIN_INTERVAL` bigint(13) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`INSTANCE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_scheduler_state
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_simple_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simple_triggers`;
CREATE TABLE `qrtz_simple_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `REPEAT_COUNT` bigint(7) NOT NULL,
  `REPEAT_INTERVAL` bigint(12) NOT NULL,
  `TIMES_TRIGGERED` bigint(10) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_simple_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_simple_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_simprop_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simprop_triggers`;
CREATE TABLE `qrtz_simprop_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `STR_PROP_1` varchar(512) DEFAULT NULL,
  `STR_PROP_2` varchar(512) DEFAULT NULL,
  `STR_PROP_3` varchar(512) DEFAULT NULL,
  `INT_PROP_1` int(11) DEFAULT NULL,
  `INT_PROP_2` int(11) DEFAULT NULL,
  `LONG_PROP_1` bigint(20) DEFAULT NULL,
  `LONG_PROP_2` bigint(20) DEFAULT NULL,
  `DEC_PROP_1` decimal(13,4) DEFAULT NULL,
  `DEC_PROP_2` decimal(13,4) DEFAULT NULL,
  `BOOL_PROP_1` varchar(1) DEFAULT NULL,
  `BOOL_PROP_2` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_simprop_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_simprop_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_triggers`;
CREATE TABLE `qrtz_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `JOB_NAME` varchar(200) NOT NULL,
  `JOB_GROUP` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `NEXT_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PREV_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PRIORITY` int(11) DEFAULT NULL,
  `TRIGGER_STATE` varchar(16) NOT NULL,
  `TRIGGER_TYPE` varchar(8) NOT NULL,
  `START_TIME` bigint(13) NOT NULL,
  `END_TIME` bigint(13) DEFAULT NULL,
  `CALENDAR_NAME` varchar(200) DEFAULT NULL,
  `MISFIRE_INSTR` smallint(2) DEFAULT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `SCHED_NAME` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  CONSTRAINT `qrtz_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) REFERENCES `qrtz_job_details` (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_triggers
-- ----------------------------
INSERT INTO `qrtz_triggers` VALUES ('SchedulerFactory', 'com.shop.job.impl.MyJob', 'test', '测试JOB', 'test', null, '1528103640000', '1528103580000', '5', 'WAITING', 'CRON', '1528096103000', '0', null, '0', '');

-- ----------------------------
-- Table structure for t_dept
-- ----------------------------
DROP TABLE IF EXISTS `t_dept`;
CREATE TABLE `t_dept` (
  `dept_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键dept_id',
  `parent_dept_id` int(11) DEFAULT NULL COMMENT '父部门parent_dept_id',
  `dept_simple_name` varchar(45) NOT NULL COMMENT '简称',
  `dept_full_name` varchar(255) DEFAULT NULL COMMENT '全称',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门表';

-- ----------------------------
-- Records of t_dept
-- ----------------------------

-- ----------------------------
-- Table structure for t_dict
-- ----------------------------
DROP TABLE IF EXISTS `t_dict`;
CREATE TABLE `t_dict` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `dict_code` varchar(255) NOT NULL COMMENT '代码',
  `dict_name` varchar(255) NOT NULL COMMENT '名称',
  `dict_value` varchar(255) NOT NULL COMMENT '值',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `status` int(2) NOT NULL DEFAULT '1' COMMENT '是否有效 1 有效 0 无效',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='字典表';

-- ----------------------------
-- Records of t_dict
-- ----------------------------

-- ----------------------------
-- Table structure for t_job_log
-- ----------------------------
DROP TABLE IF EXISTS `t_job_log`;
CREATE TABLE `t_job_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `job_name` varchar(255) NOT NULL COMMENT '任务key',
  `description` varchar(255) DEFAULT NULL COMMENT '任务执行描述',
  `excute_time` datetime DEFAULT NULL COMMENT '执行时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8 COMMENT='任务日志表';

-- ----------------------------
-- Records of t_job_log
-- ----------------------------
INSERT INTO `t_job_log` VALUES ('1', 'MyJob', '执行任务：MyJob 成功', '2018-06-04 15:05:00', null, null);
INSERT INTO `t_job_log` VALUES ('2', 'MyJob', '执行任务：MyJob 成功', '2018-06-04 15:09:00', null, null);
INSERT INTO `t_job_log` VALUES ('3', 'MyJob', '执行任务：MyJob 成功', '2018-06-04 15:09:31', null, null);
INSERT INTO `t_job_log` VALUES ('4', 'MyJob', '执行任务：MyJob 成功', '2018-06-04 15:10:00', null, null);
INSERT INTO `t_job_log` VALUES ('5', 'MyJob', '执行任务：MyJob 成功', '2018-06-04 15:11:00', null, null);
INSERT INTO `t_job_log` VALUES ('6', 'MyJob', '执行任务：MyJob 成功', '2018-06-04 15:12:00', null, null);
INSERT INTO `t_job_log` VALUES ('7', 'MyJob', '执行任务：MyJob 成功', '2018-06-04 15:13:00', null, null);
INSERT INTO `t_job_log` VALUES ('8', 'MyJob', '执行任务：MyJob 成功', '2018-06-04 15:14:00', null, null);
INSERT INTO `t_job_log` VALUES ('9', 'MyJob', '执行任务：MyJob 成功', '2018-06-04 15:15:00', null, null);
INSERT INTO `t_job_log` VALUES ('10', 'MyJob', '执行任务：MyJob 成功', '2018-06-04 15:16:00', null, null);
INSERT INTO `t_job_log` VALUES ('11', 'MyJob', '执行任务：MyJob 成功', '2018-06-04 15:17:00', null, null);
INSERT INTO `t_job_log` VALUES ('12', 'MyJob', '执行任务：MyJob 成功', '2018-06-04 15:18:00', null, null);
INSERT INTO `t_job_log` VALUES ('13', 'MyJob', '执行任务：MyJob 成功', '2018-06-04 15:19:00', null, null);
INSERT INTO `t_job_log` VALUES ('14', 'MyJob', '执行任务：MyJob 成功', '2018-06-04 15:20:00', null, null);
INSERT INTO `t_job_log` VALUES ('15', 'MyJob', '执行任务：MyJob 成功', '2018-06-04 15:21:52', null, null);
INSERT INTO `t_job_log` VALUES ('16', 'MyJob', '执行任务：MyJob 成功', '2018-06-04 15:22:00', null, null);
INSERT INTO `t_job_log` VALUES ('17', 'MyJob', '执行任务：MyJob 成功', '2018-06-04 15:23:00', null, null);
INSERT INTO `t_job_log` VALUES ('18', 'MyJob', '执行任务：MyJob 成功', '2018-06-04 15:24:00', null, null);
INSERT INTO `t_job_log` VALUES ('19', 'MyJob', '执行任务：MyJob 成功', '2018-06-04 15:25:00', null, null);
INSERT INTO `t_job_log` VALUES ('20', 'MyJob', '执行任务：MyJob 成功', '2018-06-04 15:26:00', null, null);
INSERT INTO `t_job_log` VALUES ('21', 'MyJob', '执行任务：MyJob 成功', '2018-06-04 15:27:00', null, null);
INSERT INTO `t_job_log` VALUES ('22', 'MyJob', '执行任务：MyJob 成功', '2018-06-04 15:28:00', null, null);
INSERT INTO `t_job_log` VALUES ('23', 'MyJob', '执行任务：MyJob 成功', '2018-06-04 15:29:00', null, null);
INSERT INTO `t_job_log` VALUES ('24', 'MyJob', '执行任务：MyJob 成功', '2018-06-04 15:30:00', null, null);
INSERT INTO `t_job_log` VALUES ('25', 'MyJob', '执行任务：MyJob 成功', '2018-06-04 15:35:37', null, null);
INSERT INTO `t_job_log` VALUES ('26', 'MyJob', '执行任务：MyJob 成功', '2018-06-04 15:36:00', null, null);
INSERT INTO `t_job_log` VALUES ('27', 'MyJob', '执行任务：MyJob 成功', '2018-06-04 15:37:00', null, null);
INSERT INTO `t_job_log` VALUES ('28', 'MyJob', '执行任务：MyJob 成功', '2018-06-04 15:38:00', null, null);
INSERT INTO `t_job_log` VALUES ('29', 'MyJob', '执行任务：MyJob 成功', '2018-06-04 15:38:27', null, null);
INSERT INTO `t_job_log` VALUES ('30', 'MyJob', '执行任务：MyJob 成功', '2018-06-04 15:39:00', null, null);
INSERT INTO `t_job_log` VALUES ('31', 'MyJob', '执行任务：MyJob 成功', '2018-06-04 16:04:58', null, null);
INSERT INTO `t_job_log` VALUES ('32', 'MyJob', '执行任务：MyJob 成功', '2018-06-04 16:05:42', null, null);
INSERT INTO `t_job_log` VALUES ('33', 'MyJob', '执行任务：MyJob 成功', '2018-06-04 16:06:00', null, null);
INSERT INTO `t_job_log` VALUES ('34', 'MyJob', '执行任务：MyJob 成功', '2018-06-04 16:07:00', null, null);
INSERT INTO `t_job_log` VALUES ('35', 'MyJob', '执行任务：MyJob 成功', '2018-06-04 16:08:00', null, null);
INSERT INTO `t_job_log` VALUES ('36', 'MyJob', '执行任务：MyJob 成功', '2018-06-04 16:09:00', null, null);
INSERT INTO `t_job_log` VALUES ('37', 'MyJob', '执行任务：MyJob 成功', '2018-06-04 16:10:00', null, null);
INSERT INTO `t_job_log` VALUES ('38', 'MyJob', '执行任务：MyJob 成功', '2018-06-04 16:11:00', null, null);
INSERT INTO `t_job_log` VALUES ('39', 'MyJob', '执行任务：MyJob 成功', '2018-06-04 16:12:00', null, null);
INSERT INTO `t_job_log` VALUES ('40', 'MyJob', '执行任务：MyJob 成功', '2018-06-04 16:13:00', null, null);
INSERT INTO `t_job_log` VALUES ('41', 'MyJob', '执行任务：MyJob 成功', '2018-06-04 16:16:52', null, null);
INSERT INTO `t_job_log` VALUES ('42', 'MyJob', '执行任务：MyJob 成功', '2018-06-04 16:17:00', null, null);
INSERT INTO `t_job_log` VALUES ('43', 'MyJob', '执行任务：MyJob 成功', '2018-06-04 16:18:00', null, null);
INSERT INTO `t_job_log` VALUES ('44', 'MyJob', '执行任务：MyJob 成功', '2018-06-04 16:19:00', null, null);
INSERT INTO `t_job_log` VALUES ('45', 'MyJob', '执行任务：MyJob 成功', '2018-06-04 16:20:00', null, null);
INSERT INTO `t_job_log` VALUES ('46', 'MyJob', '执行任务：MyJob 成功', '2018-06-04 16:21:00', null, null);
INSERT INTO `t_job_log` VALUES ('47', 'MyJob', '执行任务：MyJob 成功', '2018-06-04 16:22:00', null, null);
INSERT INTO `t_job_log` VALUES ('48', 'MyJob', '执行任务：MyJob 成功', '2018-06-04 16:23:00', null, null);
INSERT INTO `t_job_log` VALUES ('49', 'MyJob', '执行任务：MyJob 成功', '2018-06-04 16:24:00', null, null);
INSERT INTO `t_job_log` VALUES ('50', 'MyJob', '执行任务：MyJob 成功', '2018-06-04 16:25:00', null, null);
INSERT INTO `t_job_log` VALUES ('51', 'MyJob', '执行任务：MyJob 成功', '2018-06-04 16:26:00', null, null);
INSERT INTO `t_job_log` VALUES ('52', 'MyJob', '执行任务：MyJob 成功', '2018-06-04 16:27:00', null, null);
INSERT INTO `t_job_log` VALUES ('53', 'MyJob', '执行任务：MyJob 成功', '2018-06-04 16:28:00', null, null);
INSERT INTO `t_job_log` VALUES ('54', 'MyJob', '执行任务：MyJob 成功', '2018-06-04 16:29:00', null, null);
INSERT INTO `t_job_log` VALUES ('55', 'MyJob', '执行任务：MyJob 成功', '2018-06-04 16:30:00', null, null);
INSERT INTO `t_job_log` VALUES ('56', 'MyJob', '执行任务：MyJob 成功', '2018-06-04 16:31:00', null, null);
INSERT INTO `t_job_log` VALUES ('57', 'MyJob', '执行任务：MyJob 成功', '2018-06-04 16:32:00', null, null);
INSERT INTO `t_job_log` VALUES ('58', 'MyJob', '执行任务：MyJob 成功', '2018-06-04 16:33:00', null, null);
INSERT INTO `t_job_log` VALUES ('59', 'MyJob', '执行任务：MyJob 成功', '2018-06-04 17:11:05', null, null);
INSERT INTO `t_job_log` VALUES ('60', 'MyJob', '执行任务：MyJob 成功', '2018-06-04 17:12:00', null, null);
INSERT INTO `t_job_log` VALUES ('61', 'MyJob', '执行任务：MyJob 成功', '2018-06-04 17:13:00', null, null);

-- ----------------------------
-- Table structure for t_module
-- ----------------------------
DROP TABLE IF EXISTS `t_module`;
CREATE TABLE `t_module` (
  `module_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键group_id',
  `icon` varchar(255) DEFAULT NULL COMMENT '图标',
  `module_name` varchar(255) NOT NULL COMMENT '组名称',
  `description` varchar(255) NOT NULL COMMENT '描述',
  `order_by` int(11) NOT NULL DEFAULT '999' COMMENT '排序',
  `status` int(2) NOT NULL DEFAULT '1' COMMENT '是否有效 1 有效 0 无效',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`module_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='菜单组表';

-- ----------------------------
-- Records of t_module
-- ----------------------------
INSERT INTO `t_module` VALUES ('1', 'fa fa-user', '个人中心', '个人中心', '1', '1', null, null);
INSERT INTO `t_module` VALUES ('2', 'fa fa-power-off', '后台系统', '后台系统', '2', '1', null, null);
INSERT INTO `t_module` VALUES ('5', 'fa fa-creative-commons', '人事行政', '人事行政', '2', '1', null, null);

-- ----------------------------
-- Table structure for t_resource
-- ----------------------------
DROP TABLE IF EXISTS `t_resource`;
CREATE TABLE `t_resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `resource_key` varchar(128) DEFAULT '',
  `resource_value` varchar(128) NOT NULL,
  `url` varchar(256) DEFAULT NULL,
  `parent_id` int(20) DEFAULT NULL,
  `module_id` int(11) DEFAULT NULL,
  `level` int(2) NOT NULL,
  `available` tinyint(1) NOT NULL DEFAULT '1',
  `type` int(2) DEFAULT NULL,
  `menu_icon` varchar(128) DEFAULT NULL,
  `order_by` int(10) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_resource
-- ----------------------------
INSERT INTO `t_resource` VALUES ('1', '', '系统', null, '0', '2', '0', '1', '1', 'fa fa-power-off', '1', null, null);
INSERT INTO `t_resource` VALUES ('2', '', '模块管理', '/module/main', '1', '2', '1', '1', '1', null, '1', null, null);
INSERT INTO `t_resource` VALUES ('3', '', '资源管理', '/resource/main', '1', '2', '1', '1', '1', null, '1', null, null);
INSERT INTO `t_resource` VALUES ('4', '', '博客', null, '0', '2', '0', '1', '1', 'fa fa-gg-circle', '1', null, null);
INSERT INTO `t_resource` VALUES ('5', '', '文章', '', '4', '2', '1', '1', '1', null, '1', null, null);
INSERT INTO `t_resource` VALUES ('6', '', '文章列表', '/article/list', '5', '2', '2', '1', '1', null, '1', null, null);
INSERT INTO `t_resource` VALUES ('7', '', '角色管理', '/role/main', '1', '2', '1', '1', '1', 'fa fa-group', '1', null, null);
INSERT INTO `t_resource` VALUES ('8', '', '新增模块', '/module/add', '2', '2', '3', '1', '2', null, '1', null, null);
INSERT INTO `t_resource` VALUES ('19', '', '用户管理', '/user/main', '1', '2', '1', '1', '1', null, '4', null, null);
INSERT INTO `t_resource` VALUES ('20', '', '定时任务', '/job/main', '1', '2', '1', '1', '1', null, '5', null, null);

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键role_id',
  `role_key` varchar(255) NOT NULL,
  `role_name` varchar(255) NOT NULL COMMENT '角色名称',
  `description` varchar(255) DEFAULT NULL COMMENT '角色描述',
  `status` int(2) NOT NULL DEFAULT '1' COMMENT '是否有效 1 有效 0 无效',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', 'super', '超级管理员', '', '1', null, null);
INSERT INTO `t_role` VALUES ('2', 'admin', '管理员', '', '1', null, null);
INSERT INTO `t_role` VALUES ('3', 'vip', '普通会员', '', '1', null, null);
INSERT INTO `t_role` VALUES ('4', 'gust', '游客', '', '1', null, null);

-- ----------------------------
-- Table structure for t_role_resource_relation
-- ----------------------------
DROP TABLE IF EXISTS `t_role_resource_relation`;
CREATE TABLE `t_role_resource_relation` (
  `resource_id` int(11) NOT NULL COMMENT '资源',
  `role_id` int(11) NOT NULL COMMENT '角色',
  PRIMARY KEY (`resource_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色资源表';

-- ----------------------------
-- Records of t_role_resource_relation
-- ----------------------------
INSERT INTO `t_role_resource_relation` VALUES ('1', '1');
INSERT INTO `t_role_resource_relation` VALUES ('1', '2');
INSERT INTO `t_role_resource_relation` VALUES ('2', '1');
INSERT INTO `t_role_resource_relation` VALUES ('3', '1');
INSERT INTO `t_role_resource_relation` VALUES ('4', '1');
INSERT INTO `t_role_resource_relation` VALUES ('5', '1');
INSERT INTO `t_role_resource_relation` VALUES ('6', '1');
INSERT INTO `t_role_resource_relation` VALUES ('7', '1');
INSERT INTO `t_role_resource_relation` VALUES ('8', '1');
INSERT INTO `t_role_resource_relation` VALUES ('19', '1');
INSERT INTO `t_role_resource_relation` VALUES ('19', '2');
INSERT INTO `t_role_resource_relation` VALUES ('20', '1');
INSERT INTO `t_role_resource_relation` VALUES ('20', '2');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键user_id',
  `dept_id` int(11) DEFAULT NULL COMMENT '部门id',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  `account` varchar(45) NOT NULL COMMENT '账号',
  `password` varchar(45) NOT NULL COMMENT '密码',
  `salt` varchar(45) NOT NULL COMMENT 'md5密码盐',
  `username` varchar(45) NOT NULL COMMENT '名字',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `sex` int(11) DEFAULT NULL COMMENT '性别（1：男 2：女）',
  `email` varchar(45) DEFAULT NULL COMMENT '电子邮件',
  `phone` varchar(45) DEFAULT NULL COMMENT '电话',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '状态(1：启用  2：冻结  3：删除）',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `login_time` datetime DEFAULT NULL COMMENT '登录时间',
  `last_login_time` datetime DEFAULT NULL COMMENT '上次登录时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1009 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1000', '1', null, 'admin', '42f6bfd8e35a280d7a212cb76ae76280', '&|^286._', '刘德华', null, '2', '415656544@qq.com', null, '1', '2017-10-18 17:42:40', null, null, null);
INSERT INTO `t_user` VALUES ('1003', null, null, 'zhanglin', '42f6bfd8e35a280d7a212cb76ae76280', '@ad902s^$', '张林', '2018-05-23 00:00:00', '1', null, null, '1', '2018-05-25 00:17:54', null, null, null);
INSERT INTO `t_user` VALUES ('1004', null, null, 'wang', '42f6bfd8e35a280d7a212cb76ae76280', '@ad902s^$', '汪峰', '2018-06-21 00:00:00', '1', null, null, '1', '2018-06-04 14:23:04', null, null, null);
INSERT INTO `t_user` VALUES ('1005', null, null, 'zhou', '42f6bfd8e35a280d7a212cb76ae76280', '@ad902s^$', '周润发', '2018-06-14 00:00:00', '1', null, null, '1', '2018-06-04 14:27:06', null, null, null);
INSERT INTO `t_user` VALUES ('1006', null, null, 'liang', '42f6bfd8e35a280d7a212cb76ae76280', '@ad902s^$', '梁朝伟', '2018-06-13 00:00:00', '1', null, null, '1', '2018-06-04 14:27:59', null, null, null);
INSERT INTO `t_user` VALUES ('1007', null, null, 'fanbb', '42f6bfd8e35a280d7a212cb76ae76280', '@ad902s^$', '范冰冰', '2018-06-08 00:00:00', '2', null, null, '1', '2018-06-04 14:28:56', null, null, null);
INSERT INTO `t_user` VALUES ('1008', null, null, 'zulan', '42f6bfd8e35a280d7a212cb76ae76280', '@ad902s^$', '王祖蓝', '2018-06-20 00:00:00', '1', null, null, '1', '2018-06-04 14:30:40', null, null, null);

-- ----------------------------
-- Table structure for t_user_role_relation
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role_relation`;
CREATE TABLE `t_user_role_relation` (
  `user_id` int(11) NOT NULL COMMENT '用户',
  `role_id` int(11) NOT NULL COMMENT '角色',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色表';

-- ----------------------------
-- Records of t_user_role_relation
-- ----------------------------
INSERT INTO `t_user_role_relation` VALUES ('1000', '1');
INSERT INTO `t_user_role_relation` VALUES ('1003', '2');
INSERT INTO `t_user_role_relation` VALUES ('1004', '3');
INSERT INTO `t_user_role_relation` VALUES ('1005', '3');
INSERT INTO `t_user_role_relation` VALUES ('1006', '4');
INSERT INTO `t_user_role_relation` VALUES ('1008', '4');

-- ----------------------------
-- Function structure for queryChildrenRight
-- ----------------------------
DROP FUNCTION IF EXISTS `queryChildrenRight`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `queryChildrenRight`(rootId varchar(100)) RETURNS varchar(2000) CHARSET utf8
BEGIN   
DECLARE str varchar(2000);  
DECLARE cid varchar(100);   
SET str = '$';   
SET cid = rootId;   
WHILE cid is not null DO   
    SET str = concat(str, ',', cid);   
    SELECT group_concat(right_id) INTO cid FROM t_right where FIND_IN_SET(upper_right_id, cid) > 0;   
END WHILE;   
RETURN str;   
END
;;
DELIMITER ;
