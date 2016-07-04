package com.garrytrue.cleanarhitecturegitapi.di;

import com.garrytrue.cleanarhitecturegitapi.di.components.AppComponent;
import com.garrytrue.cleanarhitecturegitapi.di.components.DaggerTestComponent;

/**
 * Created by tiv on 30.06.2016.
 */
public class TestApplication extends CleanArchApp {
    @Override
    protected AppComponent buildAppComponent() {
        return DaggerTestComponent.builder().build();

    }
}
