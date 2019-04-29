package pl.sourcetest

import grails.gorm.transactions.Transactional
import wslite.soap.SOAPFaultException

@Transactional
class UserRequestService {

    def requestClientService


    def get(id) {
        UserRequest.get(id)
    }

    def orderedList(byField) {
        UserRequest.list(sort: byField, order: 'desc')
    }


    def save(usersInput, UserRequest.RequestType requestType) {
        new UserRequest(
                requestAt: new Date(),
                requestType: requestType,
                usersInput: usersInput,
                requestStatus: UserRequest.RequestStatus.QUEUED
        ).save(flush: true, failOnError: true)

    }

    def getCoordinates(UserRequest userRequest) {
        try {
            userRequest.requestStatus = UserRequest.RequestStatus.IN_PROGRESS
            userRequest.requestStartAt = new Date()
            userRequest.save(flush: true)
            switch (userRequest.requestType) {
                case UserRequest.RequestType.ZIP_CODE:
                    userRequest.requestResponse = requestClientService.getCoordinatesByZipCode(userRequest.usersInput)
                    break
                case UserRequest.RequestType.CORNERS:
                    userRequest.requestResponse = requestClientService.getCoordinatesBySectorCode(userRequest.usersInput)
                    break
                default:
                    throw new IllegalArgumentException("request status not supported ")
            }
            userRequest.requestStatus = UserRequest.RequestStatus.SUCCESS
        } catch (SOAPFaultException ex) {
            userRequest.requestStatus = UserRequest.RequestStatus.FAILED

        }
        userRequest.requestCompletedAt = new Date()
        userRequest.save(flush: true)
    }

}
