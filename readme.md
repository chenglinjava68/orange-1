# 概述

- orange是一个动态sql引擎，类似mybatis的功能，解析带标签的动态sql，生成?占位符的sql和?对应的参数列表。
- 借鉴了大量mybatis源码，相当于mybatis中的动态sql解析功能的抽取。
- 同时修改了mybatis源码中复杂的对象封装，代码结构更简单、更易读。也是学习mybatis源码的一个不错选择。

# 使用教程
```
    @Test
    public void testForeach() {
        DynamicSqlEngine engine = new DynamicSqlEngine();
        String sql = ("select * from user where name in <foreach collection='list' open='(' separator=',' close=')'>#{item.name}</foreach>");
        Map<String, Object> map = new HashMap<>();


        ArrayList<User> arrayList = new ArrayList<>();
        arrayList.add(new User(10, "tom"));
        arrayList.add(new User(11, "jerry"));
        map.put("list", arrayList);
      
        SqlMeta sqlMeta = engine.parse(sql, map);
        System.out.println(sqlMeta.getSql());
        sqlMeta.getJdbcParamValues().forEach(System.out::println);
    }

```

执行结果：
```
select * from user where name in  ( ? , ? ) 
tom
jerry
```

# 注意
- 目前仅支持 foreach if
- foreach 不支持map类型参数
