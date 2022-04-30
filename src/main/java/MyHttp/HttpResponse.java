package MyHttp;

import java.util.ArrayList;

public class HttpResponse {
    HttpStatus status;
    ArrayList<String> headers;
    ArrayList<String> body;

    private HttpResponse(HttpStatus status, ArrayList<String> headers, ArrayList<String> body){
        this.status = status;
        this.headers = headers;
        this.body = body;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public int getStatusCode(){
        return status.getCode();
    }

    public ArrayList<String> getHeaders() {
        return headers;
    }

    public ArrayList<String> getBody() {
        return body;
    }

    public enum HttpStatus {
        OK(200),
        CREATED(201),
        ACCEPTED(202),
        BAD_REQUEST(400),
        NOT_FOUND(404),
        INTERNAL_SERVER_ERROR(500);

        private final int code;

        HttpStatus(int i) {
            code = i;
        }
        public int getCode(){
            return code;
        }
    }

    public static final class HttpResponseBuilder implements IHttpResponseBuilder {
        HttpStatus status;
        ArrayList<String> headers;
        ArrayList<String> body;

        public HttpResponseBuilder(){
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            headers = new ArrayList<>();
            body = new ArrayList<>();
        }

        @Override
        public IHttpResponseBuilder setStatus(HttpStatus httpStatus) {
            status = httpStatus;
            return this;
        }

        @Override
        public IHttpResponseBuilder setHeaders(ArrayList<String> httpHeaders) {
            headers = httpHeaders;
            return this;
        }

        @Override
        public IHttpResponseBuilder setBody(ArrayList<String> httpBody) {
            body = httpBody;
            return this;
        }

        @Override
        public HttpResponse build() {
            return new HttpResponse(this.status, this.headers, this.body);
        }
    }
}
