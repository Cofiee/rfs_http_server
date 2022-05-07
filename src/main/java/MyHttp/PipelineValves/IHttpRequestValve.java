package MyHttp.Handling;

import MyHttp.HttpRequest;
import MyHttp.HttpResponse;

public interface IHttpRequestHandler {
    void setNextHandler(IHttpRequestHandler handler);
    void handle(HttpRequest request, HttpResponse.HttpResponseBuilder responseBuilder);
}
