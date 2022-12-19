package contracts

import org.springframework.cloud.contract.spec.Contract
Contract.make {
    description "add 2 numbers"
    request{
        method GET()
        url("/add") {
            queryParameters {
                parameter("value1", "1")
                parameter("value2", "3")
            }
        }
    }
    response {
        body("4")
        status 200
    }
}