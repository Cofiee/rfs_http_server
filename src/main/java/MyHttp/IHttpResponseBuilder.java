package MyHttp;

import java.util.ArrayList;

public interface IHttpResponseBuilder {
    IHttpResponseBuilder setStatus(HttpResponse.HttpStatus httpStatus);
    IHttpResponseBuilder setHeaders(ArrayList<String> httpHeaders);
    IHttpResponseBuilder setBody(ArrayList<String> httpBody);
    HttpResponse build();
}
