/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.io.StringReader;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Endpoint;
import javax.xml.ws.Provider;
import javax.xml.ws.Service;
import javax.xml.ws.ServiceMode;
import javax.xml.ws.WebServiceProvider;
import javax.xml.ws.http.HTTPBinding;


/**
 *
 * @author tiago.lucas
 */
    @WebServiceProvider
    @ServiceMode(value=Service.Mode.PAYLOAD)
    public class RestFul1 implements Provider<Source> {
        
    @Override
    public Source invoke(Source source) {
         String replyElement = "<p>hello world</p>";
         StreamSource reply = new StreamSource(new StringReader(replyElement));
         return reply;
    }

    public static void main(String args[]) {
       Endpoint e = Endpoint.create(HTTPBinding.HTTP_BINDING,
                                     new RestFul1());
      e.publish("http://127.0.0.1:8084/hello/world");
       // Run forever  e.stop();
    }
}
