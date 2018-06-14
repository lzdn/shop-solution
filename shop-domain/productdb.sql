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
