
package predictions;

import java.util.Optional;
import org.apache.catalina.Context;
import org.apache.catalina.servlets.DefaultServlet;
import org.apache.catalina.startup.Tomcat;

public class Main {
    
    public static final Optional<String> port = Optional.ofNullable(System.getenv("PORT"));
    
    public static void main(String[] args) throws Exception {
        String contextPath = "/";
        String appBase = ".";
        Tomcat tomcat = new Tomcat();     
        tomcat.setPort(Integer.valueOf(port.orElse("8080") ));
        tomcat.getHost().setAppBase(appBase);
        Context context = tomcat.addWebapp(contextPath, appBase);
        tomcat.addServlet(context, "default_", new MyServlet());

        context.addServletMapping("/predictions", "default_");
        context.addWelcomeFile("predictions.jsp");
        tomcat.start();
        tomcat.getServer().await();
        
    }
}
