C:\LDPlayer\LDPlayer4.0\adb shell "mkdir /data/data/xposed.framework.install"
C:\LDPlayer\LDPlayer4.0\adb push xposed-v89-sdk25-x86.zip /data/data/xposed.framework.install/xposed-v89-sdk25-x86.zip
C:\LDPlayer\LDPlayer4.0\adb shell "unzip /data/data/xposed.framework.install/xposed-v89-sdk25-x86.zip -o -q -d /data/data/xposed.framework.install/"
C:\LDPlayer\LDPlayer4.0\adb shell "chmod 777 /data/data/xposed.framework.install/META-INF/com/google/android/flash-script.sh"
C:\LDPlayer\LDPlayer4.0\adb shell "cd /data/data/xposed.framework.install/ && /data/data/xposed.framework.install/META-INF/com/google/android/flash-script.sh"
C:\LDPlayer\LDPlayer4.0\adb shell "am start -W de.robv.android.xposed.installer/.WelcomeActivity"
C:\LDPlayer\LDPlayer4.0\adb shell mkdir /data/data/de.robv.android.xposed.installer/shared_prefs/"
C:\LDPlayer\LDPlayer4.0\adb shell "killapp --index {_config.AccountConfig.LocalBuildIndex} --packagename de.robv.android.xposed.installer"