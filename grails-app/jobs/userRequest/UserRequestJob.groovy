package userRequest

import grails.plugins.quartz.QuartzJob
import groovy.time.TimeCategory
import org.quartz.JobExecutionContext
import pl.sourcetest.UserRequest
import pl.sourcetest.UserRequestService

class UserRequestJob implements QuartzJob {


    UserRequestService userRequestService

    static triggers = {
        simple name: 'UserRequestJob', startDelay: 3000, repeatInterval: 6000
    }

    def execute(JobExecutionContext context) {
        use(TimeCategory) {
            UserRequest.findAllByRequestStatus(UserRequest.RequestStatus.QUEUED).each {
                userRequestService.getCoordinates(it)
            }
        }
    }
}
