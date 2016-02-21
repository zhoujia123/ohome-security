package cn.com.countrygarden.ohome.security.sign;

import com.jfinal.kit.HashKit;

/**
 * Created by xiaobai on 16/2/21.
 */
public class DefaultHashSign implements IHashSign {

    @Override
    public boolean validSign(String signStr, String encStr, String hashMethod, String secret) {
        String result = HashKit.hash(hashMethod, secret + encStr + secret);
        return signStr.equals(result);
    }
}
