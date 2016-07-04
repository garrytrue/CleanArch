package com.garrytrue.cleanarhitecturegitapi.api;



import android.util.Log;

import com.garrytrue.cleanarhitecturegitapi.helpers.BaseTest;
import com.garrytrue.cleanarhitecturegitapi.model.data.dto.BranchDTO;
import com.garrytrue.cleanarhitecturegitapi.model.data.dto.ContributorDTO;
import com.garrytrue.cleanarhitecturegitapi.model.data.dto.RepositoryDTO;
import com.garrytrue.cleanarhitecturegitapi.utils.TestConstant;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import okhttp3.HttpUrl;
import okhttp3.mockwebserver.Dispatcher;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import rx.observers.TestSubscriber;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ApiInterfaceTest extends BaseTest {

    private MockWebServer server;
    private ApiInterface apiInterface;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        server = new MockWebServer();
        server.start();
        final Dispatcher dispatcher = new Dispatcher() {

            @Override
            public MockResponse dispatch(RecordedRequest request) throws InterruptedException {

                if (request.getPath().equals("/users/" + TestConstant.TEST_OWNER + "/repos")) {
                    return new MockResponse().setResponseCode(200)
                            .setBody(testUtils.readString("resources/json/repos.json"));
                } else if (request.getPath().equals("/repos/" + TestConstant.TEST_OWNER + "/" + TestConstant.TEST_REPO + "/branches")) {
                    return new MockResponse().setResponseCode(200)
                            .setBody(testUtils.readString("resources/json/branches.json"));
                }/* else if (request.getPath().equals("/repos/" + TestConstant.TEST_OWNER + "/" + TestConstant.TEST_REPO + "/contributors")) {
                    return new MockResponse().setResponseCode(200)
                            .setBody(testUtils.readString("json/contributors.json"));
                }*/
                return new MockResponse().setResponseCode(404);
            }
        };

        server.setDispatcher(dispatcher);
        HttpUrl baseUrl = server.url("/");
        apiInterface = ApiModule.getApiInterface(baseUrl.toString());
    }


    @Test
    public void testGetRepositories() throws Exception {

        TestSubscriber<List<RepositoryDTO>> testSubscriber = new TestSubscriber<>();
        apiInterface.getRepositories(TestConstant.TEST_OWNER).subscribe(testSubscriber);

        testSubscriber.assertNoErrors();
        testSubscriber.assertValueCount(1);

        List<RepositoryDTO> actual = testSubscriber.getOnNextEvents().get(0);

        assertEquals(7, actual.size());
        assertEquals("Android-Rate", actual.get(0).getName());
        assertEquals("andrey7mel/Android-Rate", actual.get(0).getFullName());
//        assertEquals(26314692, actual.get(0).getId());
    }

    @Test
    public void testGetRepositoriesIncorrect() throws Exception {
        try {
            apiInterface.getRepositories("IncorrectRequest").subscribe();
//            fail();
        } catch (Exception expected) {
            System.out.printf(expected.getMessage());
            assertEquals(TestConstant.ERROR_RESPONSE_404, expected.getMessage());
        }
    }

    @Test
    public void testGetBranches() {
        TestSubscriber<List<BranchDTO>> testSubscriber = new TestSubscriber<>();
        apiInterface.getBranches(TestConstant.TEST_OWNER, TestConstant.TEST_REPO).subscribe(testSubscriber);

        testSubscriber.assertNoErrors();
        testSubscriber.assertValueCount(1);

        List<BranchDTO> actual = testSubscriber.getOnNextEvents().get(0);

        assertEquals(3, actual.size());
        assertEquals("QuickStart", actual.get(0).getName());
        assertEquals("94870e23f1cfafe7201bf82985b61188f650b245", actual.get(0).getCommit().getSha());

    }

    @Test
    public void testGetBranchesIncorrect() throws Exception {
        try {
            apiInterface.getContributors("A", "B").subscribe();
            fail();
        } catch (Exception expected) {
            assertEquals(TestConstant.ERROR_RESPONSE_404, expected.getMessage());
        }
    }

    @After
    public void tearDown() throws Exception {
        server.shutdown();
    }
}