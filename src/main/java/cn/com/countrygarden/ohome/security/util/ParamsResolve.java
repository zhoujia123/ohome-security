package cn.com.countrygarden.ohome.security.util;

import cn.com.countrygarden.ohome.security.enums.CommonParams;
import com.jfinal.kit.HashKit;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 参数解析
 * Created by xiaobai on 16/2/21.
 */
public class ParamsResolve {

    /**
     * 转换
     * @param params
     * @return
     */
    public static Map<String,String> convertMaps(Map<String,String[]> params){
        Set<String> keySet = params.keySet();
        String[] value = null;
        Map<String,String> map = new HashMap<String,String>();
        for (String key:keySet) {
            value = params.get(key);
            if(!isNull(value)){
                map.put(key,value[0]);
            }
        }
        return map;
    }
    /**
     * 请求参数是否包含公共参数
     * @param params
     * @return
     */
    public static boolean mapIsContainCommonParams(Map<String,String> params){
        if(params == null){
            return false;
        }
        CommonParams[] commonParamses = CommonParams.values();
        Object value = null;
        boolean flag = true;
        for (CommonParams key:commonParamses) {
            value = params.get(key.getName());
            //参数必填且为空
            if(key.isRequired() && isNull(value)){
                flag = false;
                break;
            }
        }
        return flag;
    }

    /**
     * 去除map中的值为空的字段
     * @param params
     */
    public static void mapRemoveNull(Map<String,String> params){

        Set<String> keySet = params.keySet();
        Object value = null;
        for (String key:keySet) {
            value = params.get(key);
            if(isNull(value)){
                params.remove(key);
            }
        }
    }

    /**
     * 请求参数排序然后转换成key=value字符串相连接
     * @param params
     * @return
     */
    public static String mapConvertString(Map<String,String> params){
        //移除sign字段
        params.remove("sign");
        Set<String> keySet = params.keySet();
        String[] keys = (String[]) keySet.toArray();
        Arrays.sort(keys);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < keys.length; i++) {
            sb.append(keys[i]).append('=').append(params.get(keys[i]));
        }
        return sb.toString();
    }

    /**
     * 创建md5签名
     * @param params
     */
    public static void createMd5Sign(Map<String,String> params,String secret){
        mapRemoveNull(params);
        String signStr = mapConvertString(params);
        String sign = HashKit.md5(secret+signStr+secret);
        params.put("sign",sign);
    }
    /**
     * 判断对象是否为空
     * @param o
     * @return
     */
    public static boolean isNull(Object o){

        if(o == null){
            return true;
        } else {
          if(o instanceof String){
              return "".equals(o.toString());
          }else if (o instanceof String[]){
              if(((String[]) o).length <= 0){
                  return true;
              }else{
                  for (String v:(String[]) o) {
                      //有一个不为空
                      if(!"".equals(v)){
                          return false;
                      }
                  }
                  return true;
              }
          }
          else {
              return false;
          }
        }

    }

}
