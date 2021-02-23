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

    public ForeachContextProxy(Context context, String item, String newItem) {
        super(context.getData());
        this.sourceContext = context;
        this.item = item;
        this.newItem = newItem;
    }

    @Override
    public void appendSql(String text) {
        //foreach标签中的文本节点解析 #{item}
        TokenParser tokenParser = new TokenParser("#{", "}", new TokenHandler() {
            @Override
            public String handleToken(String content) {
                //item替换成自己的变量名: __foreach_变量名_1   __foreach_变量名_2   __foreach_变量名_3 ......
                String replace = RegexUtil.replace(content, item, newItem);
                StringBuilder builder = new StringBuilder();
                return builder.append("#{").append(replace).append("}").toString();
            }
        });

        String parse = tokenParser.parse(text);
        sourceContext.appendSql(parse);
    }
}
