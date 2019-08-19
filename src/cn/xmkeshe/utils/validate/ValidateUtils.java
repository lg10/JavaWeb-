package cn.xmkeshe.utils.validate;

public class ValidateUtils {
    /**
     * <li>判断数据是否为空</li>
     * @param str
     * @return
     */
    public static boolean validateEmpty(String str){
        if(str == null && "".equals(str)){
            return false;
        }
        return true;
    }
}
