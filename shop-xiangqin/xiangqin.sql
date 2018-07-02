/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : xiangqin

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2018-04-02 00:20:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_account
-- ----------------------------
DROP TABLE IF EXISTS `t_account`;
CREATE TABLE `t_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `open_id` varchar(255) NOT NULL COMMENT '微信open_id',
  `img_url` varchar(255) DEFAULT NULL COMMENT '图片',
  `charm` varchar(255) DEFAULT NULL COMMENT '魅力',
  `received_count` int(11) DEFAULT NULL COMMENT '收到的信件数',
  `send_count` int(11) DEFAULT NULL COMMENT '发送的信件数',
  `concern_count` int(11) DEFAULT NULL COMMENT '关注',
  `login_time` datetime DEFAULT NULL COMMENT '登录时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='账户表';

-- ----------------------------
-- Table structure for t_concern
-- ----------------------------
DROP TABLE IF EXISTS `t_concern`;
CREATE TABLE `t_concern` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `owner_id` int(11) NOT NULL,
  `follow_id` int(11) NOT NULL,
  `state` int(2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_feedback
-- ----------------------------
DROP TABLE IF EXISTS `t_feedback`;
CREATE TABLE `t_feedback` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account_id` int(11) NOT NULL,
  `content` varchar(250) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_letter
-- ----------------------------
DROP TABLE IF EXISTS `t_letter`;
CREATE TABLE `t_letter` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `from_id` int(11) NOT NULL,
  `to_id` int(11) NOT NULL DEFAULT '0',
  `content` varchar(250) NOT NULL,
  `read_state` int(2) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_person
-- ----------------------------
DROP TABLE IF EXISTS `t_person`;
CREATE TABLE `t_person` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `account_id` int(11) DEFAULT NULL COMMENT 'account_id',
  `name` varchar(255) DEFAULT NULL COMMENT '图片',
  `birthday` datetime DEFAULT NULL COMMENT '魅力',
  `sex` int(11) DEFAULT NULL COMMENT '性别',
  `province_id` int(11) DEFAULT NULL COMMENT '省ID',
  `province_name` varchar(250) DEFAULT NULL COMMENT '省名称',
  `city_id` int(11) DEFAULT NULL COMMENT '市ID',
  `city_name` varchar(250) DEFAULT NULL COMMENT '市名称',
  `county_id` int(11) DEFAULT NULL COMMENT '县ID',
  `county_name` varchar(250) DEFAULT NULL COMMENT '县名称',
  `phone` varchar(50) NOT NULL COMMENT '手机',
  `weixin` varchar(500) DEFAULT NULL COMMENT '微信号',
  `signature` varchar(500) DEFAULT NULL COMMENT '个人签名',
  `introduction` varchar(500) DEFAULT NULL COMMENT '个人简介',
  `contact_way` int(11) DEFAULT NULL COMMENT '联系方式是否加密',
  `birthday_way` int(11) DEFAULT NULL COMMENT '出生日期是否加密',
  `one_show_way` int(11) DEFAULT NULL COMMENT '仅展示一张图片',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  `age` int(11) NOT NULL,
  `height` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='个人信息表';

-- ----------------------------
-- Table structure for t_photo
-- ----------------------------
DROP TABLE IF EXISTS `t_photo`;
CREATE TABLE `t_photo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account_id` int(11) NOT NULL,
  `img_url` varchar(250) NOT NULL,
  `state` int(11) NOT NULL,
  `create_time` datetime NOT NULL,
  `serialno` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
