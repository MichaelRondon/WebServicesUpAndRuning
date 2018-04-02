package predictions.predictions3;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author Michael Felipe Rondón Acosta
 */
@ApplicationPath("/resourcesP")
public class RestfulPrediction extends Application {

    public Set<Class<?>> getClasses() {
        Set<Class<?>> set = new HashSet<Class<?>>();
        set.add(PredictionsRS.class);
        return set;
    }
}
