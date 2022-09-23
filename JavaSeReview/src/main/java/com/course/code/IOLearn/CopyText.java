package com.course.code.IOLearn;

import org.testng.annotations.Test;

import java.io.*;

/**
 * 复习IO流复制文件 读写文件的操作
 */
public class CopyText {

    //基本字符流一次复制一个字节
    @Test
    public void characterOneByte() throws IOException {

        File src = new File("F:\\ideaWorkspace\\AutoTest\\JavaSeReview\\src\\main\\java\\FileDemo\\file1.txt");
        File desc = new File("F:\\ideaWorkspace\\AutoTest\\JavaSeReview\\src\\main\\java\\FileDemo\\copyfile1_characterOneByte.txt");

        FileReader reader = new FileReader(src);
        FileWriter writer = new FileWriter(desc);

        int ch = 0;
        while ((ch= reader.read())!=-1){
            writer.write(ch);

        }
        reader.close();
        writer.close();

    }

    //基本字符流一次读取一个字符数组
    @Test
    public void characterByteArr() throws IOException {
        File src = new File("F:\\ideaWorkspace\\AutoTest\\JavaSeReview\\src\\main\\java\\FileDemo\\file1.txt");
        File desc = new File("F:\\ideaWorkspace\\AutoTest\\JavaSeReview\\src\\main\\java\\FileDemo\\copyfile1_characterByteArr.txt");

        FileReader reader = new FileReader(src);
        FileWriter writer = new FileWriter(desc);

        char [] chars = new char[1024];
        int len = 0;
        while ((len=reader.read(chars)) != -1){
            writer.write(chars,0,len);
        }

        reader.close();
        writer.close();
    }

    //字符缓冲流一次读取一个字符

    @Test
    public void bufferCharacterOneByte() throws IOException {
        File src = new File("F:\\ideaWorkspace\\AutoTest\\JavaSeReview\\src\\main\\java\\FileDemo\\file1.txt");
        File desc = new File("F:\\ideaWorkspace\\AutoTest\\JavaSeReview\\src\\main\\java\\FileDemo\\copyfile1_bufferCharacterOneByte.txt");

        BufferedReader br = new BufferedReader(new FileReader(src));
        BufferedWriter bw = new BufferedWriter(new FileWriter(desc));

        int ch = 0;

        while ((ch= br.read()) != -1){
            bw.write(ch);
        }

        br.close();
        bw.close();
    }

    //字符缓冲流一次读取一个字符数组
    @Test
    public void bufferCharacterByteArr() throws IOException {
        File src = new File("F:\\ideaWorkspace\\AutoTest\\JavaSeReview\\src\\main\\java\\FileDemo\\file1.txt");
        File desc = new File("F:\\ideaWorkspace\\AutoTest\\JavaSeReview\\src\\main\\java\\FileDemo\\copyfile1_bufferCharacterByteArr.txt");

        BufferedReader br = new BufferedReader(new FileReader(src));
        BufferedWriter bw = new BufferedWriter(new FileWriter(desc));

        char[] chars = new char[1024];
        int len = 0;
        while ((len=br.read(chars)) != -1){
            bw.write(chars,0,len);
        }
        br.close();
        bw.close();
    }

    //字符缓冲流一次读取一行字符串
    @Test
    public void bufferCharacterByStrline() throws IOException {
        File src = new File("F:\\ideaWorkspace\\AutoTest\\JavaSeReview\\src\\main\\java\\FileDemo\\file1.txt");
        File desc = new File("F:\\ideaWorkspace\\AutoTest\\JavaSeReview\\src\\main\\java\\FileDemo\\copyfile1_bufferCharacterByStrline.txt");

        BufferedReader br = new BufferedReader(new FileReader(src));
        BufferedWriter bw = new BufferedWriter(new FileWriter(desc));

        String line = null;
        while ((line=br.readLine()) != null){
            bw.write(line);
            bw.newLine();
            bw.flush();

        }
        br.close();
        bw.close();
    }



}
