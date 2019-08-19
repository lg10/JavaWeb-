package cn.xmkeshe.utils.md5.test;

import cn.xmkeshe.utils.md5.MD5Code;

public class TestMD5 {
    public static void main(String[] args){
        System.out.println(new MD5Code().getMD5ofStr("{[123456]}"));
    }
}
