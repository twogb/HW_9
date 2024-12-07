
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class HttpStatusImageDownloader {
    private static HttpStatusChecker checker = new HttpStatusChecker();

    public void downloadStatusImage(int code) throws Exception {
        String imageUrl = checker.getStatusImage(code);

        try (InputStream in = new BufferedInputStream(new URL(imageUrl).openStream());
             FileOutputStream out = new FileOutputStream(code + ".jpg")) {
            byte[] data = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(data, 0, 1024)) != -1) {
                out.write(data, 0, bytesRead);
            }
            System.out.println("Image downloaded as " + code + ".jpg");
        } catch (IOException e) {
            throw new Exception("Error downloading image: " + e.getMessage());
        }
    }
}

