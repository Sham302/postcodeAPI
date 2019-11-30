package com.spartaglobal.postcodeHTTPClients;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.swing.text.html.parser.Entity;
import java.io.Closeable;
import java.io.IOException;

public class SinglePostcodeHTTPService {
    //API URL management
    private String baseURL = "https://api.postcodes.io";
    private String singlePostcodesEndpoint = "/postcodes/";
    //API URL management end

    //manage constructor postcode data
    private String postcode;
    //End

    //Capture full response from get request
    private CloseableHttpResponse singlePostcodeResponse;
    //End

    //accessing the body of the http response
    private String singlePostcodeResponseBody;
    //end

    //constructor
    public SinglePostcodeHTTPService(String postcode) {
       this.postcode = postcode;
    }

    //making the full request and sending the response to the closeablehttpresponse
    public void singlePostcodeGetRequest(){
        //Create the HTTP Client
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        // Instantiating the Get Request - ie set up the get request object
        HttpGet getSinglePostcode = new HttpGet(baseURL + singlePostcodesEndpoint + postcode);
        //execute the call
        try {
           singlePostcodeResponse = closeableHttpClient.execute(getSinglePostcode);
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    //set the body variable with the JSON details as String
    public void setSinglePostcodeResponseBody(){

        try {
            //entityutils provide tools to be able to access http body message from responses
            // we have se the body to string we need to plan how to transfer this to JSON
            singlePostcodeResponseBody = EntityUtils.toString(singlePostcodeResponse.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public String getSinglePostcodeResponseBody(){
        return singlePostcodeResponseBody;

    }

    public void header(){
        for(Object item: singlePostcodeResponse.getAllHeaders())
        singlePostcodeResponse.getAllHeaders();
    }

    public void getResponse(){
        System.out.println(singlePostcodeResponse.getStatusLine());
    }
}


