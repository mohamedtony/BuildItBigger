/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.Tony.myapplication.backend;

import com.example.MyClass;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.myapplication.Tony.example.com",
                ownerName = "backend.myapplication.Tony.example.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /**
     * A simple endpoint method that takes a name and says Hi back
     */

   // public MyBean sayHi(@Named("name") String name) {
/*    @ApiMethod(name = "sayHi")
    public MyBean sayHi(){
        MyBean response = new MyBean();

        response.setData(MyClass.getJoke());

        return response;
    }*/

/*    @ApiMethod(name = "getJoke")
    public MyBean getJoke() {
        MyBean response = new MyBean();
        response.setData(MyClass.getJoke());

        return response;
    }*/
    @ApiMethod(name = "sayHi")
    public MyBean sayHi(@Named("name") String name) {
        MyBean response = new MyBean();


        //name=MyClass.getJoke();
        //Here is where you must call the Jokes library to set the data that will be returned to the AsyncTask
        response.setData("Hi, " + MyClass.getJoke());

        return response;
    }
}
