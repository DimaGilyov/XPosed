package kz.xposed.patcher.getmega;

import android.util.Log;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import kz.xposed.patcher.Patcher;

public class GetMegaPatcher implements Patcher {
    private static final String TAG = "GetMegaPatcher";
    @Override
    public void patch(XC_LoadPackage.LoadPackageParam lpparam) {
        XposedBridge.log("patch() -> " + lpparam.packageName);
        SetNonRootedStateOnDevice(lpparam);
    }

    private void SetNonRootedStateOnDevice(XC_LoadPackage.LoadPackageParam lpparam) {
        final Class<?> RootBeerClass = XposedHelpers.findClass("com.mega.app.fairplay.rootcheck.Root", lpparam.classLoader);
        XposedHelpers.findAndHookMethod(RootBeerClass, "a","android.content.Context", new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                try {
                    Log.d(TAG, "SetNonRootedStateOnDevice");
                    param.setResult(false);
                } catch (Exception ex) {
                    Log.e(TAG, ex.toString());
                }
            }
        });
    }
}
