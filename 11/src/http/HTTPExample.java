package http;

import java.io.IOException;
import java.net.Authenticator;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import static java.net.http.HttpClient.*;
import static java.net.http.HttpResponse.*;

/**
 * @author : Odinga David
 * @since : 1/18/22, Tue
 */
public class HTTPExample {

    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient client= HttpClient
                .newBuilder()
                .version(Version.HTTP_1_1)
                .connectTimeout(Duration.ofSeconds(5))
                .followRedirects(Redirect.NORMAL)
//                .authenticator(Authenticator.getDefault())
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://foo.com/"))
                .timeout(Duration.ofMinutes(2))
                .GET()
                .build();

      HttpResponse<String> response =  client.send(request, BodyHandlers.ofString());

      System.out.println(response.statusCode());
      System.out.println(response.body());
    }
}
