package vcu.blademonitor.logging;

import java.text.MessageFormat;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Logger implementation.
 */
public final class Log {

	/**
	 * Create logger for particular class.
	 * 
	 * @param clazz
	 *            class for which the logger should be created
	 * @return logger
	 */
	public static Log instance(Class<?> clazz) {
		return new Log(Logger.getLogger(clazz));
	}

	/**
	 * Create logger for class from which this method was invoked.
	 * 
	 * @return logger
	 */
	public static Log instance() {
		try {
			StackTraceElement[] st = Thread.currentThread().getStackTrace();
			return instance(Class.forName(st[2].getClassName()));
		} catch (ClassNotFoundException e) {
			throw new LogInitializationException(e);
		}
	}

	/**
	 * Instance of the log4j logger (delegate).
	 */
	private final Logger logger;

	private Log(Logger logger) {
		this.logger = logger;
	}

	public void debug(String message, Object... params) {
		if (logger.isEnabledFor(Level.DEBUG)) {
			logger.debug(MessageFormat.format(message, params));
		}
	}

	public void debug(String message, Throwable throwable, Object... params) {
		if (logger.isEnabledFor(Level.DEBUG)) {
			logger.debug(MessageFormat.format(message, params), throwable);
		}
	}

	public void info(String message, Object... params) {
		if (logger.isEnabledFor(Level.INFO)) {
			logger.info(MessageFormat.format(message, params));
		}
	}

	public void info(String message, Throwable throwable, Object... params) {
		if (logger.isEnabledFor(Level.INFO)) {
			logger.info(MessageFormat.format(message, params), throwable);
		}
	}

	public void warn(String message, Object... params) {
		if (logger.isEnabledFor(Level.WARN)) {
			logger.warn(MessageFormat.format(message, params));
		}
	}

	public void warn(String message, Throwable throwable, Object... params) {
		if (logger.isEnabledFor(Level.WARN)) {
			logger.warn(MessageFormat.format(message, params), throwable);
		}
	}

	public void error(String message, Object... params) {
		if (logger.isEnabledFor(Level.ERROR)) {
			logger.error(MessageFormat.format(message, params));
		}
	}

	public void error(String message, Throwable throwable, Object... params) {
		if (logger.isEnabledFor(Level.ERROR)) {
			logger.error(MessageFormat.format(message, params), throwable);
		}
	}

}
