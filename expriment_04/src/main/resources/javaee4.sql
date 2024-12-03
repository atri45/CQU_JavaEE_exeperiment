/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50562
Source Host           : localhost:3306
Source Database       : javaee4

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2024-11-28 20:12:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `class`
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `classId` int(11) DEFAULT NULL,
  `courseName` varchar(11) DEFAULT NULL,
  `teacherId` int(11) DEFAULT NULL,
  `studentNum` int(11) DEFAULT NULL,
  `openSemester` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES ('1', 'c++', '1', '45', '1');
INSERT INTO `class` VALUES ('2', 'c++', '2', '45', '2');
INSERT INTO `class` VALUES ('3', 'java', '1', '45', '1');
INSERT INTO `class` VALUES ('4', 'java', '2', '45', '2');
INSERT INTO `class` VALUES ('5', 'python', '3', '45', '1');
INSERT INTO `class` VALUES ('6', 'python', '4', '45', '2');
INSERT INTO `class` VALUES ('7', 'scala', '3', '45', '1');
INSERT INTO `class` VALUES ('8', 'scala', '4', '45', '2');

-- ----------------------------
-- Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `courseId` int(11) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', 'c++');
INSERT INTO `course` VALUES ('2', 'java');
INSERT INTO `course` VALUES ('3', 'python');
INSERT INTO `course` VALUES ('4', 'scala');

