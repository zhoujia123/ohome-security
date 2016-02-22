package cn.com.countrygarden.ohome.security.conf;

import cn.com.countrygarden.ohome.security.controller.DispatchController;
import cn.com.countrygarden.ohome.security.controller.IndexController;
import cn.com.countrygarden.ohome.security.handlers.CommonParamsHandler;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.wall.WallFilter;
import com.jfinal.config.*;
import com.jfinal.core.JFinal;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.plugin.ehcache.EhCachePlugin;


/**
 * Created by xiaobai on 16/2/21.
 */
public class WebConfig extends JFinalConfig {

    @Override
    public void configConstant(Constants me) {
        loadPropertyFile("application.properties");
        me.setDevMode(getPropertyToBoolean("devMode", false));
        //set log to slf4j
//        Logger.setLoggerFactory(new Slf4jLogFactory());
    }

    @Override
    public void configRoute(Routes me) {
        me.add("/", IndexController.class,"/index");
        me.add("/dispatch", DispatchController.class);
    }

    @Override
    public void configPlugin(Plugins me) {
        //配置druid连接池
        DruidPlugin druidDefault = new DruidPlugin(getProperty("db.url"), getProperty("db.user"), getProperty("db.password"), getProperty("db.driver"));
        // StatFilter提供JDBC层的统计信息
        druidDefault.addFilter(new StatFilter());
        // WallFilter的功能是防御SQL注入攻击
        WallFilter wallDefault = new WallFilter();
        wallDefault.setDbType("h2");
        druidDefault.addFilter(wallDefault);

        druidDefault.setInitialSize(getPropertyToInt("db.poolInitialSize"));
        druidDefault.setMaxPoolPreparedStatementPerConnectionSize(getPropertyToInt("db.poolMaxSize"));
        druidDefault.setTimeBetweenConnectErrorMillis(getPropertyToInt("db.connectionTimeoutMillis"));
        me.add(druidDefault);

        ActiveRecordPlugin activeRecordPlugin = new ActiveRecordPlugin(druidDefault);
        activeRecordPlugin.setShowSql(getPropertyToBoolean("devMode", false));
        //添加缓存
        me.add(new EhCachePlugin());
        me.add(activeRecordPlugin);
    }

    @Override
    public void configInterceptor(Interceptors me) {

    }

    @Override
    public void configHandler(Handlers me) {

//        me.add(new CommonParamsHandler());
    }

    public static void main(String[] args) {
        JFinal.start("src/main/WebRoot", 8080, "/", 5);
    }
}
