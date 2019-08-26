/*
Navicat MySQL Data Transfer

Source Server         : 192.168.0.2
Source Server Version : 50711
Source Host           : 192.168.0.2:3306
Source Database       : db_canteen

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2019-08-13 09:31:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for corporate
-- ----------------------------
DROP TABLE IF EXISTS `corporate`;
CREATE TABLE `corporate` (
  `id` int(11) NOT NULL,
  `corporateid` varchar(255) DEFAULT NULL,
  `agentid` int(11) DEFAULT NULL,
  `secret` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of corporate
-- ----------------------------
INSERT INTO `corporate` VALUES ('1', 'wx50039c6fbc9c811f', '1000024', '9wyRIqI0YcJlYLmrrKN94E8DEOdAiewcmTIDsdHiRPo');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `picture_url` varchar(255) DEFAULT NULL COMMENT '图片',
  `price` decimal(10,2) DEFAULT NULL COMMENT '价格',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=150 DEFAULT CHARSET=utf8 COMMENT='菜单';

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '包子', 'img/demo/荤菜.png', '1.00');
INSERT INTO `menu` VALUES ('2', '馄饨', 'img/demo/荤菜.png', '10.00');
INSERT INTO `menu` VALUES ('3', '饺子', 'img/demo/荤菜.png', '2.00');
INSERT INTO `menu` VALUES ('6', '稀饭', 'img/demo/荤菜.png', '2.00');
INSERT INTO `menu` VALUES ('7', '绿豆粥', 'img/demo/粥类.png', '3.00');
INSERT INTO `menu` VALUES ('8', '红豆粥', 'img/demo/粥类.png', '4.00');
INSERT INTO `menu` VALUES ('9', '咸鸭蛋', 'img/demo/荤菜.png', '2.00');
INSERT INTO `menu` VALUES ('12', '面条', 'img/demo/荤菜.png', null);
INSERT INTO `menu` VALUES ('105', '苹果', 'img/demo/水果.png', null);
INSERT INTO `menu` VALUES ('106', '蛋炒饭', 'img/demo/荤菜.png', null);
INSERT INTO `menu` VALUES ('107', '包子', 'img/demo/荤菜.png', null);
INSERT INTO `menu` VALUES ('108', '稀饭', 'img/demo/荤菜.png', null);
INSERT INTO `menu` VALUES ('109', '榨菜', 'img/demo/荤菜.png', null);
INSERT INTO `menu` VALUES ('111', '酸奶', 'img/demo/荤菜.png', null);
INSERT INTO `menu` VALUES ('112', '苹果', 'img/demo/水果.png', null);
INSERT INTO `menu` VALUES ('113', '米饭', 'img/demo/荤菜.png', null);
INSERT INTO `menu` VALUES ('114', '面条', 'img/demo/荤菜.png', null);
INSERT INTO `menu` VALUES ('115', '雪菜烧鸭腿', 'img/demo/荤菜.png', null);
INSERT INTO `menu` VALUES ('116', '红烧肉', 'img/demo/荤菜.png', null);
INSERT INTO `menu` VALUES ('117', '小炒肉', 'img/demo/荤菜.png', null);
INSERT INTO `menu` VALUES ('118', '豆芽烧牛肉', 'img/demo/荤菜.png', null);
INSERT INTO `menu` VALUES ('119', '西红柿炒鸡蛋', 'img/demo/荤菜.png', null);
INSERT INTO `menu` VALUES ('120', '青椒炒肉丝', 'img/demo/荤菜.png', null);
INSERT INTO `menu` VALUES ('121', '大煮干丝', 'img/demo/荤菜.png', null);
INSERT INTO `menu` VALUES ('122', '青菜烧百叶', 'img/demo/荤菜.png', null);
INSERT INTO `menu` VALUES ('126', '凉拌腐竹', 'img/demo/荤菜.png', null);
INSERT INTO `menu` VALUES ('127', '苹果', 'img/demo/水果.png', null);
INSERT INTO `menu` VALUES ('128', '西红柿鸡蛋汤', 'img/demo/汤类.png', null);
INSERT INTO `menu` VALUES ('129', '酸奶', 'img/demo/荤菜.png', null);
INSERT INTO `menu` VALUES ('130', '清水冬瓜汤', 'img/demo/汤类.png', null);
INSERT INTO `menu` VALUES ('133', '冰淇淋', 'img/demo/饮品.png', null);
INSERT INTO `menu` VALUES ('134', '水晶饼', 'img/demo/甜品.png', null);
INSERT INTO `menu` VALUES ('135', '甜饼', 'img/demo/甜品.png', null);
INSERT INTO `menu` VALUES ('136', '可乐', 'img/demo/饮品.png', null);
INSERT INTO `menu` VALUES ('137', 'baozi', 'upload/1560913990246申请公函.jpeg', null);
INSERT INTO `menu` VALUES ('138', '饺子', 'upload/1560923385026微信图片_20190311122509.jpg', null);
INSERT INTO `menu` VALUES ('141', 'baozi', 'upload/1560933684515申请公函.jpeg', null);
INSERT INTO `menu` VALUES ('142', '酸奶', 'upload/1560935697206微信图片_20190311122509.jpg', null);
INSERT INTO `menu` VALUES ('143', '水饺', 'upload/1561078790932微信图片_20190311122509.jpg', null);
INSERT INTO `menu` VALUES ('145', '榨菜', 'upload/1561083306870微信图片_20190308100507.jpg', null);
INSERT INTO `menu` VALUES ('146', '小米粥', 'upload/1561103897262微信图片_20190308100507.jpg', null);
INSERT INTO `menu` VALUES ('147', '苹果', 'upload/1561103912848微信图片_20190311122509.jpg', null);
INSERT INTO `menu` VALUES ('148', '蛋糕', 'upload/1561103936175微信图片_20190308100507.jpg', null);
INSERT INTO `menu` VALUES ('149', '红烧肉', 'upload/1561103954364微信图片_20190308100507.jpg', null);

-- ----------------------------
-- Table structure for menu_feedback
-- ----------------------------
DROP TABLE IF EXISTS `menu_feedback`;
CREATE TABLE `menu_feedback` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `good_state` int(11) DEFAULT NULL COMMENT '1好评 2差评 ',
  `good_time` datetime DEFAULT NULL COMMENT '添加时间 或 修改时间',
  `menu_id` int(11) DEFAULT NULL COMMENT '餐单id',
  `wxid` varchar(255) DEFAULT NULL COMMENT '用户token',
  PRIMARY KEY (`id`),
  KEY `menu_id` (`menu_id`),
  CONSTRAINT `menu_feedback_ibfk_1` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT=' 餐单 反馈';

-- ----------------------------
-- Records of menu_feedback
-- ----------------------------
INSERT INTO `menu_feedback` VALUES ('1', '1', '2019-06-21 00:00:00', '141', 'weixinid');

-- ----------------------------
-- Table structure for menu_list
-- ----------------------------
DROP TABLE IF EXISTS `menu_list`;
CREATE TABLE `menu_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_type_id` int(11) DEFAULT NULL,
  `menu_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `menu_type_id` (`menu_type_id`),
  KEY `menu_id` (`menu_id`),
  CONSTRAINT `menu_list_ibfk_2` FOREIGN KEY (`menu_type_id`) REFERENCES `menu_type` (`id`),
  CONSTRAINT `menu_list_ibfk_3` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8 COMMENT='菜单列表';

-- ----------------------------
-- Records of menu_list
-- ----------------------------
INSERT INTO `menu_list` VALUES ('55', '1', '141');
INSERT INTO `menu_list` VALUES ('56', '4', '142');
INSERT INTO `menu_list` VALUES ('57', '1', '143');
INSERT INTO `menu_list` VALUES ('59', '3', '145');
INSERT INTO `menu_list` VALUES ('60', '2', '146');
INSERT INTO `menu_list` VALUES ('61', '5', '147');
INSERT INTO `menu_list` VALUES ('62', '6', '148');
INSERT INTO `menu_list` VALUES ('63', '8', '149');

-- ----------------------------
-- Table structure for menu_message
-- ----------------------------
DROP TABLE IF EXISTS `menu_message`;
CREATE TABLE `menu_message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `time` datetime DEFAULT NULL COMMENT '发送消息时间',
  `content` text COMMENT '内容',
  `wxid` varchar(255) DEFAULT NULL COMMENT '用户token',
  `anonymous` int(11) DEFAULT NULL COMMENT '1显示 2匿名',
  `picurl` varchar(255) DEFAULT NULL,
  `lr` int(11) DEFAULT NULL COMMENT '1工作日 2节假日',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8 COMMENT='菜单 消息';

-- ----------------------------
-- Records of menu_message
-- ----------------------------
INSERT INTO `menu_message` VALUES ('40', '2019-06-12 17:07:44', '123', 'weixinid', '2', '', '1');
INSERT INTO `menu_message` VALUES ('41', '2019-06-12 17:08:29', '123', 'weixinid', '2', '', '1');
INSERT INTO `menu_message` VALUES ('42', '2019-06-12 17:10:51', '123123', 'weixinid', '2', '', '1');
INSERT INTO `menu_message` VALUES ('43', '2019-06-12 17:10:57', 'asdasdasd', 'weixinid', '2', '', '1');
INSERT INTO `menu_message` VALUES ('44', '2019-06-12 17:11:03', '123123', 'weixinid', '2', '', '1');
INSERT INTO `menu_message` VALUES ('45', '2019-06-12 17:11:09', '123123', 'weixinid', '2', '', '2');
INSERT INTO `menu_message` VALUES ('46', '2019-06-12 17:11:12', 'asdasd', 'weixinid', '2', '', '2');
INSERT INTO `menu_message` VALUES ('47', '2019-06-12 17:14:41', '123', 'weixinid', '2', '', '1');
INSERT INTO `menu_message` VALUES ('48', '2019-06-12 17:14:49', '123', 'weixinid', '2', 'upload/1560330887793299.jpg', '1');
INSERT INTO `menu_message` VALUES ('49', '2019-06-12 17:15:04', '123', 'weixinid', '2', 'upload/1560330901578299.jpg', '1');
INSERT INTO `menu_message` VALUES ('50', '2019-06-12 17:15:08', '123', 'weixinid', '2', '', '1');

-- ----------------------------
-- Table structure for menu_type
-- ----------------------------
DROP TABLE IF EXISTS `menu_type`;
CREATE TABLE `menu_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='菜单类型';

-- ----------------------------
-- Records of menu_type
-- ----------------------------
INSERT INTO `menu_type` VALUES ('1', '主食');
INSERT INTO `menu_type` VALUES ('2', '粥类');
INSERT INTO `menu_type` VALUES ('3', '小菜');
INSERT INTO `menu_type` VALUES ('4', '饮品');
INSERT INTO `menu_type` VALUES ('5', '水果');
INSERT INTO `menu_type` VALUES ('6', '点心');
INSERT INTO `menu_type` VALUES ('8', '荤菜');
INSERT INTO `menu_type` VALUES ('9', '素菜');
INSERT INTO `menu_type` VALUES ('10', '汤类');
INSERT INTO `menu_type` VALUES ('11', '甜品');

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `message` varchar(255) DEFAULT NULL,
  `addtime` datetime DEFAULT NULL,
  `flag` int(11) DEFAULT NULL COMMENT ' 1开启，2禁用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES ('10', '11111111', null, '2');
INSERT INTO `notice` VALUES ('11', 'oiewfoiwfuwieuf', null, '2');
INSERT INTO `notice` VALUES ('12', '埃里克森惊呆了空间', null, '2');
INSERT INTO `notice` VALUES ('13', 'as来得及', null, '2');
INSERT INTO `notice` VALUES ('14', '爱丽丝大螺丝', null, '2');

-- ----------------------------
-- Table structure for time_slot
-- ----------------------------
DROP TABLE IF EXISTS `time_slot`;
CREATE TABLE `time_slot` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `start_date` datetime DEFAULT NULL COMMENT '开始时间',
  `end_date` datetime DEFAULT NULL COMMENT '结束时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='时间段';

-- ----------------------------
-- Records of time_slot
-- ----------------------------
INSERT INTO `time_slot` VALUES ('1', '早餐', '2019-01-01 05:00:00', '2019-01-01 10:00:00');
INSERT INTO `time_slot` VALUES ('2', '中餐', '2019-01-01 10:30:00', '2019-01-01 15:30:00');
INSERT INTO `time_slot` VALUES ('3', '晚餐', '2019-06-10 17:28:50', '2019-06-10 23:29:14');

-- ----------------------------
-- Table structure for time_slot_as_menu_type
-- ----------------------------
DROP TABLE IF EXISTS `time_slot_as_menu_type`;
CREATE TABLE `time_slot_as_menu_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `time_slot_id` int(11) NOT NULL COMMENT '时间段外键',
  `menu_type_id` int(11) DEFAULT NULL,
  `seq` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `time_slot_id` (`time_slot_id`),
  KEY `menu_type_id` (`menu_type_id`),
  CONSTRAINT `time_slot_as_menu_type_ibfk_1` FOREIGN KEY (`time_slot_id`) REFERENCES `time_slot` (`id`),
  CONSTRAINT `time_slot_as_menu_type_ibfk_2` FOREIGN KEY (`menu_type_id`) REFERENCES `menu_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COMMENT='时间段 和 菜单类型 关联表';

-- ----------------------------
-- Records of time_slot_as_menu_type
-- ----------------------------
INSERT INTO `time_slot_as_menu_type` VALUES ('1', '1', '1', null);
INSERT INTO `time_slot_as_menu_type` VALUES ('2', '1', '2', null);
INSERT INTO `time_slot_as_menu_type` VALUES ('3', '1', '3', null);
INSERT INTO `time_slot_as_menu_type` VALUES ('4', '1', '4', null);
INSERT INTO `time_slot_as_menu_type` VALUES ('5', '1', '5', null);
INSERT INTO `time_slot_as_menu_type` VALUES ('6', '1', '6', null);
INSERT INTO `time_slot_as_menu_type` VALUES ('7', '2', '1', null);
INSERT INTO `time_slot_as_menu_type` VALUES ('8', '2', '8', null);
INSERT INTO `time_slot_as_menu_type` VALUES ('9', '2', '9', null);
INSERT INTO `time_slot_as_menu_type` VALUES ('10', '2', '5', null);
INSERT INTO `time_slot_as_menu_type` VALUES ('11', '2', '10', null);
INSERT INTO `time_slot_as_menu_type` VALUES ('12', '2', '4', null);
INSERT INTO `time_slot_as_menu_type` VALUES ('13', '2', '11', null);
INSERT INTO `time_slot_as_menu_type` VALUES ('14', '3', '1', '1');
INSERT INTO `time_slot_as_menu_type` VALUES ('15', '3', '8', '2');
INSERT INTO `time_slot_as_menu_type` VALUES ('16', '3', '9', '3');
INSERT INTO `time_slot_as_menu_type` VALUES ('17', '3', '4', '6');
INSERT INTO `time_slot_as_menu_type` VALUES ('18', '3', '5', '7');
INSERT INTO `time_slot_as_menu_type` VALUES ('19', '3', '6', '8');
INSERT INTO `time_slot_as_menu_type` VALUES ('22', '3', '2', '4');
INSERT INTO `time_slot_as_menu_type` VALUES ('23', '3', '3', '5');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL COMMENT '登录名',
  `password` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL COMMENT '真实姓名姓名',
  `gender` int(11) DEFAULT NULL COMMENT '性别 0表示未定义，1表示男性，2表示女性',
  `mobile` varchar(255) DEFAULT NULL COMMENT '手机号码',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  `wxid` varchar(255) DEFAULT NULL COMMENT '微信id',
  `manager` int(11) DEFAULT NULL COMMENT '是否是管理员',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'admin', '管理员', '2', '12312', '1047139049@qq.com', 'upload/1.jpeg', 'weixinid', '1');
INSERT INTO `user` VALUES ('2', 'asdasd', 'asdasd', 'asdasd', '1', 'asdasd', 'asdasd', null, null, null);

-- ----------------------------
-- Table structure for weekly
-- ----------------------------
DROP TABLE IF EXISTS `weekly`;
CREATE TABLE `weekly` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='星期表';

-- ----------------------------
-- Records of weekly
-- ----------------------------
INSERT INTO `weekly` VALUES ('1', '周一');
INSERT INTO `weekly` VALUES ('2', '周二');
INSERT INTO `weekly` VALUES ('3', '周三');
INSERT INTO `weekly` VALUES ('4', '周四');
INSERT INTO `weekly` VALUES ('5', '周五');
INSERT INTO `weekly` VALUES ('6', '周六');
INSERT INTO `weekly` VALUES ('7', '周日');

-- ----------------------------
-- Table structure for weekly_menu_list
-- ----------------------------
DROP TABLE IF EXISTS `weekly_menu_list`;
CREATE TABLE `weekly_menu_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `weekly_id` int(11) DEFAULT NULL COMMENT '周几 id',
  `time_slot_id` int(11) DEFAULT NULL COMMENT '时间段id',
  `menu_type_id` int(11) DEFAULT NULL COMMENT '菜单类型id',
  `menu_id` int(11) DEFAULT NULL COMMENT '菜单id',
  PRIMARY KEY (`id`),
  KEY `weekly_id` (`weekly_id`),
  KEY `time_slot_id` (`time_slot_id`),
  KEY `menu_type_id` (`menu_type_id`),
  KEY `menu_id` (`menu_id`),
  CONSTRAINT `weekly_menu_list_ibfk_1` FOREIGN KEY (`weekly_id`) REFERENCES `weekly` (`id`),
  CONSTRAINT `weekly_menu_list_ibfk_2` FOREIGN KEY (`time_slot_id`) REFERENCES `time_slot` (`id`),
  CONSTRAINT `weekly_menu_list_ibfk_3` FOREIGN KEY (`menu_type_id`) REFERENCES `menu_type` (`id`),
  CONSTRAINT `weekly_menu_list_ibfk_4` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=137 DEFAULT CHARSET=utf8 COMMENT='周几 菜单';

-- ----------------------------
-- Records of weekly_menu_list
-- ----------------------------
INSERT INTO `weekly_menu_list` VALUES ('128', '1', '1', '1', '141');
INSERT INTO `weekly_menu_list` VALUES ('129', '1', '1', '4', '142');
INSERT INTO `weekly_menu_list` VALUES ('131', '2', '1', '3', '145');
INSERT INTO `weekly_menu_list` VALUES ('135', '1', '3', '8', '149');
INSERT INTO `weekly_menu_list` VALUES ('136', '1', '3', '5', '147');
