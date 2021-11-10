CREATE DATABASE `wjchenge_master` CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_general_ci';

CREATE TABLE `wjchenge_master`.`data_source_name`  (
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

INSERT INTO `wjchenge_master`.`data_source_name` VALUES ('master');

CREATE DATABASE `wjchenge_slave` CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_general_ci';

CREATE TABLE `wjchenge_slave`.`data_source_name`  (
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

INSERT INTO `wjchenge_slave`.`data_source_name` VALUES ('slave');


CREATE TABLE `wjchenge_master`.`shardingsphere_test`  (
  `id` bigint(20) NOT NULL,
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;


CREATE TABLE `wjchenge_slave`.`shardingsphere_test`  (
  `id` bigint(20) NOT NULL,
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;
