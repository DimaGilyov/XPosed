package kz.xposed.patcher.getmega;

import android.util.Log;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import kz.xposed.patcher.Patcher;

public class TestApkPatcher implements Patcher {

    @Override
    public void patch(XC_LoadPackage.LoadPackageParam lpparam) {
        XposedBridge.log("patch() -> " + lpparam.packageName);
        final Class<?> MainActivityClass = XposedHelpers.findClass("com.example.android.testapk.MainActivity", lpparam.classLoader);
        XposedHelpers.findAndHookMethod(MainActivityClass, "getCount", new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                try {
                    String result = (String) param.getResult();
                    Log.d("getCount", result);
                    param.setResult(result + result);

                } catch (Exception ex) {
                    Log.e("Error", ex.toString());
                }
            }
        });
    }
}
