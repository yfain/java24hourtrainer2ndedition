package com.lesson34;

import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
 
public class MyFormatter extends Formatter {
 
    @Override
    public String format(LogRecord logRecord) {
        return logRecord.getSourceClassName()+"==>"
                + logRecord.getSourceMethodName()+"==>"
                + logRecord.getMessage()+"\n";
    }
}
