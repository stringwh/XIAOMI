/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : yijia

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 17/06/2020 13:43:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address`  (
  `customerId` int(11) NOT NULL,
  `addressId` int(11) NOT NULL AUTO_INCREMENT,
  `addressStr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `addressPhone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`addressId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES (1, 4, '湖北省襄阳市襄城区隆中街道296号', '13378984673');
INSERT INTO `address` VALUES (2, 5, '湖北省武汉市城区', '18903894390');
INSERT INTO `address` VALUES (3, 6, '北京市朝阳区', '199767876532');
INSERT INTO `address` VALUES (3, 7, '湖北省襄阳市襄城区檀溪路', '13787896756');
INSERT INTO `address` VALUES (13, 8, '湖北省襄阳市樊城区长虹路万达广场', '19908986776');

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart`  (
  `cartId` int(11) NOT NULL AUTO_INCREMENT,
  `customerId` int(11) NOT NULL,
  `goodsId` int(11) NOT NULL,
  `goodsCount` int(11) NOT NULL,
  PRIMARY KEY (`cartId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES (3, 1, 12, 2);
INSERT INTO `cart` VALUES (6, 1, 11, 2);
INSERT INTO `cart` VALUES (7, 12, 5, 4);
INSERT INTO `cart` VALUES (8, 12, 8, 2);
INSERT INTO `cart` VALUES (9, 12, 12, 2);

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`  (
  `customerId` int(11) NOT NULL AUTO_INCREMENT,
  `customerName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `customerPWD` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `customerBirthday` datetime(0) NULL DEFAULT NULL,
  `customerPhone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `customerRegDate` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`customerId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES (1, '杨凤', '123456', '2017-09-03 21:35:00', '15334248095', '2017-09-03 21:35:00');
