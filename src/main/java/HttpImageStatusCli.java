import java.util.Scanner;

public class HttpImageStatusCli {
    private static HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();

    public void askStatus() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter HTTP status code:");

        try {
            String input = scanner.nextLine();
            int statusCode = Integer.parseInt(input);
            try {
                downloader.downloadStatusImage(statusCode);
            } catch (Exception e) {
                System.out.println("There is not image for HTTP status " + statusCode);
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter valid number");
        }
    }

    public static void main(String[] args) {

        HttpImageStatusCli cli = new HttpImageStatusCli();
        cli.askStatus();
    }
}
