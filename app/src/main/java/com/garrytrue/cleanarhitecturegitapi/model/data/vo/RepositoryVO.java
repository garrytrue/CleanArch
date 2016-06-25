package com.garrytrue.cleanarhitecturegitapi.model.data.vo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by garrytrue on 25.06.16.
 */
public class RepositoryVO implements Parcelable {
    private String repoName;
    private String ownerName;

    public RepositoryVO(String repoName, String ownerName) {
        this.repoName = repoName;
        this.ownerName = ownerName;
    }

    public String getRepoName() {
        return repoName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.repoName);
        dest.writeString(this.ownerName);
    }


    protected RepositoryVO(Parcel in) {
        this.repoName = in.readString();
        this.ownerName = in.readString();
    }

    public static final Parcelable.Creator<RepositoryVO> CREATOR = new Parcelable.Creator<RepositoryVO>() {
        @Override
        public RepositoryVO createFromParcel(Parcel source) {
            return new RepositoryVO(source);
        }

        @Override
        public RepositoryVO[] newArray(int size) {
            return new RepositoryVO[size];
        }
    };
}