-- ----------------------------
-- Table structure for `score`
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `scoreId` int(11) NOT NULL AUTO_INCREMENT,
  `studentId` int(11) DEFAULT NULL,
  `studentName` varchar(20) DEFAULT NULL,
  `courseName` varchar(11) DEFAULT NULL,
  `classId` int(11) DEFAULT NULL,
  `regularScore` int(11) DEFAULT NULL,
  `midScore` int(11) DEFAULT NULL,
  `experimentalScore` int(11) DEFAULT NULL,
  `finalScore` int(11) DEFAULT NULL,
  `comprehensiveScore` int(11) DEFAULT NULL,
  PRIMARY KEY (`scoreId`)
) ENGINE=InnoDB AUTO_INCREMENT=4604 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES ('4514', '1', 'Alice', 'c++', '1', '71', '75', '62', '61', '67');
INSERT INTO `score` VALUES ('4515', '2', 'Bob', 'c++', '1', '94', '86', '76', '74', '82');
INSERT INTO `score` VALUES ('4516', '3', 'Charlie', 'c++', '1', '80', '60', '90', '94', '81');
INSERT INTO `score` VALUES ('4517', '4', 'Diana', 'c++', '1', '80', '73', '83', '64', '75');
INSERT INTO `score` VALUES ('4518', '5', 'Edward', 'c++', '1', '74', '80', '90', '82', '81');
INSERT INTO `score` VALUES ('4519', '6', 'Fiona', 'c++', '1', '73', '91', '98', '97', '89');
INSERT INTO `score` VALUES ('4520', '7', 'George', 'c++', '1', '75', '70', '61', '66', '68');
INSERT INTO `score` VALUES ('4521', '8', 'Hannah', 'c++', '1', '62', '87', '78', '75', '75');
INSERT INTO `score` VALUES ('4522', '9', 'Ian', 'c++', '1', '90', '82', '84', '64', '80');
INSERT INTO `score` VALUES ('4523', '10', 'Jane', 'c++', '1', '97', '68', '65', '60', '72');
INSERT INTO `score` VALUES ('4524', '11', 'Kate', 'c++', '1', '77', '91', '61', '75', '76');
INSERT INTO `score` VALUES ('4525', '12', 'Liam', 'c++', '1', '97', '93', '63', '66', '79');
INSERT INTO `score` VALUES ('4526', '13', 'Mia', 'c++', '1', '68', '95', '60', '60', '70');
INSERT INTO `score` VALUES ('4527', '14', 'Noah', 'c++', '1', '69', '82', '74', '69', '73');
INSERT INTO `score` VALUES ('4528', '15', 'Olivia', 'c++', '1', '95', '65', '89', '97', '86');
INSERT INTO `score` VALUES ('4529', '1', 'Alice', 'java', '3', '90', '60', '67', '68', '71');
INSERT INTO `score` VALUES ('4530', '2', 'Bob', 'java', '3', '66', '72', '73', '96', '76');
INSERT INTO `score` VALUES ('4531', '3', 'Charlie', 'java', '3', '76', '74', '64', '76', '72');
INSERT INTO `score` VALUES ('4532', '4', 'Diana', 'java', '3', '99', '99', '86', '61', '86');
INSERT INTO `score` VALUES ('4533', '5', 'Edward', 'java', '3', '80', '77', '93', '99', '87');
INSERT INTO `score` VALUES ('4534', '6', 'Fiona', 'java', '3', '74', '93', '75', '87', '82');
INSERT INTO `score` VALUES ('4535', '7', 'George', 'java', '3', '95', '97', '74', '68', '83');
INSERT INTO `score` VALUES ('4536', '8', 'Hannah', 'java', '3', '95', '68', '89', '94', '86');
INSERT INTO `score` VALUES ('4537', '9', 'Ian', 'java', '3', '100', '62', '87', '70', '79');
INSERT INTO `score` VALUES ('4538', '10', 'Jane', 'java', '3', '62', '98', '92', '70', '80');
INSERT INTO `score` VALUES ('4539', '11', 'Kate', 'java', '3', '72', '94', '66', '70', '75');
INSERT INTO `score` VALUES ('4540', '12', 'Liam', 'java', '3', '97', '92', '74', '65', '82');
INSERT INTO `score` VALUES ('4541', '13', 'Mia', 'java', '3', '81', '82', '94', '81', '84');
INSERT INTO `score` VALUES ('4542', '14', 'Noah', 'java', '3', '71', '70', '83', '94', '79');
INSERT INTO `score` VALUES ('4543', '15', 'Olivia', 'java', '3', '64', '99', '92', '84', '84');
INSERT INTO `score` VALUES ('4544', '31', 'Emily', 'c++', '1', '87', '66', '95', '62', '77');
INSERT INTO `score` VALUES ('4545', '32', 'Frank', 'c++', '1', '66', '68', '85', '82', '75');
INSERT INTO `score` VALUES ('4546', '33', 'Grace', 'c++', '1', '60', '77', '86', '97', '80');
INSERT INTO `score` VALUES ('4547', '34', 'Henry', 'c++', '1', '76', '79', '75', '98', '82');
INSERT INTO `score` VALUES ('4548', '35', 'Isabella', 'c++', '1', '88', '92', '73', '74', '81');
INSERT INTO `score` VALUES ('4549', '36', 'Jack', 'c++', '1', '61', '78', '76', '81', '74');
INSERT INTO `score` VALUES ('4550', '37', 'Karen', 'c++', '1', '69', '85', '75', '72', '75');
INSERT INTO `score` VALUES ('4551', '38', 'Leo', 'c++', '1', '85', '81', '60', '67', '73');
INSERT INTO `score` VALUES ('4552', '39', 'Megan', 'c++', '1', '92', '74', '73', '74', '78');
INSERT INTO `score` VALUES ('4553', '40', 'Nathan', 'c++', '1', '86', '83', '86', '98', '88');
INSERT INTO `score` VALUES ('4554', '41', 'Olive', 'c++', '1', '60', '75', '82', '70', '71');
INSERT INTO `score` VALUES ('4555', '42', 'Peter', 'c++', '1', '65', '75', '87', '81', '77');
INSERT INTO `score` VALUES ('4556', '43', 'Quincy', 'c++', '1', '91', '60', '72', '98', '80');
INSERT INTO `score` VALUES ('4557', '44', 'Robert', 'c++', '1', '89', '65', '75', '79', '77');
INSERT INTO `score` VALUES ('4558', '45', 'Sara', 'c++', '1', '85', '62', '74', '61', '70');
INSERT INTO `score` VALUES ('4559', '31', 'Emily', 'java', '3', '61', '83', '94', '60', '74');
INSERT INTO `score` VALUES ('4560', '32', 'Frank', 'java', '3', '76', '89', '78', '93', '84');
INSERT INTO `score` VALUES ('4561', '33', 'Grace', 'java', '3', '88', '69', '100', '64', '80');
INSERT INTO `score` VALUES ('4562', '34', 'Henry', 'java', '3', '92', '100', '72', '67', '82');
INSERT INTO `score` VALUES ('4563', '35', 'Isabella', 'java', '3', '91', '81', '80', '70', '80');
INSERT INTO `score` VALUES ('4564', '36', 'Jack', 'java', '3', '84', '99', '96', '74', '88');
INSERT INTO `score` VALUES ('4565', '37', 'Karen', 'java', '3', '97', '60', '74', '88', '79');
INSERT INTO `score` VALUES ('4566', '38', 'Leo', 'java', '3', '80', '83', '63', '62', '72');
INSERT INTO `score` VALUES ('4567', '39', 'Megan', 'java', '3', '97', '79', '94', '97', '91');
INSERT INTO `score` VALUES ('4568', '40', 'Nathan', 'java', '3', '79', '86', '84', '66', '78');
INSERT INTO `score` VALUES ('4569', '41', 'Olive', 'java', '3', '100', '66', '66', '64', '74');
INSERT INTO `score` VALUES ('4570', '42', 'Peter', 'java', '3', '98', '96', '90', '76', '90');
INSERT INTO `score` VALUES ('4571', '43', 'Quincy', 'java', '3', '77', '67', '81', '64', '72');
INSERT INTO `score` VALUES ('4572', '44', 'Robert', 'java', '3', '76', '77', '88', '100', '85');
INSERT INTO `score` VALUES ('4573', '45', 'Sara', 'java', '3', '99', '69', '72', '100', '85');
INSERT INTO `score` VALUES ('4574', '61', 'Ingrid', 'c++', '1', '82', '74', '98', '67', '80');
INSERT INTO `score` VALUES ('4575', '62', 'Jake', 'c++', '1', '91', '80', '96', '88', '88');
INSERT INTO `score` VALUES ('4576', '63', 'Katie', 'c++', '1', '90', '88', '79', '74', '82');
INSERT INTO `score` VALUES ('4577', '64', 'Louis', 'c++', '1', '60', '100', '60', '97', '79');
INSERT INTO `score` VALUES ('4578', '65', 'Molly', 'c++', '1', '68', '83', '96', '85', '83');
INSERT INTO `score` VALUES ('4579', '66', 'Nick', 'c++', '1', '65', '63', '74', '85', '71');
INSERT INTO `score` VALUES ('4580', '67', 'Olivia', 'c++', '1', '79', '60', '67', '70', '69');
INSERT INTO `score` VALUES ('4581', '68', 'Paul', 'c++', '1', '98', '90', '76', '72', '84');
INSERT INTO `score` VALUES ('4582', '69', 'Quinn', 'c++', '1', '89', '87', '71', '99', '86');
INSERT INTO `score` VALUES ('4583', '70', 'Ryan', 'c++', '1', '100', '66', '96', '89', '87');
INSERT INTO `score` VALUES ('4584', '71', 'Samantha', 'c++', '1', '88', '88', '75', '72', '80');
INSERT INTO `score` VALUES ('4585', '72', 'Tom', 'c++', '1', '83', '83', '84', '64', '78');
INSERT INTO `score` VALUES ('4586', '73', 'Ursula', 'c++', '1', '97', '79', '62', '98', '84');
INSERT INTO `score` VALUES ('4587', '74', 'Victor', 'c++', '1', '63', '62', '88', '95', '77');
INSERT INTO `score` VALUES ('4588', '75', 'Wendy', 'c++', '1', '71', '96', '74', '79', '80');
INSERT INTO `score` VALUES ('4589', '91', 'Megan', 'java', '3', '75', '69', '76', '74', '73');
INSERT INTO `score` VALUES ('4590', '92', 'Nathan', 'java', '3', '75', '70', '95', '94', '83');
INSERT INTO `score` VALUES ('4591', '93', 'Olive', 'java', '3', '85', '80', '68', '90', '80');
INSERT INTO `score` VALUES ('4592', '94', 'Peter', 'java', '3', '88', '68', '81', '71', '77');
INSERT INTO `score` VALUES ('4593', '95', 'Quincy', 'java', '3', '74', '88', '97', '60', '79');
INSERT INTO `score` VALUES ('4594', '96', 'Robert', 'java', '3', '83', '84', '97', '64', '82');
INSERT INTO `score` VALUES ('4595', '97', 'Sara', 'java', '3', '96', '73', '92', '73', '83');
INSERT INTO `score` VALUES ('4596', '98', 'Tom', 'java', '3', '89', '74', '81', '80', '81');
INSERT INTO `score` VALUES ('4597', '99', 'Uma', 'java', '3', '65', '73', '99', '69', '76');
INSERT INTO `score` VALUES ('4598', '100', 'Vincent', 'java', '3', '80', '65', '80', '66', '72');
INSERT INTO `score` VALUES ('4599', '101', 'Wendy', 'java', '3', '98', '85', '69', '68', '80');
INSERT INTO `score` VALUES ('4600', '102', 'Xander', 'java', '3', '67', '85', '82', '92', '81');
INSERT INTO `score` VALUES ('4601', '103', 'Yara', 'java', '3', '63', '96', '80', '71', '77');
INSERT INTO `score` VALUES ('4602', '104', 'Zack', 'java', '3', '75', '76', '84', '95', '82');
INSERT INTO `score` VALUES ('4603', '105', 'Anna', 'java', '3', '69', '69', '71', '61', '67');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `studentId` int(11) DEFAULT NULL,
  `name` varchar(10) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `grade` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', 'Alice', 'Female', '2021');
