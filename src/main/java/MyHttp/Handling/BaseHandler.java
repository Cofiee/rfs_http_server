package MyHttp.Handling;

import MyHttp.HttpRequest;
import MyHttp.HttpResponse;
import MyHttp.IHttpRequestHandler;

public class BaseHandler implements IHttpRequestHandler {
    IHttpRequestHandler nextHandler;

    BaseHandler() {}

    @Override
    public void setNextHandler(IHttpRequestHandler handler) {
        this.nextHandler = handler;
    }

    @Override
    public void handle(HttpRequest request, HttpResponse.HttpResponseBuilder responseBuilder) {
        if (this.nextHandler != null)
            nextHandler.handle(request, responseBuilder);
    }
}
