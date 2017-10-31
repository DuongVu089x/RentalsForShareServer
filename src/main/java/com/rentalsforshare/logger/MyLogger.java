package com.rentalsforshare.logger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

// TODO: Auto-generated Javadoc
/**
 * The Class MyLogger.
 */
@Aspect
@Component
public class MyLogger {

    /**  Handle to the log file. */
    private final Log logger = LogFactory.getLog(getClass());

    /**
     * Instantiates a new my logger.
     */
    public MyLogger () {}
    
    @After("execution(* com.rentalsforshare.controller..*.*(..))")
    public void logMethodAccessAfter(JoinPoint joinPoint) {
    	logger.info("*************** Completed: " + joinPoint.getSignature().getName() + " ***************");
    }

    /**
     * Log method access before.
     *
     * @param joinPoint the join point
     */
    @Before("execution(* com.rentalsforshare.controller..*.*(..))")
    public void logMethodAccessBefore(JoinPoint joinPoint) {
    	logger.info("*************** Starting: " + joinPoint.getSignature().getName() + " ***************");
    }
    
    /**
     * Error interceptor.
     *
     * @param joinPoint the join point
     * @param throwEx the throw ex
     */
    @AfterThrowing(pointcut = "execution(* com.rentalsforshare.controller..*.*(..))", throwing = "throwEx")
    public void errorInterceptor(JoinPoint joinPoint, Throwable throwEx) {
        logger.info("*************** Start-Error: " + joinPoint.getSignature().getName() + " ***************");
        StringBuffer strEx = getContentException(throwEx);
        logger.error(strEx);
        logger.info("*************** End-Error: " + joinPoint.getSignature().getName() + " ***************");

    }

	/**
	 * Error token parse.
	 *
	 * @param joinPoint the join point
	 * @param throwEx the throw ex
	 */
	@AfterThrowing(pointcut = "execution(* com.rentalsforshare.config..*.*(..))", throwing = "throwEx")
	public void errorTokenParse(JoinPoint joinPoint, Throwable throwEx) {
		logger.info("*************** Start Parse Token Error ***************");
		StringBuffer strEx = getContentException(throwEx);
		logger.error(strEx);
		logger.info("*************** End Parse Token Error ***************");
	}

    /**
     * Gets the content exception.
     *
     * @param throwEx the throw ex
     * @return the content exception
     */
    private static StringBuffer getContentException(Throwable throwEx) {
        StringBuffer strEx = new StringBuffer();
        strEx.append(throwEx);
        strEx.append(System.lineSeparator());

        for (int i = 0; i < throwEx.getStackTrace().length; i++) {
            strEx.append(throwEx.getStackTrace()[i]);
            strEx.append(System.lineSeparator());
        }
        return strEx;
    }
}