INSERT INTO `student` VALUES ('2', 'Bob', 'Male', '2021');
INSERT INTO `student` VALUES ('3', 'Charlie', 'Male', '2021');
INSERT INTO `student` VALUES ('4', 'Diana', 'Female', '2021');
INSERT INTO `student` VALUES ('5', 'Edward', 'Male', '2021');
INSERT INTO `student` VALUES ('6', 'Fiona', 'Female', '2021');
INSERT INTO `student` VALUES ('7', 'George', 'Male', '2021');
INSERT INTO `student` VALUES ('8', 'Hannah', 'Female', '2021');
INSERT INTO `student` VALUES ('9', 'Ian', 'Male', '2021');
INSERT INTO `student` VALUES ('10', 'Jane', 'Female', '2021');
INSERT INTO `student` VALUES ('11', 'Kate', 'Female', '2021');
INSERT INTO `student` VALUES ('12', 'Liam', 'Male', '2021');
INSERT INTO `student` VALUES ('13', 'Mia', 'Female', '2021');
INSERT INTO `student` VALUES ('14', 'Noah', 'Male', '2021');
INSERT INTO `student` VALUES ('15', 'Olivia', 'Female', '2021');
INSERT INTO `student` VALUES ('16', 'Patrick', 'Male', '2021');
INSERT INTO `student` VALUES ('17', 'Quinn', 'Female', '2021');
INSERT INTO `student` VALUES ('18', 'Ryan', 'Male', '2021');
INSERT INTO `student` VALUES ('19', 'Samantha', 'Female', '2021');
INSERT INTO `student` VALUES ('20', 'Thomas', 'Male', '2021');
INSERT INTO `student` VALUES ('21', 'Ursula', 'Female', '2021');
INSERT INTO `student` VALUES ('22', 'Victor', 'Male', '2021');
INSERT INTO `student` VALUES ('23', 'Wendy', 'Female', '2021');
INSERT INTO `student` VALUES ('24', 'Xavier', 'Male', '2021');
INSERT INTO `student` VALUES ('25', 'Yvonne', 'Female', '2021');
INSERT INTO `student` VALUES ('26', 'Zane', 'Male', '2021');
INSERT INTO `student` VALUES ('27', 'Amy', 'Female', '2021');
INSERT INTO `student` VALUES ('28', 'Ben', 'Male', '2021');
INSERT INTO `student` VALUES ('29', 'Cathy', 'Female', '2021');
INSERT INTO `student` VALUES ('30', 'David', 'Male', '2021');
INSERT INTO `student` VALUES ('31', 'Emily', 'Female', '2021');
INSERT INTO `student` VALUES ('32', 'Frank', 'Male', '2021');
INSERT INTO `student` VALUES ('33', 'Grace', 'Female', '2021');
INSERT INTO `student` VALUES ('34', 'Henry', 'Male', '2021');
INSERT INTO `student` VALUES ('35', 'Isabella', 'Female', '2021');
INSERT INTO `student` VALUES ('36', 'Jack', 'Male', '2021');
INSERT INTO `student` VALUES ('37', 'Karen', 'Female', '2021');
INSERT INTO `student` VALUES ('38', 'Leo', 'Male', '2021');
INSERT INTO `student` VALUES ('39', 'Megan', 'Female', '2021');
INSERT INTO `student` VALUES ('40', 'Nathan', 'Male', '2021');
INSERT INTO `student` VALUES ('41', 'Olive', 'Female', '2021');
INSERT INTO `student` VALUES ('42', 'Peter', 'Male', '2021');
INSERT INTO `student` VALUES ('43', 'Quincy', 'Female', '2021');
INSERT INTO `student` VALUES ('44', 'Robert', 'Male', '2021');
INSERT INTO `student` VALUES ('45', 'Sara', 'Female', '2021');
INSERT INTO `student` VALUES ('46', 'Tom', 'Male', '2021');
INSERT INTO `student` VALUES ('47', 'Uma', 'Female', '2021');
INSERT INTO `student` VALUES ('48', 'Vincent', 'Male', '2021');
INSERT INTO `student` VALUES ('49', 'Wendy', 'Female', '2021');
INSERT INTO `student` VALUES ('50', 'Xander', 'Male', '2021');
INSERT INTO `student` VALUES ('51', 'Yara', 'Female', '2021');
INSERT INTO `student` VALUES ('52', 'Zack', 'Male', '2021');
INSERT INTO `student` VALUES ('53', 'Anna', 'Female', '2021');
INSERT INTO `student` VALUES ('54', 'Brian', 'Male', '2021');
INSERT INTO `student` VALUES ('55', 'Cynthia', 'Female', '2021');
INSERT INTO `student` VALUES ('56', 'Daniel', 'Male', '2021');
INSERT INTO `student` VALUES ('57', 'Ella', 'Female', '2021');
INSERT INTO `student` VALUES ('58', 'Fred', 'Male', '2021');
INSERT INTO `student` VALUES ('59', 'Gina', 'Female', '2021');
INSERT INTO `student` VALUES ('60', 'Harry', 'Male', '2021');
INSERT INTO `student` VALUES ('61', 'Ingrid', 'Female', '2021');
INSERT INTO `student` VALUES ('62', 'Jake', 'Male', '2021');
INSERT INTO `student` VALUES ('63', 'Katie', 'Female', '2021');
INSERT INTO `student` VALUES ('64', 'Louis', 'Male', '2021');
INSERT INTO `student` VALUES ('65', 'Molly', 'Female', '2021');
INSERT INTO `student` VALUES ('66', 'Nick', 'Male', '2021');
INSERT INTO `student` VALUES ('67', 'Olivia', 'Female', '2021');
INSERT INTO `student` VALUES ('68', 'Paul', 'Male', '2021');
INSERT INTO `student` VALUES ('69', 'Quinn', 'Female', '2021');
INSERT INTO `student` VALUES ('70', 'Ryan', 'Male', '2021');
INSERT INTO `student` VALUES ('71', 'Samantha', 'Female', '2021');
INSERT INTO `student` VALUES ('72', 'Tom', 'Male', '2021');
INSERT INTO `student` VALUES ('73', 'Ursula', 'Female', '2021');
INSERT INTO `student` VALUES ('74', 'Victor', 'Male', '2021');
INSERT INTO `student` VALUES ('75', 'Wendy', 'Female', '2021');
INSERT INTO `student` VALUES ('76', 'Xavier', 'Male', '2021');
INSERT INTO `student` VALUES ('77', 'Yvonne', 'Female', '2021');
INSERT INTO `student` VALUES ('78', 'Zane', 'Male', '2021');
INSERT INTO `student` VALUES ('79', 'Amy', 'Female', '2021');
INSERT INTO `student` VALUES ('80', 'Ben', 'Male', '2021');
INSERT INTO `student` VALUES ('81', 'Cathy', 'Female', '2021');
INSERT INTO `student` VALUES ('82', 'David', 'Male', '2021');
INSERT INTO `student` VALUES ('83', 'Emily', 'Female', '2021');
INSERT INTO `student` VALUES ('84', 'Frank', 'Male', '2021');
INSERT INTO `student` VALUES ('85', 'Grace', 'Female', '2021');
INSERT INTO `student` VALUES ('86', 'Henry', 'Male', '2021');
INSERT INTO `student` VALUES ('87', 'Isabella', 'Female', '2021');
INSERT INTO `student` VALUES ('88', 'Jack', 'Male', '2021');
INSERT INTO `student` VALUES ('89', 'Karen', 'Female', '2021');
INSERT INTO `student` VALUES ('90', 'Leo', 'Male', '2021');
INSERT INTO `student` VALUES ('91', 'Megan', 'Female', '2021');
INSERT INTO `student` VALUES ('92', 'Nathan', 'Male', '2021');
INSERT INTO `student` VALUES ('93', 'Olive', 'Female', '2021');
INSERT INTO `student` VALUES ('94', 'Peter', 'Male', '2021');
INSERT INTO `student` VALUES ('95', 'Quincy', 'Female', '2021');
INSERT INTO `student` VALUES ('96', 'Robert', 'Male', '2021');
INSERT INTO `student` VALUES ('97', 'Sara', 'Female', '2021');
INSERT INTO `student` VALUES ('98', 'Tom', 'Male', '2021');
INSERT INTO `student` VALUES ('99', 'Uma', 'Female', '2021');
INSERT INTO `student` VALUES ('100', 'Vincent', 'Male', '2021');
INSERT INTO `student` VALUES ('101', 'Wendy', 'Female', '2021');
INSERT INTO `student` VALUES ('102', 'Xander', 'Male', '2021');
INSERT INTO `student` VALUES ('103', 'Yara', 'Female', '2021');
INSERT INTO `student` VALUES ('104', 'Zack', 'Male', '2021');
INSERT INTO `student` VALUES ('105', 'Anna', 'Female', '2021');
INSERT INTO `student` VALUES ('106', 'Brian', 'Male', '2021');
INSERT INTO `student` VALUES ('107', 'Cynthia', 'Female', '2021');
INSERT INTO `student` VALUES ('108', 'Daniel', 'Male', '2021');
INSERT INTO `student` VALUES ('109', 'Ella', 'Female', '2021');
INSERT INTO `student` VALUES ('110', 'Fred', 'Male', '2021');
INSERT INTO `student` VALUES ('111', 'Alice', 'Female', '2021');
INSERT INTO `student` VALUES ('112', 'Bob', 'Male', '2021');
INSERT INTO `student` VALUES ('113', 'Charlie', 'Male', '2021');
INSERT INTO `student` VALUES ('114', 'David', 'Male', '2021');
INSERT INTO `student` VALUES ('115', 'Eve', 'Female', '2021');
INSERT INTO `student` VALUES ('116', 'Frank', 'Male', '2021');
INSERT INTO `student` VALUES ('117', 'Grace', 'Female', '2021');
INSERT INTO `student` VALUES ('118', 'Henry', 'Male', '2021');
INSERT INTO `student` VALUES ('119', 'Ivy', 'Female', '2021');
INSERT INTO `student` VALUES ('120', 'Jack', 'Male', '2021');

