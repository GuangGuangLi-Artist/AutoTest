package com.course.code.commonFunction;


import org.testng.annotations.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class IOReviewTest {


    /**
     *字节流
     * FileInputStream 输入流
     * FileOutputStream 输出流
     *
     * 先写后读，先常规 后buffer
     */
    @Test
    public void testFileOutputStream() {

        String s = "hello FileOutputStream";
        byte[] bytes = s.getBytes(StandardCharsets.UTF_8);
        FileOutputStream fos = null;

        try {
            fos  =  new FileOutputStream(new File(System.getProperty("user.dir") + "\\src\\main\\java\\FileDemo\\FileOutputStream.txt"), true);
            fos.write(bytes);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }


    }

    @Test
    public void testFileInputStream() {
        FileInputStream fis = null;

        try {
            fis = new FileInputStream(new File(System.getProperty("user.dir") + "\\src\\main\\java\\FileDemo\\FileOutputStream.txt"));
            int i = 0;
            byte [] bys = new byte[1024];
            int len = 0;

            while ((len = fis.read(bys)) != -1) {
                System.out.println(new String(bys, 0, len));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        FileInputStream fis1 = null;
        int bys = 0;
        try {
            fis1 =  new FileInputStream(new File(System.getProperty("user.dir") + "\\src\\main\\java\\FileDemo\\FileOutputStream.txt"));
            while ((bys = fis1.read()) != -1) {
                System.out.print((char) bys);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            if (fis1 != null) {
                try {
                    fis1.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }







}
