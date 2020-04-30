/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : poi

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-09-04 21:08:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL COMMENT '用户名称',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `sex` char(1) DEFAULT NULL COMMENT '性别',
  `address` varchar(256) DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=565658 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '王五', '2017-04-18', '男', '山东');
INSERT INTO `user` VALUES ('10', '张三', '2014-07-10', '女', '北京市');
INSERT INTO `user` VALUES ('16', '张小明', '2010-06-16', '男', '河南郑州');
INSERT INTO `user` VALUES ('22', '陈小明', '2012-07-19', '女', '河南郑州');
INSERT INTO `user` VALUES ('24', '张三丰', '2017-07-05', '男', '河南郑州');
INSERT INTO `user` VALUES ('25', '陈小明', '2019-07-10', '男', '河南郑州');
INSERT INTO `user` VALUES ('26', '王五', '2015-07-31', '女', '福建');
INSERT INTO `user` VALUES ('27', '周星驰', '2017-06-25', '男', '北京');
INSERT INTO `user` VALUES ('232', '周星驰', '2017-06-25', '男', '北京');
INSERT INTO `user` VALUES ('123123', '周杰伦', '2017-07-01', '男', '台湾');
INSERT INTO `user` VALUES ('565656', '周杰伦', '2017-07-05', '男', '中国');
INSERT INTO `user` VALUES ('565657', '周杰伦', '2017-07-06', '男', '中国');
