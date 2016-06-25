package com.garrytrue.cleanarhitecturegitapi.model.data.vo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by garrytrue on 25.06.16.
 */
public class ContributorVO implements Parcelable {
    private String name;

    public ContributorVO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
    }

    protected ContributorVO(Parcel in) {
        this.name = in.readString();
    }

    public static final Parcelable.Creator<ContributorVO> CREATOR = new Parcelable.Creator<ContributorVO>() {
        @Override
        public ContributorVO createFromParcel(Parcel source) {
            return new ContributorVO(source);
        }

        @Override
        public ContributorVO[] newArray(int size) {
            return new ContributorVO[size];
        }
    };
}
