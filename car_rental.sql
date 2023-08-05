/*
Navicat MySQL Data Transfer

Source Server         : lio
Source Server Version : 50562
Source Host           : localhost:3306
Source Database       : car_rental

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2022-06-03 11:58:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for car
-- ----------------------------
DROP TABLE IF EXISTS `car`;
CREATE TABLE `car` (
  `carnum` varchar(11) NOT NULL,
  `cartype` varchar(25) CHARACTER SET utf8 DEFAULT NULL,
  `num` varchar(3) CHARACTER SET utf8 DEFAULT NULL,
  `price` double(20,0) DEFAULT NULL,
  `color` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `hire` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `information` text CHARACTER SET utf8,
  `username` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`carnum`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of car
-- ----------------------------
INSERT INTO `car` VALUES ('1', '奔驰a', '01', '100', '白色', '是', '外观瑕疵', '1');
INSERT INTO `car` VALUES ('10', '11', '11', '11', '11', '否', null, null);
INSERT INTO `car` VALUES ('2', '奔驰b', '02', '150', '白色', '是', 'SUV汽车，车况很好', '1');
INSERT INTO `car` VALUES ('3', '奔驰c', '01', '168', '红色', '是', '外观瑕疵', '1');
INSERT INTO `car` VALUES ('4', '宝马a', '01', '189', '白色', '是', '外观有很多瑕疵', '1');
INSERT INTO `car` VALUES ('5', '宝马b', '02', '200', '灰色', '否', '外观瑕疵', null);
INSERT INTO `car` VALUES ('6', '宝马c', '01', '368', '白色', '否', '四驱豪华版无瑕疵', null);
INSERT INTO `car` VALUES ('7', '奥迪a', '02', '666', '白色', '否', '外观无瑕疵', null);
INSERT INTO `car` VALUES ('8', '奥迪b', '01', '333', '黑色', '否', '外观瑕疵', null);
INSERT INTO `car` VALUES ('9', '奥迪c', '02', '555', '白色', '否', '驾驶感受很好', null);

-- ----------------------------
-- Table structure for rental
-- ----------------------------
DROP TABLE IF EXISTS `rental`;
CREATE TABLE `rental` (
  `carnum` varchar(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `days` int(20) DEFAULT NULL,
  `allprice` double(20,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rental
-- ----------------------------
INSERT INTO `rental` VALUES ('1', '1', '4', null);
INSERT INTO `rental` VALUES ('3', '1', null, null);
INSERT INTO `rental` VALUES ('2', '1', '4', '600');
INSERT INTO `rental` VALUES ('3', '1', '2', '336');
INSERT INTO `rental` VALUES ('4', '1', '3', '567');
INSERT INTO `rental` VALUES ('1', '1', '2', '200');

-- ----------------------------
-- Table structure for stores
-- ----------------------------
DROP TABLE IF EXISTS `stores`;
CREATE TABLE `stores` (
  `num` varchar(3) NOT NULL,
  `address` varchar(100) NOT NULL,
  `contact` char(11) NOT NULL,
  `adminname` varchar(20) DEFAULT NULL,
  `admin_password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stores
-- ----------------------------
INSERT INTO `stores` VALUES ('01', '大庆', '85669', '11', '11');
INSERT INTO `stores` VALUES ('02', '哈尔滨', '88668', 'admin2', '222');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(20) CHARACTER SET utf8 NOT NULL,
  `user_password` varchar(20) NOT NULL,
  `user_cardid` varchar(20) NOT NULL,
  `user_phone` char(11) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1', '1', '1');
INSERT INTO `user` VALUES ('2', '2', '2', '2');
INSERT INTO `user` VALUES ('222', '222', '12312312', '124141244');
INSERT INTO `user` VALUES ('3', '3', '3', '3');
INSERT INTO `user` VALUES ('333', '333', '333', '333');
INSERT INTO `user` VALUES ('小李', '1', '1', '32423534633');
INSERT INTO `user` VALUES ('小王', '123', '342423200010282113', '15656471237');
