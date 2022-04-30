package MyHttp;

public interface IHttpRequestHandler {
    void setNextHandler(IHttpRequestHandler handler);
    void handle(HttpRequest request, HttpResponse.HttpResponseBuilder responseBuilder);
}
