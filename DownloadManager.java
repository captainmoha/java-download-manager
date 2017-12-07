import java.io.*;
import java.net.*;
import java.util.Scanner;


public class DownloadManager {


    public static void main(String[] args) throws Exception{

        System.out.println("Enter Url of file to download");
        Scanner in = new Scanner(System.in);
        String url = in.nextLine();

        download(url);
    }


    public static void download(String urlStr) throws Exception{

        OutputStream out = null;
        URLConnection conn = null;
        InputStream in = null;

        URL url = new URL(urlStr);
        out = new BufferedOutputStream(new FileOutputStream(getFileName(url)));
        conn = url.openConnection();
        in = conn.getInputStream();
        byte[] buffer = new byte[1024];

        int numRead;
        long numWritten = 0;

        while ((numRead = in.read(buffer)) != -1) {
            out.write(buffer, 0, numRead);
            numWritten += numRead;
        }

    }

    public static String getFileName(URL url) {

        String fileName = url.getFile();
    
        return fileName.substring(fileName.lastIndexOf('/') + 1);

    } 
}

