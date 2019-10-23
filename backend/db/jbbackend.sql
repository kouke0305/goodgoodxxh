/*
Navicat MySQL Data Transfer

Source Server         : local_mysql_3306
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : jiabao

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2019-03-27 10:18:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for authority
-- ----------------------------
DROP TABLE IF EXISTS `authority`;
CREATE TABLE `authority` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限id',
  `funcname` varchar(50) DEFAULT NULL COMMENT '权限名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of authority
-- ----------------------------
INSERT INTO `authority` VALUES ('1', '员工管理');
INSERT INTO `authority` VALUES ('2', '奶站管理');
INSERT INTO `authority` VALUES ('3', '奶站修改');
INSERT INTO `authority` VALUES ('4', '订单操作');
INSERT INTO `authority` VALUES ('5', '角色管理');

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `clientid` varchar(50) DEFAULT NULL COMMENT '买家id',
  `name` varchar(50) DEFAULT NULL COMMENT '收货人名',
  `buyphone` varchar(50) DEFAULT NULL COMMENT '买家手机号',
  `attachphone` varchar(50) DEFAULT NULL COMMENT '收货人手机号',
  `address` varchar(500) DEFAULT NULL COMMENT '详细地址',
  `province` varchar(50) DEFAULT NULL COMMENT '省',
  `city` varchar(50) DEFAULT NULL COMMENT '市',
  `region` varchar(50) DEFAULT NULL COMMENT '区',
  `exaddress` varchar(500) DEFAULT NULL COMMENT '扩展地址（经纬度）',
  `jbosscid` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of customer
-- ----------------------------

-- ----------------------------
-- Table structure for dispatching
-- ----------------------------
DROP TABLE IF EXISTS `dispatching`;
CREATE TABLE `dispatching` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dispatchid` varchar(50) DEFAULT NULL COMMENT '配送单编号',
  `snumber` varchar(50) DEFAULT NULL COMMENT '订单编号',
  `cid` varchar(50) DEFAULT NULL COMMENT '客户id',
  `caid` int(11) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL COMMENT '收货人地址',
  `phone` varchar(50) DEFAULT NULL COMMENT '收货人电话',
  `sid` varchar(50) DEFAULT NULL COMMENT '奶站id',
  `eid` varchar(50) DEFAULT NULL COMMENT '员工id',
  `cneename` varchar(50) DEFAULT NULL COMMENT '收货人姓名',
  `goods` varchar(50) DEFAULT NULL COMMENT '商品名',
  `number` int(11) DEFAULT NULL COMMENT '商品数量',
  `start` date DEFAULT NULL COMMENT '开始时间',
  `end` datetime DEFAULT NULL COMMENT '结束时间',
  `status` int(11) DEFAULT '0' COMMENT '状态0、默认配送中1、成功 2、异常',
  `errorid` int(11) DEFAULT NULL COMMENT '异常描述id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `dispatchid` (`dispatchid`),
  KEY `FK_dispatching_milkstation` (`sid`),
  CONSTRAINT `FK_dispatching_milkstation` FOREIGN KEY (`sid`) REFERENCES `milkstation` (`stationid`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of dispatching
-- ----------------------------

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `empid` varchar(50) DEFAULT NULL COMMENT '员工编号',
  `roleid` varchar(50) DEFAULT '3' COMMENT '角色id',
  `pc_openid` varchar(50) DEFAULT NULL COMMENT 'pc_openid',
  `app_openid` varchar(50) DEFAULT NULL COMMENT 'app_openid',
  `binding_code` varchar(50) DEFAULT NULL COMMENT '绑定码',
  `job` int(11) DEFAULT '3' COMMENT '职位',
  `sex` int(11) DEFAULT NULL COMMENT '性别',
  `home` varchar(255) DEFAULT NULL COMMENT '家庭住址',
  `state` int(11) DEFAULT NULL COMMENT '状态',
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `phone` varchar(255) DEFAULT NULL COMMENT '电话',
  `station` varchar(50) DEFAULT NULL COMMENT '奶站',
  `address` varchar(255) DEFAULT NULL COMMENT '配送地址',
  `real_coord` varchar(50) DEFAULT NULL COMMENT '员工实时坐标',
  PRIMARY KEY (`id`),
  UNIQUE KEY `empid` (`empid`),
  KEY `FK_employee_milkstation` (`station`),
  KEY `FK_employee_role` (`roleid`),
  CONSTRAINT `FK_employee_milkstation` FOREIGN KEY (`station`) REFERENCES `milkstation` (`stationid`),
  CONSTRAINT `FK_employee_role` FOREIGN KEY (`roleid`) REFERENCES `role` (`roleid`)
) ENGINE=InnoDB AUTO_INCREMENT=2669 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of employee
-- ----------------------------

-- ----------------------------
-- Table structure for errordesc
-- ----------------------------
DROP TABLE IF EXISTS `errordesc`;
CREATE TABLE `errordesc` (
  `errorid` int(11) NOT NULL AUTO_INCREMENT COMMENT '异常id',
  `name` varchar(500) NOT NULL DEFAULT '0' COMMENT '异常描述',
  PRIMARY KEY (`errorid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of errordesc
-- ----------------------------
INSERT INTO `errordesc` VALUES ('1', '包装损坏');
INSERT INTO `errordesc` VALUES ('2', '配送盒满');
INSERT INTO `errordesc` VALUES ('3', '非当前配送区域');
INSERT INTO `errordesc` VALUES ('4', '收货人联系方式异常');
INSERT INTO `errordesc` VALUES ('5', '收货地址错误');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `itemsku` varchar(255) DEFAULT NULL,
  `numbers` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of goods
-- ----------------------------

-- ----------------------------
-- Table structure for milkstation
-- ----------------------------
DROP TABLE IF EXISTS `milkstation`;
CREATE TABLE `milkstation` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '表id',
  `stationid` varchar(50) NOT NULL DEFAULT '0' COMMENT '奶站编号',
  `name` varchar(50) NOT NULL DEFAULT '0' COMMENT '奶站名称',
  `phone` varchar(20) NOT NULL DEFAULT '0' COMMENT '奶站联系电话',
  `address` varchar(100) NOT NULL DEFAULT '0' COMMENT '奶站位置',
  `coord` varchar(500) NOT NULL DEFAULT '0' COMMENT '配送范围坐标数组',
  `region` varchar(500) NOT NULL DEFAULT '0' COMMENT '配送区域',
  PRIMARY KEY (`id`),
  UNIQUE KEY `stationid` (`stationid`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8mb4 COMMENT='奶站表';

-- ----------------------------
-- Records of milkstation
-- ----------------------------

-- ----------------------------
-- Table structure for oorder
-- ----------------------------
DROP TABLE IF EXISTS `oorder`;
CREATE TABLE `oorder` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `snumber` varchar(50) NOT NULL COMMENT '有赞订单编号',
  `jnumber` varchar(50) DEFAULT NULL COMMENT 'jboss订单编号',
  `cid` varchar(50) DEFAULT NULL COMMENT '客户id',
  `caid` int(11) DEFAULT NULL COMMENT '客户地址id',
  `name` varchar(50) DEFAULT NULL COMMENT '收货人',
  `address` varchar(50) DEFAULT NULL COMMENT '收货地址',
  `phone` varchar(50) DEFAULT NULL COMMENT '收货电话',
  `sid` varchar(50) DEFAULT NULL COMMENT '奶站id',
  `eid` varchar(50) DEFAULT NULL COMMENT '配送员id',
  `goods` varchar(50) DEFAULT NULL COMMENT '商品名',
  `number` int(11) DEFAULT NULL COMMENT '商品数',
  `start` date DEFAULT NULL COMMENT '配送时间',
  `end` date DEFAULT NULL COMMENT '配送截止',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '订单状态:0待确认 1成功 2异常',
  `errorid` int(11) DEFAULT NULL COMMENT '异常描述',
  `time` timestamp NULL DEFAULT NULL COMMENT '分单时间',
  `ostatus` int(11) DEFAULT NULL COMMENT '订单进行的状态1开始0暂停',
  `itemsku` varchar(255) DEFAULT NULL COMMENT '商品编号',
  PRIMARY KEY (`id`),
  UNIQUE KEY `snumber` (`snumber`),
  UNIQUE KEY `jnumber` (`jnumber`),
  KEY `FK_oorder_milkstation` (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of oorder
-- ----------------------------

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `functions` varchar(255) DEFAULT NULL COMMENT '权限',
  `roleid` varchar(50) DEFAULT NULL COMMENT '角色id',
  `rolename` varchar(255) DEFAULT NULL COMMENT '角色名',
  PRIMARY KEY (`id`),
  KEY `roleid` (`roleid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '1,2,3,4,5,a', '1', '管理员角色');
INSERT INTO `role` VALUES ('2', '1,2,3,4,b', '2', '站长角色');
INSERT INTO `role` VALUES ('3', '3,4,c', '3', '配送员角色');
