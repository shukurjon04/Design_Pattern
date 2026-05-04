package singleton;

public class ClickConfig {
    private static volatile ClickConfig instance;

    private final String  apiUrl;
    private final String  secretKey;
    private final int     timeoutSeconds;
    private final int     maxRetryCount;
    private final double  minPaymentAmount;
    private final double  maxPaymentAmount;

    private ClickConfig() {
        // Haqiqiy loyihada application.properties dan o'qiladi
        this.apiUrl           = "https://api.click.uz/v2";
        this.secretKey        = "click_secret_key_2024";
        this.timeoutSeconds   = 30;
        this.maxRetryCount    = 3;
        this.minPaymentAmount = 1000.0;
        this.maxPaymentAmount = 50_000_000.0;

        System.out.println("[CONFIG] Sozlamalar yuklandi.");
    }

    public static ClickConfig getInstance() {
        if (instance == null) {
            synchronized (ClickConfig.class) {
                if (instance == null) {
                    instance = new ClickConfig();
                }
            }
        }
        return instance;
    }

    public String  getApiUrl()           { return apiUrl; }
    public String  getSecretKey()        { return secretKey; }
    public int     getTimeoutSeconds()   { return timeoutSeconds; }
    public int     getMaxRetryCount()    { return maxRetryCount; }
    public double  getMinPaymentAmount() { return minPaymentAmount; }
    public double  getMaxPaymentAmount() { return maxPaymentAmount; }
}
