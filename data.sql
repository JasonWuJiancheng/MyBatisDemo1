/*
 Navicat Premium Data Transfer

 Source Server         : xamapp_Mysql
 Source Server Type    : MySQL
 Source Server Version : 50626
 Source Host           : localhost:3306
 Source Schema         : mybatis

 Target Server Type    : MySQL
 Target Server Version : 50626
 File Encoding         : 65001

 Date: 01/04/2019 20:43:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `sex` varchar(2) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '123', 'F');
INSERT INTO `user` VALUES (2, 'wujiancheng', '123', 'F');
INSERT INTO `user` VALUES (5, 'zhangwei', '12345', 'M');
INSERT INTO `user` VALUES (6, 'test1', 'abc', 'F');
INSERT INTO `user` VALUES (7, 'test2', 'abc', 'M');
INSERT INTO `user` VALUES (8, 'test3', 'abc', 'M');
INSERT INTO `user` VALUES (9, 'test4', 'abc', 'F');
INSERT INTO `user` VALUES (10, 'testUser1', 'testPassword1', 'M');
INSERT INTO `user` VALUES (12, 'ChangyuanWu', 'thisisapassword', 'F');

SET FOREIGN_KEY_CHECKS = 1;
