package com.garrytrue.cleanarhitecturegitapi.helpers;

import android.text.TextUtils;

import com.garrytrue.cleanarhitecturegitapi.BuildConfig;
import com.garrytrue.cleanarhitecturegitapi.di.TestApplication;
import com.garrytrue.cleanarhitecturegitapi.di.components.TestComponent;
import com.garrytrue.cleanarhitecturegitapi.utils.TestUtils;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

/**
 * Created by tiv on 30.06.2016.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class,
        application = TestApplication.class,
        sdk = 21)
@Ignore
public class BaseTest {
    public TestComponent component;
    public TestUtils testUtils;

    @Before
    public void setUp() throws Exception {
        component = (TestComponent) TestApplication.getAppComponent();
        testUtils = new TestUtils();
    }
}
