package com.course.code.commonFunction;


import com.course.code.java8action.Person;
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

    @Test
    public void testBufferedOutputStream() {

        BufferedOutputStream bfos = null;
        String s = "BufferedOutputStream byte[]";
        byte[] bytes = s.getBytes(StandardCharsets.UTF_8);
        int len = bytes.length;
        try {
            bfos = new BufferedOutputStream(new FileOutputStream(System.getProperty("user.dir") + "\\src\\main\\java\\FileDemo\\BufferedOutputStream.txt"));
            bfos.write(bytes,0,len);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if (bfos != null) {
                try {
                    bfos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }


    }

    @Test
    public void testBufferedInputStream() {
        BufferedInputStream bis = null;

        try {
            bis = new BufferedInputStream(new FileInputStream(new File(System.getProperty("user.dir") +  "\\src\\main\\java\\FileDemo\\BufferedOutputStream.txt")));
            byte[] bys = new byte[1024];
            int len = 0;
            while ((len = bis.read(bys)) != -1) {
                System.out.println(new String(bys, 0, len));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        BufferedInputStream bis1 = null;

        try {
            bis1 = new BufferedInputStream(new FileInputStream(new File(System.getProperty("user.dir") +  "\\src\\main\\java\\FileDemo\\BufferedOutputStream.txt")));
            int len = 0;
            while ((len = bis1.read()) != -1) {
                System.out.print((char) len);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if (bis1 != null) {
                try {
                    bis1.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


    @Test
    public void testFileWriter() {
        FileWriter fw = null;
        String s = "我爱java";

        try {
            fw = new FileWriter(System.getProperty("user.dir") + "\\src\\main\\java\\FileDemo\\FileWriter.txt", true);
            fw.write(s);
            fw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    @Test
    public void testFileReader() {
        FileReader fr = null;
        char[] chs = new char[1024];
        int len = 0;
        try {
            fr = new FileReader(System.getProperty("user.dir") + "\\src\\main\\java\\FileDemo\\FileWriter.txt");
            if ((len = fr.read(chs)) != -1){
                System.out.println(new String(chs, 0, len));
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


    @Test
    public void testBufferedWriter() {
        BufferedWriter bw = null;
        String con = "hello BufferedWriter \r\n新的一行";

        try {
            bw = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "\\src\\main\\java\\FileDemo\\BufferedWriter.txt"));
            bw.write(con);
            bw.newLine();
            bw.write("新的一行");
            bw.write("新的二行");
            bw.newLine();
            bw.write("新的三行");
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


    @Test
    public void testBufferedReader() {
        BufferedReader br = null;
        String line = null;
        try {
            br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\src\\main\\java\\FileDemo\\BufferedWriter.txt"));
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }


        System.out.println("----------------------");
        BufferedReader br1 = null;
        char[] chs = new char[1024];
        int len = 0;
        try {
            br1 = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\src\\main\\java\\FileDemo\\BufferedWriter.txt"));
            while ((len = br1.read(chs)) != -1) {
                System.out.println(new String(chs, 0, len));
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if (br1 != null) {
                try {
                    br1.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }


    }

    /**
     *序列化流
     *         ObjectOutputStream
     *     反序列化流
     *         ObjectInputStream
     *     使用transient关键字声明不需要序列化的成员变量
     */

    @Test
    public void testObjectOutputStream() {
        ObjectOutputStream oos = null;

        try {
            oos = new ObjectOutputStream(new FileOutputStream(System.getProperty("user.dir") + "\\src\\main\\java\\FileDemo\\ObjectOutputStream.txt"));
            Person p = new Person("序列化流",26);
            Person p2 = new Person("序列化流1",27);
            oos.writeObject(p);
            oos.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Test
    public void testObjectInputStream() {
        ObjectInputStream ois = null;

        try {

            ois = new ObjectInputStream(new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\FileDemo\\ObjectOutputStream.txt"));
            Person object = (Person) ois.readObject();
            System.out.println(object);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }










}
