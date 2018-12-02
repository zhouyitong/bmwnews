-- MySQL dump 10.16  Distrib 10.1.37-MariaDB, for Linux (x86_64)
--
-- Host: 39.104.164.225    Database: news
-- ------------------------------------------------------
-- Server version	5.7.24-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `n_activity`
--

DROP TABLE IF EXISTS `n_activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `n_activity` (
  `activity_id` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '活动ID',
  `activity_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '活动名称',
  `activity_start_time` datetime DEFAULT NULL COMMENT '活动开始时间',
  `activity_end_time` datetime DEFAULT NULL COMMENT '活动结束时间',
  `activity_status` char(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '活动状态0未开始1正在进行2已经结束',
  `activity_brochure_image` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '活动封面图片',
  `activity_create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '活动创建时间',
  `activity_create_user` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '活动创建人',
  `activity_update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '活动更新时间',
  `activity_update_user` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '活动更新人',
  `activity_remark` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '活动备注',
  `activity_is_delete` char(1) COLLATE utf8mb4_unicode_ci DEFAULT '0' COMMENT '是否删除0未删除1删除',
  `activity_version` bigint(20) DEFAULT '0' COMMENT '活动版本号',
  PRIMARY KEY (`activity_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='活动表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `n_activity`
--

LOCK TABLES `n_activity` WRITE;
/*!40000 ALTER TABLE `n_activity` DISABLE KEYS */;
/*!40000 ALTER TABLE `n_activity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `n_activity_group`
--

DROP TABLE IF EXISTS `n_activity_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `n_activity_group` (
  `group_id` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '活动媒体分组主键',
  `activity_id` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '活动ID',
  `group_name` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '分组名字',
  `reporter_id` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '媒体记者ID',
  `reporter_name` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '媒体记者名字',
  `media_id` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '媒体记者所属媒体ID',
  `media_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '媒体接着所属媒体名字',
  `group_create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '分组创建时间',
  `group_create_user` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '分组创建人',
  `group_update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '分组更新时间',
  `group_update_user` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '分组更新人',
  `group_is_delete` char(1) COLLATE utf8mb4_unicode_ci DEFAULT '0' COMMENT '是否删除0未删除1删除',
  `group_is_useable` char(1) COLLATE utf8mb4_unicode_ci DEFAULT '1' COMMENT '分组是否可用',
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='活动分组表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `n_activity_group`
--

LOCK TABLES `n_activity_group` WRITE;
/*!40000 ALTER TABLE `n_activity_group` DISABLE KEYS */;
/*!40000 ALTER TABLE `n_activity_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `n_activity_iamge`
--

DROP TABLE IF EXISTS `n_activity_iamge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `n_activity_iamge` (
  `image_id` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '活动图片主键',
  `activity_id` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '活动主键',
  `image_file_path` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '图片文件路径',
  `image_upload_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '图片上传时间',
  `image_upload_user` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '图片上传人',
  PRIMARY KEY (`image_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='活动图片表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `n_activity_iamge`
--

LOCK TABLES `n_activity_iamge` WRITE;
/*!40000 ALTER TABLE `n_activity_iamge` DISABLE KEYS */;
/*!40000 ALTER TABLE `n_activity_iamge` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `n_activity_invitation`
--

DROP TABLE IF EXISTS `n_activity_invitation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `n_activity_invitation` (
  `invitation_id` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '邀请函ID',
  `activity_id` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '活动ID',
  `invitation_title` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '邀请函标题',
  `invitation_content` text COLLATE utf8mb4_unicode_ci COMMENT '邀请函正文',
  `invitation_create_user` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '邀请函创建人',
  `invitation_create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '邀请函创建时间',
  `invitation_update_user` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '邀请函更新人',
  `invitation_update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '邀请函更新时间',
  `invitation_is_delete_copy1` char(1) COLLATE utf8mb4_unicode_ci DEFAULT '1' COMMENT '是否可用0不可用1可用',
  `invitation_is_delete` char(1) COLLATE utf8mb4_unicode_ci DEFAULT '0' COMMENT '是否删除0未删除1删除',
  `invitation_version` bigint(20) DEFAULT NULL COMMENT '邀请函版本号'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='活动邀请函表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `n_activity_invitation`
--

LOCK TABLES `n_activity_invitation` WRITE;
/*!40000 ALTER TABLE `n_activity_invitation` DISABLE KEYS */;
/*!40000 ALTER TABLE `n_activity_invitation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `n_activity_media`
--

DROP TABLE IF EXISTS `n_activity_media`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `n_activity_media` (
  `activity_id` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '活动ID',
  `reporter_id` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '活动受邀记者ID',
  `reporter_name` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '活动受邀记者名称',
  `media_id` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '媒体ID',
  `media_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '媒体名称',
  `reporter_is_invitation` char(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '是否发送邀请0未发送1已发送',
  `reporter_invitation_time` datetime DEFAULT NULL COMMENT '发送邀请时间',
  `reporter_response_time` datetime DEFAULT NULL COMMENT '媒体记者回应时间',
  `reporter_response_result` char(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '媒体记者回应结果0本人参加1他人参加2不参加',
  `reporter_response_remark` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '媒体记者回应备注',
  `reporter_response_update_time` datetime DEFAULT NULL COMMENT '媒体记者回应结果更新时间',
  `reporter_response_update_user` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '媒体记者回应结果更新人',
  `reporter_is_sign` char(1) COLLATE utf8mb4_unicode_ci DEFAULT '0' COMMENT '媒体记者签到标识0未签到1已签到',
  `reporter_sign_time` datetime DEFAULT NULL COMMENT '媒体记者签到时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='活动邀请媒体表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `n_activity_media`
--

LOCK TABLES `n_activity_media` WRITE;
/*!40000 ALTER TABLE `n_activity_media` DISABLE KEYS */;
/*!40000 ALTER TABLE `n_activity_media` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `n_activity_news`
--

DROP TABLE IF EXISTS `n_activity_news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `n_activity_news` (
  `news_id` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '新闻稿ID',
  `activity_id` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '活动ID',
  `news_title` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '新闻稿标题',
  `news_content` text COLLATE utf8mb4_unicode_ci COMMENT '新闻稿内容',
  `news_create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '新闻稿创建时间',
  `news_create_user` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '新闻稿创建用户',
  `news_update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '新闻稿更新时间',
  `news_update_user` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '新闻稿更新用户',
  `news_is_audit` char(1) COLLATE utf8mb4_unicode_ci DEFAULT '0' COMMENT '新闻稿是否审核0未审核1一审2二审',
  `news_audit_user_one` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '新闻稿一审用户',
  `news_audit_time_one` datetime DEFAULT NULL COMMENT '新闻稿一审时间',
  `news_audit_user_two` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '新闻稿二审用户',
  `news_audit_time_two` datetime DEFAULT NULL COMMENT '新闻稿二审时间',
  `news_is_crontab` char(1) COLLATE utf8mb4_unicode_ci DEFAULT '0' COMMENT '是否定时发送0不定时1定时',
  `news_cron_time` datetime DEFAULT NULL COMMENT '定时发送时间',
  `news_is_delete` char(1) COLLATE utf8mb4_unicode_ci DEFAULT '0' COMMENT '是否删除0未删除1删除',
  `news_like_num` bigint(20) DEFAULT '0' COMMENT '新闻稿点赞数量',
  `news_share_num` bigint(20) DEFAULT '0' COMMENT '新闻稿分享数量',
  `news_download_num` bigint(20) DEFAULT '0' COMMENT '新闻稿下载数量',
  `news_version` bigint(20) DEFAULT '0' COMMENT '新闻稿版本',
  PRIMARY KEY (`news_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='活动新闻稿表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `n_activity_news`
--

LOCK TABLES `n_activity_news` WRITE;
/*!40000 ALTER TABLE `n_activity_news` DISABLE KEYS */;
/*!40000 ALTER TABLE `n_activity_news` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `n_activity_notify`
--

DROP TABLE IF EXISTS `n_activity_notify`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `n_activity_notify` (
  `notify_id` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '活动通知ID',
  `acvitity_id` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '活动ID',
  `notify_content` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '通知内容',
  `notify_send_object` char(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '通知发送对象0所有参加活动的记者1某个记者分组2单个记者',
  `notify_is_crontab` char(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '是否定时发送0不定时1定时',
  `notify_send_time` datetime DEFAULT NULL COMMENT '发送时间',
  `notify_create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '活动通知创建时间',
  `notify_create_user` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '活动通知创建人',
  `notify_update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '活动通知更新时间',
  `notify_update_user` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '活动通知更新人',
  `notify_version` bigint(20) DEFAULT NULL COMMENT '活动通知版本号',
  PRIMARY KEY (`notify_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='活动通知表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `n_activity_notify`
--

LOCK TABLES `n_activity_notify` WRITE;
/*!40000 ALTER TABLE `n_activity_notify` DISABLE KEYS */;
/*!40000 ALTER TABLE `n_activity_notify` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `n_information`
--

DROP TABLE IF EXISTS `n_information`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `n_information` (
  `info_id` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '资讯ID',
  `info_title` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '资讯标题',
  `info_show_style` char(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '资讯展示风格0大图1右侧小图2图集',
  `info_index_image_path` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '资讯列表图片路径',
  `info_content` text COLLATE utf8mb4_unicode_ci COMMENT '资讯正文',
  `info_is_top` char(1) COLLATE utf8mb4_unicode_ci DEFAULT '0' COMMENT '是否置顶，0不置顶1置顶',
  `info_publisher` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '资讯发布者',
  `info_own_channel` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '所属频道',
  `info_share_num` bigint(20) DEFAULT NULL COMMENT '资讯分享数量',
  `info_like_num` bigint(20) DEFAULT NULL COMMENT '资讯点赞数量',
  `info_download_num` bigint(20) DEFAULT NULL COMMENT '资讯下载数量',
  `info_status` char(1) COLLATE utf8mb4_unicode_ci DEFAULT '0' COMMENT '0未审核1一审通过2二审通过',
  `info_audit_time_one` datetime DEFAULT NULL COMMENT '资讯一审通过时间',
  `info_audit_user_one` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '资讯一审审核人',
  `info_audit_time_two` datetime DEFAULT NULL COMMENT '资讯二审通过时间',
  `info_audit_user_two` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '资讯二审审核人',
  `info_create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '资讯创建时间',
  `info_create_user` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '资讯创建人',
  `info_update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '资讯更新时间',
  `info_update_user` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '资讯更新人',
  `info_version` bigint(20) DEFAULT NULL COMMENT '资讯版本号',
  `info_is_delete` char(1) COLLATE utf8mb4_unicode_ci DEFAULT '0' COMMENT '是否删除0未删除1删除',
  PRIMARY KEY (`info_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='资讯表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `n_information`
--

LOCK TABLES `n_information` WRITE;
/*!40000 ALTER TABLE `n_information` DISABLE KEYS */;
/*!40000 ALTER TABLE `n_information` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `n_information_image`
--

DROP TABLE IF EXISTS `n_information_image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `n_information_image` (
  `image_id` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '图片ID',
  `publisher_id` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '资讯发布者主键',
  `image_file_path` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '图片文件路径',
  `image_upload_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '资讯正文图片上传时间',
  `image_upload_user` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '资讯正文图片上传人',
  PRIMARY KEY (`image_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='资讯图片表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `n_information_image`
--

LOCK TABLES `n_information_image` WRITE;
/*!40000 ALTER TABLE `n_information_image` DISABLE KEYS */;
/*!40000 ALTER TABLE `n_information_image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `n_information_publisher`
--

DROP TABLE IF EXISTS `n_information_publisher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `n_information_publisher` (
  `publisher_id` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '资讯发布者主键',
  `publisher_name` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '发布者名字',
  `publisher_create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '发布者创建时间',
  `publisher_create_user` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '发布者创建人',
  `publisher_photo_image` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '发布者头像',
  `publish_update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '发布者更新时间',
  `publisher_update_user` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '发布者更新人',
  `publisher_is_delete` char(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '是否删除0未删除1删除',
  PRIMARY KEY (`publisher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='资讯发布者表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `n_information_publisher`
--

LOCK TABLES `n_information_publisher` WRITE;
/*!40000 ALTER TABLE `n_information_publisher` DISABLE KEYS */;
/*!40000 ALTER TABLE `n_information_publisher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `n_media`
--

DROP TABLE IF EXISTS `n_media`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `n_media` (
  `media_id` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '媒体主键',
  `media_level` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '媒体级别',
  `media_region` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '媒体区域',
  `media_city` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '媒体所属城市',
  `media_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '媒体名字',
  `media_type` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '媒体类型',
  `media_category` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '媒体类别',
  `media_group` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '所属媒体集团',
  `media_page` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '媒体版面',
  `media_channel` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '媒体频道',
  `media_is_important` char(1) COLLATE utf8mb4_unicode_ci DEFAULT '0' COMMENT '是否为重要媒体0不重要1重要',
  `media_is_dispatch` char(1) COLLATE utf8mb4_unicode_ci DEFAULT '0' COMMENT '是否允许发稿0不允许1允许',
  `media_logo_image` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '媒体标志图片',
  `media_contact_address` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '媒体联系地址',
  `media_contact_tel` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '媒体联系电话',
  `media_create_user` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '记录创建人',
  `media_create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建时间',
  `media_update_user` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '记录更新人',
  `media_update_time` datetime DEFAULT NULL COMMENT '记录更新时间',
  `media_is_delete` char(1) COLLATE utf8mb4_unicode_ci DEFAULT '0' COMMENT '是否删除0未删除1删除',
  PRIMARY KEY (`media_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='媒体表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `n_media`
--

LOCK TABLES `n_media` WRITE;
/*!40000 ALTER TABLE `n_media` DISABLE KEYS */;
/*!40000 ALTER TABLE `n_media` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `n_news_bulletin`
--

DROP TABLE IF EXISTS `n_news_bulletin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `n_news_bulletin` (
  `bulletin_id` varbinary(40) DEFAULT NULL COMMENT '简报主键',
  `bulletin_media_type` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '简报媒体类型',
  `bulletin_media_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '简报媒体名字',
  `bulletin_reporter_id` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '简报作者',
  `bulletin_reporter_name` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '简报作者名字',
  `bulletin_publish_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '简报发布时间',
  `bulletin_word_num` int(11) DEFAULT NULL COMMENT '简报字数',
  `bulletin_page` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '简报版面',
  `bulletin_level` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '简报级别',
  `bulletin_title` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '简报标题',
  `bulletin_url` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '简报url',
  `bulletin_tone` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '简报标签',
  `bulletin_share_num` bigint(20) DEFAULT NULL COMMENT '简报分享数量',
  `bulletin_create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '简报创建时间',
  `bulletin_create_user` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '简报创建人',
  `bulletin_update_time` datetime DEFAULT NULL COMMENT '简报更新时间',
  `bulletin_update_user` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '简报更新人',
  `bulletin_is_delete` char(1) COLLATE utf8mb4_unicode_ci DEFAULT '0' COMMENT '是否删除0未删除1删除',
  `bulletin_version` bigint(20) DEFAULT NULL COMMENT '简报版本号'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='新闻简报表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `n_news_bulletin`
--

LOCK TABLES `n_news_bulletin` WRITE;
/*!40000 ALTER TABLE `n_news_bulletin` DISABLE KEYS */;
/*!40000 ALTER TABLE `n_news_bulletin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `n_register_reporter`
--

DROP TABLE IF EXISTS `n_register_reporter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `n_register_reporter` (
  `reporter_id` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '记者主键',
  `reporter_name` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '记者名字',
  `reporter_own_media` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '所属媒体',
  `reporter_own_media_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '所属媒体名字',
  `reporter_is_access` char(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '是否通过认证0未认证1认证',
  `reporter_access_time` datetime DEFAULT NULL COMMENT '通过认证时间',
  `reporter_registry_time` datetime DEFAULT NULL COMMENT '注册时间',
  `reporter_last_login_time` datetime DEFAULT NULL COMMENT '最后登陆时间',
  `reporter_birthday` date DEFAULT NULL COMMENT '记者出生日期',
  `reporter_clothes_size` char(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '记者衣服尺码0XS1S2M3L4XL5XXL6XXXL',
  `reporter_driving_licence` int(11) DEFAULT NULL COMMENT '记者驾龄',
  `reporter_level` char(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '记者级别1I2II3III4IV5V',
  `reporter_audit_time` datetime DEFAULT NULL COMMENT '审核时间',
  `reporter_audit_user_id` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '审核结果0未审核1审核通过2审核不通过',
  `reporter_audit_user_name` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '审核结果0未审核1审核通过2审核不通过',
  `reporter_audit_result` char(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '审核结果0未审核1审核通过2审核不通过',
  `reporter_phone_num` varchar(11) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号码',
  `reporter_title` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '记者职位',
  `reporter_email` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '记者邮箱',
  `reporter_zip_code` varchar(6) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '邮政编码',
  `reporter_gender` char(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '记者性别0女1男',
  `reporter_work_tel` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '工作座机',
  `reporter_work_cert` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '工作证明',
  `reporter_identity_num` varchar(18) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '身份证号码',
  `reporter_passport_num` varchar(11) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '媒体记者护照号码',
  `reporter_home_address` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '家庭住址',
  `reporter_is_have_child` char(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '是否有孩子0无1有',
  `reporter_child_gender` char(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '孩子性别0女孩1男孩',
  `reporter_child_birthday` date DEFAULT NULL COMMENT '孩子生日',
  `reporter_second_child_gender` char(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '二孩性别0女孩1男孩',
  `reporter_second_child_birthday` date DEFAULT NULL COMMENT '二孩生日',
  `reporter_other_info` varchar(400) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '记者其他信息',
  `reporter_phone_flag` char(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '记者手机号是否一致0不一致1一致',
  PRIMARY KEY (`reporter_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='媒体记者注册表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `n_register_reporter`
--

LOCK TABLES `n_register_reporter` WRITE;
/*!40000 ALTER TABLE `n_register_reporter` DISABLE KEYS */;
/*!40000 ALTER TABLE `n_register_reporter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `n_reporter_info`
--

DROP TABLE IF EXISTS `n_reporter_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `n_reporter_info` (
  `reporter_id` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '记者主键',
  `reporter_name` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '记者名字',
  `reporter_own_media` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '所属媒体',
  `reporter_own_media_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '所属媒体名字',
  `reporter_phone_num` varchar(11) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号码',
  `reporter_title` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '记者职位',
  `reporter_birthday` date DEFAULT NULL COMMENT '记者出生日期',
  `reporter_clothes_size` char(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '记者衣服尺码0XS1S2M3L4XL5XXL6XXXL',
  `reporter_driving_licence` int(11) DEFAULT NULL COMMENT '记者驾龄',
  `reporter_level` char(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '记者级别1I2II3III4IV5V',
  `reporter_email` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '记者邮箱',
  `reporter_zip_code` varchar(6) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '邮政编码',
  `reporter_gender` char(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '记者性别0女1男',
  `reporter_work_tel` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '工作座机',
  `reporter_identity_num` varchar(18) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '身份证号码',
  `reporter_passport_num` varchar(11) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '媒体记者护照号码',
  `reporter_home_address` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '家庭住址',
  `reporter_is_have_child` char(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '是否有孩子0无1有3不清楚',
  `reporter_child_gender` char(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '孩子性别0女孩1男孩',
  `reporter_child_birthday` date DEFAULT NULL COMMENT '孩子生日',
  `reporter_second_child_gender` char(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '二孩性别0女孩1男孩',
  `reporter_second_child_birthday` date DEFAULT NULL COMMENT '二孩生日',
  `reporter_other_info` varchar(400) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '记者其他信息',
  PRIMARY KEY (`reporter_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='媒体记者信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `n_reporter_info`
--

LOCK TABLES `n_reporter_info` WRITE;
/*!40000 ALTER TABLE `n_reporter_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `n_reporter_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_area`
--

DROP TABLE IF EXISTS `sys_area`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_area` (
  `id` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '编号',
  `parent_id` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '父级编号',
  `parent_ids` varchar(2000) COLLATE utf8_bin NOT NULL COMMENT '所有父级编号',
  `name` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '名称',
  `sort` decimal(10,0) NOT NULL COMMENT '排序',
  `code` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '区域编码',
  `type` char(1) COLLATE utf8_bin DEFAULT NULL COMMENT '区域类型',
  `create_by` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) COLLATE utf8_bin NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `sys_area_parent_id` (`parent_id`),
  KEY `sys_area_del_flag` (`del_flag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='区域表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_area`
--

LOCK TABLES `sys_area` WRITE;
/*!40000 ALTER TABLE `sys_area` DISABLE KEYS */;
INSERT INTO `sys_area` VALUES ('1','0','0,','中国',10,'100000','1','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('2','1','0,1,','山东省',20,'110000','2','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('3','2','0,1,2,','济南市',30,'110101','3','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('4','3','0,1,2,3,','历城区',40,'110102','4','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('5','3','0,1,2,3,','历下区',50,'110104','4','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('6','3','0,1,2,3,','高新区',60,'110105','4','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0');
/*!40000 ALTER TABLE `sys_area` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_dict`
--

DROP TABLE IF EXISTS `sys_dict`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_dict` (
  `id` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '编号',
  `value` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '数据值',
  `label` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '标签名',
  `type` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '类型',
  `description` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '描述',
  `sort` decimal(10,0) NOT NULL COMMENT '排序（升序）',
  `parent_id` varchar(64) COLLATE utf8_bin DEFAULT '0' COMMENT '父级编号',
  `create_by` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) COLLATE utf8_bin NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `sys_dict_value` (`value`),
  KEY `sys_dict_label` (`label`),
  KEY `sys_dict_del_flag` (`del_flag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='字典表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dict`
--

LOCK TABLES `sys_dict` WRITE;
/*!40000 ALTER TABLE `sys_dict` DISABLE KEYS */;
INSERT INTO `sys_dict` VALUES ('1','0','正常','del_flag','删除标记',10,'0','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('10','yellow','黄色','color','颜色值',40,'0','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('100','java.util.Date','Date','gen_java_type','Java类型',50,'0','1','2013-10-28 08:00:00','1','2013-10-28 08:00:00',NULL,'1'),('101','com.thinkgem.jeesite.modules.sys.entity.User','User','gen_java_type','Java类型',60,'0','1','2013-10-28 08:00:00','1','2013-10-28 08:00:00',NULL,'1'),('102','com.thinkgem.jeesite.modules.sys.entity.Office','Office','gen_java_type','Java类型',70,'0','1','2013-10-28 08:00:00','1','2013-10-28 08:00:00',NULL,'1'),('103','com.thinkgem.jeesite.modules.sys.entity.Area','Area','gen_java_type','Java类型',80,'0','1','2013-10-28 08:00:00','1','2013-10-28 08:00:00',NULL,'1'),('104','Custom','Custom','gen_java_type','Java类型',90,'0','1','2013-10-28 08:00:00','1','2013-10-28 08:00:00',NULL,'1'),('105','1','会议通告\0\0','oa_notify_type','通知通告类型',10,'0','1','2013-11-08 08:00:00','1','2013-11-08 08:00:00',NULL,'0'),('106','2','奖惩通告\0\0','oa_notify_type','通知通告类型',20,'0','1','2013-11-08 08:00:00','1','2013-11-08 08:00:00',NULL,'0'),('107','3','活动通告\0\0','oa_notify_type','通知通告类型',30,'0','1','2013-11-08 08:00:00','1','2013-11-08 08:00:00',NULL,'0'),('108','0','草稿','oa_notify_status','通知通告状态',10,'0','1','2013-11-08 08:00:00','1','2013-11-08 08:00:00',NULL,'0'),('109','1','发布','oa_notify_status','通知通告状态',20,'0','1','2013-11-08 08:00:00','1','2013-11-08 08:00:00',NULL,'0'),('11','orange','橙色','color','颜色值',50,'0','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('110','0','未读','oa_notify_read','通知通告状态',10,'0','1','2013-11-08 08:00:00','1','2013-11-08 08:00:00',NULL,'0'),('111','1','已读','oa_notify_read','通知通告状态',20,'0','1','2013-11-08 08:00:00','1','2013-11-08 08:00:00',NULL,'0'),('12','default','默认主题','theme','主题方案',10,'0','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('13','cerulean','天蓝主题','theme','主题方案',20,'0','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('14','readable','橙色主题','theme','主题方案',30,'0','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('15','united','红色主题','theme','主题方案',40,'0','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('16','flat','Flat主题','theme','主题方案',60,'0','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('17','1','国家','sys_area_type','区域类型',10,'0','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('18','2','省份、直辖市','sys_area_type','区域类型',20,'0','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('19','3','地市','sys_area_type','区域类型',30,'0','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('2','1','删除','del_flag','删除标记',20,'0','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('20','4','区县','sys_area_type','区域类型',40,'0','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('21','1','公司','sys_office_type','机构类型',60,'0','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('22','2','部门','sys_office_type','机构类型',70,'0','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('23','3','小组','sys_office_type','机构类型',80,'0','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('24','4','其它','sys_office_type','机构类型',90,'0','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('25','1','综合部','sys_office_common','快捷通用部门',30,'0','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('26','2','开发部','sys_office_common','快捷通用部门',40,'0','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('27','3','人力部','sys_office_common','快捷通用部门',50,'0','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('28','1','一级','sys_office_grade','机构等级',10,'0','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('29','2','二级','sys_office_grade','机构等级',20,'0','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('3','1','显示','show_hide','显示/隐藏',10,'0','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('30','3','三级','sys_office_grade','机构等级',30,'0','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('31','4','四级','sys_office_grade','机构等级',40,'0','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('32','1','所有数据','sys_data_scope','数据范围',10,'0','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('33','2','所在公司及以下数据','sys_data_scope','数据范围',20,'0','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('34','3','所在公司数据','sys_data_scope','数据范围',30,'0','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('35','4','所在部门及以下数据','sys_data_scope','数据范围',40,'0','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('36','5','所在部门数据','sys_data_scope','数据范围',50,'0','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('37','8','仅本人数据','sys_data_scope','数据范围',90,'0','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('38','9','按明细设置','sys_data_scope','数据范围',100,'0','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('39','1','系统管理','sys_user_type','用户类型',10,'0','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('4','0','隐藏','show_hide','显示/隐藏',20,'0','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('40','2','部门经理','sys_user_type','用户类型',20,'0','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('41','3','普通用户','sys_user_type','用户类型',30,'0','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('42','basic','基础主题','cms_theme','站点主题',10,'0','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('43','blue','蓝色主题','cms_theme','站点主题',20,'0','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'1'),('44','red','红色主题','cms_theme','站点主题',30,'0','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'1'),('45','article','文章模型','cms_module','栏目模型',10,'0','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('46','picture','图片模型','cms_module','栏目模型',20,'0','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'1'),('47','download','下载模型','cms_module','栏目模型',30,'0','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'1'),('48','link','链接模型','cms_module','栏目模型',40,'0','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('49','special','专题模型','cms_module','栏目模型',50,'0','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'1'),('5','1','是','yes_no','是/否',10,'0','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('50','0','默认展现方式','cms_show_modes','展现方式',10,'0','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('51','1','首栏目内容列表','cms_show_modes','展现方式',20,'0','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('52','2','栏目第一条内容','cms_show_modes','展现方式',30,'0','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('53','0','发布','cms_del_flag','内容状态',10,'0','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('54','1','删除','cms_del_flag','内容状态',20,'0','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('55','2','审核','cms_del_flag','内容状态',15,'0','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('56','1','首页焦点图','cms_posid','推荐位',10,'0','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('57','2','栏目页文章推荐','cms_posid','推荐位',20,'0','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('58','1','咨询','cms_guestbook','留言板分类',10,'0','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('59','2','建议','cms_guestbook','留言板分类',20,'0','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('6','0','否','yes_no','是/否',20,'0','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('60','3','投诉','cms_guestbook','留言板分类',30,'0','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('61','4','其它','cms_guestbook','留言板分类',40,'0','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('62','1','公休','oa_leave_type','请假类型',10,'0','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('63','2','病假','oa_leave_type','请假类型',20,'0','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('64','3','事假','oa_leave_type','请假类型',30,'0','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('65','4','调休','oa_leave_type','请假类型',40,'0','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('66','5','婚假','oa_leave_type','请假类型',60,'0','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('67','1','接入日志','sys_log_type','日志类型',30,'0','1','2013-06-03 08:00:00','1','2013-06-03 08:00:00',NULL,'0'),('68','2','异常日志','sys_log_type','日志类型',40,'0','1','2013-06-03 08:00:00','1','2013-06-03 08:00:00',NULL,'0'),('69','leave','请假流程','act_type','流程类型',10,'0','1','2013-06-03 08:00:00','1','2013-06-03 08:00:00',NULL,'0'),('7','red','红色','color','颜色值',10,'0','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('70','test_audit','审批测试流程','act_type','流程类型',20,'0','1','2013-06-03 08:00:00','1','2013-06-03 08:00:00',NULL,'0'),('71','1','分类1','act_category','流程分类',10,'0','1','2013-06-03 08:00:00','1','2013-06-03 08:00:00',NULL,'0'),('72','2','分类2','act_category','流程分类',20,'0','1','2013-06-03 08:00:00','1','2013-06-03 08:00:00',NULL,'0'),('73','crud','增删改查','gen_category','代码生成分类',10,'0','1','2013-10-28 08:00:00','1','2013-10-28 08:00:00',NULL,'1'),('74','crud_many','增删改查（包含从表）','gen_category','代码生成分类',20,'0','1','2013-10-28 08:00:00','1','2013-10-28 08:00:00',NULL,'1'),('75','tree','树结构','gen_category','代码生成分类',30,'0','1','2013-10-28 08:00:00','1','2013-10-28 08:00:00',NULL,'1'),('76','=','=','gen_query_type','查询方式',10,'0','1','2013-10-28 08:00:00','1','2013-10-28 08:00:00',NULL,'1'),('77','!=','!=','gen_query_type','查询方式',20,'0','1','2013-10-28 08:00:00','1','2013-10-28 08:00:00',NULL,'1'),('78','&gt;','&gt;','gen_query_type','查询方式',30,'0','1','2013-10-28 08:00:00','1','2013-10-28 08:00:00',NULL,'1'),('79','&lt;','&lt;','gen_query_type','查询方式',40,'0','1','2013-10-28 08:00:00','1','2013-10-28 08:00:00',NULL,'1'),('8','green','绿色','color','颜色值',20,'0','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('80','between','Between','gen_query_type','查询方式',50,'0','1','2013-10-28 08:00:00','1','2013-10-28 08:00:00',NULL,'1'),('81','like','Like','gen_query_type','查询方式',60,'0','1','2013-10-28 08:00:00','1','2013-10-28 08:00:00',NULL,'1'),('82','left_like','Left Like','gen_query_type','查询方式',70,'0','1','2013-10-28 08:00:00','1','2013-10-28 08:00:00',NULL,'1'),('83','right_like','Right Like','gen_query_type','查询方式',80,'0','1','2013-10-28 08:00:00','1','2013-10-28 08:00:00',NULL,'1'),('84','input','文本框','gen_show_type','字段生成方案',10,'0','1','2013-10-28 08:00:00','1','2013-10-28 08:00:00',NULL,'1'),('85','textarea','文本域','gen_show_type','字段生成方案',20,'0','1','2013-10-28 08:00:00','1','2013-10-28 08:00:00',NULL,'1'),('86','select','下拉框','gen_show_type','字段生成方案',30,'0','1','2013-10-28 08:00:00','1','2013-10-28 08:00:00',NULL,'1'),('87','checkbox','复选框','gen_show_type','字段生成方案',40,'0','1','2013-10-28 08:00:00','1','2013-10-28 08:00:00',NULL,'1'),('88','radiobox','单选框','gen_show_type','字段生成方案',50,'0','1','2013-10-28 08:00:00','1','2013-10-28 08:00:00',NULL,'1'),('89','dateselect','日期选择','gen_show_type','字段生成方案',60,'0','1','2013-10-28 08:00:00','1','2013-10-28 08:00:00',NULL,'1'),('9','blue','蓝色','color','颜色值',30,'0','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('90','userselect','人员选择','gen_show_type','字段生成方案',70,'0','1','2013-10-28 08:00:00','1','2013-10-28 08:00:00',NULL,'1'),('91','officeselect','部门选择','gen_show_type','字段生成方案',80,'0','1','2013-10-28 08:00:00','1','2013-10-28 08:00:00',NULL,'1'),('92','areaselect','区域选择','gen_show_type','字段生成方案',90,'0','1','2013-10-28 08:00:00','1','2013-10-28 08:00:00',NULL,'1'),('93','String','String','gen_java_type','Java类型',10,'0','1','2013-10-28 08:00:00','1','2013-10-28 08:00:00',NULL,'1'),('94','Long','Long','gen_java_type','Java类型',20,'0','1','2013-10-28 08:00:00','1','2013-10-28 08:00:00',NULL,'1'),('95','dao','仅持久层','gen_category','代码生成分类\0\0\0\0',40,'0','1','2013-10-28 08:00:00','1','2013-10-28 08:00:00',NULL,'1'),('96','1','男','sex','性别',10,'0','1','2013-10-28 08:00:00','1','2013-10-28 08:00:00',NULL,'0'),('97','2','女','sex','性别',20,'0','1','2013-10-28 08:00:00','1','2013-10-28 08:00:00',NULL,'0'),('98','Integer','Integer','gen_java_type','Java类型',30,'0','1','2013-10-28 08:00:00','1','2013-10-28 08:00:00',NULL,'1'),('99','Double','Double','gen_java_type','Java类型',40,'0','1','2013-10-28 08:00:00','1','2013-10-28 08:00:00',NULL,'1');
/*!40000 ALTER TABLE `sys_dict` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_log`
--

DROP TABLE IF EXISTS `sys_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_log` (
  `id` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '编号',
  `type` char(1) COLLATE utf8_bin DEFAULT '1' COMMENT '日志类型',
  `title` varchar(255) COLLATE utf8_bin DEFAULT '' COMMENT '日志标题',
  `create_by` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '创建者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `remote_addr` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '操作IP地址',
  `user_agent` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '用户代理',
  `request_uri` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '请求URI',
  `method` varchar(5) COLLATE utf8_bin DEFAULT NULL COMMENT '操作方式',
  `params` text COLLATE utf8_bin COMMENT '操作提交的数据',
  `exception` text COLLATE utf8_bin COMMENT '异常信息',
  PRIMARY KEY (`id`),
  KEY `sys_log_create_by` (`create_by`),
  KEY `sys_log_request_uri` (`request_uri`),
  KEY `sys_log_type` (`type`),
  KEY `sys_log_create_date` (`create_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='日志表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_log`
--

LOCK TABLES `sys_log` WRITE;
/*!40000 ALTER TABLE `sys_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_mdict`
--

DROP TABLE IF EXISTS `sys_mdict`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_mdict` (
  `id` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '编号',
  `parent_id` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '父级编号',
  `parent_ids` varchar(2000) COLLATE utf8_bin NOT NULL COMMENT '所有父级编号',
  `name` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '名称',
  `sort` decimal(10,0) NOT NULL COMMENT '排序',
  `description` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '描述',
  `create_by` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) COLLATE utf8_bin NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `sys_mdict_parent_id` (`parent_id`),
  KEY `sys_mdict_del_flag` (`del_flag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='多级字典表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_mdict`
--

LOCK TABLES `sys_mdict` WRITE;
/*!40000 ALTER TABLE `sys_mdict` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_mdict` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_menu`
--

DROP TABLE IF EXISTS `sys_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_menu` (
  `id` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '编号',
  `parent_id` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '父级编号',
  `parent_ids` varchar(2000) COLLATE utf8_bin NOT NULL COMMENT '所有父级编号',
  `name` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '名称',
  `sort` decimal(10,0) NOT NULL COMMENT '排序',
  `href` varchar(2000) COLLATE utf8_bin DEFAULT NULL COMMENT '链接',
  `target` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '目标',
  `icon` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '图标',
  `is_show` char(1) COLLATE utf8_bin NOT NULL COMMENT '是否在菜单中显示',
  `permission` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '权限标识',
  `create_by` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) COLLATE utf8_bin NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `sys_menu_parent_id` (`parent_id`),
  KEY `sys_menu_del_flag` (`del_flag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='菜单表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_menu`
--

LOCK TABLES `sys_menu` WRITE;
/*!40000 ALTER TABLE `sys_menu` DISABLE KEYS */;
INSERT INTO `sys_menu` VALUES ('1','0','0,','功能菜单',0,NULL,NULL,NULL,'1',NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('10','3','0,1,2,3,','字典管理',60,'/sys/dict/',NULL,'th-list','1',NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('11','10','0,1,2,3,10,','查看',30,NULL,NULL,NULL,'0','sys:dict:view','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('12','10','0,1,2,3,10,','修改',40,NULL,NULL,NULL,'0','sys:dict:edit','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('13','2','0,1,2,','机构用户',970,NULL,NULL,NULL,'1',NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('14','13','0,1,2,13,','区域管理',50,'/sys/area/',NULL,'th','1',NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('15','14','0,1,2,13,14,','查看',30,NULL,NULL,NULL,'0','sys:area:view','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('16','14','0,1,2,13,14,','修改',40,NULL,NULL,NULL,'0','sys:area:edit','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('17','13','0,1,2,13,','机构管理',40,'/sys/office/',NULL,'','1',NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('18','17','0,1,2,13,17,','查看',30,NULL,NULL,NULL,'0','sys:office:view','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('19','17','0,1,2,13,17,','修改',40,NULL,NULL,NULL,'0','sys:office:edit','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('2','1','0,1,','系统设置',900,'','','','1','','1','2013-05-27 08:00:00','1','2018-12-02 11:15:23','','0'),('20','13','0,1,2,13,','用户管理',30,'/sys/user/index',NULL,'user','1',NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('21','20','0,1,2,13,20,','查看',30,NULL,NULL,NULL,'0','sys:user:view','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('22','20','0,1,2,13,20,','修改',40,NULL,NULL,NULL,'0','sys:user:edit','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('24','23','0,1,2,23','官方首页',30,'http://jeesite.com','_blank',NULL,'0',NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('3','2','0,1,2,','系统设置',980,NULL,NULL,NULL,'1',NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('4','3','0,1,2,3,','菜单管理',30,'/sys/menu/',NULL,'list-alt','1',NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('5','4','0,1,2,3,4,','查看',30,NULL,NULL,NULL,'0','sys:menu:view','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('6','4','0,1,2,3,4,','修改',40,NULL,NULL,NULL,'0','sys:menu:edit','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('67','2','0,1,2,','日志查询',985,NULL,NULL,NULL,'1',NULL,'1','2013-06-03 08:00:00','1','2013-06-03 08:00:00',NULL,'0'),('68','67','0,1,2,67,','日志查询',30,'/sys/log',NULL,'pencil','1','sys:log:view','1','2013-06-03 08:00:00','1','2013-06-03 08:00:00',NULL,'0'),('7','3','0,1,2,3,','角色管理',50,'/sys/role/',NULL,'lock','1',NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('8','7','0,1,2,3,7,','查看',30,NULL,NULL,NULL,'0','sys:role:view','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('84','67','0,1,2,67,','连接池监视',40,'/../druid',NULL,NULL,'1',NULL,'1','2013-10-18 08:00:00','1','2013-10-18 08:00:00',NULL,'0'),('85','76','0,1,75,76,','行政区域',80,'/../static/map/map-city.html',NULL,NULL,'1',NULL,'1','2013-10-22 08:00:00','1','2013-10-22 08:00:00',NULL,'0'),('9','7','0,1,2,3,7,','修改',40,NULL,NULL,NULL,'0','sys:role:edit','1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0');
/*!40000 ALTER TABLE `sys_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_office`
--

DROP TABLE IF EXISTS `sys_office`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_office` (
  `id` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '编号',
  `parent_id` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '父级编号',
  `parent_ids` varchar(2000) COLLATE utf8_bin NOT NULL COMMENT '所有父级编号',
  `name` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '名称',
  `sort` decimal(10,0) NOT NULL COMMENT '排序',
  `area_id` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '归属区域',
  `code` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '区域编码',
  `type` char(1) COLLATE utf8_bin NOT NULL COMMENT '机构类型',
  `grade` char(1) COLLATE utf8_bin NOT NULL COMMENT '机构等级',
  `address` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '联系地址',
  `zip_code` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '邮政编码',
  `master` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '负责人',
  `phone` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '电话',
  `fax` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '传真',
  `email` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '邮箱',
  `USEABLE` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '是否启用',
  `PRIMARY_PERSON` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '主负责人',
  `DEPUTY_PERSON` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '副负责人',
  `create_by` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) COLLATE utf8_bin NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `sys_office_parent_id` (`parent_id`),
  KEY `sys_office_del_flag` (`del_flag`),
  KEY `sys_office_type` (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='机构表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_office`
--

LOCK TABLES `sys_office` WRITE;
/*!40000 ALTER TABLE `sys_office` DISABLE KEYS */;
INSERT INTO `sys_office` VALUES ('1','0','0,','山东省总公司',10,'2','100000','1','1',NULL,NULL,NULL,NULL,NULL,NULL,'1',NULL,NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('2','1','0,1,','公司领导',10,'2','100001','2','1',NULL,NULL,NULL,NULL,NULL,NULL,'1',NULL,NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0');
/*!40000 ALTER TABLE `sys_office` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role` (
  `id` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '编号',
  `office_id` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '归属机构',
  `name` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '角色名称',
  `enname` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '英文名称',
  `role_type` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '角色类型',
  `data_scope` char(1) COLLATE utf8_bin DEFAULT NULL COMMENT '数据范围',
  `is_sys` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '是否系统数据',
  `useable` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '是否可用',
  `create_by` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) COLLATE utf8_bin NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `sys_role_del_flag` (`del_flag`),
  KEY `sys_role_enname` (`enname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role`
--

LOCK TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` VALUES ('1','2','系统管理员','dept','assignment','1','1','1','1','2013-05-27 08:00:00','1','2017-04-07 17:21:43','','0');
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_menu`
--

DROP TABLE IF EXISTS `sys_role_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role_menu` (
  `role_id` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '角色编号',
  `menu_id` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '菜单编号',
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='角色-菜单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_menu`
--

LOCK TABLES `sys_role_menu` WRITE;
/*!40000 ALTER TABLE `sys_role_menu` DISABLE KEYS */;
INSERT INTO `sys_role_menu` VALUES ('1','1'),('1','10'),('1','11'),('1','12'),('1','13'),('1','14'),('1','15'),('1','16'),('1','17'),('1','18'),('1','19'),('1','2'),('1','20'),('1','21'),('1','22'),('1','24'),('1','3'),('1','4'),('1','5'),('1','6'),('1','67'),('1','68'),('1','7'),('1','8'),('1','84'),('1','85'),('1','9');
/*!40000 ALTER TABLE `sys_role_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_office`
--

DROP TABLE IF EXISTS `sys_role_office`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role_office` (
  `role_id` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '角色编号',
  `office_id` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '机构编号',
  PRIMARY KEY (`role_id`,`office_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='角色-机构';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_office`
--

LOCK TABLES `sys_role_office` WRITE;
/*!40000 ALTER TABLE `sys_role_office` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_role_office` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user` (
  `id` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '编号',
  `company_id` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '归属公司',
  `office_id` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '归属部门',
  `login_name` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '登录名',
  `password` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '密码',
  `no` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '工号',
  `name` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '姓名',
  `email` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '电话',
  `mobile` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '手机',
  `user_type` char(1) COLLATE utf8_bin DEFAULT NULL COMMENT '用户类型',
  `photo` varchar(1000) COLLATE utf8_bin DEFAULT NULL COMMENT '用户头像',
  `login_ip` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '最后登陆IP',
  `login_date` datetime DEFAULT NULL COMMENT '最后登陆时间',
  `login_flag` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '是否可登录',
  `create_by` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) COLLATE utf8_bin NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `sys_user_office_id` (`office_id`),
  KEY `sys_user_login_name` (`login_name`),
  KEY `sys_user_company_id` (`company_id`),
  KEY `sys_user_update_date` (`update_date`),
  KEY `sys_user_del_flag` (`del_flag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` VALUES ('1','1','2','administrator','02a3f0772fcca9f415adc990734b45c6f059c7d33ee28362c4852032','0001','系统管理员','admin@bmw.com','010-88888888','18888888888','','','0:0:0:0:0:0:0:1','2018-12-02 12:59:54','1','1','2013-05-27 08:00:00','1','2018-12-02 12:58:39','最高管理员','0');
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user_role`
--

DROP TABLE IF EXISTS `sys_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user_role` (
  `user_id` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '用户编号',
  `role_id` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '角色编号',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户-角色';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_role`
--

LOCK TABLES `sys_user_role` WRITE;
/*!40000 ALTER TABLE `sys_user_role` DISABLE KEYS */;
INSERT INTO `sys_user_role` VALUES ('1','1');
/*!40000 ALTER TABLE `sys_user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-02 13:03:39