-- ----------------------------
-- Table structure for `studentclass`
-- ----------------------------
DROP TABLE IF EXISTS `studentclass`;
CREATE TABLE `studentclass` (
  `studentId` int(11) DEFAULT NULL,
  `classId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of studentclass
-- ----------------------------
INSERT INTO `studentclass` VALUES ('1', '1');
INSERT INTO `studentclass` VALUES ('2', '1');
INSERT INTO `studentclass` VALUES ('3', '1');
INSERT INTO `studentclass` VALUES ('4', '1');
INSERT INTO `studentclass` VALUES ('5', '1');
INSERT INTO `studentclass` VALUES ('6', '1');
INSERT INTO `studentclass` VALUES ('7', '1');
INSERT INTO `studentclass` VALUES ('8', '1');
INSERT INTO `studentclass` VALUES ('9', '1');
INSERT INTO `studentclass` VALUES ('10', '1');
INSERT INTO `studentclass` VALUES ('11', '1');
INSERT INTO `studentclass` VALUES ('12', '1');
INSERT INTO `studentclass` VALUES ('13', '1');
INSERT INTO `studentclass` VALUES ('14', '1');
INSERT INTO `studentclass` VALUES ('15', '1');
INSERT INTO `studentclass` VALUES ('1', '3');
INSERT INTO `studentclass` VALUES ('2', '3');
INSERT INTO `studentclass` VALUES ('3', '3');
INSERT INTO `studentclass` VALUES ('4', '3');
INSERT INTO `studentclass` VALUES ('5', '3');
INSERT INTO `studentclass` VALUES ('6', '3');
INSERT INTO `studentclass` VALUES ('7', '3');
INSERT INTO `studentclass` VALUES ('8', '3');
INSERT INTO `studentclass` VALUES ('9', '3');
INSERT INTO `studentclass` VALUES ('10', '3');
INSERT INTO `studentclass` VALUES ('11', '3');
INSERT INTO `studentclass` VALUES ('12', '3');
INSERT INTO `studentclass` VALUES ('13', '3');
INSERT INTO `studentclass` VALUES ('14', '3');
INSERT INTO `studentclass` VALUES ('15', '3');
INSERT INTO `studentclass` VALUES ('1', '5');
INSERT INTO `studentclass` VALUES ('2', '5');
INSERT INTO `studentclass` VALUES ('3', '5');
INSERT INTO `studentclass` VALUES ('4', '5');
INSERT INTO `studentclass` VALUES ('5', '5');
INSERT INTO `studentclass` VALUES ('6', '5');
INSERT INTO `studentclass` VALUES ('7', '5');
INSERT INTO `studentclass` VALUES ('8', '5');
INSERT INTO `studentclass` VALUES ('9', '5');
INSERT INTO `studentclass` VALUES ('10', '5');
INSERT INTO `studentclass` VALUES ('11', '5');
INSERT INTO `studentclass` VALUES ('12', '5');
INSERT INTO `studentclass` VALUES ('13', '5');
INSERT INTO `studentclass` VALUES ('14', '5');
INSERT INTO `studentclass` VALUES ('15', '5');
INSERT INTO `studentclass` VALUES ('16', '2');
INSERT INTO `studentclass` VALUES ('17', '2');
INSERT INTO `studentclass` VALUES ('18', '2');
INSERT INTO `studentclass` VALUES ('19', '2');
INSERT INTO `studentclass` VALUES ('20', '2');
INSERT INTO `studentclass` VALUES ('21', '2');
INSERT INTO `studentclass` VALUES ('22', '2');
INSERT INTO `studentclass` VALUES ('23', '2');
INSERT INTO `studentclass` VALUES ('24', '2');
INSERT INTO `studentclass` VALUES ('25', '2');
INSERT INTO `studentclass` VALUES ('26', '2');
INSERT INTO `studentclass` VALUES ('27', '2');
INSERT INTO `studentclass` VALUES ('28', '2');
INSERT INTO `studentclass` VALUES ('29', '2');
INSERT INTO `studentclass` VALUES ('30', '2');
INSERT INTO `studentclass` VALUES ('16', '4');
INSERT INTO `studentclass` VALUES ('17', '4');
INSERT INTO `studentclass` VALUES ('18', '4');
INSERT INTO `studentclass` VALUES ('19', '4');
INSERT INTO `studentclass` VALUES ('20', '4');
INSERT INTO `studentclass` VALUES ('21', '4');
INSERT INTO `studentclass` VALUES ('22', '4');
INSERT INTO `studentclass` VALUES ('23', '4');
INSERT INTO `studentclass` VALUES ('24', '4');
INSERT INTO `studentclass` VALUES ('25', '4');
INSERT INTO `studentclass` VALUES ('26', '4');
INSERT INTO `studentclass` VALUES ('27', '4');
INSERT INTO `studentclass` VALUES ('28', '4');
INSERT INTO `studentclass` VALUES ('29', '4');
INSERT INTO `studentclass` VALUES ('30', '4');
INSERT INTO `studentclass` VALUES ('16', '6');
INSERT INTO `studentclass` VALUES ('17', '6');
INSERT INTO `studentclass` VALUES ('18', '6');
INSERT INTO `studentclass` VALUES ('19', '6');
INSERT INTO `studentclass` VALUES ('20', '6');
INSERT INTO `studentclass` VALUES ('21', '6');
INSERT INTO `studentclass` VALUES ('22', '6');
INSERT INTO `studentclass` VALUES ('23', '6');
INSERT INTO `studentclass` VALUES ('24', '6');
INSERT INTO `studentclass` VALUES ('25', '6');
INSERT INTO `studentclass` VALUES ('26', '6');
INSERT INTO `studentclass` VALUES ('27', '6');
INSERT INTO `studentclass` VALUES ('28', '6');
INSERT INTO `studentclass` VALUES ('29', '6');
INSERT INTO `studentclass` VALUES ('30', '6');
INSERT INTO `studentclass` VALUES ('31', '1');
INSERT INTO `studentclass` VALUES ('32', '1');
INSERT INTO `studentclass` VALUES ('33', '1');
INSERT INTO `studentclass` VALUES ('34', '1');
INSERT INTO `studentclass` VALUES ('35', '1');
INSERT INTO `studentclass` VALUES ('36', '1');
INSERT INTO `studentclass` VALUES ('37', '1');
INSERT INTO `studentclass` VALUES ('38', '1');
INSERT INTO `studentclass` VALUES ('39', '1');
INSERT INTO `studentclass` VALUES ('40', '1');
INSERT INTO `studentclass` VALUES ('41', '1');
INSERT INTO `studentclass` VALUES ('42', '1');
INSERT INTO `studentclass` VALUES ('43', '1');
INSERT INTO `studentclass` VALUES ('44', '1');
INSERT INTO `studentclass` VALUES ('45', '1');
INSERT INTO `studentclass` VALUES ('31', '3');
INSERT INTO `studentclass` VALUES ('32', '3');
INSERT INTO `studentclass` VALUES ('33', '3');
INSERT INTO `studentclass` VALUES ('34', '3');
INSERT INTO `studentclass` VALUES ('35', '3');
INSERT INTO `studentclass` VALUES ('36', '3');
INSERT INTO `studentclass` VALUES ('37', '3');
INSERT INTO `studentclass` VALUES ('38', '3');
INSERT INTO `studentclass` VALUES ('39', '3');
INSERT INTO `studentclass` VALUES ('40', '3');
INSERT INTO `studentclass` VALUES ('41', '3');
INSERT INTO `studentclass` VALUES ('42', '3');
INSERT INTO `studentclass` VALUES ('43', '3');
INSERT INTO `studentclass` VALUES ('44', '3');
INSERT INTO `studentclass` VALUES ('45', '3');
INSERT INTO `studentclass` VALUES ('31', '7');
INSERT INTO `studentclass` VALUES ('32', '7');
INSERT INTO `studentclass` VALUES ('33', '7');
INSERT INTO `studentclass` VALUES ('34', '7');
INSERT INTO `studentclass` VALUES ('35', '7');
INSERT INTO `studentclass` VALUES ('36', '7');
INSERT INTO `studentclass` VALUES ('37', '7');
INSERT INTO `studentclass` VALUES ('38', '7');
INSERT INTO `studentclass` VALUES ('39', '7');
INSERT INTO `studentclass` VALUES ('40', '7');
INSERT INTO `studentclass` VALUES ('41', '7');
INSERT INTO `studentclass` VALUES ('42', '7');
INSERT INTO `studentclass` VALUES ('43', '7');
INSERT INTO `studentclass` VALUES ('44', '7');
INSERT INTO `studentclass` VALUES ('45', '7');
INSERT INTO `studentclass` VALUES ('46', '2');
INSERT INTO `studentclass` VALUES ('47', '2');
INSERT INTO `studentclass` VALUES ('48', '2');
INSERT INTO `studentclass` VALUES ('49', '2');
INSERT INTO `studentclass` VALUES ('50', '2');
INSERT INTO `studentclass` VALUES ('51', '2');
INSERT INTO `studentclass` VALUES ('52', '2');
INSERT INTO `studentclass` VALUES ('53', '2');
INSERT INTO `studentclass` VALUES ('54', '2');
INSERT INTO `studentclass` VALUES ('55', '2');
INSERT INTO `studentclass` VALUES ('56', '2');
INSERT INTO `studentclass` VALUES ('57', '2');
INSERT INTO `studentclass` VALUES ('58', '2');
INSERT INTO `studentclass` VALUES ('59', '2');
INSERT INTO `studentclass` VALUES ('60', '2');
INSERT INTO `studentclass` VALUES ('46', '4');
INSERT INTO `studentclass` VALUES ('47', '4');
INSERT INTO `studentclass` VALUES ('48', '4');
INSERT INTO `studentclass` VALUES ('49', '4');
INSERT INTO `studentclass` VALUES ('50', '4');
INSERT INTO `studentclass` VALUES ('51', '4');
INSERT INTO `studentclass` VALUES ('52', '4');
INSERT INTO `studentclass` VALUES ('53', '4');
INSERT INTO `studentclass` VALUES ('54', '4');
INSERT INTO `studentclass` VALUES ('55', '4');
INSERT INTO `studentclass` VALUES ('56', '4');
INSERT INTO `studentclass` VALUES ('57', '4');
INSERT INTO `studentclass` VALUES ('58', '4');
INSERT INTO `studentclass` VALUES ('59', '4');
INSERT INTO `studentclass` VALUES ('60', '4');
INSERT INTO `studentclass` VALUES ('46', '8');
INSERT INTO `studentclass` VALUES ('47', '8');
INSERT INTO `studentclass` VALUES ('48', '8');
INSERT INTO `studentclass` VALUES ('49', '8');
INSERT INTO `studentclass` VALUES ('50', '8');
INSERT INTO `studentclass` VALUES ('51', '8');
INSERT INTO `studentclass` VALUES ('52', '8');
INSERT INTO `studentclass` VALUES ('53', '8');
INSERT INTO `studentclass` VALUES ('54', '8');
INSERT INTO `studentclass` VALUES ('55', '8');
INSERT INTO `studentclass` VALUES ('56', '8');
INSERT INTO `studentclass` VALUES ('57', '8');
INSERT INTO `studentclass` VALUES ('58', '8');
INSERT INTO `studentclass` VALUES ('59', '8');
INSERT INTO `studentclass` VALUES ('60', '8');
INSERT INTO `studentclass` VALUES ('61', '1');
INSERT INTO `studentclass` VALUES ('62', '1');
INSERT INTO `studentclass` VALUES ('63', '1');
INSERT INTO `studentclass` VALUES ('64', '1');
INSERT INTO `studentclass` VALUES ('65', '1');
INSERT INTO `studentclass` VALUES ('66', '1');
INSERT INTO `studentclass` VALUES ('67', '1');
INSERT INTO `studentclass` VALUES ('68', '1');
INSERT INTO `studentclass` VALUES ('69', '1');
INSERT INTO `studentclass` VALUES ('70', '1');
INSERT INTO `studentclass` VALUES ('71', '1');
INSERT INTO `studentclass` VALUES ('72', '1');
INSERT INTO `studentclass` VALUES ('73', '1');
INSERT INTO `studentclass` VALUES ('74', '1');
INSERT INTO `studentclass` VALUES ('75', '1');
INSERT INTO `studentclass` VALUES ('61', '5');
INSERT INTO `studentclass` VALUES ('62', '5');
INSERT INTO `studentclass` VALUES ('63', '5');
INSERT INTO `studentclass` VALUES ('64', '5');
INSERT INTO `studentclass` VALUES ('65', '5');
INSERT INTO `studentclass` VALUES ('66', '5');
INSERT INTO `studentclass` VALUES ('67', '5');
INSERT INTO `studentclass` VALUES ('68', '5');
INSERT INTO `studentclass` VALUES ('69', '5');
INSERT INTO `studentclass` VALUES ('70', '5');
INSERT INTO `studentclass` VALUES ('71', '5');
INSERT INTO `studentclass` VALUES ('72', '5');
INSERT INTO `studentclass` VALUES ('73', '5');
INSERT INTO `studentclass` VALUES ('74', '5');
INSERT INTO `studentclass` VALUES ('75', '5');
INSERT INTO `studentclass` VALUES ('61', '7');
INSERT INTO `studentclass` VALUES ('62', '7');
INSERT INTO `studentclass` VALUES ('63', '7');
INSERT INTO `studentclass` VALUES ('64', '7');
INSERT INTO `studentclass` VALUES ('65', '7');
INSERT INTO `studentclass` VALUES ('66', '7');
INSERT INTO `studentclass` VALUES ('67', '7');
INSERT INTO `studentclass` VALUES ('68', '7');
INSERT INTO `studentclass` VALUES ('69', '7');
INSERT INTO `studentclass` VALUES ('70', '7');
INSERT INTO `studentclass` VALUES ('71', '7');
INSERT INTO `studentclass` VALUES ('72', '7');
INSERT INTO `studentclass` VALUES ('73', '7');
INSERT INTO `studentclass` VALUES ('74', '7');
INSERT INTO `studentclass` VALUES ('75', '7');
INSERT INTO `studentclass` VALUES ('76', '2');
INSERT INTO `studentclass` VALUES ('77', '2');
INSERT INTO `studentclass` VALUES ('78', '2');
INSERT INTO `studentclass` VALUES ('79', '2');
INSERT INTO `studentclass` VALUES ('80', '2');
INSERT INTO `studentclass` VALUES ('81', '2');
INSERT INTO `studentclass` VALUES ('82', '2');
INSERT INTO `studentclass` VALUES ('83', '2');
INSERT INTO `studentclass` VALUES ('84', '2');
INSERT INTO `studentclass` VALUES ('85', '2');
INSERT INTO `studentclass` VALUES ('86', '2');
INSERT INTO `studentclass` VALUES ('87', '2');
INSERT INTO `studentclass` VALUES ('88', '2');
INSERT INTO `studentclass` VALUES ('89', '2');
INSERT INTO `studentclass` VALUES ('90', '2');
INSERT INTO `studentclass` VALUES ('76', '6');
INSERT INTO `studentclass` VALUES ('77', '6');
INSERT INTO `studentclass` VALUES ('78', '6');
INSERT INTO `studentclass` VALUES ('79', '6');
INSERT INTO `studentclass` VALUES ('80', '6');
INSERT INTO `studentclass` VALUES ('81', '6');
INSERT INTO `studentclass` VALUES ('82', '6');
INSERT INTO `studentclass` VALUES ('83', '6');
INSERT INTO `studentclass` VALUES ('84', '6');
INSERT INTO `studentclass` VALUES ('85', '6');
INSERT INTO `studentclass` VALUES ('86', '6');
INSERT INTO `studentclass` VALUES ('87', '6');
INSERT INTO `studentclass` VALUES ('88', '6');
INSERT INTO `studentclass` VALUES ('89', '6');
INSERT INTO `studentclass` VALUES ('90', '6');
INSERT INTO `studentclass` VALUES ('76', '8');
INSERT INTO `studentclass` VALUES ('77', '8');
INSERT INTO `studentclass` VALUES ('78', '8');
INSERT INTO `studentclass` VALUES ('79', '8');
INSERT INTO `studentclass` VALUES ('80', '8');
INSERT INTO `studentclass` VALUES ('81', '8');
INSERT INTO `studentclass` VALUES ('82', '8');
INSERT INTO `studentclass` VALUES ('83', '8');
INSERT INTO `studentclass` VALUES ('84', '8');
INSERT INTO `studentclass` VALUES ('85', '8');
INSERT INTO `studentclass` VALUES ('86', '8');
INSERT INTO `studentclass` VALUES ('87', '8');
INSERT INTO `studentclass` VALUES ('88', '8');
INSERT INTO `studentclass` VALUES ('89', '8');
INSERT INTO `studentclass` VALUES ('90', '8');
INSERT INTO `studentclass` VALUES ('91', '3');
INSERT INTO `studentclass` VALUES ('92', '3');
INSERT INTO `studentclass` VALUES ('93', '3');
INSERT INTO `studentclass` VALUES ('94', '3');
INSERT INTO `studentclass` VALUES ('95', '3');
INSERT INTO `studentclass` VALUES ('96', '3');
INSERT INTO `studentclass` VALUES ('97', '3');
INSERT INTO `studentclass` VALUES ('98', '3');
INSERT INTO `studentclass` VALUES ('99', '3');
INSERT INTO `studentclass` VALUES ('100', '3');
INSERT INTO `studentclass` VALUES ('101', '3');
INSERT INTO `studentclass` VALUES ('102', '3');
INSERT INTO `studentclass` VALUES ('103', '3');
INSERT INTO `studentclass` VALUES ('104', '3');
INSERT INTO `studentclass` VALUES ('105', '3');
INSERT INTO `studentclass` VALUES ('91', '5');
INSERT INTO `studentclass` VALUES ('92', '5');
INSERT INTO `studentclass` VALUES ('93', '5');
INSERT INTO `studentclass` VALUES ('94', '5');
INSERT INTO `studentclass` VALUES ('95', '5');
INSERT INTO `studentclass` VALUES ('96', '5');
INSERT INTO `studentclass` VALUES ('97', '5');
INSERT INTO `studentclass` VALUES ('98', '5');
INSERT INTO `studentclass` VALUES ('99', '5');
INSERT INTO `studentclass` VALUES ('100', '5');
INSERT INTO `studentclass` VALUES ('101', '5');
INSERT INTO `studentclass` VALUES ('102', '5');
INSERT INTO `studentclass` VALUES ('103', '5');
INSERT INTO `studentclass` VALUES ('104', '5');
INSERT INTO `studentclass` VALUES ('105', '5');
INSERT INTO `studentclass` VALUES ('91', '7');
INSERT INTO `studentclass` VALUES ('92', '7');
INSERT INTO `studentclass` VALUES ('93', '7');
INSERT INTO `studentclass` VALUES ('94', '7');
INSERT INTO `studentclass` VALUES ('95', '7');
INSERT INTO `studentclass` VALUES ('96', '7');
INSERT INTO `studentclass` VALUES ('97', '7');
INSERT INTO `studentclass` VALUES ('98', '7');
INSERT INTO `studentclass` VALUES ('99', '7');
INSERT INTO `studentclass` VALUES ('100', '7');
INSERT INTO `studentclass` VALUES ('101', '7');
INSERT INTO `studentclass` VALUES ('102', '7');
INSERT INTO `studentclass` VALUES ('103', '7');
INSERT INTO `studentclass` VALUES ('104', '7');
INSERT INTO `studentclass` VALUES ('105', '7');
INSERT INTO `studentclass` VALUES ('106', '4');
INSERT INTO `studentclass` VALUES ('107', '4');
INSERT INTO `studentclass` VALUES ('108', '4');
INSERT INTO `studentclass` VALUES ('109', '4');
INSERT INTO `studentclass` VALUES ('110', '4');
INSERT INTO `studentclass` VALUES ('111', '4');
INSERT INTO `studentclass` VALUES ('112', '4');
INSERT INTO `studentclass` VALUES ('113', '4');
INSERT INTO `studentclass` VALUES ('114', '4');
INSERT INTO `studentclass` VALUES ('115', '4');
INSERT INTO `studentclass` VALUES ('116', '4');
INSERT INTO `studentclass` VALUES ('117', '4');
INSERT INTO `studentclass` VALUES ('118', '4');
INSERT INTO `studentclass` VALUES ('119', '4');
INSERT INTO `studentclass` VALUES ('120', '4');
INSERT INTO `studentclass` VALUES ('106', '6');
INSERT INTO `studentclass` VALUES ('107', '6');
INSERT INTO `studentclass` VALUES ('108', '6');
INSERT INTO `studentclass` VALUES ('109', '6');
INSERT INTO `studentclass` VALUES ('110', '6');
INSERT INTO `studentclass` VALUES ('111', '6');
INSERT INTO `studentclass` VALUES ('112', '6');
INSERT INTO `studentclass` VALUES ('113', '6');
INSERT INTO `studentclass` VALUES ('114', '6');
INSERT INTO `studentclass` VALUES ('115', '6');
INSERT INTO `studentclass` VALUES ('116', '6');
INSERT INTO `studentclass` VALUES ('117', '6');
INSERT INTO `studentclass` VALUES ('118', '6');
INSERT INTO `studentclass` VALUES ('119', '6');
INSERT INTO `studentclass` VALUES ('120', '6');
INSERT INTO `studentclass` VALUES ('106', '8');
INSERT INTO `studentclass` VALUES ('107', '8');
INSERT INTO `studentclass` VALUES ('108', '8');
INSERT INTO `studentclass` VALUES ('109', '8');
INSERT INTO `studentclass` VALUES ('110', '8');
INSERT INTO `studentclass` VALUES ('111', '8');
INSERT INTO `studentclass` VALUES ('112', '8');
INSERT INTO `studentclass` VALUES ('113', '8');
INSERT INTO `studentclass` VALUES ('114', '8');
INSERT INTO `studentclass` VALUES ('115', '8');
INSERT INTO `studentclass` VALUES ('116', '8');
INSERT INTO `studentclass` VALUES ('117', '8');
INSERT INTO `studentclass` VALUES ('118', '8');
INSERT INTO `studentclass` VALUES ('119', '8');
INSERT INTO `studentclass` VALUES ('120', '8');

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `teacherId` int(11) DEFAULT NULL,
  `name` varchar(10) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', 'Alice', 'Female');
INSERT INTO `teacher` VALUES ('2', 'Bob', 'Male');
INSERT INTO `teacher` VALUES ('3', 'Charlie', 'Male');
INSERT INTO `teacher` VALUES ('4', 'Diana', 'Female');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` int(11) DEFAULT NULL,
  `pass` int(11) DEFAULT NULL,
  `isTeacher` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1234', '1');
INSERT INTO `user` VALUES ('2', '1234', '0');
