package com.jq.orange.node;

import com.jq.orange.context.Context;
import com.jq.orange.context.ForeachContextProxy;
import com.jq.orange.util.OgnlUtil;

import java.util.ArrayList;

/**
 * @program: orange
 * @description:
 * @author: jiangqiang
 * @create: 2021-02-22 16:20
 **/
public class ForeachSqlNode implements SqlNode {

    String collection;
    String open;
    String close;
    String separator;
    String item;
    String index;

    SqlNode contents;

    public ForeachSqlNode(String collection, String open, String close, String separator, String item, String index, SqlNode contents) {
        this.collection = collection;
        this.open = open;
        this.close = close;
        this.separator = separator;
        this.item = item;
        this.index = index;
        this.contents = contents;
    }

    @Override
    public void apply(Context context) {
        Iterable<?> iterable = OgnlUtil.getIterable(collection, context.getData());
        int currentIndex = 0;

        ArrayList<Integer> indexs = new ArrayList<>();
        String indexDataName = String.format("__index_%s", collection);
        context.getData().put(indexDataName, indexs);
        context.appendSql(open);

        for (Object o : iterable) {

            ((ArrayList<Integer>) context.getData().get(indexDataName)).add(currentIndex);

            //不是第一次，需要拼接分隔符
            if (currentIndex != 0) {
                context.appendSql(separator);
            }

            String newItem = String.format("%s[%d]", collection, currentIndex);  //ognl可以直接获取  aaa[0]  形式的值
            String newIndex = String.format("%s[%d]", indexDataName, currentIndex);  //ognl可以直接获取  aaa[0]  形式的值

//            String newItem = Constans.prefix + collection + "_" + currentIndex;
//            context.getData().put(newItem, o);

            // 创建代理context对象，主要是为了TextSqlNode解析调用appendSql方法的时候，可以使用代理对象复写的appendSql方法，
            // 也就是append之前解析 #{item.xxx} 转化成 #{item[index].xxx}
            ForeachContextProxy contextProxy = new ForeachContextProxy(context, item, newItem, index, newIndex);
            contents.apply(contextProxy);
            currentIndex++;
        }

        context.appendSql(close);

    }

}
