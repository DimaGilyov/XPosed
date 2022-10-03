package kz.xposed;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
import de.robv.android.xposed.XposedBridge;

import kz.xposed.patcher.Patcher;
import kz.xposed.patcher.getmega.GetMegaPatcher;
import kz.xposed.patcher.getmega.TestApkPatcher;

public class Hook implements IXposedHookLoadPackage {

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) {
        XposedBridge.log("Loaded app: " + lpparam.packageName);
        Patcher patcher = CreatePatcherFactory(lpparam.packageName);
        if (patcher != null) {
            patcher.patch(lpparam);
        }
    }

    private Patcher CreatePatcherFactory(String packageName) {
        if ("com.example.android.testapk".equals(packageName)) {
            return new TestApkPatcher();
        } else if (packageName.equals("com.mega.app")) {
            return new GetMegaPatcher();
        }

        return null;
    }
}
