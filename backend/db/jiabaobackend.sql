-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- Server version:               5.7.25-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL 版本:                  10.1.0.5464
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for jiabao
CREATE DATABASE IF NOT EXISTS `jiabao` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `jiabao`;

-- Dumping structure for table jiabao.authority
CREATE TABLE IF NOT EXISTS `authority` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限id',
  `funcname` varchar(50) DEFAULT NULL COMMENT '权限名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table jiabao.authority: ~5 rows (approximately)
/*!40000 ALTER TABLE `authority` DISABLE KEYS */;
INSERT INTO `authority` (`id`, `funcname`) VALUES
	(1, '员工管理'),
	(2, '奶站管理'),
	(3, '奶站修改'),
	(4, '订单操作'),
	(5, '角色管理');
/*!40000 ALTER TABLE `authority` ENABLE KEYS */;

-- Dumping structure for table jiabao.customer
CREATE TABLE IF NOT EXISTS `customer` (
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
  `jbosscid` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table jiabao.customer: ~0 rows (approximately)
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;

-- Dumping structure for table jiabao.dispatching
CREATE TABLE IF NOT EXISTS `dispatching` (
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table jiabao.dispatching: ~0 rows (approximately)
/*!40000 ALTER TABLE `dispatching` DISABLE KEYS */;
/*!40000 ALTER TABLE `dispatching` ENABLE KEYS */;

-- Dumping structure for table jiabao.employee
CREATE TABLE IF NOT EXISTS `employee` (
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table jiabao.employee: ~0 rows (approximately)
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;

-- Dumping structure for table jiabao.errordesc
CREATE TABLE IF NOT EXISTS `errordesc` (
  `errorid` int(11) NOT NULL AUTO_INCREMENT COMMENT '异常id',
  `name` varchar(500) NOT NULL DEFAULT '0' COMMENT '异常描述',
  PRIMARY KEY (`errorid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table jiabao.errordesc: ~5 rows (approximately)
/*!40000 ALTER TABLE `errordesc` DISABLE KEYS */;
INSERT INTO `errordesc` (`errorid`, `name`) VALUES
	(1, '包装损坏'),
	(2, '配送盒满'),
	(3, '非当前配送区域'),
	(4, '收货人联系方式异常'),
	(5, '收货地址错误');
/*!40000 ALTER TABLE `errordesc` ENABLE KEYS */;

-- Dumping structure for table jiabao.goods
CREATE TABLE IF NOT EXISTS `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `itemsku` varchar(255) DEFAULT NULL,
  `numbers` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table jiabao.goods: ~0 rows (approximately)
/*!40000 ALTER TABLE `goods` DISABLE KEYS */;
/*!40000 ALTER TABLE `goods` ENABLE KEYS */;

-- Dumping structure for table jiabao.milkstation
CREATE TABLE IF NOT EXISTS `milkstation` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '表id',
  `stationid` varchar(50) NOT NULL DEFAULT '0' COMMENT '奶站编号',
  `name` varchar(50) NOT NULL DEFAULT '0' COMMENT '奶站名称',
  `phone` varchar(20) NOT NULL DEFAULT '0' COMMENT '奶站联系电话',
  `address` varchar(100) NOT NULL DEFAULT '0' COMMENT '奶站位置',
  `coord` varchar(500) NOT NULL DEFAULT '0' COMMENT '配送范围坐标数组',
  `region` varchar(500) NOT NULL DEFAULT '0' COMMENT '配送区域',
  PRIMARY KEY (`id`),
  UNIQUE KEY `stationid` (`stationid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='奶站表';

-- Dumping data for table jiabao.milkstation: ~0 rows (approximately)
/*!40000 ALTER TABLE `milkstation` DISABLE KEYS */;
/*!40000 ALTER TABLE `milkstation` ENABLE KEYS */;

-- Dumping structure for table jiabao.oorder
CREATE TABLE IF NOT EXISTS `oorder` (
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
  `dispatchper` varchar(50) DEFAULT NULL,
  `price` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `snumber` (`snumber`),
  UNIQUE KEY `jnumber` (`jnumber`),
  KEY `FK_oorder_milkstation` (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table jiabao.oorder: ~1 rows (approximately)
/*!40000 ALTER TABLE `oorder` DISABLE KEYS */;
/*!40000 ALTER TABLE `oorder` ENABLE KEYS */;

-- Dumping structure for table jiabao.role
CREATE TABLE IF NOT EXISTS `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `functions` varchar(255) DEFAULT NULL COMMENT '权限',
  `roleid` varchar(50) DEFAULT NULL COMMENT '角色id',
  `rolename` varchar(255) DEFAULT NULL COMMENT '角色名',
  PRIMARY KEY (`id`),
  KEY `roleid` (`roleid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table jiabao.role: ~3 rows (approximately)
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`id`, `functions`, `roleid`, `rolename`) VALUES
	(1, '1,2,3,4,a', '1', '管理员角色'),
	(2, '1,2,3,4,5,b', '2', '站长角色'),
	(3, '3,4,c', '3', '配送员角色');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
