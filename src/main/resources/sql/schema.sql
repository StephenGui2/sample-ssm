DROP TABLE IF EXISTS hs_user;
CREATE TABLE hs_user (
  id BIGINT NOT NULL AUTO_INCREMENT,
  user_id BIGINT NOT NULL,
  name varchar(50) NOT NULL ,
  sex varchar(3)  NOT NULL ,
  age tinyint(3)  NOT NULL ,
  status tinyint(3)  NOT NULL DEFAULT 0,
  create_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  update_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
) DEFAULT CHARSET=utf8mb4;
create unique index idx_userid on hs_user(user_id);
create index idx_name on hs_user(name);
INSERT INTO `hs_user` VALUES (1, 154485323263853, 'junda.gui1', '男', 22, 0, '2018-12-14 19:24:47', '2018-12-14 19:24:47');
INSERT INTO `hs_user` VALUES (2, 154485323266030, 'junda.gui2','男', 22, 0, '2018-12-14 19:24:48', '2018-12-14 19:24:48');
INSERT INTO `hs_user` VALUES (3, 154485323266023, 'junda.gui3', '男', 22, 0, '2018-12-14 19:24:49', '2018-12-14 19:24:49');
INSERT INTO `hs_user` VALUES (4, 154485323266004, 'junda.gui4', '男', 22, 0, '2018-12-14 19:24:50', '2018-12-14 19:24:50');
INSERT INTO `hs_user` VALUES (5, 154485323266097, '桂俊达', '男', 22, 0, '2018-12-14 19:24:51', '2018-12-14 19:24:51');