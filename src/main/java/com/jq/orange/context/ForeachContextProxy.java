package com.jq.orange.context;

import com.jq.orange.token.TokenHandler;
import com.jq.orange.token.TokenParser;
import com.jq.orange.util.RegexUtil;

/**
 * 我只是一个Context的代理，真正对sql和参数的操作，还是用我保存的原始Context (sourceContext) 来执行
 *
 * @program: orange
 * @description:
 * @author: jiangqiang
 * @create: 2021-02-23 15:56
 **/
public class ForeachContextProxy extends Context {

    Context sourceContext;
    String item;
    String newItem;
    String index;
    String newIndex;

    public ForeachContextProxy(Context context, String item, String newItem, String index, String newIndex) {
        super(context.getData());
        this.sourceContext = context;
        this.item = item;
        this.newItem = newItem;
        this.index = index;
        this.newIndex = newIndex;
    }

    @Override
    public void appendSql(String text) {
        //foreach标签中的文本节点解析 #{item.xxx}或者 #{index}
        TokenParser tokenParser = new TokenParser("#{", "}", new TokenHandler() {
            @Override
            public String handleToken(String content) {
                //item替换成自己的变量名: item[0]  item[1] item[2] ......
                String replace = RegexUtil.replace(content, item, newItem);
                if (replace.equals(content))
                    //index替换成自己的变量名: __index_xxx[0]  __index_xxx[1] __index_xxx[2] ......
                    replace = RegexUtil.replace(content, index, newIndex);
                StringBuilder builder = new StringBuilder();
                return builder.append("#{").append(replace).append("}").toString();
            }
        });

        String parse = tokenParser.parse(text);
        sourceContext.appendSql(parse);
    }
}
