//package com.base;
//
//import com.github.pagehelper.PageHelper;
//import com.nancy.mapper.UserMapper;
//import org.apache.ibatis.io.Resources;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//import org.junit.Before;
//import org.junit.Test;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.io.Reader;
//import java.util.List;
//import java.util.Map;
//
///**
// * Created by sh00912 on 2017/7/19.
// */
//public class main {
//    private static Logger log = LoggerFactory.getLogger(main.class);
//    private static SqlSessionFactory sqlSessionFactory;
//
//
//    @Before
//    public void setUp() throws Exception {
//        // create a SqlSessionFactory
//        Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
//        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
//        reader.close();
//    }
//
//    @Test
//    public void getUserPageList(){
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        try{
//            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//            log.info("*******************分页查询*************************");
//            PageHelper.startPage(3, 5);
//            List<Map<String, Object>> user = mapper.getUserPageList(50);
////            log.info("当前查询数量： " + user.size() );
////            for(User u: user){
////                System.out.println(u);
////            }
////
////            // 取分页信息
////            log.info("********************取分页信息************************");
////            PageInfo<User> pageInfo = new PageInfo<User>(user);
////            log.info("获取总记录数: " + pageInfo.getTotal());
////            log.info("每一页记录数: " + pageInfo.getPageSize());
////            log.info("当前页数: " + pageInfo.getPageNum());
////            log.info("总页数: " + pageInfo.getPages());
////            log.info("前一页: " + pageInfo.getPrePage());
////            log.info("下一页: " + pageInfo.getNextPage());
////            log.info("是否为第一页: " + pageInfo.isIsFirstPage());
////            log.info("是否为最后一页: " + pageInfo.isIsLastPage());
////            log.info("是否有前一页: " + pageInfo.isHasPreviousPage());
////            log.info("是否有下一页: " + pageInfo.isHasNextPage());
////            log.info("导航页码数: " + pageInfo.getNavigatePages());
////            log.info("所有导航页号: " + pageInfo.getNavigatepageNums());
//        } finally{
//            sqlSession.close();
//            log.info("*******************分页查询结束*************************");
//        }
//    }
//}
