package prompter;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.LogRecord;
import java.util.logging.SimpleFormatter;

public class CustoFormatter extends SimpleFormatter {
	
	private static final String format = "%1$s%n";
	
	public CustoFormatter(){
		super();
	}
	
	@Override
	public synchronized String format(LogRecord record) {
		String throwable = "";
        if (record.getThrown() != null) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            pw.println();
            record.getThrown().printStackTrace(pw);
            pw.close();
            throwable = sw.toString();
        }
        return String.format(format,
                             record.getMessage(),
                             throwable);
	}
	
	

}
