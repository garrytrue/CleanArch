package com.garrytrue.cleanarhitecturegitapi.presenter.mappers;


import com.garrytrue.cleanarhitecturegitapi.helpers.BaseTest;
import com.garrytrue.cleanarhitecturegitapi.mappers.BranchesDTOtoVO;
import com.garrytrue.cleanarhitecturegitapi.model.data.dto.BranchDTO;
import com.garrytrue.cleanarhitecturegitapi.model.data.vo.BranchVO;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;

public class RepoBranchesMapperTest extends BaseTest {

    @Inject
    protected BranchesDTOtoVO branchesMapper;

    private List<BranchDTO> branchDTOs;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        component.inject(this);
        BranchDTO[] branchDTOArray = testUtils.getGson().fromJson(testUtils.readString("resources/json/branches.json"), BranchDTO[].class);
        branchDTOs = Arrays.asList(branchDTOArray);

    }

    @Test
    public void testCall() throws Exception {
        List<BranchVO> branchList = branchesMapper.call(branchDTOs);

        assertEquals(3, branchList.size());
        assertEquals("QuickStart", branchList.get(0).getBranchName());
        assertEquals("gh-pages", branchList.get(1).getBranchName());
        assertEquals("master", branchList.get(2).getBranchName());
    }
}