public class HttpStatusChecker {

    public static String getStatusImage(int code) {
        if(!(code >= 100 & code <= 599)) {
            throw new IllegalArgumentException();
        }
        return "https://http.cat/" + code + ".jpg";

    }

}
