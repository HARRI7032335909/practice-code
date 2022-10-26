package com.practice.core.schedulers;
import org.apache.sling.commons.scheduler.ScheduleOptions;
import org.apache.sling.commons.scheduler.Scheduler;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.Designate;
import com.practice.core.survices.SlingSchedulerConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Component(immediate = true, service = CustomScheduler.class)
@Designate(ocd = SlingSchedulerConfiguration.class)
public class CustomScheduler implements Runnable{
	private static final Logger log = LoggerFactory.getLogger(CustomScheduler.class);
	private String customParameter;
	private int schedulerId;
	
	@Reference
	private Scheduler scheduler;
	
	@Activate
	protected void activate(SlingSchedulerConfiguration config) {
		
		/**
		 * Getting the scheduler id
		 */
		schedulerId = config.schdulerName().hashCode();
		
		/**
		 * Getting the custom parameter
		
		/**
		 * Again adding the scheduler
		 */
		addScheduler(config);
	}
	
	/**
	 * This method deactivates the scheduler and removes it
	 * @param config
	 */
	@Deactivate
	protected void deactivate(SlingSchedulerConfiguration config) {
		
		/**
		 * Removing the scheduler
		 */
		removeScheduler();
	}
	
	/**
	 * This method removes the scheduler
	 */
	private void removeScheduler() {
		
		log.info("Removing scheduler: {}", schedulerId);
		
		/**
		 * Unscheduling/removing the scheduler
		 */
		scheduler.unschedule(String.valueOf(schedulerId));
	}
	
	/**
	 * This method adds the scheduler
	 * 
	 * @param config
	 */
	private void addScheduler(SlingSchedulerConfiguration config) {
		
		/**
		 * Check if the scheduler is enabled
		 */
		if(config.enabled()) {
			
			/**
			 * Scheduler option takes the cron expression as a parameter and run accordingly
			 */
			ScheduleOptions scheduleOptions = scheduler.EXPR(config.cronExpression());
			
			/**
			 * Adding some parameters    
			 */
			scheduleOptions.name(config.schdulerName());
			scheduleOptions.canRunConcurrently(false);
			
			/**
			 * Scheduling the job
			 */
			scheduler.schedule(this, scheduleOptions);
			
			log.info("Scheduler added");
			
		} else {
			
			log.info("Scheduler is disabled");
			
		}
	}
	
	/**
	 * Overridden run method to execute Job
	 */
	@Override
	public void run() {

		log.info("Custom Scheduler is now running using the passed custom paratmeter, customParameter {}", customParameter);
		
	}

}
