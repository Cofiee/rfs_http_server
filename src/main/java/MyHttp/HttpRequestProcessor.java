package MyHttp;// chain of responsibility
import MyHttp.Handling.HttpRequestValidationHandler;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.io.IOException;

public class HttpRequestManager {
    private static final Logger logger = LogManager.getLogger(HttpRequestManager.class);
    private final HttpResponse.HttpResponseBuilder responseBuilder = new HttpResponse.HttpResponseBuilder();

    public HttpRequestManager() {

    }

    public HttpResponse processRequest(String request) {
        try {
            HttpRequest httpRequest = new HttpRequest(request);
            HttpRequestValidationHandler validationHandler = new HttpRequestValidationHandler();
            validationHandler.handle(httpRequest, this.responseBuilder);
            return this.responseBuilder.build();
        } catch (IOException exception) {
            return responseBuilder.setStatus(HttpResponse.HttpStatus.BAD_REQUEST).build();
        }
    }
}
