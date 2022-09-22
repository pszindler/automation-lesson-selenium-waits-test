package Exceptions;

import Driver.BrowserTypes;

public class BrowserNotSupportedException extends IllegalStateException {
    public BrowserNotSupportedException(BrowserTypes browser) {
        super(String.format("Browser not supported: %s", browser));
    }
}
