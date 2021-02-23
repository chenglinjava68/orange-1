package com.jq.orange.node;

import com.jq.orange.context.Context;
import com.jq.orange.context.ForeachContextProxy;
import com.jq.orange.util.Constans;
import com.jq.orange.util.OgnlUtil;

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

        context.appendSql(open);

        for (Object o : iterable) {
            //不是第一次，需要拼接分隔符
            if (currentIndex != 0) {
                context.appendSql(separator);
            }

            String newItem = String.format("%s[%d]", collection, currentIndex);  //ongl可以直接获取  aaa[0]  形式的值
//            String newItem = Constans.prefix + collection + "_" + currentIndex;
//            context.getData().put(newItem, o);
            ForeachContextProxy contextProxy = new ForeachContextProxy(context, item, newItem);
            contents.apply(contextProxy);
            currentIndex++;
        }

        context.appendSql(close);

    }

}
