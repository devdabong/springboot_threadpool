CREATE TABLE `tb_weather` (
  `temp_no` int(10) NOT NULL AUTO_INCREMENT COMMENT '날씨 번호',
  `temp_lon` varchar(10) NOT NULL COMMENT 'longitude(경도)',
  `temp_lat` varchar(10) NOT NULL COMMENT 'latitude(위도)',
  `cur_weather` varchar(20) NOT NULL COMMENT '현재 날씨',
  `description` varchar(20) NOT NULL COMMENT '현재 날씨 설명',
  `cur_temp` varchar(20) NOT NULL COMMENT '현재 온도',
  `feel_temp` varchar(20) NOT NULL COMMENT '체감 온도',
  `cur_humidity` varchar(20) NOT NULL COMMENT '현재 습도',
  `country` varchar(50) NOT NULL COMMENT '나라명',
  `city` varchar(50) NOT NULL COMMENT '도시명',
  `temp_date` datetime NOT NULL DEFAULT current_timestamp() COMMENT '등록 날짜',
  `etc_code` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`temp_no`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8