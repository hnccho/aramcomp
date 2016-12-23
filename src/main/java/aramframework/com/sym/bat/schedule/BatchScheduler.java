package aramframework.com.sym.bat.schedule;

import java.util.Date;
import java.util.List;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.util.Assert;

import aramframework.com.sym.bat.domain.BatchSchdulVO;
import aramframework.com.sym.bat.service.BatchSchdulService;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;

/**
 * Quartz Scheduler를 실행하는 스케줄러 클래스를 정의한다.
 * 
 * @author 아람컴포넌트 조헌철
 * @since 2014.11.11
 * @version 1.0
 */
public class BatchScheduler implements BeanFactoryAware {

	private BeanFactory beanFactory;

	/** egovBatchSchdulService	 */
	private BatchSchdulService batchSchdulService;

	/** ID Generation */
	private EgovIdGnrService idgenService;

	private MethodInvokingJobDetailFactoryBean factory;

	/** Quartz 스케줄러 */
	private Scheduler sched;

	protected final Logger LOG = LoggerFactory.getLogger(this.getClass());

	// 실행 대상을 읽기위한 페이지 크기
	private static final int RECORD_COUNT_PER_PAGE = 10000;

	public void setBeanFactory(BeanFactory beanFactory) {
		this.beanFactory = beanFactory;
	}
	/**
	 * 배치스케줄러에 batchSchdul 파라미터를 이용하여 Job , Trigger를 Add 한다.
	 * 
	 * @param batchSchdul
	 *            배치스케줄러에 등록할 스케줄정보
	 * @exception Exception
	 *                Exception
	 */
	public void insertBatchSchdul(BatchSchdulVO batchSchdul) throws Exception {
		// Job 만들기
		JobDetail jobDetail = null;
		if(batchSchdul.getBatchProgrm() != null
			&& !"".equals(batchSchdul.getBatchProgrm())) {
			jobDetail = new JobDetail();
			jobDetail.setName(batchSchdul.getBatchSchdulId());
			jobDetail.setJobClass(BatchShellScriptJob.class);
	
			jobDetail.getJobDataMap().put("batchProgrm", batchSchdul.getBatchProgrm());
			jobDetail.getJobDataMap().put("paramtr", batchSchdul.getParamtr());

		} else if(batchSchdul.getBatchBean() != null
				&& !"".equals(batchSchdul.getBatchBean())) {
			Assert.state(this.beanFactory != null, "BeanFactory must be set when using 'targetBeanName'");

			try {
				jobDetail = (JobDetail) this.beanFactory.getBean(batchSchdul.getBatchBean());
			} catch (NoSuchBeanDefinitionException ex) {
				LOG.error(ex.getMessage());
				return;
			}
			
			jobDetail.setName(batchSchdul.getBatchSchdulId());

		} else if(batchSchdul.getBatchObject() != null
				&& !"".equals(batchSchdul.getBatchObject())) {
			factory.setName(batchSchdul.getBatchSchdulId());
			factory.setTargetBeanName(batchSchdul.getBatchObject());
			factory.setTargetMethod(batchSchdul.getBatchMethod());
			factory.setConcurrent(false);
			factory.afterPropertiesSet();
			
			jobDetail = (JobDetail) factory.getObject();

		} else {
			return;
		}
		
		// 데이터 전달
		jobDetail.getJobDataMap().put("batchOpertId", batchSchdul.getBatchOpertId());
		jobDetail.getJobDataMap().put("batchSchdulId", batchSchdul.getBatchSchdulId());
		jobDetail.addJobListener(BatchJobListener.class.getName());

		// Trigger 만들기
		// Trigger trigger = TriggerUtils.makeImmediateTrigger(target.getBatchSchdulId(), 1, 1000000);
		LOG.debug("배치스케줄을 등록합니다. 배치스케줄ID : " + batchSchdul.getBatchSchdulId());
		Trigger trigger = null;
		if( batchSchdul.getRepeatInterval() != 0L ) {
			trigger = new SimpleTrigger(batchSchdul.getBatchSchdulId()
					, new Date(System.currentTimeMillis() + batchSchdul.getStartDelay())
					, null, SimpleTrigger.REPEAT_INDEFINITELY, batchSchdul.getRepeatInterval());
		} else {
			trigger = new CronTrigger(batchSchdul.getBatchSchdulId(), null, batchSchdul.toCronExpression());
			LOG.debug(batchSchdul.getBatchSchdulId() + " - cronexpression : " + ((CronTrigger)trigger).getCronExpression());
		}	
		trigger.setJobName(jobDetail.getName());
		try {
			// 스케줄러에 추가하기
			sched.scheduleJob(jobDetail, trigger);
		} catch (SchedulerException e) {
			// SchedulerException 이 발생하면 로그를 출력하고 다음 배치작업으로 넘어간다.
			// 트리거의 실행시각이 현재 시각보다 이전이면 SchedulerException이 발생한다.
			LOG.error("스케줄러에 배치작업추가할때 에러가 발생했습니다. 배치스케줄ID : " + batchSchdul.getBatchSchdulId() + ", 배치작업ID : " + batchSchdul.getBatchOpertId());
			LOG.error("에러내용 : " + e.getMessage());
		}
	}

