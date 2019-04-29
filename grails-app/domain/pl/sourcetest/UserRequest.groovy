package pl.sourcetest

class UserRequest {

    Long id
    Date requestAt
    RequestType requestType
    String usersInput
    RequestStatus requestStatus
    Date requestStartAt
    Date requestCompletedAt
    String requestResponse

    enum RequestType {
        ZIP_CODE,
        CORNERS
    }

    enum RequestStatus {
        SUCCESS,
        FAILED,
        IN_PROGRESS,
        QUEUED

    }


    static constraints = {

        requestAt  nullable: false
        requestType  nullable: false
        usersInput nullable: false
        requestStatus nullable: false
        requestStartAt nullable: true
        requestCompletedAt nullable: true
        requestResponse nullable: true
    }
}
