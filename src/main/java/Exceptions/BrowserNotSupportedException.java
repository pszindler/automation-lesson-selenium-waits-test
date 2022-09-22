package Exceptions;

import Driver.Browser;

public class BrowserNotSupportedException extends IllegalStateException {
    public BrowserNotSupportedException(Browser browser) {
        super(String.format("Browser not supported: %s", browser));
    }
}