	/**
	 * 배치스케줄러에 batchSchdul 파라미터를 이용하여 Job , Trigger를 갱신 한다.
	 * 
	 * @param batchSchdul
	 *            배치스케줄러에 갱신할 스케줄정보
	 * @exception Exception
	 *                Exception
	 */
	public void updateBatchSchdul(BatchSchdulVO batchSchdul) throws Exception {
		// Job 만들기
		JobDetail jobDetail = null;
		
		if(batchSchdul.getBatchProgrm() != null
			&& !"".equals(batchSchdul.getBatchProgrm())) {
			jobDetail = new JobDetail();
			jobDetail.setName(batchSchdul.getBatchSchdulId());
			jobDetail.setJobClass(BatchShellScriptJob.class);
	
			jobDetail.getJobDataMap().put("batchProgrm", batchSchdul.getBatchProgrm());
			jobDetail.getJobDataMap().put("paramtr", batchSchdul.getParamtr());

		} else if(batchSchdul.getBatchBean() != null
				&& !"".equals(batchSchdul.getBatchBean())) {
			Assert.state(this.beanFactory != null, "BeanFactory must be set when using 'targetBeanName'");

			try {
				jobDetail = (JobDetail) this.beanFactory.getBean(batchSchdul.getBatchBean());
			} catch (NoSuchBeanDefinitionException ex) {
				LOG.error(ex.getMessage());
				return;
			}
			
			jobDetail.setName(batchSchdul.getBatchSchdulId());

		} else if(batchSchdul.getBatchObject() != null
				&& !"".equals(batchSchdul.getBatchObject())) {
			factory.setName(batchSchdul.getBatchSchdulId());
			factory.setTargetBeanName(batchSchdul.getBatchObject());
			factory.setTargetMethod(batchSchdul.getBatchMethod());
			factory.setConcurrent(false);
			factory.afterPropertiesSet();
			
			jobDetail = (JobDetail) factory.getObject();
			
		} else {
			return;
		}
		
		// 데이터 전달
		jobDetail.getJobDataMap().put("batchOpertId", batchSchdul.getBatchOpertId());
		jobDetail.getJobDataMap().put("batchSchdulId", batchSchdul.getBatchSchdulId());
		jobDetail.getJobDataMap().put("batchOpertNm", batchSchdul.getBatchOpertNm());

		jobDetail.removeJobListener(BatchJobListener.class.getName());
		jobDetail.addJobListener(BatchJobListener.class.getName());

		// Trigger 만들기
		// Trigger trigger = TriggerUtils.makeImmediateTrigger(target.getBatchSchdulId(), 1, 1000000);
		LOG.debug("배치스케줄을 등록합니다. 배치스케줄ID : " + batchSchdul.getBatchSchdulId());
		Trigger trigger = null;
		if( batchSchdul.getRepeatInterval() != 0L ) {
			trigger = new SimpleTrigger(batchSchdul.getBatchSchdulId()
					, new Date(System.currentTimeMillis() + batchSchdul.getStartDelay())
					, null, SimpleTrigger.REPEAT_INDEFINITELY, batchSchdul.getRepeatInterval());
		} else {
			trigger = new CronTrigger(batchSchdul.getBatchSchdulId(), null, batchSchdul.toCronExpression());
			LOG.debug(batchSchdul.getBatchSchdulId() + " - cronexpression : " + ((CronTrigger)trigger).getCronExpression());
		}	
		trigger.setJobName(jobDetail.getName());

		try {
			// 스케줄러에서 기존Job, Trigger 삭제하기
			sched.deleteJob(jobDetail.getName(), jobDetail.getGroup());
			// 스케줄러에 추가하기
			sched.scheduleJob(jobDetail, trigger);
		} catch (SchedulerException e) {
			// SchedulerException 이 발생하면 로그를 출력하고 다음 배치작업으로 넘어간다.
			// 트리거의 실행시각이 현재 시각보다 이전이면 SchedulerException이 발생한다.
			LOG.error("스케줄러에 배치작업갱신할때 에러가 발생했습니다. 배치스케줄ID : " + batchSchdul.getBatchSchdulId() + ", 배치작업ID : " + batchSchdul.getBatchOpertId());
			LOG.error("에러내용 : " + e.getMessage());
		}
	}