INSERT INTO `customer` VALUES (2, '吴雅欣', '123456', '2017-09-03 21:31:00', '15334248961', '2017-09-03 21:31:00');
INSERT INTO `customer` VALUES (3, '唐丽', '123456', '2017-09-03 21:26:00', '15332489021', '2017-09-03 21:26:00');
INSERT INTO `customer` VALUES (4, '付婷', '123456', '2017-09-03 21:21:00', '15334249057', '2017-09-03 21:21:00');
INSERT INTO `customer` VALUES (5, '庹玲', '123456', '2017-09-03 20:33:00', '15334248937', '2017-09-03 20:33:00');
INSERT INTO `customer` VALUES (6, '王志豪', '123456', '2017-09-03 20:23:00', '15334247932', '2017-09-03 20:23:00');
INSERT INTO `customer` VALUES (7, '李涵', '123456', '2017-09-03 20:22:00', '13308672151', '2017-09-03 20:22:00');
INSERT INTO `customer` VALUES (8, '李涵', '123456', '2017-09-03 20:19:00', '13339967384', '2017-09-03 20:19:00');
INSERT INTO `customer` VALUES (9, '李珊珊', '123456', '2017-09-03 20:12:00', '15334247960', '2017-09-03 20:12:00');
INSERT INTO `customer` VALUES (10, '李梦娜', '123456', '2017-09-03 20:05:00', '15334249051', '2017-09-03 20:05:00');
INSERT INTO `customer` VALUES (11, '贺梦威', '123456', '2017-09-03 19:56:00', '15334248050', '2017-09-03 19:56:00');
INSERT INTO `customer` VALUES (12, '谭诗雨', '123456', '2017-09-03 19:26:00', '17343568967', '2017-09-03 19:26:00');
INSERT INTO `customer` VALUES (13, '胡海军', '123456', '2017-09-03 19:22:00', '15334259070', '2017-09-03 19:22:00');
INSERT INTO `customer` VALUES (14, '张涛', '123456', '2017-09-03 19:20:00', '17343560232', '2017-09-03 19:20:00');
INSERT INTO `customer` VALUES (15, '刘镘', '123456', '2017-09-03 19:09:00', '17343569052', '2017-09-03 19:09:00');
INSERT INTO `customer` VALUES (16, '余璐', '123456', '2017-09-03 19:04:00', '17343563307', '2017-09-03 19:04:00');
INSERT INTO `customer` VALUES (17, '梁密', '123456', '2017-09-03 18:59:00', '17364205230', '2017-09-03 18:59:00');
INSERT INTO `customer` VALUES (18, '王梦晓', '123456', '2017-09-03 18:56:00', '17343568975', '2017-09-03 18:56:00');
INSERT INTO `customer` VALUES (19, '谢承均', '123456', '2017-09-03 18:55:00', '17343569023', '2017-09-03 18:55:00');
INSERT INTO `customer` VALUES (20, '张庆宇', '123456', '2017-09-03 18:51:00', '17343569072', '2017-09-03 18:51:00');
INSERT INTO `customer` VALUES (21, '王旭', '123456', '2017-09-03 18:51:00', '17343568957', '2017-09-03 18:51:00');
INSERT INTO `customer` VALUES (22, '卢月萍', '123456', '2017-09-03 18:50:00', '17343569065', '2017-09-03 18:50:00');
INSERT INTO `customer` VALUES (23, '李淑娟', '123456', '2017-09-03 18:32:00', '17343569061', '2017-09-03 18:32:00');
INSERT INTO `customer` VALUES (24, '陈韦', '123456', '2017-09-03 18:26:00', '17343569073', '2017-09-03 18:26:00');
INSERT INTO `customer` VALUES (25, '高博文', '123456', '2017-09-03 18:22:00', '17343568937', '2017-09-03 18:22:00');
INSERT INTO `customer` VALUES (26, '李婷婷', '123456', '2017-09-03 18:18:00', '17343568932', '2017-09-03 18:18:00');
INSERT INTO `customer` VALUES (27, '罗燕', '123456', '2017-09-03 18:14:00', '17343568930', '2017-09-03 18:14:00');
INSERT INTO `customer` VALUES (28, '章耀予', '123456', '2017-09-03 18:09:00', '18154458947', '2017-09-03 18:09:00');
INSERT INTO `customer` VALUES (29, '王慧敏', '123456', '2017-09-03 17:38:00', '17343563305', '2017-09-03 17:38:00');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `goodsId` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '商品的ID，主健，自动加1',
  `goodsNum` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品的编号\r\n',
  `goodsName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名称',
  `goodsTypeId` int(11) NOT NULL COMMENT '商品种类的ID，关联到GoodsType表中的goodsTypeID\r\n',
  `goodsDescript` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goodsPrice` float(10, 2) NOT NULL COMMENT '商品价格',
  `goodsInventory` int(255) NOT NULL COMMENT '商品库存',
  `goodsPic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `goodsManager` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `goodsStatus` int(11) NOT NULL,
  PRIMARY KEY (`goodsId`) USING BTREE,
  INDEX `goods`(`goodsTypeId`) USING BTREE,
  CONSTRAINT `goods` FOREIGN KEY (`goodsTypeId`) REFERENCES `goodstype` (`goodstypeid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (4, 'XM141001', '小米CC9', 1, '前置3200万自拍 / 索尼4800万超广角三摄 / 多色炫彩轻薄机身 / 6.39英寸三星 AMOLED水滴屏', 1999.00, 5000, 'xiaomiCC9.jpg', 'admin', 0);
