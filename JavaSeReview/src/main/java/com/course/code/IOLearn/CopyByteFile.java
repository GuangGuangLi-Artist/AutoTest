package com.course.code.IOLearn;


import org.testng.annotations.Test;

import java.io.*;

/**
 * 复习IO流复制文件 读写二进制文件的操作 例如图片
 */
public class CopyByteFile {


    //基本字节流一次读取一个字节

    @Test
    public void byteByOneByte() throws IOException {

        File src = new File("F:\\ideaWorkspace\\AutoTest\\JavaSeReview\\src\\main\\java\\FileByteCopy\\HANGSEED.gif");
        File desc = new File("F:\\ideaWorkspace\\AutoTest\\JavaSeReview\\src\\main\\java\\FileByteCopy\\HANGSEED_byteByOneByte.gif");

        FileInputStream fis = new FileInputStream(src);
        FileOutputStream fos = new FileOutputStream(desc);

        int by =0;
        while ((by=fis.read()) != -1){
            fos.write(by);
        }

        fis.close();
        fos.close();

    }

    //基本字节流一次读取一个字节数组

    @Test
    public void byteByByteArr() throws IOException {

        File src = new File("F:\\ideaWorkspace\\AutoTest\\JavaSeReview\\src\\main\\java\\FileByteCopy\\HANGSEED.gif");
        File desc = new File("F:\\ideaWorkspace\\AutoTest\\JavaSeReview\\src\\main\\java\\FileByteCopy\\HANGSEED_byteByByteArr.gif");

        FileInputStream fis = new FileInputStream(src);
        FileOutputStream fos = new FileOutputStream(desc);

        byte [] bys = new byte[1024];
        int len = 0;
        while ((len=fis.read(bys)) != -1){
            fos.write(bys,0,len);
        }

        fis.close();
        fos.close();
    }

    //字节缓冲流一次读取一个字节

    @Test
    public void bufferByteByOneByte() throws IOException {
        File src = new File("F:\\ideaWorkspace\\AutoTest\\JavaSeReview\\src\\main\\java\\FileByteCopy\\HANGSEED.gif");
        File desc = new File("F:\\ideaWorkspace\\AutoTest\\JavaSeReview\\src\\main\\java\\FileByteCopy\\HANGSEED_bufferByteByOneByte.gif");

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(desc));

        int by = 0;
        while ((by= bis.read()) != -1){
            bos.write(by);
        }

        bis.close();
        bos.close();
    }

    //字节缓冲流一次读取一个字节数组
    @Test
    public void bufferByteByByteArr() throws IOException {
        File src = new File("F:\\ideaWorkspace\\AutoTest\\JavaSeReview\\src\\main\\java\\FileByteCopy\\HANGSEED.gif");
        File desc = new File("F:\\ideaWorkspace\\AutoTest\\JavaSeReview\\src\\main\\java\\FileByteCopy\\HANGSEED_bufferByteByByteArr.gif");

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(desc));

        byte[] bys = new byte[1024];
        int len = 0;
        while ((len=bis.read(bys)) != -1){
            bos.write(bys,0,len);
        }

        bis.close();
        bos.close();

    }


    //测试InputStreamReader、OutputStreamWriter作用
    @Test
    public void testInputStreamReader() throws IOException {
        File src = new File("F:\\ideaWorkspace\\AutoTest\\JavaSeReview\\src\\main\\java\\FileDemo\\file1.txt");
        File desc = new File("F:\\ideaWorkspace\\AutoTest\\JavaSeReview\\src\\main\\java\\FileDemo\\fileNew.txt");

        InputStreamReader isr = new InputStreamReader(new FileInputStream(src));
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(desc));
        int i = 0;
        while ((i = isr.read()) != -1) {
            osw.write(i);
        }

        osw.close();
        isr.close();

    }


}
