package cn.com.countrygarden.ohome.security.sign;

/**
 * hash 签名
 * Created by xiaobai on 16/2/21.
 */
public interface IHashSign {

    /**
     * 验证签名
     * @param signStr 请求参数中sign字段值
     * @param encStr 待加密字段
     * @param hashMethod hash方法
     * @param secret  hash-Key
     * @return
     */
    boolean validSign(String signStr,String encStr,String hashMethod,String secret);
}
