package com.shenma.util;

import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
import tk.mybatis.mapper.common.base.insert.InsertMapper;

/**
 * All rights Reserved, Designed By guangfeng.zhou
 *
 * @version V1.0
 * @Project: springboot
 * @Package: com.shenma.util
 * @Description: (用一句话描述该文件做什么)
 * @author: guangfeng.zhou
 * @date: 2017/7/28 16:34
 */
@Repository("mybatisMapper")
public interface MybatisMapper<T> extends Mapper<T>, InsertMapper<T>, MySqlMapper<T> {
}
