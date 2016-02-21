package cn.com.countrygarden.ohome.security.util;

import cn.com.countrygarden.ohome.security.enums.CommonParams;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/**
 * 参数解析
 * Created by xiaobai on 16/2/21.
 */
public class ParamsResolve {

    /**
     * 请求参数是否包含公共参数
     * @param params
     * @return
     */
    public static boolean mapIsContainCommonParams(Map<String,String[]> params){
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
    public static void mapRemoveNull(Map<String,String[]> params){

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
    public static String mapConvertString(Map<String,String[]> params){
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
