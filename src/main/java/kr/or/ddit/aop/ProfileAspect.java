package kr.or.ddit.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



//메서드 실행 전후 시간을 측정할 aspect
//메서드 실행 로그
public class ProfileAspect {
	
	private Logger logger = LoggerFactory.getLogger(ProfileAspect.class);
	
	//메서드 실행 전 로그 작성
	public void  beforeMethod(JoinPoint point){
		String className = point.getTarget().getClass().getSimpleName();
		String methodName = point.getSignature().getName();			//메서드 이름
		logger.debug("beforeMethod className : {}, methodName : {}", className, methodName);
	}
	
	
	//메서드 실행 후 로그 작성
	public void  afterMethod(JoinPoint point){
		String className = point.getTarget().getClass().getSimpleName();
		String methodName = point.getSignature().getName();			//메서드 이름
		logger.debug("afterMethod className : {}, methodName : {}", className, methodName);
	}
	
	
	//메서드 실행 전후(around)
	public Object aroundMethod(ProceedingJoinPoint point) throws Throwable{
		String className = point.getTarget().getClass().getSimpleName();
		String methodName = point.getSignature().getName();			//메서드 이름
		
		//메서드 실행전
		long startTime = System.currentTimeMillis();
		
		//메서드 실행(실행에 필요한 메서드 인자, 리턴값)

		//메서드 인자 구하기
		Object[] args = point.getArgs();
		
		//메서드 실행하기(리턴값)
		Object ret = point.proceed(args);
		
		//메서드 실행후
		long endTime = System.currentTimeMillis();
		
		//메서드 profile
		logger.debug("aroundMethod profiling : {} ms. {}, {}", endTime - startTime, className, methodName);
		
		return ret;
	}
	
	
	
}
