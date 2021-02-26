# 概述

- orange是一个动态sql引擎，类似mybatis的功能，解析带标签的动态sql，生成?占位符的sql和?对应的参数列表。
- 借鉴了mybatis源码，相当于mybatis中的动态sql解析功能的抽取。
- 支持 if foreach where set trim

# 使用教程
```
<dependency>
    <groupId>com.jq</groupId>
    <artifactId>orange</artifactId>
    <version>1.0</version>
</dependency>
```

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

# 联系作者：
## wechat：
<div style="text-align: center"> 
<img src="https://freakchicken.gitee.io/images/kafkaui/wechat.jpg" width = "30%" />
</div>


## 捐赠：
如果您喜欢此项目，请给捐助作者一杯咖啡
<div style="text-align: center"> 
<img src="https://freakchicken.gitee.io/images/kafkaui/wechatpay.jpg" width = "30%" />
<img src="https://freakchicken.gitee.io/images/kafkaui/alipay.jpg" width = "33%" />
</div>
