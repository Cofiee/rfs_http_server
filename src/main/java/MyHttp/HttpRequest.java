package MyHttp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Hashtable;

public class HttpRequest {
    private Methods _method;
    private String _requestedResource;
    private Hashtable<String, String> _requestHeaders;

    public enum Methods {
        OPTIONS,
        GET,
        POST,
        PUT,
        PATCH,
        DELETE
    }

    public HttpRequest(String request) throws IOException {
        BufferedReader reader = new BufferedReader(new StringReader(request));
        try{
            String line = reader.readLine();
            this.ParseFirstLine(line);
            _requestHeaders = new Hashtable<>();
            while ((line = reader.readLine()) != null) {
                this.ParseHeaderLine(line);
            }
        } catch (IllegalArgumentException exception) {
            throw new IOException();
        }

    }

    private void ParseFirstLine(String firstLine) throws IllegalArgumentException {
        firstLine = firstLine.trim();
        String[] words = firstLine.split("/s*");
        _method = Methods.valueOf(words[0]);
        _requestedResource = words[1];
    }

    private void ParseHeaderLine(String headerLine) throws IllegalArgumentException {
        String[] words = headerLine.split(": ");
        _requestHeaders.put(words[0], words[1]);
    }

}
