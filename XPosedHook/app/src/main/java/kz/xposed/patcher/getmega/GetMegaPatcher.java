package kz.xposed.patcher.getmega;

import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import kz.xposed.patcher.Patcher;

public class GetMegaPatcher implements Patcher {

    @Override
    public void patch(XC_LoadPackage.LoadPackageParam lpparam) {
        XposedBridge.log("[GetMegaPatcher] (patch): " + lpparam.packageName);
    }
}
