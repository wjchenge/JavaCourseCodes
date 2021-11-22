package io.kimmking.rpcfx.server;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author wj
 * @Date 2021/11/22 12:38
 */
public class ClassUtil {

    /**
     * 对应package下的CLass集合
     */
    private static final Map<String, List<Class<?>>> PACKAGE_CLASS = new HashMap<>();

    /**
     * 获取指定包下的class文件
     * @param packageName 指定的包名
     * @return
     */
    public static List<Class<?>> extractPackageClass(String packageName) {
        if (!PACKAGE_CLASS.containsKey(packageName)) {
            synchronized (RpcfxInvoker.class) {
                if (!PACKAGE_CLASS.containsKey(packageName)) {
                    List<Class<?>> classList = ClassUtil.doExtractPackageClass(packageName);
                    PACKAGE_CLASS.put(packageName, classList);
                }
            }
        }

        return PACKAGE_CLASS.get(packageName);
    }


    /**
     * 扫描加载指定包下的class文件
     * @param packageName 指定的包名
     * @return
     */
    private static List<Class<?>> doExtractPackageClass(String packageName) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URL url = classLoader.getResource(packageName.replace(".", "/"));
        if (url == null) {
            return null;
        } else {
            List<Class<?>> classList = new ArrayList<>();
            if (url.getProtocol().equalsIgnoreCase("file")) {
                File directory = new File(url.getPath());
                ClassUtil.doExtractClassFile(directory, classList, packageName);
            }

            return classList;
        }
    }

    /**
     * 递归加载指定路径下的class文件
     * @param directory 指定的包路径
     * @param classList Class容器
     * @param packageName 包名
     */
    private static void doExtractClassFile(final File directory, final List<Class<?>> classList, final String packageName) {
        if (!directory.isDirectory()) {
            return;
        }
        File[] files = directory.listFiles(file -> {
            if (file.isDirectory()) {
                return true;
            } else {
                String path = file.getAbsolutePath();
                if (path.endsWith(".class")) {
                    ClassUtil.addClassList(path, classList, packageName);
                }
            }
            return false;
        });

        if (files != null) {
            for (File file : files) {
                ClassUtil.doExtractClassFile(file, classList, packageName);
            }
        }

    }

    /**
     * 将Class装载到固定容器中
     * @param path class文件路径
     * @param classList 存在Class对象的容器
     * @param packageName 包名
     */
    private static void addClassList(String path, List<Class<?>> classList, String packageName) {
        path = path.replace(File.separator, ".");
        path = path.substring(path.indexOf(packageName));
        String className = path.substring(0, path.lastIndexOf("."));
        try {
            Class<?> aClass = Class.forName(className);
            classList.add(aClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
