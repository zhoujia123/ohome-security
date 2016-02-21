package cn.com.countrygarden.ohome.security.enums;

/**
 * 公共参数
 * Created by xiaobai on 16/2/21.
 */
public enum CommonParams {
    /**
     * 系统
     */
    SYSTEM("system",true),
    /**
     * 服务名
     */
    METHOD("method",true),
    /**
     * 版本
     */
    VERSION("version",true),
    /**
     * 合作方key
     */
    PRATNER_KEY("partner_key",true),
    /**
     * 时间戳
     */
    TIMESTAMP("timestamp",true),
    /**
     * 随机字符串
     */
    NONCE("nonce",true),
    /**
     * 签名方法(md5,sha)
     */
    SIGN_METHOD("sign_method",true),
    /**
     * 所有除去sign字段的请求参数按照ASCII码排序+partner_secret按照签名方法签名
     */
    SIGN("sign",true);

    /**
     * 字段名
     */
    String name;
    /**
     * 是否必填
     */
    boolean required;

    CommonParams(String name, boolean required) {
        this.name = name;
        this.required = required;
    }

    public String getName() {
        return name;
    }

    public boolean isRequired() {
        return required;
    }

    @Override
    public String toString() {
        return "CommonParams{" +
                "name='" + name + '\'' +
                ", required=" + required +
                '}';
    }
}
