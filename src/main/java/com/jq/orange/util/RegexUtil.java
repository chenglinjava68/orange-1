package com.jq.orange.util;

/**
 * @program: orange
 * @description:
 * @author: jiangqiang
 * @create: 2021-02-23 15:19
 **/
public class RegexUtil {

    public static String replace(String content, String item, String newItem) {
        return content.replaceFirst("^\\s*" + item + "(?![^.,:\\s])", newItem);
    }

    public static void main(String[] args) {
        String replace = replace("  it ? user.id", "it", "list_2");
        System.out.println(replace);
    }
}
