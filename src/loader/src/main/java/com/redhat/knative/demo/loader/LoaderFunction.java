import org.jboss.logging.Logger;

import io.quarkus.funqy.Context;
import io.quarkus.funqy.Funq;
import io.quarkus.funqy.knative.events.CloudEvent;

public class LoaderFunction {
    private static final Logger log = Logger.getLogger(LoaderFunction.class);

    public static class DispatchedEvent {
        String msg;
    }

    private final static String revisionName = System.getProperty("K_REVISION", "revision-NA");

    @Funq("com.redhat.knative.demo.Dispatched")
    public String load(DispatchedEvent message, @Context CloudEvent event) {
        log.infof("[%s] - Event received with type %s and data: %s\n", revisionName, event.type(), message);
        return "Hello " + message.msg;
    }
}