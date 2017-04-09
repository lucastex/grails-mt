package grails.mt

import grails.gorm.MultiTenant

class Show implements MultiTenant<Show> {

    Long tenantId

    String city
    Double price
    Date when

    static constraints = {
    }
}
