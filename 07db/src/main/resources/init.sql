CREATE DATABASE `wjchenge_master` CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_general_ci';

CREATE TABLE `data_source_name`  (
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

INSERT INTO `data_source_name` VALUES ('master');

CREATE DATABASE `wjchenge_slave` CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_general_ci';

CREATE TABLE `data_source_name`  (
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

INSERT INTO `data_source_name` VALUES ('slave');