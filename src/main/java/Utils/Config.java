package Utils;

public class Config {
    private static final String DEFAULT_BASE_URL = "https://www.google.com/ncr";

    private Config() {
    }

    public static String getBaseUrl() {
        String baseUrl = System.getProperty("base.url");
        return (baseUrl == null || baseUrl.trim().isEmpty()) ? DEFAULT_BASE_URL : baseUrl;
    }
}
