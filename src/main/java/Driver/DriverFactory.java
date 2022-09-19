package Driver;

public class DriverFactory {
    public static DriverManager getManager() {
        DriverManager driverManager = null;

        switch (getBrowserType()) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case FIREFOX:
                driverManager = new FireFoxDriverManager();
                break;
            case IE:
                break;
            case SAFARI:
            default:
//                driverManager = new EdgeDriverManager();
                break;
        }
        return driverManager;
    }

    private static Browser getBrowserType() {
        String browserType = System.getProperty("browserName");
        return switch (browserType) {
            case "chrome" -> Browser.CHROME;
            case "firefox" -> Browser.FIREFOX;
            case "ie" -> Browser.IE;
            case "safari" -> Browser.SAFARI;
            default -> Browser.EDGE;
        };
    }
}
