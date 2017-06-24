/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.vpaliy.myapplication.backend;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.vpaliy.joker.JokeProvider;

@Api(
        name = "jokeApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.myapplication.vpaliy.example.com",
                ownerName = "backend.myapplication.vpaliy.example.com",
                packagePath = "")
)
public class JokeEndpoint {

    private static final JokeProvider joker=new JokeProvider();

    @ApiMethod(name = "getJoke")
    public JokeBean provideJoke(){
        JokeBean jokeBean=new JokeBean();
        jokeBean.setJoke(joker.tellJoke());
        return jokeBean;
    }

}