	/**
	 * 배치스케줄러에 batchSchdul 파라미터를 이용하여 Job , Trigger를 삭제한다.
	 * 
	 * @param batchSchdul
	 *            배치스케줄러에 삭제할 스케줄정보
	 * @exception Exception
	 *                Exception
	 */
	public void deleteBatchSchdul(BatchSchdulVO batchSchdul) throws Exception {

		try {
			// 스케줄러에서 기존Job, Trigger 삭제하기
			LOG.debug("배치스케줄을 삭제합니다. 배치스케줄ID : " + batchSchdul.getBatchSchdulId());
			sched.deleteJob(batchSchdul.getBatchSchdulId(), Scheduler.DEFAULT_GROUP);
		} catch (SchedulerException e) {
			// SchedulerException 이 발생하면 로그를 출력하고 다음 배치작업으로 넘어간다.
			// 트리거의 실행시각이 현재 시각보다 이전이면 SchedulerException이 발생한다.
			LOG.error("스케줄러에 배치작업을 삭제할때 에러가 발생했습니다. 배치스케줄ID : " + batchSchdul.getBatchSchdulId() + ", 배치작업ID : " + batchSchdul.getBatchOpertId());
			LOG.error("에러내용 : " + e.getMessage());
		}
	}

	/**
	 * 클래스 초기화메소드. 배치스케줄테이블을 읽어서 Quartz 스케줄러를 초기화한다.
	 * 
	 */
	public void init() throws Exception {
		// 모니터링 대상 정보 읽어들이기~~~
		List<BatchSchdulVO> targetList = null;
		BatchSchdulVO batchSchdulVO = new BatchSchdulVO();
		// 모니터링 대상 검색 조건 초기화
		batchSchdulVO.getSearchVO().setPageIndex(1);
		batchSchdulVO.getSearchVO().setFirstIndex(0);
		batchSchdulVO.getSearchVO().setRecordPerPage(RECORD_COUNT_PER_PAGE);
		targetList = batchSchdulService.selectBatchSchdulList(batchSchdulVO);
//		log.debug("조회조건 " + searchVO);
		if (LOG.isDebugEnabled()) {
			LOG.debug("Result 건수 : " + targetList.size());
		}

		// 스케줄러 생성하기
		SchedulerFactory schedFact = new org.quartz.impl.StdSchedulerFactory();
		sched = schedFact.getScheduler();

		// Set up the listener
		BatchJobListener listener = new BatchJobListener();
		listener.setBatchSchdulService(batchSchdulService);
		listener.setIdgenService(idgenService);
		// sched.addGlobalJobListener(listener);
		sched.addJobListener(listener);

		factory = new MethodInvokingJobDetailFactoryBean();
		factory.setBeanFactory(beanFactory);
	
		// 스케줄러에 Job, Trigger 등록하기
		BatchSchdulVO target = null;
		for (int i = 0; i < targetList.size(); i++) {
			target = (BatchSchdulVO) targetList.get(i);
			if (LOG.isDebugEnabled()) {
				LOG.debug("Data : " + target);
			}

			insertBatchSchdul(target);
		}

		sched.start();
	}

	/**
	 * 클래스 destroy메소드. Quartz 스케줄러를 shutdown한다.
	 * 
	 */
	public void destroy() throws Exception {
		LOG.debug("start batch shutdown!! ");
		sched.shutdown(true);
        do {
            try {
                Thread.sleep(500);
            } catch (Exception ignore) {
            }
        } while (!sched.isShutdown());
        LOG.debug("end batch shutdown!! ");
	}

	/**
	 * 배치스케줄 서비스 리턴
	 * 
	 * @return the egovBatchSchdulService
	 */
	public BatchSchdulService getBatchSchdulService() {
		return batchSchdulService;
	}
	/**
	 * 배치스케줄 서비스 저장.
	 * 
	 * @param egovBatchSchdulService
	 *            the egovBatchSchdulService to set
	 */
	public void setBatchSchdulService(BatchSchdulService egovBatchSchdulService) {
		this.batchSchdulService = egovBatchSchdulService;
	}

	/**
	 * 배치결과ID 생성서비스 리턴
	 * 
	 * @return the idgenService
	 */
	public EgovIdGnrService getIdgenService() {
		return idgenService;
	}
	/**
	 * 배치결과ID 생성서비스 저장.
	 * 
	 * @param idgenService
	 *            the idgenService to set
	 */
	public void setIdgenService(EgovIdGnrService idgenService) {
		this.idgenService = idgenService;
	}
}
