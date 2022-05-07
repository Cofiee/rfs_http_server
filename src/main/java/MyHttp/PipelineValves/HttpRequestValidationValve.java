package MyHttp.Handling;

import MyHttp.HttpRequest;
import MyHttp.HttpResponse;

public class HttpRequestValidationHandler extends BaseHandler {
    public HttpRequestValidationHandler() {}

    @Override
    public void handle(HttpRequest request, HttpResponse.HttpResponseBuilder responseBuilder) {

        super.handle(request, responseBuilder);
    }

    private void parseRequest(HttpRequest request){

    }
}