INSERT INTO `goods` VALUES (5, 'XM141002', '小米CC美图定制版', 1, '100%美图相机 /美图经典人像 / AI弱光人像 /6.39英寸三星 AMOLED水滴屏 / 骁龙710处理器 ', 2599.00, 2000, 'xiaomiCC9meitu.jpg', 'admin', 2);
INSERT INTO `goods` VALUES (6, 'XM141003', '小米9', 1, '全曲面轻薄设计，全息幻彩玻璃机身 / 骁龙855旗舰处理器 / 20W无线闪充，标配27W有线快充 ', 2999.00, 3800, 'xiaomi9.jpg', 'admin', 0);
INSERT INTO `goods` VALUES (7, 'XM141004', '小米9 SE', 1, '骁龙712全球首发 / 全息幻彩机身 / 三星AMOLED屏幕 / 5.97”水滴屏 / 第五代屏幕指纹识别 / 多功能NFC', 1999.00, 4820, 'xiaomi9SE.jpg', 'admin', 0);
INSERT INTO `goods` VALUES (8, 'XM141005', '小米MIX 3', 1, '四曲面陶瓷机身，超艺术的商务旗舰 / 骁龙845处理器 / 包装盒内附赠10W无线充电器', 2999.00, 1580, 'xiaomiMIX3.jpg', 'admin', 2);
INSERT INTO `goods` VALUES (9, 'XM141006', '小米8 青春版', 1, '索尼2400万旗舰自拍 / 潮流镜面渐变色 / 手持超级夜景 / Dual PD 双核对焦 / 7.5mm超薄机身', 1099.00, 2130, 'xiaomi8qc.jpg', 'admin', 2);
INSERT INTO `goods` VALUES (10, 'XM141007', '小米MIX 2S', 1, '陶瓷机身 手机中的艺术品 / 搭载高通骁龙845 年度旗舰处理器 / AI超感光双摄，DxO百分相机 ', 1999.00, 3138, 'xiaomiMIX2S.jpg', 'admin', 2);
INSERT INTO `goods` VALUES (11, 'XM141008', '小米MAX 3', 1, '5500mAh 电量，支持给多个设备充电 / AI 双摄超大像素，双核对焦 / 单手可握纤薄全金属机身', 1299.00, 5537, 'xiaomiMax3.jpg', 'admin', 0);
INSERT INTO `goods` VALUES (12, 'XM141009', 'Redmi K20 Pro', 1, '骁龙855旗舰处理器 / 索尼4800万超广角三摄 / 前置2000万升降式相机 / 6.39\"AMOLED全面屏', 2999.00, 2560, 'RedmiK20Pro.jpg', 'admin', 0);
INSERT INTO `goods` VALUES (13, 'XM141010', 'Redmi K20', 1, '索尼4800万超广角三摄 / 骁龙730处理器 / 前置2000万升降式相机 / 6.39\"AMOLED全面屏 ', 2099.00, 1690, 'RedmiK20.jpg', 'admin', 0);
INSERT INTO `goods` VALUES (14, 'XM141011', 'Redmi 7', 1, ' 6.26\"水滴全面屏，德国莱茵 TÜV 认证护眼屏 / 18个月超长质保，康宁第五代大猩猩玻璃盖板 ', 799.00, 566, 'Redmi7.jpg', 'admin', 1);
INSERT INTO `goods` VALUES (15, 'XM141012', 'Redmi Note 7 Pro', 1, ' 索尼4800万超清拍照 / 6GB+128GB大存储 / 骁龙675处理器 / 4000mAh大电量 / 6.3\"水滴屏', 1499.00, 3120, 'Redmi Note 7 Pro.jpg', 'admin', 2);
INSERT INTO `goods` VALUES (16, 'XM256001', '小米笔记本Air 13.3\" 2019款', 2, '轻薄全金属机身 / MX250独立显卡 / 9.5小时超长续航 / FHD全高清屏幕 / 指纹解锁 / 兼顾办公娱乐', 5799.00, 1024, 'Air  2019.jpg', 'admin', 0);
INSERT INTO `goods` VALUES (17, 'XM256002', '小米笔记本Air 12.5\" m3 2019款', 2, '全高清屏幕 / 长续航全金属 / 超窄边框 / 像杂志一样随身携带 / 哈曼高品质扬声器 / 升级至第八代Intel ', 3599.00, 2231, 'Air125.jpg', 'admin', 0);
INSERT INTO `goods` VALUES (18, 'XM256003', '小米笔记本Pro 15.6\" 2019款', 2, 'NVIDIA MX250 2G独显 / 第八代Intel处理器 / PCIe 高速固态硬盘 / 72%NTSC高色域全高清屏 ', 5599.00, 763, '小米笔记本Pro 15.6.jpg', 'admin', 0);
INSERT INTO `goods` VALUES (19, 'XM256004', '小米笔记本Pro 15.6\" GTX版', 2, '全新第八代英特尔酷睿处理器 ／ 升级金属双风扇 ／ 带宽提升80% ／ 15.6\"全高清大屏超窄边大视野', 6299.00, 3342, '小米笔记本ProGTX.jpg', 'admin', 0);
INSERT INTO `goods` VALUES (20, 'XM256005', '小米游戏本15.6\"', 2, '第八代酷睿处理器 ／ 72%NTSC高色域窄边框全高清屏 ／ 256G PCIe高速固态 ／ 双烤不限频不降频', 7999.00, 2453, '小米游戏本.jpg', 'admin', 0);
INSERT INTO `goods` VALUES (21, 'XM360001', '小米USB Type C快充数据线', 3, '三色可选 / 正反插拔 / 1200mm线长 / 支持5V 2.1A快速充电', 16.90, 7633, '小米Type C快充数据线.jpg', 'admin', 0);
INSERT INTO `goods` VALUES (22, 'XM360002', '米家手持手机云台（自拍器）', 3, '三轴增稳 ／ 延时摄影 ／ 智能跟随 ／ 持久续航', 599.00, 3201, 'zipaiqi.png', 'admin', 0);
INSERT INTO `goods` VALUES (23, 'XM360003', '小米9 SE 街头风保护壳', 3, '个性时尚 / 细节出众 / 纤薄轻巧 / 多彩时尚', 49.00, 2015, 'xiaomi9SEK.jpg', 'admin', 0);
INSERT INTO `goods` VALUES (24, 'XM360004', '小米指环支架', 3, '适用于 所有小米手机', 19.00, 1111, 'xiaomizhijia.jpg', 'admin', 0);
INSERT INTO `goods` VALUES (25, 'XM360005', '小米K歌蓝牙耳机', 3, '一键美音 / 一键变声 / 原唱消音 / 耳返/蓝牙', 249.00, 963, 'xiaomilanyaerji.jpg', 'admin', 0);
INSERT INTO `goods` VALUES (26, 'XM449001', '小米无线充电宝 10000mAh', 4, '支持 10W 无线快充 / 3 台设备可同时充电 / 可上飞机随行 / Qi 无线标准', 149.00, 563, 'xiaomidainyuan3.jpg', 'admin', 0);
INSERT INTO `goods` VALUES (27, 'XM449002', '小米移动电源3 20000mAh 高配版', 4, 'USB-C 45W 双向快充 / 三口输出 / 大容量 / 支持笔记本电脑充电 / 高品质锂聚合物电芯', 199.00, 5632, '小米移动电源3.jpg', 'admin', 0);
INSERT INTO `goods` VALUES (28, 'XM449003', '小米充电宝 BROWN & FRIENDS 限量版', 4, 'BROWN熊的定制IP / 支持双向快充双口输出 / 兼容市场上的主流手机与平板电脑 / 支持小电流充电功能', 99.00, 756, 'xiaomidianyuan4.jpg', 'admin', 0);
INSERT INTO `goods` VALUES (29, 'XM520001', '九号平衡车燃动版', 5, '铝合金停车支架 / 可折叠拉杆 / 越野风格外观 / 22km 长续航', 2299.00, 1533, 'pinghengche1.jpg', 'admin', 0);
INSERT INTO `goods` VALUES (30, 'XM520002', '米家九号平衡轮', 5, '双脚分离式设计 / 三步轻松上手 / 无需穿脱，踩上就走 / 便携提手，拎着方便', 999.00, 1025, 'pinghengche2.jpg', 'admin', 0);
INSERT INTO `goods` VALUES (31, 'XM520003', '小米米家电动滑板车Pro', 5, '多功能控制面板 / 45 公里续航 / 6倍步行速度', 2799.00, 2153, 'pinghengche3.jpg', 'admin', 0);
INSERT INTO `goods` VALUES (32, 'XM667001', '小米电视4A 65英寸', 6, '4K超高清屏 / 四核64位高性能处理器，支持HDR10 / 2GB+8GB大存储 / 人工智能语音 / 支持壁挂', 2999.00, 2635, 'dianshiji1.jpg', 'admin', 0);
INSERT INTO `goods` VALUES (33, 'XM667002', '小米全面屏电视E65A', 6, '全面屏设计 / 4K超高清 HDR / 纤薄机身 / 2GB+8GB大内存 / 64位四核处理器 / 内置小爱同学', 3199.00, 1523, 'dianshiji2.jpg', 'admin', 0);
INSERT INTO `goods` VALUES (34, 'XM667003', '米家激光投影电视 4K', 6, '4K画面 / 150英寸超巨幕 / 超短焦 / ALPD 3.0 / 画面真实鲜明 / 高保真音响 / 智能散热 / MIUI TV', 12999.00, 563, 'dianshiji3.jpg', 'admin', 0);

