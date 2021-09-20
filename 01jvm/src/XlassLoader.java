import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class XlassLoader extends ClassLoader {

    /**
     * xlass 文件后缀
     */
    private static final String XLASS_SUFFIX = ".xlass";

    /**
     * 解码基数
     */
    private static final int DACODE_BASE = 255;


    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        if (!name.endsWith(XLASS_SUFFIX)) return null;
        // 读取xlass文件数据
        byte[] data = getXlassData(name);

        if (data == null) return null;

        Path path = Paths.get(name);
        name = path.getFileName().toString().split("\\.")[0];

        return super.defineClass(name, data, 0, data.length);
    }

    /**
     * 读取xlass文件数据并做解码处理
     * @param name
     * @return
     */
    private byte[] getXlassData(String name) {

        byte[] data = null;
        try {
            data = Files.readAllBytes(Paths.get(name));
            if (data != null) {
                for (int i = 0; i < data.length; i++) {
                    data[i] = (byte) (DACODE_BASE - data[i]);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public static void main(String[] args) throws Exception {
        XlassLoader xlassLoader = new XlassLoader();
        Class<?> aClass = xlassLoader.loadClass("01jvm/Hello.xlass");
        Object instance = aClass.getDeclaredConstructor().newInstance();
        Method hello = aClass.getDeclaredMethod("hello");
        hello.invoke(instance);
    }
}
