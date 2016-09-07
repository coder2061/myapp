/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : myapp

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2016-09-07 20:00:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for accesslog
-- ----------------------------
DROP TABLE IF EXISTS `accesslog`;
CREATE TABLE `accesslog` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ClickEntry` varchar(100) DEFAULT NULL COMMENT '点击入口',
  `MemberID` int(11) DEFAULT NULL,
  `Url` varchar(255) DEFAULT NULL,
  `Params` varchar(255) DEFAULT NULL,
  `Ip` varchar(20) DEFAULT NULL,
  `CreateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of accesslog
-- ----------------------------

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Role` tinyint(4) DEFAULT NULL COMMENT '角色',
  `Power` varchar(255) DEFAULT NULL COMMENT '权限',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------

-- ----------------------------
-- Table structure for attachment
-- ----------------------------
DROP TABLE IF EXISTS `attachment`;
CREATE TABLE `attachment` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '附件表',
  `MailID` int(11) DEFAULT NULL COMMENT '邮件内容ID',
  `Name` varchar(255) DEFAULT NULL,
  `Path` varchar(255) DEFAULT NULL COMMENT '文件路径',
  `Type` tinyint(4) DEFAULT NULL COMMENT '文件类型',
  `OrderNum` tinyint(4) DEFAULT NULL,
  `CreateTime` datetime DEFAULT NULL,
  `IsDelete` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='附件表';

-- ----------------------------
-- Records of attachment
-- ----------------------------

-- ----------------------------
-- Table structure for basic
-- ----------------------------
DROP TABLE IF EXISTS `basic`;
CREATE TABLE `basic` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CreateTime` datetime DEFAULT NULL COMMENT '创建时间',
  `UpdateTime` datetime DEFAULT NULL COMMENT '更新时间（最后）',
  `OrderNum` tinyint(4) DEFAULT '0' COMMENT '序号',
  `IsDelete` tinyint(1) DEFAULT NULL,
  `Status` tinyint(4) DEFAULT '0' COMMENT '状态',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of basic
-- ----------------------------

-- ----------------------------
-- Table structure for config
-- ----------------------------
DROP TABLE IF EXISTS `config`;
CREATE TABLE `config` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '配置信息ID',
  `Key` varchar(45) DEFAULT NULL COMMENT '关键词',
  `Val` varchar(500) DEFAULT NULL COMMENT '值',
  `Description` varchar(100) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='配置信息';

-- ----------------------------
-- Records of config
-- ----------------------------

