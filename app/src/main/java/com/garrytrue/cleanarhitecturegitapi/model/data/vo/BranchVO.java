package com.garrytrue.cleanarhitecturegitapi.model.data.vo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by garrytrue on 25.06.16.
 */
public class BranchVO implements Parcelable {
    private String branchName;

    public BranchVO(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchName() {
        return branchName;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.branchName);
    }

    protected BranchVO(Parcel in) {
        this.branchName = in.readString();
    }

    public static final Parcelable.Creator<BranchVO> CREATOR = new Parcelable.Creator<BranchVO>() {
        @Override
        public BranchVO createFromParcel(Parcel source) {
            return new BranchVO(source);
        }

        @Override
        public BranchVO[] newArray(int size) {
            return new BranchVO[size];
        }
    };
}
