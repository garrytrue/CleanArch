package com.garrytrue.cleanarhitecturegitapi.presenter;


import com.garrytrue.cleanarhitecturegitapi.helpers.BaseTest;
import com.garrytrue.cleanarhitecturegitapi.utils.TestConstant;
import com.garrytrue.cleanarhitecturegitapi.view.IRepoView;
import com.garrytrue.cleanarhitecturegitapi.view.IView;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import rx.Subscription;
import rx.observers.TestSubscriber;

import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BasePresenterTest extends BaseTest {

    protected IView view;
    private BasePresenter basePresenter;
//
    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        IRepoView repoListView = mock(IRepoView.class);
        basePresenter = new RepoListPresenter(repoListView);
        view = repoListView;
    }
//
//
    @Test
    public void testShowLoadingState() throws Exception {
        basePresenter.showLoadingState();
        verify(view).showLoading();
    }

    @Test
    public void testHideLoadingState() throws Exception {
        basePresenter.hideLoadingState();
        verify(view).hideLoading();
    }

    @Test
    public void testShowError() throws Exception {
        Throwable throwable = new Throwable(TestConstant.TEST_ERROR);
        basePresenter.showError(throwable);
        verify(view).showError(TestConstant.TEST_ERROR);
    }

    @Test
    public void testAddSubscription() throws Exception {
        Subscription test = new TestSubscriber<>();
        basePresenter.addSubscription(test);
        assertTrue(basePresenter.compositeSubscription.hasSubscriptions());
    }

    @Test
    public void testOnStop() throws Exception {
        Subscription test = new TestSubscriber<>();
        basePresenter.addSubscription(test);
        basePresenter.onStop();
        assertTrue(test.isUnsubscribed());
    }

    @Test
    public void testOnStopManySubscription() throws Exception {
        final int num_subscription = 100;
        ArrayList<Subscription> subscriptionList = new ArrayList<>();

        for (int i = 0; i < num_subscription; i++) {
            Subscription test = new TestSubscriber<>();
            basePresenter.addSubscription(test);
            subscriptionList.add(test);
        }

        basePresenter.onStop();

        for (Subscription subscription : subscriptionList) {
            assertTrue(subscription.isUnsubscribed());
        }
    }
}