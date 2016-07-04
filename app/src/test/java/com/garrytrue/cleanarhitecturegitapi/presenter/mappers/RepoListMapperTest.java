package com.garrytrue.cleanarhitecturegitapi.presenter.mappers;


import com.garrytrue.cleanarhitecturegitapi.helpers.BaseTest;
import com.garrytrue.cleanarhitecturegitapi.mappers.RepositoryDTOtoVO;
import com.garrytrue.cleanarhitecturegitapi.model.data.dto.RepositoryDTO;
import com.garrytrue.cleanarhitecturegitapi.model.data.vo.RepositoryVO;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;

public class RepoListMapperTest extends BaseTest {

    @Inject
    protected RepositoryDTOtoVO repoListMapper;

    private List<RepositoryDTO> repositoryDTOs;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        component.inject(this);
        RepositoryDTO[] repositoryDTOArray = testUtils.getGson().fromJson(testUtils.readString("resources/json/repos.json"), RepositoryDTO[].class);
        repositoryDTOs = Arrays.asList(repositoryDTOArray);

    }

    @Test
    public void testCall() throws Exception {
        List<RepositoryVO> repositoryList = repoListMapper.call(repositoryDTOs);

        assertEquals(7, repositoryList.size());

        assertEquals("Android-Rate", repositoryList.get(0).getRepoName());
        assertEquals("andrey7mel", repositoryList.get(0).getOwnerName());

        assertEquals("utils", repositoryList.get(6).getRepoName());
        assertEquals("andrey7mel", repositoryList.get(6).getOwnerName());
    }
}