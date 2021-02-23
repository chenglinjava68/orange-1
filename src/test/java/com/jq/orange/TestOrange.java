package com.jq.orange;

import com.jq.orange.engine.DynamicSqlEngine;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: orange
 * @description:
 * @author: jiangqiang
 * @create: 2021-02-23 10:19
 **/
public class TestOrange {

    @Test
    public void testForeach() {
        DynamicSqlEngine engine = new DynamicSqlEngine();
        String sql = ("<root><foreach item='its' index='index' collection='list' open='(' separator=',' close=')'> #{its.id }; #{ its . name}</foreach></root>");
        Map<String, Object> map = new HashMap<>();
        map.put("minId", 100);
        map.put("maxId", 500);

        ArrayList<User> arrayList = new ArrayList<>();
        arrayList.add(new User(10, "tom"));
        arrayList.add(new User(11, "jerry"));
        map.put("list", arrayList.toArray());

        SqlMeta sqlMeta = engine.parse(sql, map);
        System.out.println(sqlMeta.getSql());
        sqlMeta.getJdbcParamValues().forEach(System.out::println);
    }
}
