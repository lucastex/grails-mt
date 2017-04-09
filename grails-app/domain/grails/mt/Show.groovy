package grails.mt

import grails.gorm.MultiTenant

class Show implements MultiTenant<Show> {

    String tenantId

    String city
    Double price
    Date when

    static constraints = {
        table 'show_event'
        when column: 'event_date'
    }
}
