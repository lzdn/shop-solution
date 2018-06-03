/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : productdb

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2018-06-04 00:53:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_product
-- ----------------------------
DROP TABLE IF EXISTS `t_product`;
CREATE TABLE `t_product` (
  `product_id` int(11) NOT NULL,
  `content` blob,
  `description` longblob,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
