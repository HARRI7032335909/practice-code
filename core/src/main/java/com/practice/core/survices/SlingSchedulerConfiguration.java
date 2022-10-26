package com.practice.core.survices;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
@ObjectClassDefinition(name="HarikrishnaSchedularConfiguration", description ="harikrishna schedular configuration")
public @interface SlingSchedulerConfiguration{
@AttributeDefinition(name="harikrishna name", description ="Name of the Schedular",type =AttributeType.STRING)
public String schdulerName()default "custom sling schedular configuration";
@AttributeDefinition(name="Enabled", description = "True,if schedular service is enabled",type=AttributeType.BOOLEAN)
public boolean enabled()default false;
@AttributeDefinition(name="Cron Expression",description="Cron Expression used by the schedular",type=AttributeType.STRING)
public String cronExpression ()default "30 * * * * ?"; 

@AttributeDefinition(name="custom parameter", description="customerparameter to displayed by the schedular",type=AttributeType.STRING)
public String customParameter()default "AEM Scheduler Demo";
}


	
//}
////@ObjectClassDefinition(name = "HarikrishnaSchedulerConfiguration", description = "harikrishna scheduler configuration")
////public @interface SlingSchedulerConfiguration {
////
////	@AttributeDefinition(name = "Scheduler name", description = "Name of the scheduler", type = AttributeType.STRING)
////	public String schdulerName() default "Custom Sling Scheduler Configuration";
////
////	@AttributeDefinition(name = "Enabled", description = "True, if scheduler service is enabled", type = AttributeType.BOOLEAN)
////	public boolean enabled() default false;
////
////	@AttributeDefinition(name = "Cron Expression", description = "Cron expression used by the scheduler", type = AttributeType.STRING)
////	public String cronExpression() default "30 * * * * ?";
////
////	@AttributeDefinition(name = "Custom Parameter", description = "Custom parameter to be displayed by the scheduler", type = AttributeType.STRING)
////	public String customParameter() default "AEM Scheduler Demo";
//}