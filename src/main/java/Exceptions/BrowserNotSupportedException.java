package Exceptions;

public class BrowserNotSupportedException extends IllegalStateException {
    public BrowserNotSupportedException(String browser) {
        super(String.format("Browser not supported: %s. Consider to change value to: chrome, firefox, edge, ie or safari", browser));
    }
}
