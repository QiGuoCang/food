package cn.et.lesson02;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.support.http.StatViewServlet;

@Configuration
public class ConfigBean {
		/**
		 * <bean di="druidStatView" class="cn.xxx.ServletRegistrationBean"/>
		 * 
		 * 
		 * 相当于配置
		 * <servlet>
        <servlet-name>DruidStatView</servlet-name>
        <servlet-class>com.alibaba.druid.support.http.StatViewServlet</servlet-class>
        <init-param>
            <!-- 用户名 -->
            <param-name>loginUsername</param-name>
            <param-value>druid</param-value>
        </init-param>
        <init-param>
            <!-- 密码 -->
            <param-name>loginPassword</param-name>
            <param-value>druid</param-value>
        </init-param>
    </servlet>
    <servlet-mapping>
        <servlet-name>DruidStatView</servlet-name>
        <url-pattern>/druid/*</url-pattern>
    </servlet-mapping>
		 * @return
		 */
	@Bean
	public ServletRegistrationBean druidStatView(){
		ServletRegistrationBean srb = new ServletRegistrationBean();
		srb.setName("DruidStatView");
		StatViewServlet svs = new StatViewServlet();
		srb.setServlet(svs);
		String url="/druid/*";
		List<String>urls = new ArrayList<String>();
		urls.add(url);
		srb.setUrlMappings(urls);
		LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();
		linkedHashMap.put("loginUsername", "admin");
		linkedHashMap.put("loginPassword", "123456");
		srb.setInitParameters(linkedHashMap);
		return srb;
		
	}
}
