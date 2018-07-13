/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : productdb

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2018-07-13 22:53:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_brand
-- ----------------------------
DROP TABLE IF EXISTS `t_brand`;
CREATE TABLE `t_brand` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT COMMENT '品牌id',
  `name` varchar(60) NOT NULL DEFAULT '' COMMENT '品牌名称',
  `banner` varchar(255) NOT NULL DEFAULT '',
  `logo` varchar(200) NOT NULL DEFAULT '' COMMENT '品牌logo',
  `description` text COMMENT '品牌描述',
  `url` varchar(200) NOT NULL DEFAULT '' COMMENT '品牌的地址',
  `status` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '状态(是否显示，显示:1,隐藏:0)',
  `recommend` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否推荐',
  `sort` int(8) unsigned NOT NULL DEFAULT '100' COMMENT '排序',
  `cat_ids` varchar(1000) DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='商品品牌';

-- ----------------------------
-- Records of t_brand
-- ----------------------------

-- ----------------------------
-- Table structure for t_category
-- ----------------------------
DROP TABLE IF EXISTS `t_category`;
CREATE TABLE `t_category` (
  `id` mediumint(8) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '分类名称',
  `pid` mediumint(8) NOT NULL DEFAULT '0' COMMENT '父级分类id',
  `type_id` mediumint(8) unsigned NOT NULL DEFAULT '0' COMMENT '商品类型id',
  `keywords` varchar(200) NOT NULL,
  `description` varchar(200) NOT NULL,
  `grade` text COMMENT '价格分级',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态:0:关闭，1:开启',
  `sort` int(8) NOT NULL DEFAULT '100' COMMENT '排序',
  `icon` varchar(200) NOT NULL DEFAULT '' COMMENT '分类前面的小图标',
  `link` varchar(200) NOT NULL DEFAULT '' COMMENT '外部链接',
  `level` int(3) NOT NULL DEFAULT '1',
  `num` smallint(3) NOT NULL DEFAULT '0' COMMENT '商品数量',
  `remark` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='商品分类';

-- ----------------------------
-- Records of t_category
-- ----------------------------

-- ----------------------------
-- Table structure for t_goods
-- ----------------------------
DROP TABLE IF EXISTS `t_goods`;
CREATE TABLE `t_goods` (
  `good_id` mediumint(8) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) NOT NULL DEFAULT '',
  `cat_id` smallint(5) NOT NULL DEFAULT '0',
  `name` varchar(200) NOT NULL,
  `sub_name` varchar(150) NOT NULL DEFAULT '',
  `brand_id` smallint(5) NOT NULL DEFAULT '0',
  `good_type` smallint(5) NOT NULL DEFAULT '0',
  `virtype` tinyint(1) NOT NULL DEFAULT '0',
  `price` decimal(10,2) NOT NULL DEFAULT '0.00',
  `market_price` decimal(10,2) NOT NULL DEFAULT '0.00',
  `cost_price` decimal(10,2) NOT NULL DEFAULT '0.00',
  `weight` mediumint(8) NOT NULL DEFAULT '0',
  `sn` varchar(100) NOT NULL,
  `barcode` varchar(50) NOT NULL DEFAULT '',
  `unit` varchar(10) NOT NULL,
  `number` mediumint(8) NOT NULL DEFAULT '0',
  `warn_num` smallint(5) NOT NULL DEFAULT '0',
  `status` tinyint(1) NOT NULL DEFAULT '1',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `up_time` datetime NOT NULL,
  `down_time` datetime NOT NULL,
  `sale_num` mediumint(8) NOT NULL DEFAULT '0',
  `virtual_num` mediumint(8) NOT NULL DEFAULT '0',
  `point` smallint(8) NOT NULL DEFAULT '0',
  `comment_reward` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '晒单+5星好评返现或积分',
  `img` varchar(200) NOT NULL,
  `thumb` varchar(200) NOT NULL,
  `imgs` text NOT NULL,
  `specs` text NOT NULL,
  `details` text NOT NULL,
  `details_m` text NOT NULL COMMENT '手机版详情',
  `service` text NOT NULL,
  `service_m` text NOT NULL COMMENT '手机其它内容',
  `recommend` tinyint(1) NOT NULL DEFAULT '0',
  `keyword` varchar(200) NOT NULL,
  `description` varchar(200) NOT NULL,
  `sort` mediumint(8) NOT NULL DEFAULT '0',
  `hot` tinyint(1) NOT NULL DEFAULT '0',
  `new` tinyint(1) NOT NULL DEFAULT '0',
  `best` tinyint(1) NOT NULL DEFAULT '0',
  `freeshipping` tinyint(1) NOT NULL DEFAULT '0',
  `click` int(11) NOT NULL DEFAULT '0' COMMENT '点击数',
  PRIMARY KEY (`good_id`),
  KEY `sort` (`sort`),
  KEY `hot` (`hot`),
  KEY `new` (`new`),
  KEY `best` (`best`),
  KEY `freeshipping` (`freeshipping`),
  KEY `price` (`price`),
  KEY `brand_id` (`brand_id`),
  KEY `cat_id` (`cat_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_goods
-- ----------------------------

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

-- ----------------------------
-- Records of t_product
-- ----------------------------
