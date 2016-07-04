package com.garrytrue.cleanarhitecturegitapi.model;

import com.garrytrue.cleanarhitecturegitapi.api.ApiInterface;
import com.garrytrue.cleanarhitecturegitapi.helpers.BaseTest;
import com.garrytrue.cleanarhitecturegitapi.model.data.dto.BranchDTO;
import com.garrytrue.cleanarhitecturegitapi.model.data.dto.RepositoryDTO;
import com.garrytrue.cleanarhitecturegitapi.utils.TestConstant;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.observers.TestSubscriber;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by tiv on 30.06.2016.
 */
public class ModelTestImpl extends BaseTest {
    @Inject
    protected ApiInterface apiInterface;

    private Model model;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        component.inject(this);
        model = new ModelImpl();
    }

    @Test
    public void testGetRepoList() {
        RepositoryDTO[] repositoryDTOs = testUtils.getGson().fromJson(testUtils.readString("resources/json/repos.json"), RepositoryDTO[].class);

        when(apiInterface.getRepositories(TestConstant.TEST_OWNER)).thenReturn(Observable.just(Arrays.asList(repositoryDTOs)));

        TestSubscriber<List<RepositoryDTO>> testSubscriber = new TestSubscriber<>();
        model.getRepoByUser(TestConstant.TEST_OWNER).subscribe(testSubscriber);

        testSubscriber.assertNoErrors();
        testSubscriber.assertValueCount(1);

        List<RepositoryDTO> actual = testSubscriber.getOnNextEvents().get(0);

        assertEquals(7, actual.size());
        assertEquals("Android-Rate", actual.get(0).getName());
        assertEquals("andrey7mel/Android-Rate", actual.get(0).getFullName());
//        assertEquals(26314692, actual.get(0).getId());
    }

    @Test
    public void testGetRepoBranches() {

        BranchDTO[] branchDTOs = testUtils.getGson().fromJson(testUtils.readString("resources/json/branches.json"), BranchDTO[].class);
        testUtils.log(String.valueOf(branchDTOs.length));
        when(apiInterface.getBranches(TestConstant.TEST_OWNER, TestConstant.TEST_REPO)).thenReturn(Observable.just(Arrays.asList(branchDTOs)));

        TestSubscriber<List<BranchDTO>> testSubscriber = new TestSubscriber<>();
        testUtils.log(model.toString());
        model.getRepoBranches(TestConstant.TEST_OWNER, TestConstant.TEST_REPO).subscribe(testSubscriber);

        testSubscriber.assertNoErrors();
        testSubscriber.assertValueCount(1);

        List<BranchDTO> actual = testSubscriber.getOnNextEvents().get(0);

        assertEquals(3, actual.size());
        assertEquals("QuickStart", actual.get(0).getName());
        assertEquals("94870e23f1cfafe7201bf82985b61188f650b245", actual.get(0).getCommit().getSha());

    }

}
