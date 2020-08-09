package com.yjn.crowd;

import com.yjn.crowd.mapper.MemberMapper;
import com.yjn.crowd.po.MemberPo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author: yjn
 * @Date: 2020/7/19 10:41
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisTest {

    @Autowired
    private DataSource dataSource;

    @Autowired(required = false)
    private MemberMapper memberMapper;

    @Test
    public void testDao(){
        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        String encode = passwordEncoder.encode("123");
        MemberPo memberPo=new MemberPo(null, "zs", encode,"张三","zs@qq.com",1 , 1, "张三", "123123", 2);
        memberMapper.insert(memberPo);
    }

    @Test
    public void getConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println(connection.toString());
    }
}
