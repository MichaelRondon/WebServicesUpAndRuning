
package predictions;

import java.util.Optional;
import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import predictions.predictions2.PredictionsServlet;

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
        tomcat.addServlet(context, "predictions2", new PredictionsServlet());

        context.addServletMapping("/predictions", "default_");
        context.addServletMapping("/predictions2/*", "predictions2");
        context.addWelcomeFile("predictions.jsp");
        tomcat.start();
        tomcat.getServer().await();
        
    }
}
