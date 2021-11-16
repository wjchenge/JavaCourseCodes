CREATE DATABASE `wj_order_0` CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_general_ci';

CREATE TABLE `wj_order_0`.`t_order_0`  (
  `id` bigint(20) NOT NULL,
  `order_no` bigint(20) NULL DEFAULT NULL COMMENT '订单编号',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `shipping_id` int(11) NULL DEFAULT NULL COMMENT '关联的收货地址id',
  `total_payment` int(11) NULL DEFAULT NULL COMMENT '商品总金额,单位是分',
  `real_payment` int(11) NULL DEFAULT NULL COMMENT '实际付款金额,单位是分',
  `payment_type` int(4) NULL DEFAULT NULL COMMENT '支付类型,1-在线支付 2 货到付款',
  `postage` int(10) NULL DEFAULT NULL COMMENT '运费,单位是分',
  `status` tinyint(2) NULL DEFAULT NULL COMMENT '订单状态:0-已取消, 1-未付款，2-已付款，3-已发货，4-交易成功，5-订单删除',
  `payment_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `send_time` datetime(0) NULL DEFAULT NULL COMMENT '发货时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '交易完成时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

CREATE TABLE `wj_order_0`.`t_order_1`  (
  `id` bigint(20) NOT NULL,
  `order_no` bigint(20) NULL DEFAULT NULL COMMENT '订单编号',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `shipping_id` int(11) NULL DEFAULT NULL COMMENT '关联的收货地址id',
  `total_payment` int(11) NULL DEFAULT NULL COMMENT '商品总金额,单位是分',
  `real_payment` int(11) NULL DEFAULT NULL COMMENT '实际付款金额,单位是分',
  `payment_type` int(4) NULL DEFAULT NULL COMMENT '支付类型,1-在线支付 2 货到付款',
  `postage` int(10) NULL DEFAULT NULL COMMENT '运费,单位是分',
  `status` tinyint(2) NULL DEFAULT NULL COMMENT '订单状态:0-已取消, 1-未付款，2-已付款，3-已发货，4-交易成功，5-订单删除',
  `payment_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `send_time` datetime(0) NULL DEFAULT NULL COMMENT '发货时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '交易完成时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

CREATE TABLE `wj_order_0`.`t_order_2`  (
  `id` bigint(20) NOT NULL,
  `order_no` bigint(20) NULL DEFAULT NULL COMMENT '订单编号',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `shipping_id` int(11) NULL DEFAULT NULL COMMENT '关联的收货地址id',
  `total_payment` int(11) NULL DEFAULT NULL COMMENT '商品总金额,单位是分',
  `real_payment` int(11) NULL DEFAULT NULL COMMENT '实际付款金额,单位是分',
  `payment_type` int(4) NULL DEFAULT NULL COMMENT '支付类型,1-在线支付 2 货到付款',
  `postage` int(10) NULL DEFAULT NULL COMMENT '运费,单位是分',
  `status` tinyint(2) NULL DEFAULT NULL COMMENT '订单状态:0-已取消, 1-未付款，2-已付款，3-已发货，4-交易成功，5-订单删除',
  `payment_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `send_time` datetime(0) NULL DEFAULT NULL COMMENT '发货时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '交易完成时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

CREATE TABLE `wj_order_0`.`t_order_3`  (
  `id` bigint(20) NOT NULL,
  `order_no` bigint(20) NULL DEFAULT NULL COMMENT '订单编号',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `shipping_id` int(11) NULL DEFAULT NULL COMMENT '关联的收货地址id',
  `total_payment` int(11) NULL DEFAULT NULL COMMENT '商品总金额,单位是分',
  `real_payment` int(11) NULL DEFAULT NULL COMMENT '实际付款金额,单位是分',
  `payment_type` int(4) NULL DEFAULT NULL COMMENT '支付类型,1-在线支付 2 货到付款',
  `postage` int(10) NULL DEFAULT NULL COMMENT '运费,单位是分',
  `status` tinyint(2) NULL DEFAULT NULL COMMENT '订单状态:0-已取消, 1-未付款，2-已付款，3-已发货，4-交易成功，5-订单删除',
  `payment_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `send_time` datetime(0) NULL DEFAULT NULL COMMENT '发货时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '交易完成时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

CREATE TABLE `wj_order_0`.`t_order_4`  (
  `id` bigint(20) NOT NULL,
  `order_no` bigint(20) NULL DEFAULT NULL COMMENT '订单编号',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `shipping_id` int(11) NULL DEFAULT NULL COMMENT '关联的收货地址id',
  `total_payment` int(11) NULL DEFAULT NULL COMMENT '商品总金额,单位是分',
  `real_payment` int(11) NULL DEFAULT NULL COMMENT '实际付款金额,单位是分',
  `payment_type` int(4) NULL DEFAULT NULL COMMENT '支付类型,1-在线支付 2 货到付款',
  `postage` int(10) NULL DEFAULT NULL COMMENT '运费,单位是分',
  `status` tinyint(2) NULL DEFAULT NULL COMMENT '订单状态:0-已取消, 1-未付款，2-已付款，3-已发货，4-交易成功，5-订单删除',
  `payment_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `send_time` datetime(0) NULL DEFAULT NULL COMMENT '发货时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '交易完成时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

CREATE TABLE `wj_order_0`.`t_order_5`  (
  `id` bigint(20) NOT NULL,
  `order_no` bigint(20) NULL DEFAULT NULL COMMENT '订单编号',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `shipping_id` int(11) NULL DEFAULT NULL COMMENT '关联的收货地址id',
  `total_payment` int(11) NULL DEFAULT NULL COMMENT '商品总金额,单位是分',
  `real_payment` int(11) NULL DEFAULT NULL COMMENT '实际付款金额,单位是分',
  `payment_type` int(4) NULL DEFAULT NULL COMMENT '支付类型,1-在线支付 2 货到付款',
  `postage` int(10) NULL DEFAULT NULL COMMENT '运费,单位是分',
  `status` tinyint(2) NULL DEFAULT NULL COMMENT '订单状态:0-已取消, 1-未付款，2-已付款，3-已发货，4-交易成功，5-订单删除',
  `payment_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `send_time` datetime(0) NULL DEFAULT NULL COMMENT '发货时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '交易完成时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

CREATE TABLE `wj_order_0`.`t_order_6`  (
  `id` bigint(20) NOT NULL,
  `order_no` bigint(20) NULL DEFAULT NULL COMMENT '订单编号',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `shipping_id` int(11) NULL DEFAULT NULL COMMENT '关联的收货地址id',
  `total_payment` int(11) NULL DEFAULT NULL COMMENT '商品总金额,单位是分',
  `real_payment` int(11) NULL DEFAULT NULL COMMENT '实际付款金额,单位是分',
  `payment_type` int(4) NULL DEFAULT NULL COMMENT '支付类型,1-在线支付 2 货到付款',
  `postage` int(10) NULL DEFAULT NULL COMMENT '运费,单位是分',
  `status` tinyint(2) NULL DEFAULT NULL COMMENT '订单状态:0-已取消, 1-未付款，2-已付款，3-已发货，4-交易成功，5-订单删除',
  `payment_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `send_time` datetime(0) NULL DEFAULT NULL COMMENT '发货时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '交易完成时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

CREATE TABLE `wj_order_0`.`t_order_7`  (
  `id` bigint(20) NOT NULL,
  `order_no` bigint(20) NULL DEFAULT NULL COMMENT '订单编号',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `shipping_id` int(11) NULL DEFAULT NULL COMMENT '关联的收货地址id',
  `total_payment` int(11) NULL DEFAULT NULL COMMENT '商品总金额,单位是分',
  `real_payment` int(11) NULL DEFAULT NULL COMMENT '实际付款金额,单位是分',
  `payment_type` int(4) NULL DEFAULT NULL COMMENT '支付类型,1-在线支付 2 货到付款',
  `postage` int(10) NULL DEFAULT NULL COMMENT '运费,单位是分',
  `status` tinyint(2) NULL DEFAULT NULL COMMENT '订单状态:0-已取消, 1-未付款，2-已付款，3-已发货，4-交易成功，5-订单删除',
  `payment_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `send_time` datetime(0) NULL DEFAULT NULL COMMENT '发货时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '交易完成时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

CREATE TABLE `wj_order_0`.`t_order_8`  (
  `id` bigint(20) NOT NULL,
  `order_no` bigint(20) NULL DEFAULT NULL COMMENT '订单编号',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `shipping_id` int(11) NULL DEFAULT NULL COMMENT '关联的收货地址id',
  `total_payment` int(11) NULL DEFAULT NULL COMMENT '商品总金额,单位是分',
  `real_payment` int(11) NULL DEFAULT NULL COMMENT '实际付款金额,单位是分',
  `payment_type` int(4) NULL DEFAULT NULL COMMENT '支付类型,1-在线支付 2 货到付款',
  `postage` int(10) NULL DEFAULT NULL COMMENT '运费,单位是分',
  `status` tinyint(2) NULL DEFAULT NULL COMMENT '订单状态:0-已取消, 1-未付款，2-已付款，3-已发货，4-交易成功，5-订单删除',
  `payment_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `send_time` datetime(0) NULL DEFAULT NULL COMMENT '发货时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '交易完成时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

CREATE TABLE `wj_order_0`.`t_order_9`  (
  `id` bigint(20) NOT NULL,
  `order_no` bigint(20) NULL DEFAULT NULL COMMENT '订单编号',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `shipping_id` int(11) NULL DEFAULT NULL COMMENT '关联的收货地址id',
  `total_payment` int(11) NULL DEFAULT NULL COMMENT '商品总金额,单位是分',
  `real_payment` int(11) NULL DEFAULT NULL COMMENT '实际付款金额,单位是分',
  `payment_type` int(4) NULL DEFAULT NULL COMMENT '支付类型,1-在线支付 2 货到付款',
  `postage` int(10) NULL DEFAULT NULL COMMENT '运费,单位是分',
  `status` tinyint(2) NULL DEFAULT NULL COMMENT '订单状态:0-已取消, 1-未付款，2-已付款，3-已发货，4-交易成功，5-订单删除',
  `payment_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `send_time` datetime(0) NULL DEFAULT NULL COMMENT '发货时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '交易完成时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

CREATE TABLE `wj_order_0`.`t_order_10`  (
  `id` bigint(20) NOT NULL,
  `order_no` bigint(20) NULL DEFAULT NULL COMMENT '订单编号',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `shipping_id` int(11) NULL DEFAULT NULL COMMENT '关联的收货地址id',
  `total_payment` int(11) NULL DEFAULT NULL COMMENT '商品总金额,单位是分',
  `real_payment` int(11) NULL DEFAULT NULL COMMENT '实际付款金额,单位是分',
  `payment_type` int(4) NULL DEFAULT NULL COMMENT '支付类型,1-在线支付 2 货到付款',
  `postage` int(10) NULL DEFAULT NULL COMMENT '运费,单位是分',
  `status` tinyint(2) NULL DEFAULT NULL COMMENT '订单状态:0-已取消, 1-未付款，2-已付款，3-已发货，4-交易成功，5-订单删除',
  `payment_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `send_time` datetime(0) NULL DEFAULT NULL COMMENT '发货时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '交易完成时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

CREATE TABLE `wj_order_0`.`t_order_11`  (
  `id` bigint(20) NOT NULL,
  `order_no` bigint(20) NULL DEFAULT NULL COMMENT '订单编号',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `shipping_id` int(11) NULL DEFAULT NULL COMMENT '关联的收货地址id',
  `total_payment` int(11) NULL DEFAULT NULL COMMENT '商品总金额,单位是分',
  `real_payment` int(11) NULL DEFAULT NULL COMMENT '实际付款金额,单位是分',
  `payment_type` int(4) NULL DEFAULT NULL COMMENT '支付类型,1-在线支付 2 货到付款',
  `postage` int(10) NULL DEFAULT NULL COMMENT '运费,单位是分',
  `status` tinyint(2) NULL DEFAULT NULL COMMENT '订单状态:0-已取消, 1-未付款，2-已付款，3-已发货，4-交易成功，5-订单删除',
  `payment_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `send_time` datetime(0) NULL DEFAULT NULL COMMENT '发货时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '交易完成时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

CREATE TABLE `wj_order_0`.`t_order_12`  (
  `id` bigint(20) NOT NULL,
  `order_no` bigint(20) NULL DEFAULT NULL COMMENT '订单编号',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `shipping_id` int(11) NULL DEFAULT NULL COMMENT '关联的收货地址id',
  `total_payment` int(11) NULL DEFAULT NULL COMMENT '商品总金额,单位是分',
  `real_payment` int(11) NULL DEFAULT NULL COMMENT '实际付款金额,单位是分',
  `payment_type` int(4) NULL DEFAULT NULL COMMENT '支付类型,1-在线支付 2 货到付款',
  `postage` int(10) NULL DEFAULT NULL COMMENT '运费,单位是分',
  `status` tinyint(2) NULL DEFAULT NULL COMMENT '订单状态:0-已取消, 1-未付款，2-已付款，3-已发货，4-交易成功，5-订单删除',
  `payment_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `send_time` datetime(0) NULL DEFAULT NULL COMMENT '发货时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '交易完成时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

CREATE TABLE `wj_order_0`.`t_order_13`  (
  `id` bigint(20) NOT NULL,
  `order_no` bigint(20) NULL DEFAULT NULL COMMENT '订单编号',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `shipping_id` int(11) NULL DEFAULT NULL COMMENT '关联的收货地址id',
  `total_payment` int(11) NULL DEFAULT NULL COMMENT '商品总金额,单位是分',
  `real_payment` int(11) NULL DEFAULT NULL COMMENT '实际付款金额,单位是分',
  `payment_type` int(4) NULL DEFAULT NULL COMMENT '支付类型,1-在线支付 2 货到付款',
  `postage` int(10) NULL DEFAULT NULL COMMENT '运费,单位是分',
  `status` tinyint(2) NULL DEFAULT NULL COMMENT '订单状态:0-已取消, 1-未付款，2-已付款，3-已发货，4-交易成功，5-订单删除',
  `payment_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `send_time` datetime(0) NULL DEFAULT NULL COMMENT '发货时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '交易完成时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

CREATE TABLE `wj_order_0`.`t_order_14`  (
  `id` bigint(20) NOT NULL,
  `order_no` bigint(20) NULL DEFAULT NULL COMMENT '订单编号',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `shipping_id` int(11) NULL DEFAULT NULL COMMENT '关联的收货地址id',
  `total_payment` int(11) NULL DEFAULT NULL COMMENT '商品总金额,单位是分',
  `real_payment` int(11) NULL DEFAULT NULL COMMENT '实际付款金额,单位是分',
  `payment_type` int(4) NULL DEFAULT NULL COMMENT '支付类型,1-在线支付 2 货到付款',
  `postage` int(10) NULL DEFAULT NULL COMMENT '运费,单位是分',
  `status` tinyint(2) NULL DEFAULT NULL COMMENT '订单状态:0-已取消, 1-未付款，2-已付款，3-已发货，4-交易成功，5-订单删除',
  `payment_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `send_time` datetime(0) NULL DEFAULT NULL COMMENT '发货时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '交易完成时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

CREATE TABLE `wj_order_0`.`t_order_15`  (
  `id` bigint(20) NOT NULL,
  `order_no` bigint(20) NULL DEFAULT NULL COMMENT '订单编号',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `shipping_id` int(11) NULL DEFAULT NULL COMMENT '关联的收货地址id',
  `total_payment` int(11) NULL DEFAULT NULL COMMENT '商品总金额,单位是分',
  `real_payment` int(11) NULL DEFAULT NULL COMMENT '实际付款金额,单位是分',
  `payment_type` int(4) NULL DEFAULT NULL COMMENT '支付类型,1-在线支付 2 货到付款',
  `postage` int(10) NULL DEFAULT NULL COMMENT '运费,单位是分',
  `status` tinyint(2) NULL DEFAULT NULL COMMENT '订单状态:0-已取消, 1-未付款，2-已付款，3-已发货，4-交易成功，5-订单删除',
  `payment_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `send_time` datetime(0) NULL DEFAULT NULL COMMENT '发货时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '交易完成时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;


CREATE DATABASE `wj_order_1` CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_general_ci';

CREATE TABLE `wj_order_1`.`t_order_0`  (
  `id` bigint(20) NOT NULL,
  `order_no` bigint(20) NULL DEFAULT NULL COMMENT '订单编号',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `shipping_id` int(11) NULL DEFAULT NULL COMMENT '关联的收货地址id',
  `total_payment` int(11) NULL DEFAULT NULL COMMENT '商品总金额,单位是分',
  `real_payment` int(11) NULL DEFAULT NULL COMMENT '实际付款金额,单位是分',
  `payment_type` int(4) NULL DEFAULT NULL COMMENT '支付类型,1-在线支付 2 货到付款',
  `postage` int(10) NULL DEFAULT NULL COMMENT '运费,单位是分',
  `status` tinyint(2) NULL DEFAULT NULL COMMENT '订单状态:0-已取消, 1-未付款，2-已付款，3-已发货，4-交易成功，5-订单删除',
  `payment_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `send_time` datetime(0) NULL DEFAULT NULL COMMENT '发货时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '交易完成时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

CREATE TABLE `wj_order_1`.`t_order_1`  (
  `id` bigint(20) NOT NULL,
  `order_no` bigint(20) NULL DEFAULT NULL COMMENT '订单编号',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `shipping_id` int(11) NULL DEFAULT NULL COMMENT '关联的收货地址id',
  `total_payment` int(11) NULL DEFAULT NULL COMMENT '商品总金额,单位是分',
  `real_payment` int(11) NULL DEFAULT NULL COMMENT '实际付款金额,单位是分',
  `payment_type` int(4) NULL DEFAULT NULL COMMENT '支付类型,1-在线支付 2 货到付款',
  `postage` int(10) NULL DEFAULT NULL COMMENT '运费,单位是分',
  `status` tinyint(2) NULL DEFAULT NULL COMMENT '订单状态:0-已取消, 1-未付款，2-已付款，3-已发货，4-交易成功，5-订单删除',
  `payment_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `send_time` datetime(0) NULL DEFAULT NULL COMMENT '发货时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '交易完成时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

CREATE TABLE `wj_order_1`.`t_order_2`  (
  `id` bigint(20) NOT NULL,
  `order_no` bigint(20) NULL DEFAULT NULL COMMENT '订单编号',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `shipping_id` int(11) NULL DEFAULT NULL COMMENT '关联的收货地址id',
  `total_payment` int(11) NULL DEFAULT NULL COMMENT '商品总金额,单位是分',
  `real_payment` int(11) NULL DEFAULT NULL COMMENT '实际付款金额,单位是分',
  `payment_type` int(4) NULL DEFAULT NULL COMMENT '支付类型,1-在线支付 2 货到付款',
  `postage` int(10) NULL DEFAULT NULL COMMENT '运费,单位是分',
  `status` tinyint(2) NULL DEFAULT NULL COMMENT '订单状态:0-已取消, 1-未付款，2-已付款，3-已发货，4-交易成功，5-订单删除',
  `payment_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `send_time` datetime(0) NULL DEFAULT NULL COMMENT '发货时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '交易完成时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

CREATE TABLE `wj_order_1`.`t_order_3`  (
  `id` bigint(20) NOT NULL,
  `order_no` bigint(20) NULL DEFAULT NULL COMMENT '订单编号',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `shipping_id` int(11) NULL DEFAULT NULL COMMENT '关联的收货地址id',
  `total_payment` int(11) NULL DEFAULT NULL COMMENT '商品总金额,单位是分',
  `real_payment` int(11) NULL DEFAULT NULL COMMENT '实际付款金额,单位是分',
  `payment_type` int(4) NULL DEFAULT NULL COMMENT '支付类型,1-在线支付 2 货到付款',
  `postage` int(10) NULL DEFAULT NULL COMMENT '运费,单位是分',
  `status` tinyint(2) NULL DEFAULT NULL COMMENT '订单状态:0-已取消, 1-未付款，2-已付款，3-已发货，4-交易成功，5-订单删除',
  `payment_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `send_time` datetime(0) NULL DEFAULT NULL COMMENT '发货时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '交易完成时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

CREATE TABLE `wj_order_1`.`t_order_4`  (
  `id` bigint(20) NOT NULL,
  `order_no` bigint(20) NULL DEFAULT NULL COMMENT '订单编号',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `shipping_id` int(11) NULL DEFAULT NULL COMMENT '关联的收货地址id',
  `total_payment` int(11) NULL DEFAULT NULL COMMENT '商品总金额,单位是分',
  `real_payment` int(11) NULL DEFAULT NULL COMMENT '实际付款金额,单位是分',
  `payment_type` int(4) NULL DEFAULT NULL COMMENT '支付类型,1-在线支付 2 货到付款',
  `postage` int(10) NULL DEFAULT NULL COMMENT '运费,单位是分',
  `status` tinyint(2) NULL DEFAULT NULL COMMENT '订单状态:0-已取消, 1-未付款，2-已付款，3-已发货，4-交易成功，5-订单删除',
  `payment_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `send_time` datetime(0) NULL DEFAULT NULL COMMENT '发货时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '交易完成时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

CREATE TABLE `wj_order_1`.`t_order_5`  (
  `id` bigint(20) NOT NULL,
  `order_no` bigint(20) NULL DEFAULT NULL COMMENT '订单编号',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `shipping_id` int(11) NULL DEFAULT NULL COMMENT '关联的收货地址id',
  `total_payment` int(11) NULL DEFAULT NULL COMMENT '商品总金额,单位是分',
  `real_payment` int(11) NULL DEFAULT NULL COMMENT '实际付款金额,单位是分',
  `payment_type` int(4) NULL DEFAULT NULL COMMENT '支付类型,1-在线支付 2 货到付款',
  `postage` int(10) NULL DEFAULT NULL COMMENT '运费,单位是分',
  `status` tinyint(2) NULL DEFAULT NULL COMMENT '订单状态:0-已取消, 1-未付款，2-已付款，3-已发货，4-交易成功，5-订单删除',
  `payment_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `send_time` datetime(0) NULL DEFAULT NULL COMMENT '发货时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '交易完成时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

CREATE TABLE `wj_order_1`.`t_order_6`  (
  `id` bigint(20) NOT NULL,
  `order_no` bigint(20) NULL DEFAULT NULL COMMENT '订单编号',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `shipping_id` int(11) NULL DEFAULT NULL COMMENT '关联的收货地址id',
  `total_payment` int(11) NULL DEFAULT NULL COMMENT '商品总金额,单位是分',
  `real_payment` int(11) NULL DEFAULT NULL COMMENT '实际付款金额,单位是分',
  `payment_type` int(4) NULL DEFAULT NULL COMMENT '支付类型,1-在线支付 2 货到付款',
  `postage` int(10) NULL DEFAULT NULL COMMENT '运费,单位是分',
  `status` tinyint(2) NULL DEFAULT NULL COMMENT '订单状态:0-已取消, 1-未付款，2-已付款，3-已发货，4-交易成功，5-订单删除',
  `payment_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `send_time` datetime(0) NULL DEFAULT NULL COMMENT '发货时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '交易完成时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

CREATE TABLE `wj_order_1`.`t_order_7`  (
  `id` bigint(20) NOT NULL,
  `order_no` bigint(20) NULL DEFAULT NULL COMMENT '订单编号',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `shipping_id` int(11) NULL DEFAULT NULL COMMENT '关联的收货地址id',
  `total_payment` int(11) NULL DEFAULT NULL COMMENT '商品总金额,单位是分',
  `real_payment` int(11) NULL DEFAULT NULL COMMENT '实际付款金额,单位是分',
  `payment_type` int(4) NULL DEFAULT NULL COMMENT '支付类型,1-在线支付 2 货到付款',
  `postage` int(10) NULL DEFAULT NULL COMMENT '运费,单位是分',
  `status` tinyint(2) NULL DEFAULT NULL COMMENT '订单状态:0-已取消, 1-未付款，2-已付款，3-已发货，4-交易成功，5-订单删除',
  `payment_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `send_time` datetime(0) NULL DEFAULT NULL COMMENT '发货时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '交易完成时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

CREATE TABLE `wj_order_1`.`t_order_8`  (
  `id` bigint(20) NOT NULL,
  `order_no` bigint(20) NULL DEFAULT NULL COMMENT '订单编号',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `shipping_id` int(11) NULL DEFAULT NULL COMMENT '关联的收货地址id',
  `total_payment` int(11) NULL DEFAULT NULL COMMENT '商品总金额,单位是分',
  `real_payment` int(11) NULL DEFAULT NULL COMMENT '实际付款金额,单位是分',
  `payment_type` int(4) NULL DEFAULT NULL COMMENT '支付类型,1-在线支付 2 货到付款',
  `postage` int(10) NULL DEFAULT NULL COMMENT '运费,单位是分',
  `status` tinyint(2) NULL DEFAULT NULL COMMENT '订单状态:0-已取消, 1-未付款，2-已付款，3-已发货，4-交易成功，5-订单删除',
  `payment_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `send_time` datetime(0) NULL DEFAULT NULL COMMENT '发货时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '交易完成时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

CREATE TABLE `wj_order_1`.`t_order_9`  (
  `id` bigint(20) NOT NULL,
  `order_no` bigint(20) NULL DEFAULT NULL COMMENT '订单编号',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `shipping_id` int(11) NULL DEFAULT NULL COMMENT '关联的收货地址id',
  `total_payment` int(11) NULL DEFAULT NULL COMMENT '商品总金额,单位是分',
  `real_payment` int(11) NULL DEFAULT NULL COMMENT '实际付款金额,单位是分',
  `payment_type` int(4) NULL DEFAULT NULL COMMENT '支付类型,1-在线支付 2 货到付款',
  `postage` int(10) NULL DEFAULT NULL COMMENT '运费,单位是分',
  `status` tinyint(2) NULL DEFAULT NULL COMMENT '订单状态:0-已取消, 1-未付款，2-已付款，3-已发货，4-交易成功，5-订单删除',
  `payment_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `send_time` datetime(0) NULL DEFAULT NULL COMMENT '发货时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '交易完成时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

CREATE TABLE `wj_order_1`.`t_order_10`  (
  `id` bigint(20) NOT NULL,
  `order_no` bigint(20) NULL DEFAULT NULL COMMENT '订单编号',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `shipping_id` int(11) NULL DEFAULT NULL COMMENT '关联的收货地址id',
  `total_payment` int(11) NULL DEFAULT NULL COMMENT '商品总金额,单位是分',
  `real_payment` int(11) NULL DEFAULT NULL COMMENT '实际付款金额,单位是分',
  `payment_type` int(4) NULL DEFAULT NULL COMMENT '支付类型,1-在线支付 2 货到付款',
  `postage` int(10) NULL DEFAULT NULL COMMENT '运费,单位是分',
  `status` tinyint(2) NULL DEFAULT NULL COMMENT '订单状态:0-已取消, 1-未付款，2-已付款，3-已发货，4-交易成功，5-订单删除',
  `payment_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `send_time` datetime(0) NULL DEFAULT NULL COMMENT '发货时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '交易完成时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

CREATE TABLE `wj_order_1`.`t_order_11`  (
  `id` bigint(20) NOT NULL,
  `order_no` bigint(20) NULL DEFAULT NULL COMMENT '订单编号',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `shipping_id` int(11) NULL DEFAULT NULL COMMENT '关联的收货地址id',
  `total_payment` int(11) NULL DEFAULT NULL COMMENT '商品总金额,单位是分',
  `real_payment` int(11) NULL DEFAULT NULL COMMENT '实际付款金额,单位是分',
  `payment_type` int(4) NULL DEFAULT NULL COMMENT '支付类型,1-在线支付 2 货到付款',
  `postage` int(10) NULL DEFAULT NULL COMMENT '运费,单位是分',
  `status` tinyint(2) NULL DEFAULT NULL COMMENT '订单状态:0-已取消, 1-未付款，2-已付款，3-已发货，4-交易成功，5-订单删除',
  `payment_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `send_time` datetime(0) NULL DEFAULT NULL COMMENT '发货时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '交易完成时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

CREATE TABLE `wj_order_1`.`t_order_12`  (
  `id` bigint(20) NOT NULL,
  `order_no` bigint(20) NULL DEFAULT NULL COMMENT '订单编号',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `shipping_id` int(11) NULL DEFAULT NULL COMMENT '关联的收货地址id',
  `total_payment` int(11) NULL DEFAULT NULL COMMENT '商品总金额,单位是分',
  `real_payment` int(11) NULL DEFAULT NULL COMMENT '实际付款金额,单位是分',
  `payment_type` int(4) NULL DEFAULT NULL COMMENT '支付类型,1-在线支付 2 货到付款',
  `postage` int(10) NULL DEFAULT NULL COMMENT '运费,单位是分',
  `status` tinyint(2) NULL DEFAULT NULL COMMENT '订单状态:0-已取消, 1-未付款，2-已付款，3-已发货，4-交易成功，5-订单删除',
  `payment_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `send_time` datetime(0) NULL DEFAULT NULL COMMENT '发货时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '交易完成时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

CREATE TABLE `wj_order_1`.`t_order_13`  (
  `id` bigint(20) NOT NULL,
  `order_no` bigint(20) NULL DEFAULT NULL COMMENT '订单编号',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `shipping_id` int(11) NULL DEFAULT NULL COMMENT '关联的收货地址id',
  `total_payment` int(11) NULL DEFAULT NULL COMMENT '商品总金额,单位是分',
  `real_payment` int(11) NULL DEFAULT NULL COMMENT '实际付款金额,单位是分',
  `payment_type` int(4) NULL DEFAULT NULL COMMENT '支付类型,1-在线支付 2 货到付款',
  `postage` int(10) NULL DEFAULT NULL COMMENT '运费,单位是分',
  `status` tinyint(2) NULL DEFAULT NULL COMMENT '订单状态:0-已取消, 1-未付款，2-已付款，3-已发货，4-交易成功，5-订单删除',
  `payment_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `send_time` datetime(0) NULL DEFAULT NULL COMMENT '发货时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '交易完成时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

CREATE TABLE `wj_order_1`.`t_order_14`  (
  `id` bigint(20) NOT NULL,
  `order_no` bigint(20) NULL DEFAULT NULL COMMENT '订单编号',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `shipping_id` int(11) NULL DEFAULT NULL COMMENT '关联的收货地址id',
  `total_payment` int(11) NULL DEFAULT NULL COMMENT '商品总金额,单位是分',
  `real_payment` int(11) NULL DEFAULT NULL COMMENT '实际付款金额,单位是分',
  `payment_type` int(4) NULL DEFAULT NULL COMMENT '支付类型,1-在线支付 2 货到付款',
  `postage` int(10) NULL DEFAULT NULL COMMENT '运费,单位是分',
  `status` tinyint(2) NULL DEFAULT NULL COMMENT '订单状态:0-已取消, 1-未付款，2-已付款，3-已发货，4-交易成功，5-订单删除',
  `payment_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `send_time` datetime(0) NULL DEFAULT NULL COMMENT '发货时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '交易完成时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

CREATE TABLE `wj_order_1`.`t_order_15`  (
  `id` bigint(20) NOT NULL,
  `order_no` bigint(20) NULL DEFAULT NULL COMMENT '订单编号',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `shipping_id` int(11) NULL DEFAULT NULL COMMENT '关联的收货地址id',
  `total_payment` int(11) NULL DEFAULT NULL COMMENT '商品总金额,单位是分',
  `real_payment` int(11) NULL DEFAULT NULL COMMENT '实际付款金额,单位是分',
  `payment_type` int(4) NULL DEFAULT NULL COMMENT '支付类型,1-在线支付 2 货到付款',
  `postage` int(10) NULL DEFAULT NULL COMMENT '运费,单位是分',
  `status` tinyint(2) NULL DEFAULT NULL COMMENT '订单状态:0-已取消, 1-未付款，2-已付款，3-已发货，4-交易成功，5-订单删除',
  `payment_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `send_time` datetime(0) NULL DEFAULT NULL COMMENT '发货时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '交易完成时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;