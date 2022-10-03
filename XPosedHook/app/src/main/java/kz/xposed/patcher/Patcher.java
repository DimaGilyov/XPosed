package kz.xposed.patcher;

import de.robv.android.xposed.callbacks.XC_LoadPackage;

public interface Patcher {
    void patch(XC_LoadPackage.LoadPackageParam lpparam);
}