-- ----------------------------
-- Table structure for contact
-- ----------------------------
DROP TABLE IF EXISTS `contact`;
CREATE TABLE `contact` (
  `ID` int(20) NOT NULL AUTO_INCREMENT COMMENT '联系人表',
  `ContactID` int(11) DEFAULT NULL COMMENT '联系人ID',
  `MemberID` int(11) DEFAULT NULL COMMENT '用户ID',
  `ContactGroupID` int(11) DEFAULT NULL COMMENT '联系人分组',
  `Name` varchar(60) DEFAULT '' COMMENT '联系人名',
  `Mobile` varchar(11) DEFAULT NULL COMMENT '手机号',
  `Email` varchar(100) DEFAULT NULL COMMENT '邮件地址',
  `QQ` varchar(255) DEFAULT NULL,
  `HeadPic` varchar(100) DEFAULT NULL COMMENT '头像',
  `Address` varchar(100) DEFAULT NULL COMMENT '地址',
  `CreateTime` datetime DEFAULT NULL COMMENT '创建时间',
  `UpdateTime` datetime DEFAULT NULL COMMENT '修改时间',
  `IsFirst` tinyint(1) DEFAULT '0' COMMENT 'MemberID是否首次发送邮件',
  `IsDel` tinyint(1) DEFAULT '0' COMMENT '是否删除 0否1是',
  `Status` tinyint(4) DEFAULT NULL COMMENT '0,等待同意 1同意 2系统外联系人',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`) USING BTREE,
  KEY `memberID` (`MemberID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='联系人表';

-- ----------------------------
-- Records of contact
-- ----------------------------
INSERT INTO `contact` VALUES ('1', '1', '4', '1', '姜子牙', '18779885539', 'jiangziya@jxau.com', '625337923', null, '北京朝阳', '2016-04-17 17:23:20', '2016-04-17 17:23:23', '0', '0', '1');
INSERT INTO `contact` VALUES ('2', '2', '4', '1', 'Jade', '18779885540', 'jiang@jxau.com', '625337924', null, '北京朝阳', '2016-04-17 18:08:46', '2016-04-17 18:08:48', '0', '0', '1');
INSERT INTO `contact` VALUES ('3', '3', '4', '2', 'aaa', '18779885512', 'jiang0@jxau.com', '66666666', null, 'beijing chaoyang', null, '2016-04-19 22:43:05', '0', '0', '1');
INSERT INTO `contact` VALUES ('4', '5', '4', '3', 'qqq', '18779885512', 'jiang1@jxau.com', '1111111111111', null, '北京朝阳', null, null, '0', '0', '1');
INSERT INTO `contact` VALUES ('5', '6', '4', '3', 'aaa', '18779885512', 'jiang2@jxau.com', '555555555', null, '望京', null, null, '0', '0', '1');

-- ----------------------------
-- Table structure for contactgroup
-- ----------------------------
DROP TABLE IF EXISTS `contactgroup`;
CREATE TABLE `contactgroup` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '联系人分组',
  `Name` varchar(64) DEFAULT NULL COMMENT '小组名',
  `Desc` varchar(255) DEFAULT NULL COMMENT '描述',
  `CreateTime` datetime DEFAULT NULL COMMENT '创建时间',
  `OrderNum` int(11) DEFAULT '0' COMMENT '序号',
  `IsDel` tinyint(1) DEFAULT '0' COMMENT '是否删除 0否1是',
  `Status` tinyint(4) DEFAULT '0' COMMENT '状态',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='联系人分组';

-- ----------------------------
-- Records of contactgroup
-- ----------------------------
INSERT INTO `contactgroup` VALUES ('1', '亲戚', null, '2016-04-17 16:59:32', '1', '0', '0');
INSERT INTO `contactgroup` VALUES ('2', '朋友', null, '2016-04-17 17:00:23', '2', '0', '0');
INSERT INTO `contactgroup` VALUES ('3', '同学', null, '2016-04-17 17:00:25', '3', '0', '0');
INSERT INTO `contactgroup` VALUES ('4', '同事', null, '2016-04-17 17:00:48', '4', '0', '0');

-- ----------------------------
-- Table structure for feedback
-- ----------------------------
DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户反馈表',
  `MemberID` int(11) DEFAULT NULL,
  `CreateTime` datetime DEFAULT NULL,
  `Title` varchar(100) DEFAULT NULL,
  `Content` varchar(1000) DEFAULT NULL,
  `AdminID` int(11) DEFAULT NULL,
  `IsReply` tinyint(1) DEFAULT '0' COMMENT '是否回复',
  `ReplyContent` varchar(1000) DEFAULT NULL,
  `ReplyTime` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户反馈表';

-- ----------------------------
-- Records of feedback
-- ----------------------------

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志表',
  `LogTypeID` int(11) DEFAULT NULL COMMENT '日志类型',
  `AdminID` int(11) DEFAULT NULL COMMENT '管理员',
  `MemberID` int(11) DEFAULT NULL COMMENT '用户',
  `MessageID` int(11) DEFAULT NULL COMMENT '邮件ID',
  `OperIp` varchar(50) DEFAULT NULL COMMENT '访问路径',
  `OperTime` datetime DEFAULT NULL COMMENT '操作时间',
  `OperDesc` varchar(255) DEFAULT NULL COMMENT '操作描述',
  `RequestContext` varchar(255) DEFAULT NULL COMMENT '全路径',
  `IsDel` tinyint(1) DEFAULT '0' COMMENT '删除标记 是否删除 0否1是',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8 COMMENT='日志表';

-- ----------------------------
-- Table structure for logtype
-- ----------------------------
DROP TABLE IF EXISTS `logtype`;
CREATE TABLE `logtype` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '日志类型',
  `TypeName` varchar(50) DEFAULT NULL,
  `TypeDesc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='日志类型';

-- ----------------------------
-- Records of logtype
-- ----------------------------
INSERT INTO `logtype` VALUES ('1', '用户注册', '用户日志');
INSERT INTO `logtype` VALUES ('2', '用户登录', '用户日志');
INSERT INTO `logtype` VALUES ('3', '新增联系人', '联系人日志');
INSERT INTO `logtype` VALUES ('4', '修改联系人', '联系人日志');
INSERT INTO `logtype` VALUES ('5', '删除联系人', '联系人日志');
INSERT INTO `logtype` VALUES ('6', '修改用户信息', '用户日志');
INSERT INTO `logtype` VALUES ('7', '修改用户密码', '用户日志');

-- ----------------------------
-- Table structure for mail
-- ----------------------------
DROP TABLE IF EXISTS `mail`;
CREATE TABLE `mail` (
  `ID` int(20) NOT NULL AUTO_INCREMENT COMMENT '邮件内容表',
  `Subject` varchar(50) DEFAULT NULL COMMENT '主题',
  `Content` varchar(1000) DEFAULT NULL COMMENT '内容',
  `Icon` varchar(100) DEFAULT NULL COMMENT '图标',
  `Url` varchar(255) DEFAULT NULL COMMENT '链接',
  `CreateTime` datetime DEFAULT NULL COMMENT '创建时间',
  `UpdateTime` datetime DEFAULT NULL COMMENT '修改时间',
  `IsDelete` tinyint(4) DEFAULT '0' COMMENT '发送者是否删除(0未删除  1标记删除  2彻底删除)',
  `DeleteTime` datetime DEFAULT NULL COMMENT '发送者删除时间',
  `IsDraft` tinyint(1) DEFAULT '0' COMMENT '是否草稿',
  `IsTag` tinyint(1) DEFAULT '0' COMMENT '是否被标记',
  `OrderNum` int(11) DEFAULT '0' COMMENT '序号',
  `Status` tinyint(4) DEFAULT '0' COMMENT '0:未读1：已读2：回复3：转发4：全部转发 ',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='邮件内容表';

-- ----------------------------
-- Records of mail
-- ----------------------------
INSERT INTO `mail` VALUES ('1', 'aaaa', 'aaaaa', null, null, '2016-04-18 23:41:50', '2016-04-18 23:41:52', '0', null, '0', '0', '0', '0');
INSERT INTO `mail` VALUES ('5', 'ccc', 'ddd', null, null, '2016-04-20 20:34:55', null, '0', null, '0', '0', '0', '0');
INSERT INTO `mail` VALUES ('6', 'www', 'wwwwwwwww', null, null, '2016-04-20 20:41:00', null, '0', null, '0', '0', '0', '0');

-- ----------------------------
-- Table structure for mailinbox
-- ----------------------------
DROP TABLE IF EXISTS `mailinbox`;
CREATE TABLE `mailinbox` (
  `ID` int(20) NOT NULL AUTO_INCREMENT COMMENT '收件箱',
  `ReceiverID` int(11) DEFAULT NULL COMMENT '接收者ID,0 表示为所有人',
  `SenderID` int(11) DEFAULT NULL,
  `MailID` int(11) DEFAULT NULL,
  `CreateTime` datetime DEFAULT NULL COMMENT '修改时间',
  `ReceiveType ` tinyint(4) DEFAULT NULL COMMENT '接收类型；0：普收 1：抄收 2：密收',
  `IsRead` tinyint(1) DEFAULT '0' COMMENT '接收者是否已阅',
  `ReadTime` datetime DEFAULT NULL COMMENT '阅读时间',
  `IsDel` tinyint(4) DEFAULT '0' COMMENT '接收者是否删除(0未删除  1标记删除  2彻底删除)',
  `DeleteTime` datetime DEFAULT NULL COMMENT '接收者删除时间',
  `IsTag` tinyint(1) DEFAULT '0' COMMENT '是否被标记',
  `IsReply` tinyint(1) DEFAULT '0' COMMENT '是否回复',
  `ReplyID` int(11) DEFAULT NULL COMMENT '回复邮件ID',
  `OrderNum` int(11) DEFAULT '0' COMMENT '序号',
  `Status` tinyint(4) DEFAULT '0' COMMENT '0:未读1：已读2：回复3：转发4：全部转发 ',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='收件箱';

-- ----------------------------
-- Records of mailinbox
-- ----------------------------
INSERT INTO `mailinbox` VALUES ('1', '2', '1', '1', '2016-04-18 23:42:13', '1', '0', null, '0', null, '0', '0', null, '0', '0');
INSERT INTO `mailinbox` VALUES ('2', '4', '1', '1', '2016-04-20 19:49:32', '1', '0', null, '0', null, '0', '0', null, '0', '0');
INSERT INTO `mailinbox` VALUES ('3', '5', null, '6', '2016-04-20 20:41:00', null, '0', null, '0', null, '0', '0', null, '0', '0');
INSERT INTO `mailinbox` VALUES ('4', '5', null, '6', '2016-04-20 20:41:00', null, '0', null, '0', null, '0', '0', null, '0', '0');

-- ----------------------------
-- Table structure for mailoutbox
-- ----------------------------
DROP TABLE IF EXISTS `mailoutbox`;
CREATE TABLE `mailoutbox` (
  `ID` int(20) NOT NULL AUTO_INCREMENT COMMENT '发件箱',
  `SenderID` int(11) DEFAULT NULL COMMENT '发送者ID，0表示系统',
  `ReceiverID` varchar(100) DEFAULT NULL COMMENT '接收者ID,0 表示为所有人',
  `CopyerID` varchar(100) DEFAULT NULL COMMENT '抄送ID,0 表示为所有人',
  `SecreterID` varchar(100) DEFAULT NULL COMMENT '密送ID,0 表示为所有人',
  `MailID` int(11) DEFAULT NULL,
  `CreateTime` datetime DEFAULT NULL COMMENT '创建时间',
  `UpdateTime` datetime DEFAULT NULL COMMENT '修改时间',
  `IsSend` tinyint(1) DEFAULT '0' COMMENT '是否发送',
  `SendTime` datetime DEFAULT NULL COMMENT '发送时间',
  `SendType ` tinyint(4) DEFAULT NULL COMMENT '发送类型；0：普通1：急件',
  `IsDel` tinyint(4) DEFAULT '0' COMMENT '发送者是否删除(0未删除  1标记删除  2彻底删除)',
  `DeleteTime` datetime DEFAULT NULL COMMENT '发送者删除时间',
  `IsDraft` tinyint(1) DEFAULT '0' COMMENT '是否草稿',
  `IsTag` tinyint(1) DEFAULT '0' COMMENT '是否被标记',
  `OrderNum` int(11) DEFAULT '0' COMMENT '序号',
  `Status` tinyint(4) DEFAULT '0' COMMENT '0:未读1：已读2：回复3：转发4：全部转发 ',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='发件箱';

-- ----------------------------
-- Records of mailoutbox
-- ----------------------------
INSERT INTO `mailoutbox` VALUES ('1', '1', '2,4', null, null, '1', '2016-04-18 23:43:18', '2016-04-18 23:43:20', '1', '2016-04-18 23:43:28', '1', '0', null, '0', '0', '0', '0');
INSERT INTO `mailoutbox` VALUES ('2', '4', '1', '2', null, '5', null, null, '0', null, null, '0', null, '1', '0', '0', '0');
INSERT INTO `mailoutbox` VALUES ('3', '4', '5', '6', null, '6', null, null, '0', null, null, '0', null, '0', '0', '0', '0');

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户表',
  `Name` varchar(60) DEFAULT NULL COMMENT '用户名',
  `NickName` varchar(60) DEFAULT NULL COMMENT '用户名',
  `Gender` tinyint(1) DEFAULT '0' COMMENT '性别（1男，0女）',
  `Birthday` datetime DEFAULT NULL COMMENT '生日',
  `HeadPic` varchar(100) DEFAULT NULL COMMENT '头像',
  `SpacePic` varchar(100) DEFAULT NULL COMMENT '空间头图',
  `Passwd` varchar(64) DEFAULT NULL COMMENT '密码',
  `Mobile` varchar(20) DEFAULT NULL COMMENT '手机号',
  `Email` varchar(100) DEFAULT NULL COMMENT '电子邮件',
  `QQ` varchar(18) DEFAULT NULL,
  `CreateTime` datetime DEFAULT NULL COMMENT '注册时间',
  `Address` varchar(100) DEFAULT NULL COMMENT '地址',
  `PostCode` varchar(6) DEFAULT NULL COMMENT '邮编',
  `Level` tinyint(4) DEFAULT '0' COMMENT '等级',
  `LastLoginTime` datetime DEFAULT NULL COMMENT '最后登录时间',
  `IsLock` tinyint(1) DEFAULT '0' COMMENT '用户是否锁定，锁定后就不能登录,1是0否',
  `IsLogin` tinyint(1) DEFAULT '0' COMMENT '是否登录，1 login, 0 logout',
  `LockTime` datetime DEFAULT NULL COMMENT '账户锁住时间',
  `EncryptedID` varchar(100) DEFAULT NULL COMMENT '加密的用户ID',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`),
  KEY `mobile` (`Mobile`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES ('1', 'admin1', null, '0', null, null, null, '123456', '18779885539', 'Jade@jxau.com', null, null, null, null, '0', null, '0', '0', null, null);
INSERT INTO `member` VALUES ('2', 'admin2', null, '0', null, null, null, '123', null, null, null, null, null, null, '0', null, '0', '0', null, null);
INSERT INTO `member` VALUES ('3', 'admin3', null, '0', null, null, null, '123', null, null, null, null, null, null, '0', null, '0', '0', null, null);
INSERT INTO `member` VALUES ('4', 'admin', null, '0', null, null, null, '111', '18779885546', 'aaa@jxau.com', '1111111111', null, 'beijing', null, '0', null, '0', '1', null, null);
INSERT INTO `member` VALUES ('5', 'abc', null, '0', null, null, null, '111', null, null, null, null, null, null, '0', null, '0', '1', null, null);
INSERT INTO `member` VALUES ('6', 'abc1', null, '0', null, null, null, '123', null, null, null, null, null, null, '0', null, '0', '1', null, null);
INSERT INTO `member` VALUES ('7', 'abc2', null, '0', null, null, null, '123', null, null, null, null, null, null, '0', null, '0', '1', null, null);

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户消息表',
  `SenderID` int(11) DEFAULT NULL COMMENT '发送者ID，0表示系统',
  `ReceiverID` int(11) DEFAULT NULL COMMENT '接收者ID,0 表示为所有人',
  `CopyerID` varchar(500) DEFAULT NULL COMMENT '抄送ID,0 表示为所有人',
  `SecreterID` varchar(500) DEFAULT NULL COMMENT '密送ID,0 表示为所有人',
  `Title` varchar(50) DEFAULT NULL COMMENT '主题',
  `Content` varchar(1000) DEFAULT NULL COMMENT '内容',
  `Icon` varchar(100) DEFAULT NULL COMMENT '图标',
  `Url` varchar(255) DEFAULT NULL COMMENT '链接',
  `CreateTime` datetime DEFAULT NULL COMMENT '创建时间',
  `UpdateTime` datetime DEFAULT NULL COMMENT '修改时间',
  `IsSend` tinyint(1) DEFAULT '0' COMMENT '是否发送',
  `SendTime` datetime DEFAULT NULL COMMENT '发送时间',
  `SendType` int(4) DEFAULT NULL COMMENT '发送类型；0：普通1：急件',
  `IsRead` tinyint(1) DEFAULT '0' COMMENT '接收者是否已阅',
  `ReadTime` datetime DEFAULT NULL COMMENT '阅读时间',
  `IsReceiverDelete` int(1) DEFAULT '0' COMMENT '接收者是否删除(0未删除  1标记删除  2彻底删除)',
  `ReceiverDeleteTime` datetime DEFAULT NULL COMMENT '接收者删除时间',
  `IsSenderDelete` int(1) DEFAULT '0' COMMENT '发送者是否删除(0未删除  1标记删除  2彻底删除)',
  `SenderDeleteTime` datetime DEFAULT NULL COMMENT '发送者删除时间',
  `IsDraft` tinyint(1) DEFAULT '0' COMMENT '是否草稿',
  `IsTag` tinyint(1) DEFAULT '0' COMMENT '是否被标记',
  `IsReply` tinyint(1) DEFAULT '0' COMMENT '是否回复',
  `ReplyID` int(11) DEFAULT NULL COMMENT '回复邮件ID',
  `OrderNum` int(11) DEFAULT '0' COMMENT '序号',
  `Status` int(4) DEFAULT '0' COMMENT '0:未读1：已读2：回复3：转发4：全部转发 ',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户消息表';

-- ----------------------------
-- Records of message
-- ----------------------------

-- ----------------------------
-- Table structure for right
-- ----------------------------
DROP TABLE IF EXISTS `right`;
CREATE TABLE `right` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单导航',
  `RightCode` char(4) DEFAULT NULL,
  `RightAction` varchar(50) DEFAULT NULL COMMENT '定位到Action',
  `RightController` varchar(50) DEFAULT NULL COMMENT '定位到Conroller',
  `RightName` varchar(45) DEFAULT NULL,
  `RightType` int(11) DEFAULT NULL COMMENT '权限类型0=一级菜单（没入口）   1=有入口的（一级或二级菜单） 2=按钮',
  `ParentID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单导航';

-- ----------------------------
-- Records of right
-- ----------------------------

-- ----------------------------
-- Table structure for template
-- ----------------------------
DROP TABLE IF EXISTS `template`;
CREATE TABLE `template` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '邮件模板表',
  `TemplateTypeID` int(11) DEFAULT NULL COMMENT '短信类型ID',
  `Title` varchar(255) DEFAULT NULL COMMENT '短信标题',
  `Content` varchar(500) DEFAULT NULL,
  `SideNote` varchar(255) DEFAULT NULL COMMENT '备注',
  `CreateTime` datetime DEFAULT NULL,
  `UpdateTime` datetime DEFAULT NULL,
  `OrderNum` int(11) DEFAULT NULL,
  `IsDelete` tinyint(1) DEFAULT NULL,
  `Status` tinyint(4) DEFAULT NULL COMMENT '0=待受理 （1、2=审核中）1=编审审核通过 2=技术支持提交到第三方 3=审核未通过   4=审核通过',
  `Description` varchar(255) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='邮件模板表';

-- ----------------------------
-- Records of template
-- ----------------------------

-- ----------------------------
-- Table structure for templatetype
-- ----------------------------
DROP TABLE IF EXISTS `templatetype`;
CREATE TABLE `templatetype` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '模板类型表',
  `TypeName` varchar(100) DEFAULT NULL,
  `IsDelete` tinyint(1) DEFAULT '0' COMMENT '是否使用',
  `Status` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='模板类型表';

-- ----------------------------
-- Records of templatetype
-- ----------------------------
