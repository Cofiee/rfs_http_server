package MyHttp;// chain of responsibility
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class HttpRequestManager {
    private static final Logger logger = LogManager.getLogger(HttpRequestManager.class);
    private HttpRequest request;
    private final HttpResponse.HttpResponseBuilder responseBuilder = new HttpResponse.HttpResponseBuilder();

    public HttpRequestManager(HttpRequest request){
        this.request = request;
    }


}
