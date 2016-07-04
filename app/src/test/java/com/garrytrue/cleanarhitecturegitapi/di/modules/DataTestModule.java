package com.garrytrue.cleanarhitecturegitapi.di.modules;


import com.garrytrue.cleanarhitecturegitapi.mappers.BranchesDTOtoVO;
import com.garrytrue.cleanarhitecturegitapi.mappers.ContributorsDTOtoVO;
import com.garrytrue.cleanarhitecturegitapi.mappers.RepositoryDTOtoVO;
import com.garrytrue.cleanarhitecturegitapi.model.data.dto.BranchDTO;
import com.garrytrue.cleanarhitecturegitapi.model.data.dto.ContributorDTO;
import com.garrytrue.cleanarhitecturegitapi.model.data.dto.RepositoryDTO;
import com.garrytrue.cleanarhitecturegitapi.model.data.vo.BranchVO;
import com.garrytrue.cleanarhitecturegitapi.model.data.vo.ContributorVO;
import com.garrytrue.cleanarhitecturegitapi.model.data.vo.RepositoryVO;
import com.garrytrue.cleanarhitecturegitapi.utils.TestConstant;
import com.garrytrue.cleanarhitecturegitapi.utils.TestUtils;

import java.util.Arrays;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DataTestModule {

    private TestUtils testUtils;

    public DataTestModule() {
        testUtils = new TestUtils();
    }

    @Provides
    @Singleton
    TestUtils provideTestUtils() {
        return testUtils;
    }

    @Provides
    @Singleton
    RepositoryVO provideRepository() {
        return new RepositoryVO(TestConstant.TEST_REPO, TestConstant.TEST_OWNER, null);
    }


    @Provides
    @Singleton
    List<ContributorDTO> provideContributorDTOList() {
        ContributorDTO[] contributorDTOArray = testUtils.getGson().fromJson(testUtils.readString("json/contributors.json"), ContributorDTO[].class);
        return Arrays.asList(contributorDTOArray);
    }


    @Provides
    @Singleton
    List<BranchDTO> provideBranchDTOList() {
        BranchDTO[] branchDTOArray = testUtils.getGson().fromJson(testUtils.readString("json/branches.json"), BranchDTO[].class);
        return Arrays.asList(branchDTOArray);
    }

    @Provides
    @Singleton
    List<RepositoryDTO> provideRepositoryDTOList() {
        RepositoryDTO[] repositoryDTOArray = testUtils.getGson().fromJson(testUtils.readString("json/repos.json"), RepositoryDTO[].class);
        return Arrays.asList(repositoryDTOArray);
    }

    @Provides
    @Singleton
    List<RepositoryVO> provideRepositoryList(RepositoryDTOtoVO repoListMapper, List<RepositoryDTO> list) {
        return repoListMapper.call(list);
    }

    @Provides
    @Singleton
    List<ContributorVO> provideContributorList(ContributorsDTOtoVO contributorsMapper, List<ContributorDTO> contributorDTOs) {
        return contributorsMapper.call(contributorDTOs);
    }

    @Provides
    @Singleton
    List<BranchVO> provideBranchList(BranchesDTOtoVO branchesMapper, List<BranchDTO> branchDTOs) {
        return branchesMapper.call(branchDTOs);
    }


}
