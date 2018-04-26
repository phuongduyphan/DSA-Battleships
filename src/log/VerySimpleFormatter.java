package log;

import java.util.logging.LogRecord;
import java.util.logging.SimpleFormatter;

public class VerySimpleFormatter extends SimpleFormatter {
	@Override
	public String format(LogRecord record) {
		return "[" +record.getLevel() + "]" + " " + record.getMessage() + "\r\n";
	}
}
