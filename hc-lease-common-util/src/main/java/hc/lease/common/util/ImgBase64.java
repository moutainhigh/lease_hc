package hc.lease.common.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.util.ArrayList;

/**
 * 图片与base64字符串之间的转换
 * Created by tong on 2016/11/7.
 */
public class ImgBase64 {
    public static void main(String[] args) {
        String[] strImg = GetImageStr();
        System.out.println(strImg);
        //GenerateImage(strImg);
        //byteToInputStream(strImg);
    }

    // 图片转化成base64字符串
    public static String[] GetImageStr() {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        String imgFile1 = "C:/Users/Administrator/Desktop/img/ff.jpg";// 待处理的图片
        String imgFile2 = "C:/Users/Administrator/Desktop/img/ff.jpg";// 待处理的图片
        String imgFile3 = "C:/Users/Administrator/Desktop/img/ff.jpg";// 待处理的图片
        String imgFile4 = "C:/Users/Administrator/Desktop/img/ff.jpg";// 待处理的图片
        String imgFile5 = "C:/Users/Administrator/Desktop/img/ff.jpg";// 待处理的图片
        ArrayList<String> objList = new ArrayList<String>();
        objList.add(imgFile1);
        objList.add(imgFile2);
        objList.add(imgFile3);
        objList.add(imgFile4);
        objList.add(imgFile5);

        InputStream in = null;
        byte[] data = null;

        String[] objImg = new String[objList.size()];
        for (int i = 0; i < objList.size(); i++) {

            try {
                // 读取图片字节数组
                in = new FileInputStream(objList.get(i));
                data = new byte[in.available()];

                in.read(data);
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            // 对字节数组Base64编码
            BASE64Encoder encoder = new BASE64Encoder();
            String strEncode = encoder.encode(data);// 返回Base64编码过的字节数组字符串
            objImg[i] = strEncode;

        }

        return objImg;
    }

    // base64字符串转化成图片
    public static boolean GenerateImage(String imgStr) { // 对字节数组字符串进行Base64解码并生成图片
        if (imgStr == null) // 图像数据为空
            return false;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            // Base64解码
            byte[] b = decoder.decodeBuffer(imgStr);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {// 调整异常数据
                    b[i] += 256;
                }
            }
            // 生成jpeg图片
            String imgFilePath = "C:/Users/Administrator/Desktop/img/ff-copy.jpg";// 新生成的图片
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(b);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static File BetyToFile(String filePath) {
        File file = new File(filePath);
        BufferedOutputStream stream = null;
        FileOutputStream fstream = null;
        byte[] data = new byte[(int) file.length()];
        try {
            fstream = new FileOutputStream(file);
            stream = new BufferedOutputStream(fstream);
            stream.write(data);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stream != null) {
                    stream.close();
                }
                if (null != fstream) {
                    fstream.close();
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        return file;
    }

    /**
     * 图片base64转InputStream
     *
     * @param base64string
     * @return
     */
    public static InputStream byteToInputStream(String base64string) {
        ByteArrayInputStream stream = null;
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] bytes1 = decoder.decodeBuffer(base64string);
            stream = new ByteArrayInputStream(bytes1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stream;
    }

}
