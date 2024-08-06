package pro.gravit.launchermodules.guard;

import pro.gravit.launcher.base.Launcher;
import pro.gravit.launcher.core.LauncherInject;
import pro.gravit.utils.helper.JVMHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Config {
    @LauncherInject(value = "modules.launcherguard.files")
    public Map<String, List<String>> files;
    @LauncherInject(value = "modules.launcherguard.exefile")
    public Map<String, String> exeFile;
    @LauncherInject(value = "modules.launcherguard.renameexefile")
    public boolean renameExeFile;
    @LauncherInject(value = "modules.launcherguard.useclasspathproperty")
    public boolean useClasspathProperty;
    @LauncherInject(value = "modules.launcherguard.protectlauncher")
    public boolean protectLauncher;
    @LauncherInject(value = "modules.launcherguard.nativeagent")
    public Map<String, String> nativeAgent;

    public static Object getDefault() {
        Config config = new Config();
        config.files = new HashMap<>();
        config.exeFile = new HashMap<>();
        config.nativeAgent = new HashMap<>();
        List<String> windowsFiles = new ArrayList<>();
        windowsFiles.add("GravitGuard2.exe");
        windowsFiles.add("GuardDLL.dll");
        config.files.put(Launcher.makeSpecialGuardDirName(JVMHelper.ARCH.X86_64, JVMHelper.OS.MUSTDIE), windowsFiles);
        config.files.put(Launcher.makeSpecialGuardDirName(JVMHelper.ARCH.X86, JVMHelper.OS.MUSTDIE), windowsFiles);
        config.exeFile.put(Launcher.makeSpecialGuardDirName(JVMHelper.ARCH.X86_64, JVMHelper.OS.MUSTDIE), "GravitGuard2.exe");
        config.exeFile.put(Launcher.makeSpecialGuardDirName(JVMHelper.ARCH.X86, JVMHelper.OS.MUSTDIE), "GravitGuard2.exe");
        config.nativeAgent.put(Launcher.makeSpecialGuardDirName(JVMHelper.ARCH.X86_64, JVMHelper.OS.MUSTDIE), "GuardDLL");
        config.nativeAgent.put(Launcher.makeSpecialGuardDirName(JVMHelper.ARCH.X86, JVMHelper.OS.MUSTDIE), "GuardDLL");
        config.renameExeFile = true;
        config.useClasspathProperty = true;
        config.protectLauncher = false;
        return config;
    }
}
