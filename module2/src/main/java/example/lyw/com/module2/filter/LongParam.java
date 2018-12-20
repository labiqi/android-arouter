package example.lyw.com.module2.filter;

import android.os.Bundle;


/**
 * @author Liuyewu
 * @date 2018/11/27
 */
public class LongParam {
    private Bundle bundle;
    private boolean isUseAll;

    public LongParam(Bundle bundle, boolean isUseAll) {
        this.bundle = bundle;
        this.isUseAll = isUseAll;
    }
    public LongParam(Bundle bundle) {
        this.bundle = bundle;
        this.isUseAll = true;
    }
    public LongParam() {
        this.bundle = null;
        this.isUseAll = false;
    }

    public Bundle getBundle() {
        return bundle;
    }

    public void setBundle(Bundle bundle) {
        this.bundle = bundle;
    }

    public boolean isUseAll() {
        return isUseAll;
    }

    public void setUseAll(boolean useAll) {
        isUseAll = useAll;
    }

//    protected LongParam(Parcel in) {
//        bundle = in.readPersistableBundle();
//        isUseAll = in.readBoolean();
//    }
//
//    @Override
//    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeParcelable(bundle,);
//        dest.writeInt(id);
//    }
//
//    @Override
//    public int describeContents() {
//        return 0;
//    }
//
//    public static final Creator<LongParam> CREATOR = new Creator<LongParam>() {
//        @Override
//        public LongParam createFromParcel(Parcel in) {
//            return new LongParam(in);
//        }
//
//        @Override
//        public LongParam[] newArray(int size) {
//            return new LongParam[size];
//        }
//    };
}
