package pl.sourcetest

class UserRequestController {


    def userRequestService

    def index() {
        ['requestList':userRequestService.orderedList('requestAt')]
    }

    def requestByZipCode() {

        //TODO params need validation

        userRequestService.save(params.zipcode, UserRequest.RequestType.ZIP_CODE)

        redirect  ( action:'index' )
    }

    def requestBySector() {

        //TODO params need validation
        userRequestService.save(params.sector, UserRequest.RequestType.CORNERS)
        redirect  ( action:'index' )
    }

    def show(Long id) {
        respond userRequestService.get(id)
    }
}
