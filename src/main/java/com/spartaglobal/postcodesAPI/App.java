package com.spartaglobal.postcodesAPI;

import com.spartaglobal.postcodeHTTPClients.SinglePostcodeHTTPService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SinglePostcodeHTTPService singlePostcodeHTTPService = new SinglePostcodeHTTPService("kt36qr");
        singlePostcodeHTTPService.singlePostcodeGetRequest();
        singlePostcodeHTTPService.setSinglePostcodeResponseBody();
        System.out.println(singlePostcodeHTTPService.getSinglePostcodeResponseBody());
        singlePostcodeHTTPService.header();
        singlePostcodeHTTPService.getResponse();
    }
}
