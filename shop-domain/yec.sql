
--
-- 云ec商城数据结构

--
-- 表的结构 `shop_app`
--

CREATE TABLE IF NOT EXISTS `shop_app` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` tinyint(1) NOT NULL DEFAULT '0' COMMENT '1安卓，2苹果',
  `version` varchar(20) NOT NULL DEFAULT '' COMMENT '版本号',
  `memo` varchar(500) NOT NULL DEFAULT '' COMMENT '备注',
  `url` varchar(255) NOT NULL DEFAULT '',
  `addtime` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=1;

-- --------------------------------------------------------

--
-- 表的结构 `shop_attribute`
--

CREATE TABLE IF NOT EXISTS `shop_attribute` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT COMMENT '规格id',
  `type_id` mediumint(8) DEFAULT '0' COMMENT '商品类型id',
  `name` varchar(60) NOT NULL DEFAULT '' COMMENT '规格名称',
  `value` text NULL COMMENT '规格值',
  `search` tinyint(1) DEFAULT '0',
  `uitype` varchar(50) DEFAULT NULL COMMENT '输入控件的类型,radio:单选,checkbox:复选,input:输入',
  `type` tinyint(1) DEFAULT '0' COMMENT '属性种类：0属性、1规格',
  `sort` mediumint(5) unsigned NOT NULL DEFAULT '100' COMMENT '规格排序',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COMMENT='商品规格' AUTO_INCREMENT=1;

-- --------------------------------------------------------

--
-- 表的结构 `shop_banner`
--

CREATE TABLE IF NOT EXISTS `shop_banner` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `c_id` int(11) NOT NULL,
  `c_sid` int(11) NULL,
  `c_code` varchar(130) NULL,
  `c_title` varchar(200) NOT NULL,
  `c_time` int(11) NOT NULL,
  `c_width` smallint(3) NOT NULL,
  `c_height` smallint(3) NOT NULL,
  `c_name` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `c_id` (`c_id`),
  KEY `s_id` (`c_sid`),
  KEY `c_title` (`c_title`),
  KEY `c_time` (`c_time`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

-- --------------------------------------------------------

--
-- 表的结构 `shop_banner_pic`
--

CREATE TABLE IF NOT EXISTS `shop_banner_pic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `c_sid` int(11) NULL,
  `c_id` int(11) NOT NULL,
  `c_toid` int(11) NULL,
  `c_simg` varchar(200) NOT NULL,
  `c_bimg` varchar(200) NOT NULL,
  `c_title` varchar(255) NOT NULL,
  `c_code` varchar(80) NULL,
  `c_time` int(11) NOT NULL,
  `c_url` varchar(255) NOT NULL,
  `c_txt` varchar(200) NOT NULL,
  `c_order` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `c_toid` (`c_toid`),
  KEY `c_id` (`c_id`),
  KEY `c_sid` (`c_sid`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `shop_brand`
--

CREATE TABLE IF NOT EXISTS `shop_brand` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT COMMENT '品牌id',
  `name` varchar(60) NOT NULL DEFAULT '' COMMENT '品牌名称',
  `banner` VARCHAR( 255 ) NOT NULL DEFAULT  '',
  `logo` varchar(200) NOT NULL DEFAULT '' COMMENT '品牌logo',
  `description` text NULL COMMENT '品牌描述',
  `url` varchar(200) NOT NULL DEFAULT '' COMMENT '品牌的地址',
  `status` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '状态(是否显示，显示:1,隐藏:0)',
  `recommend` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否推荐',
  `sort` int(8) unsigned NOT NULL DEFAULT '100' COMMENT '排序',
  `cat_ids` varchar(1000) NULL DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`) USING BTREE
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COMMENT='商品品牌' AUTO_INCREMENT=1;

-- --------------------------------------------------------

--
-- 表的结构 `shop_cart`
--

CREATE TABLE IF NOT EXISTS `shop_cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(8) NOT NULL DEFAULT '0',
  `lasttime` int(8) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `uid` (`uid`),
  KEY `uid_2` (`uid`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

-- --------------------------------------------------------

--
-- 表的结构 `shop_cart_item`
--

CREATE TABLE IF NOT EXISTS `shop_cart_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cid` int(11) NOT NULL,
  `gid` mediumint(8) NOT NULL,
  `pid` mediumint(8) NOT NULL DEFAULT '0',
  `num` mediumint(8) NOT NULL,
  `spec` varchar(200) NOT NULL DEFAULT '',
  `act_type` TINYINT(1) NOT NULL DEFAULT  '0' COMMENT  '活动类型：1拼团',
  `data` VARCHAR(200) NULL DEFAULT  '' COMMENT  '中转数据：团id|拼团id|人数',  
  `status` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

-- --------------------------------------------------------

--
-- 表的结构 `shop_category`
--

CREATE TABLE IF NOT EXISTS `shop_category` (
  `id` mediumint(8) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '分类名称',
  `pid` mediumint(8) NOT NULL DEFAULT '0' COMMENT '父级分类id',
  `type_id` mediumint(8) unsigned NOT NULL DEFAULT '0' COMMENT '商品类型id',
  `keywords` varchar(200) NOT NULL,
  `description` varchar(200) NOT NULL,
  `grade` text NULL COMMENT '价格分级',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态:0:关闭，1:开启',
  `sort` int(8) NOT NULL DEFAULT '100' COMMENT '排序',
  `img` varchar(200) NOT NULL DEFAULT '' COMMENT '分类前面的小图标',
  `link` varchar(200) NOT NULL DEFAULT '' COMMENT '外部链接',
  `urlname` varchar(50) NOT NULL DEFAULT '',
  `tpl` varchar(50) NOT NULL DEFAULT '',
  `level` int(3) NOT NULL DEFAULT '1',
  `num` smallint(3) NOT NULL DEFAULT '0',
  `remark` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COMMENT='商品分类' AUTO_INCREMENT=1;

-- --------------------------------------------------------

--
-- 表的结构 `shop_chat_user`
--

CREATE TABLE IF NOT EXISTS `shop_chat_user` (
  `cus_id` mediumint(8) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `uid` int(11) NOT NULL DEFAULT '0' COMMENT '网站后台用户id',
  `im_name` varchar(120) NOT NULL DEFAULT '' COMMENT 'OpenFire用户名',
  `cus_name` varchar(120) NOT NULL COMMENT '客服名称',
  `shop_id` mediumint(7) NOT NULL DEFAULT '-1' COMMENT '商家编号',
  `cus_type` int(10) NOT NULL DEFAULT '0' COMMENT '客服类型',
  `cus_count` int(10) DEFAULT '0' COMMENT '客服对话次数',
  `cus_time` int(10) DEFAULT '0' COMMENT '客服对话时间',
  `cus_star` int(10) DEFAULT '0' COMMENT '客户满意度',
  `status` tinyint(1) DEFAULT '1' COMMENT '是否可用',
  `add_time` int(10) DEFAULT NULL,
  PRIMARY KEY (`cus_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

-- --------------------------------------------------------

--
-- 表的结构 `shop_columns`
--

CREATE TABLE IF NOT EXISTS `shop_columns` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `c_id` int(11) NOT NULL DEFAULT '0',
  `c_sid` int(11) NOT NULL DEFAULT '0',
  `is_system` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否系统内置',
  `c_title` varchar(60) NOT NULL,
  `c_txt` varchar(50) NOT NULL,
  `c_url` varchar(160) NOT NULL,
  `c_pid` int(11) NOT NULL DEFAULT '0',
  `c_type` varchar(10) NOT NULL DEFAULT 'news',
  `c_name` varchar(60) NOT NULL,
  `c_mo` varchar(50) NOT NULL,
  `c_simg` varchar(100) NOT NULL,
  `c_is` tinyint(1) NOT NULL DEFAULT '1',
  `c_seo` text NULL,
  `c_code` varchar(60)  NULL,
  `c_sort` smallint(5) NOT NULL DEFAULT '0',
  `c_power` tinyint(1) NOT NULL DEFAULT '0',
  `c_dir` varchar(60) NOT NULL,
  `c_look` tinyint(1) NOT NULL DEFAULT '1',
  `is_help` tinyint(1) NOT NULL DEFAULT '0',
  `c_width` smallint(4) NOT NULL DEFAULT '0',
  `c_height` smallint(4) NOT NULL DEFAULT '0',
  `c_num` smallint(4) NOT NULL DEFAULT '0',
  `c_member` tinyint(1) NOT NULL DEFAULT '0',
  `c_body` text NULL,
  `c_smtype` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `c_id` (`c_id`),
  KEY `c_pid` (`c_pid`),
  KEY `c_code` (`c_code`),
  KEY `c_type` (`c_type`),
  KEY `c_sort` (`c_sort`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

-- --------------------------------------------------------

--
-- 表的结构 `shop_comment`
--

CREATE TABLE IF NOT EXISTS `shop_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_sn` varchar(16) NOT NULL DEFAULT '',
  `item_id` int(11) NOT NULL DEFAULT '0' COMMENT '商品、文章等id',
  `spec` varchar(100) NOT NULL,
  `type` tinyint(1) NOT NULL DEFAULT '0' COMMENT '评论类型:0商品 1文章',
  `uid` int(11) NOT NULL DEFAULT '0',
  `content` varchar(1000) NOT NULL,
  `star` tinyint(1) NOT NULL DEFAULT '0' COMMENT '星级',
  `img` text NULL,
  `thumb` text NULL,
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态：0不显示，1显示',
  `is_anon` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否匿名',
  `addtime` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

-- --------------------------------------------------------

--
-- 表的结构 `shop_comment_reply`
--

CREATE TABLE IF NOT EXISTS `shop_comment_reply` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cid` int(11) NOT NULL COMMENT '评价id',
  `pid` int(11) NOT NULL DEFAULT '0' COMMENT '回复的id',
  `pid_type` tinyint(1) NOT NULL DEFAULT '0' COMMENT '回复的对象：0评论 1回复',
  `uid` int(11) NOT NULL DEFAULT '0' COMMENT '回复者',
  `reply_uid` int(11) NOT NULL DEFAULT '0' COMMENT '被回复人id',
  `role_type` tinyint(1) NOT NULL DEFAULT '0' COMMENT '账户类型：1管理员 2会员 3商家',
  `content` varchar(1000) NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态：0不显示，1显示',
  `ip` varchar(32) NOT NULL DEFAULT '',
  `addtime` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

-- --------------------------------------------------------

--
-- 表的结构 `shop_comm_attach_file`
--

CREATE TABLE IF NOT EXISTS `shop_comm_attach_file` (
  `id` varchar(32) NOT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `PATH` varchar(255) DEFAULT NULL,
  `FILE_SIZE` bigint(20) DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `shop_coupon`
--

CREATE TABLE IF NOT EXISTS `shop_coupon` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NULL,
  `code` varchar(30) NULL,
  `amount` decimal(10,0) NOT NULL DEFAULT '0' COMMENT '面额',
  `amount_reached` decimal(10,0) NOT NULL DEFAULT '0' COMMENT '使用条件的金额',
  `num` int(11) NOT NULL DEFAULT '0' COMMENT '发行量',
  `get_num` int(11) NOT NULL DEFAULT '0' COMMENT '已领取数量',
  `used_num` int(11) NOT NULL DEFAULT '0' COMMENT '已使用数量',
  `is_added` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否可叠加：0不可，1可叠加',
  `limit_start` int(11) NOT NULL DEFAULT '0' COMMENT '领取时间开始',
  `limit_end` int(11) NOT NULL DEFAULT '0' COMMENT '领取时间结束',
  `limit_num` tinyint(2) NOT NULL DEFAULT '0' COMMENT '每人限领数量',
  `day_num` tinyint(2) NOT NULL DEFAULT '0' COMMENT '每天限领数量',
  `user_day_num` tinyint(2) NOT NULL DEFAULT '0' COMMENT '每人每天限领数量',
  `date_start` int(10) NOT NULL DEFAULT '0' COMMENT '有效期开始',
  `date_end` int(10) NOT NULL DEFAULT '0' COMMENT '有效期结束',
  `days` smallint(3) NOT NULL DEFAULT '0' COMMENT '有效天数',
  `type` tinyint(1) NOT NULL DEFAULT '0' COMMENT '类型：1品类券，2商品券，3店铺券',
  `shop_id` int(11) NOT NULL DEFAULT '0' COMMENT '店铺ID,平台直营为 1',
  `grade_ids` varchar(255) NOT NULL DEFAULT '' COMMENT '会员等级',
  `addtime` int(10) NOT NULL DEFAULT '0',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '状态：0停用，1开启',
  `client` varchar(20) NOT NULL DEFAULT '0' COMMENT '客户端类型,0所有,1 pc,2 wap,3 app, 混合用逗号隔开 如1,3',
  `get_type` tinyint(1) NOT NULL DEFAULT '0' COMMENT '发放方式：1买家领取,2平台发放',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=0 ;

CREATE TABLE IF NOT EXISTS `shop_coupon_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cid` int(11) NOT NULL DEFAULT '0' COMMENT '券id',
  `item_id` int(11) NOT NULL DEFAULT '0' COMMENT '商品id/品类id',
  PRIMARY KEY (`id`),
  KEY `cid` (`cid`),
  KEY `cid_2` (`cid`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=0 ;

CREATE TABLE IF NOT EXISTS `shop_coupon_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cid` int(11) NOT NULL DEFAULT '0' COMMENT '券ID',
  `code` varchar(12) NOT NULL DEFAULT '' COMMENT '券编号',
  `uid` int(11) NOT NULL DEFAULT '0' COMMENT '会员ID',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '状态：0未使用，1已使用，2已过期，3已冻结',
  `get_time` int(11) NOT NULL DEFAULT '0' COMMENT '领取时间',
  `ip` varchar(50) NOT NULL DEFAULT '' COMMENT '领取人ip',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=0 ;


--
-- 表的结构 `shop_cron`
--

CREATE TABLE IF NOT EXISTS `shop_cron` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '名称',
  `filename` varchar(255) NOT NULL DEFAULT '0' COMMENT '执行时间',
  `lasttime` int(11) NOT NULL DEFAULT '0' COMMENT '上次执行时间',
  `nexttime` int(11) NOT NULL DEFAULT '0' COMMENT '下次执行时间',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '状态',
  `week` varchar(255) NOT NULL DEFAULT '' COMMENT '每周几',
  `day` varchar(255) NOT NULL DEFAULT '' COMMENT '每月几号',
  `hour` varchar(255) NOT NULL DEFAULT '' COMMENT '每天几时',
  `minute` varchar(255) NOT NULL COMMENT '每时几分钟',
  `memo` text NULL,
  `addtime` int(11) NOT NULL DEFAULT '0' COMMENT '添加时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

-- --------------------------------------------------------

--
-- 表的结构 `shop_delivery`
--

CREATE TABLE IF NOT EXISTS `shop_delivery` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_sn` varchar(16) NOT NULL DEFAULT '',
  `exp_id` int(11) NOT NULL,
  `exp_no` varchar(30) NOT NULL,
  `exp_time` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

-- --------------------------------------------------------

--
-- 表的结构 `shop_delivery_goods`
--

CREATE TABLE IF NOT EXISTS `shop_delivery_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `delivery_id` int(11) NOT NULL,
  `goods_id` int(11) NOT NULL,
  `spec` varchar(100) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

-- --------------------------------------------------------

--
-- 表的结构 `shop_district`
--

CREATE TABLE IF NOT EXISTS `shop_district` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `pid` int(10) NOT NULL,
  `name` varchar(50) NOT NULL DEFAULT '',
  `pinyin` varchar(100) NOT NULL DEFAULT '',
  `lng` varchar(20) NOT NULL DEFAULT '',
  `lat` varchar(20) NOT NULL DEFAULT '',
  `level` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `sort` tinyint(3) unsigned NOT NULL DEFAULT '50' COMMENT '排序',
  PRIMARY KEY (`id`),
  KEY `parent_id` (`pid`) USING BTREE,
  KEY `parent_id_2` (`pid`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `shop_diy`
--

CREATE TABLE IF NOT EXISTS `shop_diy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `diy_type` varchar(20) NOT NULL DEFAULT '0',
  `code` varchar(64) NULL DEFAULT '',
  `title` varchar(200) NOT NULL,
  `body` text NULL,
  `type` varchar(20) NULL,
  `num` smallint(3) NOT NULL DEFAULT '0',
  `is_eachnum` tinyint(1) NOT NULL DEFAULT '0',
  `is_childnum` tinyint(1) NOT NULL DEFAULT '0',
  `name` varchar(20) NOT NULL,
  `index` smallint(1) NOT NULL DEFAULT '0',
  `recommends` varchar(100) NOT NULL,
  `cus_type` TINYINT(1) NOT NULL DEFAULT  '0' COMMENT  '内容类型',
  `cat_ids` varchar(255) NOT NULL,
  `ids` TEXT NULL COMMENT  '通用id集',
  `include_son` tinyint(1) NOT NULL DEFAULT '0',
  `promotion_ids` varchar(255) DEFAULT '',
  `client` varchar(20) NOT NULL COMMENT '客户端类型,0所有,1 pc,2 wap,3 app, 混合用逗号隔开 如1,3',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `shop_express`
--

CREATE TABLE IF NOT EXISTS `shop_express` (
  `id` smallint(5) NOT NULL AUTO_INCREMENT,
  `grade_id` varchar(200) NOT NULL,
  `express_type` tinyint(1) NOT NULL DEFAULT '0',
  `money_reached` decimal(10,2) NOT NULL DEFAULT '0.00',
  `express_fee` decimal(10,2) NOT NULL DEFAULT '0.00',
  `sort` smallint(6) NOT NULL DEFAULT '0',
  `shop_id` mediumint(8) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

CREATE TABLE IF NOT EXISTS `shop_express_track` (
  `code` varchar(50) NOT NULL DEFAULT '',
  `name` varchar(50) NOT NULL DEFAULT '',
  `appid` varchar(50) NOT NULL DEFAULT '',
  `appkey` varchar(50) NOT NULL DEFAULT '',
  `status` tinyint(1) NOT NULL DEFAULT '0',
  `memo` varchar(500) NOT NULL DEFAULT ''
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- 表的结构 `shop_express_common`
--

CREATE TABLE IF NOT EXISTS `shop_express_common` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '名称',
  `code` varchar(50) NOT NULL DEFAULT '' COMMENT '快递代码',
  `code2` varchar(50) NOT NULL DEFAULT '' COMMENT '代码2',
  `status` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '开关(1:开启,0:关闭)',
  `express_type` tinyint(1) NOT NULL DEFAULT '1',
  `logo` varchar(200) NOT NULL DEFAULT '',
  `insure` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '保价',
  `tpl` text NULL COMMENT '快递单模版内容',
  `sort` tinyint(3) unsigned NOT NULL DEFAULT '100' COMMENT '排序',
  `addtime` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`) USING BTREE
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COMMENT='配送方式表' AUTO_INCREMENT=1;

-- --------------------------------------------------------

--
-- 表的结构 `shop_express_district`
--

CREATE TABLE IF NOT EXISTS `shop_express_district` (
  `id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `express_id` smallint(5) unsigned NOT NULL DEFAULT '0',
  `first_price` decimal(10,2) unsigned NOT NULL DEFAULT '0.00' COMMENT '配送金额',
  `added_price` decimal(10,2) NOT NULL DEFAULT '0.00',
  `first_weight` int(10) NOT NULL DEFAULT '0',
  `added_weight` int(10) NOT NULL DEFAULT '0',
  `district_id` text NOT NULL COMMENT '地区ID',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COMMENT='物流地区设置' AUTO_INCREMENT=1;

-- --------------------------------------------------------

--
-- 表的结构 `shop_express_picksite`
--

CREATE TABLE IF NOT EXISTS `shop_express_picksite` (
  `id` smallint(5) NOT NULL AUTO_INCREMENT,
  `express_id` smallint(5) NOT NULL DEFAULT '0',
  `picker` varchar(50) NOT NULL,
  `tel` varchar(50) NOT NULL,
  `picktime` varchar(100) NOT NULL,
  `province` int(10) NOT NULL,
  `city` int(10) NOT NULL,
  `district` int(10) NOT NULL,
  `address` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

-- --------------------------------------------------------

--
-- 表的结构 `shop_goods`
--

CREATE TABLE IF NOT EXISTS `shop_goods` (
  `goods_id` mediumint(8) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) NOT NULL DEFAULT '',
  `cat_id` smallint(5) NOT NULL DEFAULT '0',
  `name` varchar(200) NOT NULL,
  `subname` varchar(150) NOT NULL DEFAULT '',
  `brand_id` smallint(5) NOT NULL DEFAULT '0',
  `goods_type` smallint(5) NOT NULL DEFAULT '0',
  `virtype` tinyint(1) NOT NULL DEFAULT '0',
  `price` decimal(10,2) NOT NULL DEFAULT '0.00',
  `marketprice` decimal(10,2) NOT NULL DEFAULT '0.00',
  `costprice` decimal(10,2) NOT NULL DEFAULT '0.00',
  `weight` mediumint(8) NOT NULL DEFAULT '0',
  `sn` varchar(100) NOT NULL,
  `barcode` varchar(50) NOT NULL DEFAULT '',
  `unit` varchar(10) NOT NULL,
  `number` mediumint(8) NOT NULL DEFAULT '0',
  `warnnum` smallint(5) NOT NULL DEFAULT '0',
  `status` tinyint(1) NOT NULL DEFAULT '1',
  `addtime` int(10) NOT NULL DEFAULT '0',
  `updatetime` int(10) NOT NULL DEFAULT '0',
  `uptime` int(10) NOT NULL DEFAULT '0',
  `downtime` int(8) NOT NULL DEFAULT '0',
  `salenum` mediumint(8) NOT NULL DEFAULT '0',
  `virtualnum` mediumint(8) NOT NULL DEFAULT '0',
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
  PRIMARY KEY (`goods_id`),
  KEY `uptime` (`uptime`),
  KEY `sort` (`sort`),
  KEY `hot` (`hot`),
  KEY `new` (`new`),
  KEY `best` (`best`),
  KEY `freeshipping` (`freeshipping`),
  KEY `price` (`price`),
  KEY `brand_id` (`brand_id`),
  KEY `cat_id` (`cat_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `shop_goods_attr`
--

CREATE TABLE IF NOT EXISTS `shop_goods_attr` (
  `goods_id` mediumint(8) NOT NULL DEFAULT '0',
  `attr_ids` varchar(255) NOT NULL DEFAULT '',
  `values` varchar(255) NOT NULL DEFAULT ''
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- --------------------------------------------------------

--
-- 表的结构 `shop_goods_cat`
--

CREATE TABLE IF NOT EXISTS `shop_goods_cat` (
  `goods_id` mediumint(8) NOT NULL DEFAULT '0',
  `cat_id` smallint(5) NOT NULL DEFAULT '0'
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `shop_goods_spec`
--

CREATE TABLE IF NOT EXISTS `shop_goods_spec` (
  `sku_id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_id` mediumint(8) NOT NULL DEFAULT '0',
  `type` tinyint(1) NOT NULL DEFAULT '0',
  `attr_ids` varchar(200) NOT NULL DEFAULT '',
  `values` varchar(255) NOT NULL DEFAULT '',
  `number` varchar(8) DEFAULT '0',
  `price` decimal(10,2) DEFAULT '0.00',
  `marketprice` decimal(10,2) DEFAULT '0.00',
  `costprice` decimal(10,2) DEFAULT '0.00',
  `weight` mediumint(8) DEFAULT '0',
  `sn` varchar(50) DEFAULT NULL,
  `barcode` varchar(50) NOT NULL,
  PRIMARY KEY (`sku_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `shop_link`
--

CREATE TABLE IF NOT EXISTS `shop_link` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `c_id` int(11) NOT NULL DEFAULT '0',
  `c_sid` int(11) NOT NULL DEFAULT '0',
  `c_index` int(11) NOT NULL DEFAULT '0',
  `c_title` varchar(200) NOT NULL,
  `c_simg` varchar(255) NOT NULL,
  `c_url` varchar(255) NOT NULL,
  `c_code` varchar(200)  NULL,
  `c_is` smallint(1) NOT NULL DEFAULT '1',
  `c_time` int(11) NOT NULL DEFAULT '0',
  `c_order` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `c_sid` (`c_sid`),
  KEY `c_is` (`c_is`),
  KEY `c_index` (`c_index`),
  KEY `c_id` (`c_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

-- --------------------------------------------------------

--
-- 表的结构 `shop_login_log`
--

CREATE TABLE IF NOT EXISTS `shop_login_log` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `uid` mediumint(8) NOT NULL DEFAULT '0',
  `ip` varchar(20) NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '登陆情况：1成功,2失败',
  `role_type` tinyint(1) NOT NULL DEFAULT '0' COMMENT '账户类型：1管理员 2会员 3商家',
  `count` tinyint(1) NOT NULL DEFAULT '0',
  `lasttime` int(8) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

-- --------------------------------------------------------

--
-- 表的结构 `shop_member`
--

CREATE TABLE IF NOT EXISTS `shop_member` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sex` tinyint(1) NOT NULL DEFAULT '0' COMMENT '1男 2女',
  `realname` varchar(50) DEFAULT '',
  `addtime` int(11) DEFAULT '0',
  `uname` varchar(100) NOT NULL,
  `img` varchar(255) NOT NULL DEFAULT '',
  `tel` varchar(60) NOT NULL DEFAULT '',
  `mobile` varchar(60) NOT NULL DEFAULT '',
  `pwd` varchar(255) NOT NULL,
  `salt` varchar(10) NOT NULL,
  `email` varchar(120) DEFAULT '',
  `ip` varchar(200) DEFAULT '',
  `status` tinyint(1) NOT NULL DEFAULT '0',
  `grade_id` smallint(8) NOT NULL DEFAULT '0',
  `birthday` int(11) NOT NULL DEFAULT '0',
  `qq` varchar(30) DEFAULT '',
  `logintime` int(11) NOT NULL DEFAULT '0',
  `point` int(11) NOT NULL DEFAULT '0' COMMENT '积分',
  `balance` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '余额',
  `paypwd` varchar(64) DEFAULT '',
  `salt_pay` varchar(10) DEFAULT '',
  `memo` varchar(500) DEFAULT '' COMMENT '个人简介',
  `is_im` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否开通im:0未开通,1开通',
  `devicetoken` varchar(64) NOT NULL DEFAULT '' COMMENT '设备令牌',
  `devicetype` varchar(32) NOT NULL DEFAULT '' COMMENT '设备类型',
  `commiss_id` int(11) NOT NULL DEFAULT '0' COMMENT '分销级别',
  `pid1` int(11) NOT NULL DEFAULT '0' COMMENT '上1级id',
  `pid2` int(11) NOT NULL DEFAULT '0' COMMENT '上2级id',
  `pid3` int(11) NOT NULL DEFAULT '0' COMMENT '上3级id',
  PRIMARY KEY (`id`),
  KEY `c_id` (`sex`),
  KEY `c_mail` (`email`),
  KEY `c_is` (`status`),
  KEY `grade_id` (`grade_id`),
  KEY `sex` (`sex`),
  KEY `uname` (`uname`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `shop_member_address`
--

CREATE TABLE IF NOT EXISTS `shop_member_address` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `uid` mediumint(8) unsigned NOT NULL DEFAULT '0' COMMENT '会员id',
  `name` varchar(20) NOT NULL DEFAULT '' COMMENT '收货人',
  `mobile` char(11) NOT NULL DEFAULT '' COMMENT '联系电话',
  `tel` varchar(20) NOT NULL DEFAULT '',
  `county` int(10) NOT NULL DEFAULT '0' COMMENT '国家',
  `province` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '省ID',
  `city` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '市ID',
  `area` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '县区ID',
  `town` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '镇ID',
  `address` varchar(255) NOT NULL DEFAULT '' COMMENT '详细地址',
  `is_default` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否默认',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COMMENT='用户收货地址' AUTO_INCREMENT=1;

-- --------------------------------------------------------

--
-- 表的结构 `shop_member_fav`
--

CREATE TABLE IF NOT EXISTS `shop_member_fav` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `goods_id` int(11) NOT NULL,
  `spec` varchar(100) NOT NULL DEFAULT '',
  `addtime` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

-- --------------------------------------------------------

--
-- 表的结构 `shop_member_grade`
--

CREATE TABLE IF NOT EXISTS `shop_member_grade` (
  `grade_id` mediumint(8) NOT NULL AUTO_INCREMENT,
  `grade_name` varchar(50) NOT NULL,
  `point_require` smallint(8) NOT NULL DEFAULT '0',
  `discount` tinyint(2) NOT NULL DEFAULT '0' COMMENT '折扣',
  `sort` smallint(5) NOT NULL DEFAULT '10',
  `is_default` tinyint(1) DEFAULT '0' COMMENT '默认等级，0否，1是',
  PRIMARY KEY (`grade_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

-- --------------------------------------------------------

--
-- 表的结构 `shop_member_log`
--

CREATE TABLE IF NOT EXISTS `shop_member_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` mediumint(8) NOT NULL DEFAULT '0',
  `order_sn` varchar(16) NOT NULL DEFAULT '' COMMENT '订单号',
  `type` tinyint(1) NOT NULL DEFAULT '1' COMMENT '类型：1余额，2积分',
  `val` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '变动值',
  `description` varchar(255) NOT NULL,
  `addtime` int(11) NOT NULL DEFAULT '0',
  `role_type` tinyint(1) DEFAULT '0' COMMENT '账户类型：1管理员 2会员 3商家',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COMMENT='资金变动表' AUTO_INCREMENT=1;

-- --------------------------------------------------------

--
-- 表的结构 `shop_member_oauth`
--

CREATE TABLE IF NOT EXISTS `shop_member_oauth` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `unionid` varchar(50) NOT NULL COMMENT '用户统一标识',
  `openid` varchar(50) NOT NULL,
  `platform` varchar(20) NOT NULL COMMENT '平台：mp微信公众号 op微信开放平台',
  `type` varchar(10) NOT NULL COMMENT 'wx,qq,wb,ali,tb',
  `addtime` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `uid` (`uid`,`openid`,`type`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

-- --------------------------------------------------------

--
-- 表的结构 `shop_member_price`
--

CREATE TABLE IF NOT EXISTS `shop_member_price` (
  `goods_id` int(11) NOT NULL COMMENT '商品id',
  `sku_id` int(11) NOT NULL DEFAULT '0',
  `grade_id` mediumint(8) NOT NULL DEFAULT '0' COMMENT '会员等级',
  `price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '价格'
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `shop_member_token`
--

CREATE TABLE IF NOT EXISTS `shop_member_token` (
  `sid` varchar(50) NOT NULL COMMENT 'token',
  `uid` int(11) NOT NULL DEFAULT '0' COMMENT '用户id',
  `expire` int(11) NOT NULL DEFAULT '0' COMMENT '过期时间',
  `ip` varchar(50) NOT NULL DEFAULT '' COMMENT 'ip',
  PRIMARY KEY (`sid`),
  KEY `uid` (`uid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `shop_message`
--

CREATE TABLE IF NOT EXISTS `shop_message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) NULL,
  `name` varchar(50) NULL,
  `desc` varchar(255)  NULL,
  `status` tinyint(1) NOT NULL DEFAULT '0',
  `config` text NOT NULL,
  PRIMARY KEY (`id`),
  KEY `c_id` (`code`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

-- --------------------------------------------------------

--
-- 表的结构 `shop_module`
--

CREATE TABLE IF NOT EXISTS `shop_module` (
  `id` varchar(32) NOT NULL,
  `DISPLAY_INDEX` varchar(32) DEFAULT NULL,
  `FULL_SCREEN` varchar(32) DEFAULT NULL,
  `FUNC_URL` longtext,
  `IMG_SRC` varchar(255) DEFAULT NULL,
  `NAME` varchar(32) DEFAULT NULL,
  `PID` varchar(32) DEFAULT NULL,
  `TYPE` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `shop_nav`
--

CREATE TABLE IF NOT EXISTS `shop_nav` (
  `id` smallint(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `url` varchar(255) NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '0',
  `sort` smallint(5) NOT NULL,
  `target` tinyint(1) NOT NULL DEFAULT '0',
  `type` varchar(3) NOT NULL COMMENT 'top,bot,mid',
  `style` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

-- --------------------------------------------------------

--
-- 表的结构 `shop_news`
--

CREATE TABLE IF NOT EXISTS `shop_news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `c_c` smallint(1) NOT NULL DEFAULT '0',
  `c_id` int(11) NOT NULL DEFAULT '0',
  `c_sid` int(11) NOT NULL DEFAULT '0',
  `c_title` varchar(200) NOT NULL DEFAULT '',
  `c_body` mediumtext NOT NULL ,
  `c_txt` text NULL ,
  `c_author` varchar(200) NOT NULL DEFAULT '',
  `c_addtime` int(11) NOT NULL DEFAULT '0',
  `c_time` int(11) NOT NULL DEFAULT '0',
  `c_toid` int(11) NOT NULL DEFAULT '0',
  `c_code` varchar(60) NOT NULL DEFAULT '',
  `c_simg` varchar(200) NOT NULL DEFAULT '',
  `c_bimg` varchar(160) NOT NULL DEFAULT '',
  `sort` int(11) NOT NULL DEFAULT '0',
  `c_is` tinyint(1) NOT NULL DEFAULT '1',
  `c_count` int(11) NOT NULL DEFAULT '0',
  `c_smtype` varchar(1) DEFAULT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  KEY `c_id` (`c_id`),
  KEY `c_columns` (`c_toid`),
  KEY `c_addtime` (`c_addtime`),
  KEY `c_time` (`c_time`),
  KEY `c_sid` (`c_sid`),
  KEY `c_title` (`c_title`),
  KEY `c_c` (`c_c`),
  KEY `c_order` (`sort`),
  KEY `c_simg` (`c_simg`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

-- --------------------------------------------------------

--
-- 表的结构 `shop_oauth`
--

CREATE TABLE IF NOT EXISTS `shop_oauth` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(10) NULL COMMENT 'wx,qq,wb,ali,tb',
  `name` varchar(100) NOT NULL,
  `appid` varchar(50) NOT NULL,
  `appsecret` varchar(100) NOT NULL,
  `remark` text NULL,
  `status` tinyint(1) NOT NULL DEFAULT '1',
  `is_qrcode` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否扫码',
  `memo` varchar(500) NOT NULL DEFAULT '' COMMENT '备注',
  `sort` tinyint(2) NOT NULL DEFAULT '0',
  `addtime` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

-- --------------------------------------------------------

--
-- 表的结构 `shop_order`
--

CREATE TABLE IF NOT EXISTS `shop_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_sn` varchar(16) NOT NULL DEFAULT '0',
  `uid` mediumint(8) NOT NULL DEFAULT '0',
  `amount` decimal(12,2) DEFAULT '0.00' COMMENT '订单金额',
  `payble_amount` decimal(12,2) DEFAULT '0.00' COMMENT '待支付金额',
  `pay_fee` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '第三方支付的金额',
  `goods_amount` decimal(12,2) NOT NULL DEFAULT '0.00' COMMENT '商品金额',
  `exp_amount` decimal(12,2) NOT NULL DEFAULT '0.00' COMMENT '运费',
  `balance_amount` decimal(12,2) NOT NULL DEFAULT '0.00' COMMENT '使用余额',
  `point_amount` decimal(12,2) NOT NULL DEFAULT '0.00' COMMENT '积分抵用金额',
  `coupon_amount` decimal(12,2) NOT NULL DEFAULT '0.00' COMMENT '优惠券抵用金额',
  `coupon_ids` VARCHAR( 255 ) NOT NULL DEFAULT  '' COMMENT '优惠券id',
  `cashback` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '返现金额',
  `cnee_name` varchar(20) NOT NULL DEFAULT '',
  `cnee_mobile` varchar(20) NOT NULL DEFAULT '',
  `cnee_tel` varchar(20) NOT NULL DEFAULT '',
  `cnee_dist_ids` varchar(100) NOT NULL DEFAULT '',
  `cnee_dist_name` varchar(50) NOT NULL DEFAULT '' COMMENT '收货人区域',
  `cnee_address` varchar(100) NOT NULL COMMENT '收货地址',
  `pay_code` varchar(20) NOT NULL DEFAULT '' COMMENT '支付方式',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '订单状态：1等待付款,2正在发货,3等待收货,6取消，7删除,8完成',
  `pay_status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '支付状态',
  `deliver_status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '发货状态：0未发货，1部分发货, 2已发货',
  `trade_no` varchar(50) NOT NULL DEFAULT '' COMMENT '支付交易号',
  `trade_buyer` varchar(50) NOT NULL DEFAULT '' COMMENT '支付人账号',
  `trade_msg` varchar(200) NOT NULL DEFAULT '' COMMENT '支付信息',
  `pay_time` int(11) NOT NULL DEFAULT '0',
  `exp_id` mediumint(8) NOT NULL DEFAULT '0' COMMENT '配送方式Id',
  `exp_no` varchar(30) NOT NULL DEFAULT '',
  `is_comment` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否评价',
  `invoice_title` varchar(200) NOT NULL DEFAULT '' COMMENT '发票抬头',
  `invoice_con` varchar(200) NOT NULL DEFAULT '' COMMENT '发票内容',
  `client` tinyint(1) NOT NULL DEFAULT '0' COMMENT '订单来源：1pc,2wap,3app',
  `order_type` tinyint(2) NOT NULL DEFAULT '0' COMMENT '订单类型：0实物',
  `add_time` int(11) NOT NULL COMMENT '下单时间',
  `deliver_time` int(11) NOT NULL DEFAULT '0' COMMENT '发货时间',
  `receiving_time` int(11) NOT NULL DEFAULT '0' COMMENT '收货时间',
  `user_remark` varchar(200) NOT NULL DEFAULT '' COMMENT '用户留言',
  `remark` varchar(200) NOT NULL DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`),
  UNIQUE KEY `order_sn` (`order_sn`),
  KEY `c_id` (`order_sn`,`uid`),
  KEY `c_time` (`exp_amount`),
  KEY `c_ip` (`point_amount`),
  KEY `uid` (`uid`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

-- --------------------------------------------------------

--
-- 表的结构 `shop_order_goods`
--

CREATE TABLE IF NOT EXISTS `shop_order_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) NOT NULL DEFAULT '0',
  `goods_id` int(11) NOT NULL DEFAULT '0',
  `spec` varchar(100) NOT NULL DEFAULT '',
  `num` int(11) NOT NULL,
  `price` decimal(10,2) NOT NULL DEFAULT '0.00',
  `costprice` decimal(10,2) NOT NULL DEFAULT '0.00',
  `name` varchar(100) NOT NULL DEFAULT '',
  `point` int(11) NOT NULL DEFAULT '0' COMMENT '赠送积分',
  `act_type` TINYINT NOT NULL DEFAULT  '0' COMMENT  '活动类型：1拼团',
  `act_data` VARCHAR( 200 ) NULL DEFAULT  '' COMMENT  '活动数据',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `shop_order_log`
--

CREATE TABLE IF NOT EXISTS `shop_order_log` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `order_sn` char(20) NOT NULL DEFAULT '' COMMENT '订单号',
  `exp_no` varchar(30) NOT NULL DEFAULT '',
  `op_uid` mediumint(8) unsigned NOT NULL DEFAULT '0' COMMENT '操作者ID',
  `op_name` varchar(60) NOT NULL DEFAULT '' COMMENT '操作者名称',
  `op_type` tinyint(1) unsigned NOT NULL DEFAULT '2' COMMENT '操作者类型(1:后台管理员,2:会员3:商家(预留))',
  `msg` text NULL COMMENT '日志详情',
  `addtime` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '操作时间',
  `ip` char(15) NOT NULL DEFAULT '' COMMENT '操作者IP',
  PRIMARY KEY (`id`),
  KEY `order_sn` (`order_sn`) USING BTREE
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COMMENT='订单日志表' AUTO_INCREMENT=1;

-- --------------------------------------------------------

--
-- 表的结构 `shop_order_refund`
--

CREATE TABLE IF NOT EXISTS `shop_order_refund` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `refund_no` varchar(16) NOT NULL DEFAULT '' COMMENT '退款单号',
  `trade_no` varchar(50) NOT NULL DEFAULT '' COMMENT '第三方支付退款单号',
  `trade_msg` varchar(200) NOT NULL DEFAULT '' COMMENT '第三方支付返回信息',
  `pay_time` int(11) NOT NULL DEFAULT '0' COMMENT '退款时间',
  `order_sn` varchar(16) NOT NULL DEFAULT '' COMMENT '订单号',
  `refund_fee` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '退款金额',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '状态：0退款中  1退款成功',
  `uid` int(11) NOT NULL DEFAULT '0' COMMENT '操作人ID',
  `addtime` int(11) NOT NULL DEFAULT '0' COMMENT '添加时间',
  PRIMARY KEY (`id`),
  KEY `order_sn` (`order_sn`),
  KEY `uid` (`uid`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

-- --------------------------------------------------------

--
-- 表的结构 `shop_order_service`
--

CREATE TABLE IF NOT EXISTS `shop_order_service` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL DEFAULT '0',
  `order_sn` varchar(16) NOT NULL,
  `goods_id` int(11) NOT NULL DEFAULT '0',
  `spec` varchar(100) NOT NULL DEFAULT '',
  `type` tinyint(1) NOT NULL DEFAULT '0' COMMENT '类型：1换货，2退货，3维修',
  `num` int(11) NOT NULL DEFAULT '0',
  `content` varchar(500) NOT NULL DEFAULT '',
  `img` text NULL,
  `thumb` text NULL,
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '状态：1处理中 2审核通过 3审核不通过 4商品处理 5取消 8已完成',
  `refund_fee` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '退款',
  `refund_no` varchar(16) NOT NULL DEFAULT '0' COMMENT '退款单号',
  `address` varchar(200) NOT NULL DEFAULT '',
  `uname` varchar(30) NOT NULL DEFAULT '',
  `mobile` varchar(15) NOT NULL DEFAULT '',
  `remark` varchar(500) NOT NULL DEFAULT '' COMMENT '备注',
  `addtime` int(10) NOT NULL DEFAULT '0',
  `updatetime` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

-- --------------------------------------------------------

--
-- 表的结构 `shop_page`
--

CREATE TABLE IF NOT EXISTS `shop_page` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `c_id` int(11) NOT NULL DEFAULT '0',
  `c_sid` int(11) NOT NULL DEFAULT '0',
  `c_title` varchar(200) NULL,
  `c_toid` int(11) NOT NULL DEFAULT '0',
  `c_body` mediumtext NOT NULL,
  PRIMARY KEY (`id`),
  KEY `c_id` (`c_id`),
  KEY `c_sid` (`c_sid`),
  KEY `c_toid` (`c_toid`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

-- --------------------------------------------------------

--
-- 表的结构 `shop_payment`
--

CREATE TABLE IF NOT EXISTS `shop_payment` (
  `pay_code` varchar(50) NOT NULL DEFAULT '',
  `pay_name` varchar(120) NOT NULL DEFAULT '',
  `pay_fee` varchar(5) NOT NULL DEFAULT '',
  `pay_desc` text NULL ,
  `status` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '启用状态',
  `config` text NULL,
  `addtime` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '更新时间',
  `sort` int(8) unsigned NOT NULL DEFAULT '10',
  `isonline` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '是否在线支付',
  `is_redirect` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否需要跳转',
  `client` varchar(20) NOT NULL DEFAULT '0' COMMENT '客户端类型,0所有,1 pc,2 wap,3 app, 混合用逗号隔开 如1,3',
  PRIMARY KEY (`pay_code`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='支付方式配置信息';

-- --------------------------------------------------------

--
-- 表的结构 `shop_pay_log`
--

CREATE TABLE IF NOT EXISTS `shop_pay_log` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `pay_sn` varchar(16) NOT NULL COMMENT '支付单号',
  `order_sn` varchar(16) NOT NULL DEFAULT '' COMMENT '订单号',
  `uid` int(11) NOT NULL DEFAULT '0',
  `amount` decimal(10,2) unsigned NOT NULL DEFAULT '0.00',
  `type` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '订单类型',
  `pay_status` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '状态：0处理中，1完成',
  `pay_code` varchar(20) NOT NULL DEFAULT '' COMMENT '支付方式代码',
  `trade_no` varchar(50) NOT NULL DEFAULT '' COMMENT '支付交易号',
  `trade_buyer` varchar(50) NOT NULL DEFAULT '' COMMENT '支付账号',
  `trade_msg` varchar(200) NOT NULL DEFAULT '' COMMENT '支付信息',
  `addtime` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `shop_plugin`
--

CREATE TABLE IF NOT EXISTS `shop_plugin` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '插件id',
  `code` varchar(50) NULL,
  `name` varchar(100) NULL,
  `author` varchar(50) NOT NULL COMMENT '作者',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '状态',
  `version` varchar(50) NOT NULL DEFAULT '' COMMENT '版本',
  `config` text NULL COMMENT '配置',
  `memo` varchar(500) NOT NULL DEFAULT '' COMMENT '说明',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=662 ;

--
-- 表的结构 `shop_plugin_robotcomment`
--

CREATE TABLE IF NOT EXISTS `shop_plugin_robotcomment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` tinyint(2) NOT NULL DEFAULT '0' COMMENT '分类',
  `content` varchar(500) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=61 ;

--
-- 表的结构 `shop_role`
--

CREATE TABLE IF NOT EXISTS `shop_role` (
  `id` varchar(32) NOT NULL,
  `ROLE_NAME` varchar(255) DEFAULT NULL,
  `ROLE_TYPE` varchar(32) DEFAULT NULL,
  `STATUS_` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `shop_service_config`
--

CREATE TABLE IF NOT EXISTS `shop_service_config` (
  `id` varchar(32) NOT NULL,
  `CONN_NAME` varchar(255) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `CTRL_LIMIT` varchar(255) DEFAULT NULL,
  `DATA_CTRL_TYPE` varchar(255) DEFAULT NULL,
  `DELETE_` varchar(255) DEFAULT NULL,
  `FIELDS` varchar(255) DEFAULT NULL,
  `IS_ALL` varchar(255) DEFAULT NULL,
  `JSON_` longtext,
  `name` varchar(255) DEFAULT NULL,
  `NULL_FIELDS` varchar(255) DEFAULT NULL,
  `SQL_` varchar(255) DEFAULT NULL,
  `TYPE_` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `shop_service_log`
--

CREATE TABLE IF NOT EXISTS `shop_service_log` (
  `id` varchar(32) NOT NULL,
  `ARGS_` varchar(255) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `REMOTE_IP` varchar(255) DEFAULT NULL,
  `RESULT_` text,
  `STATUS` varchar(255) DEFAULT NULL,
  `TYPE` varchar(255) DEFAULT NULL,
  `USR_ID` varchar(255) DEFAULT NULL,
  `service_conf_id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2B60D70FF0471112` (`service_conf_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `shop_service_server_user`
--

CREATE TABLE IF NOT EXISTS `shop_service_server_user` (
  `id` varchar(32) NOT NULL,
  `EMAIL` varchar(32) DEFAULT NULL,
  `LAST_LOGIN_DATE` datetime DEFAULT NULL,
  `LOGIN_ID` varchar(32) DEFAULT NULL,
  `MEMO` varchar(255) DEFAULT NULL,
  `MOBILE` varchar(32) DEFAULT NULL,
  `SEX` varchar(32) DEFAULT NULL,
  `STATUS_` varchar(32) DEFAULT NULL,
  `USER_NAME` varchar(50) DEFAULT NULL,
  `USER_PWD` varchar(180) DEFAULT NULL,
  `USER_TYPE` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `shop_service_usr`
--

CREATE TABLE IF NOT EXISTS `shop_service_usr` (
  `id` varchar(32) NOT NULL,
  `CHARGE_MAN` varchar(255) DEFAULT NULL,
  `IP_ADDR` varchar(255) DEFAULT NULL,
  `LOGIN_ID` varchar(255) DEFAULT NULL,
  `MOBILE` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `SYSTEM_` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `shop_service_usr_cfg`
--

CREATE TABLE IF NOT EXISTS `shop_service_usr_cfg` (
  `USER_ID` varchar(32) NOT NULL,
  `CFG_ID` varchar(32) NOT NULL,
  KEY `FK35A36564B1F9401E` (`USER_ID`),
  KEY `FK35A365649443CF5C` (`CFG_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `shop_shop_config`
--

CREATE TABLE IF NOT EXISTS `shop_shop_config` (
  `key` varchar(200) NOT NULL,
  `value` text,
  `desc` varchar(100) NOT NULL,
  PRIMARY KEY (`key`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;



--
-- 表的结构 `shop_sms_config`
--

CREATE TABLE IF NOT EXISTS `shop_sms_config` (
  `code` varchar(50) NOT NULL DEFAULT '',
  `name` varchar(50) NOT NULL,
  `signname` varchar(50) NOT NULL DEFAULT '',
  `config` text NULL,
  `status` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`code`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `shop_sms_session`
--

CREATE TABLE IF NOT EXISTS `shop_sms_session` (
   `id` int(11) NOT NULL AUTO_INCREMENT,
  `mobile` varchar(15) NOT NULL DEFAULT '',
  `code` varchar(8) NOT NULL DEFAULT '',
  `tpl_type` varchar(20) NOT NULL DEFAULT '' COMMENT '验证码类型 reg login,updatepwd',
  `uid` int(11) NOT NULL DEFAULT '0',
  `sendtime` int(11) NOT NULL DEFAULT '0',
  `ip` varchar(30) NOT NULL,
  `err_count` tinyint(4) NOT NULL DEFAULT '0' COMMENT '尝试次数',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '状态：0未使用，1已使用',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `shop_sp_discount`
--

CREATE TABLE IF NOT EXISTS `shop_sp_discount` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL COMMENT '活动名称',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否启用：0否，1是',
  `description` text NULL COMMENT '描述',
  `goods_ids` text NULL COMMENT '商品集，逗号隔开',
  `start_time` int(11) NOT NULL COMMENT '开始时间',
  `end_time` int(11) NOT NULL COMMENT '结束时间',
  `type` tinyint(1) NOT NULL DEFAULT '0' COMMENT '优惠方式:1统一价,2直减,3折扣',
  `val` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '优惠值',
  `grade_ids` varchar(100) NOT NULL DEFAULT '0' COMMENT '会员等级：多个逗号隔开，0所有',
  `addtime` int(11) NOT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COMMENT='限时抢购' AUTO_INCREMENT=1;

-- --------------------------------------------------------

--
-- 表的结构 `shop_sys_menu`
--

CREATE TABLE IF NOT EXISTS `shop_sys_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) NOT NULL DEFAULT '',
  `name` varchar(50) NOT NULL DEFAULT '',
  `url` varchar(255) NOT NULL DEFAULT '',
  `ico` varchar(200) NOT NULL DEFAULT '',
  `status` tinyint(4) NOT NULL DEFAULT '1',
  `sort` smallint(6) NOT NULL DEFAULT '0',
  `pid` smallint(6) NOT NULL DEFAULT '0',
  `level` tinyint(1) NOT NULL DEFAULT '0',
  `is_action` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否直接执行',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

-- --------------------------------------------------------

--
-- 表的结构 `shop_sys_perm`
--

CREATE TABLE IF NOT EXISTS `shop_sys_perm` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL DEFAULT '0',
  `mid` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

-- --------------------------------------------------------

--
-- 表的结构 `shop_sys_role`
--

CREATE TABLE IF NOT EXISTS `shop_sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '角色名',
  `mid` text  NULL COMMENT '菜单ID，逗号分隔',
  `status` tinyint(1) NOT NULL DEFAULT '0',
  `memo` varchar(200) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `shop_sys_role_user`
--

CREATE TABLE IF NOT EXISTS `shop_sys_role_user` (
  `role_id` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  KEY `role_id` (`role_id`),
  KEY `uid` (`uid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `shop_tpl`
--

CREATE TABLE IF NOT EXISTS `shop_tpl` (
  `id` smallint(5) NOT NULL AUTO_INCREMENT,
  `type` tinyint(2) NOT NULL DEFAULT '0' COMMENT '1发货单,2商品详情',
  `name` varchar(50) NOT NULL,
  `content` text NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

-- --------------------------------------------------------

--
-- 表的结构 `shop_type`
--

CREATE TABLE IF NOT EXISTS `shop_type` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT COMMENT '类型ID',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '类型名称',
  `sort` tinyint(1) unsigned NOT NULL DEFAULT '100' COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COMMENT='商品模型' AUTO_INCREMENT=1;

-- --------------------------------------------------------

--
-- 表的结构 `shop_user`
--

CREATE TABLE IF NOT EXISTS `shop_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) NOT NULL,
  `name` varchar(30) NOT NULL DEFAULT '',
  `coname` varchar(255) NULL,
  `pwd` varchar(64) NOT NULL,
  `salt` varchar(10) NOT NULL DEFAULT '',
  `lastip` varchar(32) NULL,
  `lastlogintime` int(11) NULL,
  `addtime` int(11) NOT NULL,
  `updatetime` int(11) NOT NULL DEFAULT '0',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0停用，1正常',
  PRIMARY KEY (`id`),
  KEY `username` (`username`),
  KEY `pwd` (`pwd`),
  KEY `extime` (`status`),
  KEY `addtime` (`addtime`),
  KEY `lastlogintime` (`lastlogintime`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

CREATE TABLE IF NOT EXISTS `shop_wx_config` (
  `appid` varchar(30) NOT NULL,
  `appsecret` varchar(50) NOT NULL,
  `originalid` varchar(30) NOT NULL COMMENT '原创ID',
  `token` varchar(32) NOT NULL,
  `encoding_aeskey` varchar(43) NOT NULL,
  `access_token` varchar(150) NOT NULL,
  `expire_time` varchar(15) NOT NULL,
  `jsapi_ticket` varchar(150) NOT NULL,
  `fanslist` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `shop_wx_fan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `subscribe` tinyint(2) NOT NULL DEFAULT '0' COMMENT '是否关注',
  `openid` varchar(50) NOT NULL,
  `nickname` varchar(100) NOT NULL COMMENT '昵称',
  `sex` tinyint(2) NOT NULL DEFAULT '0' COMMENT '性别',
  `language` varchar(10) NOT NULL,
  `city` varchar(20) NOT NULL COMMENT '城市',
  `province` varchar(20) NOT NULL COMMENT '省份',
  `country` varchar(20) NOT NULL COMMENT '国家',
  `headimgurl` varchar(250) NOT NULL COMMENT '头像',
  `subscribe_time` varchar(11) NOT NULL COMMENT '关注时间',
  `unionid` varchar(50) NOT NULL,
  `remark` varchar(100) NOT NULL COMMENT '备注',
  `groupid` int(11) NOT NULL COMMENT '用户所在的分组ID',
  `tagid_list` varchar(250) NOT NULL COMMENT '用户被打上的标签ID列表',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `shop_wx_material` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(10) DEFAULT NULL,
  `media_id` varchar(50) DEFAULT NULL,
  `update_time` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `shop_wx_media` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `material_id` int(11) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL COMMENT '标题',
  `author` varchar(20) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `digest` varchar(500) DEFAULT NULL,
  `thumb_local` varchar(255) DEFAULT NULL,
  `media_id` varchar(50) DEFAULT NULL,
  `thumb_url` varchar(255) DEFAULT NULL,
  `content` text,
  `content_source_url` varchar(255) DEFAULT NULL,
  `comment` tinyint(4) DEFAULT NULL COMMENT '留言：5关闭评论，0所有人可评论，1粉丝才可评论',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `shop_wx_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) NOT NULL COMMENT '菜单标题',
  `pid` mediumint(9) DEFAULT '0' COMMENT '父id',
  `type` varchar(50) DEFAULT NULL COMMENT '动作类型：view表示网页，click点击，miniprogram小程序',
  `key` varchar(50) DEFAULT NULL COMMENT '菜单KEY值',
  `url` varchar(2000) DEFAULT NULL COMMENT '网页链接',
  `media_id` int(11) DEFAULT NULL COMMENT '素材接口的media_id',
  `appid` int(11) DEFAULT NULL COMMENT '小程序的appid',
  `pagepath` int(11) DEFAULT NULL COMMENT '小程序的页面路径',
  `addtime` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;


CREATE TABLE IF NOT EXISTS `shop_wx_message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `to_username` varchar(100) DEFAULT NULL COMMENT '开发者微信号',
  `from_username` varchar(100) DEFAULT NULL COMMENT '发送方帐号（OpenID）',
  `create_time` int(11) DEFAULT '0' COMMENT '创建时间',
  `msg_type` varchar(10) NOT NULL COMMENT '消息类型：text、image、voice、video、shortvideo、location、link',
  `content` longtext,
  `msg_id` varchar(20) NOT NULL COMMENT '消息id',
  `pic_url` varchar(255) DEFAULT NULL COMMENT '图片链接',
  `media_id` varchar(255) DEFAULT NULL COMMENT '媒体id',
  `format` varchar(50) DEFAULT NULL COMMENT '语音格式：amr',
  `recognition` longtext COMMENT '语音识别结果',
  `thumb_mediaid` varchar(50) DEFAULT NULL COMMENT '视频消息缩略图的媒体id',
  `location_x` varchar(20) DEFAULT NULL COMMENT '地理位置维度',
  `location_y` varchar(20) DEFAULT NULL COMMENT '地理位置经度',
  `scale` int(11) DEFAULT NULL COMMENT '地图缩放大小',
  `label` varchar(255) DEFAULT NULL COMMENT '地理位置信息',
  `title` varchar(255) DEFAULT NULL COMMENT '消息标题',
  `description` text COMMENT '消息描述',
  `url` varchar(255) DEFAULT NULL COMMENT '消息链接',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `shop_wx_tpl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `no` varchar(50) DEFAULT NULL,
  `title` varchar(50) NOT NULL DEFAULT '' COMMENT '模板名',
  `tpl_id` varchar(100) NOT NULL COMMENT '模板编号',
  `url` varchar(100) NOT NULL,
  `color` varchar(10) NOT NULL,
  `content` longtext,
  `example` varchar(255) NOT NULL,
  `status` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ; 