-- ----------------------------
-- Table structure for goodstype
-- ----------------------------
DROP TABLE IF EXISTS `goodstype`;
CREATE TABLE `goodstype`  (
  `goodsTypeId` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品种类的ID，主键，自动加1\r\n',
  `goodsTypeName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品种类的名称\r\n',
  PRIMARY KEY (`goodsTypeId`) USING BTREE,
  INDEX `goodsTypeId`(`goodsTypeId`) USING BTREE,
  INDEX `goodsTypeId_2`(`goodsTypeId`) USING BTREE,
  INDEX `goodsTypeId_3`(`goodsTypeId`) USING BTREE,
  INDEX `goodsTypeId_4`(`goodsTypeId`) USING BTREE,
  INDEX `goodsTypeId_5`(`goodsTypeId`) USING BTREE,
  INDEX `goodsTypeId_6`(`goodsTypeId`) USING BTREE,
  INDEX `goodsTypeId_7`(`goodsTypeId`) USING BTREE,
  INDEX `goodsTypeId_8`(`goodsTypeId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goodstype
-- ----------------------------
INSERT INTO `goodstype` VALUES (1, '手机');
INSERT INTO `goodstype` VALUES (2, '电脑');
INSERT INTO `goodstype` VALUES (3, '配件');
INSERT INTO `goodstype` VALUES (4, '移动电源');
INSERT INTO `goodstype` VALUES (5, '平衡车');
INSERT INTO `goodstype` VALUES (6, '电视机');

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager`  (
  `managerId` int(11) NOT NULL AUTO_INCREMENT,
  `managerNum` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `managerName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `managerPWD` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `managerStatus` int(255) NOT NULL,
  PRIMARY KEY (`managerId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES (1, '000000', 'admin', '123456', 0);

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `orderNum` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `customerName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `totalMoney` float(255, 2) NULL DEFAULT NULL,
  `orderDate` datetime(0) NOT NULL,
  `orderState` int(255) NOT NULL,
  PRIMARY KEY (`orderNum`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('2019070612345', '唐丽', 4998.00, '2019-07-06 11:07:08', 1);
INSERT INTO `order` VALUES ('2019070857913', '杨凤', 200.00, '2019-07-08 10:17:49', 1);
INSERT INTO `order` VALUES ('2019070862151', '唐丽', 1999.00, '2019-07-08 10:02:24', 0);
INSERT INTO `order` VALUES ('2019070888355', '唐丽', 1999.00, '2019-07-08 10:04:14', 0);
INSERT INTO `order` VALUES ('2019070889869', '唐丽', 191.00, '2019-07-08 10:05:41', 0);

-- ----------------------------
-- Table structure for orderdetail
-- ----------------------------
DROP TABLE IF EXISTS `orderdetail`;
CREATE TABLE `orderdetail`  (
  `orderNum` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `goodsId` int(11) NOT NULL,
  `goodsCount` int(11) NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orderdetail
-- ----------------------------
INSERT INTO `orderdetail` VALUES ('2019070612345', 4, 1);
INSERT INTO `orderdetail` VALUES ('2019070612345', 6, 1);

SET FOREIGN_KEY_CHECKS = 1;
